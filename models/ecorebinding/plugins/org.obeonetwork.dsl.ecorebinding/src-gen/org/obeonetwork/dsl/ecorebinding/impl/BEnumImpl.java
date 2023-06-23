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
import org.eclipse.emf.ecore.EEnum;

import org.obeonetwork.dsl.ecorebinding.BEnum;
import org.obeonetwork.dsl.ecorebinding.BEnumLiteral;
import org.obeonetwork.dsl.ecorebinding.EcorebindingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BEnum</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.impl.BEnumImpl#getEcoreEnum <em>Ecore Enum</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.impl.BEnumImpl#getBEnumLiterals <em>BEnum Literals</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BEnumImpl extends BDataTypeImpl implements BEnum {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BEnumImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcorebindingPackage.Literals.BENUM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEcoreEnum() {
		return (EEnum)eGet(EcorebindingPackage.Literals.BENUM__ECORE_ENUM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEcoreEnum(EEnum newEcoreEnum) {
		eSet(EcorebindingPackage.Literals.BENUM__ECORE_ENUM, newEcoreEnum);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<BEnumLiteral> getBEnumLiterals() {
		return (EList<BEnumLiteral>)eGet(EcorebindingPackage.Literals.BENUM__BENUM_LITERALS, true);
	}

} //BEnumImpl
