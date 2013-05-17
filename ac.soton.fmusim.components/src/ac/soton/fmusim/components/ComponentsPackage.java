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
import org.eventb.emf.core.CorePackage;

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
	 * NOT GENERATED!
	 * The default value of the Event-B Component extension id.
	 */
	String EVENTB_COMPONENT_EXTENSION_ID = "ac.soton.fmusim.components.eventb";

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
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__TIME = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Component Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

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
	 * The meta object id for the '{@link ac.soton.fmusim.components.impl.AbstractVariableImpl <em>Abstract Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.fmusim.components.impl.AbstractVariableImpl
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getAbstractVariable()
	 * @generated
	 */
	int ABSTRACT_VARIABLE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Causality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__CAUSALITY = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Abstract Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

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
	int PORT__NAME = ABSTRACT_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__TYPE = ABSTRACT_VARIABLE__TYPE;

	/**
	 * The feature id for the '<em><b>Causality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__CAUSALITY = ABSTRACT_VARIABLE__CAUSALITY;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__CONNECTOR = ABSTRACT_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = ABSTRACT_VARIABLE_FEATURE_COUNT + 1;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__ANNOTATIONS = CorePackage.ABSTRACT_EXTENSION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__EXTENSIONS = CorePackage.ABSTRACT_EXTENSION__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__ATTRIBUTES = CorePackage.ABSTRACT_EXTENSION__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__REFERENCE = CorePackage.ABSTRACT_EXTENSION__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__GENERATED = CorePackage.ABSTRACT_EXTENSION__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__LOCAL_GENERATED = CorePackage.ABSTRACT_EXTENSION__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Extension Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__EXTENSION_ID = CorePackage.ABSTRACT_EXTENSION__EXTENSION_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__NAME = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__INPUTS = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__OUTPUTS = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Composed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__COMPOSED = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__MACHINE = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Read Inputs Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__READ_INPUTS_EVENT = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Write Outputs Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__WRITE_OUTPUTS_EVENT = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Time Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__TIME_VARIABLE = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__VARIABLES = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Update Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__UPDATE_EVENT = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Event BComponent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT_FEATURE_COUNT = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 10;

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
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT__TYPE = PORT__TYPE;

	/**
	 * The feature id for the '<em><b>Causality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT__CAUSALITY = PORT__CAUSALITY;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT__CONNECTOR = PORT__CONNECTOR;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT__VALUE = PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT__DESCRIPTION = PORT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>FMU Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 2;

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
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__TYPE = PORT__TYPE;

	/**
	 * The feature id for the '<em><b>Causality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__CAUSALITY = PORT__CAUSALITY;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__CONNECTOR = PORT__CONNECTOR;

	/**
	 * The feature id for the '<em><b>Event Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__EVENT_PARAMETER = PORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Event BPort</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ac.soton.fmusim.components.impl.FMUVariableImpl <em>FMU Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.fmusim.components.impl.FMUVariableImpl
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getFMUVariable()
	 * @generated
	 */
	int FMU_VARIABLE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_VARIABLE__NAME = ABSTRACT_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_VARIABLE__TYPE = ABSTRACT_VARIABLE__TYPE;

	/**
	 * The feature id for the '<em><b>Causality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_VARIABLE__CAUSALITY = ABSTRACT_VARIABLE__CAUSALITY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_VARIABLE__VALUE = ABSTRACT_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_VARIABLE__DESCRIPTION = ABSTRACT_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>FMU Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_VARIABLE_FEATURE_COUNT = ABSTRACT_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ac.soton.fmusim.components.impl.EventBVariableImpl <em>Event BVariable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.fmusim.components.impl.EventBVariableImpl
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getEventBVariable()
	 * @generated
	 */
	int EVENT_BVARIABLE = 11;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BVARIABLE__VARIABLE = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BVARIABLE__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BVARIABLE__NAME = 2;

	/**
	 * The number of structural features of the '<em>Event BVariable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BVARIABLE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link ac.soton.fmusim.components.VariableType <em>Variable Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.fmusim.components.VariableType
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getVariableType()
	 * @generated
	 */
	int VARIABLE_TYPE = 12;

	/**
	 * The meta object id for the '{@link ac.soton.fmusim.components.VariableCausality <em>Variable Causality</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.fmusim.components.VariableCausality
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getVariableCausality()
	 * @generated
	 */
	int VARIABLE_CAUSALITY = 13;

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
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.ComponentDiagram#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see ac.soton.fmusim.components.ComponentDiagram#getTime()
	 * @see #getComponentDiagram()
	 * @generated
	 */
	EAttribute getComponentDiagram_Time();

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
	 * Returns the meta object for the reference '{@link ac.soton.fmusim.components.EventBComponent#getReadInputsEvent <em>Read Inputs Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Read Inputs Event</em>'.
	 * @see ac.soton.fmusim.components.EventBComponent#getReadInputsEvent()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EReference getEventBComponent_ReadInputsEvent();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.fmusim.components.EventBComponent#getWriteOutputsEvent <em>Write Outputs Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Write Outputs Event</em>'.
	 * @see ac.soton.fmusim.components.EventBComponent#getWriteOutputsEvent()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EReference getEventBComponent_WriteOutputsEvent();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.fmusim.components.EventBComponent#getTimeVariable <em>Time Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Time Variable</em>'.
	 * @see ac.soton.fmusim.components.EventBComponent#getTimeVariable()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EReference getEventBComponent_TimeVariable();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.fmusim.components.EventBComponent#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see ac.soton.fmusim.components.EventBComponent#getVariables()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EReference getEventBComponent_Variables();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.fmusim.components.EventBComponent#getUpdateEvent <em>Update Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Update Event</em>'.
	 * @see ac.soton.fmusim.components.EventBComponent#getUpdateEvent()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EReference getEventBComponent_UpdateEvent();

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
	 * Returns the meta object for class '{@link ac.soton.fmusim.components.EventBPort <em>Event BPort</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event BPort</em>'.
	 * @see ac.soton.fmusim.components.EventBPort
	 * @generated
	 */
	EClass getEventBPort();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.fmusim.components.EventBPort#getEventParameter <em>Event Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event Parameter</em>'.
	 * @see ac.soton.fmusim.components.EventBPort#getEventParameter()
	 * @see #getEventBPort()
	 * @generated
	 */
	EReference getEventBPort_EventParameter();

	/**
	 * Returns the meta object for class '{@link ac.soton.fmusim.components.FMUVariable <em>FMU Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FMU Variable</em>'.
	 * @see ac.soton.fmusim.components.FMUVariable
	 * @generated
	 */
	EClass getFMUVariable();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.FMUVariable#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see ac.soton.fmusim.components.FMUVariable#getValue()
	 * @see #getFMUVariable()
	 * @generated
	 */
	EAttribute getFMUVariable_Value();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.FMUVariable#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see ac.soton.fmusim.components.FMUVariable#getDescription()
	 * @see #getFMUVariable()
	 * @generated
	 */
	EAttribute getFMUVariable_Description();

	/**
	 * Returns the meta object for class '{@link ac.soton.fmusim.components.AbstractVariable <em>Abstract Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Variable</em>'.
	 * @see ac.soton.fmusim.components.AbstractVariable
	 * @generated
	 */
	EClass getAbstractVariable();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.AbstractVariable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see ac.soton.fmusim.components.AbstractVariable#getType()
	 * @see #getAbstractVariable()
	 * @generated
	 */
	EAttribute getAbstractVariable_Type();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.AbstractVariable#getCausality <em>Causality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Causality</em>'.
	 * @see ac.soton.fmusim.components.AbstractVariable#getCausality()
	 * @see #getAbstractVariable()
	 * @generated
	 */
	EAttribute getAbstractVariable_Causality();

	/**
	 * Returns the meta object for class '{@link ac.soton.fmusim.components.EventBVariable <em>Event BVariable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event BVariable</em>'.
	 * @see ac.soton.fmusim.components.EventBVariable
	 * @generated
	 */
	EClass getEventBVariable();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.fmusim.components.EventBVariable#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see ac.soton.fmusim.components.EventBVariable#getVariable()
	 * @see #getEventBVariable()
	 * @generated
	 */
	EReference getEventBVariable_Variable();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.EventBVariable#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see ac.soton.fmusim.components.EventBVariable#getValue()
	 * @see #getEventBVariable()
	 * @generated
	 */
	EAttribute getEventBVariable_Value();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.EventBVariable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ac.soton.fmusim.components.EventBVariable#getName()
	 * @see #getEventBVariable()
	 * @generated
	 */
	EAttribute getEventBVariable_Name();

	/**
	 * Returns the meta object for enum '{@link ac.soton.fmusim.components.VariableType <em>Variable Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variable Type</em>'.
	 * @see ac.soton.fmusim.components.VariableType
	 * @generated
	 */
	EEnum getVariableType();

	/**
	 * Returns the meta object for enum '{@link ac.soton.fmusim.components.VariableCausality <em>Variable Causality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variable Causality</em>'.
	 * @see ac.soton.fmusim.components.VariableCausality
	 * @generated
	 */
	EEnum getVariableCausality();

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
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_DIAGRAM__TIME = eINSTANCE.getComponentDiagram_Time();

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
		 * The meta object literal for the '<em><b>Machine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_BCOMPONENT__MACHINE = eINSTANCE.getEventBComponent_Machine();

		/**
		 * The meta object literal for the '<em><b>Read Inputs Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_BCOMPONENT__READ_INPUTS_EVENT = eINSTANCE.getEventBComponent_ReadInputsEvent();

		/**
		 * The meta object literal for the '<em><b>Write Outputs Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_BCOMPONENT__WRITE_OUTPUTS_EVENT = eINSTANCE.getEventBComponent_WriteOutputsEvent();

		/**
		 * The meta object literal for the '<em><b>Time Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_BCOMPONENT__TIME_VARIABLE = eINSTANCE.getEventBComponent_TimeVariable();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_BCOMPONENT__VARIABLES = eINSTANCE.getEventBComponent_Variables();

		/**
		 * The meta object literal for the '<em><b>Update Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_BCOMPONENT__UPDATE_EVENT = eINSTANCE.getEventBComponent_UpdateEvent();

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
		 * The meta object literal for the '{@link ac.soton.fmusim.components.impl.EventBPortImpl <em>Event BPort</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.fmusim.components.impl.EventBPortImpl
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getEventBPort()
		 * @generated
		 */
		EClass EVENT_BPORT = eINSTANCE.getEventBPort();

		/**
		 * The meta object literal for the '<em><b>Event Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_BPORT__EVENT_PARAMETER = eINSTANCE.getEventBPort_EventParameter();

		/**
		 * The meta object literal for the '{@link ac.soton.fmusim.components.impl.FMUVariableImpl <em>FMU Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.fmusim.components.impl.FMUVariableImpl
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getFMUVariable()
		 * @generated
		 */
		EClass FMU_VARIABLE = eINSTANCE.getFMUVariable();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU_VARIABLE__VALUE = eINSTANCE.getFMUVariable_Value();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU_VARIABLE__DESCRIPTION = eINSTANCE.getFMUVariable_Description();

		/**
		 * The meta object literal for the '{@link ac.soton.fmusim.components.impl.AbstractVariableImpl <em>Abstract Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.fmusim.components.impl.AbstractVariableImpl
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getAbstractVariable()
		 * @generated
		 */
		EClass ABSTRACT_VARIABLE = eINSTANCE.getAbstractVariable();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_VARIABLE__TYPE = eINSTANCE.getAbstractVariable_Type();

		/**
		 * The meta object literal for the '<em><b>Causality</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_VARIABLE__CAUSALITY = eINSTANCE.getAbstractVariable_Causality();

		/**
		 * The meta object literal for the '{@link ac.soton.fmusim.components.impl.EventBVariableImpl <em>Event BVariable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.fmusim.components.impl.EventBVariableImpl
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getEventBVariable()
		 * @generated
		 */
		EClass EVENT_BVARIABLE = eINSTANCE.getEventBVariable();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_BVARIABLE__VARIABLE = eINSTANCE.getEventBVariable_Variable();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_BVARIABLE__VALUE = eINSTANCE.getEventBVariable_Value();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_BVARIABLE__NAME = eINSTANCE.getEventBVariable_Name();

		/**
		 * The meta object literal for the '{@link ac.soton.fmusim.components.VariableType <em>Variable Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.fmusim.components.VariableType
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getVariableType()
		 * @generated
		 */
		EEnum VARIABLE_TYPE = eINSTANCE.getVariableType();

		/**
		 * The meta object literal for the '{@link ac.soton.fmusim.components.VariableCausality <em>Variable Causality</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.fmusim.components.VariableCausality
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getVariableCausality()
		 * @generated
		 */
		EEnum VARIABLE_CAUSALITY = eINSTANCE.getVariableCausality();

	}

} //ComponentsPackage
