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
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import ac.soton.fmusim.components.AbstractVariable;
import ac.soton.fmusim.components.FMUComponent;
import ac.soton.fmusim.components.FMUPort;
import ac.soton.fmusim.components.FMUVariable;
import ac.soton.fmusim.components.ui.controls.CheckboxTableViewerContainer;
import ac.soton.fmusim.components.ui.providers.ColumnProvider;


/**
 * FMU component definition page class.
 * Displays component's variables and allows to select/deselect them individually for further processing.
 * 
 * @author matthias, vitaly
 *
 */
public class FMUComponentDefinitionPage extends AbstractComponentDefinitionPage {
	
	private ComponentModelSource source;
	private FMUComponent currentModel;

	// UI elements
	private CheckboxTableViewerContainer inputsViewer;
	private CheckboxTableViewerContainer outputsViewer;
	private CheckboxTableViewerContainer internalsViewer;

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
		FillLayout layout = new FillLayout(SWT.VERTICAL);
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		plate.setLayout(layout);
		
		// variable tables
		inputsViewer = createLabeledCheckboxTable(plate, "Input:", "Select input ports", createColumnProviders(), null);
		outputsViewer = createLabeledCheckboxTable(plate, "Output:", "Select output ports", createColumnProviders(), null);
		internalsViewer = createLabeledCheckboxTable(plate, "Internal:", "Select internal variables and parameters", createColumnProviders(), null);
		
		return plate;
	}

	/**
	 * Creates a list of column providers.
	 * 
	 * @return providers
	 */
	private List<ColumnProvider> createColumnProviders() {
		ArrayList<ColumnProvider> providers = new ArrayList<ColumnProvider>();
		providers.add(new ColumnProvider("Name", 200, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((AbstractVariable) element).getName();
			}}));
		providers.add(new ColumnProvider("Type", 70, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((AbstractVariable) element).getType().toString();
			}}));
		providers.add(new ColumnProvider("Value", 70, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Object value = ((AbstractVariable) element).getValue();
				return value == null ? null : value.toString();
			}}));
		providers.add(new ColumnProvider("Description", 200, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((AbstractVariable) element).getDescription();
			}}));
		return providers;
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
			
			// set input
			currentModel = (FMUComponent) source.getModel();
			
			inputsViewer.setInput(currentModel.getInputs());
			outputsViewer.setInput(currentModel.getOutputs());
			internalsViewer.setInput(currentModel.getVariables());
			inputsViewer.setAllChecked(true);
			outputsViewer.setAllChecked(true);
			internalsViewer.setAllChecked(false);
			
			((Composite) getControl()).layout(true, true);
		}
	}

	/**
	 * Returns a list of checked input ports.
	 * @return
	 */
	public List<FMUPort> getCheckedInputs() {
		List<FMUPort> inputs = new ArrayList<FMUPort>();
		for (Object inp : inputsViewer.getCheckedElements()) {
			inputs.add((FMUPort) inp);
		}
		return inputs;
	}
	
	/**
	 * Returns a list of checked output ports.
	 * 
	 * @return
	 */
	public List<FMUPort> getCheckedOutputs() {
		List<FMUPort> outputs = new ArrayList<FMUPort>();
		for (Object inp : outputsViewer.getCheckedElements()) {
			outputs.add((FMUPort) inp);
		}
		return outputs;
	}

	/**
	 * Returns a list of checked internal variables.
	 * 
	 * @return
	 */
	public List<FMUVariable> getCheckedInternals() {
		List<FMUVariable> variables = new ArrayList<FMUVariable>();
		for (Object var : internalsViewer.getCheckedElements()) {
			variables.add((FMUVariable) var);
		}
		return variables;
	}
	
	/**
	 * Returns the model being redefined.
	 * 
	 * @return
	 */
	public FMUComponent getModel() {
		return currentModel;
	}
	
	/**
	 * Checks if any element was unchecked in the viewers i.e. model was modified.
	 * 
	 * @return true if modified
	 */
	public boolean isModified() {
		//FIXME: considers only the number, but not the actual checked/unchecked elements
		//FIXME: current model not set until the page is displayed, so before that everything would be displayed - including all unnecessary internal variables
		return currentModel.getVariables().size() != internalsViewer.getCheckedElements().length
				|| currentModel.getInputs().size() != inputsViewer.getCheckedElements().length
				|| currentModel.getOutputs().size() != outputsViewer.getCheckedElements().length;
	}

}

