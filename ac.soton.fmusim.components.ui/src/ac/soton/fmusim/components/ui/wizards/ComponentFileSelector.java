/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.wizards;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ResourceListSelectionDialog;

/**
 * Modified version of the org.eclipse.gmf.internal.common.ui.FileSelector
 * Supports multiple file extensions.
 * 
 * @author vitaly
 *
 */
public class ComponentFileSelector {

	public static IFile selectFile(Shell shell, String description, IContainer rootElement, IFile selected) {
		return selectFile(shell, description, rootElement, selected, null);
	}

	public static IFile selectFile(Shell shell, String description, IContainer rootElement, IFile selected, final String[] fileExtensions) {
		if (rootElement == null) {
			rootElement = ResourcesPlugin.getWorkspace().getRoot();
		}
		// final String fileName = selected == null || !selected.exists() ? "" : selected.getName();
		// ResourceSelectionDialog fsd = new ResourceSelectionDialog(shell, rootElement, description);
		ResourceListSelectionDialog fsd = new ResourceListSelectionDialog(shell, rootElement, IResource.FILE) {

			protected String adjustPattern() {
				String s = super.adjustPattern();
				if (s.equals("") && fileExtensions != null && fileExtensions.length > 0) { //$NON-NLS-1$
					s = "*." + fileExtensions[0]; //$NON-NLS-1$
//					if (fileExtensions.length > 1) {
//						for (int i=1; i < fileExtensions.length; i++)
//							s += "|" + fileExtensions[i];
//					}
//					s += ")";
				}
				return s;
			}

			public void create() {
				super.create();
				refresh(true);
			}

			protected void updateOKState(boolean state) {
				super.updateOKState(true); // allow to select nothing
			}
		};
		fsd.setTitle(description);
		fsd.setAllowUserToToggleDerived(true);
		if (fsd.open() == Window.OK) {
			Object[] result = fsd.getResult();
			if (result != null && result.length > 0 && result[0] instanceof IFile) {
				selected = (IFile) result[0];
			} else {
				selected = null;
			}
		}
		return selected;
	}
}
