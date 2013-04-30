/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * Components UI Plugin.
 * 
 * @author vitaly
 *
 */
public class ComponentsUIPlugin extends AbstractUIPlugin {

	// images
	public static final String COMPONENT_IMAGE = "icons/Component_big.gif";
	public static final String FMU_COMPONENT_IMAGE = "icons/FMUComponent_big.gif";
	public static final String EVENTB_COMPONENT_IMAGE = "icons/EventBComponent_big.gif";

	private static ComponentsUIPlugin instance;

	/**
	 * 
	 */
	public ComponentsUIPlugin() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		loadImage(reg, COMPONENT_IMAGE);
		loadImage(reg, FMU_COMPONENT_IMAGE);
		loadImage(reg, EVENTB_COMPONENT_IMAGE);
	}

	protected void loadImage(ImageRegistry registry, String id) {
		loadImage(registry, id, getBundle().getSymbolicName());
	}

	protected void loadImage(ImageRegistry registry, String id, String bundleId) {
		ImageDescriptor descriptor = imageDescriptorFromPlugin(bundleId, id);
		if (descriptor != null) {
			registry.put(id, descriptor);
		}
	}
	
	public static IStatus createStatus(int statusCode, String message, Throwable ex) {
		return new Status(statusCode, getPluginID(), 0, message, ex);
	}

	public static IStatus createError(String message, Throwable ex) {
		return createStatus(IStatus.ERROR, message, ex);
	}

	public static IStatus createWarning(String message) {
		return createStatus(IStatus.WARNING, message, null);
	}

	public static IStatus createInfo(String message) {
		return createStatus(IStatus.INFO, message, null);
	}
	
	public static void log(CoreException ex) {
		log(ex.getStatus());
	}

	public static void log(Exception ex) {
		if (ex instanceof CoreException) {
			log((CoreException) ex);
		} else {
			log(createError(ex.getMessage(), ex));
		}
	}

	public static String getPluginID() {
		return getInstance().getBundle().getSymbolicName();
	}

	public static void log(IStatus s) {
		getInstance().getLog().log(s);
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		instance = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		instance = null;
	}
	
	public static ComponentsUIPlugin getInstance() {
		return instance;
	}

}
