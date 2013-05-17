/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components;

import org.eventb.emf.core.machine.Parameter;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event BPort</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.fmusim.components.EventBPort#getEventParameter <em>Event Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.fmusim.components.ComponentsPackage#getEventBPort()
 * @model
 * @generated
 */
public interface EventBPort extends Port {

	/**
	 * Returns the value of the '<em><b>Event Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Parameter</em>' reference.
	 * @see #setEventParameter(Parameter)
	 * @see ac.soton.fmusim.components.ComponentsPackage#getEventBPort_EventParameter()
	 * @model required="true"
	 * @generated
	 */
	Parameter getEventParameter();

	/**
	 * Sets the value of the '{@link ac.soton.fmusim.components.EventBPort#getEventParameter <em>Event Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Parameter</em>' reference.
	 * @see #getEventParameter()
	 * @generated
	 */
	void setEventParameter(Parameter value);

} // EventBPort
