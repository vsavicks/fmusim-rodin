/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.diagram.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eventb.emf.core.machine.Machine;

import ac.soton.fmusim.components.Component;
import ac.soton.fmusim.components.diagram.edit.commands.ComponentsCreateShortcutDecorationsCommand;
import ac.soton.fmusim.components.diagram.edit.commands.EventBComponentCreateCommand;
import ac.soton.fmusim.components.diagram.edit.policies.ComponentDiagramCanonicalEditPolicy;
import ac.soton.fmusim.components.diagram.edit.policies.ComponentDiagramItemSemanticEditPolicy;
import ac.soton.fmusim.components.diagram.part.ComponentsVisualIDRegistry;

/**
 * @generated
 */
public class ComponentDiagramEditPart extends DiagramEditPart {

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "Components"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1000;

	/**
	 * @generated
	 */
	public ComponentDiagramEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ComponentDiagramItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new ComponentDiagramCanonicalEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicyWithCustomReparent(
						ComponentsVisualIDRegistry.TYPED_INSTANCE));
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DiagramDragDropEditPolicy() {
					public Command getDropObjectsCommand(
							DropObjectsRequest dropRequest) {
						ArrayList<CreateViewRequest.ViewDescriptor> viewDescriptors = new ArrayList<CreateViewRequest.ViewDescriptor>();
						
						// create Event-B comp.
//						if (!dropRequest.getObjects().isEmpty() && dropRequest.getObjects().get(0) instanceof Machine) {
//							Machine machine = (Machine) dropRequest.getObjects().get(0);
//							ViewDescriptor viewDescriptor = new CreateViewRequest.ViewDescriptor(
//									new EObjectAdapter(machine),
//									Node.class, 
//									ComponentsVisualIDRegistry.getType(EventBComponentEditPart.VISUAL_ID),
//									getDiagramPreferencesHint());
//							viewDescriptors.add(viewDescriptor);
//							Command command = createViewsAndArrangeCommand(dropRequest, viewDescriptors);
//							if (command != null) {
//								return command
//										.chain(new ICommandProxy(
//												new ComponentsCreateShortcutDecorationsCommand(
//														getEditingDomain(),
//														(View) getModel(),
//														viewDescriptors)));
//							}
//						}
						
						for (Iterator<?> it = dropRequest.getObjects()
								.iterator(); it.hasNext();) {
							Object nextObject = it.next();
							if (false == nextObject instanceof EObject) {
								continue;
							}

							if (nextObject instanceof Machine) {
								nextObject = Platform.getAdapterManager().getAdapter(nextObject, Component.class);
							}
							viewDescriptors
									.add(new CreateViewRequest.ViewDescriptor(
											new EObjectAdapter(
													(EObject) nextObject),
											Node.class, null,
											getDiagramPreferencesHint()));
						}
						
						
						
						return createShortcutsCommand(dropRequest,
								viewDescriptors);
					}

					private Command createShortcutsCommand(
							DropObjectsRequest dropRequest,
							List<CreateViewRequest.ViewDescriptor> viewDescriptors) {
						Command command = createViewsAndArrangeCommand(
								dropRequest, viewDescriptors);
						if (command != null) {
							return command
									.chain(new ICommandProxy(
											new ComponentsCreateShortcutDecorationsCommand(
													getEditingDomain(),
													(View) getModel(),
													viewDescriptors)));
						}
						return null;
					}
				});
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#getTargetEditPart(org.eclipse.gef.Request)
	 */
	@Override
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof SelectionRequest) {
			Point location = ((SelectionRequest) request).getLocation();
			getFigure().translateToAbsolute(location);
			List<IGraphicalEditPart> children = getChildren();
			for (IGraphicalEditPart child : children) {
				Rectangle bounds = child.getFigure().getBounds().getCopy();
				getFigure().translateToAbsolute(bounds);
				if (bounds.expand(20, 20).contains(location)) {
					return child;
				}
			}
		}
		return super.getTargetEditPart(request);
	}

}
