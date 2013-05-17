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
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eventb.emf.core.machine.Event;

import ac.soton.fmusim.components.ComponentsFactory;
import ac.soton.fmusim.components.EventBComponent;
import ac.soton.fmusim.components.EventBPort;
import ac.soton.fmusim.components.Port;
import ac.soton.fmusim.components.VariableType;
import ac.soton.fmusim.components.ui.wizards.pages.ComponentModelSource;

/**
 * New EventB port creation dialog.
 * Allows to specify the name and type of the new port,
 * as well as get & set events from the provided source.
 * Also provides the basic name validation based on the source
 * component: disallows empty name or the existing port name.
 * 
 * @author vitaly
 *
 */
public class EventBPortDialog extends Dialog {

	private Text nameText;
	private Combo typeCombo;
	private Combo getCombo;
	private Combo setCombo;
	private Set<String> conflictingNames;
	private Map<String, Event> eventMap;
	private DecoratedInputValidator nameValidator;
	private boolean nameValid;
	private EventBPort port;

	/**
	 * @param parentShell
	 */
	public EventBPortDialog(Shell parentShell, ComponentModelSource source) {
		super(parentShell);
		assert source.getModel() instanceof EventBComponent;
		EventBComponent model = (EventBComponent) source.getModel();
		
		// build up a set of existing names and event map
		if (model != null) {
			conflictingNames = new HashSet<String>(model.getInputs().size() + model.getOutputs().size());
			for (Port p : model.getInputs())
				conflictingNames.add(p.getName());
			for (Port p : model.getOutputs())
				conflictingNames.add(p.getName());
			
			if (model.getMachine() != null) {
				eventMap = new HashMap<String, Event>(model.getMachine().getEvents().size());
				for (Event event : model.getMachine().getEvents())
					eventMap.put(event.getName(), event);
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
		plate.setText("Event-B Port");
		
		// name label and field
		Label nameLabel = new Label(plate, SWT.NONE);
		nameLabel.setText("Name:");
		nameText = new Text(plate, SWT.SINGLE | SWT.BORDER);
		nameText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		nameText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				validateName();
			}
		});
		
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
		
		if (eventMap != null) {
			// get event label & combo
			Label getLabel = new Label(plate, SWT.NONE);
			getLabel.setText("Get Event:");
			getCombo = new Combo(plate, SWT.DROP_DOWN | SWT.READ_ONLY);
			getCombo.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
			{
				String[] items = new String[eventMap.size() + 1];
				int i = 0;
				items[i++] = ""; // empty item for non-refinement
				for (String name : eventMap.keySet())
					items[i++] = name;
				Arrays.sort(items);
				getCombo.setItems(items);
			}
			
			// set event label & combo
			Label setLabel = new Label(plate, SWT.NONE);
			setLabel.setText("Set Event:");
			setCombo = new Combo(plate, SWT.DROP_DOWN | SWT.READ_ONLY);
			setCombo.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
			{
				String[] items = new String[eventMap.size() + 1];
				int i = 0;
				items[i++] = ""; // empty item for non-refinement
				for (String name : eventMap.keySet())
					items[i++] = name;
				Arrays.sort(items);
				setCombo.setItems(items);
			}
		}
		
		// validator
		nameValidator = new DecoratedInputValidator(DecoratedInputValidator.createDecorator(nameText, "Please enter name", FieldDecorationRegistry.DEC_ERROR, false)) {
			
			@Override
			public String isValidInput(String name) {
				if (name == null || name.trim().isEmpty())
					return "Name cannot be empty";
				if (conflictingNames != null && conflictingNames.contains(name.trim()))
					return "Port with such name already exists";
				return null;
			}
		};
		
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
	 * Validates name.
	 */
	protected void validateName() {
		String errorMessage = null;
        if (nameValidator != null) {
            errorMessage = nameValidator.isValid(nameText.getText());
            nameValid = errorMessage == null;
        } else {
        	nameValid = true;
        }
		update();
	}

	/**
	 * Validates type.
	 * XXX: not implemented
	 */
	protected void validateType() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Updates the buttons based on name validation.
	 */
	private void update() {
		Control button = getButton(IDialogConstants.OK_ID);
		if (button != null) {
			button.setEnabled(nameValid);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	@Override
	protected void okPressed() {
		port = ComponentsFactory.eINSTANCE.createEventBPort();
		port.setName(nameText.getText().trim());
		port.setType(VariableType.getByName(typeCombo.getItem(typeCombo.getSelectionIndex())));
		
		// if events were defined set get/set events from combos
		if (eventMap != null) {
			if (getCombo.getSelectionIndex() > 0)
				port.setFmiGetEvent(eventMap.get(getCombo.getItem(getCombo.getSelectionIndex())));
			if (setCombo.getSelectionIndex() > 0)
				port.setFmiSetEvent(eventMap.get(setCombo.getItem(setCombo.getSelectionIndex())));
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
