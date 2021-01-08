/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.design.graalfeatureextensions.impl;

import org.eclipse.sirius.viewpoint.ViewpointPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.obeonetwork.graal.GraalPackage;

import org.obeonetwork.graal.design.graalfeatureextensions.GraalfeatureextensionsFactory;
import org.obeonetwork.graal.design.graalfeatureextensions.GraalfeatureextensionsPackage;
import org.obeonetwork.graal.design.graalfeatureextensions.UIConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraalfeatureextensionsPackageImpl extends EPackageImpl implements GraalfeatureextensionsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uiConfigurationEClass = null;

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
	 * @see org.obeonetwork.graal.design.graalfeatureextensions.GraalfeatureextensionsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GraalfeatureextensionsPackageImpl() {
		super(eNS_URI, GraalfeatureextensionsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link GraalfeatureextensionsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GraalfeatureextensionsPackage init() {
		if (isInited) return (GraalfeatureextensionsPackage)EPackage.Registry.INSTANCE.getEPackage(GraalfeatureextensionsPackage.eNS_URI);

		// Obtain or create and register package
		GraalfeatureextensionsPackageImpl theGraalfeatureextensionsPackage = (GraalfeatureextensionsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GraalfeatureextensionsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GraalfeatureextensionsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		GraalPackage.eINSTANCE.eClass();
		ViewpointPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theGraalfeatureextensionsPackage.createPackageContents();

		// Initialize created meta-data
		theGraalfeatureextensionsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGraalfeatureextensionsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GraalfeatureextensionsPackage.eNS_URI, theGraalfeatureextensionsPackage);
		return theGraalfeatureextensionsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUIConfiguration() {
		return uiConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUIConfiguration_ViewpointAnalysis() {
		return (EReference)uiConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUIConfiguration_ActiveUserStories() {
		return (EReference)uiConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraalfeatureextensionsFactory getGraalfeatureextensionsFactory() {
		return (GraalfeatureextensionsFactory)getEFactoryInstance();
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
		uiConfigurationEClass = createEClass(UI_CONFIGURATION);
		createEReference(uiConfigurationEClass, UI_CONFIGURATION__VIEWPOINT_ANALYSIS);
		createEReference(uiConfigurationEClass, UI_CONFIGURATION__ACTIVE_USER_STORIES);
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
		ViewpointPackage theViewpointPackage = (ViewpointPackage)EPackage.Registry.INSTANCE.getEPackage(ViewpointPackage.eNS_URI);
		GraalPackage theGraalPackage = (GraalPackage)EPackage.Registry.INSTANCE.getEPackage(GraalPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		uiConfigurationEClass.getESuperTypes().add(theViewpointPackage.getDFeatureExtension());

		// Initialize classes and features; add operations and parameters
		initEClass(uiConfigurationEClass, UIConfiguration.class, "UIConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUIConfiguration_ViewpointAnalysis(), theViewpointPackage.getDAnalysis(), null, "viewpointAnalysis", null, 0, 1, UIConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUIConfiguration_ActiveUserStories(), theGraalPackage.getUserStory(), null, "activeUserStories", null, 0, -1, UIConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //GraalfeatureextensionsPackageImpl
