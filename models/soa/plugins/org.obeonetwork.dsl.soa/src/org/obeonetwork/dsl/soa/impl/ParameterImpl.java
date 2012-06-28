/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.soa.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl;
import org.obeonetwork.dsl.soa.Parameter;
import org.obeonetwork.dsl.soa.SoaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ParameterImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ParameterImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ParameterImpl#getLower <em>Lower</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ParameterImpl#getUpper <em>Upper</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ParameterImpl#isIsUnique <em>Is Unique</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ParameterImpl#isIsOrdered <em>Is Ordered</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterImpl extends ObeoDSMObjectImpl implements Parameter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

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
	 * The default value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected static final int LOWER_EDEFAULT = 1;
	/**
	 * The default value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected static final int UPPER_EDEFAULT = 1;
	/**
	 * The default value of the '{@link #isIsUnique() <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUnique()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_UNIQUE_EDEFAULT = false;
	/**
	 * The default value of the '{@link #isIsOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOrdered()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ORDERED_EDEFAULT = true;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SoaPackage.Literals.PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		return (Type)eDynamicGet(SoaPackage.PARAMETER__TYPE, SoaPackage.Literals.PARAMETER__TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetType() {
		return (Type)eDynamicGet(SoaPackage.PARAMETER__TYPE, SoaPackage.Literals.PARAMETER__TYPE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Type newType) {
		eDynamicSet(SoaPackage.PARAMETER__TYPE, SoaPackage.Literals.PARAMETER__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eDynamicGet(SoaPackage.PARAMETER__NAME, SoaPackage.Literals.PARAMETER__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eDynamicSet(SoaPackage.PARAMETER__NAME, SoaPackage.Literals.PARAMETER__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLower() {
		return (Integer)eDynamicGet(SoaPackage.PARAMETER__LOWER, SoaPackage.Literals.PARAMETER__LOWER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLower(int newLower) {
		eDynamicSet(SoaPackage.PARAMETER__LOWER, SoaPackage.Literals.PARAMETER__LOWER, newLower);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getUpper() {
		return (Integer)eDynamicGet(SoaPackage.PARAMETER__UPPER, SoaPackage.Literals.PARAMETER__UPPER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpper(int newUpper) {
		eDynamicSet(SoaPackage.PARAMETER__UPPER, SoaPackage.Literals.PARAMETER__UPPER, newUpper);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsUnique() {
		return (Boolean)eDynamicGet(SoaPackage.PARAMETER__IS_UNIQUE, SoaPackage.Literals.PARAMETER__IS_UNIQUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsUnique(boolean newIsUnique) {
		eDynamicSet(SoaPackage.PARAMETER__IS_UNIQUE, SoaPackage.Literals.PARAMETER__IS_UNIQUE, newIsUnique);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsOrdered() {
		return (Boolean)eDynamicGet(SoaPackage.PARAMETER__IS_ORDERED, SoaPackage.Literals.PARAMETER__IS_ORDERED, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsOrdered(boolean newIsOrdered) {
		eDynamicSet(SoaPackage.PARAMETER__IS_ORDERED, SoaPackage.Literals.PARAMETER__IS_ORDERED, newIsOrdered);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SoaPackage.PARAMETER__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case SoaPackage.PARAMETER__NAME:
				return getName();
			case SoaPackage.PARAMETER__LOWER:
				return getLower();
			case SoaPackage.PARAMETER__UPPER:
				return getUpper();
			case SoaPackage.PARAMETER__IS_UNIQUE:
				return isIsUnique();
			case SoaPackage.PARAMETER__IS_ORDERED:
				return isIsOrdered();
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
			case SoaPackage.PARAMETER__TYPE:
				setType((Type)newValue);
				return;
			case SoaPackage.PARAMETER__NAME:
				setName((String)newValue);
				return;
			case SoaPackage.PARAMETER__LOWER:
				setLower((Integer)newValue);
				return;
			case SoaPackage.PARAMETER__UPPER:
				setUpper((Integer)newValue);
				return;
			case SoaPackage.PARAMETER__IS_UNIQUE:
				setIsUnique((Boolean)newValue);
				return;
			case SoaPackage.PARAMETER__IS_ORDERED:
				setIsOrdered((Boolean)newValue);
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
			case SoaPackage.PARAMETER__TYPE:
				setType((Type)null);
				return;
			case SoaPackage.PARAMETER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SoaPackage.PARAMETER__LOWER:
				setLower(LOWER_EDEFAULT);
				return;
			case SoaPackage.PARAMETER__UPPER:
				setUpper(UPPER_EDEFAULT);
				return;
			case SoaPackage.PARAMETER__IS_UNIQUE:
				setIsUnique(IS_UNIQUE_EDEFAULT);
				return;
			case SoaPackage.PARAMETER__IS_ORDERED:
				setIsOrdered(IS_ORDERED_EDEFAULT);
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
			case SoaPackage.PARAMETER__TYPE:
				return basicGetType() != null;
			case SoaPackage.PARAMETER__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case SoaPackage.PARAMETER__LOWER:
				return getLower() != LOWER_EDEFAULT;
			case SoaPackage.PARAMETER__UPPER:
				return getUpper() != UPPER_EDEFAULT;
			case SoaPackage.PARAMETER__IS_UNIQUE:
				return isIsUnique() != IS_UNIQUE_EDEFAULT;
			case SoaPackage.PARAMETER__IS_ORDERED:
				return isIsOrdered() != IS_ORDERED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //ParameterImpl