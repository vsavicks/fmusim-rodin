/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.impl;

import ac.soton.fmusim.components.ComponentsPackage;
import ac.soton.fmusim.components.EventBComponent;

import ac.soton.fmusim.components.util.ComponentsValidator;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eventb.emf.core.machine.Machine;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event BComponent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#isComposed <em>Composed</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getTimeVariableName <em>Time Variable Name</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getMachine <em>Machine</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventBComponentImpl extends ComponentImpl implements EventBComponent {
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
	 * The default value of the '{@link #getTimeVariableName() <em>Time Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeVariableName()
	 * @generated
	 * @ordered
	 */
	protected static final String TIME_VARIABLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimeVariableName() <em>Time Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeVariableName()
	 * @generated
	 * @ordered
	 */
	protected String timeVariableName = TIME_VARIABLE_NAME_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventBComponentImpl() {
		super();
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
	public String getTimeVariableName() {
		return timeVariableName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeVariableName(String newTimeVariableName) {
		String oldTimeVariableName = timeVariableName;
		timeVariableName = newTimeVariableName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__TIME_VARIABLE_NAME, oldTimeVariableName, timeVariableName));
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentsPackage.EVENT_BCOMPONENT__COMPOSED:
				return isComposed();
			case ComponentsPackage.EVENT_BCOMPONENT__TIME_VARIABLE_NAME:
				return getTimeVariableName();
			case ComponentsPackage.EVENT_BCOMPONENT__MACHINE:
				if (resolve) return getMachine();
				return basicGetMachine();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ComponentsPackage.EVENT_BCOMPONENT__COMPOSED:
				setComposed((Boolean)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__TIME_VARIABLE_NAME:
				setTimeVariableName((String)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__MACHINE:
				setMachine((Machine)newValue);
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
			case ComponentsPackage.EVENT_BCOMPONENT__COMPOSED:
				setComposed(COMPOSED_EDEFAULT);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__TIME_VARIABLE_NAME:
				setTimeVariableName(TIME_VARIABLE_NAME_EDEFAULT);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__MACHINE:
				setMachine((Machine)null);
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
			case ComponentsPackage.EVENT_BCOMPONENT__COMPOSED:
				return composed != COMPOSED_EDEFAULT;
			case ComponentsPackage.EVENT_BCOMPONENT__TIME_VARIABLE_NAME:
				return TIME_VARIABLE_NAME_EDEFAULT == null ? timeVariableName != null : !TIME_VARIABLE_NAME_EDEFAULT.equals(timeVariableName);
			case ComponentsPackage.EVENT_BCOMPONENT__MACHINE:
				return machine != null;
		}
		return super.eIsSet(featureID);
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
		result.append(" (composed: ");
		result.append(composed);
		result.append(", timeVariableName: ");
		result.append(timeVariableName);
		result.append(')');
		return result.toString();
	}

} //EventBComponentImpl
