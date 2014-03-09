/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eventb.emf.core.machine.Machine;

import ac.soton.fmusim.components.EventBComponent;
import ac.soton.fmusim.components.diagram.edit.parts.EventBComponentEditPart;

/**
 * Action for opening a corresponding machine of an EventB component.
 * 
 * @author vitaly
 *
 */
public class OpenMachineAction implements IObjectActionDelegate {

	private EventBComponentEditPart selectedElement;
	private IWorkbenchPart part;

	/**
	 * 
	 */
	public OpenMachineAction() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	@Override
	public void run(IAction action) {
		View view = selectedElement.getNotationView();
		EventBComponent component = (EventBComponent) view.getElement();
		Machine machine = component.getMachine();
		
		// if machine isn't set, add error marker
		if (machine == null || machine.eResource() == null) {
			//TODO: check if markers are already added
//			Resource resource = view.eResource();
//			ComponentsMarkerNavigationProvider.addMarker(
//					WorkspaceSynchronizer.getFile(resource), 
//					resource.getURIFragment(view),
//					EMFCoreUtil.getQualifiedName(component, true), 
//					"Machine is not set", 
//					IMarker.SEVERITY_ERROR);
			return;
		}
		
		// try to open machine in a default editor
		IWorkbenchPage page = part.getSite().getPage();
		IFile file = WorkspaceSynchronizer.getFile(machine.eResource());
		IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());
		try {
			page.openEditor(new FileEditorInput(file), desc.getId());
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		selectedElement = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.getFirstElement() instanceof EventBComponentEditPart)
				selectedElement = (EventBComponentEditPart) structuredSelection.getFirstElement();
		}
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		part = targetPart;
	}

}
