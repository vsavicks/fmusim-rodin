/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.util;

import org.ptolemy.fmi.FMIScalarVariable;
import org.ptolemy.fmi.type.FMIBooleanType;
import org.ptolemy.fmi.type.FMIIntegerType;
import org.ptolemy.fmi.type.FMIRealType;
import org.ptolemy.fmi.type.FMIStringType;
import org.ptolemy.fmi.type.FMIType;

import ac.soton.fmusim.components.FMUVariable;
import ac.soton.fmusim.components.VariableCausality;
import ac.soton.fmusim.components.VariableType;

/**
 * @author vitaly
 *
 */
public final class FmiUtil {

	/**
	 * Returns FMU variable type (from declared metamodel types in VariableType enum)
	 * that corresponds to FMI scalar variable.
	 * Also sets the start value if variable is provided.
	 * 
	 * @param scalarVariable
	 * @param variable
	 * @return
	 */
	public static VariableType getVariableType(FMIScalarVariable scalarVariable,
			FMUVariable variable) {
		FMIType type = scalarVariable.type;
		Object value = null;
		VariableType typeEnum = VariableType.REAL;
		if (type instanceof FMIRealType) {
			value = ((FMIRealType) type).start;
			typeEnum = VariableType.REAL;
		} else if (type instanceof FMIIntegerType) {
			value = ((FMIIntegerType) type).start;
			typeEnum = VariableType.INTEGER;
		} else if (type instanceof FMIBooleanType) {
			value = ((FMIBooleanType) type).start;
			typeEnum = VariableType.BOOLEAN;
		} else if (type instanceof FMIStringType) {
			value = ((FMIStringType) type).start;
			typeEnum = VariableType.STRING;
		}
		
		if (variable != null)
			variable.setValue(value);
		return typeEnum;
	}

	/**
	 * Returns components metamodel's variable causality that
	 * corresponds to provided scalar variable's causality.
	 * 
	 * @param scalarVariable
	 * @return causality
	 */
	public static VariableCausality getVariableCausality(
			FMIScalarVariable scalarVariable) {
		switch (scalarVariable.causality) {
		case internal: return VariableCausality.INTERNAL;
		case input: return VariableCausality.INPUT;
		case output: return VariableCausality.OUTPUT;
		default: return VariableCausality.NONE;
		}
	}
}
