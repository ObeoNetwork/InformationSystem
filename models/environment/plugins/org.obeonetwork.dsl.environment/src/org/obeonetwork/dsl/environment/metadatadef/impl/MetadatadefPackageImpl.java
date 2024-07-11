/**
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.environment.metadatadef.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.obeonetwork.dsl.environment.EnvironmentPackage;

import org.obeonetwork.dsl.environment.impl.EnvironmentPackageImpl;

import org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinition;
import org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinitions;
import org.obeonetwork.dsl.environment.metadatadef.MetadatadefFactory;
import org.obeonetwork.dsl.environment.metadatadef.MetadatadefPackage;

import org.obeonetwork.dsl.technicalid.TechnicalIDPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetadatadefPackageImpl extends EPackageImpl implements MetadatadefPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2024 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metaDataDefinitionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metaDataDefinitionEClass = null;

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
	 * @see org.obeonetwork.dsl.environment.metadatadef.MetadatadefPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MetadatadefPackageImpl() {
		super(eNS_URI, MetadatadefFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MetadatadefPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MetadatadefPackage init() {
		if (isInited)
			return (MetadatadefPackage) EPackage.Registry.INSTANCE.getEPackage(MetadatadefPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredMetadatadefPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		MetadatadefPackageImpl theMetadatadefPackage = registeredMetadatadefPackage instanceof MetadatadefPackageImpl
				? (MetadatadefPackageImpl) registeredMetadatadefPackage
				: new MetadatadefPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		TechnicalIDPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(EnvironmentPackage.eNS_URI);
		EnvironmentPackageImpl theEnvironmentPackage = (EnvironmentPackageImpl) (registeredPackage instanceof EnvironmentPackageImpl
				? registeredPackage
				: EnvironmentPackage.eINSTANCE);

		// Create package meta-data objects
		theMetadatadefPackage.createPackageContents();
		theEnvironmentPackage.createPackageContents();

		// Initialize created meta-data
		theMetadatadefPackage.initializePackageContents();
		theEnvironmentPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMetadatadefPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MetadatadefPackage.eNS_URI, theMetadatadefPackage);
		return theMetadatadefPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMetaDataDefinitions() {
		return metaDataDefinitionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMetaDataDefinitions_MetaDataDefinitions() {
		return (EReference) metaDataDefinitionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMetaDataDefinition() {
		return metaDataDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetaDataDefinition_Title() {
		return (EAttribute) metaDataDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetaDataDefinition_Body() {
		return (EAttribute) metaDataDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetaDataDefinition_Condition() {
		return (EAttribute) metaDataDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetadatadefFactory getMetadatadefFactory() {
		return (MetadatadefFactory) getEFactoryInstance();
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
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		metaDataDefinitionsEClass = createEClass(META_DATA_DEFINITIONS);
		createEReference(metaDataDefinitionsEClass, META_DATA_DEFINITIONS__META_DATA_DEFINITIONS);

		metaDataDefinitionEClass = createEClass(META_DATA_DEFINITION);
		createEAttribute(metaDataDefinitionEClass, META_DATA_DEFINITION__TITLE);
		createEAttribute(metaDataDefinitionEClass, META_DATA_DEFINITION__BODY);
		createEAttribute(metaDataDefinitionEClass, META_DATA_DEFINITION__CONDITION);
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
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		TechnicalIDPackage theTechnicalIDPackage = (TechnicalIDPackage) EPackage.Registry.INSTANCE
				.getEPackage(TechnicalIDPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		metaDataDefinitionsEClass.getESuperTypes().add(theTechnicalIDPackage.getIdentifiable());
		metaDataDefinitionEClass.getESuperTypes().add(theTechnicalIDPackage.getIdentifiable());

		// Initialize classes and features; add operations and parameters
		initEClass(metaDataDefinitionsEClass, MetaDataDefinitions.class, "MetaDataDefinitions", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetaDataDefinitions_MetaDataDefinitions(), this.getMetaDataDefinition(), null,
				"metaDataDefinitions", null, 0, -1, MetaDataDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metaDataDefinitionEClass, MetaDataDefinition.class, "MetaDataDefinition", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMetaDataDefinition_Title(), ecorePackage.getEString(), "title", null, 0, 1,
				MetaDataDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetaDataDefinition_Body(), ecorePackage.getEString(), "body", null, 0, 1,
				MetaDataDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetaDataDefinition_Condition(), ecorePackage.getEString(), "condition", null, 0, 1,
				MetaDataDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
	}

} //MetadatadefPackageImpl
