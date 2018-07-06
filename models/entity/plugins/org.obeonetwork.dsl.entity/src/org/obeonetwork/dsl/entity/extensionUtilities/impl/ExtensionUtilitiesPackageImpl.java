/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.entity.extensionUtilities.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.entity.extensionUtilities.EntityFilter;
import org.obeonetwork.dsl.entity.extensionUtilities.ExtensionUtilitiesFactory;
import org.obeonetwork.dsl.entity.extensionUtilities.ExtensionUtilitiesPackage;
import org.obeonetwork.dsl.entity.impl.EntityPackageImpl;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.technicalid.TechnicalIDPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class ExtensionUtilitiesPackageImpl extends EPackageImpl implements
		ExtensionUtilitiesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2017 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityFilterEClass = null;

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
	 * @see org.obeonetwork.dsl.entity.extensionUtilities.ExtensionUtilitiesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExtensionUtilitiesPackageImpl() {
		super(eNS_URI, ExtensionUtilitiesFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ExtensionUtilitiesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExtensionUtilitiesPackage init() {
		if (isInited) return (ExtensionUtilitiesPackage)EPackage.Registry.INSTANCE.getEPackage(ExtensionUtilitiesPackage.eNS_URI);

		// Obtain or create and register package
		ExtensionUtilitiesPackageImpl theExtensionUtilitiesPackage = (ExtensionUtilitiesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ExtensionUtilitiesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExtensionUtilitiesPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EnvironmentPackage.eINSTANCE.eClass();
		TechnicalIDPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		EntityPackageImpl theEntityPackage = (EntityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI) instanceof EntityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI) : EntityPackage.eINSTANCE);

		// Create package meta-data objects
		theExtensionUtilitiesPackage.createPackageContents();
		theEntityPackage.createPackageContents();

		// Initialize created meta-data
		theExtensionUtilitiesPackage.initializePackageContents();
		theEntityPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExtensionUtilitiesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ExtensionUtilitiesPackage.eNS_URI, theExtensionUtilitiesPackage);
		return theExtensionUtilitiesPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityFilter() {
		return entityFilterEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityFilter_AttributeReferences() {
		return (EReference)entityFilterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityFilter_ReferenceReferences() {
		return (EReference)entityFilterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityFilter_OwnedPropertyReferences() {
		return (EReference)entityFilterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityFilter_Entity() {
		return (EReference)entityFilterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionUtilitiesFactory getExtensionUtilitiesFactory() {
		return (ExtensionUtilitiesFactory)getEFactoryInstance();
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
		entityFilterEClass = createEClass(ENTITY_FILTER);
		createEReference(entityFilterEClass, ENTITY_FILTER__ATTRIBUTE_REFERENCES);
		createEReference(entityFilterEClass, ENTITY_FILTER__REFERENCE_REFERENCES);
		createEReference(entityFilterEClass, ENTITY_FILTER__OWNED_PROPERTY_REFERENCES);
		createEReference(entityFilterEClass, ENTITY_FILTER__ENTITY);
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
		EnvironmentPackage theEnvironmentPackage = (EnvironmentPackage)EPackage.Registry.INSTANCE.getEPackage(EnvironmentPackage.eNS_URI);
		EntityPackage theEntityPackage = (EntityPackage)EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		entityFilterEClass.getESuperTypes().add(theEnvironmentPackage.getFilter());

		// Initialize classes and features; add operations and parameters
		initEClass(entityFilterEClass, EntityFilter.class, "EntityFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntityFilter_AttributeReferences(), theEnvironmentPackage.getAttribute(), null, "attributeReferences", null, 0, -1, EntityFilter.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getEntityFilter_ReferenceReferences(), theEnvironmentPackage.getReference(), null, "referenceReferences", null, 0, -1, EntityFilter.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getEntityFilter_OwnedPropertyReferences(), theEnvironmentPackage.getProperty(), null, "ownedPropertyReferences", null, 0, -1, EntityFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntityFilter_Entity(), theEntityPackage.getEntity(), null, "entity", null, 1, 1, EntityFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} // ExtensionUtilitiesPackageImpl
