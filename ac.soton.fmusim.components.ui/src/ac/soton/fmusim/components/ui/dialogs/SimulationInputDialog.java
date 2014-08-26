/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Simulation parameters input dialog.
 * Requires to input simulation time and step size.
 * 
 * @author vitaly
 *
 */
public class SimulationInputDialog extends Dialog {

	private Text startTimeText;
	private Text stopTimeText;
	private Text stepSizeText;
	private DecoratedInputValidator startTimeValidator;
	private DecoratedInputValidator stopTimeValidator;
	private DecoratedInputValidator stepSizeValidator;
	private long startTime;
	private long stopTime;
	private long stepSize;
	private boolean startTimeValid;
	private boolean stopTimeValid;
	private boolean stepSizeValid;
	private boolean totalTimeValid;
	private boolean stepTimeValid;
	private ControlDecoration timeErrorDecorator;
	private ControlDecoration stepTimeErrorDecorator;

	/**
	 * Simulation start dialog.
	 * 
	 * @param parentShell shell
	 * @param time default simulation time
	 * @param step default step size
	 */
	public SimulationInputDialog(Shell parentShell, long start, long stop, long step) {
		super(parentShell);
		startTime = start;
		stopTime = stop;
		stepSize = step;
		startTimeValid = true;
		stopTimeValid = true;
		stepSizeValid = true;
		totalTimeValid = true;
		stepTimeValid = true;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Simulate");
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		
		// start time
		Label label = new Label(composite, SWT.NONE);
		label.setText("Start time:");
		startTimeText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		startTimeText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		startTimeText.setText(Long.toString(startTime));
		startTimeText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				validateStartTime();
			}
		});
		
		// stop time
		label = new Label(composite, SWT.NONE);
		label.setText("Stop time:");
		stopTimeText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		stopTimeText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		stopTimeText.setText(Long.toString(stopTime));
		stopTimeText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				validateStopTime();
			}
		});
		
		// step size
		label = new Label(composite, SWT.NONE);
		label.setText("Step size:");
		stepSizeText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		stepSizeText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		stepSizeText.setText(Long.toString(stepSize));
		stepSizeText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				validateStepSize();
			}
		});
		
		// validators
		addValidators();
		
		return composite;
	}

	/**
	 * Adds input field validators.
	 */
	private void addValidators() {
		startTimeValidator = createTextValidator(startTimeText);
		stopTimeValidator = createTextValidator2(stopTimeText);
		stepSizeValidator = createTextValidator2(stepSizeText);
		
		timeErrorDecorator = DecoratedInputValidator.createDecorator(stopTimeText,
				"Stop time should be after start time",
				FieldDecorationRegistry.DEC_ERROR, false);
		
		stepTimeErrorDecorator = DecoratedInputValidator.createDecorator(stepSizeText,
				"Step size cannot exceed simulation time",
				FieldDecorationRegistry.DEC_ERROR, false);
	}
	
	/**
	 * @return
	 */
	private DecoratedInputValidator createTextValidator(Text text) {
		return new DecoratedInputValidator(
				DecoratedInputValidator.createDecorator(text,
						"Please enter time in ms",
						FieldDecorationRegistry.DEC_ERROR, false)) {
			@Override
			public String isValidInput(String timeString) {
				try {
					long input = Long.parseLong(timeString);
					if (input < 0)
						return "Time must be positive";
				} catch (NumberFormatException e) {
					return "Invalid number format";
				}
				return null;
			}
		};
	}

	/**
	 * @return
	 */
	private DecoratedInputValidator createTextValidator2(Text text) {
		return new DecoratedInputValidator(
				DecoratedInputValidator.createDecorator(text,
						"Please enter time in ms",
						FieldDecorationRegistry.DEC_ERROR, false)) {
			@Override
			public String isValidInput(String timeString) {
				try {
					long input = Long.parseLong(timeString);
					if (input <= 0)
						return "Time must be greater that zero";
				} catch (NumberFormatException e) {
					return "Invalid number format";
				}
				return null;
			}
		};
	}

	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		// only here the buttons are available, so that's where OK can be disabled for initial state
		update();
		return contents;
	}
	
	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == OK) {
			startTime = Long.parseLong(startTimeText.getText());
			stopTime = Long.parseLong(stopTimeText.getText());
			stepSize = Long.parseLong(stepSizeText.getText());
		}
		super.buttonPressed(buttonId);
	}

	/**
	 * Validates start time.
	 */
	protected void validateStartTime() {
		if (startTimeValidator != null) {
			startTimeValid = startTimeValidator.isValid(startTimeText.getText()) == null;
		}
		validateTime();
		update();
	}

	/**
	 * Validates stop time.
	 */
	protected void validateStopTime() {
		if (stopTimeValidator != null) {
			stopTimeValid = stopTimeValidator.isValid(stopTimeText.getText()) == null;
		}
		validateTime();
		update();
	}

	/**
	 * Validates step size.
	 */
	protected void validateStepSize() {
		if (stepSizeValidator != null) {
			stepSizeValid = stepSizeValidator.isValid(stepSizeText.getText()) == null;
		}
		validateTime();
		update();
	}
	
	/**
	 * Validates start time against stop time
	 * and step size against total simulation time.
	 */
	private void validateTime() {
		if (timeErrorDecorator == null || stepTimeErrorDecorator == null)
			return;
		
		if (startTimeValid && stopTimeValid && stepSizeValid) {
			long startTime = Long.parseLong(startTimeText.getText());
			long stopTime = Long.parseLong(stopTimeText.getText());
			long stepSize = Long.parseLong(stepSizeText.getText());
			
			totalTimeValid = stopTime > startTime;
			if (totalTimeValid) {
				timeErrorDecorator.hide();
			} else {
				timeErrorDecorator.show();
			}
			
			stepTimeValid = stepSize <= (stopTime - startTime);
			if (stepTimeValid) {
				stepTimeErrorDecorator.hide();
			} else {
				stepTimeErrorDecorator.show();
			}
		}
	}
	
	/**
	 * Updates the buttons based on validation results.
	 */
	private void update() {
		Control button = getButton(IDialogConstants.OK_ID);
		if (button != null) {
			button.setEnabled(startTimeValid && stopTimeValid && stepSizeValid && totalTimeValid && stepTimeValid);
		}
	}

	/**
	 * @return start time
	 */
	public long getStartTime() {
		return startTime;
	}

	/**
	 * @return start time
	 */
	public long getStopTime() {
		return stopTime;
	}

	/**
	 * @return step size
	 */
	public long getStepSize() {
		return stepSize;
	}

}
