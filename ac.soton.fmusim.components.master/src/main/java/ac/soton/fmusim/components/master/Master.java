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
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eventb.core.IEventBRoot;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import org.rodinp.core.IRodinFile;
import org.rodinp.core.RodinCore;

import ac.soton.fmusim.components.AbstractVariable;
import ac.soton.fmusim.components.Component;
import ac.soton.fmusim.components.ComponentDiagram;
import ac.soton.fmusim.components.Connector;
import ac.soton.fmusim.components.EventBComponent;
import ac.soton.fmusim.components.FMUComponent;
import ac.soton.fmusim.components.Port;
import ac.soton.fmusim.components.VariableType;

import com.google.inject.Injector;

import de.be4.classicalb.core.parser.exceptions.BException;
import de.prob.animator.command.LoadEventBCommand;
import de.prob.animator.command.StartAnimationCommand;
import de.prob.cosimulation.FMU;
import de.prob.model.eventb.EventBModel;
import de.prob.rodin.translate.EventBTranslator;
import de.prob.scripting.EventBFactory;
import de.prob.statespace.OpInfo;
import de.prob.statespace.StateSpace;
import de.prob.statespace.Trace;
import de.prob.ui.eventb.internal.TranslatorFactory;
import de.prob.webconsole.ServletContextListener;

/**
 * Master algorithm for FMU-EventB co-simulation
 * from component diagrams.
 * 
 * @author vitaly
 *
 */
public class Master {

	private static final String SEPARATOR = ",";

	/**
	 * Master exception thrown if simulation goes wrong.
	 * 
	 * @author vitaly
	 *
	 */
	@SuppressWarnings("serial")
	public class MasterException extends Exception {
		public MasterException(String string) {
			super(string);
		}
	}

	private ComponentDiagram diagram;
	private double tCurrent;
	private double tStart;
	private double tStop;
	private double step;
	private int precision;
	private File resultFile;
	private BufferedWriter resultOut;
	private boolean simulating;

	/**
	 * Constructs master simulation instance
	 * that can be used to drive the simulation.
	 * 
	 * @param diagram component diagram that defines component composition graph
	 * @param tStart simulation start time
	 * @param tStop simulation stop time
	 * @param step simulation step size
	 * @param precision precision of the conversion from Event-B integer to FMU real type and back
	 * @param resultFile simulation results output file
	 */
	public Master(ComponentDiagram diagram, double tStart, double tStop, double step, int precision, File resultFile) {
		this.diagram = diagram;
		this.tStart = tStart;
		this.tStop = tStop;
		this.step = step;
		this.precision = precision;
		this.resultFile = resultFile;
	}
	
	public boolean isSimulating() {
		return simulating;
	}
	
