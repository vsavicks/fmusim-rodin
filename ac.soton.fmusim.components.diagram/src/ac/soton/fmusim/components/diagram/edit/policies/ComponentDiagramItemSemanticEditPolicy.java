/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import ac.soton.fmusim.components.diagram.edit.commands.ConnectorCreateCommand;
import ac.soton.fmusim.components.diagram.edit.commands.EventBComponentCreateCommand;
import ac.soton.fmusim.components.diagram.edit.commands.FMUComponentCreateCommand;
import ac.soton.fmusim.components.diagram.providers.ComponentsElementTypes;

/**
 * @generated
 */
public class ComponentDiagramItemSemanticEditPolicy extends
		ComponentsBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ComponentDiagramItemSemanticEditPolicy() {
		super(ComponentsElementTypes.ComponentDiagram_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (ComponentsElementTypes.FMUComponent_2001 == req.getElementType()) {
			return getGEFWrapper(new FMUComponentCreateCommand(req));
		}
		if (ComponentsElementTypes.EventBComponent_2002 == req.getElementType()) {
			return getGEFWrapper(new EventBComponentCreateCommand(req));
		}
		if (ComponentsElementTypes.Connector_2003 == req.getElementType()) {
			return getGEFWrapper(new ConnectorCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends
			DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(
				TransactionalEditingDomain editingDomain,
				DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req
					.getElementsToBeDuplicated(), req
					.getAllDuplicatedElementsMap());
		}

	}

}
