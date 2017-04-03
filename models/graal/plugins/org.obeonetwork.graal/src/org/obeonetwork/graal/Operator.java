/*******************************************************************************
 * Copyright (c) 2010, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.graal.Operator#getKind <em>Kind</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.graal.GraalPackage#getOperator()
 * @model
 * @generated
 */
public interface Operator extends Node {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.graal.OperatorKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.obeonetwork.graal.OperatorKind
	 * @see #setKind(OperatorKind)
	 * @see org.obeonetwork.graal.GraalPackage#getOperator_Kind()
	 * @model required="true"
	 * @generated
	 */
	OperatorKind getKind();

	/**
	 * Sets the value of the '{@link org.obeonetwork.graal.Operator#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.obeonetwork.graal.OperatorKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(OperatorKind value);

} // Operator
