/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.wizards.pages;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;
import org.eventb.emf.core.machine.Event;

import ac.soton.fmusim.components.EventBComponent;
import ac.soton.fmusim.components.EventBPort;
import ac.soton.fmusim.components.VariableCausality;
import ac.soton.fmusim.components.ui.dialogs.EventBPortDialog;
import ac.soton.fmusim.components.ui.wizards.pages.fmu.ColumnProvider;

/**
 * @author vitaly
 *
 */
public class EventBComponentDefinitionPage extends WizardPage {

	private ComponentModelSource source;
	private TableViewer inputsViewer;
	private TableViewer outputsViewer;
	private EventBComponent currentModel;

	/**
	 * @param pageName
	 */
	public EventBComponentDefinitionPage(String pageName, ComponentModelSource source) {
		super(pageName);
		this.source = source;
	}
	
	protected GridData createFillBothGridData(int span) {
		GridData data = new GridData();
		data.verticalAlignment = GridData.FILL;
		data.grabExcessVerticalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		data.grabExcessHorizontalSpace = true;
		data.horizontalSpan = span;
		return data;
	}

	protected GridData createFillHorzGridData(int span) {
		GridData data = new GridData();
		data.horizontalAlignment = GridData.FILL;
		data.grabExcessHorizontalSpace = true;
		data.horizontalSpan = span;
		return data;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
//		setPageComplete(false);
		setControl(createEventBComponentDefinitionGroup(parent));
	}
	
	private Control createEventBComponentDefinitionGroup(Composite parent) {
		// layout
		Composite plate = new Composite(parent, SWT.NULL);
		plate.setLayout(new GridLayout());
		plate.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
		
		// labeled check-box tables
		inputsViewer = createEventBPortTable(plate, "Input:", createColumnProviders(), null, VariableCausality.INPUT);
		outputsViewer = createEventBPortTable(plate, "Output:", createColumnProviders(), null, VariableCausality.OUTPUT);
		
		return plate;
	}
	
