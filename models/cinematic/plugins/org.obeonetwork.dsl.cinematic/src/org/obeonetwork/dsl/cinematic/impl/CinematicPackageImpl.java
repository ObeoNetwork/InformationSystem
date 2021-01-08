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
package org.obeonetwork.dsl.cinematic.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.obeonetwork.dsl.cinematic.AbstractPackage;
import org.obeonetwork.dsl.cinematic.CinematicElement;
import org.obeonetwork.dsl.cinematic.CinematicFactory;
import org.obeonetwork.dsl.cinematic.CinematicPackage;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.Event;
import org.obeonetwork.dsl.cinematic.NamedElement;
import org.obeonetwork.dsl.cinematic.flow.FlowPackage;
import org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl;
import org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage;
import org.obeonetwork.dsl.cinematic.toolkits.impl.ToolkitsPackageImpl;
import org.obeonetwork.dsl.cinematic.view.ViewPackage;
import org.obeonetwork.dsl.cinematic.view.impl.ViewPackageImpl;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.technicalid.TechnicalIDPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CinematicPackageImpl extends EPackageImpl implements CinematicPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractPackageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cinematicRootEClass = null;

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
	private EClass eventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cinematicElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageEClass = null;

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
	 * @see org.obeonetwork.dsl.cinematic.CinematicPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CinematicPackageImpl() {
		super(eNS_URI, CinematicFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CinematicPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CinematicPackage init() {
		if (isInited) return (CinematicPackage)EPackage.Registry.INSTANCE.getEPackage(CinematicPackage.eNS_URI);

		// Obtain or create and register package
		CinematicPackageImpl theCinematicPackage = (CinematicPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CinematicPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CinematicPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EnvironmentPackage.eINSTANCE.eClass();
		TechnicalIDPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ViewPackageImpl theViewPackage = (ViewPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ViewPackage.eNS_URI) instanceof ViewPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ViewPackage.eNS_URI) : ViewPackage.eINSTANCE);
		FlowPackageImpl theFlowPackage = (FlowPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FlowPackage.eNS_URI) instanceof FlowPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FlowPackage.eNS_URI) : FlowPackage.eINSTANCE);
		ToolkitsPackageImpl theToolkitsPackage = (ToolkitsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ToolkitsPackage.eNS_URI) instanceof ToolkitsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ToolkitsPackage.eNS_URI) : ToolkitsPackage.eINSTANCE);

		// Create package meta-data objects
		theCinematicPackage.createPackageContents();
		theViewPackage.createPackageContents();
		theFlowPackage.createPackageContents();
		theToolkitsPackage.createPackageContents();

		// Initialize created meta-data
		theCinematicPackage.initializePackageContents();
		theViewPackage.initializePackageContents();
		theFlowPackage.initializePackageContents();
		theToolkitsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCinematicPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CinematicPackage.eNS_URI, theCinematicPackage);
		return theCinematicPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractPackage() {
		return abstractPackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractPackage_Flows() {
		return (EReference)abstractPackageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractPackage_ViewContainers() {
		return (EReference)abstractPackageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractPackage_SubPackages() {
		return (EReference)abstractPackageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCinematicRoot() {
		return cinematicRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCinematicRoot_Toolkits() {
		return (EReference)cinematicRootEClass.getEStructuralFeatures().get(0);
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
	public EClass getEvent() {
		return eventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCinematicElement() {
		return cinematicElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackage() {
		return packageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CinematicFactory getCinematicFactory() {
		return (CinematicFactory)getEFactoryInstance();
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
		cinematicElementEClass = createEClass(CINEMATIC_ELEMENT);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		abstractPackageEClass = createEClass(ABSTRACT_PACKAGE);
		createEReference(abstractPackageEClass, ABSTRACT_PACKAGE__FLOWS);
		createEReference(abstractPackageEClass, ABSTRACT_PACKAGE__VIEW_CONTAINERS);
		createEReference(abstractPackageEClass, ABSTRACT_PACKAGE__SUB_PACKAGES);

		packageEClass = createEClass(PACKAGE);

		cinematicRootEClass = createEClass(CINEMATIC_ROOT);
		createEReference(cinematicRootEClass, CINEMATIC_ROOT__TOOLKITS);

		eventEClass = createEClass(EVENT);
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
		ViewPackage theViewPackage = (ViewPackage)EPackage.Registry.INSTANCE.getEPackage(ViewPackage.eNS_URI);
		FlowPackage theFlowPackage = (FlowPackage)EPackage.Registry.INSTANCE.getEPackage(FlowPackage.eNS_URI);
		ToolkitsPackage theToolkitsPackage = (ToolkitsPackage)EPackage.Registry.INSTANCE.getEPackage(ToolkitsPackage.eNS_URI);
		EnvironmentPackage theEnvironmentPackage = (EnvironmentPackage)EPackage.Registry.INSTANCE.getEPackage(EnvironmentPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theViewPackage);
		getESubpackages().add(theFlowPackage);
		getESubpackages().add(theToolkitsPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		cinematicElementEClass.getESuperTypes().add(theEnvironmentPackage.getObeoDSMObject());
		namedElementEClass.getESuperTypes().add(this.getCinematicElement());
		abstractPackageEClass.getESuperTypes().add(this.getNamedElement());
		packageEClass.getESuperTypes().add(this.getAbstractPackage());
		cinematicRootEClass.getESuperTypes().add(this.getAbstractPackage());
		eventEClass.getESuperTypes().add(this.getNamedElement());

		// Initialize classes and features; add operations and parameters
		initEClass(cinematicElementEClass, CinematicElement.class, "CinematicElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractPackageEClass, AbstractPackage.class, "AbstractPackage", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractPackage_Flows(), theFlowPackage.getFlow(), null, "flows", null, 0, -1, AbstractPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractPackage_ViewContainers(), theViewPackage.getViewContainer(), null, "viewContainers", null, 0, -1, AbstractPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractPackage_SubPackages(), this.getPackage(), null, "subPackages", null, 0, -1, AbstractPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packageEClass, org.obeonetwork.dsl.cinematic.Package.class, "Package", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cinematicRootEClass, CinematicRoot.class, "CinematicRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCinematicRoot_Toolkits(), theToolkitsPackage.getToolkit(), null, "toolkits", null, 0, -1, CinematicRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventEClass, Event.class, "Event", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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
		  (getNamedElement_Name(), 
		   source, 
		   new String[] {
			 "documentation", "The name of this model element."
		   });	
		addAnnotation
		  (getAbstractPackage_Flows(), 
		   source, 
		   new String[] {
			 "documentation", "List of the Flows contained in this package."
		   });	
		addAnnotation
		  (getAbstractPackage_ViewContainers(), 
		   source, 
		   new String[] {
			 "documentation", "List of the View Containers contained in this package."
		   });	
		addAnnotation
		  (getAbstractPackage_SubPackages(), 
		   source, 
		   new String[] {
			 "documentation", "List of the Packages contained in this packages (only the directly contained ones)."
		   });	
		addAnnotation
		  (getCinematicRoot_Toolkits(), 
		   source, 
		   new String[] {
			 "documentation", "List of the Toolkits defined on this Cinematic Root."
		   });
	}

} //CinematicPackageImpl
