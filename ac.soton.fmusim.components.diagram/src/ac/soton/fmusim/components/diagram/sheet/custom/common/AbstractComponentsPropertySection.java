/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.diagram.sheet.custom.common;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection;
import org.eclipse.swt.widgets.Composite;

/**
 * Abstract property section for a feature of components.
 * 
 * @author vitaly
 *
 */
public abstract class AbstractComponentsPropertySection extends
		AbstractModelerPropertySection {
	
	@Override
	protected EObject unwrap(Object object) {
		return AbstractPropertySectionFilter.unwrap(object);
	}

	/**
	 * Get section label width.
	 * Standard implementation uses label to calculate its width.
	 * Subclasses may override.
	 * 
	 * @param composite
	 * @return label width
	 */
	protected int getPropertyLabelWidth(Composite composite) {
		return 100;
//		return getStandardLabelWidth(composite,
//			new String[] {getLabelText()});
	}

	/**
	 * Get label of a section.
	 * 
	 * @return the label of section
	 */
	protected abstract String getLabelText();

	/**
	 * Get feature of a section.
	 * 
	 * @return the feature of section object
	 */
	protected abstract EStructuralFeature getFeature();
}
