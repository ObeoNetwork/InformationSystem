/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package statemachine;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Machine Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link statemachine.StateMachineDescription#getStates <em>States</em>}</li>
 *   <li>{@link statemachine.StateMachineDescription#getTransitions <em>Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see statemachine.StatemachinePackage#getStateMachineDescription()
 * @model abstract="true"
 * @generated
 */
public interface StateMachineDescription extends NamedElement {
	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link statemachine.AbstractState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see statemachine.StatemachinePackage#getStateMachineDescription_States()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractState> getStates();

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link statemachine.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see statemachine.StatemachinePackage#getStateMachineDescription_Transitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Transition> getTransitions();

} // StateMachineDescription
