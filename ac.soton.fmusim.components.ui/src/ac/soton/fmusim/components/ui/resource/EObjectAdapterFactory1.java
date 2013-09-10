/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.resource;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eventb.core.basis.MachineRoot;

/**
 * @author vitaly
 *
 */
public class EObjectAdapterFactory1 implements IAdapterFactory {

	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adaptableObject instanceof MachineRoot) {
			return getEObject((MachineRoot) adaptableObject);
		}
		return null;
	}

	/**
	 * Returns root EObject from MachineRoot.
	 * 
	 * @param machineRoot
	 * @return
	 */
	private Object getEObject(MachineRoot machineRoot) {
		IFile file = machineRoot.getResource();
		if (file != null && file.exists()) {
			URI machineURI = URI.createPlatformResourceURI(file.getFullPath().toOSString(), true);
			TransactionalEditingDomain domain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
			Resource resource = domain.getResourceSet().getResource(machineURI, true);
			if (resource != null && resource.isLoaded()) {
				return resource.getContents().get(0);
			}
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class[] getAdapterList() {
		return new Class[]{MachineRoot.class};
	}

}
