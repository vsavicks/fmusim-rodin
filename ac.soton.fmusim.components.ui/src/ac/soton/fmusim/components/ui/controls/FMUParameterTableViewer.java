/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.controls;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import ac.soton.fmusim.components.FMUParameter;
import ac.soton.fmusim.components.ui.providers.ColumnProvider;

/**
 * Table viewer for displaying FMUParameter elements.
 * Capable of editing variable values via cell editor.
 * 
 * @author vitaly
 *
 */
public class FMUParameterTableViewer extends TableViewer {

	/**
	 * @param parent
	 * @param style
	 */
	public FMUParameterTableViewer(Composite parent, int style) {
		super(parent, style);
		createColumns();
	    Table table = getTable();
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);
		setContentProvider(ArrayContentProvider.getInstance());
	}

	/**
	 * 
	 */
	private void createColumns() {
		List<ColumnProvider> columnProviders = createColumnProviders();
	    for (ColumnProvider provider : columnProviders) {
			TableViewerColumn column = createTableViewerColumn(provider.getTitle(), provider.getBound());
			column.setLabelProvider(provider.getLabelProvider());
			if (provider.getEditingSupport() != null) {
				column.setEditingSupport(provider.getEditingSupport());
			}
		}
	}
	
	/**
	 * @return
	 */
	private List<ColumnProvider> createColumnProviders() {
		ArrayList<ColumnProvider> providers = new ArrayList<ColumnProvider>();
		providers.add(new ColumnProvider("Name", 200, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((FMUParameter) element).getName();
			}}));
		providers.add(new ColumnProvider("Type", 70, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((FMUParameter) element).getType().toString();
			}}));
		providers.add(new ColumnProvider("Value", 70, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Object value = ((FMUParameter) element).getStartValue();
				return value == null ? null : value.toString();
			}}, 
			new FMUParameterValueEditingSupport(this)));
		providers.add(new ColumnProvider("Description", 200, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((FMUParameter) element).getDescription();
			}}));
		return providers;
	}

	/**
	 * Creates a table viewer column.
	 * 
	 * @param title column title
	 * @param bound column width
	 * @return table viewer column
	 */
	private TableViewerColumn createTableViewerColumn(String title, int bound) {
		TableViewerColumn viewerColumn = new TableViewerColumn(this, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		return viewerColumn;
	}

}
