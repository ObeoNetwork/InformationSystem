/**
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.soa.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl;

import org.obeonetwork.dsl.soa.Flow;
import org.obeonetwork.dsl.soa.FlowType;
import org.obeonetwork.dsl.soa.Operation;
import org.obeonetwork.dsl.soa.Parameter;
import org.obeonetwork.dsl.soa.Scope;
import org.obeonetwork.dsl.soa.SoaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.FlowImpl#getFlowType <em>Flow Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.FlowImpl#getAuthorizationURL <em>Authorization URL</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.FlowImpl#getTokenURL <em>Token URL</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.FlowImpl#getRefreshURL <em>Refresh URL</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.FlowImpl#getScopes <em>Scopes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FlowImpl extends ObeoDSMObjectImpl implements Flow {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2024 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getFlowType() <em>Flow Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlowType()
	 * @generated
	 * @ordered
	 */
	protected static final FlowType FLOW_TYPE_EDEFAULT = FlowType.IMPLICIT;

	/**
	 * The default value of the '{@link #getAuthorizationURL() <em>Authorization URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthorizationURL()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTHORIZATION_URL_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getTokenURL() <em>Token URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTokenURL()
	 * @generated
	 * @ordered
	 */
	protected static final String TOKEN_URL_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getRefreshURL() <em>Refresh URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefreshURL()
	 * @generated
	 * @ordered
	 */
	protected static final String REFRESH_URL_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SoaPackage.Literals.FLOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FlowType getFlowType() {
		return (FlowType)eDynamicGet(SoaPackage.FLOW__FLOW_TYPE, SoaPackage.Literals.FLOW__FLOW_TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlowType(FlowType newFlowType) {
		eDynamicSet(SoaPackage.FLOW__FLOW_TYPE, SoaPackage.Literals.FLOW__FLOW_TYPE, newFlowType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAuthorizationURL() {
		return (String)eDynamicGet(SoaPackage.FLOW__AUTHORIZATION_URL, SoaPackage.Literals.FLOW__AUTHORIZATION_URL, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAuthorizationURL(String newAuthorizationURL) {
		eDynamicSet(SoaPackage.FLOW__AUTHORIZATION_URL, SoaPackage.Literals.FLOW__AUTHORIZATION_URL, newAuthorizationURL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTokenURL() {
		return (String)eDynamicGet(SoaPackage.FLOW__TOKEN_URL, SoaPackage.Literals.FLOW__TOKEN_URL, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTokenURL(String newTokenURL) {
		eDynamicSet(SoaPackage.FLOW__TOKEN_URL, SoaPackage.Literals.FLOW__TOKEN_URL, newTokenURL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRefreshURL() {
		return (String)eDynamicGet(SoaPackage.FLOW__REFRESH_URL, SoaPackage.Literals.FLOW__REFRESH_URL, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRefreshURL(String newRefreshURL) {
		eDynamicSet(SoaPackage.FLOW__REFRESH_URL, SoaPackage.Literals.FLOW__REFRESH_URL, newRefreshURL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Scope> getScopes() {
		return (EList<Scope>)eDynamicGet(SoaPackage.FLOW__SCOPES, SoaPackage.Literals.FLOW__SCOPES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SoaPackage.FLOW__SCOPES:
				return ((InternalEList<?>)getScopes()).basicRemove(otherEnd, msgs);
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
			case SoaPackage.FLOW__FLOW_TYPE:
				return getFlowType();
			case SoaPackage.FLOW__AUTHORIZATION_URL:
				return getAuthorizationURL();
			case SoaPackage.FLOW__TOKEN_URL:
				return getTokenURL();
			case SoaPackage.FLOW__REFRESH_URL:
				return getRefreshURL();
			case SoaPackage.FLOW__SCOPES:
				return getScopes();
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
			case SoaPackage.FLOW__FLOW_TYPE:
				setFlowType((FlowType)newValue);
				return;
			case SoaPackage.FLOW__AUTHORIZATION_URL:
				setAuthorizationURL((String)newValue);
				return;
			case SoaPackage.FLOW__TOKEN_URL:
				setTokenURL((String)newValue);
				return;
			case SoaPackage.FLOW__REFRESH_URL:
				setRefreshURL((String)newValue);
				return;
			case SoaPackage.FLOW__SCOPES:
				getScopes().clear();
				getScopes().addAll((Collection<? extends Scope>)newValue);
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
			case SoaPackage.FLOW__FLOW_TYPE:
				setFlowType(FLOW_TYPE_EDEFAULT);
				return;
			case SoaPackage.FLOW__AUTHORIZATION_URL:
				setAuthorizationURL(AUTHORIZATION_URL_EDEFAULT);
				return;
			case SoaPackage.FLOW__TOKEN_URL:
				setTokenURL(TOKEN_URL_EDEFAULT);
				return;
			case SoaPackage.FLOW__REFRESH_URL:
				setRefreshURL(REFRESH_URL_EDEFAULT);
				return;
			case SoaPackage.FLOW__SCOPES:
				getScopes().clear();
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
			case SoaPackage.FLOW__FLOW_TYPE:
				return getFlowType() != FLOW_TYPE_EDEFAULT;
			case SoaPackage.FLOW__AUTHORIZATION_URL:
				return AUTHORIZATION_URL_EDEFAULT == null ? getAuthorizationURL() != null : !AUTHORIZATION_URL_EDEFAULT.equals(getAuthorizationURL());
			case SoaPackage.FLOW__TOKEN_URL:
				return TOKEN_URL_EDEFAULT == null ? getTokenURL() != null : !TOKEN_URL_EDEFAULT.equals(getTokenURL());
			case SoaPackage.FLOW__REFRESH_URL:
				return REFRESH_URL_EDEFAULT == null ? getRefreshURL() != null : !REFRESH_URL_EDEFAULT.equals(getRefreshURL());
			case SoaPackage.FLOW__SCOPES:
				return !getScopes().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FlowImpl
