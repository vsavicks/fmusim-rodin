/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components;

import org.eclipse.emf.common.util.EList;

import ac.soton.fmusim.components.exceptions.ModelException;
import ac.soton.fmusim.components.exceptions.SimulationException;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.fmusim.components.Component#getInputs <em>Inputs</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.Component#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.Component#getVariables <em>Variables</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.Component#getStepPeriod <em>Step Period</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.fmusim.components.ComponentsPackage#getComponent()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Component extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.fmusim.components.Port}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' containment reference list.
	 * @see ac.soton.fmusim.components.ComponentsPackage#getComponent_Inputs()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Port> getInputs();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.fmusim.components.Port}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' containment reference list.
	 * @see ac.soton.fmusim.components.ComponentsPackage#getComponent_Outputs()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Port> getOutputs();

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.fmusim.components.AbstractVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see ac.soton.fmusim.components.ComponentsPackage#getComponent_Variables()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<AbstractVariable> getVariables();

	/**
	 * Returns the value of the '<em><b>Step Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Period</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Period</em>' attribute.
	 * @see #setStepPeriod(long)
	 * @see ac.soton.fmusim.components.ComponentsPackage#getComponent_StepPeriod()
	 * @model
	 * @generated
	 */
	long getStepPeriod();

	/**
	 * Sets the value of the '{@link ac.soton.fmusim.components.Component#getStepPeriod <em>Step Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Period</em>' attribute.
	 * @see #getStepPeriod()
	 * @generated
	 */
	void setStepPeriod(long value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void initialise(long tStart, long tStop);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="ac.soton.fmusim.components.SimExceptionClass ac.soton.fmusim.components.ModelExceptionClass"
	 * @generated
	 */
	void readInputs() throws SimulationException, ModelException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="ac.soton.fmusim.components.SimExceptionClass ac.soton.fmusim.components.ModelExceptionClass"
	 * @generated
	 */
	void writeOutputs() throws SimulationException, ModelException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="ac.soton.fmusim.components.SimExceptionClass ac.soton.fmusim.components.ModelExceptionClass"
	 * @generated
	 */
	void doStep(long time, long step) throws SimulationException, ModelException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void terminate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="ac.soton.fmusim.components.SimExceptionClass"
	 * @generated
	 */
	void instantiate() throws SimulationException;

} // Component
