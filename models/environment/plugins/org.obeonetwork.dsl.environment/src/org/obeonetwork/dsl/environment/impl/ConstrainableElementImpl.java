/**
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.environment.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.obeonetwork.dsl.environment.ConstrainableElement;
import org.obeonetwork.dsl.environment.EnvironmentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constrainable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.ConstrainableElementImpl#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.ConstrainableElementImpl#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.ConstrainableElementImpl#getPattern <em>Pattern</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ConstrainableElementImpl extends CDOObjectImpl implements ConstrainableElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2023 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximum()
	 * @generated
	 * @ordered
	 */
	protected static final String MAXIMUM_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getMinimum() <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimum()
	 * @generated
	 * @ordered
	 */
	protected static final String MINIMUM_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected static final String PATTERN_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstrainableElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EnvironmentPackage.Literals.CONSTRAINABLE_ELEMENT;
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
	public String getMaximum() {
		return (String) eDynamicGet(EnvironmentPackage.CONSTRAINABLE_ELEMENT__MAXIMUM,
				EnvironmentPackage.Literals.CONSTRAINABLE_ELEMENT__MAXIMUM, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximum(String newMaximum) {
		eDynamicSet(EnvironmentPackage.CONSTRAINABLE_ELEMENT__MAXIMUM,
				EnvironmentPackage.Literals.CONSTRAINABLE_ELEMENT__MAXIMUM, newMaximum);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinimum() {
		return (String) eDynamicGet(EnvironmentPackage.CONSTRAINABLE_ELEMENT__MINIMUM,
				EnvironmentPackage.Literals.CONSTRAINABLE_ELEMENT__MINIMUM, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimum(String newMinimum) {
		eDynamicSet(EnvironmentPackage.CONSTRAINABLE_ELEMENT__MINIMUM,
				EnvironmentPackage.Literals.CONSTRAINABLE_ELEMENT__MINIMUM, newMinimum);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPattern() {
		return (String) eDynamicGet(EnvironmentPackage.CONSTRAINABLE_ELEMENT__PATTERN,
				EnvironmentPackage.Literals.CONSTRAINABLE_ELEMENT__PATTERN, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPattern(String newPattern) {
		eDynamicSet(EnvironmentPackage.CONSTRAINABLE_ELEMENT__PATTERN,
				EnvironmentPackage.Literals.CONSTRAINABLE_ELEMENT__PATTERN, newPattern);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case EnvironmentPackage.CONSTRAINABLE_ELEMENT__MAXIMUM:
			return getMaximum();
		case EnvironmentPackage.CONSTRAINABLE_ELEMENT__MINIMUM:
			return getMinimum();
		case EnvironmentPackage.CONSTRAINABLE_ELEMENT__PATTERN:
			return getPattern();
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
		case EnvironmentPackage.CONSTRAINABLE_ELEMENT__MAXIMUM:
			setMaximum((String) newValue);
			return;
		case EnvironmentPackage.CONSTRAINABLE_ELEMENT__MINIMUM:
			setMinimum((String) newValue);
			return;
		case EnvironmentPackage.CONSTRAINABLE_ELEMENT__PATTERN:
			setPattern((String) newValue);
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
		case EnvironmentPackage.CONSTRAINABLE_ELEMENT__MAXIMUM:
			setMaximum(MAXIMUM_EDEFAULT);
			return;
		case EnvironmentPackage.CONSTRAINABLE_ELEMENT__MINIMUM:
			setMinimum(MINIMUM_EDEFAULT);
			return;
		case EnvironmentPackage.CONSTRAINABLE_ELEMENT__PATTERN:
			setPattern(PATTERN_EDEFAULT);
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
		case EnvironmentPackage.CONSTRAINABLE_ELEMENT__MAXIMUM:
			return MAXIMUM_EDEFAULT == null ? getMaximum() != null : !MAXIMUM_EDEFAULT.equals(getMaximum());
		case EnvironmentPackage.CONSTRAINABLE_ELEMENT__MINIMUM:
			return MINIMUM_EDEFAULT == null ? getMinimum() != null : !MINIMUM_EDEFAULT.equals(getMinimum());
		case EnvironmentPackage.CONSTRAINABLE_ELEMENT__PATTERN:
			return PATTERN_EDEFAULT == null ? getPattern() != null : !PATTERN_EDEFAULT.equals(getPattern());
		}
		return super.eIsSet(featureID);
	}

} //ConstrainableElementImpl
