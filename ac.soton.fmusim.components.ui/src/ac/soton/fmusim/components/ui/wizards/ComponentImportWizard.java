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
import ac.soton.fmusim.components.ui.wizards.pages.ComponentModelSelectionPage;
import ac.soton.fmusim.components.ui.wizards.pages.EventBComponentDefinitionPage;
import ac.soton.fmusim.components.ui.wizards.pages.FMUComponentDefinitionPage;

/**
 * @author vitaly
 *
 */
public class ComponentImportWizard extends Wizard implements IImportWizard {
	
	// pages
	protected ComponentModelSelectionPage componentModelSelectionPage;
	protected FMUComponentDefinitionPage fmuComponentDefinitionPage;
	protected EventBComponentDefinitionPage eventBComponentDefinitionPage;

	private IWorkbench workbench;
	private IStructuredSelection selection;
	
	/**
	 * Returns true if wizard operates in definition mode.
	 * Definition mode means an imported component has been configured in definition page i.e.
	 * variables and ports have been selected/configured.
	 */
	protected boolean isInDefinitionMode() {
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
//		try {
//		//TODO: get model from the final page and add it to the diagram
//			WizardUtil.saveModel(getContainer(), toolingModelSelectionPage.getResource());
//		} catch (Exception exception) {
//			Plugin.log(exception);
//			return false;
//		}
		Component model = componentModelSelectionPage.getModel();
		if (componentModelSelectionPage.getModel() != null) {
			if (isInDefinitionMode()) {
				if (model instanceof FMUComponent) {
					FMUComponent component = (FMUComponent) model;
					// remove unselected variables:
						// internal
					component.getVariables().clear();
					component.getVariables().addAll(fmuComponentDefinitionPage.getCheckedInternals());
						// inputs
					component.getInputs().clear();
					component.getInputs().addAll(fmuComponentDefinitionPage.getCheckedInputs());
						// outputs
					component.getOutputs().clear();
					component.getOutputs().addAll(fmuComponentDefinitionPage.getCheckedOutputs());
				}
				//TODO: consider selective event-b ports
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
		
		// event-b component configuration page
		eventBComponentDefinitionPage = new EventBComponentDefinitionPage("EventBComponentDefinitionPage", componentModelSelectionPage);
		eventBComponentDefinitionPage.setTitle(Messages.EventBComponentDefinitionPageTitle);
		eventBComponentDefinitionPage.setDescription(Messages.EventBComponentDefinitionPageDesc);
		eventBComponentDefinitionPage.setImageDescriptor(ComponentsUIPlugin.getInstance().getImageRegistry().getDescriptor(ComponentsUIPlugin.EVENTB_COMPONENT_IMAGE));
		addPage(eventBComponentDefinitionPage);
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
				return eventBComponentDefinitionPage;
		}
		
		// skip event-b page if current page is the FMU page
		if (page instanceof FMUComponentDefinitionPage) {
			IWizardPage nextPage = super.getNextPage(page);
			if (nextPage instanceof EventBComponentDefinitionPage)
				return super.getNextPage(nextPage);
		}
		return super.getNextPage(page);
	}
}
