/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.wizards.pages;

import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eventb.emf.core.machine.Machine;

import de.prob.cosimulation.FMU;

import ac.soton.fmusim.components.Component;
import ac.soton.fmusim.components.FMUComponent;
import ac.soton.fmusim.components.ui.resource.FMUResource;
import ac.soton.fmusim.components.ui.resource.ResourceLocationProvider;

/**
 * Component model selection page that supports two types of resources:
 * Event-B machines and FMU models.
 * 
 * @author vitaly
 *
 */
public class ComponentModelSelectionPage extends ExtensibleModelSelectionPage implements ComponentModelSource {

	private static final String COMP = "componentModel";
	private Component model;

	public ComponentModelSelectionPage(String pageId, ResourceLocationProvider rloc, ResourceSet resourceSet) {
		super(pageId, rloc, resourceSet, new String[]{"bum","fmu"});
	}

	protected void addExtensions() {
		addExtension(COMP, new ComponentSelectorExtension());
	}

	/* (non-Javadoc)
	 * @see ac.soton.fmusim.components.ui.wizards.pages.ExtensibleModelSelectionPage#resourceChanged()
	 */
	@Override
	protected void resourceChanged() {
		super.resourceChanged();
		model = null;
		Resource resource = getResource();
		if (resource != null) {
			List<EObject> rc = getResource().getContents();
			if (rc.size() >= 1 && rc.get(0) instanceof Machine) {
				model = (Component) Platform.getAdapterManager().getAdapter(rc.get(0), Component.class);
			}
			if (resource instanceof FMUResource) {
				FMU fmu = ((FMUResource) resource).getFMU();
				String path = ((FMUResource) resource).getFmuPath();
				FMUComponent component = (FMUComponent) Platform.getAdapterManager().getAdapter(fmu, Component.class);
				component.setPath(path);
				model = component;
			}
		}
	}

	/* (non-Javadoc)
	 * @see ac.soton.fmusim.components.ui.wizards.pages.experimental.ComponentModelSource#getModel()
	 */
	@Override
	public Component getModel() {
		return model;
	}

	/* (non-Javadoc)
	 * @see ac.soton.fmusim.components.ui.wizards.pages.ComponentModelSource#like(ac.soton.fmusim.components.ui.wizards.pages.ComponentModelSource)
	 */
	@Override
	public boolean like(ComponentModelSource source) {
		return model == source.getModel();
	}

}
