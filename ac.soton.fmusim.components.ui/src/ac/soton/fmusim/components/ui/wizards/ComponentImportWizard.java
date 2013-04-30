/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.wizards;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EcoreFactoryImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.eventb.emf.core.machine.Machine;

import de.prob.cosimulation.FMU;

import ac.soton.fmusim.components.Component;
import ac.soton.fmusim.components.ui.ComponentsUIPlugin;
import ac.soton.fmusim.components.ui.resource.FMUResourceFactory;
import ac.soton.fmusim.components.ui.resource.ResourceLocationProvider;
import ac.soton.fmusim.components.ui.wizards.pages.ComponentModelSelectionPage;
import ac.soton.fmusim.components.ui.wizards.pages.EventBComponentDefinitionPage;
import ac.soton.fmusim.components.ui.wizards.pages.experimental.FMUPortDefinitionPage;
import ac.soton.fmusim.components.ui.wizards.pages.fmu.FMUComponentDefinitionPage;
//import org.eclipse.gmf.internal.bridge.resolver.StructureResolver;
//import org.eclipse.gmf.internal.bridge.wizards.Messages;
//import org.eclipse.gmf.internal.bridge.wizards.WizardUtil;
//import org.eclipse.gmf.internal.bridge.wizards.pages.simple.DefinitionPage;
//import org.eclipse.gmf.internal.bridge.wizards.pages.simple.DomainModelSelectionPage;
//import org.eclipse.gmf.internal.bridge.wizards.pages.simple.DomainModelSourceImpl;
//import org.eclipse.gmf.internal.bridge.wizards.pages.simple.StructureBuilder;
//import org.eclipse.gmf.internal.bridge.wizards.pages.simple.ToolDefBuilder;
//import org.eclipse.gmf.internal.common.URIUtil;
//import org.eclipse.gmf.internal.common.ui.ModelSelectionPage;
//import org.eclipse.gmf.internal.common.ui.ResourceLocationProvider;
//import org.eclipse.gmf.internal.bridge.resolver.StructureResolver;
//import org.eclipse.gmf.internal.bridge.wizards.Messages;
//import org.eclipse.gmf.internal.bridge.wizards.WizardUtil;
//import org.eclipse.gmf.internal.bridge.wizards.pages.simple.DefinitionPage;
//import org.eclipse.gmf.internal.bridge.wizards.pages.simple.DomainModelSourceImpl;
//import org.eclipse.gmf.internal.bridge.wizards.pages.simple.StructureBuilder;
//import org.eclipse.gmf.internal.bridge.wizards.pages.simple.ToolDefBuilder;
//import org.eclipse.gmf.internal.common.ui.ResourceLocationProvider;
//import ac.soton.fmusim.components.ui.wizards.pages.PortDefinitionPage;

/**
 * @author vitaly
 *
 */
public class ComponentImportWizard extends Wizard implements IImportWizard {
	
	// pages
	protected ComponentModelSelectionPage componentModelSelectionPage;
	protected FMUComponentDefinitionPage fmuComponentDefinitionPage;
	private EventBComponentDefinitionPage eventBComponentDefinitionPage;

