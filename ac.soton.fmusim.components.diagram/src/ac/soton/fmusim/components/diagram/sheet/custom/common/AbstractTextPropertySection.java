/*
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.diagram.sheet.custom.common;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractBasicTextPropertySection;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;


/**
 * General text property section, used for string properties of an object.
 * 
 * @author vitaly
 *
 */
public abstract class AbstractTextPropertySection extends
		AbstractBasicTextPropertySection {

	@Override
	protected Text createTextWidget(Composite parent) {
		Text text = getWidgetFactory().createText(parent, StringStatics.BLANK);
		FormData data = new FormData();
		data.left = new FormAttachment(0, getPropertyLabelWidth(parent));
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, 0);
		text.setLayoutData(data);
		if (isReadOnly())
			text.setEditable(false);
		return text;
	}

	/**
	 * Returns width of property label.
	 * Standard implementation uses label text width to calculate the width.
	 * Subclasses may overrride.
	 * 
	 * @param parent
	 * @return
	 */
	private int getPropertyLabelWidth(Composite parent) {
		return 100;
//		return getStandardLabelWidth(parent,
//				getPropertyNameStringsArray());
	}

	@Override
	protected EObject unwrap(Object object) {
		return AbstractPropertySectionFilter.unwrap(object);
	}

}