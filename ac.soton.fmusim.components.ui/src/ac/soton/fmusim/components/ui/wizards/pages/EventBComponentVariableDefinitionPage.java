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

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.eventb.emf.core.machine.Parameter;

import ac.soton.fmusim.components.Component;
import ac.soton.fmusim.components.EventBComponent;
import ac.soton.fmusim.components.EventBPort;
import ac.soton.fmusim.components.EventBVariable;
import ac.soton.fmusim.components.VariableCausality;
import ac.soton.fmusim.components.ui.controls.CheckboxTableViewerContainer;
import ac.soton.fmusim.components.ui.controls.EditableTableViewerContainer;
import ac.soton.fmusim.components.ui.dialogs.EventBPortDialog;
import ac.soton.fmusim.components.ui.providers.ColumnProvider;
import ac.soton.fmusim.components.ui.providers.SelectionDialogProvider;

/**
 * Event-B component variable definition page.
 * Allows to add input/output ports and select variables of Event-B component.
 * 
 * @author vitaly
 *
 */
public class EventBComponentVariableDefinitionPage extends AbstractComponentDefinitionPage {

	private ComponentModelSource source;
	private EventBComponent currentModel;
	
	// UI elements
	private EditableTableViewerContainer inputsViewer;
	private EditableTableViewerContainer outputsViewer;
	private CheckboxTableViewerContainer variablesViewer;

	/**
	 * @param pageName
	 * @param source
	 */
	public EventBComponentVariableDefinitionPage(String pageName, ComponentModelSource source) {
		super(pageName);
		this.source = source;
	}
	
	@Override
	public void createControl(Composite parent) {
		//TODO: utilise or remove next line
//		setPageComplete(false);
		setControl(createEventBComponentVariableDefinitionGroup(parent));
	}
	
	/**
	 * @param parent
	 * @return
	 */
	private Control createEventBComponentVariableDefinitionGroup(Composite parent) {
		Composite plate = new Composite(parent, SWT.NULL);
		plate.setLayout(new GridLayout());
		plate.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		createPortGroup(plate);
		createVariableGroup(plate);
		return plate;
	}

	/**
	 * Creates a group of UI controls for defining ports.
	 * 
	 * @param parent
	 */
	private void createPortGroup(Composite parent) {
		Group group = createLabeledGroup(parent, "Ports", "Add/Remove input and output ports");
		
		// input and output port tables
		inputsViewer = createLabeledEditableTable(group, "Input:", "Add/Remove input ports", createPortColumnProviders(), null);
		outputsViewer = createLabeledEditableTable(group, "Output:", "Add/Remove output ports", createPortColumnProviders(), null);
		createDialogProviders();
		
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

	private void createDialogProviders() {
		inputsViewer.setSelectionDialogProvider(new SelectionDialogProvider() {
			@Override
			public SelectionDialog getDialog() {
				//XXX: assumes all read input events have the same signature (name and number of parameters), so one event is sufficient for the dialog
				return new EventBPortDialog(getShell(), currentModel, VariableCausality.INPUT, currentModel.getReadInputEvents().get(0));
			}
		});
		outputsViewer.setSelectionDialogProvider(new SelectionDialogProvider() {
			@Override
			public SelectionDialog getDialog() {
				return new EventBPortDialog(getShell(), currentModel, VariableCausality.OUTPUT, null);
			}
		});
	}

	/**
	 * Creates a group of UI controls for defining variables.
	 * 
	 * @param parent
	 */
	private void createVariableGroup(Composite parent) {
		variablesViewer = createLabeledCheckboxTable(parent, "Variables:", "Select variables", createVariableColumnProviders(), null);
	}

	/**
	 * Creates a list of column providers for the port definition tables (both input and output).
	 * 
	 * @return list of column providers
	 */
	private List<ColumnProvider> createPortColumnProviders() {
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
				Parameter parameter = ((EventBPort) element).getParameter();
				// parameter is not required for the output ports
				return  parameter == null ? null : parameter.getName();
			}}));
		return providers;
	}

	private List<ColumnProvider> createVariableColumnProviders() {
		ArrayList<ColumnProvider> providers = new ArrayList<ColumnProvider>();
		providers.add(new ColumnProvider("Name", 100, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((EventBVariable) element).getName();
			}}));
		providers.add(new ColumnProvider("Comment", 200, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((EventBVariable) element).getDescription();
			}}));
		return providers;
	}
	
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			assert source.getModel() instanceof EventBComponent;
			
			// don't refresh the viewers if the model didn't change
			if (currentModel != null && currentModel == source.getModel())
				return;
			
			// set input
			currentModel = (EventBComponent) source.getModel();
			
			inputsViewer.setInput(null, currentModel.getInputs());
			outputsViewer.setInput(null, currentModel.getOutputs());
			variablesViewer.setInput(currentModel.getVariables());
			variablesViewer.setAllChecked(false);
			
			((Composite) getControl()).layout(true, true);
		}
	}

	/**
	 * Returns a list of checked variables.
	 * 
	 * @return
	 */
	public List<EventBVariable> getCheckedVariables() {
		List<EventBVariable> variables = new ArrayList<EventBVariable>();
		for (Object var : variablesViewer.getCheckedElements()) {
			variables.add((EventBVariable) var);
		}
		return variables;
	}
	
	/**
	 * Checks if any element was unchecked in the viewers i.e. model was modified.
	 * 
	 * @return true if modified
	 */
	public boolean isModified() {
		//FIXME: return correct modification flag
		//FIXME: until page is displayed all variables would be added if finished on model selection page, or removed if finished on param page
		return currentModel.getVariables().size() != variablesViewer.getCheckedElements().length;
	}

	public Component getModel() {
		return currentModel;
	}
}
