/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.wizards.pages.fmu;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;

import ac.soton.fmusim.components.FMUComponent;
import ac.soton.fmusim.components.FMUPort;
import ac.soton.fmusim.components.FMUVariable;
import ac.soton.fmusim.components.ui.wizards.pages.ComponentModelSource;


/**
 * FMU component definition page class.
 * Displays component's variables and allows to select/deselect them individually for further processing.
 * 
 * @author matthias, vitaly
 *
 */
public class FMUComponentDefinitionPage extends WizardPage {
	
	private CheckboxTableViewer internalsViewer;
	private CheckboxTableViewer inputsViewer;
	private CheckboxTableViewer outputsViewer;
	private ComponentModelSource source;
	private FMUComponent currentModel;

	public FMUComponentDefinitionPage(String pageName, ComponentModelSource source) {
		super(pageName);
		this.source = source;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		setControl(createFMUComponentDefinitionGroup(parent));
	}

	/**
	 * Creates FMU component definition control group.
	 * Consists of three labeled check-box table viewers
	 * for internal, input and output variables.
	 * 
	 * @param parent
	 * @return control
	 */
	private Control createFMUComponentDefinitionGroup(Composite parent) {
		// layout
		Composite plate = new Composite(parent, SWT.NULL);
		plate.setLayout(new GridLayout());
		plate.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		// labeled check-box tables
		internalsViewer = createLabeledTable(plate, "Internal:", createColumnProviders(), null);
		inputsViewer = createLabeledTable(plate, "Input:", createColumnProviders(), null);
		outputsViewer = createLabeledTable(plate, "Output:", createColumnProviders(), null);
		
		return plate;
	}

	/**
	 * Creates a list of column providers.
	 * 
	 * @return providers
	 */
	private List<ColumnProvider> createColumnProviders() {
		ArrayList<ColumnProvider> providers = new ArrayList<ColumnProvider>();
		providers.add(new ColumnProvider("Name", 100, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((FMUVariable) element).getName();
			}}));
		providers.add(new ColumnProvider("Type", 100, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((FMUVariable) element).getType().toString();
			}}));
		providers.add(new ColumnProvider("Value", 100, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Object value = ((FMUVariable) element).getValue();
				return value == null ? null : value.toString();
			}}));
		providers.add(new ColumnProvider("Description", 200, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((FMUVariable) element).getDescription();
			}}));
		return providers;
	}

	/**
	 * Creates a labeled check-box table with columns defined by the column providers and an optional viewer filter.
	 * 
	 * @param parent
	 * @param labelText
	 * @param columnProviders 
	 * @param filter
	 * @return table viewer
	 */
	private CheckboxTableViewer createLabeledTable(Composite parent, String labelText, List<ColumnProvider> columnProviders, ViewerFilter filter) {
		{
			// label
			Label label = new Label(parent, SWT.NONE);
			label.setText(labelText);
			label.setLayoutData(new GridData());
			
			// table
			CheckboxTableViewer tableViewer = CheckboxTableViewer.newCheckList(parent, SWT.BORDER);
			tableViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			createColumns(tableViewer, columnProviders);
			tableViewer.getTable().setHeaderVisible(true);
			tableViewer.setContentProvider(ArrayContentProvider.getInstance());
			if (filter != null)
				tableViewer.addFilter(filter);
			
			return tableViewer;
		}
	}

	/**
	 * Creates check-box table columns from the column providers.
	 * 
	 * @param tableViewer
	 * @param columnProviders
	 */
	private void createColumns(CheckboxTableViewer tableViewer, List<ColumnProvider> columnProviders) {
		// empty column for the check-box control
		TableViewerColumn zeroColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		zeroColumn.setLabelProvider(new ColumnLabelProvider());
		
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
	private TableViewerColumn createTableViewerColumn(CheckboxTableViewer tableViewer, String title, int bound) {
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
		if (visible){
			assert source.getModel() instanceof FMUComponent;
			
			// don't refresh the viewers if the model didn't change
			if (currentModel != null && currentModel == source.getModel())
				return;
			
			currentModel = (FMUComponent) source.getModel();
			internalsViewer.setInput(currentModel.getVariables());
			inputsViewer.setInput(currentModel.getInputs());
			outputsViewer.setInput(currentModel.getOutputs());
			
			internalsViewer.setAllChecked(true);
			inputsViewer.setAllChecked(true);
			outputsViewer.setAllChecked(true);
			
			((Composite) getControl()).layout(true, true);
		}
	}

	/**
	 * @return
	 */
	@SuppressWarnings("unused")
	private boolean validatePage() {
		// TODO Auto-generated method stub
		return true;
	}

	public List<FMUVariable> getCheckedInternals() {
		List<FMUVariable> variables = new ArrayList<FMUVariable>();
		for (Object var : internalsViewer.getCheckedElements()) {
			variables.add((FMUVariable) var);
		}
		return variables;
	}
	
	public List<FMUPort> getCheckedInputs() {
		List<FMUPort> inputs = new ArrayList<FMUPort>();
		for (Object inp : inputsViewer.getCheckedElements()) {
			inputs.add((FMUPort) inp);
		}
		return inputs;
	}
	
	public List<FMUPort> getCheckedOutputs() {
		List<FMUPort> outputs = new ArrayList<FMUPort>();
		for (Object inp : outputsViewer.getCheckedElements()) {
			outputs.add((FMUPort) inp);
		}
		return outputs;
	}
	
	public FMUComponent getModel() {
		return currentModel;
	}
	
	/**
	 * Checks if any element was unchecked in the viewers i.e. model was modified.
	 * 
	 * @return true if modified
	 */
	public boolean isModified() {
		return currentModel.getVariables().size() != internalsViewer.getCheckedElements().length
				|| currentModel.getInputs().size() != inputsViewer.getCheckedElements().length
				|| currentModel.getOutputs().size() != outputsViewer.getCheckedElements().length;
	}

}

