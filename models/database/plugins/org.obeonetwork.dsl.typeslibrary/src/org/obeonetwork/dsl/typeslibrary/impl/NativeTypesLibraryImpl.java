/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.typeslibrary.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.obeonetwork.dsl.technicalid.Identifiable;
import org.obeonetwork.dsl.technicalid.TechnicalIDPackage;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.NativeTypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryKind;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Native Types Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.typeslibrary.impl.NativeTypesLibraryImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.typeslibrary.impl.NativeTypesLibraryImpl#getTechnicalid <em>Technicalid</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.typeslibrary.impl.NativeTypesLibraryImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.typeslibrary.impl.NativeTypesLibraryImpl#getNativeTypes <em>Native Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NativeTypesLibraryImpl extends CDOObjectImpl implements NativeTypesLibrary {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2023 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final TypesLibraryKind KIND_EDEFAULT = TypesLibraryKind.LOGICAL_TYPES;
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
	protected NativeTypesLibraryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesLibraryPackage.Literals.NATIVE_TYPES_LIBRARY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesLibraryKind getKind() {
		return (TypesLibraryKind)eDynamicGet(TypesLibraryPackage.NATIVE_TYPES_LIBRARY__KIND, TypesLibraryPackage.Literals.TYPES_LIBRARY__KIND, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(TypesLibraryKind newKind) {
		eDynamicSet(TypesLibraryPackage.NATIVE_TYPES_LIBRARY__KIND, TypesLibraryPackage.Literals.TYPES_LIBRARY__KIND, newKind);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTechnicalid() {
		return (String)eDynamicGet(TypesLibraryPackage.NATIVE_TYPES_LIBRARY__TECHNICALID, TechnicalIDPackage.Literals.IDENTIFIABLE__TECHNICALID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTechnicalid(String newTechnicalid) {
		eDynamicSet(TypesLibraryPackage.NATIVE_TYPES_LIBRARY__TECHNICALID, TechnicalIDPackage.Literals.IDENTIFIABLE__TECHNICALID, newTechnicalid);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eDynamicGet(TypesLibraryPackage.NATIVE_TYPES_LIBRARY__NAME, TypesLibraryPackage.Literals.NATIVE_TYPES_LIBRARY__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eDynamicSet(TypesLibraryPackage.NATIVE_TYPES_LIBRARY__NAME, TypesLibraryPackage.Literals.NATIVE_TYPES_LIBRARY__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NativeType> getNativeTypes() {
		return (EList<NativeType>)eDynamicGet(TypesLibraryPackage.NATIVE_TYPES_LIBRARY__NATIVE_TYPES, TypesLibraryPackage.Literals.NATIVE_TYPES_LIBRARY__NATIVE_TYPES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NativeType findTypeByName(String name) {
		for (NativeType type : getNativeTypes()) {
			if (type.getName().equalsIgnoreCase(name)) {
				return type;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesLibraryPackage.NATIVE_TYPES_LIBRARY__NATIVE_TYPES:
				return ((InternalEList<?>)getNativeTypes()).basicRemove(otherEnd, msgs);
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
			case TypesLibraryPackage.NATIVE_TYPES_LIBRARY__KIND:
				return getKind();
			case TypesLibraryPackage.NATIVE_TYPES_LIBRARY__TECHNICALID:
				return getTechnicalid();
			case TypesLibraryPackage.NATIVE_TYPES_LIBRARY__NAME:
				return getName();
			case TypesLibraryPackage.NATIVE_TYPES_LIBRARY__NATIVE_TYPES:
				return getNativeTypes();
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
			case TypesLibraryPackage.NATIVE_TYPES_LIBRARY__KIND:
				setKind((TypesLibraryKind)newValue);
				return;
			case TypesLibraryPackage.NATIVE_TYPES_LIBRARY__TECHNICALID:
				setTechnicalid((String)newValue);
				return;
			case TypesLibraryPackage.NATIVE_TYPES_LIBRARY__NAME:
				setName((String)newValue);
				return;
			case TypesLibraryPackage.NATIVE_TYPES_LIBRARY__NATIVE_TYPES:
				getNativeTypes().clear();
				getNativeTypes().addAll((Collection<? extends NativeType>)newValue);
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
			case TypesLibraryPackage.NATIVE_TYPES_LIBRARY__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case TypesLibraryPackage.NATIVE_TYPES_LIBRARY__TECHNICALID:
				setTechnicalid(TECHNICALID_EDEFAULT);
				return;
			case TypesLibraryPackage.NATIVE_TYPES_LIBRARY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TypesLibraryPackage.NATIVE_TYPES_LIBRARY__NATIVE_TYPES:
				getNativeTypes().clear();
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
			case TypesLibraryPackage.NATIVE_TYPES_LIBRARY__KIND:
				return getKind() != KIND_EDEFAULT;
			case TypesLibraryPackage.NATIVE_TYPES_LIBRARY__TECHNICALID:
				return TECHNICALID_EDEFAULT == null ? getTechnicalid() != null : !TECHNICALID_EDEFAULT.equals(getTechnicalid());
			case TypesLibraryPackage.NATIVE_TYPES_LIBRARY__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case TypesLibraryPackage.NATIVE_TYPES_LIBRARY__NATIVE_TYPES:
				return !getNativeTypes().isEmpty();
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
				case TypesLibraryPackage.NATIVE_TYPES_LIBRARY__TECHNICALID: return TechnicalIDPackage.IDENTIFIABLE__TECHNICALID;
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
				case TechnicalIDPackage.IDENTIFIABLE__TECHNICALID: return TypesLibraryPackage.NATIVE_TYPES_LIBRARY__TECHNICALID;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //NativeTypesLibraryImpl
