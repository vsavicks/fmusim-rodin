/**
 * 
 */
package ac.soton.fmusim.components.ui.commands;


import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import de.prob.cosimulation.FMU;

import ac.soton.fmusim.components.Component;
import ac.soton.fmusim.components.ComponentDiagram;
import ac.soton.fmusim.components.Connector;
import ac.soton.fmusim.components.FMUComponent;
import ac.soton.fmusim.components.FMUPort;
import ac.soton.fmusim.components.FmiTypes;
import ac.soton.fmusim.components.Port;

/**
 * @author vitaly
 *
 */
public class SimulateCommand extends AbstractHandler {
	
	private static final IInputValidator inputValidator = new IInputValidator() {

	@Override
	public String isValid(String newText) {
		try {
			Double.parseDouble(newText);
		} catch (NumberFormatException e) {
			return "Invalid number format";
		}
		return null;
	}
};

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
		
		InputDialog inputDialog = new InputDialog(Display.getCurrent()
				.getActiveShell(), "Simulation", "Enter simulation time",
				"10.0", inputValidator);
		if (inputDialog.open() != InputDialog.OK)
			return null;

		final double endTime = Double.valueOf(inputDialog.getValue());
		final ComponentDiagram diagram = (ComponentDiagram) ((DiagramEditor) diagramEditor)
				.getDiagram().getElement();
		
		

		
		Job job = new Job("Simulation") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					new AbstractEMFOperation(editingDomain, "Simulate command") {

						@Override
						protected IStatus doExecute(IProgressMonitor monitor,
								IAdaptable info) throws ExecutionException {
							simulate(endTime, diagram, monitor);
							
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
	 * @param diagram
	 * @param monitor 
	 */
	private void simulate(final double endTime, final ComponentDiagram diagram, IProgressMonitor monitor) {
		monitor.beginTask("Simulating", 100);
		
		double step = 0.1;
		double time = 0.0;
		
		// initialisation step
		for (Component comp : diagram.getComponents()) {
			if (comp instanceof FMUComponent) {
				FMUComponent fmuComp = (FMUComponent) comp;
				FMU fmu = (FMU) fmuComp.getFmu();
				fmu.initialize(0.0, endTime);
			}
		}
		
		// simulation loop
		while (time < endTime) {
			// read port values
			for (Component c : diagram.getComponents()) {
				if (c instanceof FMUComponent) {
					FMUComponent fmuComp = (FMUComponent) c;
					FMU fmu = (FMU) fmuComp.getFmu();
					for (Port p : fmuComp.getOutputs()) {
						String name = p.getName();
						Object value = null;
						switch (p.getType()) {
						case BOOLEAN:
							value = fmu.getBoolean(name);
							break;
						case INTEGER:
							value = fmu.getInt(name);
							break;
						case REAL:
							value = fmu.getDouble(name);
							break;
						case STRING:
							value = fmu.getString(name);
							break;
						}
						p.getConnector().setValue(value);
					}
				}
			}
			
			// write port values
			for (Component c : diagram.getComponents()) {
				if (c instanceof FMUComponent) {
					FMUComponent fmuComp = (FMUComponent) c;
					FMU fmu = (FMU) fmuComp.getFmu();
					for (Port p : fmuComp.getInputs()) {
						String name = p.getName();
						Object value = p.getConnector().getValue();
						switch (p.getType()) {
						case BOOLEAN:
							fmu.set(name, (Boolean) value);
							break;
						case INTEGER:
							fmu.set(name, (Integer) value);
							break;
						case REAL:
							fmu.set(name, (Double) value);
							break;
						case STRING:
							fmu.set(name, (String) value);
							break;
						}
					}
				}
			}
			
			// do step
			for (Component comp : diagram.getComponents()) {
				if (comp instanceof FMUComponent) {
					FMUComponent fmuComp = (FMUComponent) comp;
					FMU fmu = (FMU) fmuComp.getFmu();
					fmu.doStep(time, step);
				}
			}
			
			// progress the time
			time += step;
			monitor.worked(1);
		}
		
		monitor.done();
	}

}
