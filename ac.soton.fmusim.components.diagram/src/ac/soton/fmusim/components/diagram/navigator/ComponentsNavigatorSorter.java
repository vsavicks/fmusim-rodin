/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import ac.soton.fmusim.components.diagram.part.ComponentsVisualIDRegistry;

/**
 * @generated
 */
public class ComponentsNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7003;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof ComponentsNavigatorItem) {
			ComponentsNavigatorItem item = (ComponentsNavigatorItem) element;
			return ComponentsVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
