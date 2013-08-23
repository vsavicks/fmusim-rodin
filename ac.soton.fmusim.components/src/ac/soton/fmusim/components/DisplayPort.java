/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package ac.soton.fmusim.components;

import info.monitorenter.gui.chart.ITrace2D;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Display Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.fmusim.components.DisplayPort#getTrace <em>Trace</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.DisplayPort#getColour <em>Colour</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.fmusim.components.ComponentsPackage#getDisplayPort()
 * @model
 * @generated
 */
public interface DisplayPort extends Port {
	/**
	 * Returns the value of the '<em><b>Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace</em>' attribute.
	 * @see #setTrace(ITrace2D)
	 * @see ac.soton.fmusim.components.ComponentsPackage#getDisplayPort_Trace()
	 * @model dataType="ac.soton.fmusim.components.Trace2DClass" transient="true"
	 * @generated
	 */
	ITrace2D getTrace();

	/**
	 * Sets the value of the '{@link ac.soton.fmusim.components.DisplayPort#getTrace <em>Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace</em>' attribute.
	 * @see #getTrace()
	 * @generated
	 */
	void setTrace(ITrace2D value);

	/**
	 * Returns the value of the '<em><b>Colour</b></em>' attribute.
	 * The literals are from the enumeration {@link ac.soton.fmusim.components.Colour}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Colour</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Colour</em>' attribute.
	 * @see ac.soton.fmusim.components.Colour
	 * @see #setColour(Colour)
	 * @see ac.soton.fmusim.components.ComponentsPackage#getDisplayPort_Colour()
	 * @model
	 * @generated
	 */
	Colour getColour();

	/**
	 * Sets the value of the '{@link ac.soton.fmusim.components.DisplayPort#getColour <em>Colour</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Colour</em>' attribute.
	 * @see ac.soton.fmusim.components.Colour
	 * @see #getColour()
	 * @generated
	 */
	void setColour(Colour value);

} // DisplayPort
