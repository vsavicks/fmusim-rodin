/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.wizards;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

import ac.soton.fmusim.components.Component;
import ac.soton.fmusim.components.EventBComponent;
import ac.soton.fmusim.components.FMUComponent;
import ac.soton.fmusim.components.ui.ComponentsUIPlugin;
import ac.soton.fmusim.components.ui.resource.FMUResourceFactory;
import ac.soton.fmusim.components.ui.resource.ResourceLocationProvider;
import ac.soton.fmusim.components.ui.wizards.pages.AbstractComponentDefinitionPage;
import ac.soton.fmusim.components.ui.wizards.pages.ComponentModelSelectionPage;
import ac.soton.fmusim.components.ui.wizards.pages.EventBComponentParamDefinitionPage;
import ac.soton.fmusim.components.ui.wizards.pages.EventBComponentVariableDefinitionPage;
import ac.soton.fmusim.components.ui.wizards.pages.FMUComponentDefinitionPage;

/**
 * Component import wizard that allows to import and configure component.
 * 
 * @author vitaly
 *
 */
public class ComponentImportWizard extends Wizard implements IImportWizard {
	
	// pages
	protected ComponentModelSelectionPage componentModelSelectionPage;
	protected FMUComponentDefinitionPage fmuComponentDefinitionPage;
	protected AbstractComponentDefinitionPage eventBComponentParamDefinitionPage;
	protected AbstractComponentDefinitionPage eventBComponentVariableDefinitionPage;

	@SuppressWarnings("unused")
	private IWorkbench workbench;
	private IStructuredSelection selection;
	
	/**
	 * Returns true if wizard operates in definition mode.
	 * Definition mode means an imported component has been configured in definition page i.e.
	 * variables and ports have been selected/configured.
	 */
	protected boolean isInDefinitionMode() {
		//TODO: only FMU definition page considered
		if (componentModelSelectionPage.getModel() == fmuComponentDefinitionPage.getModel()
				&& fmuComponentDefinitionPage.isModified()) {
			return true;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		Component model = componentModelSelectionPage.getModel();
		if (componentModelSelectionPage.getModel() != null) {
			if (isInDefinitionMode()) {
				if (model instanceof FMUComponent) {
					FMUComponent component = (FMUComponent) model;
					
					// leave only selected variables
					component.getVariables().clear();
					component.getVariables().addAll(fmuComponentDefinitionPage.getCheckedInternals());
					
					component.getInputs().clear();
					component.getInputs().addAll(fmuComponentDefinitionPage.getCheckedInputs());
					
					component.getOutputs().clear();
					component.getOutputs().addAll(fmuComponentDefinitionPage.getCheckedOutputs());
				} else if (model instanceof EventBComponent) {
					//TODO: implement selective variables
//					EventBComponent component = (EventBComponent) model;
//					// remove unselected variables
//					component.getVariables().clear();
//					component.getVariables().addAll(eventBComponentDefinitionPage.getCheckedVariables());
				}
			}
			return true;
		}
		
		return false;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle("Component Import Wizard");
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
		
		// event-b component parameter configuration page
		eventBComponentParamDefinitionPage = new EventBComponentParamDefinitionPage("EventBComponentParamDefinitionPage", componentModelSelectionPage);
		eventBComponentParamDefinitionPage.setTitle(Messages.EventBComponentParameterDefinitionPageTitle);
		eventBComponentParamDefinitionPage.setDescription(Messages.EventBComponentParameterDefinitionPageDesc);
		eventBComponentParamDefinitionPage.setImageDescriptor(ComponentsUIPlugin.getInstance().getImageRegistry().getDescriptor(ComponentsUIPlugin.EVENTB_COMPONENT_IMAGE));
		addPage(eventBComponentParamDefinitionPage);
		
		// event-b component variable configuration page
		eventBComponentVariableDefinitionPage = new EventBComponentVariableDefinitionPage("EventBComponentVariableDefinitionPage", componentModelSelectionPage);
		eventBComponentVariableDefinitionPage.setTitle(Messages.EventBComponentVariableDefinitionPageTitle);
		eventBComponentVariableDefinitionPage.setDescription(Messages.EventBComponentVariableDefinitionPageDesc);
		eventBComponentVariableDefinitionPage.setImageDescriptor(ComponentsUIPlugin.getInstance().getImageRegistry().getDescriptor(ComponentsUIPlugin.EVENTB_COMPONENT_IMAGE));
		addPage(eventBComponentVariableDefinitionPage);
	}

	/**
	 * Returns imported component.
	 * 
	 * @return component
	 */
	public Component getComponent() {
		return componentModelSelectionPage.getModel();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#getNextPage(org.eclipse.jface.wizard.IWizardPage)
	 */
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		// select definition page based on selected model
		if (page instanceof ComponentModelSelectionPage) {
			ComponentModelSelectionPage modelPage = (ComponentModelSelectionPage) page;
			Component model = modelPage.getModel();
			if (model instanceof FMUComponent)
				return fmuComponentDefinitionPage;
			else if (model instanceof EventBComponent)
				return eventBComponentParamDefinitionPage;
		}
		
		// no next page if current page is the FMU page
		if (page instanceof FMUComponentDefinitionPage) {
			IWizardPage nextPage = super.getNextPage(page);
			if (nextPage instanceof EventBComponentParamDefinitionPage)
				return null;
		}
		return super.getNextPage(page);
	}

	@Override
	public boolean canFinish() {
		return super.canFinish();
	}
}
