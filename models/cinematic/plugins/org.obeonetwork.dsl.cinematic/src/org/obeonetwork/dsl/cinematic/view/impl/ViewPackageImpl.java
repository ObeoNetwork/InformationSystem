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
package org.obeonetwork.dsl.cinematic.view.impl;

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
import org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage;
import org.obeonetwork.dsl.cinematic.toolkits.impl.ToolkitsPackageImpl;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.Layout;
import org.obeonetwork.dsl.cinematic.view.LayoutDirection;
import org.obeonetwork.dsl.cinematic.view.ViewAction;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewContainerReference;
import org.obeonetwork.dsl.cinematic.view.ViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewEvent;
import org.obeonetwork.dsl.cinematic.view.ViewFactory;
import org.obeonetwork.dsl.cinematic.view.ViewHorizontalAlignment;
import org.obeonetwork.dsl.cinematic.view.ViewPackage;
import org.obeonetwork.dsl.cinematic.view.ViewStyle;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.technicalid.TechnicalIDPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ViewPackageImpl extends EPackageImpl implements ViewPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractViewElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewContainerReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layoutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewStyleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum layoutDirectionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum viewHorizontalAlignmentEEnum = null;

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
	 * @see org.obeonetwork.dsl.cinematic.view.ViewPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ViewPackageImpl() {
		super(eNS_URI, ViewFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ViewPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ViewPackage init() {
		if (isInited) return (ViewPackage)EPackage.Registry.INSTANCE.getEPackage(ViewPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredViewPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ViewPackageImpl theViewPackage = registeredViewPackage instanceof ViewPackageImpl ? (ViewPackageImpl)registeredViewPackage : new ViewPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EnvironmentPackage.eINSTANCE.eClass();
		TechnicalIDPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(CinematicPackage.eNS_URI);
		CinematicPackageImpl theCinematicPackage = (CinematicPackageImpl)(registeredPackage instanceof CinematicPackageImpl ? registeredPackage : CinematicPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(FlowPackage.eNS_URI);
		FlowPackageImpl theFlowPackage = (FlowPackageImpl)(registeredPackage instanceof FlowPackageImpl ? registeredPackage : FlowPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ToolkitsPackage.eNS_URI);
		ToolkitsPackageImpl theToolkitsPackage = (ToolkitsPackageImpl)(registeredPackage instanceof ToolkitsPackageImpl ? registeredPackage : ToolkitsPackage.eINSTANCE);

		// Create package meta-data objects
		theViewPackage.createPackageContents();
		theCinematicPackage.createPackageContents();
		theFlowPackage.createPackageContents();
		theToolkitsPackage.createPackageContents();

		// Initialize created meta-data
		theViewPackage.initializePackageContents();
		theCinematicPackage.initializePackageContents();
		theFlowPackage.initializePackageContents();
		theToolkitsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theViewPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ViewPackage.eNS_URI, theViewPackage);
		return theViewPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractViewElement() {
		return abstractViewElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractViewElement_Widget() {
		return (EReference)abstractViewElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractViewElement_Actions() {
		return (EReference)abstractViewElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractViewElement_Events() {
		return (EReference)abstractViewElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractViewElement_Label() {
		return (EAttribute)abstractViewElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractViewElement_ViewStyle() {
		return (EReference)abstractViewElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getViewContainer() {
		return viewContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewContainer_OwnedElements() {
		return (EReference)viewContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewContainer_ViewContainers() {
		return (EReference)viewContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewContainer_ViewElements() {
		return (EReference)viewContainerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewContainer_ViewContainerReferences() {
		return (EReference)viewContainerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewContainer_Layout() {
		return (EReference)viewContainerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getViewElement() {
		return viewElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getViewElement_Required() {
		return (EAttribute)viewElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewElement_Type() {
		return (EReference)viewElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getViewElement_Example() {
		return (EAttribute)viewElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getViewAction() {
		return viewActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getViewEvent() {
		return viewEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewEvent_Type() {
		return (EReference)viewEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getViewContainerReference() {
		return viewContainerReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewContainerReference_ViewContainer() {
		return (EReference)viewContainerReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayout() {
		return layoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayout_X() {
		return (EAttribute)layoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayout_Y() {
		return (EAttribute)layoutEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayout_Width() {
		return (EAttribute)layoutEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayout_Height() {
		return (EAttribute)layoutEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayout_Direction() {
		return (EAttribute)layoutEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayout_ViewElement() {
		return (EReference)layoutEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayout_OwnedLayouts() {
		return (EReference)layoutEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getViewStyle() {
		return viewStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getViewStyle_FontSize() {
		return (EAttribute)viewStyleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getViewStyle_FontColor() {
		return (EAttribute)viewStyleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getViewStyle_LabelHorizontalAlignment() {
		return (EAttribute)viewStyleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLayoutDirection() {
		return layoutDirectionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getViewHorizontalAlignment() {
		return viewHorizontalAlignmentEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewFactory getViewFactory() {
		return (ViewFactory)getEFactoryInstance();
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
		abstractViewElementEClass = createEClass(ABSTRACT_VIEW_ELEMENT);
		createEReference(abstractViewElementEClass, ABSTRACT_VIEW_ELEMENT__WIDGET);
		createEReference(abstractViewElementEClass, ABSTRACT_VIEW_ELEMENT__ACTIONS);
		createEReference(abstractViewElementEClass, ABSTRACT_VIEW_ELEMENT__EVENTS);
		createEAttribute(abstractViewElementEClass, ABSTRACT_VIEW_ELEMENT__LABEL);
		createEReference(abstractViewElementEClass, ABSTRACT_VIEW_ELEMENT__VIEW_STYLE);

		viewContainerEClass = createEClass(VIEW_CONTAINER);
		createEReference(viewContainerEClass, VIEW_CONTAINER__OWNED_ELEMENTS);
		createEReference(viewContainerEClass, VIEW_CONTAINER__VIEW_CONTAINERS);
		createEReference(viewContainerEClass, VIEW_CONTAINER__VIEW_ELEMENTS);
		createEReference(viewContainerEClass, VIEW_CONTAINER__VIEW_CONTAINER_REFERENCES);
		createEReference(viewContainerEClass, VIEW_CONTAINER__LAYOUT);

		viewElementEClass = createEClass(VIEW_ELEMENT);
		createEAttribute(viewElementEClass, VIEW_ELEMENT__REQUIRED);
		createEReference(viewElementEClass, VIEW_ELEMENT__TYPE);
		createEAttribute(viewElementEClass, VIEW_ELEMENT__EXAMPLE);

		viewActionEClass = createEClass(VIEW_ACTION);

		viewEventEClass = createEClass(VIEW_EVENT);
		createEReference(viewEventEClass, VIEW_EVENT__TYPE);

		viewContainerReferenceEClass = createEClass(VIEW_CONTAINER_REFERENCE);
		createEReference(viewContainerReferenceEClass, VIEW_CONTAINER_REFERENCE__VIEW_CONTAINER);

		layoutEClass = createEClass(LAYOUT);
		createEAttribute(layoutEClass, LAYOUT__X);
		createEAttribute(layoutEClass, LAYOUT__Y);
		createEAttribute(layoutEClass, LAYOUT__WIDTH);
		createEAttribute(layoutEClass, LAYOUT__HEIGHT);
		createEAttribute(layoutEClass, LAYOUT__DIRECTION);
		createEReference(layoutEClass, LAYOUT__VIEW_ELEMENT);
		createEReference(layoutEClass, LAYOUT__OWNED_LAYOUTS);

		viewStyleEClass = createEClass(VIEW_STYLE);
		createEAttribute(viewStyleEClass, VIEW_STYLE__FONT_SIZE);
		createEAttribute(viewStyleEClass, VIEW_STYLE__FONT_COLOR);
		createEAttribute(viewStyleEClass, VIEW_STYLE__LABEL_HORIZONTAL_ALIGNMENT);

		// Create enums
		layoutDirectionEEnum = createEEnum(LAYOUT_DIRECTION);
		viewHorizontalAlignmentEEnum = createEEnum(VIEW_HORIZONTAL_ALIGNMENT);
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
		CinematicPackage theCinematicPackage = (CinematicPackage)EPackage.Registry.INSTANCE.getEPackage(CinematicPackage.eNS_URI);
		EnvironmentPackage theEnvironmentPackage = (EnvironmentPackage)EPackage.Registry.INSTANCE.getEPackage(EnvironmentPackage.eNS_URI);
		ToolkitsPackage theToolkitsPackage = (ToolkitsPackage)EPackage.Registry.INSTANCE.getEPackage(ToolkitsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractViewElementEClass.getESuperTypes().add(theCinematicPackage.getNamedElement());
		abstractViewElementEClass.getESuperTypes().add(theEnvironmentPackage.getBoundableElement());
		viewContainerEClass.getESuperTypes().add(this.getAbstractViewElement());
		viewElementEClass.getESuperTypes().add(this.getAbstractViewElement());
		viewActionEClass.getESuperTypes().add(theCinematicPackage.getNamedElement());
		viewEventEClass.getESuperTypes().add(theCinematicPackage.getEvent());
		viewContainerReferenceEClass.getESuperTypes().add(this.getAbstractViewElement());
		viewStyleEClass.getESuperTypes().add(theCinematicPackage.getCinematicElement());

		// Initialize classes and features; add operations and parameters
		initEClass(abstractViewElementEClass, AbstractViewElement.class, "AbstractViewElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractViewElement_Widget(), theToolkitsPackage.getWidget(), null, "widget", null, 0, 1, AbstractViewElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractViewElement_Actions(), this.getViewAction(), null, "actions", null, 0, -1, AbstractViewElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractViewElement_Events(), this.getViewEvent(), null, "events", null, 0, -1, AbstractViewElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractViewElement_Label(), ecorePackage.getEString(), "label", null, 0, 1, AbstractViewElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractViewElement_ViewStyle(), this.getViewStyle(), null, "viewStyle", null, 1, 1, AbstractViewElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(viewContainerEClass, ViewContainer.class, "ViewContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getViewContainer_OwnedElements(), this.getAbstractViewElement(), null, "ownedElements", null, 0, -1, ViewContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getViewContainer_ViewContainers(), this.getViewContainer(), null, "viewContainers", null, 0, -1, ViewContainer.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getViewContainer_ViewElements(), this.getViewElement(), null, "viewElements", null, 0, -1, ViewContainer.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getViewContainer_ViewContainerReferences(), this.getViewContainerReference(), null, "viewContainerReferences", null, 0, -1, ViewContainer.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getViewContainer_Layout(), this.getLayout(), null, "layout", null, 0, 1, ViewContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(viewElementEClass, ViewElement.class, "ViewElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getViewElement_Required(), ecorePackage.getEBoolean(), "required", null, 0, 1, ViewElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getViewElement_Type(), theEnvironmentPackage.getType(), null, "type", null, 0, 1, ViewElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getViewElement_Example(), ecorePackage.getEString(), "example", null, 0, 1, ViewElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(viewActionEClass, ViewAction.class, "ViewAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(viewEventEClass, ViewEvent.class, "ViewEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getViewEvent_Type(), theToolkitsPackage.getWidgetEventType(), null, "type", null, 0, 1, ViewEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(viewContainerReferenceEClass, ViewContainerReference.class, "ViewContainerReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getViewContainerReference_ViewContainer(), this.getViewContainer(), null, "viewContainer", null, 1, 1, ViewContainerReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(layoutEClass, Layout.class, "Layout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLayout_X(), ecorePackage.getEInt(), "x", null, 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayout_Y(), ecorePackage.getEInt(), "y", null, 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayout_Width(), ecorePackage.getEInt(), "width", null, 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayout_Height(), ecorePackage.getEInt(), "height", null, 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayout_Direction(), this.getLayoutDirection(), "direction", null, 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLayout_ViewElement(), this.getAbstractViewElement(), null, "viewElement", null, 0, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLayout_OwnedLayouts(), this.getLayout(), null, "ownedLayouts", null, 0, -1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(viewStyleEClass, ViewStyle.class, "ViewStyle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getViewStyle_FontSize(), ecorePackage.getEInt(), "fontSize", "12", 0, 1, ViewStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getViewStyle_FontColor(), ecorePackage.getEString(), "fontColor", "DEFAULT", 0, 1, ViewStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getViewStyle_LabelHorizontalAlignment(), this.getViewHorizontalAlignment(), "labelHorizontalAlignment", null, 0, 1, ViewStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(layoutDirectionEEnum, LayoutDirection.class, "LayoutDirection");
		addEEnumLiteral(layoutDirectionEEnum, LayoutDirection.VERTICAL);
		addEEnumLiteral(layoutDirectionEEnum, LayoutDirection.HORIZONTAL);

		initEEnum(viewHorizontalAlignmentEEnum, ViewHorizontalAlignment.class, "ViewHorizontalAlignment");
		addEEnumLiteral(viewHorizontalAlignmentEEnum, ViewHorizontalAlignment.DEFAULT);
		addEEnumLiteral(viewHorizontalAlignmentEEnum, ViewHorizontalAlignment.CENTER);
		addEEnumLiteral(viewHorizontalAlignmentEEnum, ViewHorizontalAlignment.LEFT);
		addEEnumLiteral(viewHorizontalAlignmentEEnum, ViewHorizontalAlignment.RIGHT);

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
		  (getAbstractViewElement_Widget(),
		   source,
		   new String[] {
			   "documentation", "The Widget defined for this View Element."
		   });
		addAnnotation
		  (getAbstractViewElement_Actions(),
		   source,
		   new String[] {
			   "documentation", "List of the Actions available on this View Element."
		   });
		addAnnotation
		  (getAbstractViewElement_Events(),
		   source,
		   new String[] {
			   "documentation", "List of the View Events this view can handle."
		   });
		addAnnotation
		  (getAbstractViewElement_Label(),
		   source,
		   new String[] {
			   "documentation", "The label of this View Element."
		   });
		addAnnotation
		  (getViewContainer_OwnedElements(),
		   source,
		   new String[] {
			   "documentation", "List of the directly contained View Containers, View Elements and View Container References."
		   });
		addAnnotation
		  (getViewContainer_ViewContainers(),
		   source,
		   new String[] {
			   "documentation", "List of the directly contained View Containers."
		   });
		addAnnotation
		  (getViewContainer_ViewElements(),
		   source,
		   new String[] {
			   "documentation", "List of the directly contained View Elements."
		   });
		addAnnotation
		  (getViewContainer_ViewContainerReferences(),
		   source,
		   new String[] {
			   "documentation", "List of the directly contained View Container References."
		   });
		addAnnotation
		  (getViewElement_Required(),
		   source,
		   new String[] {
			   "documentation", "Specifies if this View Element is required."
		   });
		addAnnotation
		  (getViewElement_Type(),
		   source,
		   new String[] {
			   "documentation", "The data type this View Element is manipulating."
		   });
		addAnnotation
		  (getViewElement_Example(),
		   source,
		   new String[] {
			   "documentation", "Enables the definition of how a widget can be used in the context of this view element."
		   });
		addAnnotation
		  (getViewEvent_Type(),
		   source,
		   new String[] {
			   "documentation", "The type of the View Event."
		   });
		addAnnotation
		  (getViewContainerReference_ViewContainer(),
		   source,
		   new String[] {
			   "documentation", "The referenced View Container."
		   });
		addAnnotation
		  (layoutEClass,
		   source,
		   new String[] {
			   "documentation", "A Layout owned by a ViewContainer defines the layout of all the recursively owned ViewElements of the ViewContainer.\nIt does not define the layout of the ViewElements owned by referenced ViewContainers.\nThe viewElement reference defines the element on which the size and position attributes applies.\nTherefore, the viewElement of a Layout directly contained in a ViewContainer is this ViewContainer itself.\nA Layout always defines its x, y, width and height attribute values.\nIf a Layout applies to a ViewConainer, then its owned layouts applies to nothing. In this case, an owned layout only defines a compartment of the horizontal or vertical stack.\nIf a Layout applies to nothing, then its owened layouts applies to an element.\nIf a Layout applies to a ViewElement, the direction is meaningless and it cannot own other layouts.\n"
		   });
	}

} //ViewPackageImpl
