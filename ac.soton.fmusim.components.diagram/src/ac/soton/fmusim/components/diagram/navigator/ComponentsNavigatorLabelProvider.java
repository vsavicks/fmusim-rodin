/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.diagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import ac.soton.fmusim.components.ComponentDiagram;
import ac.soton.fmusim.components.diagram.edit.parts.ComponentDiagramEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.ConnectorEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.ConnectorValueEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.EventBComponentEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.EventBComponentNameEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.EventBPort2EditPart;
import ac.soton.fmusim.components.diagram.edit.parts.EventBPortEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.EventBPortNameType2EditPart;
import ac.soton.fmusim.components.diagram.edit.parts.EventBPortNameTypeEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUComponentEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUComponentNameEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUPort2EditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUPortEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUPortNameType2EditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUPortNameTypeEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.PortConnectorEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.VariableEditPart;
import ac.soton.fmusim.components.diagram.part.ComponentsDiagramEditorPlugin;
import ac.soton.fmusim.components.diagram.part.ComponentsVisualIDRegistry;
import ac.soton.fmusim.components.diagram.providers.ComponentsElementTypes;
import ac.soton.fmusim.components.diagram.providers.ComponentsParserProvider;

/**
 * @generated
 */
public class ComponentsNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		ComponentsDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		ComponentsDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof ComponentsNavigatorItem
				&& !isOwnView(((ComponentsNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof ComponentsNavigatorGroup) {
			ComponentsNavigatorGroup group = (ComponentsNavigatorGroup) element;
			return ComponentsDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof ComponentsNavigatorItem) {
			ComponentsNavigatorItem navigatorItem = (ComponentsNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (ComponentsVisualIDRegistry.getVisualID(view)) {
		case VariableEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/fmusim/components/1.0?Variable", ComponentsElementTypes.Variable_3005); //$NON-NLS-1$
		case FMUComponentEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/fmusim/components/1.0?FMUComponent", ComponentsElementTypes.FMUComponent_2001); //$NON-NLS-1$
		case EventBPortEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/fmusim/components/1.0?EventBPort", ComponentsElementTypes.EventBPort_3003); //$NON-NLS-1$
		case FMUPortEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/fmusim/components/1.0?FMUPort", ComponentsElementTypes.FMUPort_3001); //$NON-NLS-1$
		case ConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/fmusim/components/1.0?Connector", ComponentsElementTypes.Connector_2003); //$NON-NLS-1$
		case ComponentDiagramEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://soton.ac.uk/models/fmusim/components/1.0?ComponentDiagram", ComponentsElementTypes.ComponentDiagram_1000); //$NON-NLS-1$
		case PortConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/fmusim/components/1.0?Port?connector", ComponentsElementTypes.PortConnector_4001); //$NON-NLS-1$
		case FMUPort2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/fmusim/components/1.0?FMUPort", ComponentsElementTypes.FMUPort_3002); //$NON-NLS-1$
		case EventBPort2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/fmusim/components/1.0?EventBPort", ComponentsElementTypes.EventBPort_3004); //$NON-NLS-1$
		case EventBComponentEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/fmusim/components/1.0?EventBComponent", ComponentsElementTypes.EventBComponent_2002); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = ComponentsDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& ComponentsElementTypes.isKnownElementType(elementType)) {
			image = ComponentsElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof ComponentsNavigatorGroup) {
			ComponentsNavigatorGroup group = (ComponentsNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof ComponentsNavigatorItem) {
			ComponentsNavigatorItem navigatorItem = (ComponentsNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (ComponentsVisualIDRegistry.getVisualID(view)) {
		case VariableEditPart.VISUAL_ID:
			return getVariable_3005Text(view);
		case FMUComponentEditPart.VISUAL_ID:
			return getFMUComponent_2001Text(view);
		case EventBPortEditPart.VISUAL_ID:
			return getEventBPort_3003Text(view);
		case FMUPortEditPart.VISUAL_ID:
			return getFMUPort_3001Text(view);
		case ConnectorEditPart.VISUAL_ID:
			return getConnector_2003Text(view);
		case ComponentDiagramEditPart.VISUAL_ID:
			return getComponentDiagram_1000Text(view);
		case PortConnectorEditPart.VISUAL_ID:
			return getPortConnector_4001Text(view);
		case FMUPort2EditPart.VISUAL_ID:
			return getFMUPort_3002Text(view);
		case EventBPort2EditPart.VISUAL_ID:
			return getEventBPort_3004Text(view);
		case EventBComponentEditPart.VISUAL_ID:
			return getEventBComponent_2002Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getPortConnector_4001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEventBPort_3003Text(View view) {
		IParser parser = ComponentsParserProvider.getParser(
				ComponentsElementTypes.EventBPort_3003,
				view.getElement() != null ? view.getElement() : view,
				ComponentsVisualIDRegistry
						.getType(EventBPortNameTypeEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ComponentsDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getVariable_3005Text(View view) {
		IParser parser = ComponentsParserProvider.getParser(
				ComponentsElementTypes.Variable_3005,
				view.getElement() != null ? view.getElement() : view,
				ComponentsVisualIDRegistry.getType(VariableEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ComponentsDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 3005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFMUPort_3002Text(View view) {
		IParser parser = ComponentsParserProvider.getParser(
				ComponentsElementTypes.FMUPort_3002,
				view.getElement() != null ? view.getElement() : view,
				ComponentsVisualIDRegistry
						.getType(FMUPortNameType2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ComponentsDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEventBPort_3004Text(View view) {
		IParser parser = ComponentsParserProvider.getParser(
				ComponentsElementTypes.EventBPort_3004,
				view.getElement() != null ? view.getElement() : view,
				ComponentsVisualIDRegistry
						.getType(EventBPortNameType2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ComponentsDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEventBComponent_2002Text(View view) {
		IParser parser = ComponentsParserProvider.getParser(
				ComponentsElementTypes.EventBComponent_2002,
				view.getElement() != null ? view.getElement() : view,
				ComponentsVisualIDRegistry
						.getType(EventBComponentNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ComponentsDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFMUComponent_2001Text(View view) {
		IParser parser = ComponentsParserProvider.getParser(
				ComponentsElementTypes.FMUComponent_2001,
				view.getElement() != null ? view.getElement() : view,
				ComponentsVisualIDRegistry
						.getType(FMUComponentNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ComponentsDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFMUPort_3001Text(View view) {
		IParser parser = ComponentsParserProvider.getParser(
				ComponentsElementTypes.FMUPort_3001,
				view.getElement() != null ? view.getElement() : view,
				ComponentsVisualIDRegistry
						.getType(FMUPortNameTypeEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ComponentsDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getComponentDiagram_1000Text(View view) {
		ComponentDiagram domainModelElement = (ComponentDiagram) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			ComponentsDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConnector_2003Text(View view) {
		IParser parser = ComponentsParserProvider.getParser(
				ComponentsElementTypes.Connector_2003,
				view.getElement() != null ? view.getElement() : view,
				ComponentsVisualIDRegistry
						.getType(ConnectorValueEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ComponentsDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return ComponentDiagramEditPart.MODEL_ID
				.equals(ComponentsVisualIDRegistry.getModelID(view));
	}

}
