/**
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.manifest.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.sirius.viewpoint.ViewpointPackage;

import org.obeonetwork.dsl.manifest.BadVersionStringException;
import org.obeonetwork.dsl.manifest.MImportExportData;
import org.obeonetwork.dsl.manifest.MManifest;
import org.obeonetwork.dsl.manifest.ManifestFactory;
import org.obeonetwork.dsl.manifest.ManifestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ManifestPackageImpl extends EPackageImpl implements ManifestPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2017 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mManifestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mImportExportDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType badVersionStringExceptionEDataType = null;

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
	 * @see org.obeonetwork.dsl.manifest.ManifestPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ManifestPackageImpl() {
		super(eNS_URI, ManifestFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ManifestPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ManifestPackage init() {
		if (isInited) return (ManifestPackage)EPackage.Registry.INSTANCE.getEPackage(ManifestPackage.eNS_URI);

		// Obtain or create and register package
		ManifestPackageImpl theManifestPackage = (ManifestPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ManifestPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ManifestPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ViewpointPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theManifestPackage.createPackageContents();

		// Initialize created meta-data
		theManifestPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theManifestPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ManifestPackage.eNS_URI, theManifestPackage);
		return theManifestPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMManifest() {
		return mManifestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMManifest_ProjectId() {
		return (EAttribute)mManifestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMManifest_CreationDate() {
		return (EAttribute)mManifestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMManifest_VersionMajor() {
		return (EAttribute)mManifestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMManifest_VersionMinor() {
		return (EAttribute)mManifestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMManifest_VersionPatch() {
		return (EAttribute)mManifestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMManifest_VersionQualifier() {
		return (EAttribute)mManifestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMManifest_Comment() {
		return (EAttribute)mManifestEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMManifest_Dependencies() {
		return (EReference)mManifestEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMImportExportData() {
		return mImportExportDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMImportExportData_ExportedManifests() {
		return (EReference)mImportExportDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMImportExportData_ImportedManifests() {
		return (EReference)mImportExportDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMImportExportData_Dependencies() {
		return (EReference)mImportExportDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getBadVersionStringException() {
		return badVersionStringExceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManifestFactory getManifestFactory() {
		return (ManifestFactory)getEFactoryInstance();
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
		mManifestEClass = createEClass(MMANIFEST);
		createEAttribute(mManifestEClass, MMANIFEST__PROJECT_ID);
		createEAttribute(mManifestEClass, MMANIFEST__CREATION_DATE);
		createEAttribute(mManifestEClass, MMANIFEST__VERSION_MAJOR);
		createEAttribute(mManifestEClass, MMANIFEST__VERSION_MINOR);
		createEAttribute(mManifestEClass, MMANIFEST__VERSION_PATCH);
		createEAttribute(mManifestEClass, MMANIFEST__VERSION_QUALIFIER);
		createEAttribute(mManifestEClass, MMANIFEST__COMMENT);
		createEReference(mManifestEClass, MMANIFEST__DEPENDENCIES);

		mImportExportDataEClass = createEClass(MIMPORT_EXPORT_DATA);
		createEReference(mImportExportDataEClass, MIMPORT_EXPORT_DATA__EXPORTED_MANIFESTS);
		createEReference(mImportExportDataEClass, MIMPORT_EXPORT_DATA__IMPORTED_MANIFESTS);
		createEReference(mImportExportDataEClass, MIMPORT_EXPORT_DATA__DEPENDENCIES);

		// Create data types
		badVersionStringExceptionEDataType = createEDataType(BAD_VERSION_STRING_EXCEPTION);
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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		ViewpointPackage theViewpointPackage = (ViewpointPackage)EPackage.Registry.INSTANCE.getEPackage(ViewpointPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		mImportExportDataEClass.getESuperTypes().add(theViewpointPackage.getDFeatureExtension());

		// Initialize classes and features; add operations and parameters
		initEClass(mManifestEClass, MManifest.class, "MManifest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMManifest_ProjectId(), ecorePackage.getEString(), "projectId", null, 0, 1, MManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMManifest_CreationDate(), ecorePackage.getEDate(), "creationDate", null, 0, 1, MManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMManifest_VersionMajor(), ecorePackage.getEInt(), "versionMajor", null, 0, 1, MManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMManifest_VersionMinor(), ecorePackage.getEInt(), "versionMinor", null, 0, 1, MManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMManifest_VersionPatch(), theEcorePackage.getEInt(), "versionPatch", null, 0, 1, MManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMManifest_VersionQualifier(), ecorePackage.getEString(), "versionQualifier", null, 0, 1, MManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMManifest_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, MManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMManifest_Dependencies(), this.getMManifest(), null, "dependencies", null, 0, -1, MManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(mManifestEClass, theEcorePackage.getEString(), "getVersion", 1, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = addEOperation(mManifestEClass, null, "setVersion", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "versionAsString", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getBadVersionStringException());

		initEClass(mImportExportDataEClass, MImportExportData.class, "MImportExportData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMImportExportData_ExportedManifests(), this.getMManifest(), null, "exportedManifests", null, 0, -1, MImportExportData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMImportExportData_ImportedManifests(), this.getMManifest(), null, "importedManifests", null, 0, -1, MImportExportData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMImportExportData_Dependencies(), this.getMManifest(), null, "dependencies", null, 0, -1, MImportExportData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(badVersionStringExceptionEDataType, BadVersionStringException.class, "BadVersionStringException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ManifestPackageImpl
