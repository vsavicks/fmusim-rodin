/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.properties;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.gmf.runtime.notation.View;

import ac.soton.fmusim.components.ComponentDiagram;

/**
 * Property tester for components diagram UI.
 * 
 * @author vitaly
 *
 */
public class ComponentsPropertyTester extends PropertyTester {

	private static final String DIAGRAM_PROPERTY = "isComponentDiagram";

	/* (non-Javadoc)
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 */
	@Override
	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {
		if (false == receiver instanceof View) {
			return false;
		}
		View view = (View) receiver;
		if (DIAGRAM_PROPERTY.equals(property)) {
			return view.getElement() instanceof ComponentDiagram;
		}
		return false;
	}

}
