/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.wizards.pages;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.widgets.Composite;

/**
 * Component selector extension for the component model selection page.
 * TODO: provide implementation of additional control widgets and resource listener
 *  
 * @author vitaly
 *
 */
public class ComponentSelectorExtension implements
		ModelSelectionPageExtension {

	/* (non-Javadoc)
	 * @see ac.soton.fmusim.components.ui.wizards.ModelSelectionPageExtension#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see ac.soton.fmusim.components.ui.wizards.ModelSelectionPageExtension#setResource(ac.soton.fmusim.components.ui.wizards.AbstractResource)
	 */
	@Override
	public void setResource(Resource resource) {
		// TODO Auto-generated method stub

	}

}
