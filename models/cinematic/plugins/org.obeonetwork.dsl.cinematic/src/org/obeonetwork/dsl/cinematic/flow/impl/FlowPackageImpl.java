/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.flow.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.obeonetwork.dsl.cinematic.CinematicPackage;
import org.obeonetwork.dsl.cinematic.flow.AbortState;
import org.obeonetwork.dsl.cinematic.flow.ActionState;
import org.obeonetwork.dsl.cinematic.flow.AsyncEventState;
import org.obeonetwork.dsl.cinematic.flow.DecisionState;
import org.obeonetwork.dsl.cinematic.flow.FinalState;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.flow.FlowAction;
import org.obeonetwork.dsl.cinematic.flow.FlowEvent;
import org.obeonetwork.dsl.cinematic.flow.FlowFactory;
import org.obeonetwork.dsl.cinematic.flow.FlowPackage;
import org.obeonetwork.dsl.cinematic.flow.FlowState;
import org.obeonetwork.dsl.cinematic.flow.InitialState;
import org.obeonetwork.dsl.cinematic.flow.NamedFlowState;
import org.obeonetwork.dsl.cinematic.flow.SubflowState;
import org.obeonetwork.dsl.cinematic.flow.Transition;
import org.obeonetwork.dsl.cinematic.flow.ViewState;
import org.obeonetwork.dsl.cinematic.impl.CinematicPackageImpl;
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
public class FlowPackageImpl extends EPackageImpl implements FlowPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedFlowStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass decisionStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subflowStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass initialStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass finalStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass asyncEventStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abortStateEClass = null;

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
	 * @see org.obeonetwork.dsl.cinematic.flow.FlowPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FlowPackageImpl() {
		super(eNS_URI, FlowFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link FlowPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FlowPackage init() {
		if (isInited) return (FlowPackage)EPackage.Registry.INSTANCE.getEPackage(FlowPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredFlowPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		FlowPackageImpl theFlowPackage = registeredFlowPackage instanceof FlowPackageImpl ? (FlowPackageImpl)registeredFlowPackage : new FlowPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EnvironmentPackage.eINSTANCE.eClass();
		TechnicalIDPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(CinematicPackage.eNS_URI);
		CinematicPackageImpl theCinematicPackage = (CinematicPackageImpl)(registeredPackage instanceof CinematicPackageImpl ? registeredPackage : CinematicPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ViewPackage.eNS_URI);
		ViewPackageImpl theViewPackage = (ViewPackageImpl)(registeredPackage instanceof ViewPackageImpl ? registeredPackage : ViewPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ToolkitsPackage.eNS_URI);
		ToolkitsPackageImpl theToolkitsPackage = (ToolkitsPackageImpl)(registeredPackage instanceof ToolkitsPackageImpl ? registeredPackage : ToolkitsPackage.eINSTANCE);

		// Create package meta-data objects
		theFlowPackage.createPackageContents();
		theCinematicPackage.createPackageContents();
		theViewPackage.createPackageContents();
		theToolkitsPackage.createPackageContents();

		// Initialize created meta-data
		theFlowPackage.initializePackageContents();
		theCinematicPackage.initializePackageContents();
		theViewPackage.initializePackageContents();
		theToolkitsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFlowPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FlowPackage.eNS_URI, theFlowPackage);
		return theFlowPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlow() {
		return flowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlow_States() {
		return (EReference)flowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlow_Transitions() {
		return (EReference)flowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlow_Events() {
		return (EReference)flowEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedFlowState() {
		return namedFlowStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowState() {
		return flowStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowState_Actions() {
		return (EReference)flowStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionState() {
		return actionStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getViewState() {
		return viewStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getViewState_NewInstance() {
		return (EAttribute)viewStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getViewState_Refresh() {
		return (EAttribute)viewStateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewState_ViewContainers() {
		return (EReference)viewStateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDecisionState() {
		return decisionStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubflowState() {
		return subflowStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubflowState_Subflow() {
		return (EReference)subflowStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubflowState_Name() {
		return (EAttribute)subflowStateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInitialState() {
		return initialStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFinalState() {
		return finalStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAsyncEventState() {
		return asyncEventStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransition() {
		return transitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransition_Guard() {
		return (EAttribute)transitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransition_Modal() {
		return (EAttribute)transitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransition_To() {
		return (EReference)transitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransition_From() {
		return (EReference)transitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransition_On() {
		return (EReference)transitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowAction() {
		return flowActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowAction_Calls() {
		return (EReference)flowActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowAction_Operations() {
		return (EReference)flowActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowEvent() {
		return flowEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowEvent_Binds() {
		return (EReference)flowEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbortState() {
		return abortStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowFactory getFlowFactory() {
		return (FlowFactory)getEFactoryInstance();
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
		flowEClass = createEClass(FLOW);
		createEReference(flowEClass, FLOW__STATES);
		createEReference(flowEClass, FLOW__TRANSITIONS);
		createEReference(flowEClass, FLOW__EVENTS);

		namedFlowStateEClass = createEClass(NAMED_FLOW_STATE);

		transitionEClass = createEClass(TRANSITION);
		createEAttribute(transitionEClass, TRANSITION__GUARD);
		createEAttribute(transitionEClass, TRANSITION__MODAL);
		createEReference(transitionEClass, TRANSITION__FROM);
		createEReference(transitionEClass, TRANSITION__TO);
		createEReference(transitionEClass, TRANSITION__ON);

		actionStateEClass = createEClass(ACTION_STATE);

		viewStateEClass = createEClass(VIEW_STATE);
		createEAttribute(viewStateEClass, VIEW_STATE__NEW_INSTANCE);
		createEAttribute(viewStateEClass, VIEW_STATE__REFRESH);
		createEReference(viewStateEClass, VIEW_STATE__VIEW_CONTAINERS);

		decisionStateEClass = createEClass(DECISION_STATE);

		subflowStateEClass = createEClass(SUBFLOW_STATE);
		createEReference(subflowStateEClass, SUBFLOW_STATE__SUBFLOW);
		createEAttribute(subflowStateEClass, SUBFLOW_STATE__NAME);

		asyncEventStateEClass = createEClass(ASYNC_EVENT_STATE);

		initialStateEClass = createEClass(INITIAL_STATE);

		abortStateEClass = createEClass(ABORT_STATE);

		finalStateEClass = createEClass(FINAL_STATE);

		flowActionEClass = createEClass(FLOW_ACTION);
		createEReference(flowActionEClass, FLOW_ACTION__CALLS);
		createEReference(flowActionEClass, FLOW_ACTION__OPERATIONS);

		flowEventEClass = createEClass(FLOW_EVENT);
		createEReference(flowEventEClass, FLOW_EVENT__BINDS);

		flowStateEClass = createEClass(FLOW_STATE);
		createEReference(flowStateEClass, FLOW_STATE__ACTIONS);
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
		ViewPackage theViewPackage = (ViewPackage)EPackage.Registry.INSTANCE.getEPackage(ViewPackage.eNS_URI);
		EnvironmentPackage theEnvironmentPackage = (EnvironmentPackage)EPackage.Registry.INSTANCE.getEPackage(EnvironmentPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		flowEClass.getESuperTypes().add(theCinematicPackage.getNamedElement());
		namedFlowStateEClass.getESuperTypes().add(this.getFlowState());
		namedFlowStateEClass.getESuperTypes().add(theCinematicPackage.getNamedElement());
		transitionEClass.getESuperTypes().add(theCinematicPackage.getNamedElement());
		actionStateEClass.getESuperTypes().add(this.getNamedFlowState());
		viewStateEClass.getESuperTypes().add(this.getNamedFlowState());
		decisionStateEClass.getESuperTypes().add(this.getNamedFlowState());
		subflowStateEClass.getESuperTypes().add(this.getFlowState());
		asyncEventStateEClass.getESuperTypes().add(this.getNamedFlowState());
		initialStateEClass.getESuperTypes().add(this.getNamedFlowState());
		abortStateEClass.getESuperTypes().add(this.getNamedFlowState());
		finalStateEClass.getESuperTypes().add(this.getNamedFlowState());
		flowActionEClass.getESuperTypes().add(theCinematicPackage.getNamedElement());
		flowEventEClass.getESuperTypes().add(theCinematicPackage.getEvent());
		flowStateEClass.getESuperTypes().add(theCinematicPackage.getCinematicElement());

		// Initialize classes and features; add operations and parameters
		initEClass(flowEClass, Flow.class, "Flow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFlow_States(), this.getFlowState(), null, "states", null, 0, -1, Flow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFlow_Transitions(), this.getTransition(), null, "transitions", null, 0, -1, Flow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFlow_Events(), this.getFlowEvent(), null, "events", null, 0, -1, Flow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedFlowStateEClass, NamedFlowState.class, "NamedFlowState", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(transitionEClass, Transition.class, "Transition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTransition_Guard(), ecorePackage.getEString(), "guard", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransition_Modal(), ecorePackage.getEBoolean(), "modal", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransition_From(), this.getFlowState(), null, "from", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransition_To(), this.getFlowState(), null, "to", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransition_On(), theCinematicPackage.getEvent(), null, "on", null, 0, -1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionStateEClass, ActionState.class, "ActionState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(viewStateEClass, ViewState.class, "ViewState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getViewState_NewInstance(), ecorePackage.getEBoolean(), "newInstance", null, 0, 1, ViewState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getViewState_Refresh(), ecorePackage.getEBoolean(), "refresh", null, 0, 1, ViewState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getViewState_ViewContainers(), theViewPackage.getViewContainer(), null, "viewContainers", null, 0, -1, ViewState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(decisionStateEClass, DecisionState.class, "DecisionState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(subflowStateEClass, SubflowState.class, "SubflowState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubflowState_Subflow(), this.getFlow(), null, "subflow", null, 1, 1, SubflowState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubflowState_Name(), ecorePackage.getEString(), "name", null, 0, 1, SubflowState.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(asyncEventStateEClass, AsyncEventState.class, "AsyncEventState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(initialStateEClass, InitialState.class, "InitialState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abortStateEClass, AbortState.class, "AbortState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(finalStateEClass, FinalState.class, "FinalState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(flowActionEClass, FlowAction.class, "FlowAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFlowAction_Calls(), theViewPackage.getViewAction(), null, "calls", null, 0, -1, FlowAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFlowAction_Operations(), theEnvironmentPackage.getAction(), null, "operations", null, 0, -1, FlowAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(flowEventEClass, FlowEvent.class, "FlowEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFlowEvent_Binds(), theViewPackage.getViewEvent(), null, "binds", null, 0, -1, FlowEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(flowStateEClass, FlowState.class, "FlowState", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFlowState_Actions(), this.getFlowAction(), null, "actions", null, 0, -1, FlowState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		  (getFlow_States(),
		   source,
		   new String[] {
			   "documentation", "The states of this Flow."
		   });
		addAnnotation
		  (getFlow_Transitions(),
		   source,
		   new String[] {
			   "documentation", "The transitions of this flow."
		   });
		addAnnotation
		  (getFlow_Events(),
		   source,
		   new String[] {
			   "documentation", "The events of this flow."
		   });
		addAnnotation
		  (getTransition_Guard(),
		   source,
		   new String[] {
			   "documentation", "A string defining the guard condition to this Transition."
		   });
		addAnnotation
		  (getTransition_Modal(),
		   source,
		   new String[] {
			   "documentation", "The modality of the transition, expressing transition behaviors that (true) necessarily occur (must modality), (false) possibly occur (may modality)."
		   });
		addAnnotation
		  (getTransition_From(),
		   source,
		   new String[] {
			   "documentation", "The state this transision is originating from."
		   });
		addAnnotation
		  (getTransition_To(),
		   source,
		   new String[] {
			   "documentation", "The state this transition is going to."
		   });
		addAnnotation
		  (getTransition_On(),
		   source,
		   new String[] {
			   "documentation", "The event this transition is bounded to."
		   });
		addAnnotation
		  (getViewState_NewInstance(),
		   source,
		   new String[] {
			   "documentation", "True if this view state instanciates a new view."
		   });
		addAnnotation
		  (getViewState_Refresh(),
		   source,
		   new String[] {
			   "documentation", "True if a refresh should be performed on the view."
		   });
		addAnnotation
		  (getViewState_ViewContainers(),
		   source,
		   new String[] {
			   "documentation", "The view containers this View State is presented by."
		   });
		addAnnotation
		  (getSubflowState_Subflow(),
		   source,
		   new String[] {
			   "documentation", "The Flow this Subflow State refers to."
		   });
		addAnnotation
		  (getSubflowState_Name(),
		   source,
		   new String[] {
			   "documentation", "The name of this Subflow State."
		   });
		addAnnotation
		  (getFlowAction_Calls(),
		   source,
		   new String[] {
			   "documentation", "The View Actions this Flow Action calls."
		   });
		addAnnotation
		  (getFlowAction_Operations(),
		   source,
		   new String[] {
			   "documentation", "The operations this Flow Action calls."
		   });
		addAnnotation
		  (getFlowEvent_Binds(),
		   source,
		   new String[] {
			   "documentation", "The View Events this Flow Event is binded to."
		   });
		addAnnotation
		  (getFlowState_Actions(),
		   source,
		   new String[] {
			   "documentation", "The Flow Actions defined on this Flow State (Flow Actions calling View Actions or Operations)."
		   });
	}

} //FlowPackageImpl
