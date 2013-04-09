/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.wizards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * Modified version of the org.eclipse.gmf.internal.common.ui.ResourceLocationProvider
 * 
 * @author vitaly
 *
 */
public class ComponentResourceLocationProvider {

	private final List<IResource> selectedResources;

	private final List<URI> selectedURIs;

	public ComponentResourceLocationProvider(ISelection selection) {
		selectedResources = new ArrayList<IResource>();
		selectedURIs = new ArrayList<URI>();
		if (selection instanceof IStructuredSelection) {
			for (Object element : ((IStructuredSelection) selection).toList()) {
				if (element instanceof IResource) {
					selectedResources.add((IResource) element);
				} else if (element instanceof URI) {
					selectedURIs.add((URI) element);
				}
			}
		}
	}

	/**
	 * Returns selected files with specified extension.
	 * 
	 * @param explicit If true then if folder was selected looks for appropriate files in it.
	 */
	public List<IFile> getSelectedFiles(String[] extensions, boolean explicit) {
		List<IFile> files = new ArrayList<IFile>();
		if (extensions == null || extensions.length == 0) {
			return files;
		}
		addFiles(files, selectedResources, extensions);
		if (!explicit) {
			// add files from containers; they are at the end since explicitly selected files are more important
			addContainers(files, selectedResources, extensions);
		}
		return files;
	}

	protected void addFiles(List<IFile> files, List<? extends IResource> resources, String[] extensions) {
		for (IResource resource : resources) {
			if (resource instanceof IFile) {
				String fileExt = ((IFile) resource).getFileExtension();
				for (String e : extensions) {
					if (e.equals(fileExt)) {
						files.add((IFile) resource);
						break;
					}
				}
			}
		}
	}

	protected void addContainers(List<IFile> files, List<? extends IResource> resources, String[] extensions) {
		for (IResource resource : resources) {
			if (resource instanceof IContainer) {
				try {
					List<IResource> members = Arrays.asList(((IContainer) resource).members());
					addFiles(files, members, extensions);
				} catch (CoreException ce) {
					// ignore
				}
			}
		}
	}

	/**
	 * Returns selected resources with specified extension.
	 * 
	 * @param explicit If true then examines folders in selection.
	 */
	public List<URI> getSelectedURIs(String[] extensions, boolean explicit) {
		List<URI> uris = new ArrayList<URI>();
		if (extensions == null || extensions.length == 0) {
			return uris;
		}
		for (URI uri : selectedURIs) {
			String ext = uri.fileExtension();
			for (String e : extensions) {
				if (e.equals(ext)) {
					uris.add(uri);
					break;
				}
			}
		}
		// files follow uris since uris are more specific
		List<IFile> files = getSelectedFiles(extensions, explicit);
		for (IFile file : files) {
			uris.add(URI.createPlatformResourceURI(file.getFullPath().toString(), true));
		}
		return uris;
	}

	public final List<URI> getSelectedURIs(String[] extensions) {
		return getSelectedURIs(extensions, false);
	}
}
