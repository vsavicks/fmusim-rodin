/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

import ac.soton.fmusim.components.diagram.part.ComponentsVisualIDRegistry;

/**
 * @generated
 */
public class ComponentsEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (ComponentsVisualIDRegistry.getVisualID(view)) {

			case ComponentDiagramEditPart.VISUAL_ID:
				return new ComponentDiagramEditPart(view);

			case FMUComponentEditPart.VISUAL_ID:
				return new FMUComponentEditPart(view);

			case FMUComponentNameEditPart.VISUAL_ID:
				return new FMUComponentNameEditPart(view);

			case EventBComponentEditPart.VISUAL_ID:
				return new EventBComponentEditPart(view);

			case EventBComponentNameEditPart.VISUAL_ID:
				return new EventBComponentNameEditPart(view);

			case ConnectorEditPart.VISUAL_ID:
				return new ConnectorEditPart(view);

			case ConnectorValueEditPart.VISUAL_ID:
				return new ConnectorValueEditPart(view);

			case FMUPortEditPart.VISUAL_ID:
				return new FMUPortEditPart(view);

			case FMUPortNameTypeEditPart.VISUAL_ID:
				return new FMUPortNameTypeEditPart(view);

			case FMUPort2EditPart.VISUAL_ID:
				return new FMUPort2EditPart(view);

			case FMUPortNameType2EditPart.VISUAL_ID:
				return new FMUPortNameType2EditPart(view);

			case VariableEditPart.VISUAL_ID:
				return new VariableEditPart(view);

			case EventBPortEditPart.VISUAL_ID:
				return new EventBPortEditPart(view);

			case EventBPortNameTypeEditPart.VISUAL_ID:
				return new EventBPortNameTypeEditPart(view);

			case EventBPort2EditPart.VISUAL_ID:
				return new EventBPort2EditPart(view);

			case EventBPortNameType2EditPart.VISUAL_ID:
				return new EventBPortNameType2EditPart(view);

			case FMUComponentVariablesCompartmentEditPart.VISUAL_ID:
				return new FMUComponentVariablesCompartmentEditPart(view);

			case PortConnectorEditPart.VISUAL_ID:
				return new PortConnectorEditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(
			ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE
				.getTextCellEditorLocator(source);
	}

}
