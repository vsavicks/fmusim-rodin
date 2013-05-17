/**
 * 
 */
package ac.soton.fmusim.components.ui.wizards.pages;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import ac.soton.fmusim.components.ui.resource.FileSelector;
import ac.soton.fmusim.components.ui.resource.ResourceLocationProvider;
import ac.soton.fmusim.components.ui.wizards.Messages;

/**
 * Modified version of the org.eclipse.gmf.internal.common.ui.ModelSelectionPage.
 * Supports multiple file extensions.
 * 
 * @author vitaly
 *
 */
public abstract class ModelSelectionPage extends WizardPage {

	protected final ResourceLocationProvider rloc;

	protected Text uriFld;

	private int settingUriFld; // flag to ignore modifyText notification when setting uri field value

	protected Button loadBtn;

	private Button browseFsBtn;

	private Button browseWsBtn;

	private Button findInWsBtn;

	private URI uri;
	
	private Resource resource;

	private ResourceSet resourceSet;

	private boolean readOnly;

	private boolean modelRequired;

	private boolean initialized;

	private String[] modelFileExtensions;


	public ModelSelectionPage(String pageId, ResourceLocationProvider rloc, ResourceSet resourceSet) {
		this(pageId, rloc, resourceSet, null);
	}

	public ModelSelectionPage(String pageId, ResourceLocationProvider rloc, ResourceSet resourceSet, String[] modelFileExtensions) {
		super(pageId);
		this.rloc = rloc;
		this.resourceSet = resourceSet;
		setModelFileExtensions(modelFileExtensions);
	}

