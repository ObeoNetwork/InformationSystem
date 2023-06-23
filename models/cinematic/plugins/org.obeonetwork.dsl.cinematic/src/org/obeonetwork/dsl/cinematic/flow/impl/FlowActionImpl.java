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
package org.obeonetwork.dsl.cinematic.flow.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.dsl.cinematic.flow.FlowAction;
import org.obeonetwork.dsl.cinematic.flow.FlowPackage;
import org.obeonetwork.dsl.cinematic.impl.NamedElementImpl;
import org.obeonetwork.dsl.cinematic.view.ViewAction;
import org.obeonetwork.dsl.environment.Action;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.impl.FlowActionImpl#getCalls <em>Calls</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.impl.FlowActionImpl#getOperations <em>Operations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FlowActionImpl extends NamedElementImpl implements FlowAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlowActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlowPackage.Literals.FLOW_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ViewAction> getCalls() {
		return (EList<ViewAction>)eDynamicGet(FlowPackage.FLOW_ACTION__CALLS, FlowPackage.Literals.FLOW_ACTION__CALLS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Action> getOperations() {
		return (EList<Action>)eDynamicGet(FlowPackage.FLOW_ACTION__OPERATIONS, FlowPackage.Literals.FLOW_ACTION__OPERATIONS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FlowPackage.FLOW_ACTION__CALLS:
				return getCalls();
			case FlowPackage.FLOW_ACTION__OPERATIONS:
				return getOperations();
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
			case FlowPackage.FLOW_ACTION__CALLS:
				getCalls().clear();
				getCalls().addAll((Collection<? extends ViewAction>)newValue);
				return;
			case FlowPackage.FLOW_ACTION__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends Action>)newValue);
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
			case FlowPackage.FLOW_ACTION__CALLS:
				getCalls().clear();
				return;
			case FlowPackage.FLOW_ACTION__OPERATIONS:
				getOperations().clear();
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
			case FlowPackage.FLOW_ACTION__CALLS:
				return !getCalls().isEmpty();
			case FlowPackage.FLOW_ACTION__OPERATIONS:
				return !getOperations().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FlowActionImpl
