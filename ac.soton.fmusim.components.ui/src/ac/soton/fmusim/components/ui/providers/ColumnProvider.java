/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.providers;

import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;

/**
 * Column provider class for use in creating the table viewer columns.
 * Provides a column title, bound (column width), label provider and editing support (optional).
 * 
 * @author vitaly
 *
 */
public class ColumnProvider {

	private final String title;
	private final int bound;
	private final CellLabelProvider labelProvider;
	private final EditingSupport editing;
	
	public ColumnProvider(String title, int bound, CellLabelProvider labelProvider) {
		this.title = title;
		this.bound = bound;
		this.labelProvider = labelProvider;
		this.editing = null;
	}

	public ColumnProvider(String title, int bound, CellLabelProvider labelProvider, EditingSupport editing) {
		this.title = title;
		this.bound = bound;
		this.labelProvider = labelProvider;
		this.editing = editing;
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

	/**
	 * @return the editing
	 */
	public EditingSupport getEditingSupport() {
		return editing;
	}
	
}
