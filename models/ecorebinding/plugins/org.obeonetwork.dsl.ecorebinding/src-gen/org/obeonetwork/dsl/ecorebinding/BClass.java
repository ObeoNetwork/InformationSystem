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
package org.obeonetwork.dsl.ecorebinding;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BClass</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.BClass#getEcoreClass <em>Ecore Class</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.BClass#getBFeatures <em>BFeatures</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.BClass#getBOperations <em>BOperations</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBClass()
 * @model
 * @generated
 */
public interface BClass extends BClassifier {
	/**
	 * Returns the value of the '<em><b>Ecore Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecore Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecore Class</em>' reference.
	 * @see #setEcoreClass(EClass)
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBClass_EcoreClass()
	 * @model required="true"
	 * @generated
	 */
	EClass getEcoreClass();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.ecorebinding.BClass#getEcoreClass <em>Ecore Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecore Class</em>' reference.
	 * @see #getEcoreClass()
	 * @generated
	 */
	void setEcoreClass(EClass value);

	/**
	 * Returns the value of the '<em><b>BFeatures</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.ecorebinding.BFeature}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.ecorebinding.BFeature#getBClass <em>BClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BFeatures</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BFeatures</em>' containment reference list.
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBClass_BFeatures()
	 * @see org.obeonetwork.dsl.ecorebinding.BFeature#getBClass
	 * @model opposite="bClass" containment="true"
	 * @generated
	 */
	EList<BFeature> getBFeatures();

	/**
	 * Returns the value of the '<em><b>BOperations</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.ecorebinding.BOperation}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.ecorebinding.BOperation#getBClass <em>BClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BOperations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BOperations</em>' containment reference list.
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBClass_BOperations()
	 * @see org.obeonetwork.dsl.ecorebinding.BOperation#getBClass
	 * @model opposite="bClass" containment="true"
	 * @generated
	 */
	EList<BOperation> getBOperations();

} // BClass
