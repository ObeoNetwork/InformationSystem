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
package org.obeonetwork.dsl.soa.impl;

import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.dsl.environment.TypesDefinition;
import org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl;
import org.obeonetwork.dsl.soa.ImplementationComponent;
import org.obeonetwork.dsl.soa.Interface;
import org.obeonetwork.dsl.soa.SoaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Implementation Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ImplementationComponentImpl#getImplement <em>Implement</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ImplementationComponentImpl#getEntities <em>Entities</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImplementationComponentImpl extends ObeoDSMObjectImpl implements ImplementationComponent {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2025 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImplementationComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SoaPackage.Literals.IMPLEMENTATION_COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Interface getImplement() {
		return (Interface)eDynamicGet(SoaPackage.IMPLEMENTATION_COMPONENT__IMPLEMENT, SoaPackage.Literals.IMPLEMENTATION_COMPONENT__IMPLEMENT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface basicGetImplement() {
		return (Interface)eDynamicGet(SoaPackage.IMPLEMENTATION_COMPONENT__IMPLEMENT, SoaPackage.Literals.IMPLEMENTATION_COMPONENT__IMPLEMENT, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImplement(Interface newImplement) {
		eDynamicSet(SoaPackage.IMPLEMENTATION_COMPONENT__IMPLEMENT, SoaPackage.Literals.IMPLEMENTATION_COMPONENT__IMPLEMENT, newImplement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypesDefinition getEntities() {
		return (TypesDefinition)eDynamicGet(SoaPackage.IMPLEMENTATION_COMPONENT__ENTITIES, SoaPackage.Literals.IMPLEMENTATION_COMPONENT__ENTITIES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesDefinition basicGetEntities() {
		return (TypesDefinition)eDynamicGet(SoaPackage.IMPLEMENTATION_COMPONENT__ENTITIES, SoaPackage.Literals.IMPLEMENTATION_COMPONENT__ENTITIES, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEntities(TypesDefinition newEntities) {
		eDynamicSet(SoaPackage.IMPLEMENTATION_COMPONENT__ENTITIES, SoaPackage.Literals.IMPLEMENTATION_COMPONENT__ENTITIES, newEntities);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SoaPackage.IMPLEMENTATION_COMPONENT__IMPLEMENT:
				if (resolve) return getImplement();
				return basicGetImplement();
			case SoaPackage.IMPLEMENTATION_COMPONENT__ENTITIES:
				if (resolve) return getEntities();
				return basicGetEntities();
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
			case SoaPackage.IMPLEMENTATION_COMPONENT__IMPLEMENT:
				setImplement((Interface)newValue);
				return;
			case SoaPackage.IMPLEMENTATION_COMPONENT__ENTITIES:
				setEntities((TypesDefinition)newValue);
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
			case SoaPackage.IMPLEMENTATION_COMPONENT__IMPLEMENT:
				setImplement((Interface)null);
				return;
			case SoaPackage.IMPLEMENTATION_COMPONENT__ENTITIES:
				setEntities((TypesDefinition)null);
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
			case SoaPackage.IMPLEMENTATION_COMPONENT__IMPLEMENT:
				return basicGetImplement() != null;
			case SoaPackage.IMPLEMENTATION_COMPONENT__ENTITIES:
				return basicGetEntities() != null;
		}
		return super.eIsSet(featureID);
	}

} //ImplementationComponentImpl