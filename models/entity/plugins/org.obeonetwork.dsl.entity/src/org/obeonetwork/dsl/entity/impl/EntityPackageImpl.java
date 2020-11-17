/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.entity.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.obeonetwork.dsl.entity.Criterion;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.entity.EntityFactory;
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.entity.ExternalCriterion;
import org.obeonetwork.dsl.entity.Finder;
import org.obeonetwork.dsl.entity.InheritanceKind;
import org.obeonetwork.dsl.entity.InternalCriterion;
import org.obeonetwork.dsl.entity.Root;
import org.obeonetwork.dsl.entity.extensionUtilities.ExtensionUtilitiesPackage;
import org.obeonetwork.dsl.entity.extensionUtilities.impl.ExtensionUtilitiesPackageImpl;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.technicalid.TechnicalIDPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class EntityPackageImpl extends EPackageImpl implements EntityPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2020 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass finderEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalCriterionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass criterionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalCriterionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum inheritanceKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory
	 * method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.obeonetwork.dsl.entity.EntityPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EntityPackageImpl() {
		super(eNS_URI, EntityFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link EntityPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EntityPackage init() {
		if (isInited) return (EntityPackage)EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI);

		// Obtain or create and register package
		EntityPackageImpl theEntityPackage = (EntityPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EntityPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EntityPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EnvironmentPackage.eINSTANCE.eClass();
		TechnicalIDPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ExtensionUtilitiesPackageImpl theExtensionUtilitiesPackage = (ExtensionUtilitiesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExtensionUtilitiesPackage.eNS_URI) instanceof ExtensionUtilitiesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExtensionUtilitiesPackage.eNS_URI) : ExtensionUtilitiesPackage.eINSTANCE);

		// Create package meta-data objects
		theEntityPackage.createPackageContents();
		theExtensionUtilitiesPackage.createPackageContents();

		// Initialize created meta-data
		theEntityPackage.initializePackageContents();
		theExtensionUtilitiesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEntityPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EntityPackage.eNS_URI, theEntityPackage);
		return theEntityPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoot() {
		return rootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoot_Name() {
		return (EAttribute)rootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntity() {
		return entityEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntity_EstimatedVolumetry() {
		return (EAttribute)entityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntity_EstimatedAccess() {
		return (EAttribute)entityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntity_Historized() {
		return (EAttribute)entityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntity_OwnedFinders() {
		return (EReference)entityEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntity_InheritanceKind() {
		return (EAttribute)entityEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFinder() {
		return finderEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFinder_Name() {
		return (EAttribute)finderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFinder_Entity() {
		return (EReference)finderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFinder_CustomizedName() {
		return (EAttribute)finderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFinder_Criterions() {
		return (EReference)finderEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFinder_Multiplicity() {
		return (EAttribute)finderEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInternalCriterion() {
		return internalCriterionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInternalCriterion_Target() {
		return (EReference)internalCriterionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInternalCriterion_Name() {
		return (EAttribute)internalCriterionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCriterion() {
		return criterionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalCriterion() {
		return externalCriterionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExternalCriterion_Name() {
		return (EAttribute)externalCriterionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalCriterion_Type() {
		return (EReference)externalCriterionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getInheritanceKind() {
		return inheritanceKindEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EntityFactory getEntityFactory() {
		return (EntityFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
		rootEClass = createEClass(ROOT);
		createEAttribute(rootEClass, ROOT__NAME);

		entityEClass = createEClass(ENTITY);
		createEAttribute(entityEClass, ENTITY__ESTIMATED_VOLUMETRY);
		createEAttribute(entityEClass, ENTITY__ESTIMATED_ACCESS);
		createEAttribute(entityEClass, ENTITY__HISTORIZED);
		createEReference(entityEClass, ENTITY__OWNED_FINDERS);
		createEAttribute(entityEClass, ENTITY__INHERITANCE_KIND);

		finderEClass = createEClass(FINDER);
		createEAttribute(finderEClass, FINDER__NAME);
		createEReference(finderEClass, FINDER__ENTITY);
		createEAttribute(finderEClass, FINDER__CUSTOMIZED_NAME);
		createEReference(finderEClass, FINDER__CRITERIONS);
		createEAttribute(finderEClass, FINDER__MULTIPLICITY);

		internalCriterionEClass = createEClass(INTERNAL_CRITERION);
		createEReference(internalCriterionEClass, INTERNAL_CRITERION__TARGET);
		createEAttribute(internalCriterionEClass, INTERNAL_CRITERION__NAME);

		criterionEClass = createEClass(CRITERION);

		externalCriterionEClass = createEClass(EXTERNAL_CRITERION);
		createEAttribute(externalCriterionEClass, EXTERNAL_CRITERION__NAME);
		createEReference(externalCriterionEClass, EXTERNAL_CRITERION__TYPE);

		// Create enums
		inheritanceKindEEnum = createEEnum(INHERITANCE_KIND);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
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
		ExtensionUtilitiesPackage theExtensionUtilitiesPackage = (ExtensionUtilitiesPackage)EPackage.Registry.INSTANCE.getEPackage(ExtensionUtilitiesPackage.eNS_URI);
		EnvironmentPackage theEnvironmentPackage = (EnvironmentPackage)EPackage.Registry.INSTANCE.getEPackage(EnvironmentPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theExtensionUtilitiesPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		rootEClass.getESuperTypes().add(theEnvironmentPackage.getTypesDefinition());
		rootEClass.getESuperTypes().add(theEnvironmentPackage.getNamespacesContainer());
		entityEClass.getESuperTypes().add(theEnvironmentPackage.getStructuredType());
		finderEClass.getESuperTypes().add(theEnvironmentPackage.getObeoDSMObject());
		internalCriterionEClass.getESuperTypes().add(this.getCriterion());
		criterionEClass.getESuperTypes().add(theEnvironmentPackage.getObeoDSMObject());
		externalCriterionEClass.getESuperTypes().add(this.getCriterion());

		// Initialize classes and features; add operations and parameters
		initEClass(rootEClass, Root.class, "Root", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRoot_Name(), ecorePackage.getEString(), "name", null, 0, 1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entityEClass, Entity.class, "Entity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntity_EstimatedVolumetry(), ecorePackage.getEInt(), "estimatedVolumetry", null, 0, 1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntity_EstimatedAccess(), ecorePackage.getEInt(), "estimatedAccess", null, 0, 1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntity_Historized(), ecorePackage.getEBoolean(), "historized", null, 1, 1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntity_OwnedFinders(), this.getFinder(), this.getFinder_Entity(), "ownedFinders", null, 0, -1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntity_InheritanceKind(), this.getInheritanceKind(), "inheritanceKind", null, 0, 1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(finderEClass, Finder.class, "Finder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFinder_Name(), ecorePackage.getEString(), "name", null, 1, 1, Finder.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getFinder_Entity(), this.getEntity(), this.getEntity_OwnedFinders(), "entity", null, 1, 1, Finder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFinder_CustomizedName(), ecorePackage.getEString(), "customizedName", null, 0, 1, Finder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFinder_Criterions(), this.getCriterion(), null, "criterions", null, 0, -1, Finder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFinder_Multiplicity(), theEnvironmentPackage.getMultiplicityKind(), "multiplicity", null, 1, 1, Finder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(internalCriterionEClass, InternalCriterion.class, "InternalCriterion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInternalCriterion_Target(), theEnvironmentPackage.getAttribute(), null, "target", null, 1, 1, InternalCriterion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInternalCriterion_Name(), ecorePackage.getEString(), "name", null, 1, 1, InternalCriterion.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(criterionEClass, Criterion.class, "Criterion", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(externalCriterionEClass, ExternalCriterion.class, "ExternalCriterion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExternalCriterion_Name(), ecorePackage.getEString(), "name", null, 1, 1, ExternalCriterion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExternalCriterion_Type(), theEnvironmentPackage.getType(), null, "type", null, 1, 1, ExternalCriterion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(inheritanceKindEEnum, InheritanceKind.class, "InheritanceKind");
		addEEnumLiteral(inheritanceKindEEnum, InheritanceKind.TABLE_PER_SUBCLASS_LITERAL);
		addEEnumLiteral(inheritanceKindEEnum, InheritanceKind.TABLE_PER_CLASS_HIERARCHY_LITERAL);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
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
		  (getRoot_Name(),
		   source,
		   new String[] {
			   "documentation", "The name of the root."
		   });
		addAnnotation
		  (getEntity_EstimatedVolumetry(),
		   source,
		   new String[] {
			   "documentation", "The estimated volumetry"
		   });
		addAnnotation
		  (getEntity_EstimatedAccess(),
		   source,
		   new String[] {
			   "documentation", "The estimated accesses."
		   });
		addAnnotation
		  (getEntity_Historized(),
		   source,
		   new String[] {
			   "documentation", "Tells if historized"
		   });
		addAnnotation
		  (getEntity_OwnedFinders(),
		   source,
		   new String[] {
			   "documentation", "The list of finders."
		   });
		addAnnotation
		  (getEntity_InheritanceKind(),
		   source,
		   new String[] {
			   "documentation", "The inheritance kind."
		   });
		addAnnotation
		  (getFinder_Name(),
		   source,
		   new String[] {
			   "documentation", "The name of the finder."
		   });
		addAnnotation
		  (getFinder_Entity(),
		   source,
		   new String[] {
			   "documentation", "The entity."
		   });
		addAnnotation
		  (getFinder_CustomizedName(),
		   source,
		   new String[] {
			   "documentation", "The customized name."
		   });
		addAnnotation
		  (getFinder_Criterions(),
		   source,
		   new String[] {
			   "documentation", "The list of criterions."
		   });
		addAnnotation
		  (getFinder_Multiplicity(),
		   source,
		   new String[] {
			   "documentation", "The multiplicity."
		   });
		addAnnotation
		  (getInternalCriterion_Target(),
		   source,
		   new String[] {
			   "documentation", "The target of the internal criterion."
		   });
		addAnnotation
		  (getInternalCriterion_Name(),
		   source,
		   new String[] {
			   "documentation", "The name."
		   });
		addAnnotation
		  (getExternalCriterion_Name(),
		   source,
		   new String[] {
			   "documentation", "The name."
		   });
		addAnnotation
		  (getExternalCriterion_Type(),
		   source,
		   new String[] {
			   "documentation", "The type."
		   });
	}

} // EntityPackageImpl
