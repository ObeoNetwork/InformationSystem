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
package org.obeonetwork.dsl.cinematic.flow.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.obeonetwork.dsl.cinematic.flow.*;
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
import org.obeonetwork.dsl.cinematic.flow.InitialState;
import org.obeonetwork.dsl.cinematic.flow.SubflowState;
import org.obeonetwork.dsl.cinematic.flow.Transition;
import org.obeonetwork.dsl.cinematic.flow.ViewState;
import org.obeonetwork.dsl.cinematic.flow.spec.SubflowStateSpec;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FlowFactoryImpl extends EFactoryImpl implements FlowFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FlowFactory init() {
		try {
			FlowFactory theFlowFactory = (FlowFactory)EPackage.Registry.INSTANCE.getEFactory(FlowPackage.eNS_URI);
			if (theFlowFactory != null) {
				return theFlowFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FlowFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case FlowPackage.FLOW: return (EObject)createFlow();
			case FlowPackage.TRANSITION: return (EObject)createTransition();
			case FlowPackage.ACTION_STATE: return (EObject)createActionState();
			case FlowPackage.VIEW_STATE: return (EObject)createViewState();
			case FlowPackage.DECISION_STATE: return (EObject)createDecisionState();
			case FlowPackage.SUBFLOW_STATE: return (EObject)createSubflowState();
			case FlowPackage.ASYNC_EVENT_STATE: return (EObject)createAsyncEventState();
			case FlowPackage.INITIAL_STATE: return (EObject)createInitialState();
			case FlowPackage.ABORT_STATE: return (EObject)createAbortState();
			case FlowPackage.FINAL_STATE: return (EObject)createFinalState();
			case FlowPackage.FLOW_ACTION: return (EObject)createFlowAction();
			case FlowPackage.FLOW_EVENT: return (EObject)createFlowEvent();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Flow createFlow() {
		FlowImpl flow = new FlowImpl();
		return flow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionState createActionState() {
		ActionStateImpl actionState = new ActionStateImpl();
		return actionState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewState createViewState() {
		ViewStateImpl viewState = new ViewStateImpl();
		return viewState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DecisionState createDecisionState() {
		DecisionStateImpl decisionState = new DecisionStateImpl();
		return decisionState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated Not
	 */
	public SubflowState createSubflowState() {
		SubflowStateImpl subflowState = new SubflowStateSpec();
		return subflowState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitialState createInitialState() {
		InitialStateImpl initialState = new InitialStateImpl();
		return initialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FinalState createFinalState() {
		FinalStateImpl finalState = new FinalStateImpl();
		return finalState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AsyncEventState createAsyncEventState() {
		AsyncEventStateImpl asyncEventState = new AsyncEventStateImpl();
		return asyncEventState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition createTransition() {
		TransitionImpl transition = new TransitionImpl();
		return transition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowAction createFlowAction() {
		FlowActionImpl flowAction = new FlowActionImpl();
		return flowAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowEvent createFlowEvent() {
		FlowEventImpl flowEvent = new FlowEventImpl();
		return flowEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbortState createAbortState() {
		AbortStateImpl abortState = new AbortStateImpl();
		return abortState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowPackage getFlowPackage() {
		return (FlowPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FlowPackage getPackage() {
		return FlowPackage.eINSTANCE;
	}

} //FlowFactoryImpl
