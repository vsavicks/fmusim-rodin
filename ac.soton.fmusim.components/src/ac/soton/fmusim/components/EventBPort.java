/**
 */
package ac.soton.fmusim.components;

import org.eventb.emf.core.machine.Event;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event BPort</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.fmusim.components.EventBPort#getFmiGetEvent <em>Fmi Get Event</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.EventBPort#getFmiSetEvent <em>Fmi Set Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.fmusim.components.ComponentsPackage#getEventBPort()
 * @model
 * @generated
 */
public interface EventBPort extends Port {
	/**
	 * Returns the value of the '<em><b>Fmi Get Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fmi Get Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fmi Get Event</em>' reference.
	 * @see #setFmiGetEvent(Event)
	 * @see ac.soton.fmusim.components.ComponentsPackage#getEventBPort_FmiGetEvent()
	 * @model required="true"
	 * @generated
	 */
	Event getFmiGetEvent();

	/**
	 * Sets the value of the '{@link ac.soton.fmusim.components.EventBPort#getFmiGetEvent <em>Fmi Get Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fmi Get Event</em>' reference.
	 * @see #getFmiGetEvent()
	 * @generated
	 */
	void setFmiGetEvent(Event value);

	/**
	 * Returns the value of the '<em><b>Fmi Set Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fmi Set Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fmi Set Event</em>' reference.
	 * @see #setFmiSetEvent(Event)
	 * @see ac.soton.fmusim.components.ComponentsPackage#getEventBPort_FmiSetEvent()
	 * @model required="true"
	 * @generated
	 */
	Event getFmiSetEvent();

	/**
	 * Sets the value of the '{@link ac.soton.fmusim.components.EventBPort#getFmiSetEvent <em>Fmi Set Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fmi Set Event</em>' reference.
	 * @see #getFmiSetEvent()
	 * @generated
	 */
	void setFmiSetEvent(Event value);

} // EventBPort
