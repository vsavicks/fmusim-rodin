/**
s * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
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
import ac.soton.fmusim.components.Connector;
import ac.soton.fmusim.components.DisplayComponent;
import ac.soton.fmusim.components.EventBPort;
import ac.soton.fmusim.components.FMUPort;
import ac.soton.fmusim.components.diagram.edit.parts.ComponentDiagramEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.ConnectorEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.DisplayComponentEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.DisplayPortEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.DisplayPortNameEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.EventBComponentEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.EventBComponentNameEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.EventBInputPortEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.EventBOutputPortEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.EventBVariableEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUComponentEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUComponentNameEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUInputPortEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUOutputPortEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUVariableEditPart;
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

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getImage(view);
			}
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (ComponentsVisualIDRegistry.getVisualID(view)) {
		case ComponentDiagramEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://soton.ac.uk/models/fmusim/components/1.0?ComponentDiagram", ComponentsElementTypes.ComponentDiagram_1000); //$NON-NLS-1$
		case FMUComponentEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/fmusim/components/1.0?FMUComponent", ComponentsElementTypes.FMUComponent_2001); //$NON-NLS-1$
		case EventBComponentEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/fmusim/components/1.0?EventBComponent", ComponentsElementTypes.EventBComponent_2002); //$NON-NLS-1$
		case DisplayComponentEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/fmusim/components/1.0?DisplayComponent", ComponentsElementTypes.DisplayComponent_2006); //$NON-NLS-1$
		case FMUInputPortEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/fmusim/components/1.0?FMUPort", ComponentsElementTypes.FMUPort_3001); //$NON-NLS-1$
		case FMUOutputPortEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/fmusim/components/1.0?FMUPort", ComponentsElementTypes.FMUPort_3002); //$NON-NLS-1$
		case EventBInputPortEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/fmusim/components/1.0?EventBPort", ComponentsElementTypes.EventBPort_3003); //$NON-NLS-1$
		case EventBOutputPortEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/fmusim/components/1.0?EventBPort", ComponentsElementTypes.EventBPort_3004); //$NON-NLS-1$
		case FMUVariableEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/fmusim/components/1.0?FMUVariable", ComponentsElementTypes.FMUVariable_3009); //$NON-NLS-1$
		case EventBVariableEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/fmusim/components/1.0?EventBVariable", ComponentsElementTypes.EventBVariable_3010); //$NON-NLS-1$
		case DisplayPortEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://soton.ac.uk/models/fmusim/components/1.0?DisplayPort", ComponentsElementTypes.DisplayPort_3013); //$NON-NLS-1$
		case ConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/fmusim/components/1.0?Connector", ComponentsElementTypes.Connector_4002); //$NON-NLS-1$
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

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getText(view);
			}
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
		case ComponentDiagramEditPart.VISUAL_ID:
			return getComponentDiagram_1000Text(view);
		case FMUComponentEditPart.VISUAL_ID:
			return getFMUComponent_2001Text(view);
		case EventBComponentEditPart.VISUAL_ID:
			return getEventBComponent_2002Text(view);
		case DisplayComponentEditPart.VISUAL_ID:
			return getDisplayComponent_2006Text(view);
		case FMUInputPortEditPart.VISUAL_ID:
			return getFMUPort_3001Text(view);
		case FMUOutputPortEditPart.VISUAL_ID:
			return getFMUPort_3002Text(view);
		case EventBInputPortEditPart.VISUAL_ID:
			return getEventBPort_3003Text(view);
		case EventBOutputPortEditPart.VISUAL_ID:
			return getEventBPort_3004Text(view);
		case FMUVariableEditPart.VISUAL_ID:
			return getFMUVariable_3009Text(view);
		case EventBVariableEditPart.VISUAL_ID:
			return getEventBVariable_3010Text(view);
		case DisplayPortEditPart.VISUAL_ID:
			return getDisplayPort_3013Text(view);
		case ConnectorEditPart.VISUAL_ID:
			return getConnector_4002Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getEventBPort_3003Text(View view) {
		EventBPort domainModelElement = (EventBPort) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			ComponentsDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFMUPort_3002Text(View view) {
		FMUPort domainModelElement = (FMUPort) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			ComponentsDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEventBPort_3004Text(View view) {
		EventBPort domainModelElement = (EventBPort) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			ComponentsDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFMUVariable_3009Text(View view) {
		IParser parser = ComponentsParserProvider.getParser(
				ComponentsElementTypes.FMUVariable_3009,
				view.getElement() != null ? view.getElement() : view,
				ComponentsVisualIDRegistry
						.getType(FMUVariableEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ComponentsDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 3009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEventBVariable_3010Text(View view) {
		IParser parser = ComponentsParserProvider.getParser(
				ComponentsElementTypes.EventBVariable_3010,
				view.getElement() != null ? view.getElement() : view,
				ComponentsVisualIDRegistry
						.getType(EventBVariableEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ComponentsDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 3010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDisplayPort_3013Text(View view) {
		IParser parser = ComponentsParserProvider.getParser(
				ComponentsElementTypes.DisplayPort_3013,
				view.getElement() != null ? view.getElement() : view,
				ComponentsVisualIDRegistry
						.getType(DisplayPortNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ComponentsDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConnector_4002Text(View view) {
		Connector domainModelElement = (Connector) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			ComponentsDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 4002); //$NON-NLS-1$
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
		FMUPort domainModelElement = (FMUPort) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			ComponentsDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3001); //$NON-NLS-1$
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
	private String getDisplayComponent_2006Text(View view) {
		DisplayComponent domainModelElement = (DisplayComponent) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			ComponentsDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2006); //$NON-NLS-1$
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
