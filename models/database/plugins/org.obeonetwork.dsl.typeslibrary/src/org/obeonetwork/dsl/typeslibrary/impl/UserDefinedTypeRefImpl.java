/*******************************************************************************
 * Copyright (c) 2011, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.typeslibrary.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.obeonetwork.dsl.technicalid.Identifiable;
import org.obeonetwork.dsl.technicalid.TechnicalIDPackage;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;
import org.obeonetwork.dsl.typeslibrary.UserDefinedType;
import org.obeonetwork.dsl.typeslibrary.UserDefinedTypeRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Defined Type Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.typeslibrary.impl.UserDefinedTypeRefImpl#getTechnicalid <em>Technicalid</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.typeslibrary.impl.UserDefinedTypeRefImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UserDefinedTypeRefImpl extends TypeImpl implements UserDefinedTypeRef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2011, 2017 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getTechnicalid() <em>Technicalid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTechnicalid()
	 * @generated
	 * @ordered
	 */
	protected static final String TECHNICALID_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UserDefinedTypeRefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesLibraryPackage.Literals.USER_DEFINED_TYPE_REF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTechnicalid() {
		return (String)eDynamicGet(TypesLibraryPackage.USER_DEFINED_TYPE_REF__TECHNICALID, TechnicalIDPackage.Literals.IDENTIFIABLE__TECHNICALID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTechnicalid(String newTechnicalid) {
		eDynamicSet(TypesLibraryPackage.USER_DEFINED_TYPE_REF__TECHNICALID, TechnicalIDPackage.Literals.IDENTIFIABLE__TECHNICALID, newTechnicalid);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserDefinedType getType() {
		return (UserDefinedType)eDynamicGet(TypesLibraryPackage.USER_DEFINED_TYPE_REF__TYPE, TypesLibraryPackage.Literals.USER_DEFINED_TYPE_REF__TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserDefinedType basicGetType() {
		return (UserDefinedType)eDynamicGet(TypesLibraryPackage.USER_DEFINED_TYPE_REF__TYPE, TypesLibraryPackage.Literals.USER_DEFINED_TYPE_REF__TYPE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(UserDefinedType newType) {
		eDynamicSet(TypesLibraryPackage.USER_DEFINED_TYPE_REF__TYPE, TypesLibraryPackage.Literals.USER_DEFINED_TYPE_REF__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TypesLibraryPackage.USER_DEFINED_TYPE_REF__TECHNICALID:
				return getTechnicalid();
			case TypesLibraryPackage.USER_DEFINED_TYPE_REF__TYPE:
				if (resolve) return getType();
				return basicGetType();
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
			case TypesLibraryPackage.USER_DEFINED_TYPE_REF__TECHNICALID:
				setTechnicalid((String)newValue);
				return;
			case TypesLibraryPackage.USER_DEFINED_TYPE_REF__TYPE:
				setType((UserDefinedType)newValue);
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
			case TypesLibraryPackage.USER_DEFINED_TYPE_REF__TECHNICALID:
				setTechnicalid(TECHNICALID_EDEFAULT);
				return;
			case TypesLibraryPackage.USER_DEFINED_TYPE_REF__TYPE:
				setType((UserDefinedType)null);
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
			case TypesLibraryPackage.USER_DEFINED_TYPE_REF__TECHNICALID:
				return TECHNICALID_EDEFAULT == null ? getTechnicalid() != null : !TECHNICALID_EDEFAULT.equals(getTechnicalid());
			case TypesLibraryPackage.USER_DEFINED_TYPE_REF__TYPE:
				return basicGetType() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Identifiable.class) {
			switch (derivedFeatureID) {
				case TypesLibraryPackage.USER_DEFINED_TYPE_REF__TECHNICALID: return TechnicalIDPackage.IDENTIFIABLE__TECHNICALID;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Identifiable.class) {
			switch (baseFeatureID) {
				case TechnicalIDPackage.IDENTIFIABLE__TECHNICALID: return TypesLibraryPackage.USER_DEFINED_TYPE_REF__TECHNICALID;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //UserDefinedTypeRefImpl
