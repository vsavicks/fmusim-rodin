/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.resource;


import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;


/**
 * Resource factory for creating FMU resources.
 * 
 * @author vitaly
 *
 */
public class FMUResourceFactory implements Resource.Factory {
	
	@Override
	public Resource createResource(URI uri) {
		return new FMUResource(uri);
	}
}