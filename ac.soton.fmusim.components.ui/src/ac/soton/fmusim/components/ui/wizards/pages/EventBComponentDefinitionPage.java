/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.wizards.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.EList;
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
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Parameter;
import org.eventb.emf.core.machine.Variable;

import ac.soton.fmusim.components.EventBComponent;
import ac.soton.fmusim.components.EventBPort;
import ac.soton.fmusim.components.VariableCausality;
import ac.soton.fmusim.components.ui.dialogs.EventBPortDialog;

/**
 * @author vitaly
 *
 */
public class EventBComponentDefinitionPage extends WizardPage {

	private ComponentModelSource source;
	private TableViewer inputsViewer;
	private TableViewer outputsViewer;
	private Combo readEventCombo;
	private Combo writeEventCombo;
	private Combo updateEventCombo;
	private Combo timeVariableCombo;
	private EventBComponent currentModel;

	/**
	 * @param pageName
	 */
	public EventBComponentDefinitionPage(String pageName, ComponentModelSource source) {
		super(pageName);
		this.source = source;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
//		setPageComplete(false);
		setControl(createEventBComponentDefinitionGroup(parent));
	}
	
	/**
	 * Creates a group of component definition controls:
	 * - table of input ports
	 * - table of output ports
	 * - read inputs event selection combo
	 * - write outputs event selection combo
	 * - update event selection combo
	 * - time variable selection combo
	 * 
	 * @param parent
	 * @return
	 */
	private Control createEventBComponentDefinitionGroup(Composite parent) {
		// layout
		Composite plate = new Composite(parent, SWT.NULL);
		plate.setLayout(new GridLayout());
		plate.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		createEventGroup(plate);
		createTimeGroup(plate);
		createPortGroup(plate);
		return plate;
	}

