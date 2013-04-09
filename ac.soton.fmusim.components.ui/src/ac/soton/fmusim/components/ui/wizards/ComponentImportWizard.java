/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EcoreFactoryImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

/**
 * @author vitaly
 *
 */
public class ComponentImportWizard extends Wizard implements IImportWizard {
	
	// from subclass
	protected ComponentModelSelectionPage componentModelSelectionPage;
//	protected PortDefinitionPage portDefinitionPage;

	// from superclass
	//TODO: pull up
	private IWorkbench workbench;
	private IStructuredSelection selection;

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		// TODO create component on the diagram
		return false;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle("Component Import Wizard");
//		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(GMFToolEditPlugin.INSTANCE.getImage("full/wizban/NewGMFTool")));
	}

	/**
	 * @return
	 */
	protected EObject createInitialModel() {
		return EcoreFactoryImpl.eINSTANCE.createEObject();
	}
	
	public void addPages() {
		ComponentResourceLocationProvider rloc = new ComponentResourceLocationProvider(selection);
		ResourceSet resourceSet = new ResourceSetImpl();
		
		super.addPages();
		
//		// check if a component file is already selected
//		if (selection != null && !selection.isEmpty()) {
//			Object selected = selection.getFirstElement();
//			if (selected instanceof IFile) {
//				newFileCreationPage.setFileName(WizardUtil.getDefaultFileName((IFile) selected, "gmftool")); //$NON-NLS-1$
//			}
//		}

		componentModelSelectionPage = new ComponentModelSelectionPage("ComponentModelSelectionPage", rloc, resourceSet, new String[]{"bum","fmu"}); //$NON-NLS-1$
		componentModelSelectionPage.setTitle(Messages.SimpleModelWizardDomainModelSelectionPageTitle);
		componentModelSelectionPage.setDescription(Messages.SimpleModelWizardDomainModelSelectionPageDesc);
		addPage(componentModelSelectionPage);

//		portDefinitionPage = new PortDefinitionPage("PortDefinitionPage", new StructureBuilder(new StructureResolver(), false), domainModelSelectionPage) { //$NON-NLS-1$
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
//		portDefinitionPage.setTitle(Messages.SimpleModelWizardToolDefinitionPageTitle);
//		portDefinitionPage.setDescription(Messages.SimpleModelWizardToolDefinitionPageDesc);
//		addPage(portDefinitionPage);
	}

//	public IFile getModelFile() {
//		return super.getModelFile();
//	}
}