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
import org.eclipse.emf.ecore.EDataType;
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
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__START_TIME = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Stop Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__STOP_TIME = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Step Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__STEP_SIZE = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Component Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link ac.soton.fmusim.components.Component <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.fmusim.components.Component
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
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__VARIABLES = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Step Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__STEP_PERIOD = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

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
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__VALUE = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__DESCRIPTION = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Abstract Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

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
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__VALUE = ABSTRACT_VARIABLE__VALUE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__DESCRIPTION = ABSTRACT_VARIABLE__DESCRIPTION;

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
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__VARIABLES = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Step Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__STEP_PERIOD = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Composed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__COMPOSED = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__MACHINE = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Read Input Events</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__READ_INPUT_EVENTS = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Time Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__TIME_VARIABLE = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Wait Events</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__WAIT_EVENTS = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__TRACE = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Trace Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT__TRACE_PATH = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Event BComponent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BCOMPONENT_FEATURE_COUNT = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 12;

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
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT__VARIABLES = COMPONENT__VARIABLES;

	/**
	 * The feature id for the '<em><b>Step Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT__STEP_PERIOD = COMPONENT__STEP_PERIOD;

	/**
	 * The feature id for the '<em><b>Fmu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT__FMU = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT__PATH = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_COMPONENT__PARAMETERS = COMPONENT_FEATURE_COUNT + 2;

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
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT__VALUE = PORT__VALUE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT__DESCRIPTION = PORT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT__CONNECTOR = PORT__CONNECTOR;

	/**
	 * The number of structural features of the '<em>FMU Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__VALUE = PORT__VALUE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__DESCRIPTION = PORT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__CONNECTOR = PORT__CONNECTOR;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__PARAMETER = PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__VARIABLE = PORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Real Precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT__REAL_PRECISION = PORT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Event BPort</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BPORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 3;

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
	int FMU_VARIABLE__VALUE = ABSTRACT_VARIABLE__VALUE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_VARIABLE__DESCRIPTION = ABSTRACT_VARIABLE__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>FMU Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_VARIABLE_FEATURE_COUNT = ABSTRACT_VARIABLE_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BVARIABLE__NAME = ABSTRACT_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BVARIABLE__TYPE = ABSTRACT_VARIABLE__TYPE;

	/**
	 * The feature id for the '<em><b>Causality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BVARIABLE__CAUSALITY = ABSTRACT_VARIABLE__CAUSALITY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BVARIABLE__VALUE = ABSTRACT_VARIABLE__VALUE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BVARIABLE__DESCRIPTION = ABSTRACT_VARIABLE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BVARIABLE__VARIABLE = ABSTRACT_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Event BVariable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BVARIABLE_FEATURE_COUNT = ABSTRACT_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ac.soton.fmusim.components.impl.DisplayComponentImpl <em>Display Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.fmusim.components.impl.DisplayComponentImpl
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getDisplayComponent()
	 * @generated
	 */
	int DISPLAY_COMPONENT = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_COMPONENT__NAME = COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_COMPONENT__INPUTS = COMPONENT__INPUTS;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_COMPONENT__OUTPUTS = COMPONENT__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_COMPONENT__VARIABLES = COMPONENT__VARIABLES;

	/**
	 * The feature id for the '<em><b>Step Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_COMPONENT__STEP_PERIOD = COMPONENT__STEP_PERIOD;

	/**
	 * The feature id for the '<em><b>Chart</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_COMPONENT__CHART = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Display Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ac.soton.fmusim.components.impl.DisplayPortImpl <em>Display Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.fmusim.components.impl.DisplayPortImpl
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getDisplayPort()
	 * @generated
	 */
	int DISPLAY_PORT = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_PORT__NAME = PORT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_PORT__TYPE = PORT__TYPE;

	/**
	 * The feature id for the '<em><b>Causality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_PORT__CAUSALITY = PORT__CAUSALITY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_PORT__VALUE = PORT__VALUE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_PORT__DESCRIPTION = PORT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_PORT__CONNECTOR = PORT__CONNECTOR;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_PORT__TRACE = PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Colour</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_PORT__COLOUR = PORT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Display Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ac.soton.fmusim.components.impl.FMUParameterImpl <em>FMU Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.fmusim.components.impl.FMUParameterImpl
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getFMUParameter()
	 * @generated
	 */
	int FMU_PARAMETER = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PARAMETER__NAME = FMU_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PARAMETER__TYPE = FMU_VARIABLE__TYPE;

	/**
	 * The feature id for the '<em><b>Causality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PARAMETER__CAUSALITY = FMU_VARIABLE__CAUSALITY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PARAMETER__VALUE = FMU_VARIABLE__VALUE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PARAMETER__DESCRIPTION = FMU_VARIABLE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PARAMETER__DEFAULT_VALUE = FMU_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Start Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PARAMETER__START_VALUE = FMU_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>FMU Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_PARAMETER_FEATURE_COUNT = FMU_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ac.soton.fmusim.components.VariableType <em>Variable Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.fmusim.components.VariableType
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getVariableType()
	 * @generated
	 */
	int VARIABLE_TYPE = 15;

	/**
	 * The meta object id for the '{@link ac.soton.fmusim.components.VariableCausality <em>Variable Causality</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.fmusim.components.VariableCausality
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getVariableCausality()
	 * @generated
	 */
	int VARIABLE_CAUSALITY = 16;

	/**
	 * The meta object id for the '{@link ac.soton.fmusim.components.Colour <em>Colour</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.fmusim.components.Colour
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getColour()
	 * @generated
	 */
	int COLOUR = 17;

	/**
	 * The meta object id for the '<em>Fmu Class</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.prob.cosimulation.FMU
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getFmuClass()
	 * @generated
	 */
	int FMU_CLASS = 18;

	/**
	 * The meta object id for the '<em>Trace Class</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.prob.statespace.Trace
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getTraceClass()
	 * @generated
	 */
	int TRACE_CLASS = 19;

	/**
	 * The meta object id for the '<em>Trace2 DClass</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see info.monitorenter.gui.chart.ITrace2D
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getTrace2DClass()
	 * @generated
	 */
	int TRACE2_DCLASS = 20;

	/**
	 * The meta object id for the '<em>Chart2 DClass</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see info.monitorenter.gui.chart.Chart2D
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getChart2DClass()
	 * @generated
	 */
	int CHART2_DCLASS = 21;

	/**
	 * The meta object id for the '<em>Sim Exception Class</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.fmusim.components.exceptions.SimulationException
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getSimExceptionClass()
	 * @generated
	 */
	int SIM_EXCEPTION_CLASS = 22;

	/**
	 * The meta object id for the '<em>Model Exception Class</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.fmusim.components.exceptions.ModelException
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getModelExceptionClass()
	 * @generated
	 */
	int MODEL_EXCEPTION_CLASS = 23;

	/**
	 * The meta object id for the '<em>Real Class</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jscience.mathematics.number.Real
	 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getRealClass()
	 * @generated
	 */
	int REAL_CLASS = 24;

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
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.ComponentDiagram#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see ac.soton.fmusim.components.ComponentDiagram#getStartTime()
	 * @see #getComponentDiagram()
	 * @generated
	 */
	EAttribute getComponentDiagram_StartTime();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.ComponentDiagram#getStopTime <em>Stop Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stop Time</em>'.
	 * @see ac.soton.fmusim.components.ComponentDiagram#getStopTime()
	 * @see #getComponentDiagram()
	 * @generated
	 */
	EAttribute getComponentDiagram_StopTime();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.ComponentDiagram#getStepSize <em>Step Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Size</em>'.
	 * @see ac.soton.fmusim.components.ComponentDiagram#getStepSize()
	 * @see #getComponentDiagram()
	 * @generated
	 */
	EAttribute getComponentDiagram_StepSize();

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
	 * Returns the meta object for the containment reference list '{@link ac.soton.fmusim.components.Component#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see ac.soton.fmusim.components.Component#getVariables()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Variables();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.Component#getStepPeriod <em>Step Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Period</em>'.
	 * @see ac.soton.fmusim.components.Component#getStepPeriod()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_StepPeriod();

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
	 * Returns the meta object for the reference list '{@link ac.soton.fmusim.components.EventBComponent#getReadInputEvents <em>Read Input Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Read Input Events</em>'.
	 * @see ac.soton.fmusim.components.EventBComponent#getReadInputEvents()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EReference getEventBComponent_ReadInputEvents();

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
	 * Returns the meta object for the reference list '{@link ac.soton.fmusim.components.EventBComponent#getWaitEvents <em>Wait Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Wait Events</em>'.
	 * @see ac.soton.fmusim.components.EventBComponent#getWaitEvents()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EReference getEventBComponent_WaitEvents();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.EventBComponent#getTrace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trace</em>'.
	 * @see ac.soton.fmusim.components.EventBComponent#getTrace()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EAttribute getEventBComponent_Trace();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.EventBComponent#getTracePath <em>Trace Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trace Path</em>'.
	 * @see ac.soton.fmusim.components.EventBComponent#getTracePath()
	 * @see #getEventBComponent()
	 * @generated
	 */
	EAttribute getEventBComponent_TracePath();

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
	 * Returns the meta object for the containment reference list '{@link ac.soton.fmusim.components.FMUComponent#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see ac.soton.fmusim.components.FMUComponent#getParameters()
	 * @see #getFMUComponent()
	 * @generated
	 */
	EReference getFMUComponent_Parameters();

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
	 * Returns the meta object for the reference '{@link ac.soton.fmusim.components.EventBPort#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter</em>'.
	 * @see ac.soton.fmusim.components.EventBPort#getParameter()
	 * @see #getEventBPort()
	 * @generated
	 */
	EReference getEventBPort_Parameter();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.fmusim.components.EventBPort#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see ac.soton.fmusim.components.EventBPort#getVariable()
	 * @see #getEventBPort()
	 * @generated
	 */
	EReference getEventBPort_Variable();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.EventBPort#getRealPrecision <em>Real Precision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Real Precision</em>'.
	 * @see ac.soton.fmusim.components.EventBPort#getRealPrecision()
	 * @see #getEventBPort()
	 * @generated
	 */
	EAttribute getEventBPort_RealPrecision();

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
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.AbstractVariable#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see ac.soton.fmusim.components.AbstractVariable#getValue()
	 * @see #getAbstractVariable()
	 * @generated
	 */
	EAttribute getAbstractVariable_Value();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.AbstractVariable#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see ac.soton.fmusim.components.AbstractVariable#getDescription()
	 * @see #getAbstractVariable()
	 * @generated
	 */
	EAttribute getAbstractVariable_Description();

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
	 * Returns the meta object for class '{@link ac.soton.fmusim.components.DisplayComponent <em>Display Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Display Component</em>'.
	 * @see ac.soton.fmusim.components.DisplayComponent
	 * @generated
	 */
	EClass getDisplayComponent();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.DisplayComponent#getChart <em>Chart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Chart</em>'.
	 * @see ac.soton.fmusim.components.DisplayComponent#getChart()
	 * @see #getDisplayComponent()
	 * @generated
	 */
	EAttribute getDisplayComponent_Chart();

	/**
	 * Returns the meta object for class '{@link ac.soton.fmusim.components.DisplayPort <em>Display Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Display Port</em>'.
	 * @see ac.soton.fmusim.components.DisplayPort
	 * @generated
	 */
	EClass getDisplayPort();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.DisplayPort#getTrace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trace</em>'.
	 * @see ac.soton.fmusim.components.DisplayPort#getTrace()
	 * @see #getDisplayPort()
	 * @generated
	 */
	EAttribute getDisplayPort_Trace();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.DisplayPort#getColour <em>Colour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Colour</em>'.
	 * @see ac.soton.fmusim.components.DisplayPort#getColour()
	 * @see #getDisplayPort()
	 * @generated
	 */
	EAttribute getDisplayPort_Colour();

	/**
	 * Returns the meta object for class '{@link ac.soton.fmusim.components.FMUParameter <em>FMU Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FMU Parameter</em>'.
	 * @see ac.soton.fmusim.components.FMUParameter
	 * @generated
	 */
	EClass getFMUParameter();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.FMUParameter#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see ac.soton.fmusim.components.FMUParameter#getDefaultValue()
	 * @see #getFMUParameter()
	 * @generated
	 */
	EAttribute getFMUParameter_DefaultValue();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.fmusim.components.FMUParameter#getStartValue <em>Start Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Value</em>'.
	 * @see ac.soton.fmusim.components.FMUParameter#getStartValue()
	 * @see #getFMUParameter()
	 * @generated
	 */
	EAttribute getFMUParameter_StartValue();

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
	 * Returns the meta object for enum '{@link ac.soton.fmusim.components.Colour <em>Colour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Colour</em>'.
	 * @see ac.soton.fmusim.components.Colour
	 * @generated
	 */
	EEnum getColour();

	/**
	 * Returns the meta object for data type '{@link de.prob.cosimulation.FMU <em>Fmu Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Fmu Class</em>'.
	 * @see de.prob.cosimulation.FMU
	 * @model instanceClass="de.prob.cosimulation.FMU"
	 * @generated
	 */
	EDataType getFmuClass();

	/**
	 * Returns the meta object for data type '{@link de.prob.statespace.Trace <em>Trace Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Trace Class</em>'.
	 * @see de.prob.statespace.Trace
	 * @model instanceClass="de.prob.statespace.Trace" serializeable="false"
	 * @generated
	 */
	EDataType getTraceClass();

	/**
	 * Returns the meta object for data type '{@link info.monitorenter.gui.chart.ITrace2D <em>Trace2 DClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Trace2 DClass</em>'.
	 * @see info.monitorenter.gui.chart.ITrace2D
	 * @model instanceClass="info.monitorenter.gui.chart.ITrace2D" serializeable="false"
	 * @generated
	 */
	EDataType getTrace2DClass();

	/**
	 * Returns the meta object for data type '{@link info.monitorenter.gui.chart.Chart2D <em>Chart2 DClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Chart2 DClass</em>'.
	 * @see info.monitorenter.gui.chart.Chart2D
	 * @model instanceClass="info.monitorenter.gui.chart.Chart2D" serializeable="false"
	 * @generated
	 */
	EDataType getChart2DClass();

	/**
	 * Returns the meta object for data type '{@link ac.soton.fmusim.components.exceptions.SimulationException <em>Sim Exception Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Sim Exception Class</em>'.
	 * @see ac.soton.fmusim.components.exceptions.SimulationException
	 * @model instanceClass="ac.soton.fmusim.components.exceptions.SimulationException"
	 * @generated
	 */
	EDataType getSimExceptionClass();

	/**
	 * Returns the meta object for data type '{@link ac.soton.fmusim.components.exceptions.ModelException <em>Model Exception Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Model Exception Class</em>'.
	 * @see ac.soton.fmusim.components.exceptions.ModelException
	 * @model instanceClass="ac.soton.fmusim.components.exceptions.ModelException"
	 * @generated
	 */
	EDataType getModelExceptionClass();

	/**
	 * Returns the meta object for data type '{@link org.jscience.mathematics.number.Real <em>Real Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Real Class</em>'.
	 * @see org.jscience.mathematics.number.Real
	 * @model instanceClass="org.jscience.mathematics.number.Real"
	 * @generated
	 */
	EDataType getRealClass();

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
		 * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_DIAGRAM__START_TIME = eINSTANCE.getComponentDiagram_StartTime();

		/**
		 * The meta object literal for the '<em><b>Stop Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_DIAGRAM__STOP_TIME = eINSTANCE.getComponentDiagram_StopTime();

		/**
		 * The meta object literal for the '<em><b>Step Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_DIAGRAM__STEP_SIZE = eINSTANCE.getComponentDiagram_StepSize();

		/**
		 * The meta object literal for the '{@link ac.soton.fmusim.components.Component <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.fmusim.components.Component
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
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__VARIABLES = eINSTANCE.getComponent_Variables();

		/**
		 * The meta object literal for the '<em><b>Step Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__STEP_PERIOD = eINSTANCE.getComponent_StepPeriod();

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
		 * The meta object literal for the '<em><b>Read Input Events</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_BCOMPONENT__READ_INPUT_EVENTS = eINSTANCE.getEventBComponent_ReadInputEvents();

		/**
		 * The meta object literal for the '<em><b>Time Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_BCOMPONENT__TIME_VARIABLE = eINSTANCE.getEventBComponent_TimeVariable();

		/**
		 * The meta object literal for the '<em><b>Wait Events</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_BCOMPONENT__WAIT_EVENTS = eINSTANCE.getEventBComponent_WaitEvents();

		/**
		 * The meta object literal for the '<em><b>Trace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_BCOMPONENT__TRACE = eINSTANCE.getEventBComponent_Trace();

		/**
		 * The meta object literal for the '<em><b>Trace Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_BCOMPONENT__TRACE_PATH = eINSTANCE.getEventBComponent_TracePath();

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
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU_COMPONENT__PATH = eINSTANCE.getFMUComponent_Path();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMU_COMPONENT__PARAMETERS = eINSTANCE.getFMUComponent_Parameters();

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
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_BPORT__PARAMETER = eINSTANCE.getEventBPort_Parameter();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_BPORT__VARIABLE = eINSTANCE.getEventBPort_Variable();

		/**
		 * The meta object literal for the '<em><b>Real Precision</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_BPORT__REAL_PRECISION = eINSTANCE.getEventBPort_RealPrecision();

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
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_VARIABLE__VALUE = eINSTANCE.getAbstractVariable_Value();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_VARIABLE__DESCRIPTION = eINSTANCE.getAbstractVariable_Description();

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
		 * The meta object literal for the '{@link ac.soton.fmusim.components.impl.DisplayComponentImpl <em>Display Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.fmusim.components.impl.DisplayComponentImpl
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getDisplayComponent()
		 * @generated
		 */
		EClass DISPLAY_COMPONENT = eINSTANCE.getDisplayComponent();

		/**
		 * The meta object literal for the '<em><b>Chart</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISPLAY_COMPONENT__CHART = eINSTANCE.getDisplayComponent_Chart();

		/**
		 * The meta object literal for the '{@link ac.soton.fmusim.components.impl.DisplayPortImpl <em>Display Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.fmusim.components.impl.DisplayPortImpl
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getDisplayPort()
		 * @generated
		 */
		EClass DISPLAY_PORT = eINSTANCE.getDisplayPort();

		/**
		 * The meta object literal for the '<em><b>Trace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISPLAY_PORT__TRACE = eINSTANCE.getDisplayPort_Trace();

		/**
		 * The meta object literal for the '<em><b>Colour</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISPLAY_PORT__COLOUR = eINSTANCE.getDisplayPort_Colour();

		/**
		 * The meta object literal for the '{@link ac.soton.fmusim.components.impl.FMUParameterImpl <em>FMU Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.fmusim.components.impl.FMUParameterImpl
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getFMUParameter()
		 * @generated
		 */
		EClass FMU_PARAMETER = eINSTANCE.getFMUParameter();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU_PARAMETER__DEFAULT_VALUE = eINSTANCE.getFMUParameter_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Start Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FMU_PARAMETER__START_VALUE = eINSTANCE.getFMUParameter_StartValue();

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

		/**
		 * The meta object literal for the '{@link ac.soton.fmusim.components.Colour <em>Colour</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.fmusim.components.Colour
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getColour()
		 * @generated
		 */
		EEnum COLOUR = eINSTANCE.getColour();

		/**
		 * The meta object literal for the '<em>Fmu Class</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.prob.cosimulation.FMU
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getFmuClass()
		 * @generated
		 */
		EDataType FMU_CLASS = eINSTANCE.getFmuClass();

		/**
		 * The meta object literal for the '<em>Trace Class</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.prob.statespace.Trace
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getTraceClass()
		 * @generated
		 */
		EDataType TRACE_CLASS = eINSTANCE.getTraceClass();

		/**
		 * The meta object literal for the '<em>Trace2 DClass</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see info.monitorenter.gui.chart.ITrace2D
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getTrace2DClass()
		 * @generated
		 */
		EDataType TRACE2_DCLASS = eINSTANCE.getTrace2DClass();

		/**
		 * The meta object literal for the '<em>Chart2 DClass</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see info.monitorenter.gui.chart.Chart2D
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getChart2DClass()
		 * @generated
		 */
		EDataType CHART2_DCLASS = eINSTANCE.getChart2DClass();

		/**
		 * The meta object literal for the '<em>Sim Exception Class</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.fmusim.components.exceptions.SimulationException
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getSimExceptionClass()
		 * @generated
		 */
		EDataType SIM_EXCEPTION_CLASS = eINSTANCE.getSimExceptionClass();

		/**
		 * The meta object literal for the '<em>Model Exception Class</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.fmusim.components.exceptions.ModelException
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getModelExceptionClass()
		 * @generated
		 */
		EDataType MODEL_EXCEPTION_CLASS = eINSTANCE.getModelExceptionClass();

		/**
		 * The meta object literal for the '<em>Real Class</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jscience.mathematics.number.Real
		 * @see ac.soton.fmusim.components.impl.ComponentsPackageImpl#getRealClass()
		 * @generated
		 */
		EDataType REAL_CLASS = eINSTANCE.getRealClass();

	}

} //ComponentsPackage
