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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EParameter;

import org.obeonetwork.dsl.ecorebinding.BOperation;
import org.obeonetwork.dsl.ecorebinding.BParameter;
import org.obeonetwork.dsl.ecorebinding.EcorebindingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BParameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.impl.BParameterImpl#getBOperation <em>BOperation</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.impl.BParameterImpl#getEcoreParameter <em>Ecore Parameter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BParameterImpl extends BTypedElementImpl implements BParameter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcorebindingPackage.Literals.BPARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BOperation getBOperation() {
		return (BOperation)eGet(EcorebindingPackage.Literals.BPARAMETER__BOPERATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBOperation(BOperation newBOperation) {
		eSet(EcorebindingPackage.Literals.BPARAMETER__BOPERATION, newBOperation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EParameter getEcoreParameter() {
		return (EParameter)eGet(EcorebindingPackage.Literals.BPARAMETER__ECORE_PARAMETER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEcoreParameter(EParameter newEcoreParameter) {
		eSet(EcorebindingPackage.Literals.BPARAMETER__ECORE_PARAMETER, newEcoreParameter);
	}

} //BParameterImpl
