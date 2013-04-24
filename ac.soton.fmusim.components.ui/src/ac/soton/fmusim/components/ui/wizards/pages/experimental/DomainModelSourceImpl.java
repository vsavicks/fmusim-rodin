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
 * @author vitaly
 *
 */
public class DomainModelSourceImpl implements DomainModelSource {

	/**
	 * @param contents
	 * @param diagramElement
	 */
	public DomainModelSourceImpl(EPackage contents, EClass diagramElement) {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see ac.soton.fmusim.components.ui.wizards.pages.DomainModelSource#getContents()
	 */
	@Override
	public EPackage getContents() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see ac.soton.fmusim.components.ui.wizards.pages.DomainModelSource#getDiagramElement()
	 */
	@Override
	public EClass getDiagramElement() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see ac.soton.fmusim.components.ui.wizards.pages.DomainModelSource#isDisabled(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public boolean isDisabled(EObject domainElement) {
		// TODO Auto-generated method stub
		return false;
	}

}
