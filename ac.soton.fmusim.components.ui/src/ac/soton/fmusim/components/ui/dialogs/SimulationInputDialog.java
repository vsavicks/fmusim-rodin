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
 * @author vitaly
 *
 */
public class SimulationInputDialog extends Dialog {

	private Text timeText;
	private Text stepText;
	private DecoratedInputValidator timeValidator;
	private DecoratedInputValidator stepValidator;
	private double initialTime;
	private double initialStep;
	private boolean timeValid;
	private boolean stepValid;
	private ControlDecoration stepToTimeErrorDecorator;

	/**
	 * Simulation start dialog.
	 * 
	 * @param parentShell shell
	 * @param time default simulation time
	 * @param step default step size
	 */
	public SimulationInputDialog(Shell parentShell, double time, double step) {
		super(parentShell);
		
		assert 0 < step && step < time;
		this.initialTime = time;
		this.initialStep = step;
		timeValid = true;
		stepValid = true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Simulate");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		
		// time
		Label timeLabel = new Label(composite, SWT.NONE);
		timeLabel.setText("Simulation time:");
		timeText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		timeText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		timeText.setText(Double.toString(initialTime));
		timeText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				validateTime();
			}
		});
		
		// step
		Label stepLabel = new Label(composite, SWT.NONE);
		stepLabel.setText("Step size:");
		stepText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		stepText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		stepText.setText(Double.toString(initialStep));
		stepText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				validateStep();
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
		timeValidator = new DecoratedInputValidator(
				DecoratedInputValidator.createDecorator(timeText,
						"Please enter simulation end time",
						FieldDecorationRegistry.DEC_ERROR, false)) {
			@Override
			public String isValidInput(String timeString) {
				try {
					double input = Double.parseDouble(timeString);
					if (input <= 0.0)
						return "Simulation time must be greater that zero";
				} catch (NumberFormatException e) {
					return "Invalid number format";
				}
				return null;
			}
		};
		
		stepValidator = new DecoratedInputValidator(
				DecoratedInputValidator.createDecorator(stepText,
						"Please enter simulation step size",
						FieldDecorationRegistry.DEC_ERROR, false)) {
			@Override
			public String isValidInput(String stepString) {
				try {
					double input = Double.parseDouble(stepString);
					if (input <= 0.0)
						return "Step size must be greater that zero";
				} catch (NumberFormatException e) {
					return "Invalid number format";
				}
				return null;
			}
		};
		
		stepToTimeErrorDecorator = DecoratedInputValidator.createDecorator(stepText,
				"Step size cannot exceed simulation time",
				FieldDecorationRegistry.DEC_ERROR, false);
	}

	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		// only here the buttons are available, so that's where OK can be disabled for initial state
		update();
		return contents;
	}
	
	/**
	 * Validates time.
	 */
	protected void validateTime() {
		if (timeValidator != null) {
			timeValid = timeValidator.isValid(timeText.getText()) == null;
		}
		validateStepToTime();
		update();
	}

	/**
	 * Validates step.
	 */
	protected void validateStep() {
		if (stepValidator != null) {
			stepValid = stepValidator.isValid(stepText.getText()) == null;
		}
		validateStepToTime();
		update();
	}
	
	/**
	 * Validates the relation of step size to simulation time:
	 * step size must not exceed simulation time.
	 */
	private void validateStepToTime() {
		if (timeValid && stepValid && stepToTimeErrorDecorator != null) {
			double time = Double.parseDouble(timeText.getText());
			double step = Double.parseDouble(stepText.getText());
			
			stepValid = step <= time;
			if (!stepValid) {
				stepToTimeErrorDecorator.show();
				return;
			}
		}
		stepToTimeErrorDecorator.hide();
	}
	
	/**
	 * Updates the buttons based on validation results.
	 */
	private void update() {
		Control button = getButton(IDialogConstants.OK_ID);
		if (button != null) {
			button.setEnabled(timeValid && stepValid);
		}
	}

	/**
	 * @return time
	 */
	public double getTime() {
		return Double.parseDouble(timeText.getText());
	}

	/**
	 * @return step
	 */
	public double getStep() {
		return Double.parseDouble(stepText.getText());
	}

}
