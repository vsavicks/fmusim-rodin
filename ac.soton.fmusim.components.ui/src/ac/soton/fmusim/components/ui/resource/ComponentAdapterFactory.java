/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.resource;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.Variable;
import org.ptolemy.fmi.FMIModelDescription;
import org.ptolemy.fmi.FMIScalarVariable;
import org.ptolemy.fmi.FMIScalarVariable.Causality;

import ac.soton.fmusim.components.AbstractVariable;
import ac.soton.fmusim.components.Component;
import ac.soton.fmusim.components.ComponentsFactory;
import ac.soton.fmusim.components.ComponentsPackage;
import ac.soton.fmusim.components.EventBComponent;
import ac.soton.fmusim.components.EventBVariable;
import ac.soton.fmusim.components.FMUComponent;
import ac.soton.fmusim.components.FMUVariable;
import ac.soton.fmusim.components.Port;
import ac.soton.fmusim.components.VariableCausality;
import ac.soton.fmusim.components.VariableType;
import ac.soton.fmusim.components.util.FmiUtil;

/**
 * Adapter factory for adapting an Event-B machine or FMU to a
 * corresponding simulation component.
 * 
 * @author vitaly
 *
 */
public class ComponentAdapterFactory implements IAdapterFactory {

	private static final long DEFAULT_STEP = 1000;

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object, java.lang.Class)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adaptableObject instanceof Machine) {
			return createEventBComponent((Machine) adaptableObject);
		}
		if (adaptableObject instanceof FMIModelDescription) {
			return createFMUComponent((FMIModelDescription) adaptableObject);
		}
		return null;
	}

	/**
	 * Creates an FMU Component from the FMIModelDescription.
	 * 
	 * @param modelDescription
	 * @return component
	 */
	private Component createFMUComponent(FMIModelDescription modelDescription) {
		FMUComponent component = ComponentsFactory.eINSTANCE.createFMUComponent();
		component.setName(modelDescription.modelName);
		//TODO: set path (probably requires adapting an FMU resource instead of FMU)
		// as path is not available from the FMU itself
//		fmuComponent.setPath(filePath);
		
		for (FMIScalarVariable scalarVariable : modelDescription.modelVariables) {
			AbstractVariable variable = null;
			
			if (scalarVariable.causality == Causality.internal) {
				variable = ComponentsFactory.eINSTANCE.createFMUVariable();
				component.getVariables().add((FMUVariable) variable);
			} else if (scalarVariable.causality == Causality.input) {
				variable = ComponentsFactory.eINSTANCE.createFMUPort();
				component.getInputs().add((Port) variable);
			} else if (scalarVariable.causality == Causality.output) {
				variable = ComponentsFactory.eINSTANCE.createFMUPort();
				component.getOutputs().add((Port) variable);
			}
			assert variable != null;
			
			// common variable attributes
			variable.setName(scalarVariable.name);
			variable.setType(FmiUtil.getVariableType(scalarVariable, variable));
			variable.setCausality(FmiUtil.getVariableCausality(scalarVariable));
			variable.setDescription(scalarVariable.description);
		}
		return component;
	}

	/**
	 * Creates a component from Event-B machine.
	 * Loads an existing component from an extension if contained in the machine.
	 * 
	 * @param machine
	 * @return component
	 */
	private Component createEventBComponent(Machine machine) {
		// check if extensions contain a component already
		for (AbstractExtension extension : machine.getExtensions()) {
			if (ComponentsPackage.EVENTB_COMPONENT_EXTENSION_ID.equals(extension.getExtensionId())) {
				return (Component) extension;
			}
		}
		
		// if no component extensions, create a new Event-B component
		EventBComponent component = ComponentsFactory.eINSTANCE.createEventBComponent();
		component.setName(machine.getName());
		component.setMachine(machine);
		component.setStepPeriod(DEFAULT_STEP);
		
		for (Variable v : machine.getVariables()) {
			EventBVariable variable = ComponentsFactory.eINSTANCE.createEventBVariable();
			variable.setVariable(v);
			variable.setDescription(v.getComment());
			variable.setCausality(VariableCausality.INTERNAL);
			variable.setType(VariableType.STRING);
			component.getVariables().add(variable);
		}
			
		return component;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapterList()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Class[] getAdapterList() {
		return new Class[]{Component.class};
	}

}
