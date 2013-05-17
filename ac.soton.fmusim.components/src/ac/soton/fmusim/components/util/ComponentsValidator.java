/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import ac.soton.fmusim.components.AbstractVariable;
import ac.soton.fmusim.components.Component;
import ac.soton.fmusim.components.ComponentDiagram;
import ac.soton.fmusim.components.ComponentsPackage;
import ac.soton.fmusim.components.Connector;
import ac.soton.fmusim.components.EventBComponent;
import ac.soton.fmusim.components.EventBPort;
import ac.soton.fmusim.components.EventBVariable;
import ac.soton.fmusim.components.FMUComponent;
import ac.soton.fmusim.components.FMUPort;
import ac.soton.fmusim.components.FMUVariable;
import ac.soton.fmusim.components.NamedElement;
import ac.soton.fmusim.components.Port;
import ac.soton.fmusim.components.VariableCausality;
import ac.soton.fmusim.components.VariableType;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see ac.soton.fmusim.components.ComponentsPackage
 * @generated
 */
public class ComponentsValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ComponentsValidator INSTANCE = new ComponentsValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "ac.soton.fmusim.components";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has Valid Machine Reference' of 'Event BComponent'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EVENT_BCOMPONENT__HAS_VALID_MACHINE_REFERENCE = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has Valid Fmu Path' of 'FMU Component'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FMU_COMPONENT__HAS_VALID_FMU_PATH = 2;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 2;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentsValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return ComponentsPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case ComponentsPackage.COMPONENT_DIAGRAM:
				return validateComponentDiagram((ComponentDiagram)value, diagnostics, context);
			case ComponentsPackage.COMPONENT:
				return validateComponent((Component)value, diagnostics, context);
			case ComponentsPackage.CONNECTOR:
				return validateConnector((Connector)value, diagnostics, context);
			case ComponentsPackage.PORT:
				return validatePort((Port)value, diagnostics, context);
			case ComponentsPackage.NAMED_ELEMENT:
				return validateNamedElement((NamedElement)value, diagnostics, context);
			case ComponentsPackage.EVENT_BCOMPONENT:
				return validateEventBComponent((EventBComponent)value, diagnostics, context);
			case ComponentsPackage.FMU_COMPONENT:
				return validateFMUComponent((FMUComponent)value, diagnostics, context);
			case ComponentsPackage.FMU_PORT:
				return validateFMUPort((FMUPort)value, diagnostics, context);
			case ComponentsPackage.EVENT_BPORT:
				return validateEventBPort((EventBPort)value, diagnostics, context);
			case ComponentsPackage.FMU_VARIABLE:
				return validateFMUVariable((FMUVariable)value, diagnostics, context);
			case ComponentsPackage.ABSTRACT_VARIABLE:
				return validateAbstractVariable((AbstractVariable)value, diagnostics, context);
			case ComponentsPackage.EVENT_BVARIABLE:
				return validateEventBVariable((EventBVariable)value, diagnostics, context);
			case ComponentsPackage.VARIABLE_TYPE:
				return validateVariableType((VariableType)value, diagnostics, context);
			case ComponentsPackage.VARIABLE_CAUSALITY:
				return validateVariableCausality((VariableCausality)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentDiagram(ComponentDiagram componentDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(componentDiagram, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponent(Component component, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(component, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnector(Connector connector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_NoCircularContainment(connector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMultiplicityConforms(connector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(connector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(connector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(connector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(connector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(connector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(connector, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(connector, diagnostics, context);
		if (result || diagnostics != null) result &= validateConnector_CompatiblePorts(connector, diagnostics, context);
		if (result || diagnostics != null) result &= validateConnector_CompleteConnection(connector, diagnostics, context);
		return result;
	}

	/**
	 * Validates the CompatiblePorts constraint of '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * All ports connected by a connector must have the same type.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateConnector_CompatiblePorts(Connector connector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		
		// skip if none or a single port is connected
		EList<Port> ports = connector.getPorts();
		if (ports.size() < 2)
			return true;
		
		boolean failed = false;
		VariableType type = ports.get(0).getType();
		for (Port p : ports) {
			if (p.getType() != type) {
				failed = true;
				break;
			}
		}
		if (failed) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "CompatiblePorts", getObjectLabel(connector, context) },
						 new Object[] { connector },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the CompleteConnection constraint of '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * The connector must have a complete connection:
	 * for any connector output there must be an input
	 * i.e. if input ports are linked to a connector, an output port must also be linked.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateConnector_CompleteConnection(Connector connector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		EList<Port> ports = connector.getPorts();
		boolean input = false;
		for (Port p : ports) {
			if (p.getCausality() == VariableCausality.OUTPUT) {
				input = true;
				break;
			}
		}
		
		if (!input && ports.size() > 0) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "CompleteConnection", getObjectLabel(connector, context) },
						 new Object[] { connector },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePort(Port port, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(port, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedElement(NamedElement namedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(namedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEventBComponent(EventBComponent eventBComponent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_NoCircularContainment(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMultiplicityConforms(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(eventBComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateEventBComponent_hasValidMachineReference(eventBComponent, diagnostics, context);
		return result;
	}

	/**
	 * Validates the hasValidMachineReference constraint of '<em>Event BComponent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEventBComponent_hasValidMachineReference(EventBComponent eventBComponent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return eventBComponent.hasValidMachineReference(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFMUComponent(FMUComponent fmuComponent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_NoCircularContainment(fmuComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMultiplicityConforms(fmuComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(fmuComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(fmuComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(fmuComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(fmuComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(fmuComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(fmuComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(fmuComponent, diagnostics, context);
		if (result || diagnostics != null) result &= validateFMUComponent_hasValidFmuPath(fmuComponent, diagnostics, context);
		return result;
	}

	/**
	 * Validates the hasValidFmuPath constraint of '<em>FMU Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFMUComponent_hasValidFmuPath(FMUComponent fmuComponent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return fmuComponent.hasValidFmuPath(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFMUPort(FMUPort fmuPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(fmuPort, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEventBPort(EventBPort eventBPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(eventBPort, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFMUVariable(FMUVariable fmuVariable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(fmuVariable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractVariable(AbstractVariable abstractVariable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(abstractVariable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEventBVariable(EventBVariable eventBVariable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(eventBVariable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableType(VariableType variableType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableCausality(VariableCausality variableCausality, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //ComponentsValidator
