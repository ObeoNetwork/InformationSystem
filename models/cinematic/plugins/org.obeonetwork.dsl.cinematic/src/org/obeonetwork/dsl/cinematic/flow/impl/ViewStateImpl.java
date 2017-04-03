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

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.dsl.cinematic.flow.FlowPackage;
import org.obeonetwork.dsl.cinematic.flow.ViewState;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.impl.ViewStateImpl#isNewInstance <em>New Instance</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.impl.ViewStateImpl#isRefresh <em>Refresh</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.flow.impl.ViewStateImpl#getViewContainers <em>View Containers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ViewStateImpl extends NamedFlowStateImpl implements ViewState {
	/**
	 * The default value of the '{@link #isNewInstance() <em>New Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNewInstance()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NEW_INSTANCE_EDEFAULT = false;
	/**
	 * The default value of the '{@link #isRefresh() <em>Refresh</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRefresh()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REFRESH_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlowPackage.Literals.VIEW_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNewInstance() {
		return (Boolean)eDynamicGet(FlowPackage.VIEW_STATE__NEW_INSTANCE, FlowPackage.Literals.VIEW_STATE__NEW_INSTANCE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewInstance(boolean newNewInstance) {
		eDynamicSet(FlowPackage.VIEW_STATE__NEW_INSTANCE, FlowPackage.Literals.VIEW_STATE__NEW_INSTANCE, newNewInstance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRefresh() {
		return (Boolean)eDynamicGet(FlowPackage.VIEW_STATE__REFRESH, FlowPackage.Literals.VIEW_STATE__REFRESH, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefresh(boolean newRefresh) {
		eDynamicSet(FlowPackage.VIEW_STATE__REFRESH, FlowPackage.Literals.VIEW_STATE__REFRESH, newRefresh);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ViewContainer> getViewContainers() {
		return (EList<ViewContainer>)eDynamicGet(FlowPackage.VIEW_STATE__VIEW_CONTAINERS, FlowPackage.Literals.VIEW_STATE__VIEW_CONTAINERS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FlowPackage.VIEW_STATE__NEW_INSTANCE:
				return isNewInstance();
			case FlowPackage.VIEW_STATE__REFRESH:
				return isRefresh();
			case FlowPackage.VIEW_STATE__VIEW_CONTAINERS:
				return getViewContainers();
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
			case FlowPackage.VIEW_STATE__NEW_INSTANCE:
				setNewInstance((Boolean)newValue);
				return;
			case FlowPackage.VIEW_STATE__REFRESH:
				setRefresh((Boolean)newValue);
				return;
			case FlowPackage.VIEW_STATE__VIEW_CONTAINERS:
				getViewContainers().clear();
				getViewContainers().addAll((Collection<? extends ViewContainer>)newValue);
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
			case FlowPackage.VIEW_STATE__NEW_INSTANCE:
				setNewInstance(NEW_INSTANCE_EDEFAULT);
				return;
			case FlowPackage.VIEW_STATE__REFRESH:
				setRefresh(REFRESH_EDEFAULT);
				return;
			case FlowPackage.VIEW_STATE__VIEW_CONTAINERS:
				getViewContainers().clear();
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
			case FlowPackage.VIEW_STATE__NEW_INSTANCE:
				return isNewInstance() != NEW_INSTANCE_EDEFAULT;
			case FlowPackage.VIEW_STATE__REFRESH:
				return isRefresh() != REFRESH_EDEFAULT;
			case FlowPackage.VIEW_STATE__VIEW_CONTAINERS:
				return !getViewContainers().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ViewStateImpl
