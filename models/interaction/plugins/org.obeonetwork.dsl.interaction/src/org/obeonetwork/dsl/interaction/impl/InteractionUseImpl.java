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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.dsl.interaction.Interaction;
import org.obeonetwork.dsl.interaction.InteractionPackage;
import org.obeonetwork.dsl.interaction.InteractionUse;
import org.obeonetwork.dsl.interaction.Participant;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Use</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.interaction.impl.InteractionUseImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.interaction.impl.InteractionUseImpl#getInteraction <em>Interaction</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.interaction.impl.InteractionUseImpl#getCoveredParticipants <em>Covered Participants</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InteractionUseImpl extends InteractionFragmentImpl implements InteractionUse {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InteractionUseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InteractionPackage.Literals.INTERACTION_USE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return (String)eDynamicGet(InteractionPackage.INTERACTION_USE__TYPE, InteractionPackage.Literals.INTERACTION_USE__TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		eDynamicSet(InteractionPackage.INTERACTION_USE__TYPE, InteractionPackage.Literals.INTERACTION_USE__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interaction getInteraction() {
		return (Interaction)eDynamicGet(InteractionPackage.INTERACTION_USE__INTERACTION, InteractionPackage.Literals.INTERACTION_USE__INTERACTION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interaction basicGetInteraction() {
		return (Interaction)eDynamicGet(InteractionPackage.INTERACTION_USE__INTERACTION, InteractionPackage.Literals.INTERACTION_USE__INTERACTION, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInteraction(Interaction newInteraction) {
		eDynamicSet(InteractionPackage.INTERACTION_USE__INTERACTION, InteractionPackage.Literals.INTERACTION_USE__INTERACTION, newInteraction);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Participant> getCoveredParticipants() {
		return (EList<Participant>)eDynamicGet(InteractionPackage.INTERACTION_USE__COVERED_PARTICIPANTS, InteractionPackage.Literals.INTERACTION_USE__COVERED_PARTICIPANTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InteractionPackage.INTERACTION_USE__TYPE:
				return getType();
			case InteractionPackage.INTERACTION_USE__INTERACTION:
				if (resolve) return getInteraction();
				return basicGetInteraction();
			case InteractionPackage.INTERACTION_USE__COVERED_PARTICIPANTS:
				return getCoveredParticipants();
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
			case InteractionPackage.INTERACTION_USE__TYPE:
				setType((String)newValue);
				return;
			case InteractionPackage.INTERACTION_USE__INTERACTION:
				setInteraction((Interaction)newValue);
				return;
			case InteractionPackage.INTERACTION_USE__COVERED_PARTICIPANTS:
				getCoveredParticipants().clear();
				getCoveredParticipants().addAll((Collection<? extends Participant>)newValue);
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
			case InteractionPackage.INTERACTION_USE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case InteractionPackage.INTERACTION_USE__INTERACTION:
				setInteraction((Interaction)null);
				return;
			case InteractionPackage.INTERACTION_USE__COVERED_PARTICIPANTS:
				getCoveredParticipants().clear();
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
			case InteractionPackage.INTERACTION_USE__TYPE:
				return TYPE_EDEFAULT == null ? getType() != null : !TYPE_EDEFAULT.equals(getType());
			case InteractionPackage.INTERACTION_USE__INTERACTION:
				return basicGetInteraction() != null;
			case InteractionPackage.INTERACTION_USE__COVERED_PARTICIPANTS:
				return !getCoveredParticipants().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InteractionUseImpl
