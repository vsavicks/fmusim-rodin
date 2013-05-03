/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBObject;

import ac.soton.fmusim.components.AbstractVariable;
import ac.soton.fmusim.components.Component;
import ac.soton.fmusim.components.ComponentDiagram;
import ac.soton.fmusim.components.ComponentsPackage;
import ac.soton.fmusim.components.Connector;
import ac.soton.fmusim.components.EventBComponent;
import ac.soton.fmusim.components.EventBPort;
import ac.soton.fmusim.components.FMUComponent;
import ac.soton.fmusim.components.FMUInternalVariable;
import ac.soton.fmusim.components.FMUPort;
import ac.soton.fmusim.components.FMUVariable;
import ac.soton.fmusim.components.NamedElement;
import ac.soton.fmusim.components.Port;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see ac.soton.fmusim.components.ComponentsPackage
 * @generated
 */
public class ComponentsSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ComponentsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentsSwitch() {
		if (modelPackage == null) {
			modelPackage = ComponentsPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ComponentsPackage.COMPONENT_DIAGRAM: {
				ComponentDiagram componentDiagram = (ComponentDiagram)theEObject;
				T result = caseComponentDiagram(componentDiagram);
				if (result == null) result = caseNamedElement(componentDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentsPackage.COMPONENT: {
				Component component = (Component)theEObject;
				T result = caseComponent(component);
				if (result == null) result = caseNamedElement(component);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentsPackage.CONNECTOR: {
				Connector connector = (Connector)theEObject;
				T result = caseConnector(connector);
				if (result == null) result = caseNamedElement(connector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentsPackage.PORT: {
				Port port = (Port)theEObject;
				T result = casePort(port);
				if (result == null) result = caseAbstractVariable(port);
				if (result == null) result = caseNamedElement(port);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentsPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentsPackage.EVENT_BCOMPONENT: {
				EventBComponent eventBComponent = (EventBComponent)theEObject;
				T result = caseEventBComponent(eventBComponent);
				if (result == null) result = caseAbstractExtension(eventBComponent);
				if (result == null) result = caseComponent(eventBComponent);
				if (result == null) result = caseEventBElement(eventBComponent);
				if (result == null) result = caseNamedElement(eventBComponent);
				if (result == null) result = caseEventBObject(eventBComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentsPackage.FMU_COMPONENT: {
				FMUComponent fmuComponent = (FMUComponent)theEObject;
				T result = caseFMUComponent(fmuComponent);
				if (result == null) result = caseComponent(fmuComponent);
				if (result == null) result = caseNamedElement(fmuComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentsPackage.FMU_PORT: {
				FMUPort fmuPort = (FMUPort)theEObject;
				T result = caseFMUPort(fmuPort);
				if (result == null) result = casePort(fmuPort);
				if (result == null) result = caseFMUVariable(fmuPort);
				if (result == null) result = caseAbstractVariable(fmuPort);
				if (result == null) result = caseNamedElement(fmuPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentsPackage.EVENT_BPORT: {
				EventBPort eventBPort = (EventBPort)theEObject;
				T result = caseEventBPort(eventBPort);
				if (result == null) result = casePort(eventBPort);
				if (result == null) result = caseAbstractVariable(eventBPort);
				if (result == null) result = caseNamedElement(eventBPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentsPackage.FMU_INTERNAL_VARIABLE: {
				FMUInternalVariable fmuInternalVariable = (FMUInternalVariable)theEObject;
				T result = caseFMUInternalVariable(fmuInternalVariable);
				if (result == null) result = caseFMUVariable(fmuInternalVariable);
				if (result == null) result = caseAbstractVariable(fmuInternalVariable);
				if (result == null) result = caseNamedElement(fmuInternalVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentsPackage.FMU_VARIABLE: {
				FMUVariable fmuVariable = (FMUVariable)theEObject;
				T result = caseFMUVariable(fmuVariable);
				if (result == null) result = caseAbstractVariable(fmuVariable);
				if (result == null) result = caseNamedElement(fmuVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ComponentsPackage.ABSTRACT_VARIABLE: {
				AbstractVariable abstractVariable = (AbstractVariable)theEObject;
				T result = caseAbstractVariable(abstractVariable);
				if (result == null) result = caseNamedElement(abstractVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentDiagram(ComponentDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponent(Component object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnector(Connector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePort(Port object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event BComponent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event BComponent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventBComponent(EventBComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FMU Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FMU Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFMUComponent(FMUComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FMU Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FMU Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFMUPort(FMUPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event BPort</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event BPort</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventBPort(EventBPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FMU Internal Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FMU Internal Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFMUInternalVariable(FMUInternalVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FMU Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FMU Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFMUVariable(FMUVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractVariable(AbstractVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event BObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event BObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventBObject(EventBObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event BElement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event BElement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventBElement(EventBElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractExtension(AbstractExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //ComponentsSwitch
