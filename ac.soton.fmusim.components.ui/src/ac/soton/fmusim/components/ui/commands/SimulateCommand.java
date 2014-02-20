/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.commands;


import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import ac.soton.fmusim.components.ComponentDiagram;
import ac.soton.fmusim.components.diagram.part.ValidateAction;
import ac.soton.fmusim.components.master.Master;
import ac.soton.fmusim.components.ui.ComponentsUIPlugin;
import ac.soton.fmusim.components.ui.dialogs.SimulationInputDialog;

/**
 * @author vitaly
 *
 */
public class SimulateCommand extends AbstractHandler {
	
	private static final double STOP_DEFAULT = 10.0;	// default simulation stop time
	private static final double STEP_DEFAULT = 0.1;		// default simulation step size

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart diagramEditor = HandlerUtil.getActiveEditorChecked(event);
		Shell shell = diagramEditor.getEditorSite().getShell();
		assert diagramEditor instanceof DiagramEditor;
		if (validate(diagramEditor) == false)
			return null;
		
		final TransactionalEditingDomain editingDomain = ((DiagramEditor) diagramEditor)
				.getEditingDomain();
		final ComponentDiagram diagram = (ComponentDiagram) ((DiagramEditor) diagramEditor)
				.getDiagram().getElement();
		double defaultTime = diagram.getStopTime() > 0 ? diagram.getStopTime() : STOP_DEFAULT;
		double defaultStep = diagram.getStepSize() > 0 ? diagram.getStepSize() : STEP_DEFAULT;
		
		// input dialog for entering the time and step size
		SimulationInputDialog simulationInputDialog = new SimulationInputDialog(shell, defaultTime, defaultStep);
		if (simulationInputDialog.open() != InputDialog.OK)
			return null;

		final double time = simulationInputDialog.getTime();
		final double step = simulationInputDialog.getStep();
		
		// get output path
		IEditorInput input = diagramEditor.getEditorInput();
		IResource res = (IResource) input.getAdapter(IResource.class);
		IPath loc = res.getLocation().removeLastSegments(1).append("results.csv");
		
		final Master master = new Master(diagram, 0, time, step, new File(loc.toOSString()));
		
		// execute simulation in a job
		Job job = new Job("Simulation") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					new AbstractEMFOperation(editingDomain, "Simulate command") {
						
						@Override
						protected IStatus doExecute(IProgressMonitor monitor,
								IAdaptable info) throws ExecutionException {
							diagram.setStopTime(time);
							diagram.setStepSize(step);
							master.simulateAll();
							return null;
						}
					}.execute(monitor, null);
					if (monitor.isCanceled())
						return Status.CANCEL_STATUS;
				} catch (ExecutionException e) {
					return new Status(Status.ERROR, ComponentsUIPlugin.getPluginID(), e.getMessage());
				}
				return Status.OK_STATUS;
			}

		};
		job.setUser(true);
		job.schedule();
		
		return null;
	}

	/**
	 * Validate the editor content.
	 * Returns true if validation has found no problems, otherwise false.
	 * @param diagramEditor
	 */
	public static boolean validate(IEditorPart diagramEditor) {
		Action validateAction = new ValidateAction(diagramEditor.getSite().getPage());
		validateAction.run();

		// show error markers if added
		IResource resource = (IResource) diagramEditor.getEditorInput().getAdapter(IResource.class);
		if (resource == null)
			return false;
		IMarker[] problems = null;
		int depth = IResource.DEPTH_INFINITE;
		try {
			problems = resource.findMarkers(IMarker.PROBLEM, true, depth);
			if (problems.length > 0) {
				new MessageDialog(diagramEditor.getSite().getShell(),
						"Validation", null,
						"Please fix the validation problems first.",
						MessageDialog.ERROR, new String[] { "OK" }, 0).open();
				return false;
			}
		} catch (CoreException e) {
			return false;
		}
		return true;
	}

}
