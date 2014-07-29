/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eventb.core.IEventBRoot;
import org.eventb.emf.core.impl.AbstractExtensionImpl;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.Variable;
import org.rodinp.core.IRodinFile;
import org.rodinp.core.RodinCore;

import ac.soton.fmusim.components.AbstractVariable;
import ac.soton.fmusim.components.Component;
import ac.soton.fmusim.components.ComponentsPackage;
import ac.soton.fmusim.components.Connector;
import ac.soton.fmusim.components.EventBComponent;
import ac.soton.fmusim.components.EventBPort;
import ac.soton.fmusim.components.NamedElement;
import ac.soton.fmusim.components.Port;
import ac.soton.fmusim.components.VariableType;
import ac.soton.fmusim.components.exceptions.ModelException;
import ac.soton.fmusim.components.exceptions.SimulationException;
import ac.soton.fmusim.components.util.ComponentsValidator;

import com.google.inject.Injector;

import de.be4.classicalb.core.parser.exceptions.BException;
import de.prob.model.eventb.EventBModel;
import de.prob.scripting.EventBFactory;
import de.prob.statespace.OpInfo;
import de.prob.statespace.StateId;
import de.prob.statespace.StateSpace;
import de.prob.statespace.Trace;
import de.prob.webconsole.ServletContextListener;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event BComponent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getName <em>Name</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getStepPeriod <em>Step Period</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#isComposed <em>Composed</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getMachine <em>Machine</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getReadInputEvents <em>Read Input Events</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getTimeVariable <em>Time Variable</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getWaitEvents <em>Wait Events</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getTrace <em>Trace</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getTracePath <em>Trace Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventBComponentImpl extends AbstractExtensionImpl implements EventBComponent {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> inputs;

	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> outputs;

	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractVariable> variables;

	/**
	 * The default value of the '{@link #getStepPeriod() <em>Step Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepPeriod()
	 * @generated
	 * @ordered
	 */
	protected static final double STEP_PERIOD_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getStepPeriod() <em>Step Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepPeriod()
	 * @generated
	 * @ordered
	 */
	protected double stepPeriod = STEP_PERIOD_EDEFAULT;

	/**
	 * The default value of the '{@link #isComposed() <em>Composed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComposed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMPOSED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isComposed() <em>Composed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComposed()
	 * @generated
	 * @ordered
	 */
	protected boolean composed = COMPOSED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMachine() <em>Machine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachine()
	 * @generated
	 * @ordered
	 */
	protected Machine machine;

	/**
	 * The cached value of the '{@link #getReadInputEvents() <em>Read Input Events</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReadInputEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> readInputEvents;

	/**
	 * The cached value of the '{@link #getTimeVariable() <em>Time Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable timeVariable;

	/**
	 * The cached value of the '{@link #getWaitEvents() <em>Wait Events</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWaitEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> waitEvents;

	/**
	 * The default value of the '{@link #getTrace() <em>Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrace()
	 * @generated
	 * @ordered
	 */
	protected static final Trace TRACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTrace() <em>Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrace()
	 * @generated
	 * @ordered
	 */
	protected Trace trace = TRACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTracePath() <em>Trace Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTracePath()
	 * @generated
	 * @ordered
	 */
	protected static final String TRACE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTracePath() <em>Trace Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTracePath()
	 * @generated
	 * @ordered
	 */
	protected String tracePath = TRACE_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected EventBComponentImpl() {
		super();
		//XXX: temporary solution for setting abstract extension default id
		// this implementation is sensible to order of subclasses in metamodel
		setExtensionId(ComponentsPackage.EVENTB_COMPONENT_EXTENSION_ID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentsPackage.Literals.EVENT_BCOMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getInputs() {
		if (inputs == null) {
			inputs = new EObjectContainmentEList.Resolving<Port>(Port.class, this, ComponentsPackage.EVENT_BCOMPONENT__INPUTS);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getOutputs() {
		if (outputs == null) {
			outputs = new EObjectContainmentEList.Resolving<Port>(Port.class, this, ComponentsPackage.EVENT_BCOMPONENT__OUTPUTS);
		}
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isComposed() {
		return composed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComposed(boolean newComposed) {
		boolean oldComposed = composed;
		composed = newComposed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__COMPOSED, oldComposed, composed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Machine getMachine() {
		if (machine != null && machine.eIsProxy()) {
			InternalEObject oldMachine = (InternalEObject)machine;
			machine = (Machine)eResolveProxy(oldMachine);
			if (machine != oldMachine) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComponentsPackage.EVENT_BCOMPONENT__MACHINE, oldMachine, machine));
			}
		}
		return machine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Machine basicGetMachine() {
		return machine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMachine(Machine newMachine) {
		Machine oldMachine = machine;
		machine = newMachine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__MACHINE, oldMachine, machine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> getReadInputEvents() {
		if (readInputEvents == null) {
			readInputEvents = new EObjectResolvingEList<Event>(Event.class, this, ComponentsPackage.EVENT_BCOMPONENT__READ_INPUT_EVENTS);
		}
		return readInputEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getTimeVariable() {
		if (timeVariable != null && timeVariable.eIsProxy()) {
			InternalEObject oldTimeVariable = (InternalEObject)timeVariable;
			timeVariable = (Variable)eResolveProxy(oldTimeVariable);
			if (timeVariable != oldTimeVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComponentsPackage.EVENT_BCOMPONENT__TIME_VARIABLE, oldTimeVariable, timeVariable));
			}
		}
		return timeVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetTimeVariable() {
		return timeVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeVariable(Variable newTimeVariable) {
		Variable oldTimeVariable = timeVariable;
		timeVariable = newTimeVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__TIME_VARIABLE, oldTimeVariable, timeVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> getWaitEvents() {
		if (waitEvents == null) {
			waitEvents = new EObjectResolvingEList<Event>(Event.class, this, ComponentsPackage.EVENT_BCOMPONENT__WAIT_EVENTS);
		}
		return waitEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractVariable> getVariables() {
		if (variables == null) {
			variables = new EObjectContainmentEList.Resolving<AbstractVariable>(AbstractVariable.class, this, ComponentsPackage.EVENT_BCOMPONENT__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trace getTrace() {
		return trace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrace(Trace newTrace) {
		Trace oldTrace = trace;
		trace = newTrace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__TRACE, oldTrace, trace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTracePath() {
		return tracePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTracePath(String newTracePath) {
		String oldTracePath = tracePath;
		tracePath = newTracePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__TRACE_PATH, oldTracePath, tracePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getStepPeriod() {
		return stepPeriod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStepPeriod(double newStepPeriod) {
		double oldStepPeriod = stepPeriod;
		stepPeriod = newStepPeriod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__STEP_PERIOD, oldStepPeriod, stepPeriod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * Event-B Component must have a valid reference to an existing machine.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasValidMachineReference(DiagnosticChain diagnostics, Map<Object, Object> context) {
		
		// get method to retrieve a machine with a proxy resolution
		Machine m = getMachine();
		
		// error if still null or proxy unresolved
		if (m == null || m.eIsProxy()) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 ComponentsValidator.DIAGNOSTIC_SOURCE,
						 ComponentsValidator.EVENT_BCOMPONENT__HAS_VALID_MACHINE_REFERENCE,
						//TODO: use external string resource and a default approach, i.e. EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] {...
						 MessageFormat.format("Component ''{0}'' must have a valid Machine reference", new Object[] { this.getName() }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void initialise(double tStart, double tStop) {
		Trace trace = getTrace();
		assert trace != null;
		
		// execute first two events: 'setup_constants' and 'initialise'
		//NOTE: setup_constants can be absent if there are no constants
		trace = trace.anyEvent(null);
		String currentOpName = trace.getCurrent().getOp().getName();
		if (currentOpName.startsWith("$initialise_machine") == false)
			trace = trace.anyEvent(null);
		
		// update variables and output ports
		//NOTE: input ports are bound to parameters, so no value for them
		for (AbstractVariable v : getVariables())
			v.setValue(trace.getCurrentState().value(v.getName()));
		for (Port p : getOutputs())
			p.setValue(trace.getCurrentState().value(p.getName()));
		
		// update trace
		setTrace(trace);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws SimulationException 
	 * @generated NOT
	 */
	public void readInputs() throws SimulationException, ModelException {
		Trace trace = getTrace();
		assert trace != null;
		EList<Event> readEvents = getReadInputEvents();
		
		// skip if no inputs
		if (readEvents.isEmpty())
			return;
		
		// build parameter predicate for event execution
		StringBuilder predicate = new StringBuilder("TRUE=TRUE");
		for (Port p : getInputs()) {
			assert p instanceof EventBPort;
			EventBPort port = (EventBPort) p;
			assert port.getParameter() != null;
			String parameterName = port.getParameter().getName();
			
			Connector connector = port.getConnector();
			
			// if port not connected, let ProB to pick the value non-deterministically
			//XXX: should it keep the previous (previous step) input value?
			if (connector == null)
				continue;
			
			Object value = connector.getValue();	// value from connector
			String bValue = valueFmiToEventB(value, port.getType(), port.getRealPrecision());	// value to be passed to event, thus in Event-B format
			
			// add parameter to event predicate string
			predicate.append("&" + parameterName + "=" + bValue);
			
			// set port value
			port.setValue(value);
		}

		OpInfo op = null;
		for (Event e : readEvents) {
			try {
				op = trace.findOneOp(e.getName(), predicate.toString());
				//FIXME: should it stop here if an event is found? what if multiple events are possible?
				//TODO: set randomly chosen values of disconnected ports
			} catch (BException e1) {
				throw new SimulationException("Finding 'read inputs' event '" + e.getName() + "' by ProB failed: " + e1.getMessage());
			} catch (IllegalArgumentException e1) {
				// if operation was not found, carry on looking
			}
		}
		
		// if not found at all, likely indicates that model is not correct
		if (op == null) {
			throw new ModelException("No enabled 'read inputs' events could be found for component '" + this.getName() + "' with the predicate: " + predicate.toString());
		}

		// execute 'read inputs' event with calculated parameter predicate
		trace = trace.add(op.getId());
			
		// update trace
		setTrace(trace);
	}
	
	/**
	 * Converts FMI value to Event-B.
	 * Precision is required for the Real type.
	 * 
	 * @param value
	 * @param type
	 * @param precision
	 * @return
	 */
	private String valueFmiToEventB(Object value, VariableType type, int precision) {
		switch (type) {
		case BOOLEAN:
			assert value instanceof Boolean;
			return value.toString().toUpperCase();
		case INTEGER:
			assert value instanceof Integer;
			return value.toString();
		case REAL:
			assert value instanceof Double;
			double toB = ((Double) value).doubleValue() * Math.pow(10, precision);
			return Integer.toString((int) toB);
		case STRING:
			assert value instanceof String;
			return (String) value;
		default:
			return null;
		}
	}

	/**
	 * Returns any enabled operation from the list of events, i.e.
	 * if multiple operations are enabled, a random one is selected.
	 * 
	 * @param trace trace of operations
	 * @param events list of events
	 * @return
	 */
	private OpInfo findAnyEnabled(Trace trace, EList<Event> events) {
		// get names of all events
		Set<String> eventNames = new HashSet<String>(events.size());
		for (Event event : events)
			eventNames.add(event.getName());
		
		// find enabled events that match by name
		List<OpInfo> enabledOps = new ArrayList<OpInfo>(events.size());
		Set<OpInfo> opInfos = trace.getStateSpace().evaluateOps(trace.getNextTransitions());
		for (OpInfo op : opInfos) {
			if (eventNames.contains(op.getName())) {
				enabledOps.add(op);
			}
		}
		
		// return a random enabled op
		if (enabledOps.size() > 0) {
			int idx = new Random().nextInt(enabledOps.size());
			return enabledOps.get(idx);
		}
		
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void writeOutputs() {
		Trace trace = getTrace();
		assert trace != null;
		StateId state = trace.getCurrentState();
		
		for (Port p : getOutputs()) {
			assert p instanceof EventBPort;
			EventBPort port = (EventBPort) p;
			assert port.getVariable() != null;
			String name = port.getVariable().getName();
			String bValue = (String) state.value(name);
			Object value = valueEventBToFmi(bValue, port.getType(), port.getRealPrecision());
			
			// send value to connector if connected
			Connector connector = port.getConnector();
			if (connector != null) {
				connector.setValue(value);
			}
			
			// set port value
			port.setValue(value);
		}

		// update trace
		setTrace(trace);
	}

	/**
	 * Convert Event-B value to FMI.
	 * NOTE: As doubles are not yet supported by Event-B,
	 * they are modelled as integers, converted from a double
	 * with a specified precision: double = int / (10 ^ precision)
	 * 
	 * @param value
	 * @param type
	 * @param precision
	 * @return
	 */
	private Object valueEventBToFmi(String value, VariableType type, int precision) {
		switch (type) {
		case BOOLEAN:
			return Boolean.valueOf(value);
		case INTEGER:
			return Integer.valueOf(value);
		case REAL:
			Integer integer = Integer.valueOf(value);
			return integer.doubleValue() / Math.pow(10d, precision);
		case STRING:
			return value;
		default:
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws SimulationException 
	 * @generated NOT
	 */
	public void doStep(double time, double step) throws SimulationException {
		Trace trace = getTrace();
		assert trace != null;
		EList<Event> waitEvents = getWaitEvents();
		assert waitEvents.size() > 0;
		EList<Event> readEvents = getReadInputEvents();
		
		boolean update = false;
		while (!update) {
			// find and execute an enabled Wait event
			OpInfo op = findAnyEnabled(trace, waitEvents);
			if (op != null) {
				// execute only if wait event is not also a readInput event (if inputs exist)
				if (findEvent(op, readEvents) == null) {
					trace = trace.add(op.getId());
				}
				update = true;
				break;
			}
			
			// if not found, execute any event
			if (!update) {
				if (trace.getNextTransitions().isEmpty())
					throw new SimulationException("Deadlock state reached in "+getName());
				
				trace = trace.anyEvent(null);
			}
		}
		
		// update variables
		for (AbstractVariable v : getVariables())
			v.setValue(trace.getCurrentState().value(v.getName()));
		// update ports: only outputs need to be updated - inputs shouldn't have changed
		for (Port p : getOutputs())
			p.setValue(trace.getCurrentState().value(p.getName()));
		
		// update trace
		setTrace(trace);
	}

	/**
	 * Returns first matching event corresponding to an operation, or null of not found.
	 * 
	 * @param operation
	 * @param events list of events
	 * @return
	 */
	private Event findEvent(OpInfo operation, EList<Event> events) {
		for (Event event : events)
			if (operation.getName().equals(event.getName()))
				return event;
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void terminate() {
		trace.getStateSpace().endTransaction();
		setTrace(null);
		System.gc();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void instantiate() throws SimulationException {
		final IEventBRoot machineRoot = getMachineRoot(getMachine());
		if (machineRoot == null)
			throw new SimulationException("Cannot load machine component '" + getName()
					+ "'. Machine root cannot be determined.");
		
		String fileName = machineRoot.getResource().getRawLocation()
				.makeAbsolute().toOSString();
		if (fileName.endsWith(".buc")) {
			fileName = fileName.replace(".buc", ".bcc");
		} else {
			fileName = fileName.replace(".bum", ".bcm");
		}

		Injector injector = ServletContextListener.INJECTOR;

		final EventBFactory instance = injector
				.getInstance(EventBFactory.class);

		EventBModel model = instance.load(fileName,
				new HashMap<String, String>(), true);

		StateSpace s = model.getStatespace();
		s.startTransaction();

		Trace t = new Trace(s);
		setTrace(t);
		System.gc();
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentsPackage.EVENT_BCOMPONENT__INPUTS:
				return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.EVENT_BCOMPONENT__OUTPUTS:
				return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.EVENT_BCOMPONENT__VARIABLES:
				return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentsPackage.EVENT_BCOMPONENT__NAME:
				return getName();
			case ComponentsPackage.EVENT_BCOMPONENT__INPUTS:
				return getInputs();
			case ComponentsPackage.EVENT_BCOMPONENT__OUTPUTS:
				return getOutputs();
			case ComponentsPackage.EVENT_BCOMPONENT__VARIABLES:
				return getVariables();
			case ComponentsPackage.EVENT_BCOMPONENT__STEP_PERIOD:
				return getStepPeriod();
			case ComponentsPackage.EVENT_BCOMPONENT__COMPOSED:
				return isComposed();
			case ComponentsPackage.EVENT_BCOMPONENT__MACHINE:
				if (resolve) return getMachine();
				return basicGetMachine();
			case ComponentsPackage.EVENT_BCOMPONENT__READ_INPUT_EVENTS:
				return getReadInputEvents();
			case ComponentsPackage.EVENT_BCOMPONENT__TIME_VARIABLE:
				if (resolve) return getTimeVariable();
				return basicGetTimeVariable();
			case ComponentsPackage.EVENT_BCOMPONENT__WAIT_EVENTS:
				return getWaitEvents();
			case ComponentsPackage.EVENT_BCOMPONENT__TRACE:
				return getTrace();
			case ComponentsPackage.EVENT_BCOMPONENT__TRACE_PATH:
				return getTracePath();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ComponentsPackage.EVENT_BCOMPONENT__NAME:
				setName((String)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends Port>)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends Port>)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends AbstractVariable>)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__STEP_PERIOD:
				setStepPeriod((Double)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__COMPOSED:
				setComposed((Boolean)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__MACHINE:
				setMachine((Machine)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__READ_INPUT_EVENTS:
				getReadInputEvents().clear();
				getReadInputEvents().addAll((Collection<? extends Event>)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__TIME_VARIABLE:
				setTimeVariable((Variable)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__WAIT_EVENTS:
				getWaitEvents().clear();
				getWaitEvents().addAll((Collection<? extends Event>)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__TRACE:
				setTrace((Trace)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__TRACE_PATH:
				setTracePath((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ComponentsPackage.EVENT_BCOMPONENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__INPUTS:
				getInputs().clear();
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__OUTPUTS:
				getOutputs().clear();
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__VARIABLES:
				getVariables().clear();
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__STEP_PERIOD:
				setStepPeriod(STEP_PERIOD_EDEFAULT);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__COMPOSED:
				setComposed(COMPOSED_EDEFAULT);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__MACHINE:
				setMachine((Machine)null);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__READ_INPUT_EVENTS:
				getReadInputEvents().clear();
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__TIME_VARIABLE:
				setTimeVariable((Variable)null);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__WAIT_EVENTS:
				getWaitEvents().clear();
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__TRACE:
				setTrace(TRACE_EDEFAULT);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__TRACE_PATH:
				setTracePath(TRACE_PATH_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ComponentsPackage.EVENT_BCOMPONENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ComponentsPackage.EVENT_BCOMPONENT__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case ComponentsPackage.EVENT_BCOMPONENT__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
			case ComponentsPackage.EVENT_BCOMPONENT__VARIABLES:
				return variables != null && !variables.isEmpty();
			case ComponentsPackage.EVENT_BCOMPONENT__STEP_PERIOD:
				return stepPeriod != STEP_PERIOD_EDEFAULT;
			case ComponentsPackage.EVENT_BCOMPONENT__COMPOSED:
				return composed != COMPOSED_EDEFAULT;
			case ComponentsPackage.EVENT_BCOMPONENT__MACHINE:
				return machine != null;
			case ComponentsPackage.EVENT_BCOMPONENT__READ_INPUT_EVENTS:
				return readInputEvents != null && !readInputEvents.isEmpty();
			case ComponentsPackage.EVENT_BCOMPONENT__TIME_VARIABLE:
				return timeVariable != null;
			case ComponentsPackage.EVENT_BCOMPONENT__WAIT_EVENTS:
				return waitEvents != null && !waitEvents.isEmpty();
			case ComponentsPackage.EVENT_BCOMPONENT__TRACE:
				return TRACE_EDEFAULT == null ? trace != null : !TRACE_EDEFAULT.equals(trace);
			case ComponentsPackage.EVENT_BCOMPONENT__TRACE_PATH:
				return TRACE_PATH_EDEFAULT == null ? tracePath != null : !TRACE_PATH_EDEFAULT.equals(tracePath);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == NamedElement.class) {
			switch (derivedFeatureID) {
				case ComponentsPackage.EVENT_BCOMPONENT__NAME: return ComponentsPackage.NAMED_ELEMENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == Component.class) {
			switch (derivedFeatureID) {
				case ComponentsPackage.EVENT_BCOMPONENT__INPUTS: return ComponentsPackage.COMPONENT__INPUTS;
				case ComponentsPackage.EVENT_BCOMPONENT__OUTPUTS: return ComponentsPackage.COMPONENT__OUTPUTS;
				case ComponentsPackage.EVENT_BCOMPONENT__VARIABLES: return ComponentsPackage.COMPONENT__VARIABLES;
				case ComponentsPackage.EVENT_BCOMPONENT__STEP_PERIOD: return ComponentsPackage.COMPONENT__STEP_PERIOD;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == NamedElement.class) {
			switch (baseFeatureID) {
				case ComponentsPackage.NAMED_ELEMENT__NAME: return ComponentsPackage.EVENT_BCOMPONENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == Component.class) {
			switch (baseFeatureID) {
				case ComponentsPackage.COMPONENT__INPUTS: return ComponentsPackage.EVENT_BCOMPONENT__INPUTS;
				case ComponentsPackage.COMPONENT__OUTPUTS: return ComponentsPackage.EVENT_BCOMPONENT__OUTPUTS;
				case ComponentsPackage.COMPONENT__VARIABLES: return ComponentsPackage.EVENT_BCOMPONENT__VARIABLES;
				case ComponentsPackage.COMPONENT__STEP_PERIOD: return ComponentsPackage.EVENT_BCOMPONENT__STEP_PERIOD;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", stepPeriod: ");
		result.append(stepPeriod);
		result.append(", composed: ");
		result.append(composed);
		result.append(", trace: ");
		result.append(trace);
		result.append(", tracePath: ");
		result.append(tracePath);
		result.append(')');
		return result.toString();
	}

} //EventBComponentImpl
