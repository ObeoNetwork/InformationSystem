/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.flow.impl;

import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.flow.FlowPackage;
import org.obeonetwork.dsl.cinematic.flow.SubflowState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subflow State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.impl.SubflowStateImpl#getSubflow <em>Subflow</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.impl.SubflowStateImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubflowStateImpl extends FlowStateImpl implements SubflowState {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubflowStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlowPackage.Literals.SUBFLOW_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Flow getSubflow() {
		return (Flow)eDynamicGet(FlowPackage.SUBFLOW_STATE__SUBFLOW, FlowPackage.Literals.SUBFLOW_STATE__SUBFLOW, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Flow basicGetSubflow() {
		return (Flow)eDynamicGet(FlowPackage.SUBFLOW_STATE__SUBFLOW, FlowPackage.Literals.SUBFLOW_STATE__SUBFLOW, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubflow(Flow newSubflow) {
		eDynamicSet(FlowPackage.SUBFLOW_STATE__SUBFLOW, FlowPackage.Literals.SUBFLOW_STATE__SUBFLOW, newSubflow);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eDynamicGet(FlowPackage.SUBFLOW_STATE__NAME, FlowPackage.Literals.SUBFLOW_STATE__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FlowPackage.SUBFLOW_STATE__SUBFLOW:
				if (resolve) return getSubflow();
				return basicGetSubflow();
			case FlowPackage.SUBFLOW_STATE__NAME:
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FlowPackage.SUBFLOW_STATE__SUBFLOW:
				setSubflow((Flow)newValue);
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
			case FlowPackage.SUBFLOW_STATE__SUBFLOW:
				setSubflow((Flow)null);
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
			case FlowPackage.SUBFLOW_STATE__SUBFLOW:
				return basicGetSubflow() != null;
			case FlowPackage.SUBFLOW_STATE__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
		}
		return super.eIsSet(featureID);
	}

} //SubflowStateImpl
