/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.diagram.sheet.custom.common.experimental;

import org.eclipse.emf.ecore.EObject;

import ac.soton.fmusim.components.AbstractVariable;
import ac.soton.fmusim.components.VariableType;

/**
 * @author vitaly
 *
 */
public class TypePropertySection extends AbstractEnumerationPropertySection {

	@Override
	protected String getPropertyNameLabel() {
		return "Type:";
	}

	@Override
	protected void setPropertyValue(EObject object, Object value) {
		assert object instanceof AbstractVariable;
		((AbstractVariable) object).setType((VariableType) value);
	}

	@Override
	protected Object[] getEnumPropertyValues() {
		return VariableType.values();
	}

	@Override
	protected String getPropertyValueString() {
		return ((AbstractVariable) getEObject()).getType().getName();
	}

	@Override
	protected String[] getEnumPropertyValueStrings() {
		VariableType[] values = VariableType.values();
		String[] valStrings = new String[values.length];
		for (int i = 0; i < values.length; i++) {
			valStrings[i] = values[i].getName();
		}
		return valStrings;
	}
	@Override

	protected String getPropertyChangeCommandName() {
		return "change type";
	}

}
