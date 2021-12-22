/**
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.soa.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.obeonetwork.dsl.soa.Scope;
import org.obeonetwork.dsl.soa.SecurityApplication;
import org.obeonetwork.dsl.soa.SecurityScheme;
import org.obeonetwork.dsl.soa.SoaPackage;

import org.obeonetwork.dsl.technicalid.impl.IdentifiableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Security Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.SecurityApplicationImpl#getSecurityScheme <em>Security Scheme</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.SecurityApplicationImpl#getScopes <em>Scopes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SecurityApplicationImpl extends IdentifiableImpl implements SecurityApplication {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2021 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SecurityApplicationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SoaPackage.Literals.SECURITY_APPLICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecurityScheme getSecurityScheme() {
		return (SecurityScheme)eDynamicGet(SoaPackage.SECURITY_APPLICATION__SECURITY_SCHEME, SoaPackage.Literals.SECURITY_APPLICATION__SECURITY_SCHEME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecurityScheme basicGetSecurityScheme() {
		return (SecurityScheme)eDynamicGet(SoaPackage.SECURITY_APPLICATION__SECURITY_SCHEME, SoaPackage.Literals.SECURITY_APPLICATION__SECURITY_SCHEME, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecurityScheme(SecurityScheme newSecurityScheme) {
		eDynamicSet(SoaPackage.SECURITY_APPLICATION__SECURITY_SCHEME, SoaPackage.Literals.SECURITY_APPLICATION__SECURITY_SCHEME, newSecurityScheme);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Scope> getScopes() {
		return (EList<Scope>)eDynamicGet(SoaPackage.SECURITY_APPLICATION__SCOPES, SoaPackage.Literals.SECURITY_APPLICATION__SCOPES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SoaPackage.SECURITY_APPLICATION__SECURITY_SCHEME:
				if (resolve) return getSecurityScheme();
				return basicGetSecurityScheme();
			case SoaPackage.SECURITY_APPLICATION__SCOPES:
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
			case SoaPackage.SECURITY_APPLICATION__SECURITY_SCHEME:
				setSecurityScheme((SecurityScheme)newValue);
				return;
			case SoaPackage.SECURITY_APPLICATION__SCOPES:
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
			case SoaPackage.SECURITY_APPLICATION__SECURITY_SCHEME:
				setSecurityScheme((SecurityScheme)null);
				return;
			case SoaPackage.SECURITY_APPLICATION__SCOPES:
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
			case SoaPackage.SECURITY_APPLICATION__SECURITY_SCHEME:
				return basicGetSecurityScheme() != null;
			case SoaPackage.SECURITY_APPLICATION__SCOPES:
				return !getScopes().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SecurityApplicationImpl
