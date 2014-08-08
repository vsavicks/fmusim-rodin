/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.fmusim.components.Port#getOut <em>Out</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.Port#getIn <em>In</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.fmusim.components.ComponentsPackage#getPort()
 * @model abstract="true"
 * @generated
 */
public interface Port extends AbstractVariable {
	/**
	 * Returns the value of the '<em><b>Out</b></em>' reference list.
	 * The list contents are of type {@link ac.soton.fmusim.components.Connector}.
	 * It is bidirectional and its opposite is '{@link ac.soton.fmusim.components.Connector#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out</em>' reference list.
	 * @see ac.soton.fmusim.components.ComponentsPackage#getPort_Out()
	 * @see ac.soton.fmusim.components.Connector#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Connector> getOut();

	/**
	 * Returns the value of the '<em><b>In</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link ac.soton.fmusim.components.Connector#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In</em>' reference.
	 * @see #setIn(Connector)
	 * @see ac.soton.fmusim.components.ComponentsPackage#getPort_In()
	 * @see ac.soton.fmusim.components.Connector#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	Connector getIn();

	/**
	 * Sets the value of the '{@link ac.soton.fmusim.components.Port#getIn <em>In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In</em>' reference.
	 * @see #getIn()
	 * @generated
	 */
	void setIn(Connector value);

} // Port
