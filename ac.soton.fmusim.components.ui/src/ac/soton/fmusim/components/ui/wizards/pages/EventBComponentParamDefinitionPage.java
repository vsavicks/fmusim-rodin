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

import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Variable;

import ac.soton.fmusim.components.Component;
import ac.soton.fmusim.components.EventBComponent;
import ac.soton.fmusim.components.ui.controls.EditableTableViewerContainer;
import ac.soton.fmusim.components.ui.controls.EventBNamedComboContainer;
import ac.soton.fmusim.components.ui.dialogs.DecoratedInputValidator;
import ac.soton.fmusim.components.ui.providers.ColumnProvider;

/**
 * Event-B component parameter definition page.
 * Allows to define simulation parameters, specific to Event-B components.
 * 
 * @author vitaly
 *
 */
public class EventBComponentParamDefinitionPage extends AbstractComponentDefinitionPage {

	private ComponentModelSource source;
	private EventBComponent currentModel;
	
	// UI elements
	private Text stepPeriodText;
	private Text precisionText;
	private EventBNamedComboContainer timeVariableCombo;
	private EditableTableViewerContainer readEventsViewer;
	private EditableTableViewerContainer updateEventsViewer;
	private DecoratedInputValidator stepPeriodValidator;
	private DecoratedInputValidator precisionValidator;
	private boolean stepPeriodValid;
	private boolean precisionValid;

	/**
	 * @param pageName
	 * @param source
	 */
	public EventBComponentParamDefinitionPage(String pageName, ComponentModelSource source) {
		super(pageName);
		this.source = source;
	}
	
	@Override
	public void createControl(Composite parent) {
		//TODO: utilise or remove the next line
//		setPageComplete(false);
		setControl(createEventBComponentParameterDefinitionGroup(parent));
	}
	
	/**
	 * Creates a group of component parameter definition controls.
	 * 
	 * @param parent
	 * @return
	 */
	private Control createEventBComponentParameterDefinitionGroup(Composite parent) {
		Composite plate = new Composite(parent, SWT.NULL);
		plate.setLayout(new GridLayout());
		plate.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		createParamGroup(plate);
		createEventGroup(plate);
		addValidators();
		addListeners();
		return plate;
	}
	
	/**
	 * Creates a group of UI controls for defining component parameters.
	 * 
	 * @param parent
	 */
	private void createParamGroup(Composite parent) {
		Group group = createLabeledGroup(parent, "Parameters", "Enter simulation step period, Real signal conversion precision and select time variable");
		
		stepPeriodText = createLabeledText(group, "Step Period:", "Enter time period of one simulation step");
		precisionText = createLabeledText(group, "Precision:", "Enter Real signal to Event-B integer conversion precision (x10 magnitude)");
		timeVariableCombo = createLabeledEventBNamedCombo(group, "Time Variable:", "Select variable that holds the simulation time (optional)");
		
		group.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
	}

