/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.wizards.pages.fmu;

import org.eclipse.jface.viewers.CellLabelProvider;

/**
 * @author vitaly
 *
 */
public class ColumnProvider {

	private final String title;
	private final int bound;
	private final CellLabelProvider labelProvider;

	public ColumnProvider(String title, int bound, CellLabelProvider labelProvider) {
		super();
		this.title = title;
		this.bound = bound;
		this.labelProvider = labelProvider;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the bound
	 */
	public int getBound() {
		return bound;
	}

	/**
	 * @return the labelProvider
	 */
	public CellLabelProvider getLabelProvider() {
		return labelProvider;
	}
	
}
