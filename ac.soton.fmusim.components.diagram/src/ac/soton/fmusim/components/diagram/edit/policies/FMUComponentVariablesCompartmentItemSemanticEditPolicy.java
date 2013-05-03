/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import ac.soton.fmusim.components.diagram.edit.commands.FMUInternalVariableCreateCommand;
import ac.soton.fmusim.components.diagram.providers.ComponentsElementTypes;

/**
 * @generated
 */
public class FMUComponentVariablesCompartmentItemSemanticEditPolicy extends
		ComponentsBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public FMUComponentVariablesCompartmentItemSemanticEditPolicy() {
		super(ComponentsElementTypes.FMUComponent_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (ComponentsElementTypes.FMUInternalVariable_3006 == req
				.getElementType()) {
			return getGEFWrapper(new FMUInternalVariableCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