	/**
	 * Creates a group of UI controls for defining simulation events.
	 * 
	 * @param parent
	 */
	private void createEventGroup(Composite parent) {
		Group group = createLabeledGroup(parent, "Events", "Select Event-B machine events for reading inputs and simulation step update");
		
		readEventsViewer = createLabeledEditableTable(group, "Read Input:", "Add/Remove events for reading input signals", createEventColumnProviders(), null);
		updateEventsViewer = createLabeledEditableTable(group, "Update:", "Add/Remove events for simulation step update", createEventColumnProviders(), null);
		
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

	/**
	 * Creates and adds input validators for UI controls.
	 */
	private void addValidators() {
		stepPeriodValidator = new DecoratedInputValidator(
				DecoratedInputValidator.createDecorator(stepPeriodText,
						"Please enter simulation step period",
						FieldDecorationRegistry.DEC_ERROR, false)) {
			@Override
			public String isValidInput(String timeString) {
				try {
					double input = Double.parseDouble(timeString);
					if (input <= 0.0)
						return "Simulation step period must be greater that zero";
				} catch (NumberFormatException e) {
					return "Invalid double number format";
				}
				return null;
			}
		};
		
		precisionValidator = new DecoratedInputValidator(
				DecoratedInputValidator.createDecorator(precisionText,
						"Please enter Real signal to Event-B integer conversion precision (x10 magnitude)",
						FieldDecorationRegistry.DEC_ERROR, false)) {
			@Override
			public String isValidInput(String stepString) {
				try {
					@SuppressWarnings("unused")
					int input = Integer.parseInt(stepString);
				} catch (NumberFormatException e) {
					return "Invalid integer number format";
				}
				return null;
			}
		};
		
		//TODO: add decorators for invalid (absent) read/update events
//		stepToTimeErrorDecorator = DecoratedInputValidator.createDecorator(stepText,
//				"Step size cannot exceed simulation time",
//				FieldDecorationRegistry.DEC_ERROR, false);
	}

	/**
	 * Creates and adds listeners to UI controls.
	 */
	private void addListeners() {
		stepPeriodText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				if (validateStepPeriod())
					currentModel.setStepPeriod(Double.parseDouble(stepPeriodText.getText()));
			}
		});
		precisionText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				if (validatePrecision())
					currentModel.setRealPrecision(Integer.parseInt(precisionText.getText()));
			}
		});
		timeVariableCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				EventBNamed element = timeVariableCombo.getSelected();
				currentModel.setTimeVariable((Variable) element);
			}
		});
		readEventsViewer.setChangeListener(new Listener() {
			@Override
			public void handleEvent(org.eclipse.swt.widgets.Event event) {
				validatePage();
			}
		});
		updateEventsViewer.setChangeListener(new Listener() {
			@Override
			public void handleEvent(org.eclipse.swt.widgets.Event event) {
				validatePage();
			}
		});
	}

	protected boolean validateStepPeriod() {
		if (stepPeriodValidator != null) {
			stepPeriodValid = stepPeriodValidator.isValid(stepPeriodText.getText()) == null;
		}
		validatePage();
		return stepPeriodValid;
	}

	protected boolean validatePrecision() {
		if (precisionValidator != null) {
			precisionValid = precisionValidator.isValid(precisionText.getText()) == null;
		}
		validatePage();
		return precisionValid;
	}

	/**
	 * Creates Event-B Event column providers.
	 * 
	 * @return
	 */
	private List<ColumnProvider> createEventColumnProviders() {
		ArrayList<ColumnProvider> providers = new ArrayList<ColumnProvider>();
		providers.add(new ColumnProvider("Name", 100, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((Event) element).getName();
			}}));
		providers.add(new ColumnProvider("Refines", 200, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				String refinesNames = ((Event) element).getRefinesNames().toString();
				return refinesNames.substring(1, refinesNames.length()-1);
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
			stepPeriodText.setText(Double.toString(currentModel.getStepPeriod()));
			precisionText.setText(Integer.toString(currentModel.getRealPrecision()));
			timeVariableCombo.setInput(currentModel.getMachine().getVariables(), currentModel.getTimeVariable());
			readEventsViewer.setInput(currentModel.getMachine().getEvents(), currentModel.getReadInputEvents());
			updateEventsViewer.setInput(currentModel.getMachine().getEvents(), currentModel.getUpdateEvents());
			
			// clear error message
			//TODO: implement error messages and input validation
//			setErrorMessage(null);
			
			((Composite) getControl()).layout(true, true);
			
			validatePage();
		}
	}

	/**
	 * Validates page input.
	 */
	public void validatePage() {
		boolean valid = true;
		valid &= stepPeriodValid & precisionValid;
		
		if (readEventsViewer.getInput() != null)
			valid &= ((List<?>) readEventsViewer.getInput()).size() > 0;
		if (updateEventsViewer.getInput() != null)
			valid &= ((List<?>) updateEventsViewer.getInput()).size() > 0;
		
		setPageComplete(valid);
	}

	public boolean isModified() {
		// TODO Auto-generated method stub
		return false;
	}

	public Component getModel() {
		return currentModel;
	}

}