	protected final ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		return resourceSet;
	}

	public void setModelFileExtensions(String[] fileExtensions) {
		this.modelFileExtensions = fileExtensions;
	}

	/**
	 * @return <code>null</code> if none set
	 */
	protected String[] getModelFileExtensions() {
		return modelFileExtensions;
	}

	public final void createControl(Composite parent) {
		Composite plate = new Composite(parent, SWT.NONE);
		{
			GridLayout layout = new GridLayout();
			plate.setLayout(layout);

			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			plate.setLayoutData(data);
		}
		createTitleAndButtonsRow(plate);
		createUriRow(plate);
		createAdditionalControls(plate);
		setControl(plate);
	}

	protected void createTitleAndButtonsRow(Composite parent) {
		Composite plate = new Composite(parent, SWT.NONE);
		{
			GridLayout layout = new GridLayout();
			layout.numColumns = 4;
			plate.setLayout(layout);

			plate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		}
		Label label = new Label(plate, SWT.NONE);
		label.setText(Messages.ModelSelectionPageModelURI);
		label.setLayoutData(new GridData());

		browseFsBtn = new Button(plate, SWT.PUSH);
		browseFsBtn.setText(Messages.ModelSelectionPageBrowseFS);
		browseFsBtn.setLayoutData(new GridData(SWT.END, SWT.CENTER, true, false));

		browseWsBtn = new Button(plate, SWT.PUSH);
		browseWsBtn.setText(Messages.ModelSelectionPageBrowseWS);
		browseWsBtn.setLayoutData(new GridData());

		findInWsBtn = new Button(plate, SWT.PUSH);
		findInWsBtn.setText(Messages.ModelSelectionPageFindInWS);
		findInWsBtn.setLayoutData(new GridData());

		// logic

		browseFsBtn.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(getShell(), SWT.OPEN);
				fd.setText(Messages.ModelSelectionPageSelectModel);
				String fileName = fd.open();
				if (fileName == null) {
					return;
				}
				setURI(URI.createFileURI(fileName));
				updateURI();
			};
		});
		browseWsBtn.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				ViewerFilter extFilter = new ViewerFilter() {

					public boolean select(Viewer viewer, Object parentElement, Object element) {
						String[] ext = getModelFileExtensions();
						if (ext != null && element instanceof IFile) {
							IFile file = (IFile) element;
							for (String e : ext) {
								if (e.equals(file.getFileExtension()))
									return true;
							}
							return false;
						}
						return true;
					}
				};
				IFile[] files = WorkspaceResourceDialog.openFileSelection(getShell(), Messages.ModelSelectionPageSelectModel, Messages.ModelSelectionPageSelectModelDesc, false, null, Collections
						.singletonList(extFilter));
				if (files == null || files.length == 0) {
					return;
				}
				setURI(URI.createPlatformResourceURI(files[0].getFullPath().toString(), true));
				updateURI();
			}
		});
		findInWsBtn.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				IFile file = FileSelector.selectFile(getShell(), Messages.ModelSelectionPageSelectModel, null, null, getModelFileExtensions());
				if (file == null) {
					return;
				}
				setURI(URI.createPlatformResourceURI(file.getFullPath().toString(), true));
				updateURI();
			};
		});
	}

	protected void createUriRow(Composite parent) {
		Composite plate = new Composite(parent, SWT.NONE);
		{
			GridLayout layout = new GridLayout();
			layout.numColumns = 2;
			plate.setLayout(layout);

			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			plate.setLayoutData(data);
		}
		uriFld = new Text(plate, SWT.SINGLE | SWT.BORDER);
		{
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			uriFld.setLayoutData(data);
		}
		loadBtn = new Button(plate, SWT.PUSH);
		loadBtn.setText(Messages.ModelSelectionPageLoad);
		{
			GridData data = new GridData();
			loadBtn.setLayoutData(data);
		}

		// logic

		loadBtn.setEnabled(false);
		uriFld.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				if (settingUriFld > 0) {
					return;
				}
				setURI(uriFld.getText());
				setResource(null);
			}
		});
		loadBtn.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				setResource(loadResource());
			}
		});
	}

	protected void createAdditionalControls(Composite parent) {
	}

	public void setReadOnly(boolean value) {
		readOnly = value;
		uriFld.setEnabled(!value);
		browseFsBtn.setEnabled(!value);
		browseWsBtn.setEnabled(!value);
		findInWsBtn.setEnabled(!value);
	}

	protected void initControls() {
		if (rloc == null || getModelFileExtensions() == null) {
			return;
		}
		List<URI> uris = rloc.getSelectedURIs(getModelFileExtensions());
		if (!uris.isEmpty()) {
			setURI(uris.get(0));
			updateURI();
		}
	}

	/**
	 * Updates resource and text control to reflect used URI.
	 */
	public void updateURI() {
		if (readOnly) {
			return;
		}
		try {
			settingUriFld++;
			if (uri != null) {
				uriFld.setText(uri.toString());
				setResource(loadResource());
			} else {
				uriFld.setText(""); //$NON-NLS-1$
				setResource(null);
			}
		} finally {
			settingUriFld--;
		}
	}

	/**
	 * Changes URI to the value provided by string representation.
	 */
	public void setURI(String uriText) {
		if (readOnly) {
			return;
		}
		if (uriText == null || uriText.trim().length() == 0) {
			uri = null;
			loadBtn.setEnabled(false);
			setErrorMessage(null);
			return;
		}
		try {
			uri = URI.createURI(uriText.trim());
			loadBtn.setEnabled(true);
			setErrorMessage(null);
		} catch (IllegalArgumentException iae) {
			uri = null;
			loadBtn.setEnabled(false);
			setErrorMessage(NLS.bind(Messages.ModelSelectionPageBadURI, iae.getLocalizedMessage()));
			return;
		}
	}

	public void setURI(URI uri) {
		if (readOnly) {
			return;
		}
		this.uri = uri;
		loadBtn.setEnabled(uri != null);
		setErrorMessage(null);
	}

	public final URI getURI() {
		return uri;
	}

	/**
	 * Unloads current resource.
	 */
	protected void unloadResource() {
		if (this.resource != null) {
			if (this.resource.isLoaded()) {
				this.resource.unload();
			}
			getResourceSet().getResources().remove(this.resource);
			this.resource = null;
		}
	}

	/**
	 * Loads a resource.
	 * 
	 * @return resource, or null if loading failed
	 */
	protected Resource loadResource() {
		unloadResource();
		assert uri != null;
		Resource resource = getResourceSet().createResource(uri, ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		if (resource == null) {
			setErrorMessage(Messages.ModelSelectionPageModelNA);
			return null;
		}
		try {
			resource.load(Collections.EMPTY_MAP);
		} catch (IOException ioe) {
			setErrorMessage(NLS.bind(Messages.ModelSelectionPageErrorLoadingModel, ioe.getLocalizedMessage()));
			return null;
		}
		setErrorMessage(null);
		return resource;
	}

	/**
	 * Set a new resource.
	 * Unloads the previous resource and loads a new one,
	 * as well as performs the validation and notifies about the change event.
	 * 
	 * @param resource
	 */
	protected final void setResource(Resource resource) {
		unloadResource();
		this.resource = resource;
		validatePage();
		resourceChanged();
	}

	/**
	 * Validates the page.
	 */
	public void validatePage() {
		if (modelRequired) {
			setPageComplete(resource != null);
		}
	}

	@Override
	public void setVisible(boolean visible) {
		if (!initialized && visible) {
			initialized = true;
			initControls();
		}
		super.setVisible(visible);
	}

	/**
	 * Shall be overridden to handle a resource change event.
	 */
	protected void resourceChanged() {
	}

	/**
	 * Returns loaded resource.
	 * 
	 * @return resource
	 */
	public final Resource getResource() {
		return resource;
	}

	/**
	 * Returns indicator if model is required for the page to be completed.
	 * 
	 * @return
	 */
	public final boolean isModelRequired() {
		return modelRequired;
	}

	/**
	 * Sets model required flag.
	 * 
	 * @param modelRequired
	 */
	public void setModelRequired(boolean modelRequired) {
		this.modelRequired = modelRequired;
		validatePage();
	}

}
