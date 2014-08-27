/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.commands;


import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.progress.IProgressConstants;

import ac.soton.fmusim.components.ComponentDiagram;
import ac.soton.fmusim.components.diagram.part.ValidateAction;
import ac.soton.fmusim.components.master.Master;
import ac.soton.fmusim.components.ui.dialogs.SimulationInputDialog;

/**
 * @author vitaly
 *
 */
public class SimulateCommand extends AbstractHandler {

	private static final long START_DEFAULT = 0;		// default simulation start time
	private static final long STOP_DEFAULT = 10000;		// default simulation stop time
	private static final long STEP_DEFAULT = 1000;		// default simulation step size

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
		
//		final TransactionalEditingDomain editingDomain = ((DiagramEditor) diagramEditor).getEditingDomain();
		final ComponentDiagram diagram = (ComponentDiagram) ((DiagramEditor) diagramEditor).getDiagram().getElement();
		long defaultStart = diagram.getStartTime() > 0 ? diagram.getStartTime() : START_DEFAULT;
		long defaultStop = diagram.getStopTime() > 0 ? diagram.getStopTime() : STOP_DEFAULT;
		long defaultStep = diagram.getStepSize() > 0 ? diagram.getStepSize() : STEP_DEFAULT;
		
		// input dialog for entering the time and step size
		SimulationInputDialog simulationInputDialog = new SimulationInputDialog(shell, defaultStart, defaultStop, defaultStep);
		if (simulationInputDialog.open() != InputDialog.OK)
			return null;
		
		setDefaults(diagram, simulationInputDialog.getStartTime(), simulationInputDialog.getStopTime(), simulationInputDialog.getStepSize(), ((DiagramEditor) diagramEditor).getEditingDomain());

		// get output path
		IEditorInput input = diagramEditor.getEditorInput();
		IResource res = (IResource) input.getAdapter(IResource.class);
		String resultFilePath = res.getLocation().removeLastSegments(1).append("results.csv").toOSString();
		
		// simulation parameters
		final Map<String, String> params = new HashMap<String, String>();
		params.put(Master.PARAMETER_START_TIME, Long.toString(simulationInputDialog.getStartTime()));
		params.put(Master.PARAMETER_STOP_TIME, Long.toString(simulationInputDialog.getStopTime()));
		params.put(Master.PARAMETER_STEP_SIZE, Long.toString(simulationInputDialog.getStepSize()));
		params.put(Master.PARAMETER_OUTPUT_FILE, resultFilePath);
		
		// execute simulation in a job
		final Job job = new Job("Multi-simulation") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				return Master.simulate(diagram, monitor, params);
			}
			@Override
			public boolean belongsTo(Object family) {
				return "Multi-simulation".equals(getName());
			}
		};
		job.setUser(true);
		job.setPriority(Job.LONG);
		job.setProperty(IProgressConstants.KEEPONE_PROPERTY, true);
//		job.setProperty(IProgressConstants.ICON_PROPERTY, RmsUIActivator.getDefault().getImageRegistry().getDescriptor(RmsUIActivator.IMAGE_RMS));	// job icon
		job.setProperty(IProgressConstants.ACTION_PROPERTY, new Action() {
			Job jb = job;
			@Override
			public void run() {
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Simulation Results", jb.getResult().getMessage());
					}
				});
			}
		});
		job.schedule();
		
		return null;
	}

	/**
	 * Sets diagram default parameters.
	 * 
	 * @param diagram
	 * @param startTime
	 * @param stopTime
	 * @param stepSize
	 * @param transactionalEditingDomain 
	 */
	private void setDefaults(final ComponentDiagram diagram, final long startTime,
			final long stopTime, final long stepSize, TransactionalEditingDomain editingDomain) {
		try {
			new AbstractEMFOperation(editingDomain, "Set defaults") {
				@Override
				protected IStatus doExecute(IProgressMonitor arg0,
						IAdaptable arg1) throws ExecutionException {
					diagram.setStartTime(startTime);
					diagram.setStopTime(stopTime);
					diagram.setStepSize(stepSize);
					return null;
				}
			}.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Validate the editor content.
	 * Returns true if validation has found no problems, otherwise false.
	 * 
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
