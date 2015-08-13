/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.statemachine;

import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.environment.Behaviour;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.statemachine.StateMachine#getRegions <em>Regions</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.statemachine.StateMachinePackage#getStateMachine()
 * @model
 * @generated
 */
public interface StateMachine extends StateMachineDescription, Behaviour {
	/**
	 * Returns the value of the '<em><b>Regions</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.statemachine.Region}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Regions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regions</em>' containment reference list.
	 * @see org.obeonetwork.dsl.statemachine.StateMachinePackage#getStateMachine_Regions()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Region> getRegions();

} // StateMachine
