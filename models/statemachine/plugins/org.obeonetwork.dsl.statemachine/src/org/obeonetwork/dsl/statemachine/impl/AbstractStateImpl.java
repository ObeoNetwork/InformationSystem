/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl;
import org.obeonetwork.dsl.statemachine.AbstractState;
import org.obeonetwork.dsl.statemachine.StateMachinePackage;
import org.obeonetwork.dsl.statemachine.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.statemachine.impl.AbstractStateImpl#getIncomingTransitions <em>Incoming Transitions</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.statemachine.impl.AbstractStateImpl#getOutcomingTransitions <em>Outcoming Transitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractStateImpl extends ObeoDSMObjectImpl implements AbstractState {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StateMachinePackage.Literals.ABSTRACT_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Transition> getIncomingTransitions() {
		return (EList<Transition>)eDynamicGet(StateMachinePackage.ABSTRACT_STATE__INCOMING_TRANSITIONS, StateMachinePackage.Literals.ABSTRACT_STATE__INCOMING_TRANSITIONS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Transition> getOutcomingTransitions() {
		return (EList<Transition>)eDynamicGet(StateMachinePackage.ABSTRACT_STATE__OUTCOMING_TRANSITIONS, StateMachinePackage.Literals.ABSTRACT_STATE__OUTCOMING_TRANSITIONS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StateMachinePackage.ABSTRACT_STATE__INCOMING_TRANSITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingTransitions()).basicAdd(otherEnd, msgs);
			case StateMachinePackage.ABSTRACT_STATE__OUTCOMING_TRANSITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutcomingTransitions()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StateMachinePackage.ABSTRACT_STATE__INCOMING_TRANSITIONS:
				return ((InternalEList<?>)getIncomingTransitions()).basicRemove(otherEnd, msgs);
			case StateMachinePackage.ABSTRACT_STATE__OUTCOMING_TRANSITIONS:
				return ((InternalEList<?>)getOutcomingTransitions()).basicRemove(otherEnd, msgs);
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
			case StateMachinePackage.ABSTRACT_STATE__INCOMING_TRANSITIONS:
				return getIncomingTransitions();
			case StateMachinePackage.ABSTRACT_STATE__OUTCOMING_TRANSITIONS:
				return getOutcomingTransitions();
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
			case StateMachinePackage.ABSTRACT_STATE__INCOMING_TRANSITIONS:
				getIncomingTransitions().clear();
				getIncomingTransitions().addAll((Collection<? extends Transition>)newValue);
				return;
			case StateMachinePackage.ABSTRACT_STATE__OUTCOMING_TRANSITIONS:
				getOutcomingTransitions().clear();
				getOutcomingTransitions().addAll((Collection<? extends Transition>)newValue);
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
			case StateMachinePackage.ABSTRACT_STATE__INCOMING_TRANSITIONS:
				getIncomingTransitions().clear();
				return;
			case StateMachinePackage.ABSTRACT_STATE__OUTCOMING_TRANSITIONS:
				getOutcomingTransitions().clear();
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
			case StateMachinePackage.ABSTRACT_STATE__INCOMING_TRANSITIONS:
				return !getIncomingTransitions().isEmpty();
			case StateMachinePackage.ABSTRACT_STATE__OUTCOMING_TRANSITIONS:
				return !getOutcomingTransitions().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AbstractStateImpl
