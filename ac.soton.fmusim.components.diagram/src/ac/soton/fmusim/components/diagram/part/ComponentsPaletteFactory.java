/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.diagram.part;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import ac.soton.fmusim.components.diagram.providers.ComponentsElementTypes;

/**
 * @generated
 */
public class ComponentsPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createComponents1Group());
	}

	/**
	 * Creates "components" palette tool group
	 * @generated
	 */
	private PaletteContainer createComponents1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Components1Group_title);
		paletteContainer.setId("createComponents1Group"); //$NON-NLS-1$
		paletteContainer.add(createFMUComponent1CreationTool());
		paletteContainer.add(createEventBComponent2CreationTool());
		paletteContainer.add(createDisplayComponent3CreationTool());
		paletteContainer.add(createVariable4CreationTool());
		paletteContainer.add(createInputPort5CreationTool());
		paletteContainer.add(createOutputPort6CreationTool());
		paletteContainer.add(createConnector7CreationTool());
		paletteContainer.add(createLink8CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFMUComponent1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.FMUComponent1CreationTool_title,
				Messages.FMUComponent1CreationTool_desc,
				Collections
						.singletonList(ComponentsElementTypes.FMUComponent_2001));
		entry.setId("createFMUComponent1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ComponentsDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.fmusim.components/icons/FMUComponent.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEventBComponent2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.EventBComponent2CreationTool_title,
				Messages.EventBComponent2CreationTool_desc,
				Collections
						.singletonList(ComponentsElementTypes.EventBComponent_2002));
		entry.setId("createEventBComponent2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ComponentsDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.fmusim.components/icons/EventBComponent.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDisplayComponent3CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.DisplayComponent3CreationTool_title,
				null,
				Collections
						.singletonList(ComponentsElementTypes.DisplayComponent_2006));
		entry.setId("createDisplayComponent3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ComponentsDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.fmusim.components/icons/DisplayComponent.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createVariable4CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ComponentsElementTypes.FMUVariable_3009);
		types.add(ComponentsElementTypes.EventBVariable_3010);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Variable4CreationTool_title,
				Messages.Variable4CreationTool_desc, types);
		entry.setId("createVariable4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ComponentsDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.fmusim.components/icons/FMUVariable.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInputPort5CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(ComponentsElementTypes.FMUPort_3001);
		types.add(ComponentsElementTypes.EventBPort_3003);
		types.add(ComponentsElementTypes.DisplayPort_3013);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.InputPort5CreationTool_title,
				Messages.InputPort5CreationTool_desc, types);
		entry.setId("createInputPort5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ComponentsDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.fmusim.components/icons/InputPort.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOutputPort6CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ComponentsElementTypes.FMUPort_3002);
		types.add(ComponentsElementTypes.EventBPort_3004);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.OutputPort6CreationTool_title,
				Messages.OutputPort6CreationTool_desc, types);
		entry.setId("createOutputPort6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ComponentsDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.fmusim.components/icons/OutputPort.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConnector7CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Connector7CreationTool_title,
				Messages.Connector7CreationTool_desc,
				Collections
						.singletonList(ComponentsElementTypes.Connector_2003));
		entry.setId("createConnector7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ComponentsDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.fmusim.components/icons/Connector.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLink8CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Link8CreationTool_title,
				Messages.Link8CreationTool_desc,
				Collections
						.singletonList(ComponentsElementTypes.PortConnector_4001));
		entry.setId("createLink8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ComponentsDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.fmusim.components/icons/Link.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List<IElementType> elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List<IElementType> relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
