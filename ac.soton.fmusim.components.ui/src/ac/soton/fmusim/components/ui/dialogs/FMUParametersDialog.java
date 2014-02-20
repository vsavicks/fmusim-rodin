/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.dialogs;

import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import ac.soton.fmusim.components.FMUParameter;
import ac.soton.fmusim.components.ui.controls.FMUParameterTableViewer;

/**
 * Input dialog for modifying the values of parameters.
 * 
 * @author vitaly
 *
 */
public class FMUParametersDialog extends Dialog {

	private List<FMUParameter> parameters;
	private TableViewer viewer;

	/**
	 * @param parentShell
	 */
	public FMUParametersDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		FillLayout fillLayout = new FillLayout(SWT.VERTICAL | SWT.HORIZONTAL);
	    fillLayout.marginHeight = 10;
	    fillLayout.marginWidth = 10;
		container.setLayout(fillLayout);
	    
	    viewer = new FMUParameterTableViewer(container, SWT.MULTI | SWT.H_SCROLL
	          | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		viewer.setInput(parameters); 

	    return container;
	}

	public void setParameters(List<FMUParameter> params) {
		parameters = params;
		if (viewer != null)
			viewer.setInput(params);
	}
	
	public List<FMUParameter> getParameters() {
		return parameters;
	}

	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Parameters");
	}

	@Override
	protected void okPressed() {
		// TODO Auto-generated method stub
		super.okPressed();
		
	}

}
