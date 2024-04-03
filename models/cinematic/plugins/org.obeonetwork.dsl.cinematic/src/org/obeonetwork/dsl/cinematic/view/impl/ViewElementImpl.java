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
package org.obeonetwork.dsl.cinematic.view.impl;

import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.dsl.cinematic.view.ViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewPackage;
import org.obeonetwork.dsl.environment.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.impl.ViewElementImpl#isRequired <em>Required</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.impl.ViewElementImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.impl.ViewElementImpl#getExample <em>Example</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ViewElementImpl extends AbstractViewElementImpl implements ViewElement {
	/**
	 * The default value of the '{@link #isRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REQUIRED_EDEFAULT = false;

	/**
	 * The default value of the '{@link #getExample() <em>Example</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExample()
	 * @generated
	 * @ordered
	 */
	protected static final String EXAMPLE_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ViewPackage.Literals.VIEW_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRequired() {
		return (Boolean)eDynamicGet(ViewPackage.VIEW_ELEMENT__REQUIRED, ViewPackage.Literals.VIEW_ELEMENT__REQUIRED, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequired(boolean newRequired) {
		eDynamicSet(ViewPackage.VIEW_ELEMENT__REQUIRED, ViewPackage.Literals.VIEW_ELEMENT__REQUIRED, newRequired);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		return (Type)eDynamicGet(ViewPackage.VIEW_ELEMENT__TYPE, ViewPackage.Literals.VIEW_ELEMENT__TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetType() {
		return (Type)eDynamicGet(ViewPackage.VIEW_ELEMENT__TYPE, ViewPackage.Literals.VIEW_ELEMENT__TYPE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Type newType) {
		eDynamicSet(ViewPackage.VIEW_ELEMENT__TYPE, ViewPackage.Literals.VIEW_ELEMENT__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExample() {
		return (String)eDynamicGet(ViewPackage.VIEW_ELEMENT__EXAMPLE, ViewPackage.Literals.VIEW_ELEMENT__EXAMPLE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExample(String newExample) {
		eDynamicSet(ViewPackage.VIEW_ELEMENT__EXAMPLE, ViewPackage.Literals.VIEW_ELEMENT__EXAMPLE, newExample);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ViewPackage.VIEW_ELEMENT__REQUIRED:
				return isRequired();
			case ViewPackage.VIEW_ELEMENT__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case ViewPackage.VIEW_ELEMENT__EXAMPLE:
				return getExample();
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
			case ViewPackage.VIEW_ELEMENT__REQUIRED:
				setRequired((Boolean)newValue);
				return;
			case ViewPackage.VIEW_ELEMENT__TYPE:
				setType((Type)newValue);
				return;
			case ViewPackage.VIEW_ELEMENT__EXAMPLE:
				setExample((String)newValue);
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
			case ViewPackage.VIEW_ELEMENT__REQUIRED:
				setRequired(REQUIRED_EDEFAULT);
				return;
			case ViewPackage.VIEW_ELEMENT__TYPE:
				setType((Type)null);
				return;
			case ViewPackage.VIEW_ELEMENT__EXAMPLE:
				setExample(EXAMPLE_EDEFAULT);
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
			case ViewPackage.VIEW_ELEMENT__REQUIRED:
				return isRequired() != REQUIRED_EDEFAULT;
			case ViewPackage.VIEW_ELEMENT__TYPE:
				return basicGetType() != null;
			case ViewPackage.VIEW_ELEMENT__EXAMPLE:
				return EXAMPLE_EDEFAULT == null ? getExample() != null : !EXAMPLE_EDEFAULT.equals(getExample());
		}
		return super.eIsSet(featureID);
	}

} //ViewElementImpl
