/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.providers;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SemanticCreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eventb.emf.core.machine.Machine;

import ac.soton.fmusim.components.Component;
import ac.soton.fmusim.components.ComponentDiagram;
import ac.soton.fmusim.components.EventBComponent;
import ac.soton.fmusim.components.diagram.edit.commands.EventBComponentCreateCommand;
import ac.soton.fmusim.components.diagram.providers.ComponentsElementTypes;

/**
 * Diagram drag and drop edit policy that allows to drop
 * machines and Event-B components to component diagram.
 * 
 * @author vitaly
 *
 */
public class DiagramDnDComponentEditPolicy extends DiagramDragDropEditPolicy {
	public Command getDropObjectsCommand(
			DropObjectsRequest dropRequest) {
		// don't support multiple selections
		if (dropRequest.getObjects().size() == 0 || dropRequest.getObjects().size() > 1)
			return null;
		
		GraphicalEditPart editPart = (GraphicalEditPart) getHost();
		Object nextObject = dropRequest.getObjects().get(0);
		
		if (nextObject instanceof Machine) {
			return getDropMachineCommand(editPart, (Machine) nextObject, dropRequest);
		}
		if (nextObject instanceof EventBComponent) {
			return getDropComponentCommand(editPart, (EventBComponent) nextObject, dropRequest);
		}
		
		return null;
	}

	/**
	 * @param part
	 * @param machine
	 * @param dropRequest
	 * @return
	 */
	private Command getDropMachineCommand(GraphicalEditPart part, final Machine machine,
			DropObjectsRequest dropRequest) {
		return new ICommandProxy(
				new EventBComponentCreateCommand(
						new CreateElementRequest(
								part.getEditingDomain(),
								((View) part.getModel())
										.getElement(),
								ComponentsElementTypes.EventBComponent_2002)){

									@Override
									protected CommandResult doExecuteWithResult(
											IProgressMonitor monitor,
											IAdaptable info)
											throws ExecutionException {
										EventBComponent newElement = (EventBComponent) Platform.getAdapterManager().getAdapter(machine, Component.class);
										newElement = EcoreUtil.copy(newElement);
										//TODO: add the presentation of the component configuration dialog

										ComponentDiagram owner = (ComponentDiagram) getElementToEdit();
										owner.getComponents().add(newElement);

										doConfigure(newElement, monitor, info);

										((CreateElementRequest) getRequest()).setNewElement(newElement);
										return CommandResult.newOKCommandResult(newElement);
									}});
	}

	/**
	 * @param part
	 * @param component
	 * @param dropRequest
	 * @return
	 */
	private Command getDropComponentCommand(GraphicalEditPart part, final EventBComponent component, DropObjectsRequest dropRequest) {
		// requests and adapters
		IElementType type = ComponentsElementTypes.EventBComponent_2002;
		CreateElementRequest createElementRequest = new CreateElementRequest(
				part.getEditingDomain(), ((View) part.getModel()).getElement(),
				ComponentsElementTypes.EventBComponent_2002);
		CreateElementRequestAdapter adapter = new CreateElementRequestAdapter(createElementRequest);
		ViewAndElementDescriptor descriptor = new ViewAndElementDescriptor(
				adapter,
				Node.class,
				((IHintedType) type).getSemanticHint(), 
				part.getDiagramPreferencesHint());
		CreateViewAndElementRequest request = new CreateViewAndElementRequest(descriptor);
		request.setLocation(dropRequest.getLocation().getCopy());

		// element command (customised to return an existing element)
		Command createElementCommand = new ICommandProxy(
				new EventBComponentCreateCommand((CreateElementRequest) descriptor.getCreateElementRequestAdapter().getAdapter(CreateElementRequest.class)) {

					@Override
					protected CommandResult doExecuteWithResult(
							IProgressMonitor monitor, IAdaptable info)
							throws ExecutionException {
						// create a copy, as the component may already exist on the diagram
						EventBComponent newElement = EcoreUtil.copy(component);

						ComponentDiagram owner = (ComponentDiagram) getElementToEdit();
						owner.getComponents().add(newElement);

						doConfigure(newElement, monitor, info);

						((CreateElementRequest) getRequest())
								.setNewElement(newElement);
						return CommandResult.newOKCommandResult(newElement);
					}
				});
		
		// semantic command
		SemanticCreateCommand semanticCommand = new SemanticCreateCommand(adapter, createElementCommand);
		
		// view command
		CreateCommand viewCommand = new CreateCommand(part.getEditingDomain(), descriptor, (View) (getHost().getModel()));
		
		// relocate command
		Point dropLocation = dropRequest.getLocation().getCopy();
		((GraphicalEditPart) part).getFigure().translateToRelative(dropLocation);
		SetBoundsCommand relocateCommand = new SetBoundsCommand(part.getEditingDomain(), "Set location", request.getViewAndElementDescriptor(), dropLocation);
		
		// compound command
		CompositeCommand cc = new CompositeCommand(semanticCommand.getLabel());
		cc.compose(semanticCommand);
		cc.compose(viewCommand);
		cc.compose(relocateCommand);
		return new ICommandProxy(cc);
	}
}