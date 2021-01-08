/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.ecorebinding;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BOperation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.BOperation#getBClass <em>BClass</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.BOperation#getEcoreOperation <em>Ecore Operation</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.BOperation#getBParameters <em>BParameters</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.BOperation#getBTypeParameters <em>BType Parameters</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBOperation()
 * @model
 * @generated
 */
public interface BOperation extends BTypedElement {
	/**
	 * Returns the value of the '<em><b>BClass</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.ecorebinding.BClass#getBOperations <em>BOperations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BClass</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BClass</em>' container reference.
	 * @see #setBClass(BClass)
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBOperation_BClass()
	 * @see org.obeonetwork.dsl.ecorebinding.BClass#getBOperations
	 * @model opposite="bOperations" required="true" transient="false"
	 * @generated
	 */
	BClass getBClass();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.ecorebinding.BOperation#getBClass <em>BClass</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BClass</em>' container reference.
	 * @see #getBClass()
	 * @generated
	 */
	void setBClass(BClass value);

	/**
	 * Returns the value of the '<em><b>Ecore Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecore Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecore Operation</em>' reference.
	 * @see #setEcoreOperation(EOperation)
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBOperation_EcoreOperation()
	 * @model required="true"
	 * @generated
	 */
	EOperation getEcoreOperation();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.ecorebinding.BOperation#getEcoreOperation <em>Ecore Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecore Operation</em>' reference.
	 * @see #getEcoreOperation()
	 * @generated
	 */
	void setEcoreOperation(EOperation value);

	/**
	 * Returns the value of the '<em><b>BParameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.ecorebinding.BParameter}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.ecorebinding.BParameter#getBOperation <em>BOperation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BParameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BParameters</em>' containment reference list.
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBOperation_BParameters()
	 * @see org.obeonetwork.dsl.ecorebinding.BParameter#getBOperation
	 * @model opposite="bOperation" containment="true"
	 * @generated
	 */
	EList<BParameter> getBParameters();

	/**
	 * Returns the value of the '<em><b>BType Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.ecorebinding.BTypeParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BType Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BType Parameters</em>' containment reference list.
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBOperation_BTypeParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<BTypeParameter> getBTypeParameters();

} // BOperation
