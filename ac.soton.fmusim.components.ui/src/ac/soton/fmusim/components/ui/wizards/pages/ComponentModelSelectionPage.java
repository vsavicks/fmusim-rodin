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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.machine.Machine;

import de.prob.cosimulation.FMU;

import ac.soton.fmusim.components.Component;
import ac.soton.fmusim.components.ComponentsPackage;
import ac.soton.fmusim.components.EventBComponent;
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

	private Component model;

	public ComponentModelSelectionPage(String pageId, ResourceLocationProvider rloc, ResourceSet resourceSet) {
		super(pageId, rloc, resourceSet, new String[]{"bum","fmu"});
	}

	@Override
	protected void resourceChanged() {
		super.resourceChanged();
		model = null;
		Resource resource = getResource();
		if (resource != null) {
			List<EObject> rc = getResource().getContents();
			if (rc.size() >= 1 && rc.get(0) instanceof Machine) {
				EventBComponent component = (EventBComponent) Platform.getAdapterManager().getAdapter(rc.get(0), Component.class);
				if (component != null) {
					// copy component and set a new AbstractExtension reference attribute
					// to avoid conflicts with other instances of the same machine component
					EventBComponent componentCopy = EcoreUtil.copy(component);
					componentCopy.setReference(ComponentsPackage.EVENTB_COMPONENT_EXTENSION_ID + "." + EcoreUtil.generateUUID());
					
					model = componentCopy;
				}
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
//
//	@Override
//	public void validatePage() {
//		super.validatePage();
//		if ()
//	}

	@Override
	public Component getModel() {
		return model;
	}

	@Override
	public boolean like(ComponentModelSource source) {
		return model == source.getModel();
	}

}
