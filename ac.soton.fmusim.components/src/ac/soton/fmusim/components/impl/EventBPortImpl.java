/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eventb.emf.core.machine.Parameter;
import org.eventb.emf.core.machine.Variable;

import ac.soton.fmusim.components.ComponentsPackage;
import ac.soton.fmusim.components.EventBPort;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event BPort</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBPortImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBPortImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBPortImpl#getRealPrecision <em>Real Precision</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventBPortImpl extends PortImpl implements EventBPort {
	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected Parameter parameter;
	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable variable;
	/**
	 * The default value of the '{@link #getRealPrecision() <em>Real Precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealPrecision()
	 * @generated
	 * @ordered
	 */
	protected static final int REAL_PRECISION_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getRealPrecision() <em>Real Precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealPrecision()
	 * @generated
	 * @ordered
	 */
	protected int realPrecision = REAL_PRECISION_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventBPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentsPackage.Literals.EVENT_BPORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter getParameter() {
		if (parameter != null && parameter.eIsProxy()) {
			InternalEObject oldParameter = (InternalEObject)parameter;
			parameter = (Parameter)eResolveProxy(oldParameter);
			if (parameter != oldParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComponentsPackage.EVENT_BPORT__PARAMETER, oldParameter, parameter));
			}
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter basicGetParameter() {
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameter(Parameter newParameter) {
		Parameter oldParameter = parameter;
		parameter = newParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BPORT__PARAMETER, oldParameter, parameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getVariable() {
		if (variable != null && variable.eIsProxy()) {
			InternalEObject oldVariable = (InternalEObject)variable;
			variable = (Variable)eResolveProxy(oldVariable);
			if (variable != oldVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComponentsPackage.EVENT_BPORT__VARIABLE, oldVariable, variable));
			}
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetVariable() {
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariable(Variable newVariable) {
		Variable oldVariable = variable;
		variable = newVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BPORT__VARIABLE, oldVariable, variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRealPrecision() {
		return realPrecision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRealPrecision(int newRealPrecision) {
		int oldRealPrecision = realPrecision;
		realPrecision = newRealPrecision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BPORT__REAL_PRECISION, oldRealPrecision, realPrecision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentsPackage.EVENT_BPORT__PARAMETER:
				if (resolve) return getParameter();
				return basicGetParameter();
			case ComponentsPackage.EVENT_BPORT__VARIABLE:
				if (resolve) return getVariable();
				return basicGetVariable();
			case ComponentsPackage.EVENT_BPORT__REAL_PRECISION:
				return getRealPrecision();
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
			case ComponentsPackage.EVENT_BPORT__PARAMETER:
				setParameter((Parameter)newValue);
				return;
			case ComponentsPackage.EVENT_BPORT__VARIABLE:
				setVariable((Variable)newValue);
				return;
			case ComponentsPackage.EVENT_BPORT__REAL_PRECISION:
				setRealPrecision((Integer)newValue);
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
			case ComponentsPackage.EVENT_BPORT__PARAMETER:
				setParameter((Parameter)null);
				return;
			case ComponentsPackage.EVENT_BPORT__VARIABLE:
				setVariable((Variable)null);
				return;
			case ComponentsPackage.EVENT_BPORT__REAL_PRECISION:
				setRealPrecision(REAL_PRECISION_EDEFAULT);
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
			case ComponentsPackage.EVENT_BPORT__PARAMETER:
				return parameter != null;
			case ComponentsPackage.EVENT_BPORT__VARIABLE:
				return variable != null;
			case ComponentsPackage.EVENT_BPORT__REAL_PRECISION:
				return realPrecision != REAL_PRECISION_EDEFAULT;
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
		result.append(" (realPrecision: ");
		result.append(realPrecision);
		result.append(')');
		return result.toString();
	}

} //EventBPortImpl
