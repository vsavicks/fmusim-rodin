/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.controls;

import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;


/**
 * Container for checkbox table viewer.
 * 
 * @author vitaly
 *
 */
public class CheckboxTableViewerContainer extends TableViewerContainer {

	/**
	 * @param viewer
	 */
	public CheckboxTableViewerContainer(CheckboxTableViewer viewer) {
		super(viewer);
	}

	/**
	 * Sets the checked state of all elements.
	 * 
	 * @param state true to make all checked, false to uncheck
	 */
	public void setAllChecked(boolean state) {
		((CheckboxTableViewer) tableViewer).setAllChecked(state);
	}

	/**
	 * Returns checked elements.
	 * 
	 * @return
	 */
	public Object[] getCheckedElements() {
		return ((CheckboxTableViewer) tableViewer).getCheckedElements();
	}
	
	public void addCheckStateListener(ICheckStateListener listener) {
		((CheckboxTableViewer) tableViewer).addCheckStateListener(listener);
	}

}
