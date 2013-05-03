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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.fmusim.components.AbstractVariable#getType <em>Type</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.AbstractVariable#getCausality <em>Causality</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.fmusim.components.ComponentsPackage#getAbstractVariable()
 * @model abstract="true"
 * @generated
 */
public interface AbstractVariable extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link ac.soton.fmusim.components.VariableType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see ac.soton.fmusim.components.VariableType
	 * @see #setType(VariableType)
	 * @see ac.soton.fmusim.components.ComponentsPackage#getAbstractVariable_Type()
	 * @model
	 * @generated
	 */
	VariableType getType();

	/**
	 * Sets the value of the '{@link ac.soton.fmusim.components.AbstractVariable#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see ac.soton.fmusim.components.VariableType
	 * @see #getType()
	 * @generated
	 */
	void setType(VariableType value);

	/**
	 * Returns the value of the '<em><b>Causality</b></em>' attribute.
	 * The literals are from the enumeration {@link ac.soton.fmusim.components.VariableCausality}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Causality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Causality</em>' attribute.
	 * @see ac.soton.fmusim.components.VariableCausality
	 * @see #setCausality(VariableCausality)
	 * @see ac.soton.fmusim.components.ComponentsPackage#getAbstractVariable_Causality()
	 * @model
	 * @generated
	 */
	VariableCausality getCausality();

	/**
	 * Sets the value of the '{@link ac.soton.fmusim.components.AbstractVariable#getCausality <em>Causality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Causality</em>' attribute.
	 * @see ac.soton.fmusim.components.VariableCausality
	 * @see #getCausality()
	 * @generated
	 */
	void setCausality(VariableCausality value);

} // AbstractVariable
