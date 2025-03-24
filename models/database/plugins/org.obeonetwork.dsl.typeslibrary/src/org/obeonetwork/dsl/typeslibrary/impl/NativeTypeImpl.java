/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
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
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.obeonetwork.dsl.technicalid.impl.IdentifiableImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.NativeTypeKind;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Native Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.typeslibrary.impl.NativeTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.typeslibrary.impl.NativeTypeImpl#getSpec <em>Spec</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.typeslibrary.impl.NativeTypeImpl#getMapsTo <em>Maps To</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NativeTypeImpl extends IdentifiableImpl implements NativeType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2025 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v2.0\r\nwhich accompanies this distribution, and is available at\r\nhttps://www.eclipse.org/legal/epl-2.0/\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

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
	 * The default value of the '{@link #getSpec() <em>Spec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpec()
	 * @generated
	 * @ordered
	 */
	protected static final NativeTypeKind SPEC_EDEFAULT = NativeTypeKind.SIMPLE;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NativeTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesLibraryPackage.Literals.NATIVE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eDynamicGet(TypesLibraryPackage.NATIVE_TYPE__NAME, TypesLibraryPackage.Literals.NATIVE_TYPE__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eDynamicSet(TypesLibraryPackage.NATIVE_TYPE__NAME, TypesLibraryPackage.Literals.NATIVE_TYPE__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NativeTypeKind getSpec() {
		return (NativeTypeKind)eDynamicGet(TypesLibraryPackage.NATIVE_TYPE__SPEC, TypesLibraryPackage.Literals.NATIVE_TYPE__SPEC, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpec(NativeTypeKind newSpec) {
		eDynamicSet(TypesLibraryPackage.NATIVE_TYPE__SPEC, TypesLibraryPackage.Literals.NATIVE_TYPE__SPEC, newSpec);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NativeType getMapsTo() {
		return (NativeType)eDynamicGet(TypesLibraryPackage.NATIVE_TYPE__MAPS_TO, TypesLibraryPackage.Literals.NATIVE_TYPE__MAPS_TO, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NativeType basicGetMapsTo() {
		return (NativeType)eDynamicGet(TypesLibraryPackage.NATIVE_TYPE__MAPS_TO, TypesLibraryPackage.Literals.NATIVE_TYPE__MAPS_TO, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapsTo(NativeType newMapsTo) {
		eDynamicSet(TypesLibraryPackage.NATIVE_TYPE__MAPS_TO, TypesLibraryPackage.Literals.NATIVE_TYPE__MAPS_TO, newMapsTo);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TypesLibraryPackage.NATIVE_TYPE__NAME:
				return getName();
			case TypesLibraryPackage.NATIVE_TYPE__SPEC:
				return getSpec();
			case TypesLibraryPackage.NATIVE_TYPE__MAPS_TO:
				if (resolve) return getMapsTo();
				return basicGetMapsTo();
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
			case TypesLibraryPackage.NATIVE_TYPE__NAME:
				setName((String)newValue);
				return;
			case TypesLibraryPackage.NATIVE_TYPE__SPEC:
				setSpec((NativeTypeKind)newValue);
				return;
			case TypesLibraryPackage.NATIVE_TYPE__MAPS_TO:
				setMapsTo((NativeType)newValue);
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
			case TypesLibraryPackage.NATIVE_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TypesLibraryPackage.NATIVE_TYPE__SPEC:
				setSpec(SPEC_EDEFAULT);
				return;
			case TypesLibraryPackage.NATIVE_TYPE__MAPS_TO:
				setMapsTo((NativeType)null);
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
			case TypesLibraryPackage.NATIVE_TYPE__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case TypesLibraryPackage.NATIVE_TYPE__SPEC:
				return getSpec() != SPEC_EDEFAULT;
			case TypesLibraryPackage.NATIVE_TYPE__MAPS_TO:
				return basicGetMapsTo() != null;
		}
		return super.eIsSet(featureID);
	}

} //NativeTypeImpl
