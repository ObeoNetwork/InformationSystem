/**
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.typeslibrary.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.obeonetwork.dsl.technicalid.Identifiable;
import org.obeonetwork.dsl.technicalid.TechnicalIDPackage;
import org.obeonetwork.dsl.typeslibrary.ComplexNamedType;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;
import org.obeonetwork.dsl.typeslibrary.UserDefinedType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Named Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.typeslibrary.impl.ComplexNamedTypeImpl#getTechnicalid <em>Technicalid</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.typeslibrary.impl.ComplexNamedTypeImpl#getTypes <em>Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComplexNamedTypeImpl extends UserDefinedTypeImpl implements ComplexNamedType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2011 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

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
	protected ComplexNamedTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesLibraryPackage.Literals.COMPLEX_NAMED_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTechnicalid() {
		return (String)eDynamicGet(TypesLibraryPackage.COMPLEX_NAMED_TYPE__TECHNICALID, TechnicalIDPackage.Literals.IDENTIFIABLE__TECHNICALID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTechnicalid(String newTechnicalid) {
		eDynamicSet(TypesLibraryPackage.COMPLEX_NAMED_TYPE__TECHNICALID, TechnicalIDPackage.Literals.IDENTIFIABLE__TECHNICALID, newTechnicalid);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<UserDefinedType> getTypes() {
		return (EList<UserDefinedType>)eDynamicGet(TypesLibraryPackage.COMPLEX_NAMED_TYPE__TYPES, TypesLibraryPackage.Literals.COMPLEX_NAMED_TYPE__TYPES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesLibraryPackage.COMPLEX_NAMED_TYPE__TYPES:
				return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
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
			case TypesLibraryPackage.COMPLEX_NAMED_TYPE__TECHNICALID:
				return getTechnicalid();
			case TypesLibraryPackage.COMPLEX_NAMED_TYPE__TYPES:
				return getTypes();
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
			case TypesLibraryPackage.COMPLEX_NAMED_TYPE__TECHNICALID:
				setTechnicalid((String)newValue);
				return;
			case TypesLibraryPackage.COMPLEX_NAMED_TYPE__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection<? extends UserDefinedType>)newValue);
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
			case TypesLibraryPackage.COMPLEX_NAMED_TYPE__TECHNICALID:
				setTechnicalid(TECHNICALID_EDEFAULT);
				return;
			case TypesLibraryPackage.COMPLEX_NAMED_TYPE__TYPES:
				getTypes().clear();
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
			case TypesLibraryPackage.COMPLEX_NAMED_TYPE__TECHNICALID:
				return TECHNICALID_EDEFAULT == null ? getTechnicalid() != null : !TECHNICALID_EDEFAULT.equals(getTechnicalid());
			case TypesLibraryPackage.COMPLEX_NAMED_TYPE__TYPES:
				return !getTypes().isEmpty();
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
				case TypesLibraryPackage.COMPLEX_NAMED_TYPE__TECHNICALID: return TechnicalIDPackage.IDENTIFIABLE__TECHNICALID;
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
				case TechnicalIDPackage.IDENTIFIABLE__TECHNICALID: return TypesLibraryPackage.COMPLEX_NAMED_TYPE__TECHNICALID;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //ComplexNamedTypeImpl
