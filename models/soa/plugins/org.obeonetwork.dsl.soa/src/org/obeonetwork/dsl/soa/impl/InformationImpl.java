/**
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.soa.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl;
import org.obeonetwork.dsl.soa.Information;
import org.obeonetwork.dsl.soa.SoaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Information</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.InformationImpl#getApiVersion <em>Api Version</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.InformationImpl#getTermsOfService <em>Terms Of Service</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InformationImpl extends ObeoDSMObjectImpl implements Information {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2022 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getApiVersion() <em>Api Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApiVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String API_VERSION_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getTermsOfService() <em>Terms Of Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTermsOfService()
	 * @generated
	 * @ordered
	 */
	protected static final String TERMS_OF_SERVICE_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SoaPackage.Literals.INFORMATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getApiVersion() {
		return (String)eDynamicGet(SoaPackage.INFORMATION__API_VERSION, SoaPackage.Literals.INFORMATION__API_VERSION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApiVersion(String newApiVersion) {
		eDynamicSet(SoaPackage.INFORMATION__API_VERSION, SoaPackage.Literals.INFORMATION__API_VERSION, newApiVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTermsOfService() {
		return (String)eDynamicGet(SoaPackage.INFORMATION__TERMS_OF_SERVICE, SoaPackage.Literals.INFORMATION__TERMS_OF_SERVICE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTermsOfService(String newTermsOfService) {
		eDynamicSet(SoaPackage.INFORMATION__TERMS_OF_SERVICE, SoaPackage.Literals.INFORMATION__TERMS_OF_SERVICE, newTermsOfService);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SoaPackage.INFORMATION__API_VERSION:
				return getApiVersion();
			case SoaPackage.INFORMATION__TERMS_OF_SERVICE:
				return getTermsOfService();
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
			case SoaPackage.INFORMATION__API_VERSION:
				setApiVersion((String)newValue);
				return;
			case SoaPackage.INFORMATION__TERMS_OF_SERVICE:
				setTermsOfService((String)newValue);
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
			case SoaPackage.INFORMATION__API_VERSION:
				setApiVersion(API_VERSION_EDEFAULT);
				return;
			case SoaPackage.INFORMATION__TERMS_OF_SERVICE:
				setTermsOfService(TERMS_OF_SERVICE_EDEFAULT);
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
			case SoaPackage.INFORMATION__API_VERSION:
				return API_VERSION_EDEFAULT == null ? getApiVersion() != null : !API_VERSION_EDEFAULT.equals(getApiVersion());
			case SoaPackage.INFORMATION__TERMS_OF_SERVICE:
				return TERMS_OF_SERVICE_EDEFAULT == null ? getTermsOfService() != null : !TERMS_OF_SERVICE_EDEFAULT.equals(getTermsOfService());
		}
		return super.eIsSet(featureID);
	}

} //InformationImpl
