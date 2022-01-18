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
package org.obeonetwork.dsl.requirement;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Category</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.requirement.Category#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.Category#getSubCategories <em>Sub Categories</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.Category#getId <em>Id</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.Category#getRepository <em>Repository</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.Category#getParentCategory <em>Parent Category</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.requirement.Category#getReferencedObject <em>Referenced Object</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.requirement.RequirementPackage#getCategory()
 * @model
 * @generated
 */
public interface Category extends CategoriesContainer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2022 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Requirements</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.requirement.Requirement}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.requirement.Requirement#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of the contained requirements.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Requirements</em>' containment reference list.
	 * @see org.obeonetwork.dsl.requirement.RequirementPackage#getCategory_Requirements()
	 * @see org.obeonetwork.dsl.requirement.Requirement#getCategory
	 * @model opposite="category" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Requirement> getRequirements();

	/**
	 * Returns the value of the '<em><b>Sub Categories</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.requirement.Category}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.requirement.Category#getParentCategory <em>Parent Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Categories</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of the contained categories.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub Categories</em>' containment reference list.
	 * @see org.obeonetwork.dsl.requirement.RequirementPackage#getCategory_SubCategories()
	 * @see org.obeonetwork.dsl.requirement.Category#getParentCategory
	 * @model opposite="parentCategory" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Category> getSubCategories();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Category's identifier.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.obeonetwork.dsl.requirement.RequirementPackage#getCategory_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.requirement.Category#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Repository</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.requirement.Repository#getMainCategories <em>Main Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Repository where the category is contained.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Repository</em>' container reference.
	 * @see #setRepository(Repository)
	 * @see org.obeonetwork.dsl.requirement.RequirementPackage#getCategory_Repository()
	 * @see org.obeonetwork.dsl.requirement.Repository#getMainCategories
	 * @model opposite="mainCategories" transient="false"
	 * @generated
	 */
	Repository getRepository();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.requirement.Category#getRepository <em>Repository</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository</em>' container reference.
	 * @see #getRepository()
	 * @generated
	 */
	void setRepository(Repository value);

	/**
	 * Returns the value of the '<em><b>Parent Category</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.requirement.Category#getSubCategories <em>Sub Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Category</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Parent category containing this one.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parent Category</em>' container reference.
	 * @see #setParentCategory(Category)
	 * @see org.obeonetwork.dsl.requirement.RequirementPackage#getCategory_ParentCategory()
	 * @see org.obeonetwork.dsl.requirement.Category#getSubCategories
	 * @model opposite="subCategories" transient="false"
	 * @generated
	 */
	Category getParentCategory();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.requirement.Category#getParentCategory <em>Parent Category</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Category</em>' container reference.
	 * @see #getParentCategory()
	 * @generated
	 */
	void setParentCategory(Category value);

	/**
	 * Returns the value of the '<em><b>Referenced Object</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Object</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of the referenced objects.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referenced Object</em>' reference list.
	 * @see org.obeonetwork.dsl.requirement.RequirementPackage#getCategory_ReferencedObject()
	 * @model
	 * @generated
	 */
	EList<EObject> getReferencedObject();

} // Category
