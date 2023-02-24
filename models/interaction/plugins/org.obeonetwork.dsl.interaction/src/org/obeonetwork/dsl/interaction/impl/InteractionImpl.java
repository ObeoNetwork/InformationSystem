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
package org.obeonetwork.dsl.interaction.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.interaction.CombinedFragment;
import org.obeonetwork.dsl.interaction.End;
import org.obeonetwork.dsl.interaction.Execution;
import org.obeonetwork.dsl.interaction.Interaction;
import org.obeonetwork.dsl.interaction.InteractionPackage;
import org.obeonetwork.dsl.interaction.InteractionUse;
import org.obeonetwork.dsl.interaction.Message;
import org.obeonetwork.dsl.interaction.Participant;
import org.obeonetwork.dsl.interaction.StateInvariant;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.interaction.impl.InteractionImpl#getParticipants <em>Participants</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.interaction.impl.InteractionImpl#getMessages <em>Messages</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.interaction.impl.InteractionImpl#getExecutions <em>Executions</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.interaction.impl.InteractionImpl#getStateInvariants <em>State Invariants</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.interaction.impl.InteractionImpl#getInteractionUses <em>Interaction Uses</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.interaction.impl.InteractionImpl#getEnds <em>Ends</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.interaction.impl.InteractionImpl#getCombinedFragments <em>Combined Fragments</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InteractionImpl extends NamedElementImpl implements Interaction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InteractionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InteractionPackage.Literals.INTERACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Participant> getParticipants() {
		return (EList<Participant>)eDynamicGet(InteractionPackage.INTERACTION__PARTICIPANTS, InteractionPackage.Literals.INTERACTION__PARTICIPANTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Message> getMessages() {
		return (EList<Message>)eDynamicGet(InteractionPackage.INTERACTION__MESSAGES, InteractionPackage.Literals.INTERACTION__MESSAGES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Execution> getExecutions() {
		return (EList<Execution>)eDynamicGet(InteractionPackage.INTERACTION__EXECUTIONS, InteractionPackage.Literals.INTERACTION__EXECUTIONS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<StateInvariant> getStateInvariants() {
		return (EList<StateInvariant>)eDynamicGet(InteractionPackage.INTERACTION__STATE_INVARIANTS, InteractionPackage.Literals.INTERACTION__STATE_INVARIANTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<InteractionUse> getInteractionUses() {
		return (EList<InteractionUse>)eDynamicGet(InteractionPackage.INTERACTION__INTERACTION_USES, InteractionPackage.Literals.INTERACTION__INTERACTION_USES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<End> getEnds() {
		return (EList<End>)eDynamicGet(InteractionPackage.INTERACTION__ENDS, InteractionPackage.Literals.INTERACTION__ENDS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<CombinedFragment> getCombinedFragments() {
		return (EList<CombinedFragment>)eDynamicGet(InteractionPackage.INTERACTION__COMBINED_FRAGMENTS, InteractionPackage.Literals.INTERACTION__COMBINED_FRAGMENTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InteractionPackage.INTERACTION__PARTICIPANTS:
				return ((InternalEList<?>)getParticipants()).basicRemove(otherEnd, msgs);
			case InteractionPackage.INTERACTION__MESSAGES:
				return ((InternalEList<?>)getMessages()).basicRemove(otherEnd, msgs);
			case InteractionPackage.INTERACTION__EXECUTIONS:
				return ((InternalEList<?>)getExecutions()).basicRemove(otherEnd, msgs);
			case InteractionPackage.INTERACTION__STATE_INVARIANTS:
				return ((InternalEList<?>)getStateInvariants()).basicRemove(otherEnd, msgs);
			case InteractionPackage.INTERACTION__INTERACTION_USES:
				return ((InternalEList<?>)getInteractionUses()).basicRemove(otherEnd, msgs);
			case InteractionPackage.INTERACTION__ENDS:
				return ((InternalEList<?>)getEnds()).basicRemove(otherEnd, msgs);
			case InteractionPackage.INTERACTION__COMBINED_FRAGMENTS:
				return ((InternalEList<?>)getCombinedFragments()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InteractionPackage.INTERACTION__PARTICIPANTS:
				return getParticipants();
			case InteractionPackage.INTERACTION__MESSAGES:
				return getMessages();
			case InteractionPackage.INTERACTION__EXECUTIONS:
				return getExecutions();
			case InteractionPackage.INTERACTION__STATE_INVARIANTS:
				return getStateInvariants();
			case InteractionPackage.INTERACTION__INTERACTION_USES:
				return getInteractionUses();
			case InteractionPackage.INTERACTION__ENDS:
				return getEnds();
			case InteractionPackage.INTERACTION__COMBINED_FRAGMENTS:
				return getCombinedFragments();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case InteractionPackage.INTERACTION__PARTICIPANTS:
				getParticipants().clear();
				getParticipants().addAll((Collection<? extends Participant>)newValue);
				return;
			case InteractionPackage.INTERACTION__MESSAGES:
				getMessages().clear();
				getMessages().addAll((Collection<? extends Message>)newValue);
				return;
			case InteractionPackage.INTERACTION__EXECUTIONS:
				getExecutions().clear();
				getExecutions().addAll((Collection<? extends Execution>)newValue);
				return;
			case InteractionPackage.INTERACTION__STATE_INVARIANTS:
				getStateInvariants().clear();
				getStateInvariants().addAll((Collection<? extends StateInvariant>)newValue);
				return;
			case InteractionPackage.INTERACTION__INTERACTION_USES:
				getInteractionUses().clear();
				getInteractionUses().addAll((Collection<? extends InteractionUse>)newValue);
				return;
			case InteractionPackage.INTERACTION__ENDS:
				getEnds().clear();
				getEnds().addAll((Collection<? extends End>)newValue);
				return;
			case InteractionPackage.INTERACTION__COMBINED_FRAGMENTS:
				getCombinedFragments().clear();
				getCombinedFragments().addAll((Collection<? extends CombinedFragment>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case InteractionPackage.INTERACTION__PARTICIPANTS:
				getParticipants().clear();
				return;
			case InteractionPackage.INTERACTION__MESSAGES:
				getMessages().clear();
				return;
			case InteractionPackage.INTERACTION__EXECUTIONS:
				getExecutions().clear();
				return;
			case InteractionPackage.INTERACTION__STATE_INVARIANTS:
				getStateInvariants().clear();
				return;
			case InteractionPackage.INTERACTION__INTERACTION_USES:
				getInteractionUses().clear();
				return;
			case InteractionPackage.INTERACTION__ENDS:
				getEnds().clear();
				return;
			case InteractionPackage.INTERACTION__COMBINED_FRAGMENTS:
				getCombinedFragments().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case InteractionPackage.INTERACTION__PARTICIPANTS:
				return !getParticipants().isEmpty();
			case InteractionPackage.INTERACTION__MESSAGES:
				return !getMessages().isEmpty();
			case InteractionPackage.INTERACTION__EXECUTIONS:
				return !getExecutions().isEmpty();
			case InteractionPackage.INTERACTION__STATE_INVARIANTS:
				return !getStateInvariants().isEmpty();
			case InteractionPackage.INTERACTION__INTERACTION_USES:
				return !getInteractionUses().isEmpty();
			case InteractionPackage.INTERACTION__ENDS:
				return !getEnds().isEmpty();
			case InteractionPackage.INTERACTION__COMBINED_FRAGMENTS:
				return !getCombinedFragments().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InteractionImpl