	public void simulateStep() {
		if (!simulating) {
			// instantiate components
			try {
				for (Component c : diagram.getComponents())
					apiInstantiate(c);
			} catch (MasterException e) {
				e.printStackTrace();
				// TODO: terminate instantiated fmus
				return;
			}
	
			// create output file
			resultOut = apiCreateOutput((File) resultFile);
			if (resultOut != null) {
				apiOutputColumns(diagram, resultOut);
				apiOutput(diagram, tStart, resultOut);
			}
	
			// initialisation step
			for (Component c : diagram.getComponents())
				apiInitialise(c, tStart, tStop);
	
			// set simulation time
			tCurrent = tStart;
			
			// marks simulation has started
			simulating = true;
		}
		
		// simulation step
		if (simulating) {
			if (tCurrent < tStop) {
				
				// read port values
				for (Component c : diagram.getComponents())
					apiReadPorts(c);
				
				// write port values
				for (Component c : diagram.getComponents())
					apiWritePorts(c);
				
				// do step
				for (Component c : diagram.getComponents())
					apiDoStep(c, tCurrent, step);
				
				// progress the time
				tCurrent += step;
				
				// write output
				apiOutput(diagram, tCurrent, resultOut);
			}
			
			// termination step, if finished
			if (tCurrent >= tStop) {
				simulating = false;
				
				for (Component c : diagram.getComponents())
					apiTerminate(c);
				
				// close file
				try {
					resultOut.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Runs the simulation to completion.
	 */
	public void simulateAll() {
		// instantiate components
		try {
			for (Component c : diagram.getComponents())
				apiInstantiate(c);
		} catch (MasterException e) {
			e.printStackTrace();
			//TODO: terminate instantiated fmus
			return;
		}
		
		// create output file
		resultOut = apiCreateOutput((File) resultFile);
		if (resultOut != null) {
			apiOutputColumns(diagram, resultOut);
			apiOutput(diagram, tStart, resultOut);
		}
		
		// initialisation step
		for (Component c : diagram.getComponents())
			apiInitialise(c, tStart, tStop);
		
		// set simulation time
		tCurrent = tStart;

		// simulation loop
		while (tCurrent < tStop) {
			
			// read port values
			for (Component c : diagram.getComponents())
				apiReadPorts(c);
			
			// write port values
			for (Component c : diagram.getComponents())
				apiWritePorts(c);
			
			// do step
			for (Component c : diagram.getComponents())
				apiDoStep(c, tCurrent, step);
			
			// progress the time
			tCurrent += step;
			
			// write output
			apiOutput(diagram, tCurrent, resultOut);
		}

		// termination step
		for (Component c : diagram.getComponents())
			apiTerminate(c);
		
		// close file
		try {
			resultOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void apiOutputColumns(ComponentDiagram diagram, BufferedWriter writer) {
		try {
			writer.write("time");
			for (Component c : diagram.getComponents()) {
				String name = c.getName();
//				for (Port p : c.getInputs())
//					writer.write(SEPARATOR + name + "." + p.getName());
				for (AbstractVariable v : c.getVariables())
					writer.write(SEPARATOR + name + "." + v.getName());
//				for (Port p : c.getOutputs())
//					writer.write(SEPARATOR + name + "." + p.getName());
			}
			writer.write('\n');
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void apiOutput(ComponentDiagram diagram, double time, BufferedWriter writer) {
		try {
			writer.write(Double.toString(time));
			for (Component c : diagram.getComponents()) {
//				for (Port p : c.getInputs())
//					writer.write(SEPARATOR + p.getValue());
				for (AbstractVariable v : c.getVariables()) {
					//XXX: replace with elegant converion to int
					Object value = v.getValue();
					if ("TRUE".equals(value.toString()))
						value = 1;
					else if ("FALSE".equals(value.toString()))
						value = 0;
					
					writer.write(SEPARATOR + value);
				}
//				for (Port p : c.getOutputs())
//					writer.write(SEPARATOR + p.getValue());
			}
			writer.write('\n');
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private BufferedWriter apiCreateOutput(File file) {
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

	private void apiInstantiate(Component component) throws MasterException {
		if (component instanceof FMUComponent)
			apiInstantiateFMU((FMUComponent) component);
		else if (component instanceof EventBComponent)
			apiInstantiateEventB((EventBComponent) component);
	}

	/**
	 * Instantiates an FMU component.
	 * Essentially, loads an FMU file attached to this component.
	 * 
	 * @param component
	 * @throws MasterException if loading an FMU file failed
	 */
	private void apiInstantiateFMU(FMUComponent component) throws MasterException {
		try {
			FMU fmu = component.getFmu();
//			if (fmu == null)
				fmu = new FMU(component.getPath());
			component.setFmu(fmu);
		} catch (IOException e) {
			throw new MasterException("Failed to load FMU: "+ component.getPath() + '\n' + e.getMessage());
		}
	}

	/**
	 * Instantiates a machine component,
	 * i.e. loads a machine file as a ProB animation trace.
	 * 
	 * @param component
	 * @throws MasterException 
	 */
	private void apiInstantiateEventB(EventBComponent component) throws MasterException {
		final IEventBRoot machineRoot = getMachineRoot(component.getMachine());
		if (machineRoot == null)
			throw new MasterException("Cannot load machine component '" + component.getName()
					+ "'. Machine root cannot be determined.");
		
		EventBTranslator eventBTranslator = new EventBTranslator(machineRoot);

		Injector injector = ServletContextListener.INJECTOR;

		final EventBFactory instance = injector
				.getInstance(EventBFactory.class);

		EventBModel model = instance.load(eventBTranslator.getMainComponent(),
				eventBTranslator.getMachines(), eventBTranslator.getContexts(),
				eventBTranslator.getModelFile());

		StringWriter writer = new StringWriter();
		PrintWriter pto = new PrintWriter(writer);
		try {
			TranslatorFactory.translate(machineRoot, pto);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		StateSpace s = model.getStatespace();
		
		Pattern p2 = Pattern.compile("^package\\((.*?)\\)\\.");
		Matcher m2 = p2.matcher(writer.toString());
		m2.find();
		String cmd = m2.group(1);

		s.execute(new LoadEventBCommand(cmd));
		s.execute(new StartAnimationCommand());

		Trace t = new Trace(s);
		component.setTrace(t);
	}

	/**
	 * Initialises a component.
	 * 
	 * @param component
	 * @param tStart
	 * @param tStop
	 */
	private void apiInitialise(Component component, double tStart, double tStop) {
		if (component instanceof FMUComponent)
			apiInitialiseFMU((FMUComponent) component, tStart, tStop);
		else if (component instanceof EventBComponent)
			apiInitialiseEventB((EventBComponent) component);
	}

	/**
	 * Initialises FMU component.
	 * 
	 * @param component
	 * @param tStart start time
	 * @param tStop stop time
	 */
	private void apiInitialiseFMU(FMUComponent component, double tStart, double tStop) {
		FMU fmu = (FMU) component.getFmu();
		fmu.initialize(tStart, tStop);
		
		// update variables
		for (AbstractVariable v : component.getVariables())
			v.setValue(getValueFMU(fmu, v));
	}

	/**
	 * Initialises Event-B component.
	 * Executes first two events: setup constants and initialisation.
	 * 
	 * @param component
	 */
	private void apiInitialiseEventB(EventBComponent component) {
		Trace trace = component.getTrace();
		assert trace != null;
		trace = trace.anyEvent(null).anyEvent(null);
		
		// update variables
		for (AbstractVariable v : component.getVariables())
			v.setValue(trace.getCurrentState().value(v.getName()));
		
		// update trace
		component.setTrace(trace);
	}
	
	/**
	 * Returns Event-B Root element of a machine.
	 * @param machine
	 * @return
	 */
	private IEventBRoot getMachineRoot(Machine machine) {
		Resource resource = machine.eResource();
		if (resource != null) {
			URI uri = resource.getURI();
			if (uri.isPlatformResource()) {
				IFile file = WorkspaceSynchronizer.getFile(resource);
				IRodinFile rodinFile = RodinCore.valueOf(file);
				if (rodinFile != null) {
					return (IEventBRoot) rodinFile.getRoot();
				}
			}
			//TODO: root for a non-workspace resource?
		}
		return null;
	}

	/**
	 * Runs a simulation step of a component.
	 * 
	 * @param component
	 * @param time current time
	 * @param step step size
	 */
	private void apiDoStep(Component component, double time, double step) {
		if (component instanceof FMUComponent)
			apiDoStepFMU((FMUComponent) component, time, step);
		else if (component instanceof EventBComponent)
			apiDoStepEventB((EventBComponent) component, time, step);
	}
	
	/**
	 * Runs a simulation step of FMU component.
	 * 
	 * @param component
	 * @param time current time
	 * @param step step size
	 */
	private void apiDoStepFMU(FMUComponent component, double time, double step) {
		FMU fmu = (FMU) component.getFmu();
		fmu.doStep(time, step);
		for (AbstractVariable v : component.getVariables())
			v.setValue(getValueFMU(fmu, v));
	}
	
	/**
	 * Runs a simulation step of Event-B component.
	 * Executes non-deterministically a number of events until an update event is enabled,
	 * then execute update and returns.
	 * 
	 * @param component
	 * @param time - not used at the moment
	 * @param step - not used at the moment
	 */
	private void apiDoStepEventB(EventBComponent component, double time, double step) {
		Trace trace = component.getTrace();
		assert trace != null;
		Event updateEvent = component.getUpdateEvent();
		assert updateEvent != null;
		
		String updateEventName = updateEvent.getName();
		boolean update = false;
		while (!update) {
			
			// find and execute update event
			for (OpInfo op : trace.getNextTransitions()) {
				if (op.name.equals(updateEventName)) {
					trace = trace.add(op.id);
					update = true;
					break;
				}
			}
			
			// if not found, execute any event
			if (!update)
				trace = trace.anyEvent(null);
		}
		
		// update variables
		for (AbstractVariable v : component.getVariables())
			v.setValue(trace.getCurrentState().value(v.getName()));
		
		// update trace
		component.setTrace(trace);
	}

	/**
	 * Reads values from output ports of a component.
	 * 
	 * @param component
	 */
	private void apiReadPorts(Component component) {
		if (component instanceof FMUComponent)
			apiReadPortsFMU((FMUComponent) component);
		else if (component instanceof EventBComponent)
			apiReadPortsEventB((EventBComponent) component);
	}
	
	/**
	 * Reads values from output ports of an FMU component.
	 * 
	 * @param component
	 */
	private void apiReadPortsFMU(FMUComponent component) {
		FMU fmu = (FMU) component.getFmu();
		for (Port port : component.getOutputs()) {
			Object value = getValueFMU(fmu, port);
			Connector connector = port.getConnector();
			if (connector != null)
				connector.setValue(value);
			port.setValue(value);
		}
	}

	/**
	 * Returns FMU variable's value.
	 * 
	 * @param fmu
	 * @param variable
	 * @return
	 */
	private Object getValueFMU(FMU fmu, AbstractVariable variable) {
		String name = variable.getName();
		Object value = null;
		switch (variable.getType()) {
		case BOOLEAN:
			value  = fmu.getBoolean(name);
			break;
		case INTEGER:
			value = fmu.getInt(name);
			break;
		case REAL:
			value = fmu.getDouble(name);
			break;
		case STRING:
			value = fmu.getString(name);
			break;
		}
		return value;
	}

	/**
	 * Reads values from output ports of an Event-B component.
	 * 
	 * @param component
	 */
	private void apiReadPortsEventB(EventBComponent component) {
		Trace trace = component.getTrace();
		assert trace != null;
		
		// if write outputs event specified and enabled, execute it
		if (component.getWriteOutputsEvent() != null) {
			try {
				OpInfo op = findEnabled(trace, component.getWriteOutputsEvent().getName());
				if (op != null)
					trace = trace.add(op.name, "TRUE=TRUE");
			} catch (BException e) {
				//FIXME: no graceful fail recovery
				e.printStackTrace();
				return;
				//XXX: what to do if event is specified, but not enabled?
			}
		}
		
		// read values from Event-B to connectors
		for (Port port : component.getOutputs()) {
			Connector connector = port.getConnector();
			if (connector == null)
				continue;
			Object value = getValueEventB(trace, port, precision);
			connector.setValue(value);
//			port.setValue(value);
		}

		// update trace
		component.setTrace(trace);
	}

	/**
	 * Returns variable value from Event-B.
	 * 
	 * @param trace
	 * @param variable
	 * @param precision Event-B variable (int) to double conversion precision
	 * @return
	 */
	private Object getValueEventB(Trace trace, AbstractVariable variable, int precision) {
		String name = variable.getName();
		Object value = null;
		switch (variable.getType()) {
		case BOOLEAN:
			value = getBooleanFromEventB(trace, name);
			break;
		case INTEGER:
			value = getIntegerFromEventB(trace, name);
			break;
		case REAL:
			value = getDoubleFromEventB(trace, name, precision);
			break;
		case STRING:
			value = getStringFromEventB(trace, name);
			break;
		}
		return value;
	}

	/**
	 * Returns enabled event by name.
	 * 
	 * @param trace
	 * @param eventName
	 * @return
	 */
	private OpInfo findEnabled(Trace trace, String eventName) {
		for (OpInfo op : trace.getNextTransitions()) {
			if (op.name.equals(eventName)) {
				return op;
			}
		}
		return null;
	}

	/**
	 * Writes values to input ports of a component.
	 * 
	 * @param component
	 */
	private void apiWritePorts(Component component) {
		if (component instanceof FMUComponent)
			apiWritePortsFMU((FMUComponent) component);
		else if (component instanceof EventBComponent)
			apiWritePortsEventB((EventBComponent) component);
	}

	/**
	 * Writes values to inputs of an FMU component.
	 * 
	 * @param component
	 */
	private void apiWritePortsFMU(FMUComponent component) {
		FMU fmu = (FMU) component.getFmu();
		for (Port port : component.getInputs()) {
			Connector connector = port.getConnector();
			if (connector == null)
				continue;
			Object value = connector.getValue();
			setValueFMU(fmu, port, value);
			port.setValue(value);
		}
	}

	/**
	 * Sets value to FMU variable.
	 * 
	 * @param fmu
	 * @param port
	 * @param value
	 * @return
	 */
	private void setValueFMU(FMU fmu, AbstractVariable variable, Object value) {
		String name = variable.getName();
		switch (variable.getType()) {
		case BOOLEAN:
			fmu.set(name, (Boolean) value);
			break;
		case INTEGER:
			fmu.set(name, (Integer) value);
			break;
		case REAL:
			fmu.set(name, (Double) value);
			break;
		case STRING:
			fmu.set(name, (String) value);
			break;
		}
	}
	
	/**
	 * Writes values to input ports of an Event-B component.
	 * 
	 * @param component
	 */
	private void apiWritePortsEventB(EventBComponent component) {
		// if no read inputs event specified, skip
		if (component.getReadInputsEvent() == null)
			return;

		Trace trace = component.getTrace();
		assert trace != null;
		
		// if read inputs event not enabled, also skip
		//XXX: is it an invalid state if not enabled?
		String eventName = component.getReadInputsEvent().getName();
		OpInfo op = findEnabled(trace, eventName);
		if (op == null)
			return;
		
		// build parameter predicate for event execution
		// including only parameter values for the ports
		// that are connected to a feeding connector
		StringBuilder params = new StringBuilder("TRUE=TRUE");
		for (Port port : component.getInputs()) {
			Connector connector = port.getConnector();
			if (connector == null)
				continue;

			String name = port.getName();
			Object value = connector.getValue();
			String bValue = null;
			switch (port.getType()) {
			case BOOLEAN:
				bValue = getBooleanToEventB((Boolean) value);
				break;
			case INTEGER:
				bValue = getIntegerToEventB((Integer) value);
				break;
			case REAL:
				bValue = getDoubleToEventB((Double) value, precision);
				break;
			case STRING:
				bValue = getStringToEventB((String) value);
				break;
			}
//			port.setValue(value);
			
			// add param to params string
			params.append("&" + name + "=" + bValue);
		}
		
		// execute 'read inputs' event with calculated parameters
		try {
//			if (trace.getNextTransitions().iterator().hasNext()) {
//				op = trace.getNextTransitions().iterator().next();
//			}
		 OpInfo opp = trace.findOneOp(op.name, params.toString());
			trace = trace.add(opp.id);
//			for (Port port : component.getInputs()) {
//				port.setValue(trace.getCurrentState().value(port.getName()));
//			}
		} catch (BException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// update trace
		component.setTrace(trace);
	}
	
	
	/**
	 * Terminates component simulation.
	 * 
	 * @param component
	 */
	private void apiTerminate(Component component) {
		if (component instanceof FMUComponent)
			apiTerminateFMU((FMUComponent) component);
		else if (component instanceof EventBComponent)
			apiTerminateEventB((EventBComponent) component);
	}

	/**
	 * Terminates FMU component simulation.
	 * 
	 * @param component
	 */
	private void apiTerminateFMU(FMUComponent component) {
		FMU fmu = (FMU) component.getFmu();
		if (fmu != null) {
			fmu.terminate();
			component.setFmu(null);
		}
	}

	/**
	 * Terminates Event-B component simulation.
	 * 
	 * @param component
	 */
	private void apiTerminateEventB(EventBComponent component) {
		// TODO Auto-generated method stub
		
	}
	
	private String getBooleanToEventB(Boolean value) {
		return value.toString().toUpperCase();
	}

	private String getIntegerToEventB(Integer value) {
		return value.toString();
	}

	private String getDoubleToEventB(Double value, int precision) {
		double toB = value.doubleValue() * Math.pow(10, precision);
		return Integer.toString((int) toB);
	}

	private String getStringToEventB(String value) {
		return value;
	}

	/**
	 * Returns a boolean value from Event-B animation trace.
	 * 
	 * @param trace current animation trace
	 * @param name variable name
	 * @return
	 */
	private Boolean getBooleanFromEventB(Trace trace, String name) {
		String value = (String) trace.getCurrentState().value(name);
		return Boolean.valueOf(value);
	}

	/**
	 * Returns an integer value from Event-B animation trace.
	 * 
	 * @param trace current animation trace
	 * @param name variable name
	 * @return
	 */
	private Integer getIntegerFromEventB(Trace trace, String name) {
		String value = (String) trace.getCurrentState().value(name);
		return Integer.valueOf(value);
	}
	
	/**
	 * Returns a double value from Event-B animation trace.
	 * As doubles are not yet supported by Event-B,
	 * they are modelled as integers, converted from a double
	 * with a specified precision: double = int / (10 ^ precision)
	 * 
	 * @param trace current animation trace
	 * @param name variable name
	 * @param precision int to double conversion precision
	 * @return
	 */
	private Double getDoubleFromEventB(Trace trace, String name, int precision) {
		Integer integer = getIntegerFromEventB(trace, name);
		return integer.doubleValue() / Math.pow(10d, precision);
	}

	/**
	 * Returns a string value from Event-B animation trace.
	 * 
	 * @param trace current animation trace
	 * @param name variable name
	 * @return
	 */
	private String getStringFromEventB(Trace trace, String name) {
		String value = (String) trace.getCurrentState().value(name);
		return value;
	}

}
