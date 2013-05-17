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

import ac.soton.fmusim.components.ComponentsPackage;
import ac.soton.fmusim.components.EventBPort;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event BPort</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBPortImpl#getEventParameter <em>Event Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventBPortImpl extends PortImpl implements EventBPort {
	/**
	 * The cached value of the '{@link #getEventParameter() <em>Event Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventParameter()
	 * @generated
	 * @ordered
	 */
	protected Parameter eventParameter;
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
	public Parameter getEventParameter() {
		if (eventParameter != null && eventParameter.eIsProxy()) {
			InternalEObject oldEventParameter = (InternalEObject)eventParameter;
			eventParameter = (Parameter)eResolveProxy(oldEventParameter);
			if (eventParameter != oldEventParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComponentsPackage.EVENT_BPORT__EVENT_PARAMETER, oldEventParameter, eventParameter));
			}
		}
		return eventParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter basicGetEventParameter() {
		return eventParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventParameter(Parameter newEventParameter) {
		Parameter oldEventParameter = eventParameter;
		eventParameter = newEventParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BPORT__EVENT_PARAMETER, oldEventParameter, eventParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentsPackage.EVENT_BPORT__EVENT_PARAMETER:
				if (resolve) return getEventParameter();
				return basicGetEventParameter();
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
			case ComponentsPackage.EVENT_BPORT__EVENT_PARAMETER:
				setEventParameter((Parameter)newValue);
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
			case ComponentsPackage.EVENT_BPORT__EVENT_PARAMETER:
				setEventParameter((Parameter)null);
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
			case ComponentsPackage.EVENT_BPORT__EVENT_PARAMETER:
				return eventParameter != null;
		}
		return super.eIsSet(featureID);
	}

} //EventBPortImpl
