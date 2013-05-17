/**
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.dialogs;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;

/**
 * @author vitaly
 *
 */
public abstract class DecoratedInputValidator implements IInputValidator {
	
	private final ControlDecoration controlDecoration;

	/**
	 * @param controlDecoration control decoration if required
	 */
	public DecoratedInputValidator(ControlDecoration controlDecoration) {
		this.controlDecoration = controlDecoration;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IInputValidator#isValid(java.lang.String)
	 */
	@Override
	public String isValid(String newText) {
		String message = isValidInput(newText);
		if (controlDecoration != null) {
			if (message == null) {
				controlDecoration.hide();
			} else {
				controlDecoration.setDescriptionText(message);
				controlDecoration.show();
			}
		}
		return message;
	}

	/**
	 * Returns validation result.
	 * 
	 * @param input validation input string
	 * @return validation error message or null
	 */
	public abstract String isValidInput(String input);
	
	/**
	 * Returns new control decorator initialised with message.
	 * 
	 * @param control control widget
	 * @param message initial message or null if none
	 * @param type decorator type constant from FieldDecorationRegistry
	 * @param visible is it visible when created
	 * @return control decorator
	 */
	public static ControlDecoration createDecorator(Control control, String message, String type, boolean visible) {
		ControlDecoration controlDecoration = new ControlDecoration(control, SWT.LEFT | SWT.TOP);
		controlDecoration.setDescriptionText(message);
		FieldDecoration fieldDecoration = FieldDecorationRegistry.getDefault().getFieldDecoration(type);
		controlDecoration.setImage(fieldDecoration.getImage());
		if (!visible)
			controlDecoration.hide();
		return controlDecoration;
	}

}
