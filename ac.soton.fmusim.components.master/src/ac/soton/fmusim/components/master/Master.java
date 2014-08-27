/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.master;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import ac.soton.fmusim.components.AbstractVariable;
import ac.soton.fmusim.components.Component;
import ac.soton.fmusim.components.ComponentDiagram;
import ac.soton.fmusim.components.Connector;
import ac.soton.fmusim.components.DisplayComponent;
import ac.soton.fmusim.components.Port;
import ac.soton.fmusim.components.exceptions.ModelException;
import ac.soton.fmusim.components.exceptions.SimulationException;

/**
 * Master algorithm for FMU-EventB co-simulation.
 * 
 * @author vitaly
 *
 */
public class Master {

	/**
	 * 
	 */
	private static final String PLUGIN_ID = "ac.soton.fmusim.components.master";
	// simulation parameter names
	public static final String OUTPUT_SEPARATOR = ",";
	public static final String PARAMETER_START_TIME = "parameter.startTime";
	public static final String PARAMETER_STOP_TIME = "parameter.stopTime";
	public static final String PARAMETER_STEP_SIZE = "parameter.stepSize";
	public static final String PARAMETER_OUTPUT_FILE = "parameter.outputFile";

	// parameters
	private static ComponentDiagram diagram;
	private static long tCurrent;
	private static long tStart;
	private static long tStop;
	private static long step;
	
	// two-list
	private static Map<Component, Long> updateList = new HashMap<Component, Long>();
	private static List<Component> evaluationList = new ArrayList<Component>();
	
	private static File resultFile;
	private static BufferedWriter resultWriter;

	/**
	 * Simulate a diagram.
	 * @param cd
	 * @param monitor 
	 * @param params 
	 * @return 
	 */
	public static IStatus simulate(ComponentDiagram cd, IProgressMonitor monitor, Map<String, String> params) {
		diagram = cd;
		tStart = Long.parseLong(params.get(PARAMETER_START_TIME));
		tStop = Long.parseLong(params.get(PARAMETER_STOP_TIME));
		step = Long.parseLong(params.get(PARAMETER_STEP_SIZE));
		resultFile = new File(params.get(PARAMETER_OUTPUT_FILE));
		updateList.clear();
		evaluationList.clear();
		long cStep;
		IStatus status = Status.OK_STATUS;
		long simulationTime = System.currentTimeMillis();
		
		setNotification(false);
		
		// instantiate components
		try {
			for (Component c : diagram.getComponents())
				c.instantiate();
		} catch (SimulationException e) {
			return new Status(IStatus.ERROR, PLUGIN_ID, "Failed to instantiate", e);
		}
		
		// create output file
		resultWriter = apiCreateOutput((File) resultFile);
		if (resultWriter == null) {
			return new Status(IStatus.ERROR, PLUGIN_ID, "Failed to create an output file.");
		}
		
		// initialisation step
		for (Component c : diagram.getComponents()) {
			c.initialise(tStart, tStop);
			// time-zero initialisation
			updateList.put(c, tStart);
		}
		
		// header output
		apiOutputColumns(diagram, resultWriter);

		// simulation loop
		for (tCurrent = tStart; tCurrent <= tStop; ++tCurrent) {
			if (monitor.isCanceled()) {
				status = Status.CANCEL_STATUS;
				break;
			}
			
			// read update list for evaluation-ready components
			for (Component c : diagram.getComponents()) {
				if (tCurrent == updateList.get(c))
					evaluationList.add(c);
			}
			
			if (evaluationList.isEmpty())
				continue;
			
			// only simulate components in evaluation list
			// read port values
			for (Component c : evaluationList)
				try {
					c.writeOutputs();
				} catch (SimulationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ModelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			// write port values
			for (Component c : evaluationList)
				try {
					c.readInputs();
				} catch (SimulationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ModelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			// do step & update the update list
			for (Component c : evaluationList)
				try {
					cStep = c.getStepPeriod() == 0 ? step : c.getStepPeriod();
					if (tCurrent + cStep <= tStop) {
						c.doStep(tCurrent, cStep);
						updateList.put(c, updateList.get(c) + cStep);
					}
				} catch (SimulationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ModelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			// clear evaluation list
			evaluationList.clear();
			
			// write output
			apiOutput(diagram, tCurrent, resultWriter);
		}

		// termination step
		for (Component c : diagram.getComponents())
			c.terminate();
		
		setNotification(true);
		
		// close file
		try {
			resultWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (status.getSeverity() == Status.OK)
			status = new Status(IStatus.OK, PLUGIN_ID, "Completed in " + (System.currentTimeMillis() - simulationTime) + "ms");
		
		return status;
	}

	/**
	 * 
	 */
	private static void setNotification(boolean flag) {
		for (Component c : diagram.getComponents()) {
			c.eSetDeliver(flag);
			for (AbstractVariable v : c.getVariables())
				v.eSetDeliver(flag);
			for (Port p : c.getInputs())
				p.eSetDeliver(flag);
			for (Port p : c.getOutputs())
				p.eSetDeliver(flag);
		}
		for (Connector c : diagram.getConnectors())
			c.eSetDeliver(flag);
	}

	private static void apiOutputColumns(ComponentDiagram diagram, BufferedWriter writer) {
		try {
			writer.write("time");
			for (Component c : diagram.getComponents()) {
				//XXX: current hack to ignore display component for outputs
				if (c instanceof DisplayComponent)
					continue;
				
				String name = c.getName();
				for (AbstractVariable v : c.getVariables())
					writer.write(OUTPUT_SEPARATOR + name + "." + v.getName());
				for (Port p : c.getOutputs())
					writer.write(OUTPUT_SEPARATOR + name + "." + p.getName());
			}
			writer.write('\n');
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void apiOutput(ComponentDiagram diagram, long time, BufferedWriter writer) {
		try {
			writer.write(Long.toString(time));
			for (Component c : diagram.getComponents()) {
				//XXX: current hack to ignore display component for outputs
				if (c instanceof DisplayComponent)
					continue;
				
				for (AbstractVariable v : c.getVariables()) {
					writer.write(OUTPUT_SEPARATOR + toPlotValue(v.getValue().toString()));
				}
				for (Port p : c.getOutputs()) {
					writer.write(OUTPUT_SEPARATOR + toPlotValue(p.getValue().toString()));
				}
			}
			writer.write('\n');
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String toPlotValue(String value) {
		assert value != null;
		if ("false".equals(value.toLowerCase()))
			return "0";
		if ("true".equals(value.toLowerCase()))
			return "1";
		return value;
	}

	private static BufferedWriter apiCreateOutput(File file) {
		try {
			if (!file.exists())
				file.createNewFile();
			return new BufferedWriter(new FileWriter((File) file));
		} catch (IOException e) {
			e.printStackTrace();
			//TODO: log output file error
			return null;
		}
	}

}