	private IWorkbench workbench;
	private IStructuredSelection selection;
	
//	/**
//	 * Returns true if wizard operates in definition mode.
//	 * Definition mode means an imported component has been configured in definition page i.e.
//	 * variables and ports have been selected/configured.
//	 */
//	protected boolean isInDefinitionMode() {
//		return fmuComponentDefinitionPage != null && fmuComponentDefinitionPage.getComponent() != null;
//	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
//		try {
//		//TODO: get model from the final page and add it to the diagram
//			WizardUtil.saveModel(getContainer(), toolingModelSelectionPage.getResource());
//		} catch (Exception exception) {
//			Plugin.log(exception);
//			return false;
//		}
		
//		FMU model = (FMU) componentModelSelectionPage.getModel();
//		if (model == null)
//			return false;
//		
//		FMIModelDescription modelDescription = model.getModelDescription();
//		
//		// new component
//		FMUComponent fmuComponent = ComponentsFactory.eINSTANCE
//				.createFMUComponent();
//		fmuComponent.setPath(componentModelSelectionPage.getURI().toString());
//		fmuComponent.setFmu(model);
//		fmuComponent.setName(modelDescription.modelName);
//		
//		// add ports from selection
//		List<FMUVariable[]> definition = fmuComponentDefinitionPage.getSelection();
//		for (FMIScalarVariable scalarVariable : modelDescription.modelVariables) {
//			Variable variable = ComponentsFactory.eINSTANCE
//					.createVariable();
//			variable.setName(scalarVariable.name);
//			// FIXME: variable requires a reference to FMI scalar variable
//			// (for API calls)
//			// TODO: maybe the variable also requires the type, variability (parameter etc.), start value (from type i.e. type.start)
//			
//			// type and start value
//			FMIType type = scalarVariable.type;
//			Object value = null;
//			FmiTypes typeEnum = FmiTypes.REAL;
//			if (type instanceof FMIRealType) {
//				value = ((FMIRealType) type).start;
//				typeEnum = FmiTypes.REAL;
//			} else if (type instanceof FMIIntegerType) {
//				value = ((FMIIntegerType) type).start;
//				typeEnum = FmiTypes.INTEGER;
//			} else if (type instanceof FMIBooleanType) {
//				value = ((FMIBooleanType) type).start;
//				typeEnum = FmiTypes.BOOLEAN;
//			} else if (type instanceof FMIStringType) {
//				value = ((FMIStringType) type).start;
//				typeEnum = FmiTypes.STRING;
//			}
//			variable.setValue(value);
//
//			if (scalarVariable.causality == Causality.internal) {
//				fmuComponent.getVariables().add(variable);
//			} else if (scalarVariable.causality == Causality.input || scalarVariable.causality == Causality.output) {
//				FMUPort port = ComponentsFactory.eINSTANCE.createFMUPort();
//				port.setName(scalarVariable.name);
//				port.setVariable(variable);
//				port.setType(typeEnum);
//
//				if (scalarVariable.causality == Causality.input) {
//					port.setKind(PortKind.INPUT);
//					fmuComponent.getInputs().add(port);
//				} else if (scalarVariable.causality == Causality.output) {
//					port.setKind(PortKind.OUTPUT);
//					fmuComponent.getOutputs().add(port);
//				}
//			}
//		}
//		component = fmuComponent;
		return false;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle("Component Import Wizard");
	}

	/**
	 * @return
	 */
	protected EObject createInitialModel() {
		return EcoreFactoryImpl.eINSTANCE.createEObject();
	}
	
	public void addPages() {
		ResourceLocationProvider rloc = new ResourceLocationProvider(selection);
		ResourceSet resourceSet = new ResourceSetImpl();
		
		// register FMU resource factory
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("fmu", new FMUResourceFactory());
		
		// model file selection page
		componentModelSelectionPage = new ComponentModelSelectionPage("ComponentModelSelectionPage", rloc, resourceSet);
		componentModelSelectionPage.setPageComplete(false);
		componentModelSelectionPage.setModelRequired(true);
		componentModelSelectionPage.setTitle(Messages.ComponentModelSelectionPageTitle);
		componentModelSelectionPage.setDescription(Messages.ComponentModelSelectionPageDesc);
		componentModelSelectionPage.setImageDescriptor(ComponentsUIPlugin.getInstance().getImageRegistry().getDescriptor(ComponentsUIPlugin.COMPONENT_IMAGE));
		addPage(componentModelSelectionPage);
		
		// fmu component configuration page
		fmuComponentDefinitionPage = new FMUComponentDefinitionPage("FMUComponentDefinitionPage", componentModelSelectionPage);
		fmuComponentDefinitionPage.setTitle(Messages.FMUComponentDefinitionPageTitle);
		fmuComponentDefinitionPage.setDescription(Messages.FMUComponentDefinitionPageDesc);
		fmuComponentDefinitionPage.setImageDescriptor(ComponentsUIPlugin.getInstance().getImageRegistry().getDescriptor(ComponentsUIPlugin.FMU_COMPONENT_IMAGE));
		addPage(fmuComponentDefinitionPage);
		
		// event-b component configuration page
		eventBComponentDefinitionPage = new EventBComponentDefinitionPage("EventBComponentDefinitionPage", componentModelSelectionPage);
		eventBComponentDefinitionPage.setTitle(Messages.EventBComponentDefinitionPageTitle);
		eventBComponentDefinitionPage.setDescription(Messages.EventBComponentDefinitionPageDesc);
		eventBComponentDefinitionPage.setImageDescriptor(ComponentsUIPlugin.getInstance().getImageRegistry().getDescriptor(ComponentsUIPlugin.EVENTB_COMPONENT_IMAGE));
		addPage(eventBComponentDefinitionPage);

//		fmuPortDefinitionPage = new FMUPortDefinitionPage("PortDefinitionPage", new StructureBuilder(new StructureResolver(), false), componentModelSelectionPage);// { //$NON-NLS-1$
//
//			protected DomainModelSourceImpl createDomainModelSource(EPackage contents, EClass diagramElement) {
//				if (isInReconcileMode()) {
//					return new DomainModelSourceImpl(contents, diagramElement) {
//
//						public boolean isDisabled(EObject domainElement) {
//							return ToolDefBuilder.getCreationTool(toolingModelSelectionPage.getResource().getAllContents(), domainElement) != null;
//						}
//					};
//				}
//				return super.createDomainModelSource(contents, diagramElement);
//			}
//		};
//		fmuPortDefinitionPage.setTitle(Messages.SimpleModelWizardToolDefinitionPageTitle);
//		fmuPortDefinitionPage.setDescription(Messages.SimpleModelWizardToolDefinitionPageDesc);
//		addPage(fmuPortDefinitionPage);
	}

//	public IFile getModelFile() {
//		return super.getModelFile();
//	}
	
	/**
	 * Returns imported component.
	 * 
	 * @return component
	 */
	public Component getComponent() {
//		if (isInDefinitionMode()) {
//			return fmuComponentDefinitionPage.getComponent();
//		}
		return null;//super.getModelFile();
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		// select definition page based on selected model
		if (page instanceof ComponentModelSelectionPage) {
			ComponentModelSelectionPage modelPage = (ComponentModelSelectionPage) page;
			Object model = modelPage.getModel();
			if (model instanceof FMU)
				return fmuComponentDefinitionPage;
			else if (model instanceof Machine)
				return eventBComponentDefinitionPage;
		}
		
		// skip event-b page if current page is the fmu page
		if (page instanceof FMUComponentDefinitionPage) {
			IWizardPage nextPage = super.getNextPage(page);
			if (nextPage instanceof EventBComponentDefinitionPage)
				return super.getNextPage(nextPage);
		}
		return super.getNextPage(page);
	}
}
