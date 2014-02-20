/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.controls;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;

import ac.soton.fmusim.components.FMUParameter;

/**
 * Table cell editing support for FMU parameter values.
 * 
 * @author vitaly
 *
 */
public class FMUParameterValueEditingSupport extends EditingSupport {
	
	/**
	 * @param viewer
	 */
	public FMUParameterValueEditingSupport(ColumnViewer viewer) {
		super(viewer);
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return new AbstractVariableValueCellEditor(((TableViewer) getViewer()).getTable(), (FMUParameter) element);
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected Object getValue(Object element) {
		Object value = ((FMUParameter) element).getStartValue();
		return value == null ? "" : value.toString();
	}

	@Override
	protected void setValue(Object element, Object value) {
		((FMUParameter) element).setStartValue(String.valueOf(value));
		getViewer().update(element, null);
	}
}