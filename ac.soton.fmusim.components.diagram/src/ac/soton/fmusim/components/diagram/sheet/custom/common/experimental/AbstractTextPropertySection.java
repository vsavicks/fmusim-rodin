/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.diagram.sheet.custom.common.experimental;

import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractBasicTextPropertySection;

/**
 * Abstract text property section for simple text properties.
 * Requires to implement getPropertyValue() and isReadOnlyProeprty().
 * 
 * @author vitaly
 *
 */
public abstract class AbstractTextPropertySection extends
		AbstractBasicTextPropertySection {

	/**
	 * Returns property value string.
	 * 
	 * @return value
	 */
	protected abstract String getPropertyValue();

	@Override
	protected String getPropertyValueString() {
		String value = getPropertyValue();
		return value == null ? StringStatics.BLANK : value;
	}

	@Override
	protected boolean isReadOnly() {
		return super.isReadOnly() && isReadOnlyProperty();
	}

	/**
	 * Whether property is read only.
	 * 
	 * @return true for read only
	 */
	protected abstract boolean isReadOnlyProperty();

	//XXX: this code is used in statemachines, but does not seem to make any difference
//	@Override
//	protected EObject unwrap(Object object) {
//		if (object instanceof EObject)
//			return (EObject) object;
//		if (object instanceof EditPart) {
//			Object model = ((EditPart) object).getModel();
//			return model instanceof View ? ((View) model).getElement() : null;
//		}
//		if (object instanceof View) {
//			return ((View) object).getElement();
//		}
//		if (object instanceof IAdaptable) {
//			View view = (View) ((IAdaptable) object).getAdapter(View.class);
//			if (view != null) {
//				return view.getElement();
//			}
//		}
//		return null;
//	}


}