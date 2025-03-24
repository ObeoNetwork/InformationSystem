/**
 * Copyright (c) 2008, 2025 Obeo.
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
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl;
import org.obeonetwork.dsl.soa.ApiKeyLocation;
import org.obeonetwork.dsl.soa.Flow;
import org.obeonetwork.dsl.soa.HttpScheme;
import org.obeonetwork.dsl.soa.SecurityScheme;
import org.obeonetwork.dsl.soa.SecuritySchemeType;
import org.obeonetwork.dsl.soa.SoaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Security Scheme</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.SecuritySchemeImpl#getKey <em>Key</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.SecuritySchemeImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.SecuritySchemeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.SecuritySchemeImpl#getApiKeyLocation <em>Api Key Location</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.SecuritySchemeImpl#getConnectURL <em>Connect URL</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.SecuritySchemeImpl#getFlows <em>Flows</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.SecuritySchemeImpl#getHttpScheme <em>Http Scheme</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.SecuritySchemeImpl#getFormat <em>Format</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SecuritySchemeImpl extends ObeoDSMObjectImpl implements SecurityScheme {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2025 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected static final String KEY_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final SecuritySchemeType TYPE_EDEFAULT = SecuritySchemeType.API_KEY;

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
	 * The default value of the '{@link #getApiKeyLocation() <em>Api Key Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApiKeyLocation()
	 * @generated
	 * @ordered
	 */
	protected static final ApiKeyLocation API_KEY_LOCATION_EDEFAULT = ApiKeyLocation.QUERY;

	/**
	 * The default value of the '{@link #getConnectURL() <em>Connect URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectURL()
	 * @generated
	 * @ordered
	 */
	protected static final String CONNECT_URL_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getHttpScheme() <em>Http Scheme</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHttpScheme()
	 * @generated
	 * @ordered
	 */
	protected static final HttpScheme HTTP_SCHEME_EDEFAULT = HttpScheme.BASIC;

	/**
	 * The default value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String FORMAT_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SecuritySchemeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SoaPackage.Literals.SECURITY_SCHEME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getKey() {
		return (String)eDynamicGet(SoaPackage.SECURITY_SCHEME__KEY, SoaPackage.Literals.SECURITY_SCHEME__KEY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKey(String newKey) {
		eDynamicSet(SoaPackage.SECURITY_SCHEME__KEY, SoaPackage.Literals.SECURITY_SCHEME__KEY, newKey);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SecuritySchemeType getType() {
		return (SecuritySchemeType)eDynamicGet(SoaPackage.SECURITY_SCHEME__TYPE, SoaPackage.Literals.SECURITY_SCHEME__TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(SecuritySchemeType newType) {
		eDynamicSet(SoaPackage.SECURITY_SCHEME__TYPE, SoaPackage.Literals.SECURITY_SCHEME__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String)eDynamicGet(SoaPackage.SECURITY_SCHEME__NAME, SoaPackage.Literals.SECURITY_SCHEME__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eDynamicSet(SoaPackage.SECURITY_SCHEME__NAME, SoaPackage.Literals.SECURITY_SCHEME__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ApiKeyLocation getApiKeyLocation() {
		return (ApiKeyLocation)eDynamicGet(SoaPackage.SECURITY_SCHEME__API_KEY_LOCATION, SoaPackage.Literals.SECURITY_SCHEME__API_KEY_LOCATION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setApiKeyLocation(ApiKeyLocation newApiKeyLocation) {
		eDynamicSet(SoaPackage.SECURITY_SCHEME__API_KEY_LOCATION, SoaPackage.Literals.SECURITY_SCHEME__API_KEY_LOCATION, newApiKeyLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getConnectURL() {
		return (String)eDynamicGet(SoaPackage.SECURITY_SCHEME__CONNECT_URL, SoaPackage.Literals.SECURITY_SCHEME__CONNECT_URL, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConnectURL(String newConnectURL) {
		eDynamicSet(SoaPackage.SECURITY_SCHEME__CONNECT_URL, SoaPackage.Literals.SECURITY_SCHEME__CONNECT_URL, newConnectURL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Flow> getFlows() {
		return (EList<Flow>)eDynamicGet(SoaPackage.SECURITY_SCHEME__FLOWS, SoaPackage.Literals.SECURITY_SCHEME__FLOWS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HttpScheme getHttpScheme() {
		return (HttpScheme)eDynamicGet(SoaPackage.SECURITY_SCHEME__HTTP_SCHEME, SoaPackage.Literals.SECURITY_SCHEME__HTTP_SCHEME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHttpScheme(HttpScheme newHttpScheme) {
		eDynamicSet(SoaPackage.SECURITY_SCHEME__HTTP_SCHEME, SoaPackage.Literals.SECURITY_SCHEME__HTTP_SCHEME, newHttpScheme);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFormat() {
		return (String)eDynamicGet(SoaPackage.SECURITY_SCHEME__FORMAT, SoaPackage.Literals.SECURITY_SCHEME__FORMAT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFormat(String newFormat) {
		eDynamicSet(SoaPackage.SECURITY_SCHEME__FORMAT, SoaPackage.Literals.SECURITY_SCHEME__FORMAT, newFormat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SoaPackage.SECURITY_SCHEME__FLOWS:
				return ((InternalEList<?>)getFlows()).basicRemove(otherEnd, msgs);
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
			case SoaPackage.SECURITY_SCHEME__KEY:
				return getKey();
			case SoaPackage.SECURITY_SCHEME__TYPE:
				return getType();
			case SoaPackage.SECURITY_SCHEME__NAME:
				return getName();
			case SoaPackage.SECURITY_SCHEME__API_KEY_LOCATION:
				return getApiKeyLocation();
			case SoaPackage.SECURITY_SCHEME__CONNECT_URL:
				return getConnectURL();
			case SoaPackage.SECURITY_SCHEME__FLOWS:
				return getFlows();
			case SoaPackage.SECURITY_SCHEME__HTTP_SCHEME:
				return getHttpScheme();
			case SoaPackage.SECURITY_SCHEME__FORMAT:
				return getFormat();
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
			case SoaPackage.SECURITY_SCHEME__KEY:
				setKey((String)newValue);
				return;
			case SoaPackage.SECURITY_SCHEME__TYPE:
				setType((SecuritySchemeType)newValue);
				return;
			case SoaPackage.SECURITY_SCHEME__NAME:
				setName((String)newValue);
				return;
			case SoaPackage.SECURITY_SCHEME__API_KEY_LOCATION:
				setApiKeyLocation((ApiKeyLocation)newValue);
				return;
			case SoaPackage.SECURITY_SCHEME__CONNECT_URL:
				setConnectURL((String)newValue);
				return;
			case SoaPackage.SECURITY_SCHEME__FLOWS:
				getFlows().clear();
				getFlows().addAll((Collection<? extends Flow>)newValue);
				return;
			case SoaPackage.SECURITY_SCHEME__HTTP_SCHEME:
				setHttpScheme((HttpScheme)newValue);
				return;
			case SoaPackage.SECURITY_SCHEME__FORMAT:
				setFormat((String)newValue);
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
			case SoaPackage.SECURITY_SCHEME__KEY:
				setKey(KEY_EDEFAULT);
				return;
			case SoaPackage.SECURITY_SCHEME__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case SoaPackage.SECURITY_SCHEME__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SoaPackage.SECURITY_SCHEME__API_KEY_LOCATION:
				setApiKeyLocation(API_KEY_LOCATION_EDEFAULT);
				return;
			case SoaPackage.SECURITY_SCHEME__CONNECT_URL:
				setConnectURL(CONNECT_URL_EDEFAULT);
				return;
			case SoaPackage.SECURITY_SCHEME__FLOWS:
				getFlows().clear();
				return;
			case SoaPackage.SECURITY_SCHEME__HTTP_SCHEME:
				setHttpScheme(HTTP_SCHEME_EDEFAULT);
				return;
			case SoaPackage.SECURITY_SCHEME__FORMAT:
				setFormat(FORMAT_EDEFAULT);
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
			case SoaPackage.SECURITY_SCHEME__KEY:
				return KEY_EDEFAULT == null ? getKey() != null : !KEY_EDEFAULT.equals(getKey());
			case SoaPackage.SECURITY_SCHEME__TYPE:
				return getType() != TYPE_EDEFAULT;
			case SoaPackage.SECURITY_SCHEME__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case SoaPackage.SECURITY_SCHEME__API_KEY_LOCATION:
				return getApiKeyLocation() != API_KEY_LOCATION_EDEFAULT;
			case SoaPackage.SECURITY_SCHEME__CONNECT_URL:
				return CONNECT_URL_EDEFAULT == null ? getConnectURL() != null : !CONNECT_URL_EDEFAULT.equals(getConnectURL());
			case SoaPackage.SECURITY_SCHEME__FLOWS:
				return !getFlows().isEmpty();
			case SoaPackage.SECURITY_SCHEME__HTTP_SCHEME:
				return getHttpScheme() != HTTP_SCHEME_EDEFAULT;
			case SoaPackage.SECURITY_SCHEME__FORMAT:
				return FORMAT_EDEFAULT == null ? getFormat() != null : !FORMAT_EDEFAULT.equals(getFormat());
		}
		return super.eIsSet(featureID);
	}

} //SecuritySchemeImpl
