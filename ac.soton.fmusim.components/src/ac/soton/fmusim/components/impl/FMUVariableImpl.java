/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package ac.soton.fmusim.components.impl;

import org.eclipse.emf.ecore.EClass;

import ac.soton.fmusim.components.ComponentsPackage;
import ac.soton.fmusim.components.FMUVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FMU Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class FMUVariableImpl extends AbstractVariableImpl implements FMUVariable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FMUVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentsPackage.Literals.FMU_VARIABLE;
	}

} //FMUVariableImpl
