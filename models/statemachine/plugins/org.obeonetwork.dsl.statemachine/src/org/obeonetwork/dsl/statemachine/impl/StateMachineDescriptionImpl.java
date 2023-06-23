/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.statemachine.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.statemachine.AbstractState;
import org.obeonetwork.dsl.statemachine.StateMachineDescription;
import org.obeonetwork.dsl.statemachine.StateMachinePackage;
import org.obeonetwork.dsl.statemachine.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.statemachine.impl.StateMachineDescriptionImpl#getStates <em>States</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.statemachine.impl.StateMachineDescriptionImpl#getTransitions <em>Transitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class StateMachineDescriptionImpl extends NamedElementImpl implements StateMachineDescription {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateMachineDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StateMachinePackage.Literals.STATE_MACHINE_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AbstractState> getStates() {
		return (EList<AbstractState>)eDynamicGet(StateMachinePackage.STATE_MACHINE_DESCRIPTION__STATES, StateMachinePackage.Literals.STATE_MACHINE_DESCRIPTION__STATES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Transition> getTransitions() {
		return (EList<Transition>)eDynamicGet(StateMachinePackage.STATE_MACHINE_DESCRIPTION__TRANSITIONS, StateMachinePackage.Literals.STATE_MACHINE_DESCRIPTION__TRANSITIONS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StateMachinePackage.STATE_MACHINE_DESCRIPTION__STATES:
				return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
			case StateMachinePackage.STATE_MACHINE_DESCRIPTION__TRANSITIONS:
				return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
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
			case StateMachinePackage.STATE_MACHINE_DESCRIPTION__STATES:
				return getStates();
			case StateMachinePackage.STATE_MACHINE_DESCRIPTION__TRANSITIONS:
				return getTransitions();
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
			case StateMachinePackage.STATE_MACHINE_DESCRIPTION__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends AbstractState>)newValue);
				return;
			case StateMachinePackage.STATE_MACHINE_DESCRIPTION__TRANSITIONS:
				getTransitions().clear();
				getTransitions().addAll((Collection<? extends Transition>)newValue);
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
			case StateMachinePackage.STATE_MACHINE_DESCRIPTION__STATES:
				getStates().clear();
				return;
			case StateMachinePackage.STATE_MACHINE_DESCRIPTION__TRANSITIONS:
				getTransitions().clear();
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
			case StateMachinePackage.STATE_MACHINE_DESCRIPTION__STATES:
				return !getStates().isEmpty();
			case StateMachinePackage.STATE_MACHINE_DESCRIPTION__TRANSITIONS:
				return !getTransitions().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StateMachineDescriptionImpl
