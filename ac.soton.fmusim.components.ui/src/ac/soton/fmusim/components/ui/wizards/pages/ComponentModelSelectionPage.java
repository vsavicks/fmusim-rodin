/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.wizards.pages;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;

import ac.soton.fmusim.components.ui.resource.ResourceLocationProvider;
import ac.soton.fmusim.components.ui.wizards.pages.experimental.DomainModelSource;

/**
 * Component model selection page that supports two types of resources:
 * Event-B machines and FMU models.
 * 
 * @author vitaly
 *
 */
public class ComponentModelSelectionPage extends ExtensibleModelSelectionPage implements DomainModelSource {

	private static final String COMP = "componentModel";

	private EPackage contents;

	public ComponentModelSelectionPage(String pageId, ResourceLocationProvider rloc, ResourceSet resourceSet) {
		super(pageId, rloc, resourceSet, new String[]{"bum","fmu"});
	}

	protected void addExtensions() {
		addExtension(COMP, new ComponentSelectorExtension());
	}

	@Override
	//FIXME: fmu does not have epackage
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

	/* (non-Javadoc)
	 * @see ac.soton.fmusim.components.ui.wizards.pages.DomainModelSource#getContents()
	 */
	@Override
	//FIXME: not for fmu
	public EPackage getContents() {
		return contents;
	}
	
	/* (non-Javadoc)
	 * @see ac.soton.fmusim.components.ui.wizards.pages.DomainModelSource#isDisabled(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public boolean isDisabled(EObject domainElement) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see ac.soton.fmusim.components.ui.wizards.pages.DomainModelSource#getDiagramElement()
	 */
	@Override
	public EClass getDiagramElement() {
		// TODO Auto-generated method stub
		return null;
	}

}
