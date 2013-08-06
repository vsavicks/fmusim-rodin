/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eventb.emf.core.impl.AbstractExtensionImpl;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.Variable;

import ac.soton.fmusim.components.AbstractVariable;
import ac.soton.fmusim.components.Component;
import ac.soton.fmusim.components.ComponentsPackage;
import ac.soton.fmusim.components.EventBComponent;
import ac.soton.fmusim.components.NamedElement;
import ac.soton.fmusim.components.Port;
import ac.soton.fmusim.components.util.ComponentsValidator;
import de.prob.statespace.Trace;

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
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getWriteOutputsEvent <em>Write Outputs Event</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getTimeVariable <em>Time Variable</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getUpdateEvent <em>Update Event</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getTrace <em>Trace</em>}</li>
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
	 * The cached value of the '{@link #getWriteOutputsEvent() <em>Write Outputs Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWriteOutputsEvent()
	 * @generated
	 * @ordered
	 */
	protected Event writeOutputsEvent;

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
	public Event getWriteOutputsEvent() {
		if (writeOutputsEvent != null && writeOutputsEvent.eIsProxy()) {
			InternalEObject oldWriteOutputsEvent = (InternalEObject)writeOutputsEvent;
			writeOutputsEvent = (Event)eResolveProxy(oldWriteOutputsEvent);
			if (writeOutputsEvent != oldWriteOutputsEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComponentsPackage.EVENT_BCOMPONENT__WRITE_OUTPUTS_EVENT, oldWriteOutputsEvent, writeOutputsEvent));
			}
		}
		return writeOutputsEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event basicGetWriteOutputsEvent() {
		return writeOutputsEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWriteOutputsEvent(Event newWriteOutputsEvent) {
		Event oldWriteOutputsEvent = writeOutputsEvent;
		writeOutputsEvent = newWriteOutputsEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__WRITE_OUTPUTS_EVENT, oldWriteOutputsEvent, writeOutputsEvent));
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
	 * @generated
	 */
	public void initialise(double tStart, double tStop) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void readInputs() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void writeOutputs() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void doStep(double time, double step) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void terminate() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void instantiate() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case ComponentsPackage.EVENT_BCOMPONENT__WRITE_OUTPUTS_EVENT:
				if (resolve) return getWriteOutputsEvent();
				return basicGetWriteOutputsEvent();
			case ComponentsPackage.EVENT_BCOMPONENT__TIME_VARIABLE:
				if (resolve) return getTimeVariable();
				return basicGetTimeVariable();
			case ComponentsPackage.EVENT_BCOMPONENT__UPDATE_EVENT:
				if (resolve) return getUpdateEvent();
				return basicGetUpdateEvent();
			case ComponentsPackage.EVENT_BCOMPONENT__TRACE:
				return getTrace();
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
			case ComponentsPackage.EVENT_BCOMPONENT__WRITE_OUTPUTS_EVENT:
				setWriteOutputsEvent((Event)newValue);
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
			case ComponentsPackage.EVENT_BCOMPONENT__WRITE_OUTPUTS_EVENT:
				setWriteOutputsEvent((Event)null);
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
			case ComponentsPackage.EVENT_BCOMPONENT__WRITE_OUTPUTS_EVENT:
				return writeOutputsEvent != null;
			case ComponentsPackage.EVENT_BCOMPONENT__TIME_VARIABLE:
				return timeVariable != null;
			case ComponentsPackage.EVENT_BCOMPONENT__UPDATE_EVENT:
				return updateEvent != null;
			case ComponentsPackage.EVENT_BCOMPONENT__TRACE:
				return TRACE_EDEFAULT == null ? trace != null : !TRACE_EDEFAULT.equals(trace);
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
		result.append(')');
		return result.toString();
	}

} //EventBComponentImpl
