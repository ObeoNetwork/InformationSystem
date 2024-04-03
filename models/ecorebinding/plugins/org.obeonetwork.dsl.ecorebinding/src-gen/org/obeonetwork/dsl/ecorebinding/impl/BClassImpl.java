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
package org.obeonetwork.dsl.ecorebinding.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.obeonetwork.dsl.ecorebinding.BClass;
import org.obeonetwork.dsl.ecorebinding.BFeature;
import org.obeonetwork.dsl.ecorebinding.BOperation;
import org.obeonetwork.dsl.ecorebinding.EcorebindingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BClass</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.impl.BClassImpl#getEcoreClass <em>Ecore Class</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.impl.BClassImpl#getBFeatures <em>BFeatures</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.impl.BClassImpl#getBOperations <em>BOperations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BClassImpl extends BClassifierImpl implements BClass {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcorebindingPackage.Literals.BCLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEcoreClass() {
		return (EClass)eGet(EcorebindingPackage.Literals.BCLASS__ECORE_CLASS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEcoreClass(EClass newEcoreClass) {
		eSet(EcorebindingPackage.Literals.BCLASS__ECORE_CLASS, newEcoreClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<BFeature> getBFeatures() {
		return (EList<BFeature>)eGet(EcorebindingPackage.Literals.BCLASS__BFEATURES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<BOperation> getBOperations() {
		return (EList<BOperation>)eGet(EcorebindingPackage.Literals.BCLASS__BOPERATIONS, true);
	}

} //BClassImpl
