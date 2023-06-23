/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
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
import org.eclipse.emf.ecore.EOperation;

import org.obeonetwork.dsl.ecorebinding.BClass;
import org.obeonetwork.dsl.ecorebinding.BOperation;
import org.obeonetwork.dsl.ecorebinding.BParameter;
import org.obeonetwork.dsl.ecorebinding.BTypeParameter;
import org.obeonetwork.dsl.ecorebinding.EcorebindingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BOperation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.impl.BOperationImpl#getBClass <em>BClass</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.impl.BOperationImpl#getEcoreOperation <em>Ecore Operation</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.impl.BOperationImpl#getBParameters <em>BParameters</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.impl.BOperationImpl#getBTypeParameters <em>BType Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BOperationImpl extends BTypedElementImpl implements BOperation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcorebindingPackage.Literals.BOPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BClass getBClass() {
		return (BClass)eGet(EcorebindingPackage.Literals.BOPERATION__BCLASS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBClass(BClass newBClass) {
		eSet(EcorebindingPackage.Literals.BOPERATION__BCLASS, newBClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEcoreOperation() {
		return (EOperation)eGet(EcorebindingPackage.Literals.BOPERATION__ECORE_OPERATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEcoreOperation(EOperation newEcoreOperation) {
		eSet(EcorebindingPackage.Literals.BOPERATION__ECORE_OPERATION, newEcoreOperation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<BParameter> getBParameters() {
		return (EList<BParameter>)eGet(EcorebindingPackage.Literals.BOPERATION__BPARAMETERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<BTypeParameter> getBTypeParameters() {
		return (EList<BTypeParameter>)eGet(EcorebindingPackage.Literals.BOPERATION__BTYPE_PARAMETERS, true);
	}

} //BOperationImpl
