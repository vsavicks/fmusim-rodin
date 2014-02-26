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
import org.eclipse.swt.layout.FillLayout;
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
	private EventBNamedComboContainer timeVariableCombo;
	private EditableTableViewerContainer readEventsViewer;
	private EditableTableViewerContainer waitEventsViewer;
	private DecoratedInputValidator stepPeriodValidator;
	private boolean stepPeriodValid;

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
		
		createParamGroup(plate).setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		createEventGroup(plate).setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		addValidators();
		addListeners();
		return plate;
	}
	
	/**
	 * Creates a group of UI controls for defining component parameters.
	 * 
	 * @param parent
	 * @return 
	 */
	private Group createParamGroup(Composite parent) {
		Group group = createLabeledGroup(parent, "Parameters", "Enter simulation step period, Real signal conversion precision and select time variable");
		FillLayout layout = new FillLayout(SWT.VERTICAL);
		layout.marginWidth = 5;
		layout.marginHeight = 5;
		group.setLayout(layout);
		
		stepPeriodText = createLabeledText(group, "Step Period:", "Enter time period of one simulation step");
		timeVariableCombo = createLabeledEventBNamedCombo(group, "Time Variable:", "Select variable that holds the simulation time (optional)");
		
		return group;
	}

	/**
	 * Creates a group of UI controls for defining simulation events.
	 * 
	 * @param parent
	 * @return 
	 */
	private Group createEventGroup(Composite parent) {
		Group group = createLabeledGroup(parent, "Events", "Select Event-B machine events for reading inputs and simulation step wait");
		FillLayout layout = new FillLayout(SWT.VERTICAL);
		layout.marginWidth = 5;
		layout.marginHeight = 5;
		group.setLayout(layout);
		
		readEventsViewer = createLabeledEditableTable(group, "Read Input:", "Add/Remove events for reading input signals", createEventColumnProviders(), null);
		waitEventsViewer = createLabeledEditableTable(group, "Wait:", "Add/Remove events for simulation step wait", createEventColumnProviders(), null);
		
		return group;
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
		waitEventsViewer.setChangeListener(new Listener() {
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

	/**
	 * Creates Event-B Event column providers.
	 * 
	 * @return
	 */
	private List<ColumnProvider> createEventColumnProviders() {
		ArrayList<ColumnProvider> providers = new ArrayList<ColumnProvider>();
		providers.add(new ColumnProvider("Name", 200, new ColumnLabelProvider() {
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
			timeVariableCombo.setInput(currentModel.getMachine().getVariables(), currentModel.getTimeVariable());
			readEventsViewer.setInput(currentModel.getMachine().getEvents(), currentModel.getReadInputEvents());
			waitEventsViewer.setInput(currentModel.getMachine().getEvents(), currentModel.getWaitEvents());
			
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
		valid &= stepPeriodValid;
		valid &= waitEventsViewer.getInput() != null && ((List<?>) waitEventsViewer.getInput()).size() > 0;
		
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
