/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.fmusim.components.Port#getConnector <em>Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.fmusim.components.ComponentsPackage#getPort()
 * @model abstract="true"
 * @generated
 */
public interface Port extends AbstractVariable {
	/**
	 * Returns the value of the '<em><b>Connector</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link ac.soton.fmusim.components.Connector#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connector</em>' reference.
	 * @see #setConnector(Connector)
	 * @see ac.soton.fmusim.components.ComponentsPackage#getPort_Connector()
	 * @see ac.soton.fmusim.components.Connector#getPorts
	 * @model opposite="ports"
	 * @generated
	 */
	Connector getConnector();

	/**
	 * Sets the value of the '{@link ac.soton.fmusim.components.Port#getConnector <em>Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connector</em>' reference.
	 * @see #getConnector()
	 * @generated
	 */
	void setConnector(Connector value);

} // Port
