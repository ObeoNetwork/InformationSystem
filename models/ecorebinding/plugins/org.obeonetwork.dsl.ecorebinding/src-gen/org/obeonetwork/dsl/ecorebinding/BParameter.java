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
package org.obeonetwork.dsl.ecorebinding;

import org.eclipse.emf.ecore.EParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BParameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.BParameter#getBOperation <em>BOperation</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.BParameter#getEcoreParameter <em>Ecore Parameter</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBParameter()
 * @model
 * @generated
 */
public interface BParameter extends BTypedElement {
	/**
	 * Returns the value of the '<em><b>BOperation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.ecorebinding.BOperation#getBParameters <em>BParameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BOperation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BOperation</em>' container reference.
	 * @see #setBOperation(BOperation)
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBParameter_BOperation()
	 * @see org.obeonetwork.dsl.ecorebinding.BOperation#getBParameters
	 * @model opposite="bParameters" required="true" transient="false"
	 * @generated
	 */
	BOperation getBOperation();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.ecorebinding.BParameter#getBOperation <em>BOperation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BOperation</em>' container reference.
	 * @see #getBOperation()
	 * @generated
	 */
	void setBOperation(BOperation value);

	/**
	 * Returns the value of the '<em><b>Ecore Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecore Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecore Parameter</em>' reference.
	 * @see #setEcoreParameter(EParameter)
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBParameter_EcoreParameter()
	 * @model required="true"
	 * @generated
	 */
	EParameter getEcoreParameter();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.ecorebinding.BParameter#getEcoreParameter <em>Ecore Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecore Parameter</em>' reference.
	 * @see #getEcoreParameter()
	 * @generated
	 */
	void setEcoreParameter(EParameter value);

} // BParameter
