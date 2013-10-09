/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import ac.soton.fmusim.components.diagram.part.ValidateAction;

/**
 * Validation command that calls EMF validation via GMF-generated validate action.
 * 
 * @author vitaly
 *
 */
public class ValidateCommand extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart diagramEditor = HandlerUtil.getActiveEditorChecked(event);

		// reuse GMF-generated validate action from the diagram
		Action validateAction = new ValidateAction(diagramEditor.getSite().getPage());
		validateAction.run();
		
//		// show error markers if added
//		IResource resource = (IResource) diagramEditor.getEditorInput().getAdapter(IResource.class);
//		if (resource == null)
//			return null;
//		IMarker[] problems = null;
//		   int depth = IResource.DEPTH_INFINITE;
//		   try {
//		      problems = resource.findMarkers(IMarker.PROBLEM, true, depth);
//		      for (IMarker marker : problems) {
//		    	  System.err.println(marker.getAttribute(IMarker.MESSAGE));
//		      }
//		   } catch (CoreException e) {
//		      // something went wrong
//		   }
		return null;
	}

}
