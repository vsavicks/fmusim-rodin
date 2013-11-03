/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.navigator;

import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.Viewer;

import ac.soton.fmusim.components.diagram.navigator.ComponentsNavigatorContentProvider;

/**
 * @author vitaly
 *
 */
public class NavigatorComponentsDiagramContentProvider extends ComponentsNavigatorContentProvider {
	
	private static final Object[] NO_OBJECT = new Object[0];

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof IProject) {
			IProject project = (IProject) element;
			return getChildren(project).length > 0;
		}
		return super.hasChildren(element);
	}

	@Override
	public Object[] getChildren(Object element) {
		if (element instanceof IProject) {
			IProject project = (IProject) element;
			if (project.exists() && project.isOpen()) {
				IResource[] members = null;
				try {
					members = project.members();
				} catch (CoreException e) {
					return NO_OBJECT;
				}
				ArrayList<Object> children = new ArrayList<Object>();
				for (IResource res : members) {
					if ("cmd".equals(res.getFileExtension())) {
						Object[] c = super.getChildren(res);
						for (Object o : c)
							children.add(o);
					}
				}
				return children.toArray();
			}
		} else {
			return super.getChildren(element);
		}
		return NO_OBJECT;
	}
	
	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	@Override
	public Object getParent(Object element) {
		//TODO
		return null;
	}

	@Override
	public void dispose() {
		// ignored
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// ignored
	}

}
