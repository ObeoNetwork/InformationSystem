/*******************************************************************************
 * Copyright (c) 2013, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.ecorebinding.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.obeonetwork.dsl.ecorebinding.BClass;
import org.obeonetwork.dsl.ecorebinding.BFeature;
import org.obeonetwork.dsl.ecorebinding.EcorebindingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BFeature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.impl.BFeatureImpl#getBClass <em>BClass</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.impl.BFeatureImpl#getEcoreFeature <em>Ecore Feature</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BFeatureImpl extends BTypedElementImpl implements BFeature {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcorebindingPackage.Literals.BFEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BClass getBClass() {
		return (BClass)eGet(EcorebindingPackage.Literals.BFEATURE__BCLASS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBClass(BClass newBClass) {
		eSet(EcorebindingPackage.Literals.BFEATURE__BCLASS, newBClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getEcoreFeature() {
		return (EStructuralFeature)eGet(EcorebindingPackage.Literals.BFEATURE__ECORE_FEATURE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEcoreFeature(EStructuralFeature newEcoreFeature) {
		eSet(EcorebindingPackage.Literals.BFEATURE__ECORE_FEATURE, newEcoreFeature);
	}

} //BFeatureImpl
