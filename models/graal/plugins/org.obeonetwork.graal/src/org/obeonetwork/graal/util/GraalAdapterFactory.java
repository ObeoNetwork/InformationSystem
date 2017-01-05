/*******************************************************************************
 * Copyright (c) 2010, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.environment.BoundableElement;
import org.obeonetwork.dsl.environment.NamespacesContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.technicalid.Identifiable;
import org.obeonetwork.graal.AbortNode;
import org.obeonetwork.graal.AbstractTask;
import org.obeonetwork.graal.Activity;
import org.obeonetwork.graal.Actor;
import org.obeonetwork.graal.AppliAction;
import org.obeonetwork.graal.AppliEvent;
import org.obeonetwork.graal.DomainClass;
import org.obeonetwork.graal.DomainModelRegistry;
import org.obeonetwork.graal.FinalNode;
import org.obeonetwork.graal.GraalObject;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.InitialNode;
import org.obeonetwork.graal.Loop;
import org.obeonetwork.graal.NamedElement;
import org.obeonetwork.graal.NamedNode;
import org.obeonetwork.graal.Node;
import org.obeonetwork.graal.Operator;
import org.obeonetwork.graal.Task;
import org.obeonetwork.graal.TaskReference;
import org.obeonetwork.graal.TasksContainer;
import org.obeonetwork.graal.TasksGroup;
import org.obeonetwork.graal.Transition;
import org.obeonetwork.graal.UseCase;
import org.obeonetwork.graal.UserAction;
import org.obeonetwork.graal.UserStory;
import org.obeonetwork.graal.UserStoryElement;
import org.obeonetwork.graal.UserView;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.obeonetwork.graal.GraalPackage
 * @generated
 */
