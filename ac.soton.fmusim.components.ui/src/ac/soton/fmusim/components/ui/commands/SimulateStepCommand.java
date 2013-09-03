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
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import ac.soton.fmusim.components.ComponentDiagram;
import ac.soton.fmusim.components.master.Master;
import ac.soton.fmusim.components.ui.dialogs.SimulationInputDialog;

/**
 * @author vitaly
 *
 */
public class SimulateStepCommand extends AbstractHandler {

	private static Master master;

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart diagramEditor = HandlerUtil.getActiveEditorChecked(event);
		Shell shell = diagramEditor.getEditorSite().getShell();
		assert diagramEditor instanceof DiagramEditor;
		final TransactionalEditingDomain editingDomain = ((DiagramEditor) diagramEditor)
				.getEditingDomain();
		
		if (master == null || !master.isSimulating()) {
			SimulationInputDialog simulationInputDialog = new SimulationInputDialog(shell, 10.0, 0.1);
			if (simulationInputDialog.open() != InputDialog.OK)
				return null;
			
			final double time = simulationInputDialog.getTime();
			final double step = simulationInputDialog.getStep();
			final ComponentDiagram diagram = (ComponentDiagram) ((DiagramEditor) diagramEditor)
					.getDiagram().getElement();
			
			master = new Master(diagram, 0, time, step, new File("C:/Users/vitaly/results.csv"));
		}
		
		// execute simulation in a job
		Job job = new Job("Simulation") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					new AbstractEMFOperation(editingDomain, "Simulate command") {

						@Override
						protected IStatus doExecute(IProgressMonitor monitor,
								IAdaptable info) throws ExecutionException {
							master.simulateStep();
							return null;
						}
					}.execute(monitor, null);
					if (monitor.isCanceled())
						return Status.CANCEL_STATUS;
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return Status.OK_STATUS;
			}
		};
		job.setUser(true);
		job.schedule();
		
		return null;
	}
}
