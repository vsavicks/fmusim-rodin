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
