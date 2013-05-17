/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.wizards.pages;

import ac.soton.fmusim.components.Component;


/**
 * Component model source class.
 * 
 * @author vitaly
 *
 */
public interface ComponentModelSource {

	/**
	 * Returns component model.
	 * @return model
	 */
	public Component getModel();

	/**
	 * Returns true if source is the same.
	 * @param source
	 * @return
	 */
	public boolean like(ComponentModelSource source);

}
