/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.statemachine;

import org.obeonetwork.dsl.environment.ObeoDSMObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.statemachine.Transition#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.statemachine.Transition#getFrom <em>From</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.statemachine.Transition#getTo <em>To</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.statemachine.StateMachinePackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends ObeoDSMObject {
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
	 * @see org.obeonetwork.dsl.statemachine.StateMachinePackage#getTransition_Guard()
	 * @model
	 * @generated
	 */
	String getGuard();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.statemachine.Transition#getGuard <em>Guard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard</em>' attribute.
	 * @see #getGuard()
	 * @generated
	 */
	void setGuard(String value);

	/**
	 * Returns the value of the '<em><b>From</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.statemachine.AbstractState#getOutcomingTransitions <em>Outcoming Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference.
	 * @see #setFrom(AbstractState)
	 * @see org.obeonetwork.dsl.statemachine.StateMachinePackage#getTransition_From()
	 * @see org.obeonetwork.dsl.statemachine.AbstractState#getOutcomingTransitions
	 * @model opposite="outcomingTransitions" required="true"
	 * @generated
	 */
	AbstractState getFrom();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.statemachine.Transition#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(AbstractState value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.statemachine.AbstractState#getIncomingTransitions <em>Incoming Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see #setTo(AbstractState)
	 * @see org.obeonetwork.dsl.statemachine.StateMachinePackage#getTransition_To()
	 * @see org.obeonetwork.dsl.statemachine.AbstractState#getIncomingTransitions
	 * @model opposite="incomingTransitions" required="true"
	 * @generated
	 */
	AbstractState getTo();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.statemachine.Transition#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(AbstractState value);

} // Transition
