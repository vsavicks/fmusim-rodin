/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

import ac.soton.fmusim.components.ComponentDiagram;
import ac.soton.fmusim.components.ComponentsPackage;
import ac.soton.fmusim.components.EventBPort;
import ac.soton.fmusim.components.FMUPort;
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
import ac.soton.fmusim.components.diagram.edit.parts.FMUComponentVariablesCompartmentEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUInternalVariableEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUPort2EditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUPortEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUPortNameType2EditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUPortNameTypeEditPart;
import ac.soton.fmusim.components.diagram.expressions.ComponentsOCLFactory;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class ComponentsVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "ac.soton.fmusim.components.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (ComponentDiagramEditPart.MODEL_ID.equals(view.getType())) {
				return ComponentDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return ac.soton.fmusim.components.diagram.part.ComponentsVisualIDRegistry
				.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				ComponentsDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (ComponentsPackage.eINSTANCE.getComponentDiagram().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((ComponentDiagram) domainElement)) {
			return ComponentDiagramEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = ac.soton.fmusim.components.diagram.part.ComponentsVisualIDRegistry
				.getModelID(containerView);
		if (!ComponentDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (ComponentDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = ac.soton.fmusim.components.diagram.part.ComponentsVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ComponentDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case ComponentDiagramEditPart.VISUAL_ID:
			if (ComponentsPackage.eINSTANCE.getFMUComponent().isSuperTypeOf(
					domainElement.eClass())) {
				return FMUComponentEditPart.VISUAL_ID;
			}
			if (ComponentsPackage.eINSTANCE.getEventBComponent().isSuperTypeOf(
					domainElement.eClass())) {
				return EventBComponentEditPart.VISUAL_ID;
			}
			if (ComponentsPackage.eINSTANCE.getConnector().isSuperTypeOf(
					domainElement.eClass())) {
				return ConnectorEditPart.VISUAL_ID;
			}
			break;
		case FMUComponentEditPart.VISUAL_ID:
			if (ComponentsPackage.eINSTANCE.getFMUPort().isSuperTypeOf(
					domainElement.eClass())
					&& isFMUPort_3001((FMUPort) domainElement)) {
				return FMUPortEditPart.VISUAL_ID;
			}
			if (ComponentsPackage.eINSTANCE.getFMUPort().isSuperTypeOf(
					domainElement.eClass())
					&& isFMUPort_3002((FMUPort) domainElement)) {
				return FMUPort2EditPart.VISUAL_ID;
			}
			break;
		case EventBComponentEditPart.VISUAL_ID:
			if (ComponentsPackage.eINSTANCE.getEventBPort().isSuperTypeOf(
					domainElement.eClass())
					&& isEventBPort_3003((EventBPort) domainElement)) {
				return EventBPortEditPart.VISUAL_ID;
			}
			if (ComponentsPackage.eINSTANCE.getEventBPort().isSuperTypeOf(
					domainElement.eClass())
					&& isEventBPort_3004((EventBPort) domainElement)) {
				return EventBPort2EditPart.VISUAL_ID;
			}
			break;
		case FMUComponentVariablesCompartmentEditPart.VISUAL_ID:
			if (ComponentsPackage.eINSTANCE.getFMUInternalVariable()
					.isSuperTypeOf(domainElement.eClass())) {
				return FMUInternalVariableEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = ac.soton.fmusim.components.diagram.part.ComponentsVisualIDRegistry
				.getModelID(containerView);
		if (!ComponentDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (ComponentDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = ac.soton.fmusim.components.diagram.part.ComponentsVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ComponentDiagramEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case ComponentDiagramEditPart.VISUAL_ID:
			if (FMUComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventBComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FMUComponentEditPart.VISUAL_ID:
			if (FMUComponentNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FMUComponentVariablesCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FMUPortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FMUPort2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EventBComponentEditPart.VISUAL_ID:
			if (EventBComponentNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventBPortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventBPort2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConnectorEditPart.VISUAL_ID:
			if (ConnectorValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FMUPortEditPart.VISUAL_ID:
			if (FMUPortNameTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FMUPort2EditPart.VISUAL_ID:
			if (FMUPortNameType2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EventBPortEditPart.VISUAL_ID:
			if (EventBPortNameTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EventBPort2EditPart.VISUAL_ID:
			if (EventBPortNameType2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FMUComponentVariablesCompartmentEditPart.VISUAL_ID:
			if (FMUInternalVariableEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(ComponentDiagram element) {
		return true;
	}

	/**
	 * @generated
	 */
	private static boolean isFMUPort_3001(FMUPort domainElement) {
		Object result = ComponentsOCLFactory.getExpression(0,
				ComponentsPackage.eINSTANCE.getFMUPort(), null).evaluate(
				domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isFMUPort_3002(FMUPort domainElement) {
		Object result = ComponentsOCLFactory.getExpression(2,
				ComponentsPackage.eINSTANCE.getFMUPort(), null).evaluate(
				domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isEventBPort_3003(EventBPort domainElement) {
		Object result = ComponentsOCLFactory.getExpression(4,
				ComponentsPackage.eINSTANCE.getEventBPort(), null).evaluate(
				domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isEventBPort_3004(EventBPort domainElement) {
		Object result = ComponentsOCLFactory.getExpression(6,
				ComponentsPackage.eINSTANCE.getEventBPort(), null).evaluate(
				domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	public static boolean checkNodeVisualID(View containerView,
			EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	 * @generated
	 */
	public static boolean isCompartmentVisualID(int visualID) {
		switch (visualID) {
		case FMUComponentVariablesCompartmentEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case ComponentDiagramEditPart.VISUAL_ID:
			return false;
		case ConnectorEditPart.VISUAL_ID:
		case FMUPortEditPart.VISUAL_ID:
		case FMUPort2EditPart.VISUAL_ID:
		case EventBPortEditPart.VISUAL_ID:
		case EventBPort2EditPart.VISUAL_ID:
		case FMUInternalVariableEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		 * @generated
		 */
		@Override
		public int getVisualID(View view) {
			return ac.soton.fmusim.components.diagram.part.ComponentsVisualIDRegistry
					.getVisualID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public String getModelID(View view) {
			return ac.soton.fmusim.components.diagram.part.ComponentsVisualIDRegistry
					.getModelID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return ac.soton.fmusim.components.diagram.part.ComponentsVisualIDRegistry
					.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean checkNodeVisualID(View containerView,
				EObject domainElement, int candidate) {
			return ac.soton.fmusim.components.diagram.part.ComponentsVisualIDRegistry
					.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isCompartmentVisualID(int visualID) {
			return ac.soton.fmusim.components.diagram.part.ComponentsVisualIDRegistry
					.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isSemanticLeafVisualID(int visualID) {
			return ac.soton.fmusim.components.diagram.part.ComponentsVisualIDRegistry
					.isSemanticLeafVisualID(visualID);
		}
	};

}
