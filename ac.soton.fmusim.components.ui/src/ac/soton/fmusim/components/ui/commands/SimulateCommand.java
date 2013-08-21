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
public class SimulateCommand extends AbstractHandler {
	


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
		
		SimulationInputDialog simulationInputDialog = new SimulationInputDialog(shell, 10.0, 0.1);
		if (simulationInputDialog.open() != InputDialog.OK)
			return null;

		final double time = simulationInputDialog.getTime();
		final double step = simulationInputDialog.getStep();
		final ComponentDiagram diagram = (ComponentDiagram) ((DiagramEditor) diagramEditor)
				.getDiagram().getElement();
		
		// execute simulation in a job
		Job job = new Job("Simulation") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					new AbstractEMFOperation(editingDomain, "Simulate command") {

						@Override
						protected IStatus doExecute(IProgressMonitor monitor,
								IAdaptable info) throws ExecutionException {
							simulate(time, step, diagram, monitor);
							
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

	/**
	 * @param endTime
	 * @param step 
	 * @param diagram
	 * @param monitor 
	 */
	private void simulate(final double endTime, double step, final ComponentDiagram diagram, IProgressMonitor monitor) {

		new Master(diagram, 0, endTime, step, new File("/Users/vitaly/results.csv")).simulateAll();
		
//		FMIMaster master = new FMIMaster();
//		master.simulate(diagram, endTime, step);

//		monitor.beginTask("Simulating", (int) Math.round(endTime));
//		
//		double currentTime = 0.0;
//		
//		// initialisation step
//		for (Component comp : diagram.getComponents()) {
//			if (comp instanceof FMUComponent) {
//				FMUComponent fmuComp = (FMUComponent) comp;
//				FMU fmu = (FMU) fmuComp.getFmu();
//				fmu.initialize(0.0, endTime);
//			}
//		}
//		
//		// simulation loop
//		while (currentTime < endTime) {
//			// read port values
//			for (Component c : diagram.getComponents()) {
//				if (c instanceof FMUComponent) {
//					FMUComponent fmuComp = (FMUComponent) c;
//					FMU fmu = (FMU) fmuComp.getFmu();
//					Connector con = null;
//					for (Port p : fmuComp.getOutputs()) {
//						String name = p.getName();
//						Object value = null;
//						switch (p.getType()) {
//						case BOOLEAN:
//							value = fmu.getBoolean(name);
//							break;
//						case INTEGER:
//							value = fmu.getInt(name);
//							break;
//						case REAL:
//							value = fmu.getDouble(name);
//							break;
//						case STRING:
//							value = fmu.getString(name);
//							break;
//						}
//						con = p.getConnector();
//						if (con != null)
//							con.setValue(value);
//					}
//				}
//			}
//			
//			// write port values
//			for (Component c : diagram.getComponents()) {
//				if (c instanceof FMUComponent) {
//					FMUComponent fmuComp = (FMUComponent) c;
//					FMU fmu = (FMU) fmuComp.getFmu();
//					Connector con = null;
//					for (Port p : fmuComp.getInputs()) {
//						String name = p.getName();
//						con = p.getConnector();
//						if (con == null)
//							continue;
//						Object value = con.getValue();
//						switch (p.getType()) {
//						case BOOLEAN:
//							fmu.set(name, (Boolean) value);
//							break;
//						case INTEGER:
//							fmu.set(name, (Integer) value);
//							break;
//						case REAL:
//							fmu.set(name, (Double) value);
//							break;
//						case STRING:
//							fmu.set(name, (String) value);
//							break;
//						}
//					}
//				}
//			}
//			
//			// do step
//			for (Component comp : diagram.getComponents()) {
//				if (comp instanceof FMUComponent) {
//					FMUComponent fmuComp = (FMUComponent) comp;
//					FMU fmu = (FMU) fmuComp.getFmu();
//					fmu.doStep(currentTime, step);
//				}
//			}
//			
//			// progress the time
//			currentTime += step;
//			
//			// progress the monitor
//			if (currentTime < Math.floor(currentTime) + step)
//				monitor.worked(1);
//		}
//		
//		monitor.done();
	}

}
