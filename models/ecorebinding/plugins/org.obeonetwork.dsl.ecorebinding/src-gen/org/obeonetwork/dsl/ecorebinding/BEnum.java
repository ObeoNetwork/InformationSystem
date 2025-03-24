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
package org.obeonetwork.dsl.ecorebinding;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EEnum;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BEnum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.BEnum#getEcoreEnum <em>Ecore Enum</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.BEnum#getBEnumLiterals <em>BEnum Literals</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBEnum()
 * @model
 * @generated
 */
public interface BEnum extends BDataType {
	/**
	 * Returns the value of the '<em><b>Ecore Enum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecore Enum</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecore Enum</em>' reference.
	 * @see #setEcoreEnum(EEnum)
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBEnum_EcoreEnum()
	 * @model required="true"
	 * @generated
	 */
	EEnum getEcoreEnum();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.ecorebinding.BEnum#getEcoreEnum <em>Ecore Enum</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecore Enum</em>' reference.
	 * @see #getEcoreEnum()
	 * @generated
	 */
	void setEcoreEnum(EEnum value);

	/**
	 * Returns the value of the '<em><b>BEnum Literals</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.ecorebinding.BEnumLiteral}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.ecorebinding.BEnumLiteral#getBEnum <em>BEnum</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BEnum Literals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BEnum Literals</em>' containment reference list.
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBEnum_BEnumLiterals()
	 * @see org.obeonetwork.dsl.ecorebinding.BEnumLiteral#getBEnum
	 * @model opposite="bEnum" containment="true"
	 * @generated
	 */
	EList<BEnumLiteral> getBEnumLiterals();

} // BEnum
