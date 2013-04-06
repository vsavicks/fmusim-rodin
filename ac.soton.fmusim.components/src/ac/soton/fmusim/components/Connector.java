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
 * A representation of the model object '<em><b>Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.fmusim.components.Connector#getValue <em>Value</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.Connector#getPorts <em>Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.fmusim.components.ComponentsPackage#getConnector()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='CompatiblePorts CompleteConnection'"
 * @generated
 */
public interface Connector extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Object)
	 * @see ac.soton.fmusim.components.ComponentsPackage#getConnector_Value()
	 * @model transient="true"
	 * @generated
	 */
	Object getValue();

	/**
	 * Sets the value of the '{@link ac.soton.fmusim.components.Connector#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Object value);

	/**
	 * Returns the value of the '<em><b>Ports</b></em>' reference list.
	 * The list contents are of type {@link ac.soton.fmusim.components.Port}.
	 * It is bidirectional and its opposite is '{@link ac.soton.fmusim.components.Port#getConnector <em>Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ports</em>' reference list.
	 * @see ac.soton.fmusim.components.ComponentsPackage#getConnector_Ports()
	 * @see ac.soton.fmusim.components.Port#getConnector
	 * @model opposite="connector"
	 * @generated
	 */
	EList<Port> getPorts();

} // Connector
