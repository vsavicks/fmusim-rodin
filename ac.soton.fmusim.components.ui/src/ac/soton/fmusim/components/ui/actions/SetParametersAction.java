/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.ptolemy.fmi.FMIModelDescription;
import org.ptolemy.fmi.FMIScalarVariable;
import org.ptolemy.fmi.FMIScalarVariable.Variability;
import org.ptolemy.fmi.FMUFile;

import ac.soton.fmusim.components.ComponentsFactory;
import ac.soton.fmusim.components.FMUComponent;
import ac.soton.fmusim.components.FMUParameter;
import ac.soton.fmusim.components.diagram.edit.parts.FMUComponentEditPart;
import ac.soton.fmusim.components.ui.dialogs.FMUParametersDialog;
import ac.soton.fmusim.components.util.FmiUtil;

/**
 * UI command to modify the FMU component parameters.
 * 
 * @author vitaly
 *
 */
public class SetParametersAction implements IObjectActionDelegate {

	private FMUComponentEditPart selectedElement;

	@Override
	public void run(IAction action) {
		final FMUComponent component = (FMUComponent) selectedElement.getNotationView().getElement();
		FMIModelDescription modelDescription = null;
		
		// read model description
		if (component.getFmu() != null) {
			modelDescription = component.getFmu().getModelDescription();
		} else {
			try {
				modelDescription = FMUFile.parseFMUFile(component.getPath());
			} catch (IOException e) {
				e.printStackTrace();
				//FIXME: handle the exception (no file found)
				return;
			}
		}
		
		// list all the parameters
		final List<FMUParameter> parameters = new ArrayList<FMUParameter>();
		if (component.getParameters().isEmpty()) {
			for (FMIScalarVariable variable : modelDescription.modelVariables) {
				if (variable.variability == Variability.parameter) {	//XXX according to specification a parameter must also be an input, i.e. variable.causality == Causality.input
					FMUParameter param = ComponentsFactory.eINSTANCE.createFMUParameter();
					param.setCausality(FmiUtil.getVariableCausality(variable));
					param.setType(FmiUtil.getVariableType(variable, param));
					param.setDefaultValue(param.getValue());
					param.setStartValue(param.getValue());
					param.setName(variable.name);
					param.setDescription(variable.description);
					parameters.add(param);
				}
			}
		} else {
			parameters.addAll(EcoreUtil.copyAll(component.getParameters()));
		}
		
		// display configuration window
		FMUParametersDialog dialog = new FMUParametersDialog(Display.getCurrent().getActiveShell());
		dialog.setParameters(parameters);
		dialog.create();
		if (Window.OK == dialog.open()) {
			try {
				new AbstractEMFOperation(selectedElement.getEditingDomain(), "Set parameters command") {
					@Override
					protected IStatus doExecute(IProgressMonitor monitor,
							IAdaptable info) throws ExecutionException {
						component.getParameters().clear();
						component.getParameters().addAll(parameters);
						return null;
					}
				}.execute(null, null);
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		selectedElement = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.getFirstElement() instanceof FMUComponentEditPart)
				selectedElement = (FMUComponentEditPart) structuredSelection.getFirstElement();
		}
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// nothing to do here
	}

}
