/**
 * 
 */
package ac.soton.fmusim.components.ui.wizards.pages;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.swt.widgets.Composite;

import ac.soton.fmusim.components.ui.resource.ResourceLocationProvider;

/**
 * Modified version of the org.eclipse.gmf.internal.common.ui.ExtensibleModelSelectionPage.
 * Supports multiple file extensions.
 * 
 * @author vitaly
 *
 */
public class ExtensibleModelSelectionPage extends ModelSelectionPage {

	private Map<String, ModelSelectionPageExtension> extensions; // id -> extension

	public ExtensibleModelSelectionPage(String pageId, ResourceLocationProvider rloc, ResourceSet resourceSet) {
		this(pageId, rloc, resourceSet, null);
	}

	public ExtensibleModelSelectionPage(String pageId, ResourceLocationProvider rloc, ResourceSet resourceSet, String[] modelFileExtensions) {
		super(pageId, rloc, resourceSet, modelFileExtensions);
		extensions = new LinkedHashMap<String, ModelSelectionPageExtension>();
		addExtensions();
	}

	protected void addExtensions() {
	}

	public void addExtension(String id, ModelSelectionPageExtension extension) {
		assert id != null;
		assert extension != null;
		assert getControl() == null;
		extensions.put(id, extension);
	}

	public ModelSelectionPageExtension getExtension(String id) {
		return extensions.get(id);
	}

	@Override
	public void createAdditionalControls(Composite parent) {
		for (ModelSelectionPageExtension extension : extensions.values()) {
			extension.createControl(parent);
		}
	}

	@Override
	protected void resourceChanged() {
		for (ModelSelectionPageExtension extension : extensions.values()) {
			extension.setResource(getResource());
		}
	}
	
}
