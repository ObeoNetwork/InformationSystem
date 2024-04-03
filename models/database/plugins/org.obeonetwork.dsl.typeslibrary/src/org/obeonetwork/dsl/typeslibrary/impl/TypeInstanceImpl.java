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
package org.obeonetwork.dsl.typeslibrary.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.obeonetwork.dsl.technicalid.Identifiable;
import org.obeonetwork.dsl.technicalid.TechnicalIDPackage;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.typeslibrary.impl.TypeInstanceImpl#getTechnicalid <em>Technicalid</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.typeslibrary.impl.TypeInstanceImpl#getNativeType <em>Native Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.typeslibrary.impl.TypeInstanceImpl#getLength <em>Length</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.typeslibrary.impl.TypeInstanceImpl#getPrecision <em>Precision</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.typeslibrary.impl.TypeInstanceImpl#getLiterals <em>Literals</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeInstanceImpl extends TypeImpl implements TypeInstance {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2024 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v2.0\r\nwhich accompanies this distribution, and is available at\r\nhttps://www.eclipse.org/legal/epl-2.0/\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

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
	 * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected static final Integer LENGTH_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getPrecision() <em>Precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrecision()
	 * @generated
	 * @ordered
	 */
	protected static final Integer PRECISION_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesLibraryPackage.Literals.TYPE_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTechnicalid() {
		return (String)eDynamicGet(TypesLibraryPackage.TYPE_INSTANCE__TECHNICALID, TechnicalIDPackage.Literals.IDENTIFIABLE__TECHNICALID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTechnicalid(String newTechnicalid) {
		eDynamicSet(TypesLibraryPackage.TYPE_INSTANCE__TECHNICALID, TechnicalIDPackage.Literals.IDENTIFIABLE__TECHNICALID, newTechnicalid);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NativeType getNativeType() {
		return (NativeType)eDynamicGet(TypesLibraryPackage.TYPE_INSTANCE__NATIVE_TYPE, TypesLibraryPackage.Literals.TYPE_INSTANCE__NATIVE_TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NativeType basicGetNativeType() {
		return (NativeType)eDynamicGet(TypesLibraryPackage.TYPE_INSTANCE__NATIVE_TYPE, TypesLibraryPackage.Literals.TYPE_INSTANCE__NATIVE_TYPE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNativeType(NativeType newNativeType) {
		eDynamicSet(TypesLibraryPackage.TYPE_INSTANCE__NATIVE_TYPE, TypesLibraryPackage.Literals.TYPE_INSTANCE__NATIVE_TYPE, newNativeType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getLength() {
		return (Integer)eDynamicGet(TypesLibraryPackage.TYPE_INSTANCE__LENGTH, TypesLibraryPackage.Literals.TYPE_INSTANCE__LENGTH, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLength(Integer newLength) {
		eDynamicSet(TypesLibraryPackage.TYPE_INSTANCE__LENGTH, TypesLibraryPackage.Literals.TYPE_INSTANCE__LENGTH, newLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getPrecision() {
		return (Integer)eDynamicGet(TypesLibraryPackage.TYPE_INSTANCE__PRECISION, TypesLibraryPackage.Literals.TYPE_INSTANCE__PRECISION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrecision(Integer newPrecision) {
		eDynamicSet(TypesLibraryPackage.TYPE_INSTANCE__PRECISION, TypesLibraryPackage.Literals.TYPE_INSTANCE__PRECISION, newPrecision);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getLiterals() {
		return (EList<String>)eDynamicGet(TypesLibraryPackage.TYPE_INSTANCE__LITERALS, TypesLibraryPackage.Literals.TYPE_INSTANCE__LITERALS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TypesLibraryPackage.TYPE_INSTANCE__TECHNICALID:
				return getTechnicalid();
			case TypesLibraryPackage.TYPE_INSTANCE__NATIVE_TYPE:
				if (resolve) return getNativeType();
				return basicGetNativeType();
			case TypesLibraryPackage.TYPE_INSTANCE__LENGTH:
				return getLength();
			case TypesLibraryPackage.TYPE_INSTANCE__PRECISION:
				return getPrecision();
			case TypesLibraryPackage.TYPE_INSTANCE__LITERALS:
				return getLiterals();
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
			case TypesLibraryPackage.TYPE_INSTANCE__TECHNICALID:
				setTechnicalid((String)newValue);
				return;
			case TypesLibraryPackage.TYPE_INSTANCE__NATIVE_TYPE:
				setNativeType((NativeType)newValue);
				return;
			case TypesLibraryPackage.TYPE_INSTANCE__LENGTH:
				setLength((Integer)newValue);
				return;
			case TypesLibraryPackage.TYPE_INSTANCE__PRECISION:
				setPrecision((Integer)newValue);
				return;
			case TypesLibraryPackage.TYPE_INSTANCE__LITERALS:
				getLiterals().clear();
				getLiterals().addAll((Collection<? extends String>)newValue);
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
			case TypesLibraryPackage.TYPE_INSTANCE__TECHNICALID:
				setTechnicalid(TECHNICALID_EDEFAULT);
				return;
			case TypesLibraryPackage.TYPE_INSTANCE__NATIVE_TYPE:
				setNativeType((NativeType)null);
				return;
			case TypesLibraryPackage.TYPE_INSTANCE__LENGTH:
				setLength(LENGTH_EDEFAULT);
				return;
			case TypesLibraryPackage.TYPE_INSTANCE__PRECISION:
				setPrecision(PRECISION_EDEFAULT);
				return;
			case TypesLibraryPackage.TYPE_INSTANCE__LITERALS:
				getLiterals().clear();
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
			case TypesLibraryPackage.TYPE_INSTANCE__TECHNICALID:
				return TECHNICALID_EDEFAULT == null ? getTechnicalid() != null : !TECHNICALID_EDEFAULT.equals(getTechnicalid());
			case TypesLibraryPackage.TYPE_INSTANCE__NATIVE_TYPE:
				return basicGetNativeType() != null;
			case TypesLibraryPackage.TYPE_INSTANCE__LENGTH:
				return LENGTH_EDEFAULT == null ? getLength() != null : !LENGTH_EDEFAULT.equals(getLength());
			case TypesLibraryPackage.TYPE_INSTANCE__PRECISION:
				return PRECISION_EDEFAULT == null ? getPrecision() != null : !PRECISION_EDEFAULT.equals(getPrecision());
			case TypesLibraryPackage.TYPE_INSTANCE__LITERALS:
				return !getLiterals().isEmpty();
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
				case TypesLibraryPackage.TYPE_INSTANCE__TECHNICALID: return TechnicalIDPackage.IDENTIFIABLE__TECHNICALID;
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
				case TechnicalIDPackage.IDENTIFIABLE__TECHNICALID: return TypesLibraryPackage.TYPE_INSTANCE__TECHNICALID;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //TypeInstanceImpl
