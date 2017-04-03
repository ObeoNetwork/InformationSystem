/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.flow;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.obeonetwork.dsl.cinematic.CinematicPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.cinematic.flow.FlowFactory
 * @model kind="package"
 * @generated
 */
public interface FlowPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "flow";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.obeonetwork.org/dsl/cinematic/flow/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cinematic-flow";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FlowPackage eINSTANCE = org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.FlowImpl <em>Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowImpl
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getFlow()
	 * @generated
	 */
	int FLOW = 0;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__TECHNICALID = CinematicPackage.NAMED_ELEMENT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__METADATAS = CinematicPackage.NAMED_ELEMENT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__DESCRIPTION = CinematicPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__KEYWORDS = CinematicPackage.NAMED_ELEMENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__BEHAVIOURS = CinematicPackage.NAMED_ELEMENT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__BINDING_REGISTRIES = CinematicPackage.NAMED_ELEMENT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__VERSION = CinematicPackage.NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__CREATED_ON = CinematicPackage.NAMED_ELEMENT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__MODIFIED_ON = CinematicPackage.NAMED_ELEMENT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__NAME = CinematicPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__STATES = CinematicPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__TRANSITIONS = CinematicPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__EVENTS = CinematicPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_FEATURE_COUNT = CinematicPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.NamedFlowStateImpl <em>Named Flow State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.NamedFlowStateImpl
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getNamedFlowState()
	 * @generated
	 */
	int NAMED_FLOW_STATE = 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.FlowStateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowStateImpl
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getFlowState()
	 * @generated
	 */
	int FLOW_STATE = 13;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_STATE__TECHNICALID = CinematicPackage.CINEMATIC_ELEMENT__TECHNICALID;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.ActionStateImpl <em>Action State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.ActionStateImpl
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getActionState()
	 * @generated
	 */
	int ACTION_STATE = 3;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.ViewStateImpl <em>View State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.ViewStateImpl
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getViewState()
	 * @generated
	 */
	int VIEW_STATE = 4;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.DecisionStateImpl <em>Decision State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.DecisionStateImpl
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getDecisionState()
	 * @generated
	 */
	int DECISION_STATE = 5;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.SubflowStateImpl <em>Subflow State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.SubflowStateImpl
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getSubflowState()
	 * @generated
	 */
	int SUBFLOW_STATE = 6;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.InitialStateImpl <em>Initial State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.InitialStateImpl
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getInitialState()
	 * @generated
	 */
	int INITIAL_STATE = 8;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.FinalStateImpl <em>Final State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.FinalStateImpl
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getFinalState()
	 * @generated
	 */
	int FINAL_STATE = 10;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.AsyncEventStateImpl <em>Async Event State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.AsyncEventStateImpl
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getAsyncEventState()
	 * @generated
	 */
	int ASYNC_EVENT_STATE = 7;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.TransitionImpl
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 2;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_STATE__METADATAS = CinematicPackage.CINEMATIC_ELEMENT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_STATE__DESCRIPTION = CinematicPackage.CINEMATIC_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_STATE__KEYWORDS = CinematicPackage.CINEMATIC_ELEMENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_STATE__BEHAVIOURS = CinematicPackage.CINEMATIC_ELEMENT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_STATE__BINDING_REGISTRIES = CinematicPackage.CINEMATIC_ELEMENT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_STATE__VERSION = CinematicPackage.CINEMATIC_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_STATE__CREATED_ON = CinematicPackage.CINEMATIC_ELEMENT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_STATE__MODIFIED_ON = CinematicPackage.CINEMATIC_ELEMENT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_STATE__ACTIONS = CinematicPackage.CINEMATIC_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_STATE_FEATURE_COUNT = CinematicPackage.CINEMATIC_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_FLOW_STATE__TECHNICALID = FLOW_STATE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_FLOW_STATE__METADATAS = FLOW_STATE__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_FLOW_STATE__DESCRIPTION = FLOW_STATE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_FLOW_STATE__KEYWORDS = FLOW_STATE__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_FLOW_STATE__BEHAVIOURS = FLOW_STATE__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_FLOW_STATE__BINDING_REGISTRIES = FLOW_STATE__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_FLOW_STATE__VERSION = FLOW_STATE__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_FLOW_STATE__CREATED_ON = FLOW_STATE__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_FLOW_STATE__MODIFIED_ON = FLOW_STATE__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_FLOW_STATE__ACTIONS = FLOW_STATE__ACTIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_FLOW_STATE__NAME = FLOW_STATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Flow State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_FLOW_STATE_FEATURE_COUNT = FLOW_STATE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TECHNICALID = CinematicPackage.NAMED_ELEMENT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__METADATAS = CinematicPackage.NAMED_ELEMENT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__DESCRIPTION = CinematicPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__KEYWORDS = CinematicPackage.NAMED_ELEMENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__BEHAVIOURS = CinematicPackage.NAMED_ELEMENT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__BINDING_REGISTRIES = CinematicPackage.NAMED_ELEMENT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__VERSION = CinematicPackage.NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__CREATED_ON = CinematicPackage.NAMED_ELEMENT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__MODIFIED_ON = CinematicPackage.NAMED_ELEMENT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__NAME = CinematicPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__GUARD = CinematicPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__MODAL = CinematicPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__FROM = CinematicPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TO = CinematicPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__ON = CinematicPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = CinematicPackage.NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATE__TECHNICALID = NAMED_FLOW_STATE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATE__METADATAS = NAMED_FLOW_STATE__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATE__DESCRIPTION = NAMED_FLOW_STATE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATE__KEYWORDS = NAMED_FLOW_STATE__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATE__BEHAVIOURS = NAMED_FLOW_STATE__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATE__BINDING_REGISTRIES = NAMED_FLOW_STATE__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATE__VERSION = NAMED_FLOW_STATE__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATE__CREATED_ON = NAMED_FLOW_STATE__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATE__MODIFIED_ON = NAMED_FLOW_STATE__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATE__ACTIONS = NAMED_FLOW_STATE__ACTIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATE__NAME = NAMED_FLOW_STATE__NAME;

	/**
	 * The number of structural features of the '<em>Action State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATE_FEATURE_COUNT = NAMED_FLOW_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_STATE__TECHNICALID = NAMED_FLOW_STATE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_STATE__METADATAS = NAMED_FLOW_STATE__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_STATE__DESCRIPTION = NAMED_FLOW_STATE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_STATE__KEYWORDS = NAMED_FLOW_STATE__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_STATE__BEHAVIOURS = NAMED_FLOW_STATE__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_STATE__BINDING_REGISTRIES = NAMED_FLOW_STATE__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_STATE__VERSION = NAMED_FLOW_STATE__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_STATE__CREATED_ON = NAMED_FLOW_STATE__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_STATE__MODIFIED_ON = NAMED_FLOW_STATE__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_STATE__ACTIONS = NAMED_FLOW_STATE__ACTIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_STATE__NAME = NAMED_FLOW_STATE__NAME;

	/**
	 * The feature id for the '<em><b>New Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_STATE__NEW_INSTANCE = NAMED_FLOW_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Refresh</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_STATE__REFRESH = NAMED_FLOW_STATE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>View Containers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_STATE__VIEW_CONTAINERS = NAMED_FLOW_STATE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>View State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_STATE_FEATURE_COUNT = NAMED_FLOW_STATE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_STATE__TECHNICALID = NAMED_FLOW_STATE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_STATE__METADATAS = NAMED_FLOW_STATE__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_STATE__DESCRIPTION = NAMED_FLOW_STATE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_STATE__KEYWORDS = NAMED_FLOW_STATE__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_STATE__BEHAVIOURS = NAMED_FLOW_STATE__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_STATE__BINDING_REGISTRIES = NAMED_FLOW_STATE__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_STATE__VERSION = NAMED_FLOW_STATE__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_STATE__CREATED_ON = NAMED_FLOW_STATE__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_STATE__MODIFIED_ON = NAMED_FLOW_STATE__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_STATE__ACTIONS = NAMED_FLOW_STATE__ACTIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_STATE__NAME = NAMED_FLOW_STATE__NAME;

	/**
	 * The number of structural features of the '<em>Decision State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_STATE_FEATURE_COUNT = NAMED_FLOW_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBFLOW_STATE__TECHNICALID = FLOW_STATE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBFLOW_STATE__METADATAS = FLOW_STATE__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBFLOW_STATE__DESCRIPTION = FLOW_STATE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBFLOW_STATE__KEYWORDS = FLOW_STATE__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBFLOW_STATE__BEHAVIOURS = FLOW_STATE__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBFLOW_STATE__BINDING_REGISTRIES = FLOW_STATE__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBFLOW_STATE__VERSION = FLOW_STATE__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBFLOW_STATE__CREATED_ON = FLOW_STATE__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBFLOW_STATE__MODIFIED_ON = FLOW_STATE__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBFLOW_STATE__ACTIONS = FLOW_STATE__ACTIONS;

	/**
	 * The feature id for the '<em><b>Subflow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBFLOW_STATE__SUBFLOW = FLOW_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBFLOW_STATE__NAME = FLOW_STATE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Subflow State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBFLOW_STATE_FEATURE_COUNT = FLOW_STATE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASYNC_EVENT_STATE__TECHNICALID = NAMED_FLOW_STATE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASYNC_EVENT_STATE__METADATAS = NAMED_FLOW_STATE__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASYNC_EVENT_STATE__DESCRIPTION = NAMED_FLOW_STATE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASYNC_EVENT_STATE__KEYWORDS = NAMED_FLOW_STATE__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASYNC_EVENT_STATE__BEHAVIOURS = NAMED_FLOW_STATE__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASYNC_EVENT_STATE__BINDING_REGISTRIES = NAMED_FLOW_STATE__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASYNC_EVENT_STATE__VERSION = NAMED_FLOW_STATE__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASYNC_EVENT_STATE__CREATED_ON = NAMED_FLOW_STATE__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASYNC_EVENT_STATE__MODIFIED_ON = NAMED_FLOW_STATE__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASYNC_EVENT_STATE__ACTIONS = NAMED_FLOW_STATE__ACTIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASYNC_EVENT_STATE__NAME = NAMED_FLOW_STATE__NAME;

	/**
	 * The number of structural features of the '<em>Async Event State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASYNC_EVENT_STATE_FEATURE_COUNT = NAMED_FLOW_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__TECHNICALID = NAMED_FLOW_STATE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__METADATAS = NAMED_FLOW_STATE__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__DESCRIPTION = NAMED_FLOW_STATE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__KEYWORDS = NAMED_FLOW_STATE__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__BEHAVIOURS = NAMED_FLOW_STATE__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__BINDING_REGISTRIES = NAMED_FLOW_STATE__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__VERSION = NAMED_FLOW_STATE__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__CREATED_ON = NAMED_FLOW_STATE__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__MODIFIED_ON = NAMED_FLOW_STATE__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__ACTIONS = NAMED_FLOW_STATE__ACTIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__NAME = NAMED_FLOW_STATE__NAME;

	/**
	 * The number of structural features of the '<em>Initial State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE_FEATURE_COUNT = NAMED_FLOW_STATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.FlowActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowActionImpl
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getFlowAction()
	 * @generated
	 */
	int FLOW_ACTION = 11;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.FlowEventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowEventImpl
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getFlowEvent()
	 * @generated
	 */
	int FLOW_EVENT = 12;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.AbortStateImpl <em>Abort State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.AbortStateImpl
	 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getAbortState()
	 * @generated
	 */
	int ABORT_STATE = 9;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABORT_STATE__TECHNICALID = NAMED_FLOW_STATE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABORT_STATE__METADATAS = NAMED_FLOW_STATE__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABORT_STATE__DESCRIPTION = NAMED_FLOW_STATE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABORT_STATE__KEYWORDS = NAMED_FLOW_STATE__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABORT_STATE__BEHAVIOURS = NAMED_FLOW_STATE__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABORT_STATE__BINDING_REGISTRIES = NAMED_FLOW_STATE__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABORT_STATE__VERSION = NAMED_FLOW_STATE__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABORT_STATE__CREATED_ON = NAMED_FLOW_STATE__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABORT_STATE__MODIFIED_ON = NAMED_FLOW_STATE__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABORT_STATE__ACTIONS = NAMED_FLOW_STATE__ACTIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABORT_STATE__NAME = NAMED_FLOW_STATE__NAME;

	/**
	 * The number of structural features of the '<em>Abort State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABORT_STATE_FEATURE_COUNT = NAMED_FLOW_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__TECHNICALID = NAMED_FLOW_STATE__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__METADATAS = NAMED_FLOW_STATE__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__DESCRIPTION = NAMED_FLOW_STATE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__KEYWORDS = NAMED_FLOW_STATE__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__BEHAVIOURS = NAMED_FLOW_STATE__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__BINDING_REGISTRIES = NAMED_FLOW_STATE__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__VERSION = NAMED_FLOW_STATE__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__CREATED_ON = NAMED_FLOW_STATE__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__MODIFIED_ON = NAMED_FLOW_STATE__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__ACTIONS = NAMED_FLOW_STATE__ACTIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__NAME = NAMED_FLOW_STATE__NAME;

	/**
	 * The number of structural features of the '<em>Final State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE_FEATURE_COUNT = NAMED_FLOW_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ACTION__TECHNICALID = CinematicPackage.NAMED_ELEMENT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ACTION__METADATAS = CinematicPackage.NAMED_ELEMENT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ACTION__DESCRIPTION = CinematicPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ACTION__KEYWORDS = CinematicPackage.NAMED_ELEMENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ACTION__BEHAVIOURS = CinematicPackage.NAMED_ELEMENT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ACTION__BINDING_REGISTRIES = CinematicPackage.NAMED_ELEMENT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ACTION__VERSION = CinematicPackage.NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ACTION__CREATED_ON = CinematicPackage.NAMED_ELEMENT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ACTION__MODIFIED_ON = CinematicPackage.NAMED_ELEMENT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ACTION__NAME = CinematicPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Calls</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ACTION__CALLS = CinematicPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ACTION__OPERATIONS = CinematicPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ACTION_FEATURE_COUNT = CinematicPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Technicalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_EVENT__TECHNICALID = CinematicPackage.EVENT__TECHNICALID;

	/**
	 * The feature id for the '<em><b>Metadatas</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_EVENT__METADATAS = CinematicPackage.EVENT__METADATAS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_EVENT__DESCRIPTION = CinematicPackage.EVENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_EVENT__KEYWORDS = CinematicPackage.EVENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Behaviours</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_EVENT__BEHAVIOURS = CinematicPackage.EVENT__BEHAVIOURS;

	/**
	 * The feature id for the '<em><b>Binding Registries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_EVENT__BINDING_REGISTRIES = CinematicPackage.EVENT__BINDING_REGISTRIES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_EVENT__VERSION = CinematicPackage.EVENT__VERSION;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_EVENT__CREATED_ON = CinematicPackage.EVENT__CREATED_ON;

	/**
	 * The feature id for the '<em><b>Modified On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_EVENT__MODIFIED_ON = CinematicPackage.EVENT__MODIFIED_ON;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_EVENT__NAME = CinematicPackage.EVENT__NAME;

	/**
	 * The feature id for the '<em><b>Binds</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_EVENT__BINDS = CinematicPackage.EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_EVENT_FEATURE_COUNT = CinematicPackage.EVENT_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.flow.Flow <em>Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.Flow
	 * @generated
	 */
	EClass getFlow();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.cinematic.flow.Flow#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.Flow#getStates()
	 * @see #getFlow()
	 * @generated
	 */
	EReference getFlow_States();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.cinematic.flow.Flow#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.Flow#getTransitions()
	 * @see #getFlow()
	 * @generated
	 */
	EReference getFlow_Transitions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.cinematic.flow.Flow#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Events</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.Flow#getEvents()
	 * @see #getFlow()
	 * @generated
	 */
	EReference getFlow_Events();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.flow.NamedFlowState <em>Named Flow State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Flow State</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.NamedFlowState
	 * @generated
	 */
	EClass getNamedFlowState();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.flow.FlowState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.FlowState
	 * @generated
	 */
	EClass getFlowState();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.cinematic.flow.FlowState#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.FlowState#getActions()
	 * @see #getFlowState()
	 * @generated
	 */
	EReference getFlowState_Actions();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.flow.ActionState <em>Action State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action State</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.ActionState
	 * @generated
	 */
	EClass getActionState();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.flow.ViewState <em>View State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View State</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.ViewState
	 * @generated
	 */
	EClass getViewState();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.cinematic.flow.ViewState#isNewInstance <em>New Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Instance</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.ViewState#isNewInstance()
	 * @see #getViewState()
	 * @generated
	 */
	EAttribute getViewState_NewInstance();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.cinematic.flow.ViewState#isRefresh <em>Refresh</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Refresh</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.ViewState#isRefresh()
	 * @see #getViewState()
	 * @generated
	 */
	EAttribute getViewState_Refresh();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.cinematic.flow.ViewState#getViewContainers <em>View Containers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>View Containers</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.ViewState#getViewContainers()
	 * @see #getViewState()
	 * @generated
	 */
	EReference getViewState_ViewContainers();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.flow.DecisionState <em>Decision State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decision State</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.DecisionState
	 * @generated
	 */
	EClass getDecisionState();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.flow.SubflowState <em>Subflow State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subflow State</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.SubflowState
	 * @generated
	 */
	EClass getSubflowState();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.cinematic.flow.SubflowState#getSubflow <em>Subflow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Subflow</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.SubflowState#getSubflow()
	 * @see #getSubflowState()
	 * @generated
	 */
	EReference getSubflowState_Subflow();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.cinematic.flow.SubflowState#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.SubflowState#getName()
	 * @see #getSubflowState()
	 * @generated
	 */
	EAttribute getSubflowState_Name();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.flow.InitialState <em>Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Initial State</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.InitialState
	 * @generated
	 */
	EClass getInitialState();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.flow.FinalState <em>Final State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Final State</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.FinalState
	 * @generated
	 */
	EClass getFinalState();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.flow.AsyncEventState <em>Async Event State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Async Event State</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.AsyncEventState
	 * @generated
	 */
	EClass getAsyncEventState();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.flow.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.cinematic.flow.Transition#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Guard</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.Transition#getGuard()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Guard();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.cinematic.flow.Transition#isModal <em>Modal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modal</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.Transition#isModal()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Modal();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.cinematic.flow.Transition#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.Transition#getTo()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_To();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.cinematic.flow.Transition#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.Transition#getFrom()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_From();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.cinematic.flow.Transition#getOn <em>On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>On</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.Transition#getOn()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_On();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.flow.FlowAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.FlowAction
	 * @generated
	 */
	EClass getFlowAction();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.cinematic.flow.FlowAction#getCalls <em>Calls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Calls</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.FlowAction#getCalls()
	 * @see #getFlowAction()
	 * @generated
	 */
	EReference getFlowAction_Calls();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.cinematic.flow.FlowAction#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Operations</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.FlowAction#getOperations()
	 * @see #getFlowAction()
	 * @generated
	 */
	EReference getFlowAction_Operations();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.flow.FlowEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.FlowEvent
	 * @generated
	 */
	EClass getFlowEvent();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.cinematic.flow.FlowEvent#getBinds <em>Binds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Binds</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.FlowEvent#getBinds()
	 * @see #getFlowEvent()
	 * @generated
	 */
	EReference getFlowEvent_Binds();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.cinematic.flow.AbortState <em>Abort State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abort State</em>'.
	 * @see org.obeonetwork.dsl.cinematic.flow.AbortState
	 * @generated
	 */
	EClass getAbortState();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FlowFactory getFlowFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.FlowImpl <em>Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowImpl
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getFlow()
		 * @generated
		 */
		EClass FLOW = eINSTANCE.getFlow();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW__STATES = eINSTANCE.getFlow_States();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW__TRANSITIONS = eINSTANCE.getFlow_Transitions();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW__EVENTS = eINSTANCE.getFlow_Events();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.NamedFlowStateImpl <em>Named Flow State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.NamedFlowStateImpl
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getNamedFlowState()
		 * @generated
		 */
		EClass NAMED_FLOW_STATE = eINSTANCE.getNamedFlowState();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.FlowStateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowStateImpl
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getFlowState()
		 * @generated
		 */
		EClass FLOW_STATE = eINSTANCE.getFlowState();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW_STATE__ACTIONS = eINSTANCE.getFlowState_Actions();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.ActionStateImpl <em>Action State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.ActionStateImpl
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getActionState()
		 * @generated
		 */
		EClass ACTION_STATE = eINSTANCE.getActionState();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.ViewStateImpl <em>View State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.ViewStateImpl
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getViewState()
		 * @generated
		 */
		EClass VIEW_STATE = eINSTANCE.getViewState();

		/**
		 * The meta object literal for the '<em><b>New Instance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW_STATE__NEW_INSTANCE = eINSTANCE.getViewState_NewInstance();

		/**
		 * The meta object literal for the '<em><b>Refresh</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW_STATE__REFRESH = eINSTANCE.getViewState_Refresh();

		/**
		 * The meta object literal for the '<em><b>View Containers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_STATE__VIEW_CONTAINERS = eINSTANCE.getViewState_ViewContainers();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.DecisionStateImpl <em>Decision State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.DecisionStateImpl
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getDecisionState()
		 * @generated
		 */
		EClass DECISION_STATE = eINSTANCE.getDecisionState();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.SubflowStateImpl <em>Subflow State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.SubflowStateImpl
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getSubflowState()
		 * @generated
		 */
		EClass SUBFLOW_STATE = eINSTANCE.getSubflowState();

		/**
		 * The meta object literal for the '<em><b>Subflow</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBFLOW_STATE__SUBFLOW = eINSTANCE.getSubflowState_Subflow();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBFLOW_STATE__NAME = eINSTANCE.getSubflowState_Name();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.InitialStateImpl <em>Initial State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.InitialStateImpl
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getInitialState()
		 * @generated
		 */
		EClass INITIAL_STATE = eINSTANCE.getInitialState();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.FinalStateImpl <em>Final State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.FinalStateImpl
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getFinalState()
		 * @generated
		 */
		EClass FINAL_STATE = eINSTANCE.getFinalState();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.AsyncEventStateImpl <em>Async Event State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.AsyncEventStateImpl
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getAsyncEventState()
		 * @generated
		 */
		EClass ASYNC_EVENT_STATE = eINSTANCE.getAsyncEventState();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.TransitionImpl
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Guard</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__GUARD = eINSTANCE.getTransition_Guard();

		/**
		 * The meta object literal for the '<em><b>Modal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__MODAL = eINSTANCE.getTransition_Modal();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TO = eINSTANCE.getTransition_To();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__FROM = eINSTANCE.getTransition_From();

		/**
		 * The meta object literal for the '<em><b>On</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__ON = eINSTANCE.getTransition_On();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.FlowActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowActionImpl
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getFlowAction()
		 * @generated
		 */
		EClass FLOW_ACTION = eINSTANCE.getFlowAction();

		/**
		 * The meta object literal for the '<em><b>Calls</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW_ACTION__CALLS = eINSTANCE.getFlowAction_Calls();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW_ACTION__OPERATIONS = eINSTANCE.getFlowAction_Operations();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.FlowEventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowEventImpl
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getFlowEvent()
		 * @generated
		 */
		EClass FLOW_EVENT = eINSTANCE.getFlowEvent();

		/**
		 * The meta object literal for the '<em><b>Binds</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW_EVENT__BINDS = eINSTANCE.getFlowEvent_Binds();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.cinematic.flow.impl.AbortStateImpl <em>Abort State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.AbortStateImpl
		 * @see org.obeonetwork.dsl.cinematic.flow.impl.FlowPackageImpl#getAbortState()
		 * @generated
		 */
		EClass ABORT_STATE = eINSTANCE.getAbortState();

	}

} //FlowPackage
