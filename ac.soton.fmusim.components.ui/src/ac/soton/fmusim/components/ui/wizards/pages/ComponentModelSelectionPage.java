/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.wizards.pages;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;

import ac.soton.fmusim.components.ui.resource.ResourceLocationProvider;

/**
 * Component model selection page that supports two types of resources:
 * Event-B machines and FMU models.
 * 
 * @author vitaly
 *
 */
public class ComponentModelSelectionPage extends ExtensibleModelSelectionPage {

	private static final String COMP = "componentModel";

	private EPackage contents;

	public ComponentModelSelectionPage(String pageId, ResourceLocationProvider rloc, ResourceSet resourceSet) {
		super(pageId, rloc, resourceSet, new String[]{"bum","fmu"});
	}

	protected void addExtensions() {
		addExtension(COMP, new ComponentSelectorExtension());
	}

	@Override
	protected void resourceChanged() {
		super.resourceChanged();
		contents = null;
		if (getResource() != null) {
			List<EObject> rc = getResource().getContents();
			if (rc.size() >= 1 && rc.get(0) instanceof EPackage) {
				contents = (EPackage) rc.get(0);
			}
		}
	}

	public EPackage getContents() {
		return contents;
	}

//	public EClass getDiagramElement() {
//		return (EClass) ((DiagramElementSelectorExtension) getExtension(DEE)).getModelElement();
//	}

	public boolean isDisabled(EObject domainElement) {
		throw new UnsupportedOperationException();
	}

//	/* (non-Javadoc)
//	 * @see ac.soton.fmusim.components.ui.wizards.pages.ModelSelectionPage#createResource(org.eclipse.emf.common.util.URI)
//	 */
//	@Override
//	protected AbstractResource createResource(URI uri) {
//		String fileExtension = uri.fileExtension();
//		if (fileExtension != null && getModelFileExtensions() != null) {
//			for (String ext : getModelFileExtensions()) {
//				if (fileExtension.equals(ext))
//			}
//		}
//		return null;
//	}
}
