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
package org.obeonetwork.dsl.cinematic.toolkits.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.obeonetwork.dsl.cinematic.CinematicPackage;
import org.obeonetwork.dsl.cinematic.flow.FlowPackage;
import org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl;
import org.obeonetwork.dsl.cinematic.impl.CinematicPackageImpl;
import org.obeonetwork.dsl.cinematic.toolkits.Toolkit;
import org.obeonetwork.dsl.cinematic.toolkits.ToolkitsFactory;
import org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage;
import org.obeonetwork.dsl.cinematic.toolkits.Widget;
import org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType;
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
public class ToolkitsPackageImpl extends EPackageImpl implements ToolkitsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toolkitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass widgetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass widgetEventTypeEClass = null;

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
	 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ToolkitsPackageImpl() {
		super(eNS_URI, ToolkitsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ToolkitsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ToolkitsPackage init() {
		if (isInited) return (ToolkitsPackage)EPackage.Registry.INSTANCE.getEPackage(ToolkitsPackage.eNS_URI);

		// Obtain or create and register package
		ToolkitsPackageImpl theToolkitsPackage = (ToolkitsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ToolkitsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ToolkitsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EnvironmentPackage.eINSTANCE.eClass();
		TechnicalIDPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CinematicPackageImpl theCinematicPackage = (CinematicPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CinematicPackage.eNS_URI) instanceof CinematicPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CinematicPackage.eNS_URI) : CinematicPackage.eINSTANCE);
		ViewPackageImpl theViewPackage = (ViewPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ViewPackage.eNS_URI) instanceof ViewPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ViewPackage.eNS_URI) : ViewPackage.eINSTANCE);
		FlowPackageImpl theFlowPackage = (FlowPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FlowPackage.eNS_URI) instanceof FlowPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FlowPackage.eNS_URI) : FlowPackage.eINSTANCE);

		// Create package meta-data objects
		theToolkitsPackage.createPackageContents();
		theCinematicPackage.createPackageContents();
		theViewPackage.createPackageContents();
		theFlowPackage.createPackageContents();

		// Initialize created meta-data
		theToolkitsPackage.initializePackageContents();
		theCinematicPackage.initializePackageContents();
		theViewPackage.initializePackageContents();
		theFlowPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theToolkitsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ToolkitsPackage.eNS_URI, theToolkitsPackage);
		return theToolkitsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getToolkit() {
		return toolkitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToolkit_Widgets() {
		return (EReference)toolkitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getToolkit_Name() {
		return (EAttribute)toolkitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWidget() {
		return widgetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWidget_Name() {
		return (EAttribute)widgetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWidget_Icon() {
		return (EAttribute)widgetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWidget_Implementation() {
		return (EAttribute)widgetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWidget_Toolkit() {
		return (EReference)widgetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWidget_PossibleEvents() {
		return (EReference)widgetEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWidget_IsContainer() {
		return (EAttribute)widgetEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWidgetEventType() {
		return widgetEventTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWidgetEventType_Name() {
		return (EAttribute)widgetEventTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToolkitsFactory getToolkitsFactory() {
		return (ToolkitsFactory)getEFactoryInstance();
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
		toolkitEClass = createEClass(TOOLKIT);
		createEReference(toolkitEClass, TOOLKIT__WIDGETS);
		createEAttribute(toolkitEClass, TOOLKIT__NAME);

		widgetEClass = createEClass(WIDGET);
		createEAttribute(widgetEClass, WIDGET__NAME);
		createEAttribute(widgetEClass, WIDGET__ICON);
		createEAttribute(widgetEClass, WIDGET__IMPLEMENTATION);
		createEReference(widgetEClass, WIDGET__TOOLKIT);
		createEReference(widgetEClass, WIDGET__POSSIBLE_EVENTS);
		createEAttribute(widgetEClass, WIDGET__IS_CONTAINER);

		widgetEventTypeEClass = createEClass(WIDGET_EVENT_TYPE);
		createEAttribute(widgetEventTypeEClass, WIDGET_EVENT_TYPE__NAME);
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
		toolkitEClass.getESuperTypes().add(theTechnicalIDPackage.getIdentifiable());
		widgetEClass.getESuperTypes().add(theTechnicalIDPackage.getIdentifiable());
		widgetEventTypeEClass.getESuperTypes().add(theTechnicalIDPackage.getIdentifiable());

		// Initialize classes and features; add operations and parameters
		initEClass(toolkitEClass, Toolkit.class, "Toolkit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getToolkit_Widgets(), this.getWidget(), this.getWidget_Toolkit(), "widgets", null, 0, -1, Toolkit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getToolkit_Name(), ecorePackage.getEString(), "name", null, 1, 1, Toolkit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(widgetEClass, Widget.class, "Widget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWidget_Name(), ecorePackage.getEString(), "name", null, 1, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWidget_Icon(), ecorePackage.getEString(), "icon", null, 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWidget_Implementation(), ecorePackage.getEString(), "implementation", null, 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWidget_Toolkit(), this.getToolkit(), this.getToolkit_Widgets(), "toolkit", null, 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWidget_PossibleEvents(), this.getWidgetEventType(), null, "possibleEvents", null, 0, -1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWidget_IsContainer(), ecorePackage.getEBoolean(), "isContainer", null, 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(widgetEventTypeEClass, WidgetEventType.class, "WidgetEventType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWidgetEventType_Name(), ecorePackage.getEString(), "name", null, 1, 1, WidgetEventType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		  (getToolkit_Widgets(), 
		   source, 
		   new String[] {
			 "documentation", "The widgets owned by this Toolkit."
		   });	
		addAnnotation
		  (getToolkit_Name(), 
		   source, 
		   new String[] {
			 "documentation", "The name of this Toolkit."
		   });	
		addAnnotation
		  (getWidget_Name(), 
		   source, 
		   new String[] {
			 "documentation", "The name of this Widget."
		   });	
		addAnnotation
		  (getWidget_Icon(), 
		   source, 
		   new String[] {
			 "documentation", "The icon path of this widget."
		   });	
		addAnnotation
		  (getWidget_Implementation(), 
		   source, 
		   new String[] {
			 "documentation", "The target implementation of this Widget."
		   });	
		addAnnotation
		  (getWidget_Toolkit(), 
		   source, 
		   new String[] {
			 "documentation", "The Toolkit owning this Widget."
		   });	
		addAnnotation
		  (getWidget_PossibleEvents(), 
		   source, 
		   new String[] {
			 "documentation", "The list of the events this Widget handles."
		   });	
		addAnnotation
		  (getWidget_IsContainer(), 
		   source, 
		   new String[] {
			 "documentation", "True if this Widget is a container."
		   });	
		addAnnotation
		  (getWidgetEventType_Name(), 
		   source, 
		   new String[] {
			 "documentation", "The name of this Widget Event Type."
		   });
	}

} //ToolkitsPackageImpl
