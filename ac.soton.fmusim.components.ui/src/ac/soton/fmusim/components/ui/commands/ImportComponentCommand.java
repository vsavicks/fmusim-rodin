/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.commands;
/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import ac.soton.fmusim.components.Component;
import ac.soton.fmusim.components.ComponentDiagram;
import ac.soton.fmusim.components.ui.wizards.ComponentImportWizard;

/**
 * @author vitaly
 *
 */
public class ImportComponentCommand extends AbstractHandler {

	private static final int WIZARD_WIDTH_INCH = 6;
	private static final int WIZARD_HEIGHT_INCH = 7;

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		DiagramEditor diagramEditor = (DiagramEditor) HandlerUtil.getActiveEditorChecked(event);
		Shell shell = diagramEditor.getEditorSite().getShell();

		final ComponentImportWizard wiz = new ComponentImportWizard();
		wiz.setWindowTitle("New Component Import Wizard");
		wiz.init(PlatformUI.getWorkbench(), null);
		WizardDialog wd = new WizardDialog(shell, wiz);
		wd.create();
		Rectangle mb = shell.getMonitor().getClientArea();
		Point dpi = shell.getDisplay().getDPI();
		if (Platform.OS_MACOSX.equals(Platform.getOS())) {
			dpi = new Point(110, 110); // OSX DPI is always 72; 110 is a common value for modern LCD screens
		}
		int width = dpi.x * WIZARD_WIDTH_INCH;
		int height = dpi.y * WIZARD_HEIGHT_INCH;
		int x = mb.x + (mb.width - width) / 2;
		if (x < mb.x) {
			x = mb.x;
		}
		int y = mb.y + (mb.height - height) / 2;
		if (y < mb.y) {
			y = mb.y;
		}
		wd.getShell().setLocation(x, y);
		wd.getShell().setSize(width, height);
		
		if (wd.open() != Window.OK)
			return null;
		
		// adding component to diagram
		final Component component = wiz.getComponent();
		if (component != null) {
			final ComponentDiagram diagram = (ComponentDiagram) diagramEditor.getDiagram().getElement();
			TransactionalEditingDomain editingDomain = diagramEditor.getEditingDomain();
			editingDomain.getCommandStack().execute(
					new RecordingCommand(editingDomain) {
						protected void doExecute() {
							diagram.getComponents().add(component);
						}
					});
		}
		return null;
	}

}
