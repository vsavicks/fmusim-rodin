/**
 * 
 */
package ac.soton.fmusim.components.ui.wizards.pages;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.widgets.Composite;

/**
 * Copied from the org.eclipse.gmf.internal.common.ui.ModelSelectionPageExtension.
 * 
 */
public interface ModelSelectionPageExtension {

	/**
	 * Create additional control(s) inside model selection page.
	 */
	public void createControl(Composite parent);

	/**
	 * New model was selected for the page.
	 * Called by page so extension could update controls.
	 */
	public void setResource(Resource resource);
	
}
