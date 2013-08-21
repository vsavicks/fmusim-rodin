/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package ac.soton.fmusim.components;

import info.monitorenter.gui.chart.Chart2D;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Display Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.fmusim.components.DisplayComponent#getChart <em>Chart</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.fmusim.components.ComponentsPackage#getDisplayComponent()
 * @model
 * @generated
 */
public interface DisplayComponent extends Component {
	/**
	 * Returns the value of the '<em><b>Chart</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chart</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chart</em>' attribute.
	 * @see #setChart(Chart2D)
	 * @see ac.soton.fmusim.components.ComponentsPackage#getDisplayComponent_Chart()
	 * @model dataType="ac.soton.fmusim.components.Chart2DClass" transient="true"
	 * @generated
	 */
	Chart2D getChart();

	/**
	 * Sets the value of the '{@link ac.soton.fmusim.components.DisplayComponent#getChart <em>Chart</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chart</em>' attribute.
	 * @see #getChart()
	 * @generated
	 */
	void setChart(Chart2D value);

} // DisplayComponent
