/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.providers;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import ac.soton.fmusim.components.AbstractVariable;
import ac.soton.fmusim.components.VariableCausality;

/**
 * Causality filter.
 * Filters abstract variables by accepting only a particular causality.
 * 
 * @author vitaly
 *
 */
public class VariableCausalityFilter extends ViewerFilter {
	
	private VariableCausality causality;

	/**
	 * Constructor accepting causality that filter accepts.
	 */
	public VariableCausalityFilter(VariableCausality causality) {
		this.causality = causality;
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement,
			Object element) {
		assert element instanceof AbstractVariable;
		return ((AbstractVariable) element).getCausality() == causality;
	}
}