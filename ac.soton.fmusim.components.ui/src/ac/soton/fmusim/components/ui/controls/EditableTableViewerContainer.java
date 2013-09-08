/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.controls;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.common.ui.dialogs.PopupDialog;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.dialogs.SelectionDialog;

import ac.soton.fmusim.components.ui.providers.ColumnProvider;
import ac.soton.fmusim.components.ui.providers.SelectionDialogProvider;


/**
 * Table viewer container with Add and Remove buttons for editing the table.
 * 
 * @author vitaly
 *
 */
public class EditableTableViewerContainer {

	private Composite plate;
	private TableViewer tableViewer;
	private Button addButton;
	private Button removeButton;
	private List<?> inputSource;
	private int idColumnIndex;
	private List<ColumnProvider> columnProviders;
	private Listener changeListener;
	private SelectionDialogProvider dialogProvider;

	/**
	 * Contructor.
	 * @param viewer
	 */
	public EditableTableViewerContainer(TableViewer viewer) {
		assert viewer != null;
		tableViewer = viewer;
		
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
					// removing only the first selected element, as table is set to a single selection style
					Object element = sel.getFirstElement();
					Object input = tableViewer.getInput();
					((List) input).remove(element);
					
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
				//XXX: check that button is also disabled correctly
			}
		});

		buttonPlate.setLayoutData(new GridData(GridData.FILL_VERTICAL));
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
		// if column providers defined, use ID provider
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
	 * Creates table columns from the column providers.
	 * 
	 * @param columnProviders list of column providers
	 * @param idColumnIndex index of ID column provider, also used when selecting new elements
	 */
	public void setColumns(List<ColumnProvider> columnProviders, int idColumnIndex) {
		assert idColumnIndex >= 0 && idColumnIndex < columnProviders.size();
		this.idColumnIndex = idColumnIndex;
		this.columnProviders = columnProviders;
		
		for (ColumnProvider provider : columnProviders) {
			TableViewerColumn column = createTableViewerColumn(tableViewer, provider.getTitle(), provider.getBound());
			column.setLabelProvider(provider.getLabelProvider());
		}
	}

	/**
	 * Creates a table viewer column.
	 * 
	 * @param viewer 
	 * @param title column title
	 * @param bound column width bound
	 * @return table viewer column
	 */
	private TableViewerColumn createTableViewerColumn(TableViewer viewer, String title, int bound) {
		TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		return viewerColumn;
	}

	/**
	 * Returns table viewer.
	 * 
	 * @return
	 */
	public TableViewer getViewer() {
		return tableViewer;
	}

	/**
	 * Sets table viewer input.
	 * 
	 * @param source input source (can be null if a selection dialog is used as element source)
	 * @param input current table content
	 */
	public void setInput(List<?> source, Object input) {
		inputSource = source;
		tableViewer.setInput(input);
	}

	/**
	 * Returns table viewer input.
	 * 
	 * @return
	 */
	public List<?> getInput() {
		return (List<?>) tableViewer.getInput();
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
	 * If selection dialog provider is not set, by default a PopupDialog (list dialog) is returned,
	 * Override or set dialog provider via setSelectionDialogProvider() if custom dialog is required.
	 * 
	 * @return
	 */
	protected SelectionDialog getSelectionDialog() {
		if (dialogProvider == null) {
			return new PopupDialog(tableViewer.getControl().getShell(), getInputSource(), getInputLabelProvider());
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
