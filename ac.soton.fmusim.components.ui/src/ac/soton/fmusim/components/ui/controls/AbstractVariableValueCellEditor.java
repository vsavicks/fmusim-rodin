/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.controls;

import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.viewers.ICellEditorListener;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;

import ac.soton.fmusim.components.AbstractVariable;
import ac.soton.fmusim.components.ui.dialogs.DecoratedInputValidator;

/**
 * AbstractVariable value cell editor with type validation and error decoration.
 * 
 * @author vitaly
 *
 */
public class AbstractVariableValueCellEditor extends TextCellEditor {
	
	private AbstractVariable variable;
	private ControlDecoration decorator;

	/**
	 * @param parent
	 */
	public AbstractVariableValueCellEditor(Composite parent, AbstractVariable var) {
		super(parent);
		variable = var;
		decorator = DecoratedInputValidator.createDecorator(getControl(), "abba", FieldDecorationRegistry.DEC_ERROR, false);
		createValidator();
		createListener();
	}

	/**
	 * Adds cell editor validator.
	 */
	private void createValidator() {
		setValidator(new ICellEditorValidator() {
			@Override
			public String isValid(Object value) {
				String valueStr = value.toString();
				if (valueStr == null || valueStr.trim().isEmpty())
					return "Value cannot be empty";
				
				String errorMsg = null;
				valueStr = valueStr.trim().toLowerCase();
				switch (variable.getType()) {
				case BOOLEAN:
					if (false == (valueStr.equals("true") || valueStr.equals("false")))
						errorMsg = "Invalid boolean value (allowed 'true' or 'false')";
					break;
				case INTEGER:
					try {
						Integer.parseInt(valueStr);
					} catch (NumberFormatException e) {
						errorMsg = "Invalid integer value";
					}
					break;
				case REAL:
					try {
						Double.parseDouble(valueStr);
					} catch (NumberFormatException e) {
						errorMsg = "Invalid real value";
					}
				case STRING:
				}
				return errorMsg;
			}
		});
	}
	
	/**
	 * Adds cell editor validation listener.
	 */
	private void createListener() {
		addListener(new ICellEditorListener() {

			@Override
			public void editorValueChanged(boolean oldValidState,
					boolean newValidState) {
				if (!newValidState) {
					decorator.setDescriptionText(getErrorMessage());
					decorator.show();
				} else {
					decorator.hide();
				}
			}

			@Override
			public void applyEditorValue() {
			}

			@Override
			public void cancelEditor() {
				decorator.hide();
			}
		});
	}

	@Override
	public void dispose() {
		super.dispose();
		decorator.dispose();
	}
}