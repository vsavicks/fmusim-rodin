/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.Variable;

import de.prob.statespace.Trace;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event BComponent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.fmusim.components.EventBComponent#isComposed <em>Composed</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.EventBComponent#getMachine <em>Machine</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.EventBComponent#getReadInputEvents <em>Read Input Events</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.EventBComponent#getTimeVariable <em>Time Variable</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.EventBComponent#getWaitEvents <em>Wait Events</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.EventBComponent#getTrace <em>Trace</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.EventBComponent#getStepPeriod <em>Step Period</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.EventBComponent#getRealPrecision <em>Real Precision</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.fmusim.components.ComponentsPackage#getEventBComponent()
 * @model
 * @generated
 */
public interface EventBComponent extends AbstractExtension, Component {
	/**
	 * Returns the value of the '<em><b>Composed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composed</em>' attribute.
	 * @see #setComposed(boolean)
	 * @see ac.soton.fmusim.components.ComponentsPackage#getEventBComponent_Composed()
	 * @model
	 * @generated
	 */
	boolean isComposed();

	/**
	 * Sets the value of the '{@link ac.soton.fmusim.components.EventBComponent#isComposed <em>Composed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composed</em>' attribute.
	 * @see #isComposed()
	 * @generated
	 */
	void setComposed(boolean value);

	/**
	 * Returns the value of the '<em><b>Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machine</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machine</em>' reference.
	 * @see #setMachine(Machine)
	 * @see ac.soton.fmusim.components.ComponentsPackage#getEventBComponent_Machine()
	 * @model required="true"
	 * @generated
	 */
	Machine getMachine();

	/**
	 * Sets the value of the '{@link ac.soton.fmusim.components.EventBComponent#getMachine <em>Machine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Machine</em>' reference.
	 * @see #getMachine()
	 * @generated
	 */
	void setMachine(Machine value);

	/**
	 * Returns the value of the '<em><b>Read Input Events</b></em>' reference list.
	 * The list contents are of type {@link org.eventb.emf.core.machine.Event}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Input Events</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Input Events</em>' reference list.
	 * @see ac.soton.fmusim.components.ComponentsPackage#getEventBComponent_ReadInputEvents()
	 * @model
	 * @generated
	 */
	EList<Event> getReadInputEvents();

	/**
	 * Returns the value of the '<em><b>Time Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Variable</em>' reference.
	 * @see #setTimeVariable(Variable)
	 * @see ac.soton.fmusim.components.ComponentsPackage#getEventBComponent_TimeVariable()
	 * @model
	 * @generated
	 */
	Variable getTimeVariable();

	/**
	 * Sets the value of the '{@link ac.soton.fmusim.components.EventBComponent#getTimeVariable <em>Time Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Variable</em>' reference.
	 * @see #getTimeVariable()
	 * @generated
	 */
	void setTimeVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Wait Events</b></em>' reference list.
	 * The list contents are of type {@link org.eventb.emf.core.machine.Event}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wait Events</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wait Events</em>' reference list.
	 * @see ac.soton.fmusim.components.ComponentsPackage#getEventBComponent_WaitEvents()
	 * @model required="true"
	 * @generated
	 */
	EList<Event> getWaitEvents();

	/**
	 * Returns the value of the '<em><b>Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace</em>' attribute.
	 * @see #setTrace(Trace)
	 * @see ac.soton.fmusim.components.ComponentsPackage#getEventBComponent_Trace()
	 * @model dataType="ac.soton.fmusim.components.TraceClass" transient="true"
	 * @generated
	 */
	Trace getTrace();

	/**
	 * Sets the value of the '{@link ac.soton.fmusim.components.EventBComponent#getTrace <em>Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace</em>' attribute.
	 * @see #getTrace()
	 * @generated
	 */
	void setTrace(Trace value);

	/**
	 * Returns the value of the '<em><b>Step Period</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Period</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Period</em>' attribute.
	 * @see #setStepPeriod(double)
	 * @see ac.soton.fmusim.components.ComponentsPackage#getEventBComponent_StepPeriod()
	 * @model default="1" required="true"
	 * @generated
	 */
	double getStepPeriod();

	/**
	 * Sets the value of the '{@link ac.soton.fmusim.components.EventBComponent#getStepPeriod <em>Step Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Period</em>' attribute.
	 * @see #getStepPeriod()
	 * @generated
	 */
	void setStepPeriod(double value);

	/**
	 * Returns the value of the '<em><b>Real Precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Real Precision</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Real Precision</em>' attribute.
	 * @see #setRealPrecision(int)
	 * @see ac.soton.fmusim.components.ComponentsPackage#getEventBComponent_RealPrecision()
	 * @model
	 * @generated
	 */
	int getRealPrecision();

	/**
	 * Sets the value of the '{@link ac.soton.fmusim.components.EventBComponent#getRealPrecision <em>Real Precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Real Precision</em>' attribute.
	 * @see #getRealPrecision()
	 * @generated
	 */
	void setRealPrecision(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean hasValidMachineReference(DiagnosticChain diagnostics, Map<Object, Object> context);

} // EventBComponent
