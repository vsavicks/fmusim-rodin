/*
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import ac.soton.fmusim.components.diagram.edit.parts.DisplayPortEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.EventBInputPortEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.EventBOutputPortEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUInputPortEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUOutputPortEditPart;
import ac.soton.fmusim.components.diagram.providers.ComponentsElementTypes;
import ac.soton.fmusim.components.diagram.providers.ComponentsModelingAssistantProvider;

/**
 * @generated
 */
public class ComponentsModelingAssistantProviderOfEventBInputPortEditPart
		extends ComponentsModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((EventBInputPortEditPart) sourceEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSource(
			EventBInputPortEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(ComponentsElementTypes.Connector_4002);
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget(
				(EventBInputPortEditPart) sourceEditPart, targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSourceAndTarget(
			EventBInputPortEditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof FMUInputPortEditPart) {
			types.add(ComponentsElementTypes.Connector_4002);
		}
		if (targetEditPart instanceof FMUOutputPortEditPart) {
			types.add(ComponentsElementTypes.Connector_4002);
		}
		if (targetEditPart instanceof EventBInputPortEditPart) {
			types.add(ComponentsElementTypes.Connector_4002);
		}
		if (targetEditPart instanceof EventBOutputPortEditPart) {
			types.add(ComponentsElementTypes.Connector_4002);
		}
		if (targetEditPart instanceof DisplayPortEditPart) {
			types.add(ComponentsElementTypes.Connector_4002);
		}
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((EventBInputPortEditPart) sourceEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForTarget(
			EventBInputPortEditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == ComponentsElementTypes.Connector_4002) {
			types.add(ComponentsElementTypes.FMUPort_3001);
			types.add(ComponentsElementTypes.FMUPort_3002);
			types.add(ComponentsElementTypes.EventBPort_3003);
			types.add(ComponentsElementTypes.EventBPort_3004);
			types.add(ComponentsElementTypes.DisplayPort_3013);
		}
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((EventBInputPortEditPart) targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnTarget(
			EventBInputPortEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(ComponentsElementTypes.Connector_4002);
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((EventBInputPortEditPart) targetEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForSource(
			EventBInputPortEditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == ComponentsElementTypes.Connector_4002) {
			types.add(ComponentsElementTypes.FMUPort_3001);
			types.add(ComponentsElementTypes.FMUPort_3002);
			types.add(ComponentsElementTypes.EventBPort_3003);
			types.add(ComponentsElementTypes.EventBPort_3004);
			types.add(ComponentsElementTypes.DisplayPort_3013);
		}
		return types;
	}

}
