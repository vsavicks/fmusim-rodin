/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

import ac.soton.fmusim.components.Component;
import ac.soton.fmusim.components.ComponentDiagram;
import ac.soton.fmusim.components.ComponentsPackage;
import ac.soton.fmusim.components.Connector;
import ac.soton.fmusim.components.EventBComponent;
import ac.soton.fmusim.components.EventBPort;
import ac.soton.fmusim.components.FMUComponent;
import ac.soton.fmusim.components.FMUPort;
import ac.soton.fmusim.components.Port;
import ac.soton.fmusim.components.Variable;
import ac.soton.fmusim.components.diagram.edit.parts.ComponentDiagramEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.ConnectorEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.EventBComponentEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.EventBPort2EditPart;
import ac.soton.fmusim.components.diagram.edit.parts.EventBPortEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUComponentEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUComponentVariablesCompartmentEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUPort2EditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUPortEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.PortConnectorEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.VariableEditPart;
import ac.soton.fmusim.components.diagram.providers.ComponentsElementTypes;

/**
 * @generated
 */
public class ComponentsDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<ComponentsNodeDescriptor> getSemanticChildren(View view) {
		switch (ComponentsVisualIDRegistry.getVisualID(view)) {
		case ComponentDiagramEditPart.VISUAL_ID:
			return getComponentDiagram_1000SemanticChildren(view);
		case FMUComponentEditPart.VISUAL_ID:
			return getFMUComponent_2001SemanticChildren(view);
		case EventBComponentEditPart.VISUAL_ID:
			return getEventBComponent_2002SemanticChildren(view);
		case FMUComponentVariablesCompartmentEditPart.VISUAL_ID:
			return getFMUComponentVariablesCompartment_7001SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsNodeDescriptor> getComponentDiagram_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		ComponentDiagram modelElement = (ComponentDiagram) view.getElement();
		LinkedList<ComponentsNodeDescriptor> result = new LinkedList<ComponentsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getComponents().iterator(); it
				.hasNext();) {
			Component childElement = (Component) it.next();
			int visualID = ComponentsVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == FMUComponentEditPart.VISUAL_ID) {
				result.add(new ComponentsNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventBComponentEditPart.VISUAL_ID) {
				result.add(new ComponentsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getConnectors().iterator(); it
				.hasNext();) {
			Connector childElement = (Connector) it.next();
			int visualID = ComponentsVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ConnectorEditPart.VISUAL_ID) {
				result.add(new ComponentsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsNodeDescriptor> getFMUComponent_2001SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		FMUComponent modelElement = (FMUComponent) view.getElement();
		LinkedList<ComponentsNodeDescriptor> result = new LinkedList<ComponentsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getInputs().iterator(); it.hasNext();) {
			Port childElement = (Port) it.next();
			int visualID = ComponentsVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == FMUPortEditPart.VISUAL_ID) {
				result.add(new ComponentsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getOutputs().iterator(); it
				.hasNext();) {
			Port childElement = (Port) it.next();
			int visualID = ComponentsVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == FMUPort2EditPart.VISUAL_ID) {
				result.add(new ComponentsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsNodeDescriptor> getEventBComponent_2002SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		EventBComponent modelElement = (EventBComponent) view.getElement();
		LinkedList<ComponentsNodeDescriptor> result = new LinkedList<ComponentsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getInputs().iterator(); it.hasNext();) {
			Port childElement = (Port) it.next();
			int visualID = ComponentsVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == EventBPortEditPart.VISUAL_ID) {
				result.add(new ComponentsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getOutputs().iterator(); it
				.hasNext();) {
			Port childElement = (Port) it.next();
			int visualID = ComponentsVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == EventBPort2EditPart.VISUAL_ID) {
				result.add(new ComponentsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsNodeDescriptor> getFMUComponentVariablesCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		FMUComponent modelElement = (FMUComponent) containerView.getElement();
		LinkedList<ComponentsNodeDescriptor> result = new LinkedList<ComponentsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getVariables().iterator(); it
				.hasNext();) {
			Variable childElement = (Variable) it.next();
			int visualID = ComponentsVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == VariableEditPart.VISUAL_ID) {
				result.add(new ComponentsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getContainedLinks(View view) {
		switch (ComponentsVisualIDRegistry.getVisualID(view)) {
		case ComponentDiagramEditPart.VISUAL_ID:
			return getComponentDiagram_1000ContainedLinks(view);
		case FMUComponentEditPart.VISUAL_ID:
			return getFMUComponent_2001ContainedLinks(view);
		case EventBComponentEditPart.VISUAL_ID:
			return getEventBComponent_2002ContainedLinks(view);
		case ConnectorEditPart.VISUAL_ID:
			return getConnector_2003ContainedLinks(view);
		case FMUPortEditPart.VISUAL_ID:
			return getFMUPort_3001ContainedLinks(view);
		case FMUPort2EditPart.VISUAL_ID:
			return getFMUPort_3002ContainedLinks(view);
		case VariableEditPart.VISUAL_ID:
			return getVariable_3005ContainedLinks(view);
		case EventBPortEditPart.VISUAL_ID:
			return getEventBPort_3003ContainedLinks(view);
		case EventBPort2EditPart.VISUAL_ID:
			return getEventBPort_3004ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getIncomingLinks(View view) {
		switch (ComponentsVisualIDRegistry.getVisualID(view)) {
		case FMUComponentEditPart.VISUAL_ID:
			return getFMUComponent_2001IncomingLinks(view);
		case EventBComponentEditPart.VISUAL_ID:
			return getEventBComponent_2002IncomingLinks(view);
		case ConnectorEditPart.VISUAL_ID:
			return getConnector_2003IncomingLinks(view);
		case FMUPortEditPart.VISUAL_ID:
			return getFMUPort_3001IncomingLinks(view);
		case FMUPort2EditPart.VISUAL_ID:
			return getFMUPort_3002IncomingLinks(view);
		case VariableEditPart.VISUAL_ID:
			return getVariable_3005IncomingLinks(view);
		case EventBPortEditPart.VISUAL_ID:
			return getEventBPort_3003IncomingLinks(view);
		case EventBPort2EditPart.VISUAL_ID:
			return getEventBPort_3004IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getOutgoingLinks(View view) {
		switch (ComponentsVisualIDRegistry.getVisualID(view)) {
		case FMUComponentEditPart.VISUAL_ID:
			return getFMUComponent_2001OutgoingLinks(view);
		case EventBComponentEditPart.VISUAL_ID:
			return getEventBComponent_2002OutgoingLinks(view);
		case ConnectorEditPart.VISUAL_ID:
			return getConnector_2003OutgoingLinks(view);
		case FMUPortEditPart.VISUAL_ID:
			return getFMUPort_3001OutgoingLinks(view);
		case FMUPort2EditPart.VISUAL_ID:
			return getFMUPort_3002OutgoingLinks(view);
		case VariableEditPart.VISUAL_ID:
			return getVariable_3005OutgoingLinks(view);
		case EventBPortEditPart.VISUAL_ID:
			return getEventBPort_3003OutgoingLinks(view);
		case EventBPort2EditPart.VISUAL_ID:
			return getEventBPort_3004OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getComponentDiagram_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getFMUComponent_2001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getEventBComponent_2002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getConnector_2003ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getFMUPort_3001ContainedLinks(
			View view) {
		FMUPort modelElement = (FMUPort) view.getElement();
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Connector_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getFMUPort_3002ContainedLinks(
			View view) {
		FMUPort modelElement = (FMUPort) view.getElement();
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Connector_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getVariable_3005ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getEventBPort_3003ContainedLinks(
			View view) {
		EventBPort modelElement = (EventBPort) view.getElement();
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Connector_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getEventBPort_3004ContainedLinks(
			View view) {
		EventBPort modelElement = (EventBPort) view.getElement();
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Connector_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getFMUComponent_2001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getEventBComponent_2002IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getConnector_2003IncomingLinks(
			View view) {
		Connector modelElement = (Connector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Port_Connector_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getFMUPort_3001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getFMUPort_3002IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getVariable_3005IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getEventBPort_3003IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getEventBPort_3004IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getFMUComponent_2001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getEventBComponent_2002OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getConnector_2003OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getFMUPort_3001OutgoingLinks(
			View view) {
		FMUPort modelElement = (FMUPort) view.getElement();
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Connector_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getFMUPort_3002OutgoingLinks(
			View view) {
		FMUPort modelElement = (FMUPort) view.getElement();
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Connector_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getVariable_3005OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getEventBPort_3003OutgoingLinks(
			View view) {
		EventBPort modelElement = (EventBPort) view.getElement();
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Connector_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ComponentsLinkDescriptor> getEventBPort_3004OutgoingLinks(
			View view) {
		EventBPort modelElement = (EventBPort) view.getElement();
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Connector_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ComponentsLinkDescriptor> getIncomingFeatureModelFacetLinks_Port_Connector_4001(
			Connector target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == ComponentsPackage.eINSTANCE
					.getPort_Connector()) {
				result.add(new ComponentsLinkDescriptor(setting.getEObject(),
						target, ComponentsElementTypes.PortConnector_4001,
						PortConnectorEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ComponentsLinkDescriptor> getOutgoingFeatureModelFacetLinks_Port_Connector_4001(
			Port source) {
		LinkedList<ComponentsLinkDescriptor> result = new LinkedList<ComponentsLinkDescriptor>();
		Connector destination = source.getConnector();
		if (destination == null) {
			return result;
		}
		result.add(new ComponentsLinkDescriptor(source, destination,
				ComponentsElementTypes.PortConnector_4001,
				PortConnectorEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		 * @generated
		 */
		@Override
		public List<ComponentsNodeDescriptor> getSemanticChildren(View view) {
			return ComponentsDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<ComponentsLinkDescriptor> getContainedLinks(View view) {
			return ComponentsDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<ComponentsLinkDescriptor> getIncomingLinks(View view) {
			return ComponentsDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<ComponentsLinkDescriptor> getOutgoingLinks(View view) {
			return ComponentsDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
