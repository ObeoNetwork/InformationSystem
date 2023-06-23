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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BModel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.ecorebinding.BModel#getBPackages <em>BPackages</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBModel()
 * @model
 * @generated
 */
public interface BModel extends BBase {
	/**
	 * Returns the value of the '<em><b>BPackages</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.ecorebinding.BPackage}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.ecorebinding.BPackage#getBModel <em>BModel</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BPackages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BPackages</em>' containment reference list.
	 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage#getBModel_BPackages()
	 * @see org.obeonetwork.dsl.ecorebinding.BPackage#getBModel
	 * @model opposite="bModel" containment="true"
	 * @generated
	 */
	EList<BPackage> getBPackages();

} // BModel
