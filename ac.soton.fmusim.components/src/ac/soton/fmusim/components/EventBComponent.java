/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.machine.Machine;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event BComponent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.fmusim.components.EventBComponent#isComposed <em>Composed</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.EventBComponent#getTimeVariableName <em>Time Variable Name</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.EventBComponent#getMachine <em>Machine</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.fmusim.components.ComponentsPackage#getEventBComponent()
 * @model
 * @generated
 */
public interface EventBComponent extends AbstractExtension, Component {
	/**
	 * Returns the value of the '<em><b>Composed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composed</em>' attribute.
	 * @see #setComposed(boolean)
	 * @see ac.soton.fmusim.components.ComponentsPackage#getEventBComponent_Composed()
	 * @model
	 * @generated
	 */
	boolean isComposed();

	/**
	 * Sets the value of the '{@link ac.soton.fmusim.components.EventBComponent#isComposed <em>Composed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composed</em>' attribute.
	 * @see #isComposed()
	 * @generated
	 */
	void setComposed(boolean value);

	/**
	 * Returns the value of the '<em><b>Time Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Variable Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Variable Name</em>' attribute.
	 * @see #setTimeVariableName(String)
	 * @see ac.soton.fmusim.components.ComponentsPackage#getEventBComponent_TimeVariableName()
	 * @model
	 * @generated
	 */
	String getTimeVariableName();

	/**
	 * Sets the value of the '{@link ac.soton.fmusim.components.EventBComponent#getTimeVariableName <em>Time Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Variable Name</em>' attribute.
	 * @see #getTimeVariableName()
	 * @generated
	 */
	void setTimeVariableName(String value);

	/**
	 * Returns the value of the '<em><b>Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machine</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machine</em>' reference.
	 * @see #setMachine(Machine)
	 * @see ac.soton.fmusim.components.ComponentsPackage#getEventBComponent_Machine()
	 * @model required="true"
	 * @generated
	 */
	Machine getMachine();

	/**
	 * Sets the value of the '{@link ac.soton.fmusim.components.EventBComponent#getMachine <em>Machine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Machine</em>' reference.
	 * @see #getMachine()
	 * @generated
	 */
	void setMachine(Machine value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean hasValidMachineReference(DiagnosticChain diagnostics, Map<Object, Object> context);

} // EventBComponent
