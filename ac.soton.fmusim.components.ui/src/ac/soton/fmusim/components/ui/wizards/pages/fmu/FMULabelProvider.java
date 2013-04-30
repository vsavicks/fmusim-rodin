/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.wizards.pages.fmu;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

class FMULabelProvider implements ITableLabelProvider {
	
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}
	
	//Set up table content
	public String getColumnText(Object element, int columnIndex) {
		FMUVariable fmuVar = (FMUVariable) element;
		switch (columnIndex) {
		case 0:
			return fmuVar.getName();
		case 1:
			return fmuVar.getType();
		case 2:
			return fmuVar.getVariability();
		case 3:
			return fmuVar.getDesc();
		}
		return "";
	}

	public void dispose() {
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
	}
	
	@Override
	public void removeListener(ILabelProviderListener listener) {
	}
}
