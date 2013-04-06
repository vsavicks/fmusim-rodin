/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.impl;

import ac.soton.fmusim.components.ComponentsPackage;
import ac.soton.fmusim.components.EventBPort;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eventb.emf.core.machine.Event;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event BPort</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBPortImpl#getFmiGetEvent <em>Fmi Get Event</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBPortImpl#getFmiSetEvent <em>Fmi Set Event</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventBPortImpl extends PortImpl implements EventBPort {
	/**
	 * The cached value of the '{@link #getFmiGetEvent() <em>Fmi Get Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFmiGetEvent()
	 * @generated
	 * @ordered
	 */
	protected Event fmiGetEvent;

	/**
	 * The cached value of the '{@link #getFmiSetEvent() <em>Fmi Set Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFmiSetEvent()
	 * @generated
	 * @ordered
	 */
	protected Event fmiSetEvent;

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
	public Event getFmiGetEvent() {
		if (fmiGetEvent != null && fmiGetEvent.eIsProxy()) {
			InternalEObject oldFmiGetEvent = (InternalEObject)fmiGetEvent;
			fmiGetEvent = (Event)eResolveProxy(oldFmiGetEvent);
			if (fmiGetEvent != oldFmiGetEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComponentsPackage.EVENT_BPORT__FMI_GET_EVENT, oldFmiGetEvent, fmiGetEvent));
			}
		}
		return fmiGetEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event basicGetFmiGetEvent() {
		return fmiGetEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFmiGetEvent(Event newFmiGetEvent) {
		Event oldFmiGetEvent = fmiGetEvent;
		fmiGetEvent = newFmiGetEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BPORT__FMI_GET_EVENT, oldFmiGetEvent, fmiGetEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event getFmiSetEvent() {
		if (fmiSetEvent != null && fmiSetEvent.eIsProxy()) {
			InternalEObject oldFmiSetEvent = (InternalEObject)fmiSetEvent;
			fmiSetEvent = (Event)eResolveProxy(oldFmiSetEvent);
			if (fmiSetEvent != oldFmiSetEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComponentsPackage.EVENT_BPORT__FMI_SET_EVENT, oldFmiSetEvent, fmiSetEvent));
			}
		}
		return fmiSetEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event basicGetFmiSetEvent() {
		return fmiSetEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFmiSetEvent(Event newFmiSetEvent) {
		Event oldFmiSetEvent = fmiSetEvent;
		fmiSetEvent = newFmiSetEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BPORT__FMI_SET_EVENT, oldFmiSetEvent, fmiSetEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentsPackage.EVENT_BPORT__FMI_GET_EVENT:
				if (resolve) return getFmiGetEvent();
				return basicGetFmiGetEvent();
			case ComponentsPackage.EVENT_BPORT__FMI_SET_EVENT:
				if (resolve) return getFmiSetEvent();
				return basicGetFmiSetEvent();
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
			case ComponentsPackage.EVENT_BPORT__FMI_GET_EVENT:
				setFmiGetEvent((Event)newValue);
				return;
			case ComponentsPackage.EVENT_BPORT__FMI_SET_EVENT:
				setFmiSetEvent((Event)newValue);
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
			case ComponentsPackage.EVENT_BPORT__FMI_GET_EVENT:
				setFmiGetEvent((Event)null);
				return;
			case ComponentsPackage.EVENT_BPORT__FMI_SET_EVENT:
				setFmiSetEvent((Event)null);
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
			case ComponentsPackage.EVENT_BPORT__FMI_GET_EVENT:
				return fmiGetEvent != null;
			case ComponentsPackage.EVENT_BPORT__FMI_SET_EVENT:
				return fmiSetEvent != null;
		}
		return super.eIsSet(featureID);
	}

} //EventBPortImpl
