/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.wizards.pages;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eventb.emf.core.machine.Machine;

import ac.soton.fmusim.components.ui.resource.FMUResource;
import ac.soton.fmusim.components.ui.resource.ResourceLocationProvider;
import ac.soton.fmusim.components.ui.wizards.pages.experimental.ComponentModelSource;

/**
 * Component model selection page that supports two types of resources:
 * Event-B machines and FMU models.
 * 
 * @author vitaly
 *
 */
public class ComponentModelSelectionPage extends ExtensibleModelSelectionPage implements ComponentModelSource {

	private static final String COMP = "componentModel";
	private Object model;

//	private EObject contents;

	public ComponentModelSelectionPage(String pageId, ResourceLocationProvider rloc, ResourceSet resourceSet) {
		super(pageId, rloc, resourceSet, new String[]{"bum","fmu"});
	}

	protected void addExtensions() {
		addExtension(COMP, new ComponentSelectorExtension());
	}

	@Override
	protected void resourceChanged() {
		super.resourceChanged();
		model = null;
		Resource resource = getResource();
		if (resource != null) {
			List<EObject> rc = getResource().getContents();
			if (rc.size() >= 1 && rc.get(0) instanceof Machine) {
				model = rc.get(0);
			}
			if (resource instanceof FMUResource) {
				model = ((FMUResource) resource).getFMU();
			}
		}
	}

	/* (non-Javadoc)
	 * @see ac.soton.fmusim.components.ui.wizards.pages.experimental.ComponentModelSource#getModel()
	 */
	@Override
	public Object getModel() {
		return model;
	}

}
