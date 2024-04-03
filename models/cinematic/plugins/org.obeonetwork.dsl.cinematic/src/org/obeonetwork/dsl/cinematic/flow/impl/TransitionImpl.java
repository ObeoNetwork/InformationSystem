/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.flow.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.dsl.cinematic.Event;
import org.obeonetwork.dsl.cinematic.flow.FlowPackage;
import org.obeonetwork.dsl.cinematic.flow.FlowState;
import org.obeonetwork.dsl.cinematic.flow.Transition;
import org.obeonetwork.dsl.cinematic.impl.NamedElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.impl.TransitionImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.impl.TransitionImpl#isModal <em>Modal</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.impl.TransitionImpl#getFrom <em>From</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.impl.TransitionImpl#getTo <em>To</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.impl.TransitionImpl#getOn <em>On</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionImpl extends NamedElementImpl implements Transition {
	/**
	 * The default value of the '{@link #getGuard() <em>Guard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuard()
	 * @generated
	 * @ordered
	 */
	protected static final String GUARD_EDEFAULT = null;
	/**
	 * The default value of the '{@link #isModal() <em>Modal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isModal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MODAL_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlowPackage.Literals.TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGuard() {
		return (String)eDynamicGet(FlowPackage.TRANSITION__GUARD, FlowPackage.Literals.TRANSITION__GUARD, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuard(String newGuard) {
		eDynamicSet(FlowPackage.TRANSITION__GUARD, FlowPackage.Literals.TRANSITION__GUARD, newGuard);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isModal() {
		return (Boolean)eDynamicGet(FlowPackage.TRANSITION__MODAL, FlowPackage.Literals.TRANSITION__MODAL, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModal(boolean newModal) {
		eDynamicSet(FlowPackage.TRANSITION__MODAL, FlowPackage.Literals.TRANSITION__MODAL, newModal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowState getTo() {
		return (FlowState)eDynamicGet(FlowPackage.TRANSITION__TO, FlowPackage.Literals.TRANSITION__TO, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowState basicGetTo() {
		return (FlowState)eDynamicGet(FlowPackage.TRANSITION__TO, FlowPackage.Literals.TRANSITION__TO, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTo(FlowState newTo) {
		eDynamicSet(FlowPackage.TRANSITION__TO, FlowPackage.Literals.TRANSITION__TO, newTo);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowState getFrom() {
		return (FlowState)eDynamicGet(FlowPackage.TRANSITION__FROM, FlowPackage.Literals.TRANSITION__FROM, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowState basicGetFrom() {
		return (FlowState)eDynamicGet(FlowPackage.TRANSITION__FROM, FlowPackage.Literals.TRANSITION__FROM, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrom(FlowState newFrom) {
		eDynamicSet(FlowPackage.TRANSITION__FROM, FlowPackage.Literals.TRANSITION__FROM, newFrom);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Event> getOn() {
		return (EList<Event>)eDynamicGet(FlowPackage.TRANSITION__ON, FlowPackage.Literals.TRANSITION__ON, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FlowPackage.TRANSITION__GUARD:
				return getGuard();
			case FlowPackage.TRANSITION__MODAL:
				return isModal();
			case FlowPackage.TRANSITION__FROM:
				if (resolve) return getFrom();
				return basicGetFrom();
			case FlowPackage.TRANSITION__TO:
				if (resolve) return getTo();
				return basicGetTo();
			case FlowPackage.TRANSITION__ON:
				return getOn();
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
			case FlowPackage.TRANSITION__GUARD:
				setGuard((String)newValue);
				return;
			case FlowPackage.TRANSITION__MODAL:
				setModal((Boolean)newValue);
				return;
			case FlowPackage.TRANSITION__FROM:
				setFrom((FlowState)newValue);
				return;
			case FlowPackage.TRANSITION__TO:
				setTo((FlowState)newValue);
				return;
			case FlowPackage.TRANSITION__ON:
				getOn().clear();
				getOn().addAll((Collection<? extends Event>)newValue);
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
			case FlowPackage.TRANSITION__GUARD:
				setGuard(GUARD_EDEFAULT);
				return;
			case FlowPackage.TRANSITION__MODAL:
				setModal(MODAL_EDEFAULT);
				return;
			case FlowPackage.TRANSITION__FROM:
				setFrom((FlowState)null);
				return;
			case FlowPackage.TRANSITION__TO:
				setTo((FlowState)null);
				return;
			case FlowPackage.TRANSITION__ON:
				getOn().clear();
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
			case FlowPackage.TRANSITION__GUARD:
				return GUARD_EDEFAULT == null ? getGuard() != null : !GUARD_EDEFAULT.equals(getGuard());
			case FlowPackage.TRANSITION__MODAL:
				return isModal() != MODAL_EDEFAULT;
			case FlowPackage.TRANSITION__FROM:
				return basicGetFrom() != null;
			case FlowPackage.TRANSITION__TO:
				return basicGetTo() != null;
			case FlowPackage.TRANSITION__ON:
				return !getOn().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TransitionImpl
