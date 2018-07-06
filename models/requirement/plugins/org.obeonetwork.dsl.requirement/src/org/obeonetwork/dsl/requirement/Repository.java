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
package org.obeonetwork.dsl.requirement;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.requirement.Repository#getMainCategories <em>Main Categories</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.Repository#getReferencedObject <em>Referenced Object</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.requirement.RequirementPackage#getRepository()
 * @model
 * @generated
 */
public interface Repository extends CategoriesContainer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2010, 2017 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Main Categories</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.requirement.Category}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.requirement.Category#getRepository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main Categories</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Categories</em>' containment reference list.
	 * @see org.obeonetwork.dsl.requirement.RequirementPackage#getRepository_MainCategories()
	 * @see org.obeonetwork.dsl.requirement.Category#getRepository
	 * @model opposite="repository" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Category> getMainCategories();

	/**
	 * Returns the value of the '<em><b>Referenced Object</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Object</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Object</em>' reference list.
	 * @see org.obeonetwork.dsl.requirement.RequirementPackage#getRepository_ReferencedObject()
	 * @model
	 * @generated
	 */
	EList<EObject> getReferencedObject();

} // Repository
