/*******************************************************************************
 * Copyright (c) 2011, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.interaction;

import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.environment.Behaviour;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interaction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.interaction.Interaction#getParticipants <em>Participants</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.interaction.Interaction#getMessages <em>Messages</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.interaction.Interaction#getExecutions <em>Executions</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.interaction.Interaction#getStateInvariants <em>State Invariants</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.interaction.Interaction#getInteractionUses <em>Interaction Uses</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.interaction.Interaction#getEnds <em>Ends</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.interaction.Interaction#getCombinedFragments <em>Combined Fragments</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getInteraction()
 * @model
 * @generated
 */
public interface Interaction extends NamedElement, Behaviour {
	/**
	 * Returns the value of the '<em><b>Participants</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.interaction.Participant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Participants</em>' containment reference list.
	 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getInteraction_Participants()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Participant> getParticipants();

	/**
	 * Returns the value of the '<em><b>Messages</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.interaction.Message}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Messages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Messages</em>' containment reference list.
	 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getInteraction_Messages()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Message> getMessages();

	/**
	 * Returns the value of the '<em><b>Executions</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.interaction.Execution}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Executions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Executions</em>' containment reference list.
	 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getInteraction_Executions()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Execution> getExecutions();

	/**
	 * Returns the value of the '<em><b>State Invariants</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.interaction.StateInvariant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Invariants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Invariants</em>' containment reference list.
	 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getInteraction_StateInvariants()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<StateInvariant> getStateInvariants();

	/**
	 * Returns the value of the '<em><b>Interaction Uses</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.interaction.InteractionUse}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interaction Uses</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interaction Uses</em>' containment reference list.
	 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getInteraction_InteractionUses()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<InteractionUse> getInteractionUses();

	/**
	 * Returns the value of the '<em><b>Ends</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.interaction.End}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ends</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ends</em>' containment reference list.
	 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getInteraction_Ends()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<End> getEnds();

	/**
	 * Returns the value of the '<em><b>Combined Fragments</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.interaction.CombinedFragment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Combined Fragments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Combined Fragments</em>' containment reference list.
	 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getInteraction_CombinedFragments()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<CombinedFragment> getCombinedFragments();

} // Interaction
