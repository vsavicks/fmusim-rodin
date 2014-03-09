/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.actions;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;

import ac.soton.fmusim.components.EventBComponent;

/**
 * Action for deleting an Event-B component from the Event-B Explorer view.
 * 
 * @author vitaly
 *
 */
public class DeleteEventBComponentAction extends Action {

	private ICommonActionExtensionSite site;

	public DeleteEventBComponentAction(ICommonActionExtensionSite actionSite) {
		site = actionSite;
		setText("&Delete");
		setToolTipText("Delete Event-B component");
		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE));
	}
	
	@Override
	public void run() {
		if (!(site.getStructuredViewer().getSelection().isEmpty())) {
			IStructuredSelection ssel = (IStructuredSelection) site.getStructuredViewer().getSelection();
			
			Object element = ssel.getFirstElement();
			if (element instanceof IAdaptable) {
				final EventBComponent component = (EventBComponent) ((IAdaptable) element).getAdapter(EObject.class);
				final Resource resource = component.eResource();

				if (resource != null && resource.isLoaded()) {
					TransactionalEditingDomain editingDomain = TransactionUtil
							.getEditingDomain(resource);
					if (editingDomain != null) {
						Command cmd = new RecordingCommand(editingDomain, "Delete Diagram Command") {
							protected void doExecute() {
								EcoreUtil.delete(component, true);
							}
						};
						if (cmd.canExecute()) {
							editingDomain.getCommandStack().execute(cmd);
							try {
								resource.save(Collections.emptyMap());
							} catch (IOException e) {
								cmd.undo();
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}

}