public class GraalAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GraalPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraalAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = GraalPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraalSwitch<Adapter> modelSwitch =
		new GraalSwitch<Adapter>() {
			@Override
			public Adapter caseTask(Task object) {
				return createTaskAdapter();
			}
			@Override
			public Adapter caseSystem(org.obeonetwork.graal.System object) {
				return createSystemAdapter();
			}
			@Override
			public Adapter caseActivity(Activity object) {
				return createActivityAdapter();
			}
			@Override
			public Adapter caseOperator(Operator object) {
				return createOperatorAdapter();
			}
			@Override
			public Adapter caseNode(Node object) {
				return createNodeAdapter();
			}
			@Override
			public Adapter caseTransition(Transition object) {
				return createTransitionAdapter();
			}
			@Override
			public Adapter caseTaskReference(TaskReference object) {
				return createTaskReferenceAdapter();
			}
			@Override
			public Adapter caseUserView(UserView object) {
				return createUserViewAdapter();
			}
			@Override
			public Adapter caseUserAction(UserAction object) {
				return createUserActionAdapter();
			}
			@Override
			public Adapter caseAppliEvent(AppliEvent object) {
				return createAppliEventAdapter();
			}
			@Override
			public Adapter caseAppliAction(AppliAction object) {
				return createAppliActionAdapter();
			}
			@Override
			public Adapter caseInitialNode(InitialNode object) {
				return createInitialNodeAdapter();
			}
			@Override
			public Adapter caseFinalNode(FinalNode object) {
				return createFinalNodeAdapter();
			}
			@Override
			public Adapter caseAbortNode(AbortNode object) {
				return createAbortNodeAdapter();
			}
			@Override
			public Adapter caseLoop(Loop object) {
				return createLoopAdapter();
			}
			@Override
			public Adapter caseActor(Actor object) {
				return createActorAdapter();
			}
			@Override
			public Adapter caseAbstractTask(AbstractTask object) {
				return createAbstractTaskAdapter();
			}
			@Override
			public Adapter caseTasksGroup(TasksGroup object) {
				return createTasksGroupAdapter();
			}
			@Override
			public Adapter caseUseCase(UseCase object) {
				return createUseCaseAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseNamedNode(NamedNode object) {
				return createNamedNodeAdapter();
			}
			@Override
			public Adapter caseDomainModelRegistry(DomainModelRegistry object) {
				return createDomainModelRegistryAdapter();
			}
			@Override
			public Adapter caseTasksContainer(TasksContainer object) {
				return createTasksContainerAdapter();
			}
			@Override
			public Adapter caseUserStory(UserStory object) {
				return createUserStoryAdapter();
			}
			@Override
			public Adapter caseUserStoryElement(UserStoryElement object) {
				return createUserStoryElementAdapter();
			}
			@Override
			public Adapter caseGraalObject(GraalObject object) {
				return createGraalObjectAdapter();
			}
			@Override
			public Adapter caseDomainClass(DomainClass object) {
				return createDomainClassAdapter();
			}
			@Override
			public Adapter caseIdentifiable(Identifiable object) {
				return createIdentifiableAdapter();
			}
			@Override
			public Adapter caseObeoDSMObject(ObeoDSMObject object) {
				return createObeoDSMObjectAdapter();
			}
			@Override
			public Adapter caseNamespacesContainer(NamespacesContainer object) {
				return createNamespacesContainerAdapter();
			}
			@Override
			public Adapter caseBoundableElement(BoundableElement object) {
				return createBoundableElementAdapter();
			}
			@Override
			public Adapter caseType(Type object) {
				return createTypeAdapter();
			}
			@Override
			public Adapter caseStructuredType(StructuredType object) {
				return createStructuredTypeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.Task
	 * @generated
	 */
	public Adapter createTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.System
	 * @generated
	 */
	public Adapter createSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.Activity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.Activity
	 * @generated
	 */
	public Adapter createActivityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.Operator
	 * @generated
	 */
	public Adapter createOperatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.Node
	 * @generated
	 */
	public Adapter createNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.Transition
	 * @generated
	 */
	public Adapter createTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.TaskReference <em>Task Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.TaskReference
	 * @generated
	 */
	public Adapter createTaskReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.UserView <em>User View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.UserView
	 * @generated
	 */
	public Adapter createUserViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.UserAction <em>User Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.UserAction
	 * @generated
	 */
	public Adapter createUserActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.AppliEvent <em>Appli Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.AppliEvent
	 * @generated
	 */
	public Adapter createAppliEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.AppliAction <em>Appli Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.AppliAction
	 * @generated
	 */
	public Adapter createAppliActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.InitialNode <em>Initial Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.InitialNode
	 * @generated
	 */
	public Adapter createInitialNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.FinalNode <em>Final Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.FinalNode
	 * @generated
	 */
	public Adapter createFinalNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.AbortNode <em>Abort Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.AbortNode
	 * @generated
	 */
	public Adapter createAbortNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.Loop <em>Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.Loop
	 * @generated
	 */
	public Adapter createLoopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.Actor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.Actor
	 * @generated
	 */
	public Adapter createActorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.AbstractTask <em>Abstract Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.AbstractTask
	 * @generated
	 */
	public Adapter createAbstractTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.TasksGroup <em>Tasks Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.TasksGroup
	 * @generated
	 */
	public Adapter createTasksGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.UseCase <em>Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.UseCase
	 * @generated
	 */
	public Adapter createUseCaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.NamedNode <em>Named Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.NamedNode
	 * @generated
	 */
	public Adapter createNamedNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.DomainModelRegistry <em>Domain Model Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.DomainModelRegistry
	 * @generated
	 */
	public Adapter createDomainModelRegistryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.TasksContainer <em>Tasks Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.TasksContainer
	 * @generated
	 */
	public Adapter createTasksContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.UserStory <em>User Story</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.UserStory
	 * @generated
	 */
	public Adapter createUserStoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.UserStoryElement <em>User Story Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.UserStoryElement
	 * @generated
	 */
	public Adapter createUserStoryElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.GraalObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.GraalObject
	 * @generated
	 */
	public Adapter createGraalObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.graal.DomainClass <em>Domain Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.graal.DomainClass
	 * @generated
	 */
	public Adapter createDomainClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.technicalid.Identifiable <em>Identifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.technicalid.Identifiable
	 * @generated
	 */
	public Adapter createIdentifiableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.environment.ObeoDSMObject <em>Obeo DSM Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.environment.ObeoDSMObject
	 * @generated
	 */
	public Adapter createObeoDSMObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.environment.NamespacesContainer <em>Namespaces Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.environment.NamespacesContainer
	 * @generated
	 */
	public Adapter createNamespacesContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.environment.BoundableElement <em>Boundable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.environment.BoundableElement
	 * @generated
	 */
	public Adapter createBoundableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.environment.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.environment.Type
	 * @generated
	 */
	public Adapter createTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.environment.StructuredType <em>Structured Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.environment.StructuredType
	 * @generated
	 */
	public Adapter createStructuredTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //GraalAdapterFactory
