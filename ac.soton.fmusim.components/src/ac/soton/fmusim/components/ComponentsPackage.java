/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ac.soton.fmusim.components.ComponentsFactory
 * @model kind="package"
 * @generated
 */
public interface ComponentsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "components";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://soton.ac.uk/models/fmusim/components/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "components";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComponentsPackage eINSTANCE = ac.soton.fmusim.components.impl.ComponentsPackageImpl.init();

	/**
	 * The meta object id for the '{@link ac.soton.fmusim.components.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.fmusim.components.impl.NamedElementImpl
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link ac.soton.fmusim.components.impl.ComponentDiagramImpl <em>Component Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.fmusim.components.impl.ComponentDiagramImpl
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getComponentDiagram()
	 * @generated
	 */
	int COMPONENT_DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__COMPONENTS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__CONNECTORS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Component Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ac.soton.fmusim.components.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.fmusim.components.impl.ComponentImpl
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__INPUTS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__OUTPUTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ac.soton.fmusim.components.impl.ConnectorImpl <em>Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.fmusim.components.impl.ConnectorImpl
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getConnector()
	 * @generated
	 */
	int CONNECTOR = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__VALUE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__PORTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ac.soton.fmusim.components.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.fmusim.components.impl.PortImpl
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__CONNECTOR = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__KIND = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link ac.soton.fmusim.components.impl.EventBComponentImpl <em>Event BComponent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.fmusim.components.impl.EventBComponentImpl
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getEventBComponent()
	 * @generated
	 */
	int EVENT_BCOMPONENT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__NAME = COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__INPUTS = COMPONENT__INPUTS;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__OUTPUTS = COMPONENT__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Composed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__COMPOSED = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Time Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__TIME_VARIABLE_NAME = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__MACHINE = COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Event BComponent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link ac.soton.fmusim.components.impl.FMUComponentImpl <em>FMU Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.fmusim.components.impl.FMUComponentImpl
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getFMUComponent()
	 * @generated
	 */
	int FMU_COMPONENT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT__NAME = COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT__INPUTS = COMPONENT__INPUTS;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT__OUTPUTS = COMPONENT__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Fmu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT__FMU = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT__VARIABLES = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT__PATH = COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>FMU Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link ac.soton.fmusim.components.impl.FMUPortImpl <em>FMU Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.fmusim.components.impl.FMUPortImpl
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getFMUPort()
	 * @generated
	 */
	int FMU_PORT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT__NAME = PORT__NAME;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT__CONNECTOR = PORT__CONNECTOR;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT__TYPE = PORT__TYPE;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT__KIND = PORT__KIND;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT__VARIABLE = PORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>FMU Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ac.soton.fmusim.components.impl.EventBPortImpl <em>Event BPort</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.fmusim.components.impl.EventBPortImpl
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getEventBPort()
	 * @generated
	 */
	int EVENT_BPORT = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__NAME = PORT__NAME;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__CONNECTOR = PORT__CONNECTOR;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__TYPE = PORT__TYPE;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__KIND = PORT__KIND;

	/**
	 * The feature id for the '<em><b>Fmi Get Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__FMI_GET_EVENT = PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fmi Set Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__FMI_SET_EVENT = PORT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Event BPort</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ac.soton.fmusim.components.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.fmusim.components.impl.VariableImpl
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__VALUE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ac.soton.fmusim.components.FmiTypes <em>Fmi Types</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.fmusim.components.FmiTypes
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getFmiTypes()
	 * @generated
	 */
	int FMI_TYPES = 10;

	/**
	 * The meta object id for the '{@link ac.soton.fmusim.components.PortKind <em>Port Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.fmusim.components.PortKind
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getPortKind()
	 * @generated
	 */
	int PORT_KIND = 11;


	/**
	 * Returns the meta object for class '{@link ac.soton.fmusim.components.ComponentDiagram <em>Component Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Diagram</em>'.
	 * @see ac.soton.fmusim.components.ComponentDiagram
	 * @generated
	 */
	EClass getComponentDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.fmusim.components.ComponentDiagram#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see ac.soton.fmusim.components.ComponentDiagram#getComponents()
	 * @see #getComponentDiagram()
	 * @generated
	 */
	EReference getComponentDiagram_Components();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.fmusim.components.ComponentDiagram#getConnectors <em>Connectors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connectors</em>'.
	 * @see ac.soton.fmusim.components.ComponentDiagram#getConnectors()
	 * @see #getComponentDiagram()
	 * @generated
	 */
	EReference getComponentDiagram_Connectors();

	/**
	 * Returns the meta object for class '{@link ac.soton.fmusim.components.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see ac.soton.fmusim.components.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.fmusim.components.Component#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see ac.soton.fmusim.components.Component#getInputs()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Inputs();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.fmusim.components.Component#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outputs</em>'.
	 * @see ac.soton.fmusim.components.Component#getOutputs()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Outputs();

	/**
	 * Returns the meta object for class '{@link ac.soton.fmusim.components.Connector <em>Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector</em>'.
	 * @see ac.soton.fmusim.components.Connector
	 * @generated
	 */
	EClass getConnector();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.Connector#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see ac.soton.fmusim.components.Connector#getValue()
	 * @see #getConnector()
	 * @generated
	 */
	EAttribute getConnector_Value();

	/**
	 * Returns the meta object for the reference list '{@link ac.soton.fmusim.components.Connector#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ports</em>'.
	 * @see ac.soton.fmusim.components.Connector#getPorts()
	 * @see #getConnector()
	 * @generated
	 */
	EReference getConnector_Ports();

	/**
	 * Returns the meta object for class '{@link ac.soton.fmusim.components.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see ac.soton.fmusim.components.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.fmusim.components.Port#getConnector <em>Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Connector</em>'.
	 * @see ac.soton.fmusim.components.Port#getConnector()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Connector();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.Port#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see ac.soton.fmusim.components.Port#getType()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Type();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.Port#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see ac.soton.fmusim.components.Port#getKind()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Kind();

	/**
	 * Returns the meta object for class '{@link ac.soton.fmusim.components.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see ac.soton.fmusim.components.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ac.soton.fmusim.components.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link ac.soton.fmusim.components.EventBComponent <em>Event BComponent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event BComponent</em>'.
	 * @see ac.soton.fmusim.components.EventBComponent
	 * @generated
	 */
	EClass getEventBComponent();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.EventBComponent#isComposed <em>Composed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Composed</em>'.
	 * @see ac.soton.fmusim.components.EventBComponent#isComposed()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EAttribute getEventBComponent_Composed();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.EventBComponent#getTimeVariableName <em>Time Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Variable Name</em>'.
	 * @see ac.soton.fmusim.components.EventBComponent#getTimeVariableName()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EAttribute getEventBComponent_TimeVariableName();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.fmusim.components.EventBComponent#getMachine <em>Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Machine</em>'.
	 * @see ac.soton.fmusim.components.EventBComponent#getMachine()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EReference getEventBComponent_Machine();

	/**
	 * Returns the meta object for class '{@link ac.soton.fmusim.components.FMUComponent <em>FMU Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FMU Component</em>'.
	 * @see ac.soton.fmusim.components.FMUComponent
	 * @generated
	 */
	EClass getFMUComponent();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.FMUComponent#getFmu <em>Fmu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fmu</em>'.
	 * @see ac.soton.fmusim.components.FMUComponent#getFmu()
	 * @see #getFMUComponent()
	 * @generated
	 */
	EAttribute getFMUComponent_Fmu();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.fmusim.components.FMUComponent#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see ac.soton.fmusim.components.FMUComponent#getVariables()
	 * @see #getFMUComponent()
	 * @generated
	 */
	EReference getFMUComponent_Variables();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.FMUComponent#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see ac.soton.fmusim.components.FMUComponent#getPath()
	 * @see #getFMUComponent()
	 * @generated
	 */
	EAttribute getFMUComponent_Path();

	/**
	 * Returns the meta object for class '{@link ac.soton.fmusim.components.FMUPort <em>FMU Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FMU Port</em>'.
	 * @see ac.soton.fmusim.components.FMUPort
	 * @generated
	 */
	EClass getFMUPort();

	/**
	 * Returns the meta object for the containment reference '{@link ac.soton.fmusim.components.FMUPort#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable</em>'.
	 * @see ac.soton.fmusim.components.FMUPort#getVariable()
	 * @see #getFMUPort()
	 * @generated
	 */
	EReference getFMUPort_Variable();

	/**
	 * Returns the meta object for class '{@link ac.soton.fmusim.components.EventBPort <em>Event BPort</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event BPort</em>'.
	 * @see ac.soton.fmusim.components.EventBPort
	 * @generated
	 */
	EClass getEventBPort();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.fmusim.components.EventBPort#getFmiGetEvent <em>Fmi Get Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Fmi Get Event</em>'.
	 * @see ac.soton.fmusim.components.EventBPort#getFmiGetEvent()
	 * @see #getEventBPort()
	 * @generated
	 */
	EReference getEventBPort_FmiGetEvent();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.fmusim.components.EventBPort#getFmiSetEvent <em>Fmi Set Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Fmi Set Event</em>'.
	 * @see ac.soton.fmusim.components.EventBPort#getFmiSetEvent()
	 * @see #getEventBPort()
	 * @generated
	 */
	EReference getEventBPort_FmiSetEvent();

	/**
	 * Returns the meta object for class '{@link ac.soton.fmusim.components.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see ac.soton.fmusim.components.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.Variable#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see ac.soton.fmusim.components.Variable#getValue()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Value();

	/**
	 * Returns the meta object for enum '{@link ac.soton.fmusim.components.FmiTypes <em>Fmi Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Fmi Types</em>'.
	 * @see ac.soton.fmusim.components.FmiTypes
	 * @generated
	 */
	EEnum getFmiTypes();

	/**
	 * Returns the meta object for enum '{@link ac.soton.fmusim.components.PortKind <em>Port Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Port Kind</em>'.
	 * @see ac.soton.fmusim.components.PortKind
	 * @generated
	 */
	EEnum getPortKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ComponentsFactory getComponentsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link ac.soton.fmusim.components.impl.ComponentDiagramImpl <em>Component Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.fmusim.components.impl.ComponentDiagramImpl
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getComponentDiagram()
		 * @generated
		 */
		EClass COMPONENT_DIAGRAM = eINSTANCE.getComponentDiagram();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_DIAGRAM__COMPONENTS = eINSTANCE.getComponentDiagram_Components();

		/**
		 * The meta object literal for the '<em><b>Connectors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_DIAGRAM__CONNECTORS = eINSTANCE.getComponentDiagram_Connectors();

		/**
		 * The meta object literal for the '{@link ac.soton.fmusim.components.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.fmusim.components.impl.ComponentImpl
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__INPUTS = eINSTANCE.getComponent_Inputs();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__OUTPUTS = eINSTANCE.getComponent_Outputs();

		/**
		 * The meta object literal for the '{@link ac.soton.fmusim.components.impl.ConnectorImpl <em>Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.fmusim.components.impl.ConnectorImpl
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getConnector()
		 * @generated
		 */
		EClass CONNECTOR = eINSTANCE.getConnector();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR__VALUE = eINSTANCE.getConnector_Value();

		/**
		 * The meta object literal for the '<em><b>Ports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR__PORTS = eINSTANCE.getConnector_Ports();

		/**
		 * The meta object literal for the '{@link ac.soton.fmusim.components.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.fmusim.components.impl.PortImpl
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__CONNECTOR = eINSTANCE.getPort_Connector();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__TYPE = eINSTANCE.getPort_Type();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__KIND = eINSTANCE.getPort_Kind();

		/**
		 * The meta object literal for the '{@link ac.soton.fmusim.components.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.fmusim.components.impl.NamedElementImpl
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link ac.soton.fmusim.components.impl.EventBComponentImpl <em>Event BComponent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.fmusim.components.impl.EventBComponentImpl
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getEventBComponent()
		 * @generated
		 */
		EClass EVENT_BCOMPONENT = eINSTANCE.getEventBComponent();

		/**
		 * The meta object literal for the '<em><b>Composed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_BCOMPONENT__COMPOSED = eINSTANCE.getEventBComponent_Composed();

		/**
		 * The meta object literal for the '<em><b>Time Variable Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_BCOMPONENT__TIME_VARIABLE_NAME = eINSTANCE.getEventBComponent_TimeVariableName();

		/**
		 * The meta object literal for the '<em><b>Machine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_BCOMPONENT__MACHINE = eINSTANCE.getEventBComponent_Machine();

		/**
		 * The meta object literal for the '{@link ac.soton.fmusim.components.impl.FMUComponentImpl <em>FMU Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.fmusim.components.impl.FMUComponentImpl
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getFMUComponent()
		 * @generated
		 */
		EClass FMU_COMPONENT = eINSTANCE.getFMUComponent();

		/**
		 * The meta object literal for the '<em><b>Fmu</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU_COMPONENT__FMU = eINSTANCE.getFMUComponent_Fmu();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMU_COMPONENT__VARIABLES = eINSTANCE.getFMUComponent_Variables();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU_COMPONENT__PATH = eINSTANCE.getFMUComponent_Path();

		/**
		 * The meta object literal for the '{@link ac.soton.fmusim.components.impl.FMUPortImpl <em>FMU Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.fmusim.components.impl.FMUPortImpl
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getFMUPort()
		 * @generated
		 */
		EClass FMU_PORT = eINSTANCE.getFMUPort();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMU_PORT__VARIABLE = eINSTANCE.getFMUPort_Variable();

		/**
		 * The meta object literal for the '{@link ac.soton.fmusim.components.impl.EventBPortImpl <em>Event BPort</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.fmusim.components.impl.EventBPortImpl
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getEventBPort()
		 * @generated
		 */
		EClass EVENT_BPORT = eINSTANCE.getEventBPort();

		/**
		 * The meta object literal for the '<em><b>Fmi Get Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_BPORT__FMI_GET_EVENT = eINSTANCE.getEventBPort_FmiGetEvent();

		/**
		 * The meta object literal for the '<em><b>Fmi Set Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_BPORT__FMI_SET_EVENT = eINSTANCE.getEventBPort_FmiSetEvent();

		/**
		 * The meta object literal for the '{@link ac.soton.fmusim.components.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.fmusim.components.impl.VariableImpl
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__VALUE = eINSTANCE.getVariable_Value();

		/**
		 * The meta object literal for the '{@link ac.soton.fmusim.components.FmiTypes <em>Fmi Types</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.fmusim.components.FmiTypes
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getFmiTypes()
		 * @generated
		 */
		EEnum FMI_TYPES = eINSTANCE.getFmiTypes();

		/**
		 * The meta object literal for the '{@link ac.soton.fmusim.components.PortKind <em>Port Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.fmusim.components.PortKind
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getPortKind()
		 * @generated
		 */
		EEnum PORT_KIND = eINSTANCE.getPortKind();

	}

} //ComponentsPackage
