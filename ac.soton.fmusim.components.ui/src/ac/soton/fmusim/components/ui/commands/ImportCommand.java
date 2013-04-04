/**
 * 
 */
package ac.soton.fmusim.components.ui.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.internal.resources.File;
import org.eclipse.core.internal.resources.Folder;
import org.eclipse.core.internal.resources.Project;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eventb.emf.core.machine.Machine;
import org.ptolemy.fmi.FMIModelDescription;
import org.ptolemy.fmi.FMIScalarVariable;
import org.ptolemy.fmi.FMIScalarVariable.Causality;

import ac.soton.fmusim.components.Component;
import ac.soton.fmusim.components.ComponentDiagram;
import ac.soton.fmusim.components.ComponentsFactory;
import ac.soton.fmusim.components.EventBComponent;
import ac.soton.fmusim.components.FMUComponent;
import ac.soton.fmusim.components.FMUPort;
import ac.soton.fmusim.components.PortKind;
import ac.soton.fmusim.components.Variable;
import de.prob.cosimulation.FMU;
//import org.eclipse.gmf.internal.common.ui.Messages;

/**
 * @author vitaly
 * 
 */
public class ImportCommand extends AbstractHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.
	 * ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart diagramEditor = HandlerUtil.getActiveEditorChecked(event);
		Shell shell = diagramEditor.getEditorSite().getShell();
		assert diagramEditor instanceof DiagramEditor;
		TransactionalEditingDomain editingDomain = ((DiagramEditor) diagramEditor)
				.getEditingDomain();
		
		// workspace file dialog
		IFile file = null;
		List<ViewerFilter> filters = new ArrayList<ViewerFilter>();
		filters.add(new ViewerFilter() {
			
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				if (element instanceof Project)
					return true;
				if (element instanceof Folder) {
					// skip hidden folders
					if (((Folder) element).getName().startsWith("."))
						return false;
					return true;
				}
				if (element instanceof File) {
					File file = (File) element;
					String extension = file.getFileExtension();
					// pass only accepted extensions
					if ("fmu".equals(extension) || "bum".equals(extension))
						return true;
				}
				return false;
			}
		});
		IFile[] files = WorkspaceResourceDialog.openFileSelection(shell, "New Component", "Select a component to import", false, null, filters);		
		if (files.length != 0) {
        	file = files[0];
        } else {
        	// no files selected
        	return null;
        }
		
		
//		// browse for imported file
//		FileDialog dialog = new FileDialog(shell, SWT.OPEN);
//		dialog.setFilterExtensions(new String[] { "*.fmu; *.bum" });
//		String fileName = dialog.open();
//		if (fileName == null)
//			return null;

		// create either Event-B component or FMUComponent, based on imported
		// file
		Component component = null;
		if ("fmu".equals(file.getFileExtension())) {
			// load the .fmu
			String filePath = file.getLocation().toString();
			FMU fmu = null;
			try {
				fmu = new FMU(filePath);
			} catch (IOException e) {
				// failed to load
				e.printStackTrace();
				return null;
			}
			FMIModelDescription modelDescription = fmu.getModelDescription();

			// construct the component
			FMUComponent fmuComponent = ComponentsFactory.eINSTANCE
					.createFMUComponent();
			fmuComponent.setPath(filePath);
			fmuComponent.setFmu(fmu);
			fmuComponent.setName(modelDescription.modelName);
			for (FMIScalarVariable scalarVariable : modelDescription.modelVariables) {
				Variable variable = ComponentsFactory.eINSTANCE
						.createVariable();
				variable.setName(scalarVariable.name);
				// FIXME: variable requires a reference to FMI scalar variable
				// (for API calls)
				// TODO: maybe the variable also requires the type, variability (parameter etc.), start value (from type i.e. type.start)
				// variable.setValue(value)

				if (scalarVariable.causality == Causality.internal) {
					fmuComponent.getVariables().add(variable);
				} else if (scalarVariable.causality != Causality.none) {
					FMUPort port = ComponentsFactory.eINSTANCE.createFMUPort();
					port.setName(scalarVariable.name);
					port.setVariable(variable);
					// port.setType(variable.type)

					if (scalarVariable.causality == Causality.input) {
						port.setKind(PortKind.INPUT);
						fmuComponent.getInputs().add(port);
					} else if (scalarVariable.causality == Causality.output) {
						port.setKind(PortKind.OUTPUT);
						fmuComponent.getOutputs().add(port);
					}
				}
			}
			component = fmuComponent;
		} else if ("bum".equals(file.getFileExtension())) {
			// load Event-B machine
			URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			Resource resource = editingDomain.getResourceSet().getResource(uri, true);
			Machine machine = (Machine) resource.getContents().get(0);

			EventBComponent eventBComponent = ComponentsFactory.eINSTANCE
					.createEventBComponent();
			eventBComponent.setName(machine.getName());
			eventBComponent.setMachine(machine);
			component = eventBComponent;
		} else {
			// unsupported file extension
			return null;
		}
		
		assert component != null;
		final Component newComponent = component;
		final ComponentDiagram diagram = (ComponentDiagram) ((DiagramEditor) diagramEditor)
				.getDiagram().getElement();
		editingDomain.getCommandStack().execute(
				new RecordingCommand(editingDomain) {
					protected void doExecute() {
						diagram.getComponents().add(newComponent);
					}
				});
		return null;
	}
}
