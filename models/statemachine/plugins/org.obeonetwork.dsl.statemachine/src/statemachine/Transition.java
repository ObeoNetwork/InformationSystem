/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package statemachine;

import org.eclipse.emf.cdo.CDOObject;

import org.obeonetwork.dsl.environment.ObeoDSMObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link statemachine.Transition#getGuard <em>Guard</em>}</li>
 *   <li>{@link statemachine.Transition#getFrom <em>From</em>}</li>
 *   <li>{@link statemachine.Transition#getTo <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @see statemachine.StatemachinePackage#getTransition()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface Transition extends CDOObject, ObeoDSMObject {
	/**
	 * Returns the value of the '<em><b>Guard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard</em>' attribute.
	 * @see #setGuard(String)
	 * @see statemachine.StatemachinePackage#getTransition_Guard()
	 * @model
	 * @generated
	 */
	String getGuard();

	/**
	 * Sets the value of the '{@link statemachine.Transition#getGuard <em>Guard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard</em>' attribute.
	 * @see #getGuard()
	 * @generated
	 */
	void setGuard(String value);

	/**
	 * Returns the value of the '<em><b>From</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link statemachine.AbstractState#getOutcomingTransitions <em>Outcoming Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference.
	 * @see #setFrom(AbstractState)
	 * @see statemachine.StatemachinePackage#getTransition_From()
	 * @see statemachine.AbstractState#getOutcomingTransitions
	 * @model opposite="outcomingTransitions" required="true"
	 * @generated
	 */
	AbstractState getFrom();

	/**
	 * Sets the value of the '{@link statemachine.Transition#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(AbstractState value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link statemachine.AbstractState#getIncomingTransitions <em>Incoming Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see #setTo(AbstractState)
	 * @see statemachine.StatemachinePackage#getTransition_To()
	 * @see statemachine.AbstractState#getIncomingTransitions
	 * @model opposite="incomingTransitions" required="true"
	 * @generated
	 */
	AbstractState getTo();

	/**
	 * Sets the value of the '{@link statemachine.Transition#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(AbstractState value);

} // Transition
