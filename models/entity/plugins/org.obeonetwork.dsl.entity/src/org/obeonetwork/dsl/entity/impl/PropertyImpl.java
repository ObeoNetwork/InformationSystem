/**
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *
 * $Id$
 */
package org.obeonetwork.dsl.entity.impl;

import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.entity.Property;
import org.obeonetwork.dsl.environment.BoundableElement;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.PropertyImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.PropertyImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entity.impl.PropertyImpl#isIsPrimaryKey <em>Is Primary Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PropertyImpl extends ObeoDSMObjectImpl implements
		Property {
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
	 * The default value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected static final MultiplicityKind MULTIPLICITY_EDEFAULT = MultiplicityKind.ZERO_ONE_LITERAL;
	/**
	 * The default value of the '{@link #isIsPrimaryKey() <em>Is Primary Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPrimaryKey()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_PRIMARY_KEY_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EntityPackage.Literals.PROPERTY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eDynamicGet(EntityPackage.PROPERTY__NAME, EntityPackage.Literals.PROPERTY__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eDynamicSet(EntityPackage.PROPERTY__NAME, EntityPackage.Literals.PROPERTY__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicityKind getMultiplicity() {
		return (MultiplicityKind)eDynamicGet(EntityPackage.PROPERTY__MULTIPLICITY, EntityPackage.Literals.PROPERTY__MULTIPLICITY, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiplicity(MultiplicityKind newMultiplicity) {
		eDynamicSet(EntityPackage.PROPERTY__MULTIPLICITY, EntityPackage.Literals.PROPERTY__MULTIPLICITY, newMultiplicity);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsPrimaryKey() {
		return (Boolean)eDynamicGet(EntityPackage.PROPERTY__IS_PRIMARY_KEY, EntityPackage.Literals.PROPERTY__IS_PRIMARY_KEY, true, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsPrimaryKey(boolean newIsPrimaryKey) {
		eDynamicSet(EntityPackage.PROPERTY__IS_PRIMARY_KEY, EntityPackage.Literals.PROPERTY__IS_PRIMARY_KEY, newIsPrimaryKey);
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
			case EntityPackage.PROPERTY__NAME:
				return getName();
			case EntityPackage.PROPERTY__MULTIPLICITY:
				return getMultiplicity();
			case EntityPackage.PROPERTY__IS_PRIMARY_KEY:
				return isIsPrimaryKey();
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
			case EntityPackage.PROPERTY__NAME:
				setName((String)newValue);
				return;
			case EntityPackage.PROPERTY__MULTIPLICITY:
				setMultiplicity((MultiplicityKind)newValue);
				return;
			case EntityPackage.PROPERTY__IS_PRIMARY_KEY:
				setIsPrimaryKey((Boolean)newValue);
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
			case EntityPackage.PROPERTY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EntityPackage.PROPERTY__MULTIPLICITY:
				setMultiplicity(MULTIPLICITY_EDEFAULT);
				return;
			case EntityPackage.PROPERTY__IS_PRIMARY_KEY:
				setIsPrimaryKey(IS_PRIMARY_KEY_EDEFAULT);
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
			case EntityPackage.PROPERTY__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case EntityPackage.PROPERTY__MULTIPLICITY:
				return getMultiplicity() != MULTIPLICITY_EDEFAULT;
			case EntityPackage.PROPERTY__IS_PRIMARY_KEY:
				return isIsPrimaryKey() != IS_PRIMARY_KEY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} // PropertyImpl
