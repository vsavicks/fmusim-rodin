/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.resource;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import de.prob.cosimulation.FMU;

/**
 * FMU resource.
 * 
 * @author vitaly
 *
 */
//TODO: add unloading
public class FMUResource extends ResourceImpl {
	
	private FMU fmu;
	private String fmuPath;

	/**
	 * Creates an abstract FMU resource from the URI.
	 * The resource does not have to exist at this point,
	 * but has to exist if you try to load it.
	 * 
	 * @param uri resource URI
	 */
	public FMUResource(URI uri) {
		super(uri);
		fmu = null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.resource.impl.ResourceImpl#load(java.util.Map)
	 */
	@Override
	public void load(Map<?, ?> options) throws IOException {
		String filePath = null;
		if (uri.isPlatform()) {
			String ps = uri.toPlatformString(true);
			IResource res = ResourcesPlugin.getWorkspace().getRoot().findMember(ps);
			filePath = res.getLocation().toString();
		} else if (uri.isFile()) {
			filePath = uri.toFileString();
		} else {
			throw new IOException("Loading FMU resource failed: unsupported resource URI" + "\"" + uri + "\"");
		}
		
		// file path validity
		if (filePath == null || new File(filePath).exists() == false) {
			throw new IOException("Loading FMU resource failed: invalid resource file path " + "\"" + filePath + "\"");
		}
		
		fmu = new FMU(filePath);
		fmuPath = filePath;
	}
	
	
	
	/**
	 * Returns resource fmu.
	 * 
	 * @return fmu, or null of not loaded
	 */
	public FMU getFMU() {
		return fmu;
	}

	/**
	 * Returns absolute path to fmu.
	 * 
	 * @return the fmuPath
	 */
	public String getFmuPath() {
		return fmuPath;
	}
}