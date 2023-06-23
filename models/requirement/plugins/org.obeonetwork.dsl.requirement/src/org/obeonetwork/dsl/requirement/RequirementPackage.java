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
package org.obeonetwork.dsl.requirement;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.obeonetwork.dsl.technicalid.TechnicalIDPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.requirement.RequirementFactory
 * @model kind="package"
 * @generated
 */
public interface RequirementPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2023 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v2.0\r\nwhich accompanies this distribution, and is available at\r\nhttps://www.eclipse.org/legal/epl-2.0/\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "requirement";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.obeonetwork.org/dsl/requirement/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "requirement";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RequirementPackage eINSTANCE = org.obeonetwork.dsl.requirement.impl.RequirementPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.requirement.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.requirement.impl.NamedElementImpl
	 * @see org.obeonetwork.dsl.requirement.impl.RequirementPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__TECHNICALID = TechnicalIDPackage.IDENTIFIABLE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = TechnicalIDPackage.IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = TechnicalIDPackage.IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.requirement.impl.CategoriesContainerImpl <em>Categories Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.requirement.impl.CategoriesContainerImpl
	 * @see org.obeonetwork.dsl.requirement.impl.RequirementPackageImpl#getCategoriesContainer()
	 * @generated
	 */
	int CATEGORIES_CONTAINER = 4;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORIES_CONTAINER__TECHNICALID = NAMED_ELEMENT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORIES_CONTAINER__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORIES_CONTAINER__OWNED_CATEGORIES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Requirements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORIES_CONTAINER__OWNED_REQUIREMENTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Categories Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORIES_CONTAINER_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.requirement.impl.RepositoryImpl <em>Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.requirement.impl.RepositoryImpl
	 * @see org.obeonetwork.dsl.requirement.impl.RequirementPackageImpl#getRepository()
	 * @generated
	 */
	int REPOSITORY = 0;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__TECHNICALID = CATEGORIES_CONTAINER__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__NAME = CATEGORIES_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Owned Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__OWNED_CATEGORIES = CATEGORIES_CONTAINER__OWNED_CATEGORIES;

	/**
	 * The feature id for the '<em><b>Owned Requirements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__OWNED_REQUIREMENTS = CATEGORIES_CONTAINER__OWNED_REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Main Categories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__MAIN_CATEGORIES = CATEGORIES_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referenced Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__REFERENCED_OBJECT = CATEGORIES_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_FEATURE_COUNT = CATEGORIES_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.requirement.impl.CategoryImpl <em>Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.requirement.impl.CategoryImpl
	 * @see org.obeonetwork.dsl.requirement.impl.RequirementPackageImpl#getCategory()
	 * @generated
	 */
	int CATEGORY = 1;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__TECHNICALID = CATEGORIES_CONTAINER__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__NAME = CATEGORIES_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Owned Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__OWNED_CATEGORIES = CATEGORIES_CONTAINER__OWNED_CATEGORIES;

	/**
	 * The feature id for the '<em><b>Owned Requirements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__OWNED_REQUIREMENTS = CATEGORIES_CONTAINER__OWNED_REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__REQUIREMENTS = CATEGORIES_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Categories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__SUB_CATEGORIES = CATEGORIES_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__ID = CATEGORIES_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Repository</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__REPOSITORY = CATEGORIES_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Parent Category</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__PARENT_CATEGORY = CATEGORIES_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Referenced Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__REFERENCED_OBJECT = CATEGORIES_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_FEATURE_COUNT = CATEGORIES_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.requirement.impl.RequirementImpl <em>Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.requirement.impl.RequirementImpl
	 * @see org.obeonetwork.dsl.requirement.impl.RequirementPackageImpl#getRequirement()
	 * @generated
	 */
	int REQUIREMENT = 2;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__TECHNICALID = NAMED_ELEMENT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__ID = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__VERSION = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referenced Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REFERENCED_OBJECT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__STATEMENT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Rationale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__RATIONALE = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Acceptance Criteria</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__ACCEPTANCE_CRITERIA = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Category</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__CATEGORY = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Subtype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__SUBTYPE = NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__STATUS = NAMED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__CREATED_ON = NAMED_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__MODIFIED_ON = NAMED_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.requirement.RequirementType <em>Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.requirement.RequirementType
	 * @see org.obeonetwork.dsl.requirement.impl.RequirementPackageImpl#getRequirementType()
	 * @generated
	 */
	int REQUIREMENT_TYPE = 5;


	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.requirement.Repository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repository</em>'.
	 * @see org.obeonetwork.dsl.requirement.Repository
	 * @generated
	 */
	EClass getRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.requirement.Repository#getMainCategories <em>Main Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Main Categories</em>'.
	 * @see org.obeonetwork.dsl.requirement.Repository#getMainCategories()
	 * @see #getRepository()
	 * @generated
	 */
	EReference getRepository_MainCategories();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.requirement.Repository#getReferencedObject <em>Referenced Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referenced Object</em>'.
	 * @see org.obeonetwork.dsl.requirement.Repository#getReferencedObject()
	 * @see #getRepository()
	 * @generated
	 */
	EReference getRepository_ReferencedObject();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.requirement.Category <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Category</em>'.
	 * @see org.obeonetwork.dsl.requirement.Category
	 * @generated
	 */
	EClass getCategory();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.requirement.Category#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Requirements</em>'.
	 * @see org.obeonetwork.dsl.requirement.Category#getRequirements()
	 * @see #getCategory()
	 * @generated
	 */
	EReference getCategory_Requirements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.requirement.Category#getSubCategories <em>Sub Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Categories</em>'.
	 * @see org.obeonetwork.dsl.requirement.Category#getSubCategories()
	 * @see #getCategory()
	 * @generated
	 */
	EReference getCategory_SubCategories();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.requirement.Category#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.obeonetwork.dsl.requirement.Category#getId()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_Id();

	/**
	 * Returns the meta object for the container reference '{@link org.obeonetwork.dsl.requirement.Category#getRepository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Repository</em>'.
	 * @see org.obeonetwork.dsl.requirement.Category#getRepository()
	 * @see #getCategory()
	 * @generated
	 */
	EReference getCategory_Repository();

	/**
	 * Returns the meta object for the container reference '{@link org.obeonetwork.dsl.requirement.Category#getParentCategory <em>Parent Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Category</em>'.
	 * @see org.obeonetwork.dsl.requirement.Category#getParentCategory()
	 * @see #getCategory()
	 * @generated
	 */
	EReference getCategory_ParentCategory();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.requirement.Category#getReferencedObject <em>Referenced Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referenced Object</em>'.
	 * @see org.obeonetwork.dsl.requirement.Category#getReferencedObject()
	 * @see #getCategory()
	 * @generated
	 */
	EReference getCategory_ReferencedObject();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.requirement.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement</em>'.
	 * @see org.obeonetwork.dsl.requirement.Requirement
	 * @generated
	 */
	EClass getRequirement();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.requirement.Requirement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.obeonetwork.dsl.requirement.Requirement#getId()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.requirement.Requirement#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.obeonetwork.dsl.requirement.Requirement#getVersion()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_Version();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.requirement.Requirement#getReferencedObject <em>Referenced Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referenced Object</em>'.
	 * @see org.obeonetwork.dsl.requirement.Requirement#getReferencedObject()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_ReferencedObject();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.requirement.Requirement#getStatement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Statement</em>'.
	 * @see org.obeonetwork.dsl.requirement.Requirement#getStatement()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_Statement();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.requirement.Requirement#getRationale <em>Rationale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rationale</em>'.
	 * @see org.obeonetwork.dsl.requirement.Requirement#getRationale()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_Rationale();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.requirement.Requirement#getAcceptanceCriteria <em>Acceptance Criteria</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Acceptance Criteria</em>'.
	 * @see org.obeonetwork.dsl.requirement.Requirement#getAcceptanceCriteria()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_AcceptanceCriteria();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.requirement.Requirement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.obeonetwork.dsl.requirement.Requirement#getType()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_Type();

	/**
	 * Returns the meta object for the container reference '{@link org.obeonetwork.dsl.requirement.Requirement#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Category</em>'.
	 * @see org.obeonetwork.dsl.requirement.Requirement#getCategory()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_Category();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.requirement.Requirement#getSubtype <em>Subtype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Subtype</em>'.
	 * @see org.obeonetwork.dsl.requirement.Requirement#getSubtype()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_Subtype();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.requirement.Requirement#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see org.obeonetwork.dsl.requirement.Requirement#getStatus()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_Status();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.requirement.Requirement#getCreatedOn <em>Created On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created On</em>'.
	 * @see org.obeonetwork.dsl.requirement.Requirement#getCreatedOn()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_CreatedOn();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.requirement.Requirement#getModifiedOn <em>Modified On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modified On</em>'.
	 * @see org.obeonetwork.dsl.requirement.Requirement#getModifiedOn()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_ModifiedOn();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.requirement.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.obeonetwork.dsl.requirement.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.requirement.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.requirement.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.requirement.CategoriesContainer <em>Categories Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Categories Container</em>'.
	 * @see org.obeonetwork.dsl.requirement.CategoriesContainer
	 * @generated
	 */
	EClass getCategoriesContainer();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.requirement.CategoriesContainer#getOwnedCategories <em>Owned Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Owned Categories</em>'.
	 * @see org.obeonetwork.dsl.requirement.CategoriesContainer#getOwnedCategories()
	 * @see #getCategoriesContainer()
	 * @generated
	 */
	EReference getCategoriesContainer_OwnedCategories();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.requirement.CategoriesContainer#getOwnedRequirements <em>Owned Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Owned Requirements</em>'.
	 * @see org.obeonetwork.dsl.requirement.CategoriesContainer#getOwnedRequirements()
	 * @see #getCategoriesContainer()
	 * @generated
	 */
	EReference getCategoriesContainer_OwnedRequirements();

	/**
	 * Returns the meta object for enum '{@link org.obeonetwork.dsl.requirement.RequirementType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type</em>'.
	 * @see org.obeonetwork.dsl.requirement.RequirementType
	 * @generated
	 */
	EEnum getRequirementType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RequirementFactory getRequirementFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.requirement.impl.RepositoryImpl <em>Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.requirement.impl.RepositoryImpl
		 * @see org.obeonetwork.dsl.requirement.impl.RequirementPackageImpl#getRepository()
		 * @generated
		 */
		EClass REPOSITORY = eINSTANCE.getRepository();

		/**
		 * The meta object literal for the '<em><b>Main Categories</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY__MAIN_CATEGORIES = eINSTANCE.getRepository_MainCategories();

		/**
		 * The meta object literal for the '<em><b>Referenced Object</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY__REFERENCED_OBJECT = eINSTANCE.getRepository_ReferencedObject();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.requirement.impl.CategoryImpl <em>Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.requirement.impl.CategoryImpl
		 * @see org.obeonetwork.dsl.requirement.impl.RequirementPackageImpl#getCategory()
		 * @generated
		 */
		EClass CATEGORY = eINSTANCE.getCategory();

		/**
		 * The meta object literal for the '<em><b>Requirements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATEGORY__REQUIREMENTS = eINSTANCE.getCategory_Requirements();

		/**
		 * The meta object literal for the '<em><b>Sub Categories</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATEGORY__SUB_CATEGORIES = eINSTANCE.getCategory_SubCategories();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__ID = eINSTANCE.getCategory_Id();

		/**
		 * The meta object literal for the '<em><b>Repository</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATEGORY__REPOSITORY = eINSTANCE.getCategory_Repository();

		/**
		 * The meta object literal for the '<em><b>Parent Category</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATEGORY__PARENT_CATEGORY = eINSTANCE.getCategory_ParentCategory();

		/**
		 * The meta object literal for the '<em><b>Referenced Object</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATEGORY__REFERENCED_OBJECT = eINSTANCE.getCategory_ReferencedObject();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.requirement.impl.RequirementImpl <em>Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.requirement.impl.RequirementImpl
		 * @see org.obeonetwork.dsl.requirement.impl.RequirementPackageImpl#getRequirement()
		 * @generated
		 */
		EClass REQUIREMENT = eINSTANCE.getRequirement();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__ID = eINSTANCE.getRequirement_Id();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__VERSION = eINSTANCE.getRequirement_Version();

		/**
		 * The meta object literal for the '<em><b>Referenced Object</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__REFERENCED_OBJECT = eINSTANCE.getRequirement_ReferencedObject();

		/**
		 * The meta object literal for the '<em><b>Statement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__STATEMENT = eINSTANCE.getRequirement_Statement();

		/**
		 * The meta object literal for the '<em><b>Rationale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__RATIONALE = eINSTANCE.getRequirement_Rationale();

		/**
		 * The meta object literal for the '<em><b>Acceptance Criteria</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__ACCEPTANCE_CRITERIA = eINSTANCE.getRequirement_AcceptanceCriteria();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__TYPE = eINSTANCE.getRequirement_Type();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__CATEGORY = eINSTANCE.getRequirement_Category();

		/**
		 * The meta object literal for the '<em><b>Subtype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__SUBTYPE = eINSTANCE.getRequirement_Subtype();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__STATUS = eINSTANCE.getRequirement_Status();

		/**
		 * The meta object literal for the '<em><b>Created On</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__CREATED_ON = eINSTANCE.getRequirement_CreatedOn();

		/**
		 * The meta object literal for the '<em><b>Modified On</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__MODIFIED_ON = eINSTANCE.getRequirement_ModifiedOn();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.requirement.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.requirement.impl.NamedElementImpl
		 * @see org.obeonetwork.dsl.requirement.impl.RequirementPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.requirement.impl.CategoriesContainerImpl <em>Categories Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.requirement.impl.CategoriesContainerImpl
		 * @see org.obeonetwork.dsl.requirement.impl.RequirementPackageImpl#getCategoriesContainer()
		 * @generated
		 */
		EClass CATEGORIES_CONTAINER = eINSTANCE.getCategoriesContainer();

		/**
		 * The meta object literal for the '<em><b>Owned Categories</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATEGORIES_CONTAINER__OWNED_CATEGORIES = eINSTANCE.getCategoriesContainer_OwnedCategories();

		/**
		 * The meta object literal for the '<em><b>Owned Requirements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATEGORIES_CONTAINER__OWNED_REQUIREMENTS = eINSTANCE.getCategoriesContainer_OwnedRequirements();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.requirement.RequirementType <em>Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.requirement.RequirementType
		 * @see org.obeonetwork.dsl.requirement.impl.RequirementPackageImpl#getRequirementType()
		 * @generated
		 */
		EEnum REQUIREMENT_TYPE = eINSTANCE.getRequirementType();

	}

} //RequirementPackage
