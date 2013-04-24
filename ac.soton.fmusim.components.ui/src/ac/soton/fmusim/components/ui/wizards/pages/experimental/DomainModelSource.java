/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.wizards.pages.experimental;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * Copied from org.eclipse.gmf.internal.bridge.wizards.pages.simple.DomainModelSource.
 * 
 * @author vitaly
 *
 */
public interface DomainModelSource {

	public EPackage getContents();

	/**
	 * EClass mapped to diagram canvas.
	 */
	public EClass getDiagramElement();

	/**
	 * Returns true if domain element should be ignored.
	 * When model is being reconciled these elements are
	 * represented in it and should not be processed.
	 */
	public boolean isDisabled(EObject domainElement);
}
