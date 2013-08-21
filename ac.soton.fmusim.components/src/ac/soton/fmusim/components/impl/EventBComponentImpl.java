/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
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
import ac.soton.fmusim.components.exceptions.SimulationException;
import ac.soton.fmusim.components.util.ComponentsValidator;

import com.google.inject.Injector;

import de.be4.classicalb.core.parser.exceptions.BException;
import de.prob.animator.command.LoadEventBCommand;
import de.prob.animator.command.StartAnimationCommand;
import de.prob.model.eventb.EventBModel;
import de.prob.rodin.translate.EventBTranslator;
import de.prob.scripting.EventBFactory;
import de.prob.statespace.OpInfo;
import de.prob.statespace.StateSpace;
import de.prob.statespace.Trace;
import de.prob.ui.eventb.internal.TranslatorFactory;
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
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#isComposed <em>Composed</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getMachine <em>Machine</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getReadInputsEvent <em>Read Inputs Event</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getTimeVariable <em>Time Variable</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getUpdateEvent <em>Update Event</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getTrace <em>Trace</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getStepPeriod <em>Step Period</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getIntToRealPrecision <em>Int To Real Precision</em>}</li>
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
	 * The cached value of the '{@link #getReadInputsEvent() <em>Read Inputs Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReadInputsEvent()
	 * @generated
	 * @ordered
	 */
	protected Event readInputsEvent;

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
	 * The cached value of the '{@link #getUpdateEvent() <em>Update Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpdateEvent()
	 * @generated
	 * @ordered
	 */
	protected Event updateEvent;

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
	 * The default value of the '{@link #getIntToRealPrecision() <em>Int To Real Precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntToRealPrecision()
	 * @generated
	 * @ordered
	 */
	protected static final int INT_TO_REAL_PRECISION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIntToRealPrecision() <em>Int To Real Precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntToRealPrecision()
	 * @generated
	 * @ordered
	 */
	protected int intToRealPrecision = INT_TO_REAL_PRECISION_EDEFAULT;

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
	public Event getReadInputsEvent() {
		if (readInputsEvent != null && readInputsEvent.eIsProxy()) {
			InternalEObject oldReadInputsEvent = (InternalEObject)readInputsEvent;
			readInputsEvent = (Event)eResolveProxy(oldReadInputsEvent);
			if (readInputsEvent != oldReadInputsEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComponentsPackage.EVENT_BCOMPONENT__READ_INPUTS_EVENT, oldReadInputsEvent, readInputsEvent));
			}
		}
		return readInputsEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event basicGetReadInputsEvent() {
		return readInputsEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadInputsEvent(Event newReadInputsEvent) {
		Event oldReadInputsEvent = readInputsEvent;
		readInputsEvent = newReadInputsEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__READ_INPUTS_EVENT, oldReadInputsEvent, readInputsEvent));
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
	public Event getUpdateEvent() {
		if (updateEvent != null && updateEvent.eIsProxy()) {
			InternalEObject oldUpdateEvent = (InternalEObject)updateEvent;
			updateEvent = (Event)eResolveProxy(oldUpdateEvent);
			if (updateEvent != oldUpdateEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComponentsPackage.EVENT_BCOMPONENT__UPDATE_EVENT, oldUpdateEvent, updateEvent));
			}
		}
		return updateEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event basicGetUpdateEvent() {
		return updateEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpdateEvent(Event newUpdateEvent) {
		Event oldUpdateEvent = updateEvent;
		updateEvent = newUpdateEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__UPDATE_EVENT, oldUpdateEvent, updateEvent));
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
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIntToRealPrecision() {
		return intToRealPrecision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntToRealPrecision(int newIntToRealPrecision) {
		int oldIntToRealPrecision = intToRealPrecision;
		intToRealPrecision = newIntToRealPrecision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__INT_TO_REAL_PRECISION, oldIntToRealPrecision, intToRealPrecision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * Event-B Component must have a valid reference to an existing machine.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasValidMachineReference(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		
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
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "hasValidMachineReference", EObjectValidator.getObjectLabel(this, context) }),
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
		String currentOpName = trace.getCurrent().getOp().name;
		if (currentOpName.startsWith("$initialise_machine") == false)
			trace = trace.anyEvent(null);
		
		// update variables and ports
		for (AbstractVariable v : getVariables())
			v.setValue(trace.getCurrentState().value(v.getName()));
		for (Port p : getInputs())
			p.setValue(trace.getCurrentState().value(p.getName()));
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
	public void readInputs() throws SimulationException {
		Trace trace = getTrace();
		assert trace != null;
		Event readEvent = getReadInputsEvent();
		assert readEvent != null;
		
		String eventName = readEvent.getName();
		OpInfo op = findEnabled(trace, eventName);
		assert op != null;
		//TODO: treat read event not enabled as invalid state (maybe throw an exception)
		
		// build parameter predicate for event execution
		// including only parameter values for the ports
		// that are connected to a feeding connector
		StringBuilder predicate = new StringBuilder("TRUE=TRUE");
		for (Port p : getInputs()) {
			assert p instanceof EventBPort;
			EventBPort port = (EventBPort) p;
			assert port.getParameter() != null;
			String parameterName = port.getParameter().getName();
			
			Connector connector = port.getConnector();
			Object value = null;
			String bValue = null;
			// if port not connected use current value
			if (connector == null) {
				assert port.getVariable() != null;
				value = trace.getCurrentState().value(port.getVariable().getName());
				assert value != null;
				bValue = value.toString();
			} else {
				value = connector.getValue();
				switch (port.getType()) {
				case BOOLEAN:
					bValue = getBooleanToEventB((Boolean) value);
					break;
				case INTEGER:
					bValue = getIntegerToEventB((Integer) value);
					break;
				case REAL:
					bValue = getDoubleToEventB((Double) value, getIntToRealPrecision());
					break;
				case STRING:
					bValue = getStringToEventB((String) value);
					break;
				}
			}
			
			
			// add parameter to event predicate string
			predicate.append("&" + parameterName + "=" + bValue);
			
			// set port value
			port.setValue(value);
		}
		
		// execute 'read inputs' event with calculated parameter predicate
		try {
			trace = trace.add(eventName, predicate.toString());
		} catch (BException e) {
			throw new SimulationException("Executing 'read inputs' event by ProB failed: " + e.getMessage());
			//FIXME: add error handling if read inputs operation not found (not enabled etc.)
		}

		// update trace
		setTrace(trace);
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void writeOutputs() {
		Trace trace = getTrace();
		assert trace != null;
		
		for (Port port : getOutputs()) {
			Object value = getValueEventB(trace, port, getIntToRealPrecision());
			
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void doStep(double time, double step) {
		Trace trace = getTrace();
		assert trace != null;
		Event updateEvent = getUpdateEvent();
		assert updateEvent != null;
		Event readEvent = getReadInputsEvent();
		assert readEvent != null;
		
		String updateEventName = updateEvent.getName();
		boolean update = false;
		while (!update) {
			// find and execute update event
			for (OpInfo op : trace.getNextTransitions()) {
				if (op.name.equals(updateEventName)) {
					// execute only if update and readInputs events are not the same
					if (updateEvent != readEvent) {
						trace = trace.add(op.id);
					}
					update = true;
					break;
				}
			}
			
			// if not found, execute any event
			if (!update)
				trace = trace.anyEvent(null);
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void terminate() {
		//XXX: nothing to do here
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
			//TODO: add error handling
		}

		StateSpace s = model.getStatespace();
		
		Pattern p2 = Pattern.compile("^package\\((.*?)\\)\\.");
		Matcher m2 = p2.matcher(writer.toString());
		m2.find();
		String cmd = m2.group(1);

		s.execute(new LoadEventBCommand(cmd));
		s.execute(new StartAnimationCommand());

		Trace t = new Trace(s);
		setTrace(t);
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
			case ComponentsPackage.EVENT_BCOMPONENT__COMPOSED:
				return isComposed();
			case ComponentsPackage.EVENT_BCOMPONENT__MACHINE:
				if (resolve) return getMachine();
				return basicGetMachine();
			case ComponentsPackage.EVENT_BCOMPONENT__READ_INPUTS_EVENT:
				if (resolve) return getReadInputsEvent();
				return basicGetReadInputsEvent();
			case ComponentsPackage.EVENT_BCOMPONENT__TIME_VARIABLE:
				if (resolve) return getTimeVariable();
				return basicGetTimeVariable();
			case ComponentsPackage.EVENT_BCOMPONENT__UPDATE_EVENT:
				if (resolve) return getUpdateEvent();
				return basicGetUpdateEvent();
			case ComponentsPackage.EVENT_BCOMPONENT__TRACE:
				return getTrace();
			case ComponentsPackage.EVENT_BCOMPONENT__STEP_PERIOD:
				return getStepPeriod();
			case ComponentsPackage.EVENT_BCOMPONENT__INT_TO_REAL_PRECISION:
				return getIntToRealPrecision();
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
			case ComponentsPackage.EVENT_BCOMPONENT__COMPOSED:
				setComposed((Boolean)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__MACHINE:
				setMachine((Machine)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__READ_INPUTS_EVENT:
				setReadInputsEvent((Event)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__TIME_VARIABLE:
				setTimeVariable((Variable)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__UPDATE_EVENT:
				setUpdateEvent((Event)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__TRACE:
				setTrace((Trace)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__STEP_PERIOD:
				setStepPeriod((Double)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__INT_TO_REAL_PRECISION:
				setIntToRealPrecision((Integer)newValue);
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
			case ComponentsPackage.EVENT_BCOMPONENT__COMPOSED:
				setComposed(COMPOSED_EDEFAULT);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__MACHINE:
				setMachine((Machine)null);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__READ_INPUTS_EVENT:
				setReadInputsEvent((Event)null);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__TIME_VARIABLE:
				setTimeVariable((Variable)null);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__UPDATE_EVENT:
				setUpdateEvent((Event)null);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__TRACE:
				setTrace(TRACE_EDEFAULT);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__STEP_PERIOD:
				setStepPeriod(STEP_PERIOD_EDEFAULT);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__INT_TO_REAL_PRECISION:
				setIntToRealPrecision(INT_TO_REAL_PRECISION_EDEFAULT);
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
			case ComponentsPackage.EVENT_BCOMPONENT__COMPOSED:
				return composed != COMPOSED_EDEFAULT;
			case ComponentsPackage.EVENT_BCOMPONENT__MACHINE:
				return machine != null;
			case ComponentsPackage.EVENT_BCOMPONENT__READ_INPUTS_EVENT:
				return readInputsEvent != null;
			case ComponentsPackage.EVENT_BCOMPONENT__TIME_VARIABLE:
				return timeVariable != null;
			case ComponentsPackage.EVENT_BCOMPONENT__UPDATE_EVENT:
				return updateEvent != null;
			case ComponentsPackage.EVENT_BCOMPONENT__TRACE:
				return TRACE_EDEFAULT == null ? trace != null : !TRACE_EDEFAULT.equals(trace);
			case ComponentsPackage.EVENT_BCOMPONENT__STEP_PERIOD:
				return stepPeriod != STEP_PERIOD_EDEFAULT;
			case ComponentsPackage.EVENT_BCOMPONENT__INT_TO_REAL_PRECISION:
				return intToRealPrecision != INT_TO_REAL_PRECISION_EDEFAULT;
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
		result.append(", composed: ");
		result.append(composed);
		result.append(", trace: ");
		result.append(trace);
		result.append(", stepPeriod: ");
		result.append(stepPeriod);
		result.append(", intToRealPrecision: ");
		result.append(intToRealPrecision);
		result.append(')');
		return result.toString();
	}

} //EventBComponentImpl
