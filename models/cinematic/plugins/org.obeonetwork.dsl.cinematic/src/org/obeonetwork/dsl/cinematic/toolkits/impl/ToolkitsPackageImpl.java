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
package org.obeonetwork.dsl.cinematic.toolkits.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.obeonetwork.dsl.cinematic.CinematicPackage;
import org.obeonetwork.dsl.cinematic.flow.FlowPackage;
import org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl;
import org.obeonetwork.dsl.cinematic.impl.CinematicPackageImpl;
import org.obeonetwork.dsl.cinematic.toolkits.CardinalPosition;
import org.obeonetwork.dsl.cinematic.toolkits.HorizontalAlignment;
import org.obeonetwork.dsl.cinematic.toolkits.Style;
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass styleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum cardinalPositionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum horizontalAlignmentEEnum = null;

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
		Object registeredToolkitsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ToolkitsPackageImpl theToolkitsPackage = registeredToolkitsPackage instanceof ToolkitsPackageImpl ? (ToolkitsPackageImpl)registeredToolkitsPackage : new ToolkitsPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EnvironmentPackage.eINSTANCE.eClass();
		TechnicalIDPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(CinematicPackage.eNS_URI);
		CinematicPackageImpl theCinematicPackage = (CinematicPackageImpl)(registeredPackage instanceof CinematicPackageImpl ? registeredPackage : CinematicPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ViewPackage.eNS_URI);
		ViewPackageImpl theViewPackage = (ViewPackageImpl)(registeredPackage instanceof ViewPackageImpl ? registeredPackage : ViewPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(FlowPackage.eNS_URI);
		FlowPackageImpl theFlowPackage = (FlowPackageImpl)(registeredPackage instanceof FlowPackageImpl ? registeredPackage : FlowPackage.eINSTANCE);

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
	public EReference getWidget_Style() {
		return (EReference)widgetEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWidget_MetadataHelp() {
		return (EAttribute)widgetEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWidget_Summary() {
		return (EAttribute)widgetEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWidget_Documentation() {
		return (EAttribute)widgetEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWidget_MetadataDefinitions() {
		return (EReference)widgetEClass.getEStructuralFeatures().get(10);
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
	public EClass getStyle() {
		return styleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStyle_Decorator() {
		return (EAttribute)styleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStyle_DecoratorPosition() {
		return (EAttribute)styleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStyle_DecoratorVFill() {
		return (EAttribute)styleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStyle_DecoratorHFill() {
		return (EAttribute)styleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStyle_Bordered() {
		return (EAttribute)styleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStyle_RoundedCorners() {
		return (EAttribute)styleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStyle_FontColor() {
		return (EAttribute)styleEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStyle_FontUnderlined() {
		return (EAttribute)styleEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStyle_LabelHAlignment() {
		return (EAttribute)styleEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStyle_DefaultWidth() {
		return (EAttribute)styleEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStyle_DefaultHeight() {
		return (EAttribute)styleEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStyle_ExampleExpression() {
		return (EAttribute)styleEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStyle_LabelHidden() {
		return (EAttribute)styleEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCardinalPosition() {
		return cardinalPositionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getHorizontalAlignment() {
		return horizontalAlignmentEEnum;
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
		createEReference(widgetEClass, WIDGET__STYLE);
		createEAttribute(widgetEClass, WIDGET__METADATA_HELP);
		createEAttribute(widgetEClass, WIDGET__SUMMARY);
		createEAttribute(widgetEClass, WIDGET__DOCUMENTATION);
		createEReference(widgetEClass, WIDGET__METADATA_DEFINITIONS);

		widgetEventTypeEClass = createEClass(WIDGET_EVENT_TYPE);
		createEAttribute(widgetEventTypeEClass, WIDGET_EVENT_TYPE__NAME);

		styleEClass = createEClass(STYLE);
		createEAttribute(styleEClass, STYLE__DECORATOR);
		createEAttribute(styleEClass, STYLE__DECORATOR_POSITION);
		createEAttribute(styleEClass, STYLE__DECORATOR_VFILL);
		createEAttribute(styleEClass, STYLE__DECORATOR_HFILL);
		createEAttribute(styleEClass, STYLE__BORDERED);
		createEAttribute(styleEClass, STYLE__ROUNDED_CORNERS);
		createEAttribute(styleEClass, STYLE__FONT_COLOR);
		createEAttribute(styleEClass, STYLE__FONT_UNDERLINED);
		createEAttribute(styleEClass, STYLE__LABEL_HALIGNMENT);
		createEAttribute(styleEClass, STYLE__DEFAULT_WIDTH);
		createEAttribute(styleEClass, STYLE__DEFAULT_HEIGHT);
		createEAttribute(styleEClass, STYLE__EXAMPLE_EXPRESSION);
		createEAttribute(styleEClass, STYLE__LABEL_HIDDEN);

		// Create enums
		cardinalPositionEEnum = createEEnum(CARDINAL_POSITION);
		horizontalAlignmentEEnum = createEEnum(HORIZONTAL_ALIGNMENT);
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
		EnvironmentPackage theEnvironmentPackage = (EnvironmentPackage)EPackage.Registry.INSTANCE.getEPackage(EnvironmentPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		toolkitEClass.getESuperTypes().add(theTechnicalIDPackage.getIdentifiable());
		widgetEClass.getESuperTypes().add(theTechnicalIDPackage.getIdentifiable());
		widgetEventTypeEClass.getESuperTypes().add(theTechnicalIDPackage.getIdentifiable());
		styleEClass.getESuperTypes().add(theTechnicalIDPackage.getIdentifiable());

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
		initEReference(getWidget_Style(), this.getStyle(), null, "style", null, 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWidget_MetadataHelp(), ecorePackage.getEString(), "metadataHelp", null, 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWidget_Summary(), ecorePackage.getEString(), "summary", null, 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWidget_Documentation(), ecorePackage.getEString(), "documentation", null, 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWidget_MetadataDefinitions(), theEnvironmentPackage.getAnnotation(), null, "metadataDefinitions", null, 0, -1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(widgetEventTypeEClass, WidgetEventType.class, "WidgetEventType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWidgetEventType_Name(), ecorePackage.getEString(), "name", null, 1, 1, WidgetEventType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(styleEClass, Style.class, "Style", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStyle_Decorator(), ecorePackage.getEString(), "decorator", null, 0, 1, Style.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStyle_DecoratorPosition(), this.getCardinalPosition(), "decoratorPosition", null, 0, 1, Style.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStyle_DecoratorVFill(), ecorePackage.getEBoolean(), "decoratorVFill", "true", 0, 1, Style.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStyle_DecoratorHFill(), ecorePackage.getEBoolean(), "decoratorHFill", null, 0, 1, Style.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStyle_Bordered(), ecorePackage.getEBoolean(), "bordered", "true", 0, 1, Style.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStyle_RoundedCorners(), ecorePackage.getEBoolean(), "roundedCorners", null, 0, 1, Style.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStyle_FontColor(), ecorePackage.getEString(), "fontColor", null, 0, 1, Style.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStyle_FontUnderlined(), ecorePackage.getEBoolean(), "fontUnderlined", "false", 0, 1, Style.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStyle_LabelHAlignment(), this.getHorizontalAlignment(), "labelHAlignment", null, 0, 1, Style.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStyle_DefaultWidth(), ecorePackage.getEInt(), "defaultWidth", null, 0, 1, Style.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStyle_DefaultHeight(), ecorePackage.getEInt(), "defaultHeight", null, 0, 1, Style.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStyle_ExampleExpression(), ecorePackage.getEString(), "exampleExpression", null, 0, 1, Style.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStyle_LabelHidden(), ecorePackage.getEBoolean(), "labelHidden", "false", 0, 1, Style.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(cardinalPositionEEnum, CardinalPosition.class, "CardinalPosition");
		addEEnumLiteral(cardinalPositionEEnum, CardinalPosition.WEST);
		addEEnumLiteral(cardinalPositionEEnum, CardinalPosition.EAST);
		addEEnumLiteral(cardinalPositionEEnum, CardinalPosition.NORTH_WEST);
		addEEnumLiteral(cardinalPositionEEnum, CardinalPosition.NORTH_EAST);

		initEEnum(horizontalAlignmentEEnum, HorizontalAlignment.class, "HorizontalAlignment");
		addEEnumLiteral(horizontalAlignmentEEnum, HorizontalAlignment.CENTER);
		addEEnumLiteral(horizontalAlignmentEEnum, HorizontalAlignment.LEFT);
		addEEnumLiteral(horizontalAlignmentEEnum, HorizontalAlignment.RIGHT);

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
		addAnnotation
		  (getStyle_ExampleExpression(),
		   source,
		   new String[] {
			   "documentation", "AQL expression evaluated in the context of the AbstractViewElement that uses this Widget, and which provides the label that should be displayed in the diagram when using the \"example\" layer."
		   });
	}

} //ToolkitsPackageImpl
