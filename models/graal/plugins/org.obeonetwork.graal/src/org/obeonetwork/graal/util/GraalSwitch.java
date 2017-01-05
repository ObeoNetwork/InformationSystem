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

import java.util.List;

import org.eclipse.emf.ecore.EClass;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.obeonetwork.graal.GraalPackage
 * @generated
 */
public class GraalSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GraalPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraalSwitch() {
		if (modelPackage == null) {
			modelPackage = GraalPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case GraalPackage.TASK: {
				Task task = (Task)theEObject;
				T result = caseTask(task);
				if (result == null) result = caseActivity(task);
				if (result == null) result = caseAbstractTask(task);
				if (result == null) result = caseUserStoryElement(task);
				if (result == null) result = caseNamedElement(task);
				if (result == null) result = caseGraalObject(task);
				if (result == null) result = caseObeoDSMObject(task);
				if (result == null) result = caseIdentifiable(task);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraalPackage.SYSTEM: {
				org.obeonetwork.graal.System system = (org.obeonetwork.graal.System)theEObject;
				T result = caseSystem(system);
				if (result == null) result = caseNamedElement(system);
				if (result == null) result = caseDomainModelRegistry(system);
				if (result == null) result = caseTasksContainer(system);
				if (result == null) result = caseNamespacesContainer(system);
				if (result == null) result = caseGraalObject(system);
				if (result == null) result = caseObeoDSMObject(system);
				if (result == null) result = caseIdentifiable(system);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraalPackage.ACTIVITY: {
				Activity activity = (Activity)theEObject;
				T result = caseActivity(activity);
				if (result == null) result = caseGraalObject(activity);
				if (result == null) result = caseObeoDSMObject(activity);
				if (result == null) result = caseIdentifiable(activity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraalPackage.OPERATOR: {
				Operator operator = (Operator)theEObject;
				T result = caseOperator(operator);
				if (result == null) result = caseNode(operator);
				if (result == null) result = caseGraalObject(operator);
				if (result == null) result = caseUserStoryElement(operator);
				if (result == null) result = caseObeoDSMObject(operator);
				if (result == null) result = caseIdentifiable(operator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraalPackage.NODE: {
				Node node = (Node)theEObject;
				T result = caseNode(node);
				if (result == null) result = caseGraalObject(node);
				if (result == null) result = caseUserStoryElement(node);
				if (result == null) result = caseObeoDSMObject(node);
				if (result == null) result = caseIdentifiable(node);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraalPackage.TRANSITION: {
				Transition transition = (Transition)theEObject;
				T result = caseTransition(transition);
				if (result == null) result = caseGraalObject(transition);
				if (result == null) result = caseUserStoryElement(transition);
				if (result == null) result = caseObeoDSMObject(transition);
				if (result == null) result = caseIdentifiable(transition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraalPackage.TASK_REFERENCE: {
				TaskReference taskReference = (TaskReference)theEObject;
				T result = caseTaskReference(taskReference);
				if (result == null) result = caseNode(taskReference);
				if (result == null) result = caseGraalObject(taskReference);
				if (result == null) result = caseUserStoryElement(taskReference);
				if (result == null) result = caseObeoDSMObject(taskReference);
				if (result == null) result = caseIdentifiable(taskReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraalPackage.USER_VIEW: {
				UserView userView = (UserView)theEObject;
				T result = caseUserView(userView);
				if (result == null) result = caseNamedNode(userView);
				if (result == null) result = caseNode(userView);
				if (result == null) result = caseNamedElement(userView);
				if (result == null) result = caseGraalObject(userView);
				if (result == null) result = caseUserStoryElement(userView);
				if (result == null) result = caseObeoDSMObject(userView);
				if (result == null) result = caseIdentifiable(userView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraalPackage.USER_ACTION: {
				UserAction userAction = (UserAction)theEObject;
				T result = caseUserAction(userAction);
				if (result == null) result = caseNamedNode(userAction);
				if (result == null) result = caseNode(userAction);
				if (result == null) result = caseNamedElement(userAction);
				if (result == null) result = caseGraalObject(userAction);
				if (result == null) result = caseUserStoryElement(userAction);
				if (result == null) result = caseObeoDSMObject(userAction);
				if (result == null) result = caseIdentifiable(userAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraalPackage.APPLI_EVENT: {
				AppliEvent appliEvent = (AppliEvent)theEObject;
				T result = caseAppliEvent(appliEvent);
				if (result == null) result = caseNamedNode(appliEvent);
				if (result == null) result = caseNode(appliEvent);
				if (result == null) result = caseNamedElement(appliEvent);
				if (result == null) result = caseGraalObject(appliEvent);
				if (result == null) result = caseUserStoryElement(appliEvent);
				if (result == null) result = caseObeoDSMObject(appliEvent);
				if (result == null) result = caseIdentifiable(appliEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraalPackage.APPLI_ACTION: {
				AppliAction appliAction = (AppliAction)theEObject;
				T result = caseAppliAction(appliAction);
				if (result == null) result = caseNamedNode(appliAction);
				if (result == null) result = caseNode(appliAction);
				if (result == null) result = caseNamedElement(appliAction);
				if (result == null) result = caseGraalObject(appliAction);
				if (result == null) result = caseUserStoryElement(appliAction);
				if (result == null) result = caseObeoDSMObject(appliAction);
				if (result == null) result = caseIdentifiable(appliAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraalPackage.INITIAL_NODE: {
				InitialNode initialNode = (InitialNode)theEObject;
				T result = caseInitialNode(initialNode);
				if (result == null) result = caseNode(initialNode);
				if (result == null) result = caseGraalObject(initialNode);
				if (result == null) result = caseUserStoryElement(initialNode);
				if (result == null) result = caseObeoDSMObject(initialNode);
				if (result == null) result = caseIdentifiable(initialNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraalPackage.FINAL_NODE: {
				FinalNode finalNode = (FinalNode)theEObject;
				T result = caseFinalNode(finalNode);
				if (result == null) result = caseNode(finalNode);
				if (result == null) result = caseGraalObject(finalNode);
				if (result == null) result = caseUserStoryElement(finalNode);
				if (result == null) result = caseObeoDSMObject(finalNode);
				if (result == null) result = caseIdentifiable(finalNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraalPackage.ABORT_NODE: {
				AbortNode abortNode = (AbortNode)theEObject;
				T result = caseAbortNode(abortNode);
				if (result == null) result = caseNode(abortNode);
				if (result == null) result = caseGraalObject(abortNode);
				if (result == null) result = caseUserStoryElement(abortNode);
				if (result == null) result = caseObeoDSMObject(abortNode);
				if (result == null) result = caseIdentifiable(abortNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraalPackage.LOOP: {
				Loop loop = (Loop)theEObject;
				T result = caseLoop(loop);
				if (result == null) result = caseActivity(loop);
				if (result == null) result = caseGraalObject(loop);
				if (result == null) result = caseObeoDSMObject(loop);
				if (result == null) result = caseIdentifiable(loop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraalPackage.ACTOR: {
				Actor actor = (Actor)theEObject;
				T result = caseActor(actor);
				if (result == null) result = caseNamedElement(actor);
				if (result == null) result = caseGraalObject(actor);
				if (result == null) result = caseObeoDSMObject(actor);
				if (result == null) result = caseIdentifiable(actor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraalPackage.ABSTRACT_TASK: {
				AbstractTask abstractTask = (AbstractTask)theEObject;
				T result = caseAbstractTask(abstractTask);
				if (result == null) result = caseNamedElement(abstractTask);
				if (result == null) result = caseGraalObject(abstractTask);
				if (result == null) result = caseObeoDSMObject(abstractTask);
				if (result == null) result = caseIdentifiable(abstractTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraalPackage.TASKS_GROUP: {
				TasksGroup tasksGroup = (TasksGroup)theEObject;
				T result = caseTasksGroup(tasksGroup);
				if (result == null) result = caseAbstractTask(tasksGroup);
				if (result == null) result = caseTasksContainer(tasksGroup);
				if (result == null) result = caseNamedElement(tasksGroup);
				if (result == null) result = caseGraalObject(tasksGroup);
				if (result == null) result = caseObeoDSMObject(tasksGroup);
				if (result == null) result = caseIdentifiable(tasksGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraalPackage.USE_CASE: {
				UseCase useCase = (UseCase)theEObject;
				T result = caseUseCase(useCase);
				if (result == null) result = caseNamedElement(useCase);
				if (result == null) result = caseDomainModelRegistry(useCase);
				if (result == null) result = caseGraalObject(useCase);
				if (result == null) result = caseObeoDSMObject(useCase);
				if (result == null) result = caseIdentifiable(useCase);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraalPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = caseGraalObject(namedElement);
				if (result == null) result = caseObeoDSMObject(namedElement);
				if (result == null) result = caseIdentifiable(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraalPackage.NAMED_NODE: {
				NamedNode namedNode = (NamedNode)theEObject;
				T result = caseNamedNode(namedNode);
				if (result == null) result = caseNode(namedNode);
				if (result == null) result = caseNamedElement(namedNode);
				if (result == null) result = caseGraalObject(namedNode);
				if (result == null) result = caseUserStoryElement(namedNode);
				if (result == null) result = caseObeoDSMObject(namedNode);
				if (result == null) result = caseIdentifiable(namedNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraalPackage.DOMAIN_MODEL_REGISTRY: {
				DomainModelRegistry domainModelRegistry = (DomainModelRegistry)theEObject;
				T result = caseDomainModelRegistry(domainModelRegistry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraalPackage.TASKS_CONTAINER: {
				TasksContainer tasksContainer = (TasksContainer)theEObject;
				T result = caseTasksContainer(tasksContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraalPackage.USER_STORY: {
				UserStory userStory = (UserStory)theEObject;
				T result = caseUserStory(userStory);
				if (result == null) result = caseNamedElement(userStory);
				if (result == null) result = caseGraalObject(userStory);
				if (result == null) result = caseObeoDSMObject(userStory);
				if (result == null) result = caseIdentifiable(userStory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraalPackage.USER_STORY_ELEMENT: {
				UserStoryElement userStoryElement = (UserStoryElement)theEObject;
				T result = caseUserStoryElement(userStoryElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraalPackage.GRAAL_OBJECT: {
				GraalObject graalObject = (GraalObject)theEObject;
				T result = caseGraalObject(graalObject);
				if (result == null) result = caseObeoDSMObject(graalObject);
				if (result == null) result = caseIdentifiable(graalObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraalPackage.DOMAIN_CLASS: {
				DomainClass domainClass = (DomainClass)theEObject;
				T result = caseDomainClass(domainClass);
				if (result == null) result = caseStructuredType(domainClass);
				if (result == null) result = caseType(domainClass);
				if (result == null) result = caseObeoDSMObject(domainClass);
				if (result == null) result = caseBoundableElement(domainClass);
				if (result == null) result = caseIdentifiable(domainClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTask(Task object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystem(org.obeonetwork.graal.System object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivity(Activity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperator(Operator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNode(Node object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransition(Transition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaskReference(TaskReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUserView(UserView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUserAction(UserAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Appli Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Appli Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAppliEvent(AppliEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Appli Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Appli Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAppliAction(AppliAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Initial Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Initial Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInitialNode(InitialNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Final Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Final Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFinalNode(FinalNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abort Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abort Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbortNode(AbortNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoop(Loop object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActor(Actor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractTask(AbstractTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tasks Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tasks Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTasksGroup(TasksGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Use Case</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Use Case</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUseCase(UseCase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedNode(NamedNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain Model Registry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain Model Registry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomainModelRegistry(DomainModelRegistry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tasks Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tasks Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTasksContainer(TasksContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User Story</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Story</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUserStory(UserStory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User Story Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Story Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUserStoryElement(UserStoryElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGraalObject(GraalObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomainClass(DomainClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifiable(Identifiable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Obeo DSM Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Obeo DSM Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObeoDSMObject(ObeoDSMObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Namespaces Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespaces Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamespacesContainer(NamespacesContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boundable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boundable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoundableElement(BoundableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structured Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structured Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructuredType(StructuredType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //GraalSwitch
