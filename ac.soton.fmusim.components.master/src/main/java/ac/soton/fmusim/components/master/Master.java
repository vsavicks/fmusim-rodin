/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.master;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;

import de.prob.cosimulation.FMU;
import de.prob.statespace.OpInfo;
import de.prob.statespace.Trace;
import de.prob.webconsole.GroovyExecution;
import de.prob.webconsole.ServletContextListener;

import ac.soton.fmusim.components.Component;
import ac.soton.fmusim.components.ComponentDiagram;
import ac.soton.fmusim.components.Connector;
import ac.soton.fmusim.components.EventBComponent;
import ac.soton.fmusim.components.FMUComponent;
import ac.soton.fmusim.components.Port;

/**
 * Master algorithm for FMU-EventB co-simulation
 * from component diagrams.
 * 
 * @author vitaly
 *
 */
public class Master {

	private static final int DOUBLE_PRECISION = 3;
	private static GroovyExecution groovy;
	private static Map<EventBComponent, Trace> traces;

	/**
	 * Constructor.
	 * Creates a Groovy executor.
	 */
	public Master() {
		initGroovy();
		initMappings();
	}
	
	/**
	 * Initialises Groovy for script execution.
	 */
	private void initGroovy() {
		if (groovy == null) {
			groovy = ServletContextListener.INJECTOR.getInstance(GroovyExecution.class); 
			groovy.runScript(readScript("eventb_load.groovy"));
		}
	}

	/**
	 * Initialises mappings.
	 */
	private void initMappings() {
		if (traces == null)
			traces = new HashMap<EventBComponent, Trace>();
	}

	/**
	 * Reads a Groovy script into a string.
	 * 
	 * @param scriptName
	 * @return
	 */
	private String readScript(String scriptName) {
		try {
			String path = getScriptPath(scriptName);
			URL url = new URL(path);
			InputStream inputStream = url.openConnection().getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			Scanner scanner = new Scanner(in);
			String script = scanner.useDelimiter("\\Z").next();
			scanner.close();
			return script;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Returns full path to a script.
	 * 
	 * @param scriptName
	 * @return
	 */
	private String getScriptPath(String scriptName) {
		//TODO: find actual script
		return "platform:/plugin/ac.soton.fmusim.components.master/src/main/groovy/ac/soton/fmusim/components/master/" + scriptName;
	}

	/**
	 * Simulates a component diagram.
	 * 
	 * @param diagram component diagram model
	 * @param endTime simulation stop time
	 * @param step step size
	 */
	public void simulate(ComponentDiagram diagram, double endTime, double step) {
		assert groovy != null;
		assert traces != null;
		traces.clear();
		
		double currentTime = 0.0;
		
		// initialisation step
		for (Component c : diagram.getComponents())
			apiInitialise(c, currentTime, endTime);

		// simulation loop
		while (currentTime < endTime) {
			
			// read port values
			for (Component c : diagram.getComponents())
				apiReadPorts(c);
			
			// write port values
			for (Component c : diagram.getComponents())
				apiWritePorts(c);
			
			// do step
			for (Component c : diagram.getComponents())
				apiDoStep(c, currentTime, step);
			
			// progress the time
			currentTime += step;
		}
		
		// termination step
		for (Component c : diagram.getComponents())
			apiTerminate(c);
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
	}

	/**
	 * Initialises Event-B component.
	 * Loads an Event-B machine using Groovy API
	 * and execute first two events: 1) setup constants, 2) initalisation
	 * 
	 * @param component
	 */
	private void apiInitialiseEventB(EventBComponent component) {
		String machinePath = getMachinePath(component.getMachine());
		if (machinePath == null)
			throw new RuntimeException("Cannot load machine component '" + component.getName()
					+ "'. Machine path cannot be determined.");

		groovy.getBindings().setVariable("machinePath", machinePath);
		groovy.runScript(
				"trace = api.eventb_load(\"$machinePath\") as Trace;"+
				"trace = ctrl.anyEvent();"+
				"trace = ctrl.anyEvent();");
		Trace trace = (Trace) groovy.getBindings().getVariable("trace");
		traces.put(component, trace);
	}

	/**
	 * Returns the absolute path of the Event-B machine.
	 * @param machine
	 * @return
	 */
	private String getMachinePath(Machine machine) {
		Resource resource = machine.eResource();
		if (resource != null) {
			URI uri = resource.getURI();
			if (uri.isPlatformResource()) {
				return uri.toFileString();
			}
			//TODO: get path for a non-platform resource (outside of the workspace)
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
	}
	
	/**
	 * Runs a simulation step of Event-B component.
	 * Executes non-deterministically a number of events until an update event is enabled.
	 * 
	 * @param component
	 * @param time - not used at the moment
	 * @param step - not used at the moment
	 */
	private void apiDoStepEventB(EventBComponent component, double time, double step) {
		Trace trace = traces.get(component);
		Event updateEvent = component.getUpdateEvent();
		String updateEventName = updateEvent.getName();
		boolean update = false;
		while (!update) {
			Set<OpInfo> transitions = trace.getNextTransitions();
			
			// find update event
			for (OpInfo op : transitions) {
				if (updateEventName.equals(op.name)) {
					update = true;
					break;
				}
			}
			
			// if not found, execute any event
			if (!update)
				trace = trace.anyEvent(null);
		}
		
		// update recorded trace
		traces.put(component, trace);
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
			Connector connector = port.getConnector();
			if (connector == null)
				continue;
			String name = port.getName();
			Object value = null;
			switch (port.getType()) {
			case BOOLEAN:
				value = fmu.getBoolean(name);
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
			connector.setValue(value);
		}
	}

	/**
	 * Reads values from output ports of an Event-B component.
	 * 
	 * @param component
	 */
	private void apiReadPortsEventB(EventBComponent component) {
		Trace trace = traces.get(component);
		for (Port port : component.getOutputs()) {
			Connector connector = port.getConnector();
			if (connector == null)
				continue;
			String name = port.getName();
			Object value = trace.getCurrentState().value(name);
			switch (port.getType()) {
			case BOOLEAN:
				value = getBooleanFromEventB(trace, name);
				break;
			case INTEGER:
				value = getIntegerFromEventB(trace, name);
				break;
			case REAL:
				value = getDoubleFromEventB(trace, name, DOUBLE_PRECISION);
				break;
			case STRING:
				value = getStringFromEventB(trace, name);
				break;
			}
			connector.setValue(value);
		}
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
			String name = port.getName();
			Object value = connector.getValue();
			switch (port.getType()) {
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
	}
	
	/**
	 * Writes values to input ports of an Event-B component.
	 * 
	 * @param component
	 */
	private void apiWritePortsEventB(EventBComponent component) {
		Trace trace = traces.get(component);
		List<String> params = new ArrayList<String>();
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
				bValue = getDoubleToEventB((Double) value, DOUBLE_PRECISION);
				break;
			case STRING:
				bValue = getStringToEventB((String) value);
				break;
			}
			params.add(name + "=" + bValue);
		}
		trace = trace.add(component.getReadInputsEvent().getName(), params);
		
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
		fmu.terminate();
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
		double toB = value.doubleValue() * Math.pow(10, DOUBLE_PRECISION);
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