	/**
	 * Creates a group of combos for defining ports.
	 * 
	 * @param parent
	 */
	private void createPortGroup(Composite parent) {
		Group group = new Group(parent, SWT.SHADOW_ETCHED_IN);
		group.setLayout(new GridLayout());
		group.setText("Define input/output ports to be displayed in Event-B component");
		
		// input and output port tables
		inputsViewer = createEventBPortTable(group, "Input:", createColumnProviders(), null, VariableCausality.INPUT);
		outputsViewer = createEventBPortTable(group, "Output:", createColumnProviders(), null, VariableCausality.OUTPUT);
		
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

	/**
	 * Creates a group of elemets for defining time.
	 * 
	 * @param parent
	 */
	private void createTimeGroup(Composite parent) {
		Group group = new Group(parent, SWT.SHADOW_ETCHED_IN);
		group.setLayout(new GridLayout());
		group.setText("Optionally select Event-B variable that will be used to store the simulation time");
		
		// time variable combo
		timeVariableCombo = createListCombo(group, "Time Variable:");
		timeVariableCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				EventBNamed element = readEventBListCombo(timeVariableCombo);
				currentModel.setTimeVariable((Variable) element);
			}
		});
		
		group.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
	}
	
	/**
	 * Creates a group of combos for defining control events.
	 * 
	 * @param parent
	 */
	private void createEventGroup(Composite parent) {
		Group group = new Group(parent, SWT.SHADOW_ETCHED_IN);
		group.setLayout(new GridLayout());
		group.setText("Select Event-B machine events for reading inputs, writing outputs and control cycle update");
		
		// event combos: read inputs event, write outputs event, update event
		readEventCombo = createListCombo(group, "Read:");
		readEventCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				EventBNamed element = readEventBListCombo(readEventCombo);
				currentModel.setReadInputsEvent((Event) element);
			}
		});
		
		writeEventCombo = createListCombo(group, "Write:");
		writeEventCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				EventBNamed element = readEventBListCombo(writeEventCombo);
				currentModel.setWriteOutputsEvent((Event) element);
			}
		});
		
		updateEventCombo = createListCombo(group, "Update:");
		updateEventCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				EventBNamed element = readEventBListCombo(updateEventCombo);
				currentModel.setUpdateEvent((Event) element);
			}
		});
		
		group.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
	}

	/**
	 * Creates a labeled combo control.
	 * Label width is fixed to 100.
	 * 
	 * @param parent parent control
	 * @param name combo label
	 * @return
	 */
	private Combo createListCombo(Composite parent, String name) {
		Composite plate = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		plate.setLayout(layout);
		
		Label label = new Label(plate, SWT.NONE);
		label.setText(name);
		label.setLayoutData(new GridData(100, SWT.DEFAULT));
		Combo combo = new Combo(plate, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		
		plate.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		return combo;
	}

	/**
	 * Creates a list of column providers for the port definition tables (both input and output).
	 * Providers include columns for: name, type
	 * 
	 * @return list of column providers
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
		providers.add(new ColumnProvider("Parameter", 100, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Parameter parameter = ((EventBPort) element).getEventParameter();
				return  parameter == null ? null : parameter.getName();
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
			label.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));
			
			// table
			final TableViewer tableViewer = new TableViewer(plate, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);
			tableViewer.getControl().setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
			createColumns(tableViewer, columnProviders);
			tableViewer.getTable().setHeaderVisible(true);
			tableViewer.setContentProvider(ArrayContentProvider.getInstance());
			if (filter != null)
				tableViewer.addFilter(filter);
			
			// buttons plate
			Composite buttonPlate = new Composite(plate, SWT.NONE);
			GridLayout buttonLayout = new GridLayout(1, false);
			buttonPlate.setLayout(buttonLayout);
			
			// add/remove buttons
			Button addButton = new Button(buttonPlate, SWT.PUSH);
			addButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
			addButton.setText("Add");
			addButton.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					// remember selection
					int idx = tableViewer.getTable().getSelectionIndex();
					
					// check if corresponding event for a new port is set
					EventBNamed event = null;
					String errorMessage = null;
					switch (causality) {
						case INPUT:
							event = readEventBListCombo(readEventCombo);
							errorMessage = "Please select an event for reading inputs first";
							break;
						case OUTPUT:
							event = readEventBListCombo(writeEventCombo);
							errorMessage = "Please select an event for writing outputs first";
							break;
						default:
							break;
					}
//					if (event == null) {
//						setErrorMessage(errorMessage);
//						return;
//					}
					
					// create and add new port
					EventBPortDialog dialog = new EventBPortDialog(getShell(), currentModel, causality, (Event) event);
					if (Dialog.OK == dialog.open()) {
						EventBPort port = dialog.getPort();
						if (port == null)
							return;
						
						// add port / refresh table
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
			removeButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
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
				@Override
				public void widgetSelected(SelectionEvent e) {
					removeButton.setEnabled(true);
				}
			});

			buttonPlate.setLayoutData(new GridData(GridData.FILL_VERTICAL));
			plate.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
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
			
			// set combo input
			setEventBListComboInput(readEventCombo, currentModel.getMachine().getEvents(), currentModel.getReadInputsEvent());
			setEventBListComboInput(writeEventCombo, currentModel.getMachine().getEvents(), currentModel.getWriteOutputsEvent());
			setEventBListComboInput(updateEventCombo, currentModel.getMachine().getEvents(), currentModel.getUpdateEvent());
			setEventBListComboInput(timeVariableCombo, currentModel.getMachine().getVariables(), currentModel.getTimeVariable());
			
			// set table input
			inputsViewer.setInput(currentModel.getInputs());
			outputsViewer.setInput(currentModel.getOutputs());
			
			// clear error message
//			setErrorMessage(null);
			
			((Composite) getControl()).layout(true, true);
		}
	}

	/**
	 * Sets combo input, expecting a list of EventBNamed elements.
	 * 
	 * @param combo
	 * @param elements
	 * @param selectedElement 
	 */
	private void setEventBListComboInput(Combo combo, EList<? extends EventBNamed> elements, EventBNamed selectedElement) {
		String[] items = new String[elements.size() + 1];
		int i = 0;
		items[i++] = ""; // empty item
		for (EventBNamed el : elements) {
			items[i++] = el.getName();
		}
		Arrays.sort(items);
		combo.setItems(items);
		combo.setData(elements);
		
		// set selection if provided
		if (selectedElement != null) {
			for (int j = 0; j < items.length; j++) {
				if (selectedElement.getName().equals(items[j])) {
					combo.select(j);
				}
			}
		}
	}
	
	/**
	 * Reads Event-B combo and returns selected element.
	 * 
	 * @param combo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private EventBNamed readEventBListCombo(Combo combo) {
		// assertion checks for validity of data
		assert combo.getData() instanceof EList;
		if (((EList<?>) combo.getData()).size() > 0)
			assert ((EList<?>) combo.getData()).get(0) instanceof EventBNamed;
		
		if (combo.getSelectionIndex() < 0)
			return null;
		
		// find selected item by name
		String itemName = combo.getItem(combo.getSelectionIndex());
		EList<? extends EventBNamed> elements = (EList<? extends EventBNamed>) combo.getData();
		for (EventBNamed el : elements) {
			if (itemName.equals(el.getName())) {
				return el;
			}
		}
		return null;
	}

	public void validatePage() {
		boolean valid = true;
		List input = (List) inputsViewer.getInput();
		List output = (List) outputsViewer.getInput();
		
		if (input.size() > 0)
			valid &= readEventCombo.getSelectionIndex() > 0;
		if (output.size() > 0)
			valid &= writeEventCombo.getSelectionIndex() > 0;
		valid &= updateEventCombo.getSelectionIndex() > 0;
		
		setPageComplete(valid);
	}
	

}
