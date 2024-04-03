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
package org.obeonetwork.dsl.requirement;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Categories Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.requirement.CategoriesContainer#getOwnedCategories <em>Owned Categories</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.CategoriesContainer#getOwnedRequirements <em>Owned Requirements</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.requirement.RequirementPackage#getCategoriesContainer()
 * @model abstract="true"
 * @generated
 */
public interface CategoriesContainer extends NamedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2024 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v2.0\r\nwhich accompanies this distribution, and is available at\r\nhttps://www.eclipse.org/legal/epl-2.0/\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Owned Categories</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.requirement.Category}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Categories</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of contained categories (and only the directly contained ones).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Categories</em>' reference list.
	 * @see org.obeonetwork.dsl.requirement.RequirementPackage#getCategoriesContainer_OwnedCategories()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Category> getOwnedCategories();

	/**
	 * Returns the value of the '<em><b>Owned Requirements</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.requirement.Requirement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Requirements</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of directly contained requirements.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Requirements</em>' reference list.
	 * @see org.obeonetwork.dsl.requirement.RequirementPackage#getCategoriesContainer_OwnedRequirements()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Requirement> getOwnedRequirements();

} // CategoriesContainer
