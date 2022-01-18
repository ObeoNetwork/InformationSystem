/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BClassifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.BClassifier#getBTypeParameters <em>BType Parameters</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.BClassifier#getBPackage <em>BPackage</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBClassifier()
 * @model
 * @generated
 */
public interface BClassifier extends BBase {
	/**
	 * Returns the value of the '<em><b>BPackage</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.ecorebinding.BPackage#getBClassifiers <em>BClassifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BPackage</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BPackage</em>' reference.
	 * @see #setBPackage(BPackage)
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBClassifier_BPackage()
	 * @see org.obeonetwork.dsl.ecorebinding.BPackage#getBClassifiers
	 * @model opposite="bClassifiers" required="true"
	 * @generated
	 */
	BPackage getBPackage();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.ecorebinding.BClassifier#getBPackage <em>BPackage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BPackage</em>' reference.
	 * @see #getBPackage()
	 * @generated
	 */
	void setBPackage(BPackage value);

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
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBClassifier_BTypeParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<BTypeParameter> getBTypeParameters();

} // BClassifier
