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
package org.obeonetwork.dsl.requirement.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.obeonetwork.dsl.requirement.CategoriesContainer;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.NamedElement;
import org.obeonetwork.dsl.requirement.Repository;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.dsl.requirement.RequirementFactory;
import org.obeonetwork.dsl.requirement.RequirementPackage;
import org.obeonetwork.dsl.requirement.RequirementType;
import org.obeonetwork.dsl.requirement.util.RequirementValidator;
import org.obeonetwork.dsl.technicalid.TechnicalIDPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RequirementPackageImpl extends EPackageImpl implements RequirementPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2022 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass repositoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass categoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requirementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass categoriesContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum requirementTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.obeonetwork.dsl.requirement.RequirementPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RequirementPackageImpl() {
		super(eNS_URI, RequirementFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link RequirementPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RequirementPackage init() {
		if (isInited) return (RequirementPackage)EPackage.Registry.INSTANCE.getEPackage(RequirementPackage.eNS_URI);

		// Obtain or create and register package
		RequirementPackageImpl theRequirementPackage = (RequirementPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RequirementPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RequirementPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TechnicalIDPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theRequirementPackage.createPackageContents();

		// Initialize created meta-data
		theRequirementPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theRequirementPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return RequirementValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theRequirementPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RequirementPackage.eNS_URI, theRequirementPackage);
		return theRequirementPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepository() {
		return repositoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepository_MainCategories() {
		return (EReference)repositoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepository_ReferencedObject() {
		return (EReference)repositoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCategory() {
		return categoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCategory_Requirements() {
		return (EReference)categoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCategory_SubCategories() {
		return (EReference)categoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCategory_Id() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCategory_Repository() {
		return (EReference)categoryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCategory_ParentCategory() {
		return (EReference)categoryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCategory_ReferencedObject() {
		return (EReference)categoryEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequirement() {
		return requirementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirement_Id() {
		return (EAttribute)requirementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirement_Version() {
		return (EAttribute)requirementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequirement_ReferencedObject() {
		return (EReference)requirementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirement_Statement() {
		return (EAttribute)requirementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirement_Rationale() {
		return (EAttribute)requirementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirement_AcceptanceCriteria() {
		return (EAttribute)requirementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirement_Type() {
		return (EAttribute)requirementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequirement_Category() {
		return (EReference)requirementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirement_Subtype() {
		return (EAttribute)requirementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirement_Status() {
		return (EAttribute)requirementEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirement_CreatedOn() {
		return (EAttribute)requirementEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirement_ModifiedOn() {
		return (EAttribute)requirementEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCategoriesContainer() {
		return categoriesContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCategoriesContainer_OwnedCategories() {
		return (EReference)categoriesContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCategoriesContainer_OwnedRequirements() {
		return (EReference)categoriesContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRequirementType() {
		return requirementTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementFactory getRequirementFactory() {
		return (RequirementFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		repositoryEClass = createEClass(REPOSITORY);
		createEReference(repositoryEClass, REPOSITORY__MAIN_CATEGORIES);
		createEReference(repositoryEClass, REPOSITORY__REFERENCED_OBJECT);

		categoryEClass = createEClass(CATEGORY);
		createEReference(categoryEClass, CATEGORY__REQUIREMENTS);
		createEReference(categoryEClass, CATEGORY__SUB_CATEGORIES);
		createEAttribute(categoryEClass, CATEGORY__ID);
		createEReference(categoryEClass, CATEGORY__REPOSITORY);
		createEReference(categoryEClass, CATEGORY__PARENT_CATEGORY);
		createEReference(categoryEClass, CATEGORY__REFERENCED_OBJECT);

		requirementEClass = createEClass(REQUIREMENT);
		createEAttribute(requirementEClass, REQUIREMENT__ID);
		createEAttribute(requirementEClass, REQUIREMENT__VERSION);
		createEReference(requirementEClass, REQUIREMENT__REFERENCED_OBJECT);
		createEAttribute(requirementEClass, REQUIREMENT__STATEMENT);
		createEAttribute(requirementEClass, REQUIREMENT__RATIONALE);
		createEAttribute(requirementEClass, REQUIREMENT__ACCEPTANCE_CRITERIA);
		createEAttribute(requirementEClass, REQUIREMENT__TYPE);
		createEReference(requirementEClass, REQUIREMENT__CATEGORY);
		createEAttribute(requirementEClass, REQUIREMENT__SUBTYPE);
		createEAttribute(requirementEClass, REQUIREMENT__STATUS);
		createEAttribute(requirementEClass, REQUIREMENT__CREATED_ON);
		createEAttribute(requirementEClass, REQUIREMENT__MODIFIED_ON);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		categoriesContainerEClass = createEClass(CATEGORIES_CONTAINER);
		createEReference(categoriesContainerEClass, CATEGORIES_CONTAINER__OWNED_CATEGORIES);
		createEReference(categoriesContainerEClass, CATEGORIES_CONTAINER__OWNED_REQUIREMENTS);

		// Create enums
		requirementTypeEEnum = createEEnum(REQUIREMENT_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		TechnicalIDPackage theTechnicalIDPackage = (TechnicalIDPackage)EPackage.Registry.INSTANCE.getEPackage(TechnicalIDPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		repositoryEClass.getESuperTypes().add(this.getCategoriesContainer());
		categoryEClass.getESuperTypes().add(this.getCategoriesContainer());
		requirementEClass.getESuperTypes().add(this.getNamedElement());
		namedElementEClass.getESuperTypes().add(theTechnicalIDPackage.getIdentifiable());
		categoriesContainerEClass.getESuperTypes().add(this.getNamedElement());

		// Initialize classes and features; add operations and parameters
		initEClass(repositoryEClass, Repository.class, "Repository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRepository_MainCategories(), this.getCategory(), this.getCategory_Repository(), "mainCategories", null, 0, -1, Repository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRepository_ReferencedObject(), ecorePackage.getEObject(), null, "referencedObject", null, 0, -1, Repository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(categoryEClass, Category.class, "Category", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCategory_Requirements(), this.getRequirement(), this.getRequirement_Category(), "requirements", null, 0, -1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCategory_SubCategories(), this.getCategory(), this.getCategory_ParentCategory(), "subCategories", null, 0, -1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategory_Id(), ecorePackage.getEString(), "id", null, 0, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCategory_Repository(), this.getRepository(), this.getRepository_MainCategories(), "repository", null, 0, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCategory_ParentCategory(), this.getCategory(), this.getCategory_SubCategories(), "parentCategory", null, 0, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCategory_ReferencedObject(), ecorePackage.getEObject(), null, "referencedObject", null, 0, -1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(requirementEClass, Requirement.class, "Requirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRequirement_Id(), ecorePackage.getEString(), "id", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequirement_Version(), ecorePackage.getEInt(), "version", "1", 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRequirement_ReferencedObject(), ecorePackage.getEObject(), null, "referencedObject", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequirement_Statement(), ecorePackage.getEString(), "statement", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequirement_Rationale(), ecorePackage.getEString(), "rationale", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequirement_AcceptanceCriteria(), ecorePackage.getEString(), "acceptanceCriteria", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequirement_Type(), this.getRequirementType(), "type", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRequirement_Category(), this.getCategory(), this.getCategory_Requirements(), "category", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequirement_Subtype(), ecorePackage.getEString(), "subtype", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequirement_Status(), ecorePackage.getEString(), "status", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequirement_CreatedOn(), ecorePackage.getEDate(), "createdOn", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequirement_ModifiedOn(), ecorePackage.getEDate(), "modifiedOn", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(categoriesContainerEClass, CategoriesContainer.class, "CategoriesContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCategoriesContainer_OwnedCategories(), this.getCategory(), null, "ownedCategories", null, 0, -1, CategoriesContainer.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getCategoriesContainer_OwnedRequirements(), this.getRequirement(), null, "ownedRequirements", null, 0, -1, CategoriesContainer.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(requirementTypeEEnum, RequirementType.class, "RequirementType");
		addEEnumLiteral(requirementTypeEEnum, RequirementType.FUNCTIONAL);
		addEEnumLiteral(requirementTypeEEnum, RequirementType.TECHNICAL);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/GenModel</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGenModelAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/GenModel";	
		addAnnotation
		  (getRepository_MainCategories(), 
		   source, 
		   new String[] {
			 "documentation", "List of the root categories of the repository."
		   });	
		addAnnotation
		  (getRepository_ReferencedObject(), 
		   source, 
		   new String[] {
			 "documentation", "List of the objects concerned by this requirement category."
		   });	
		addAnnotation
		  (getCategory_Requirements(), 
		   source, 
		   new String[] {
			 "documentation", "List of the contained requirements."
		   });	
		addAnnotation
		  (getCategory_SubCategories(), 
		   source, 
		   new String[] {
			 "documentation", "List of the contained categories."
		   });	
		addAnnotation
		  (getCategory_Id(), 
		   source, 
		   new String[] {
			 "documentation", "Category\'s identifier."
		   });	
		addAnnotation
		  (getCategory_Repository(), 
		   source, 
		   new String[] {
			 "documentation", "Repository where the category is contained."
		   });	
		addAnnotation
		  (getCategory_ParentCategory(), 
		   source, 
		   new String[] {
			 "documentation", "Parent category containing this one."
		   });	
		addAnnotation
		  (getCategory_ReferencedObject(), 
		   source, 
		   new String[] {
			 "documentation", "List of the referenced objects."
		   });	
		addAnnotation
		  (getRequirement_Id(), 
		   source, 
		   new String[] {
			 "documentation", "The business identifier of the requirement."
		   });	
		addAnnotation
		  (getRequirement_Version(), 
		   source, 
		   new String[] {
			 "documentation", "The version of the requirement."
		   });	
		addAnnotation
		  (getRequirement_ReferencedObject(), 
		   source, 
		   new String[] {
			 "documentation", "The list of the objects the requirement holds on."
		   });	
		addAnnotation
		  (getRequirement_Statement(), 
		   source, 
		   new String[] {
			 "documentation", "The statement is the text that expresses the requirement."
		   });	
		addAnnotation
		  (getRequirement_Rationale(), 
		   source, 
		   new String[] {
			 "documentation", "The requirement\'s rationale."
		   });	
		addAnnotation
		  (getRequirement_AcceptanceCriteria(), 
		   source, 
		   new String[] {
			 "documentation", "The acceptance criteria shall be meet for the client to accept the specified system."
		   });	
		addAnnotation
		  (getRequirement_Type(), 
		   source, 
		   new String[] {
			 "documentation", "The requirement type can be either functionnal or technical."
		   });	
		addAnnotation
		  (getRequirement_Category(), 
		   source, 
		   new String[] {
			 "documentation", "The category containing the requirement."
		   });	
		addAnnotation
		  (getRequirement_Subtype(), 
		   source, 
		   new String[] {
			 "documentation", "Application dependent requirement type."
		   });	
		addAnnotation
		  (getRequirement_Status(), 
		   source, 
		   new String[] {
			 "documentation", "Application dependent status indicating where the requirement lies in the requirement\'s life cycle."
		   });	
		addAnnotation
		  (getRequirement_CreatedOn(), 
		   source, 
		   new String[] {
			 "documentation", "Date the requirement was created."
		   });	
		addAnnotation
		  (getRequirement_ModifiedOn(), 
		   source, 
		   new String[] {
			 "documentation", "Date the requirement was last modified."
		   });	
		addAnnotation
		  (getNamedElement_Name(), 
		   source, 
		   new String[] {
			 "documentation", "The name of this model element."
		   });	
		addAnnotation
		  (getCategoriesContainer_OwnedCategories(), 
		   source, 
		   new String[] {
			 "documentation", "List of contained categories (and only the directly contained ones)."
		   });	
		addAnnotation
		  (getCategoriesContainer_OwnedRequirements(), 
		   source, 
		   new String[] {
			 "documentation", "List of directly contained requirements."
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";	
		addAnnotation
		  (requirementEClass, 
		   source, 
		   new String[] {
			 "constraints", "isRequirementValid"
		   });
	}

} //RequirementPackageImpl
