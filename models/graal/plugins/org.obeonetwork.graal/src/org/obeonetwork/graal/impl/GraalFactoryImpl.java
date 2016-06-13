/**
 * Copyright (c) 2010-2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.graal.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.obeonetwork.graal.AbortNode;
import org.obeonetwork.graal.Actor;
import org.obeonetwork.graal.AppliAction;
import org.obeonetwork.graal.AppliEvent;
import org.obeonetwork.graal.FinalNode;
import org.obeonetwork.graal.GraalFactory;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.InitialNode;
import org.obeonetwork.graal.Loop;
import org.obeonetwork.graal.Operator;
import org.obeonetwork.graal.OperatorKind;
import org.obeonetwork.graal.Task;
import org.obeonetwork.graal.TaskReference;
import org.obeonetwork.graal.TasksGroup;
import org.obeonetwork.graal.Transition;
import org.obeonetwork.graal.TransitionKind;
import org.obeonetwork.graal.UseCase;
import org.obeonetwork.graal.UserAction;
import org.obeonetwork.graal.UserStory;
import org.obeonetwork.graal.UserView;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraalFactoryImpl extends EFactoryImpl implements GraalFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GraalFactory init() {
		try {
			GraalFactory theGraalFactory = (GraalFactory)EPackage.Registry.INSTANCE.getEFactory(GraalPackage.eNS_URI);
			if (theGraalFactory != null) {
				return theGraalFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GraalFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraalFactoryImpl() {
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
			case GraalPackage.TASK: return (EObject)createTask();
			case GraalPackage.SYSTEM: return (EObject)createSystem();
			case GraalPackage.OPERATOR: return (EObject)createOperator();
			case GraalPackage.TRANSITION: return (EObject)createTransition();
			case GraalPackage.TASK_REFERENCE: return (EObject)createTaskReference();
			case GraalPackage.USER_VIEW: return (EObject)createUserView();
			case GraalPackage.USER_ACTION: return (EObject)createUserAction();
			case GraalPackage.APPLI_EVENT: return (EObject)createAppliEvent();
			case GraalPackage.APPLI_ACTION: return (EObject)createAppliAction();
			case GraalPackage.INITIAL_NODE: return (EObject)createInitialNode();
			case GraalPackage.FINAL_NODE: return (EObject)createFinalNode();
			case GraalPackage.ABORT_NODE: return (EObject)createAbortNode();
			case GraalPackage.LOOP: return (EObject)createLoop();
			case GraalPackage.ACTOR: return (EObject)createActor();
			case GraalPackage.TASKS_GROUP: return (EObject)createTasksGroup();
			case GraalPackage.USE_CASE: return (EObject)createUseCase();
			case GraalPackage.USER_STORY: return (EObject)createUserStory();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case GraalPackage.TRANSITION_KIND:
				return createTransitionKindFromString(eDataType, initialValue);
			case GraalPackage.OPERATOR_KIND:
				return createOperatorKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case GraalPackage.TRANSITION_KIND:
				return convertTransitionKindToString(eDataType, instanceValue);
			case GraalPackage.OPERATOR_KIND:
				return convertOperatorKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task createTask() {
		TaskImpl task = new TaskImpl();
		return task;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.obeonetwork.graal.System createSystem() {
		SystemImpl system = new SystemImpl();
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operator createOperator() {
		OperatorImpl operator = new OperatorImpl();
		return operator;
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
	public TaskReference createTaskReference() {
		TaskReferenceImpl taskReference = new TaskReferenceImpl();
		return taskReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserView createUserView() {
		UserViewImpl userView = new UserViewImpl();
		return userView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserAction createUserAction() {
		UserActionImpl userAction = new UserActionImpl();
		return userAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppliEvent createAppliEvent() {
		AppliEventImpl appliEvent = new AppliEventImpl();
		return appliEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppliAction createAppliAction() {
		AppliActionImpl appliAction = new AppliActionImpl();
		return appliAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitialNode createInitialNode() {
		InitialNodeImpl initialNode = new InitialNodeImpl();
		return initialNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FinalNode createFinalNode() {
		FinalNodeImpl finalNode = new FinalNodeImpl();
		return finalNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbortNode createAbortNode() {
		AbortNodeImpl abortNode = new AbortNodeImpl();
		return abortNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Loop createLoop() {
		LoopImpl loop = new LoopImpl();
		return loop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor createActor() {
		ActorImpl actor = new ActorImpl();
		return actor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TasksGroup createTasksGroup() {
		TasksGroupImpl tasksGroup = new TasksGroupImpl();
		return tasksGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCase createUseCase() {
		UseCaseImpl useCase = new UseCaseImpl();
		return useCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserStory createUserStory() {
		UserStoryImpl userStory = new UserStoryImpl();
		return userStory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionKind createTransitionKindFromString(EDataType eDataType, String initialValue) {
		TransitionKind result = TransitionKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTransitionKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorKind createOperatorKindFromString(EDataType eDataType, String initialValue) {
		OperatorKind result = OperatorKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperatorKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraalPackage getGraalPackage() {
		return (GraalPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GraalPackage getPackage() {
		return GraalPackage.eINSTANCE;
	}

} //GraalFactoryImpl
