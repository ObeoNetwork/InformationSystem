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
package org.obeonetwork.dsl.interaction.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.interaction.CombinedFragment;
import org.obeonetwork.dsl.interaction.InteractionPackage;
import org.obeonetwork.dsl.interaction.Operand;
import org.obeonetwork.dsl.interaction.Participant;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Combined Fragment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.interaction.impl.CombinedFragmentImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.interaction.impl.CombinedFragmentImpl#getCoveredParticipants <em>Covered Participants</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.interaction.impl.CombinedFragmentImpl#getOwnedOperands <em>Owned Operands</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CombinedFragmentImpl extends InteractionFragmentImpl implements CombinedFragment {
	/**
	 * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected static final String OPERATOR_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CombinedFragmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InteractionPackage.Literals.COMBINED_FRAGMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperator() {
		return (String)eDynamicGet(InteractionPackage.COMBINED_FRAGMENT__OPERATOR, InteractionPackage.Literals.COMBINED_FRAGMENT__OPERATOR, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperator(String newOperator) {
		eDynamicSet(InteractionPackage.COMBINED_FRAGMENT__OPERATOR, InteractionPackage.Literals.COMBINED_FRAGMENT__OPERATOR, newOperator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Participant> getCoveredParticipants() {
		return (EList<Participant>)eDynamicGet(InteractionPackage.COMBINED_FRAGMENT__COVERED_PARTICIPANTS, InteractionPackage.Literals.COMBINED_FRAGMENT__COVERED_PARTICIPANTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Operand> getOwnedOperands() {
		return (EList<Operand>)eDynamicGet(InteractionPackage.COMBINED_FRAGMENT__OWNED_OPERANDS, InteractionPackage.Literals.COMBINED_FRAGMENT__OWNED_OPERANDS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InteractionPackage.COMBINED_FRAGMENT__OWNED_OPERANDS:
				return ((InternalEList<?>)getOwnedOperands()).basicRemove(otherEnd, msgs);
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
			case InteractionPackage.COMBINED_FRAGMENT__OPERATOR:
				return getOperator();
			case InteractionPackage.COMBINED_FRAGMENT__COVERED_PARTICIPANTS:
				return getCoveredParticipants();
			case InteractionPackage.COMBINED_FRAGMENT__OWNED_OPERANDS:
				return getOwnedOperands();
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
			case InteractionPackage.COMBINED_FRAGMENT__OPERATOR:
				setOperator((String)newValue);
				return;
			case InteractionPackage.COMBINED_FRAGMENT__COVERED_PARTICIPANTS:
				getCoveredParticipants().clear();
				getCoveredParticipants().addAll((Collection<? extends Participant>)newValue);
				return;
			case InteractionPackage.COMBINED_FRAGMENT__OWNED_OPERANDS:
				getOwnedOperands().clear();
				getOwnedOperands().addAll((Collection<? extends Operand>)newValue);
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
			case InteractionPackage.COMBINED_FRAGMENT__OPERATOR:
				setOperator(OPERATOR_EDEFAULT);
				return;
			case InteractionPackage.COMBINED_FRAGMENT__COVERED_PARTICIPANTS:
				getCoveredParticipants().clear();
				return;
			case InteractionPackage.COMBINED_FRAGMENT__OWNED_OPERANDS:
				getOwnedOperands().clear();
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
			case InteractionPackage.COMBINED_FRAGMENT__OPERATOR:
				return OPERATOR_EDEFAULT == null ? getOperator() != null : !OPERATOR_EDEFAULT.equals(getOperator());
			case InteractionPackage.COMBINED_FRAGMENT__COVERED_PARTICIPANTS:
				return !getCoveredParticipants().isEmpty();
			case InteractionPackage.COMBINED_FRAGMENT__OWNED_OPERANDS:
				return !getOwnedOperands().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CombinedFragmentImpl
