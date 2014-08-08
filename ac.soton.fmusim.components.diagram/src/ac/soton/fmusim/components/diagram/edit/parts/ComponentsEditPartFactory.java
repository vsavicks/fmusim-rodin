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

			case DisplayComponentEditPart.VISUAL_ID:
				return new DisplayComponentEditPart(view);

			case FMUInputPortEditPart.VISUAL_ID:
				return new FMUInputPortEditPart(view);

			case FMUOutputPortEditPart.VISUAL_ID:
				return new FMUOutputPortEditPart(view);

			case FMUVariableEditPart.VISUAL_ID:
				return new FMUVariableEditPart(view);

			case EventBInputPortEditPart.VISUAL_ID:
				return new EventBInputPortEditPart(view);

			case EventBOutputPortEditPart.VISUAL_ID:
				return new EventBOutputPortEditPart(view);

			case EventBVariableEditPart.VISUAL_ID:
				return new EventBVariableEditPart(view);

			case DisplayPortEditPart.VISUAL_ID:
				return new DisplayPortEditPart(view);

			case DisplayPortNameEditPart.VISUAL_ID:
				return new DisplayPortNameEditPart(view);

			case FMUComponentVariablesCompartmentEditPart.VISUAL_ID:
				return new FMUComponentVariablesCompartmentEditPart(view);

			case EventBComponentEventBVariablesCompartmentEditPart.VISUAL_ID:
				return new EventBComponentEventBVariablesCompartmentEditPart(
						view);

			case ConnectorEditPart.VISUAL_ID:
				return new ConnectorEditPart(view);

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
