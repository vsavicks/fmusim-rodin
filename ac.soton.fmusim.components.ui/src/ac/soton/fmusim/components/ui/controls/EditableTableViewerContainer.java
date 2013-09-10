/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.controls;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.eclipse.ui.dialogs.SelectionDialog;

import ac.soton.fmusim.components.ui.providers.ColumnProvider;
import ac.soton.fmusim.components.ui.providers.SelectionDialogProvider;


/**
 * Table viewer container with Add and Remove buttons for editing the table.
 * 
 * @author vitaly
 *
 */
public class EditableTableViewerContainer extends TableViewerContainer {

	private Composite plate;
	private List<?> inputSource;
	int idColumnIndex;
	private Button addButton;
	private Button removeButton;
	private Listener changeListener;
	private SelectionDialogProvider dialogProvider;

	/**
	 * Contructor.
	 * @param viewer
	 */
	public EditableTableViewerContainer(TableViewer viewer) {
		super(viewer);
		
		// swap table parent to composite
		Composite parent = tableViewer.getTable().getParent();
		plate = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		plate.setLayout(layout);
		tableViewer.getTable().setParent(plate);
		tableViewer.getTable().setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
		
		// buttons
		Composite buttonPlate = new Composite(plate, SWT.NONE);
		GridLayout buttonLayout = new GridLayout(1, false);
		buttonPlate.setLayout(buttonLayout);
					
		addButton = new Button(buttonPlate, SWT.PUSH);
		addButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		addButton.setText("Add");
		addButton.addSelectionListener(new SelectionAdapter() {

			@SuppressWarnings("unchecked")
			@Override
			public void widgetSelected(SelectionEvent e) {
				// remember selection
				int idx = tableViewer.getTable().getSelectionIndex();
				
				// select elements to add
				SelectionDialog selectionDialog = getSelectionDialog();
//				eventsDialog.setTitle(machine.getName() + " Events");
//				eventsDialog.setMessage("Please select events for this transition to elaborate");
				if (Dialog.OK == selectionDialog.open()) {
					Object[] result = selectionDialog.getResult();
					if (result != null) {
						List<Object> newElements = new ArrayList<Object>();
						for (Object obj : result)
							newElements.add(obj);
						
						Object input = tableViewer.getInput();
						((List<Object>) input).addAll(newElements);
						tableViewer.refresh();
						
						// restore selection
						if (idx >= 0) {
							tableViewer.getTable().select(idx);
							tableViewer.getTable().notifyListeners(SWT.Selection, new org.eclipse.swt.widgets.Event());
						}
						
						// notify about the change
						notifyChanged();
					}
				}
			}});
					
		removeButton = new Button(buttonPlate, SWT.PUSH);
		removeButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		removeButton.setText("Remove");
		removeButton.setEnabled(false);
		removeButton.addSelectionListener(new SelectionAdapter() {

			@SuppressWarnings("rawtypes")
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tableViewer.getSelection();
				if (selection != null && selection instanceof IStructuredSelection) {
					IStructuredSelection sel = (IStructuredSelection) selection;
					List input = (List) tableViewer.getInput();
					for (Iterator it = sel.iterator(); it.hasNext(); ) {
						Object element = it.next();
						input.remove(element);
					}
					
					// refresh table and buttons
					tableViewer.refresh();
					removeButton.setEnabled(false);
					
					// notify about the change
					notifyChanged();
				}
			}});
					
		// button enabling behaviour based on the table state
		tableViewer.getTable().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				removeButton.setEnabled(true);
			}
		});

		buttonPlate.setLayoutData(new GridData(GridData.FILL_VERTICAL));
	}
	
	/**
	 * Creates table columns from the column providers.
	 * 
	 * @param columnProviders list of column providers
	 * @param idColumnIndex index of ID column provider, also used when selecting new elements
	 */
	public void setColumnProviders(List<ColumnProvider> columnProviders, int idColumnIndex) {
		super.setColumnProviders(columnProviders);
		
		assert idColumnIndex >= 0 && idColumnIndex < columnProviders.size();
		this.idColumnIndex = idColumnIndex;
	}

	/**
	 * Returns input source for the default implementation of getSelectionDialog(),
	 * which allows to add elements from this source to the table.
	 * 
	 * @return
	 */
	protected List<?> getInputSource() {
		return inputSource;
	}

	/**
	 * Returns input label provider for the default implementation of getSelectionDialog().
	 * @return
	 */
	protected ILabelProvider getInputLabelProvider() {
		// if column providers defined, use ID provider (default is 0, if not set)
		if (columnProviders != null)
			return (ILabelProvider) columnProviders.get(idColumnIndex).getLabelProvider();
		
		// or use default label provider
		return new LabelProvider();
	}

	/**
	 * Sets layout data for the button table viewer.
	 * 
	 * @param layoutData
	 */
	public void setLayoutData(Object layoutData) {
		plate.setLayoutData(layoutData);
	}

	/**
	 * Sets table viewer input.
	 * 
	 * @param source input source (can be null if a selection dialog is used as element source)
	 * @param input current table content
	 */
	public void setInput(List<?> source, Object input) {
		super.setInput(input);
		inputSource = source;
	}
	
	/**
	 * Sets table listener that will be notified
	 * about the changes of the table content.
	 * 
	 * @param listener
	 */
	public void setChangeListener(Listener listener) {
		changeListener = listener;
	}
	
	/**
	 * @param dialog
	 */
	public void setSelectionDialogProvider(SelectionDialogProvider provider) {
		dialogProvider = provider;
	}

	/**
	 * Returns selection dialog, used when pressing Add button to add elements to the table.
	 * If selection dialog provider is not set, by default a ListSelectionDialog is returned,
	 * Override or set dialog provider via setSelectionDialogProvider() if custom dialog is required.
	 * 
	 * @return
	 */
	protected SelectionDialog getSelectionDialog() {
		if (dialogProvider == null) {
			return new ListSelectionDialog(tableViewer.getControl().getShell(), getInputSource(), new ArrayContentProvider(), getInputLabelProvider(), null);
		}
		return dialogProvider.getDialog();
	}
	
	/**
	 * Notifies registered change listener if table content has changed.
	 */
	protected void notifyChanged() {
		if (changeListener != null)
			changeListener.handleEvent(null);
	}

}
