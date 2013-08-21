/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.dialogs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.Parameter;
import org.eventb.emf.core.machine.Variable;

import ac.soton.fmusim.components.ComponentsFactory;
import ac.soton.fmusim.components.EventBComponent;
import ac.soton.fmusim.components.EventBPort;
import ac.soton.fmusim.components.Port;
import ac.soton.fmusim.components.VariableCausality;
import ac.soton.fmusim.components.VariableType;

/**
 * New EventB port creation dialog.
 * Allows to specify the name and type of the new port,
 * as well as a parameter for provided read/write event.
 * Also provides the basic name validation based on the source
 * component: disallows empty name or the existing port name.
 * 
 * @author vitaly
 *
 */
public class EventBPortDialog extends Dialog {

	private Combo typeCombo;
	private Combo variableCombo;
	private Combo parameterCombo;
	private Set<String> usedVariables;
	private Map<String, Variable> variableMap;
	private Map<String, Parameter> parameterMap;
	private DecoratedInputValidator variableValidator;
	private DecoratedInputValidator parameterValidator;
	private boolean variableValid;
	private boolean parameterValid;
	private EventBPort port;
	private VariableCausality causality;
	
	/**
	 * Creates a new Event-B port dialog.
	 * 
	 * @param parentShell
	 * @param component target component of the new port
	 * @param causality port variable causality
	 * @param event IO event used to read from or write to the port
	 */
	public EventBPortDialog(Shell parentShell, EventBComponent component, VariableCausality causality, Event event) {
		super(parentShell);
		
		// build up a set of existing names and event map
		if (component != null) {
			usedVariables = new HashSet<String>(component.getInputs().size() + component.getOutputs().size());
			for (Port p : component.getInputs())
				usedVariables.add(p.getName());
			for (Port p : component.getOutputs())
				usedVariables.add(p.getName());
			
			// set causality
			this.causality = causality;
			
			// construct map of variables for combo
			Machine machine = component.getMachine();
			variableMap = new HashMap<String, Variable>(machine.getVariables().size());
			for (Variable variable : machine.getVariables()) {
				variableMap.put(variable.getName(), variable);
			}
			
			// if event defined, construct map of event parameters for combo
			if (event != null) {
				parameterMap = new HashMap<String, Parameter>(event.getParameters().size());
				for (Parameter parameter : event.getParameters()) {
					parameterMap.put(parameter.getName(), parameter);
				}
			} else {
				parameterValid = true;
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("New Event-B Port");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		composite.setLayout(new GridLayout());
		
		Group plate = new Group(composite, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		plate.setLayout(layout);
		plate.setText("Event-B port attributes");
		
		// variable label and combo
		Label variableLabel = new Label(plate, SWT.NONE);
		variableLabel.setText("Variable:");
		variableCombo = new Combo(plate, SWT.DROP_DOWN | SWT.READ_ONLY);
		variableCombo.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		variableCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				validateVariable();
			}
		});
		{
			String[] items = new String[variableMap.size() + 1];
			int i = 0;
			items[i++] = ""; // empty item
			for (String name : variableMap.keySet())
				items[i++] = name;
			Arrays.sort(items);
			variableCombo.setItems(items);
		}
		
		// type label and combo
		Label typeLabel = new Label(plate, SWT.NONE);
		typeLabel.setText("Type:");
		typeCombo = new Combo(plate, SWT.DROP_DOWN | SWT.READ_ONLY);
		typeCombo.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		{
			assert VariableType.VALUES.size() > 0;
			String[] items = new String[VariableType.VALUES.size()];
			for (int i = 0; i < VariableType.VALUES.size(); i++) {
				items[i] = VariableType.VALUES.get(i).getName();
			}
			typeCombo.setItems(items);
			typeCombo.select(0);
		}
		
		// read/write event parameter combo
		if (parameterMap != null) {
			Label parameterLabel = new Label(plate, SWT.NONE);
			parameterLabel.setText("Parameter:");
			parameterCombo = new Combo(plate, SWT.DROP_DOWN | SWT.READ_ONLY);
			parameterCombo.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
			parameterCombo.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					validateParameter();
				}
			});
			{
				String[] items = new String[parameterMap.size() + 1];
				int i = 0;
				items[i++] = ""; // empty item
				for (String name : parameterMap.keySet())
					items[i++] = name;
				Arrays.sort(items);
				parameterCombo.setItems(items);
			}
		}
		
		// validators
		variableValidator = new DecoratedInputValidator(
				DecoratedInputValidator.createDecorator(
						variableCombo,
						"Please select variable",
						FieldDecorationRegistry.DEC_ERROR, 
						false)) {
			@Override
			public String isValidInput(String variable) {
				if (variable == null || variable.isEmpty())
					return "Variable cannot be empty";
				if (usedVariables != null && usedVariables.contains(variable.trim()))
					return "Port for this variable already exists";
				return null;
			}
		};
		
		if (parameterMap != null) {
			parameterValidator = new DecoratedInputValidator(
					DecoratedInputValidator.createDecorator(
							parameterCombo,
							"Please select event parameter",
							FieldDecorationRegistry.DEC_ERROR, 
							false)) {
				@Override
				public String isValidInput(String parameter) {
					if (parameter == null || parameter.isEmpty())
						return "Event parameter cannot be empty";
					return null;
				}
			};
		}
		
		plate.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		return composite;
	}
	

	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		// only here the buttons are available, so that's where OK can be disabled for initial state
		update();
		return contents;
	}

	/**
	 * Validates type.
	 * XXX: not implemented
	 */
	protected void validateType() {
	}

	/**
	 * Validates variable.
	 */
	protected void validateVariable() {
		if (variableValidator != null) {
			variableValid = variableValidator.isValid(variableCombo.getText()) == null;
		} else {
			variableValid = true;
		}
		update();
	}

	/**
	 * Validates parameter.
	 */
	protected void validateParameter() {
		if (parameterValidator != null) {
			parameterValid = parameterValidator.isValid(parameterCombo.getText()) == null;
		} else {
			parameterValid = true;
		}
		update();
	}

	/**
	 * Updates the buttons based on validation:
	 * - variable
	 * - parameter
	 */
	private void update() {
		boolean valid = true;
		Control button = getButton(IDialogConstants.OK_ID);
		if (button != null) {
			valid &= variableValid;
			valid &= parameterValid;
			button.setEnabled(valid);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	@Override
	protected void okPressed() {
		String variableStr = variableCombo.getItem(variableCombo.getSelectionIndex());
		String typeStr = typeCombo.getItem(typeCombo.getSelectionIndex());
		
		port = ComponentsFactory.eINSTANCE.createEventBPort();
		port.setName(variableMap.get(variableStr).getName());
		port.setVariable(variableMap.get(variableStr));
		port.setType(VariableType.getByName(typeStr));
		port.setCausality(causality);
		
		// if parameter was defined set parameter from combo
		if (parameterMap != null) {
			if (parameterCombo.getSelectionIndex() > 0)
				port.setParameter(parameterMap.get(parameterCombo.getItem(parameterCombo.getSelectionIndex())));
		}
		
		super.okPressed();
	}

	/**
	 * Returns created EventB port, or null if the dialog was cancelled.
	 * 
	 * @return the port
	 */
	public EventBPort getPort() {
		return port;
	}


}
