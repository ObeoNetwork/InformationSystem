/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.impl;

import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.dsl.environment.MultiplicityKind;
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
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ParameterImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ParameterImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ParameterImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ParameterImpl#isIsUnique <em>Is Unique</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ParameterImpl#isIsOrdered <em>Is Ordered</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParameterImpl extends ObeoDSMObjectImpl implements Parameter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2017 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

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
	 * The default value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected static final MultiplicityKind MULTIPLICITY_EDEFAULT = MultiplicityKind.ONE_LITERAL;

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
	public MultiplicityKind getMultiplicity() {
		return (MultiplicityKind)eDynamicGet(SoaPackage.PARAMETER__MULTIPLICITY, SoaPackage.Literals.PARAMETER__MULTIPLICITY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiplicity(MultiplicityKind newMultiplicity) {
		eDynamicSet(SoaPackage.PARAMETER__MULTIPLICITY, SoaPackage.Literals.PARAMETER__MULTIPLICITY, newMultiplicity);
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
			case SoaPackage.PARAMETER__MULTIPLICITY:
				return getMultiplicity();
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
			case SoaPackage.PARAMETER__MULTIPLICITY:
				setMultiplicity((MultiplicityKind)newValue);
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
			case SoaPackage.PARAMETER__MULTIPLICITY:
				setMultiplicity(MULTIPLICITY_EDEFAULT);
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
			case SoaPackage.PARAMETER__MULTIPLICITY:
				return getMultiplicity() != MULTIPLICITY_EDEFAULT;
			case SoaPackage.PARAMETER__IS_UNIQUE:
				return isIsUnique() != IS_UNIQUE_EDEFAULT;
			case SoaPackage.PARAMETER__IS_ORDERED:
				return isIsOrdered() != IS_ORDERED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //ParameterImpl