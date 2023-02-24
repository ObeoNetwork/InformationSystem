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
package org.obeonetwork.dsl.environment.impl;

import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.dsl.environment.BoundableElement;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.PropertyImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.PropertyImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.PropertyImpl#isIsIdentifier <em>Is Identifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PropertyImpl extends ObeoDSMObjectImpl implements Property {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2023 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

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
	protected static final MultiplicityKind MULTIPLICITY_EDEFAULT = MultiplicityKind.ZERO_ONE_LITERAL;

	/**
	 * The default value of the '{@link #isIsIdentifier() <em>Is Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_IDENTIFIER_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EnvironmentPackage.Literals.PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String) eDynamicGet(EnvironmentPackage.PROPERTY__NAME, EnvironmentPackage.Literals.PROPERTY__NAME, true,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eDynamicSet(EnvironmentPackage.PROPERTY__NAME, EnvironmentPackage.Literals.PROPERTY__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicityKind getMultiplicity() {
		return (MultiplicityKind) eDynamicGet(EnvironmentPackage.PROPERTY__MULTIPLICITY,
				EnvironmentPackage.Literals.PROPERTY__MULTIPLICITY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiplicity(MultiplicityKind newMultiplicity) {
		eDynamicSet(EnvironmentPackage.PROPERTY__MULTIPLICITY, EnvironmentPackage.Literals.PROPERTY__MULTIPLICITY,
				newMultiplicity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsIdentifier() {
		return (Boolean) eDynamicGet(EnvironmentPackage.PROPERTY__IS_IDENTIFIER,
				EnvironmentPackage.Literals.PROPERTY__IS_IDENTIFIER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsIdentifier(boolean newIsIdentifier) {
		eDynamicSet(EnvironmentPackage.PROPERTY__IS_IDENTIFIER, EnvironmentPackage.Literals.PROPERTY__IS_IDENTIFIER,
				newIsIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPathValid(BoundableElement root, String path) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case EnvironmentPackage.PROPERTY__NAME:
			return getName();
		case EnvironmentPackage.PROPERTY__MULTIPLICITY:
			return getMultiplicity();
		case EnvironmentPackage.PROPERTY__IS_IDENTIFIER:
			return isIsIdentifier();
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
		case EnvironmentPackage.PROPERTY__NAME:
			setName((String) newValue);
			return;
		case EnvironmentPackage.PROPERTY__MULTIPLICITY:
			setMultiplicity((MultiplicityKind) newValue);
			return;
		case EnvironmentPackage.PROPERTY__IS_IDENTIFIER:
			setIsIdentifier((Boolean) newValue);
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
		case EnvironmentPackage.PROPERTY__NAME:
			setName(NAME_EDEFAULT);
			return;
		case EnvironmentPackage.PROPERTY__MULTIPLICITY:
			setMultiplicity(MULTIPLICITY_EDEFAULT);
			return;
		case EnvironmentPackage.PROPERTY__IS_IDENTIFIER:
			setIsIdentifier(IS_IDENTIFIER_EDEFAULT);
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
		case EnvironmentPackage.PROPERTY__NAME:
			return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
		case EnvironmentPackage.PROPERTY__MULTIPLICITY:
			return getMultiplicity() != MULTIPLICITY_EDEFAULT;
		case EnvironmentPackage.PROPERTY__IS_IDENTIFIER:
			return isIsIdentifier() != IS_IDENTIFIER_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //PropertyImpl
