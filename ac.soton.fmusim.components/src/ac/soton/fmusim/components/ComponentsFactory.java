/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ac.soton.fmusim.components.ComponentsPackage
 * @generated
 */
public interface ComponentsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComponentsFactory eINSTANCE = ac.soton.fmusim.components.impl.ComponentsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Component Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Diagram</em>'.
	 * @generated
	 */
	ComponentDiagram createComponentDiagram();

	/**
	 * Returns a new object of class '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connector</em>'.
	 * @generated
	 */
	Connector createConnector();

	/**
	 * Returns a new object of class '<em>Event BComponent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event BComponent</em>'.
	 * @generated
	 */
	EventBComponent createEventBComponent();

	/**
	 * Returns a new object of class '<em>FMU Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FMU Component</em>'.
	 * @generated
	 */
	FMUComponent createFMUComponent();

	/**
	 * Returns a new object of class '<em>FMU Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FMU Port</em>'.
	 * @generated
	 */
	FMUPort createFMUPort();

	/**
	 * Returns a new object of class '<em>Event BPort</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event BPort</em>'.
	 * @generated
	 */
	EventBPort createEventBPort();

	/**
	 * Returns a new object of class '<em>FMU Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FMU Variable</em>'.
	 * @generated
	 */
	FMUVariable createFMUVariable();

	/**
	 * Returns a new object of class '<em>Event BVariable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event BVariable</em>'.
	 * @generated
	 */
	EventBVariable createEventBVariable();

	/**
	 * Returns a new object of class '<em>Display Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Display Component</em>'.
	 * @generated
	 */
	DisplayComponent createDisplayComponent();

	/**
	 * Returns a new object of class '<em>Display Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Display Port</em>'.
	 * @generated
	 */
	DisplayPort createDisplayPort();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ComponentsPackage getComponentsPackage();

} //ComponentsFactory