	/**
	 * @return
	 */
	private List<ColumnProvider> createColumnProviders() {
		ArrayList<ColumnProvider> providers = new ArrayList<ColumnProvider>();
		providers.add(new ColumnProvider("Name", 100, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((EventBPort) element).getName();
			}}));
		providers.add(new ColumnProvider("Type", 100, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((EventBPort) element).getType().toString();
			}}));
		providers.add(new ColumnProvider("Get Event", 100, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Event event = ((EventBPort) element).getFmiGetEvent();
				return event == null ? null : event.getName();
			}}));
		providers.add(new ColumnProvider("Set Event", 100, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Event event = ((EventBPort) element).getFmiSetEvent();
				return  event == null ? null : event.getName();
			}}));
		return providers;
	}

	/**
	 * Creates a labeled table with columns defined by the column providers and an optional viewer filter.
	 * 
	 * @param parent
	 * @param labelText
	 * @param columnProviders 
	 * @param filter
	 * @return table viewer
	 */
	private TableViewer createEventBPortTable(Composite parent, String labelText, List<ColumnProvider> columnProviders, ViewerFilter filter, final VariableCausality causality) {
		{
			Composite plate = new Composite(parent, SWT.NONE);
			GridLayout layout = new GridLayout(2, false);
			plate.setLayout(layout);
			
			// label
			Label label = new Label(plate, SWT.NONE);
			label.setText(labelText);
			label.setLayoutData(createFillHorzGridData(2));
			
			// table plate (table + buttons)
			Composite tablePlate = new Composite(plate, SWT.NONE);
			GridLayout tableLayout = new GridLayout(2, false);
			tableLayout.verticalSpacing = 12;
			tablePlate.setLayout(tableLayout);
			
			// table
			final TableViewer tableViewer = new TableViewer(tablePlate, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);
			tableViewer.getControl().setLayoutData(createFillBothGridData(1));
			createColumns(tableViewer, columnProviders);
			tableViewer.getTable().setHeaderVisible(true);
			tableViewer.setContentProvider(ArrayContentProvider.getInstance());
			if (filter != null)
				tableViewer.addFilter(filter);
			
			// buttons plate
			Composite buttonPlate = new Composite(tablePlate, SWT.NONE);
			GridLayout buttonLayout = new GridLayout(1, false);
			buttonPlate.setLayout(buttonLayout);
			
			// add/remove buttons
			Button addButton = new Button(buttonPlate, SWT.PUSH);
			addButton.setLayoutData(createFillHorzGridData(1));
			addButton.setText("Add");
			addButton.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					// remember selection
					int idx = tableViewer.getTable().getSelectionIndex();
					
					// create and add new port
					EventBPortDialog dialog = new EventBPortDialog(getShell(), source);
					if (Dialog.OK == dialog.open()) {
						EventBPort port = dialog.getPort();
						if (port == null)
							return;
						
						// add port / refresh table
						port.setCausality(causality);
						Object input = tableViewer.getInput();
						((List) input).add(port);
						tableViewer.refresh();
						
						// restore selection
						if (idx >= 0) {
							tableViewer.getTable().select(idx);
							tableViewer.getTable().notifyListeners(SWT.Selection, new org.eclipse.swt.widgets.Event());
						}
					}
				}});
			
			final Button removeButton = new Button(buttonPlate, SWT.PUSH);
			removeButton.setLayoutData(createFillHorzGridData(1));
			removeButton.setText("Remove");
			removeButton.setEnabled(false);
			removeButton.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					ISelection selection = tableViewer.getSelection();
					if (selection != null && selection instanceof IStructuredSelection) {
						IStructuredSelection sel = (IStructuredSelection) selection;
						//XXX: removing only the first selected element, as table is set to a single selection style
						EventBPort port = (EventBPort) sel.getFirstElement();
						Object input = tableViewer.getInput();
						((List) input).remove(port);
						
						// refresh table and buttons
						tableViewer.refresh();
						removeButton.setEnabled(false);
					}
				}});
			
			// button behaviour based on the table state
			tableViewer.getTable().addSelectionListener(new SelectionAdapter() {

				/* (non-Javadoc)
				 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
				 */
				@Override
				public void widgetSelected(SelectionEvent e) {
					removeButton.setEnabled(true);
				}
			});

			buttonPlate.setLayoutData(new GridData(GridData.FILL_VERTICAL));
			tablePlate.setLayoutData(createFillBothGridData(2));
			plate.setLayoutData(createFillBothGridData(1));
			return tableViewer;
		}
	}

	/**
	 * Creates check-box table columns from the column providers.
	 * 
	 * @param tableViewer
	 * @param columnProviders
	 */
	private void createColumns(TableViewer tableViewer, List<ColumnProvider> columnProviders) {
		for (ColumnProvider provider : columnProviders) {
			TableViewerColumn column = createTableViewerColumn(tableViewer, provider.getTitle(), provider.getBound());
			column.setLabelProvider(provider.getLabelProvider());
		}
	}

	/**
	 * Creates a table viewer column.
	 * 
	 * @param tableViewer  table viewer
	 * @param title column title
	 * @param bound column width bound
	 * @return table viewer column
	 */
	private TableViewerColumn createTableViewerColumn(TableViewer tableViewer, String title, int bound) {
		TableViewerColumn viewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		return viewerColumn;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
	 */
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			assert source.getModel() instanceof EventBComponent;
			
			// don't refresh the viewers if the model didn't change
			if (currentModel != null && currentModel == source.getModel())
				return;
			
			currentModel = (EventBComponent) source.getModel();
			
			inputsViewer.setInput(currentModel.getInputs());
			outputsViewer.setInput(currentModel.getOutputs());
			((Composite) getControl()).layout(true, true);
		}
	}

}
