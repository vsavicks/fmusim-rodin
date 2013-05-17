/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.providers;

import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gef.Tool;
import org.eclipse.gef.internal.ui.palette.editparts.ToolEntryEditPart;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteListener;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.IPaletteProvider;
import org.eclipse.gmf.runtime.gef.ui.internal.palette.PaletteToolbar;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IEditorPart;

import ac.soton.fmusim.components.ui.ComponentsUIPlugin;

/**
 * Custom palette provider for components diagram.
 * 
 * @author vitaly
 *
 */
@SuppressWarnings("restriction")
public class ComponentsPaletteProvider implements IPaletteProvider {

	/**
	 * 
	 */
	private static final String IMPORT_BTN_LABEL = "Import";

	/**
	 * 
	 */
	public ComponentsPaletteProvider() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#addProviderChangeListener(org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener)
	 */
	@Override
	public void addProviderChangeListener(IProviderChangeListener listener) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
	 */
	@Override
	public boolean provides(IOperation operation) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#removeProviderChangeListener(org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener)
	 */
	@Override
	public void removeProviderChangeListener(IProviderChangeListener listener) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.palette.IPaletteProvider#contributeToPalette(org.eclipse.ui.IEditorPart, java.lang.Object, org.eclipse.gef.palette.PaletteRoot, java.util.Map)
	 */
	@Override
	public void contributeToPalette(final IEditorPart editor, Object content,
			PaletteRoot root, Map predefinedEntries) {

		for (Object e : root.getChildren()) {
			if (e instanceof PaletteToolbar) {
				
				// create and add Import tool entry
				ToolEntry entry = createImportEntry(editor);
				((PaletteToolbar) e).add(entry);
				break;
			}
		}
	}

	/**
	 * @param editor
	 * @return
	 */
	private ToolEntry createImportEntry(final IEditorPart editor) {
		return new ToolEntry(IMPORT_BTN_LABEL, "Import a component",
				ComponentsUIPlugin.imageDescriptorFromPlugin(
						ComponentsUIPlugin.getPluginID(),
						"icons/Import.gif"), null) {

			private PaletteListener postListener;
			private ISelectionChangedListener preListener;
			private ToolEntry activeTool;

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.gef.palette.ToolEntry#createTool()
			 */
			@Override
			public Tool createTool() {
				if (postListener == null) {

					// listener for recording the last selected (active) tool
					preListener = new ISelectionChangedListener() {
						@Override
						public void selectionChanged(
								SelectionChangedEvent event) {
							Object source = event.getSource();
							Object element = ((IStructuredSelection) event.getSelection()).getFirstElement();
							if (source instanceof PaletteViewer && element instanceof ToolEntryEditPart) {
								PaletteEntry entry = (PaletteEntry) ((ToolEntryEditPart) element).getModel();
								if (IMPORT_BTN_LABEL.equals(entry.getLabel())) {
									PaletteViewer palette = (PaletteViewer) source;
									activeTool = palette.getActiveTool();
								}
							}
						}
					};
					((DiagramEditor) editor)
							.getDiagramGraphicalViewer()
							.getEditDomain()
							.getPaletteViewer()
							.addSelectionChangedListener(
									preListener);
					
					// listener for unselecting the Import button and selecting previously recorded active tool (by preListener)
					postListener = new PaletteListener() {
						@Override
						public void activeToolChanged(PaletteViewer palette, ToolEntry tool) {
							if (IMPORT_BTN_LABEL.equals(tool.getLabel())) {
								palette.deselectAll();
								palette.setActiveTool(activeTool);
							}
						}
					};
					((DiagramEditor) editor)
					.getDiagramGraphicalViewer()
					.getEditDomain().getPaletteViewer()
					.addPaletteListener(postListener);
				}
				return super.createTool();
			}
		};
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.palette.IPaletteProvider#setContributions(org.eclipse.core.runtime.IConfigurationElement)
	 */
	@Override
	public void setContributions(IConfigurationElement configElement) {
		// TODO Auto-generated method stub

	}

}
