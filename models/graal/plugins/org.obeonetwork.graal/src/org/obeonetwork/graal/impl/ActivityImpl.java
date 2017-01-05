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
package org.obeonetwork.graal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.graal.Activity;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.Loop;
import org.obeonetwork.graal.Node;
import org.obeonetwork.graal.Task;
import org.obeonetwork.graal.TaskReference;
import org.obeonetwork.graal.Transition;
import org.obeonetwork.graal.UserStory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.graal.impl.ActivityImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.ActivityImpl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.ActivityImpl#getSubActivities <em>Sub Activities</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ActivityImpl extends GraalObjectImpl implements Activity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraalPackage.Literals.ACTIVITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Node> getNodes() {
		return (EList<Node>)eDynamicGet(GraalPackage.ACTIVITY__NODES, GraalPackage.Literals.ACTIVITY__NODES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Transition> getTransitions() {
		return (EList<Transition>)eDynamicGet(GraalPackage.ACTIVITY__TRANSITIONS, GraalPackage.Literals.ACTIVITY__TRANSITIONS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Loop> getSubActivities() {
		return (EList<Loop>)eDynamicGet(GraalPackage.ACTIVITY__SUB_ACTIVITIES, GraalPackage.Literals.ACTIVITY__SUB_ACTIVITIES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasChildAttachedToUserStory(UserStory userStory) {
		
		// Checks if one of the nodes is attached to the user story
		for (Node node : getNodes()) {
			if (node.isConcernedByUserStory(userStory)) {
				return true;
			}
		}
		// Checks if one of the transitions is attached to the user story
		for (Transition transition : getTransitions()) {
			if (userStory.getElements().contains(transition)) {
				return true;
			}
		}
		// Checks if one of the subActivities is attached to the user story
		for (Activity subActivity : getSubActivities()) {
			if (subActivity.hasChildAttachedToUserStory(userStory)) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Task getContainingTask() {
		EObject container = eContainer();
		while (container != null) {
			if (container instanceof Task) {
				return (Task)container;
			}
			container = container.eContainer();
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraalPackage.ACTIVITY__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case GraalPackage.ACTIVITY__TRANSITIONS:
				return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
			case GraalPackage.ACTIVITY__SUB_ACTIVITIES:
				return ((InternalEList<?>)getSubActivities()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraalPackage.ACTIVITY__NODES:
				return getNodes();
			case GraalPackage.ACTIVITY__TRANSITIONS:
				return getTransitions();
			case GraalPackage.ACTIVITY__SUB_ACTIVITIES:
				return getSubActivities();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraalPackage.ACTIVITY__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case GraalPackage.ACTIVITY__TRANSITIONS:
				getTransitions().clear();
				getTransitions().addAll((Collection<? extends Transition>)newValue);
				return;
			case GraalPackage.ACTIVITY__SUB_ACTIVITIES:
				getSubActivities().clear();
				getSubActivities().addAll((Collection<? extends Loop>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GraalPackage.ACTIVITY__NODES:
				getNodes().clear();
				return;
			case GraalPackage.ACTIVITY__TRANSITIONS:
				getTransitions().clear();
				return;
			case GraalPackage.ACTIVITY__SUB_ACTIVITIES:
				getSubActivities().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GraalPackage.ACTIVITY__NODES:
				return !getNodes().isEmpty();
			case GraalPackage.ACTIVITY__TRANSITIONS:
				return !getTransitions().isEmpty();
			case GraalPackage.ACTIVITY__SUB_ACTIVITIES:
				return !getSubActivities().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public void attachToUserStory(UserStory userStory) {
		// Every children excepting TaskReferences is associated with the user story
		for (Node node : getNodes()) {
			if (!(node instanceof TaskReference)) {
				node.attachToUserStory(userStory);
			}
		}
		
		// Every transition is associated with the user story
		for (Transition transition : getTransitions()) {
			transition.attachToUserStory(userStory);
		}
		
		// Every subActivity is associated with the user story
		for(Activity subActivity : getSubActivities()) {
			subActivity.attachToUserStory(userStory);
		}
	}
	
	@Override
	public void detachFromUserStory(UserStory userStory) {
		// Every children excepting TaskReferences is detached from the user story
		for (Node node : getNodes()) {
			if (!(node instanceof TaskReference)) {
				node.detachFromUserStory(userStory);
			}
		}
		
		// Every transition is detached from the user story
		for (Transition transition : getTransitions()) {
			transition.detachFromUserStory(userStory);
		}
		
		// Every subActivity is detached from the user story
		for(Activity subActivity : getSubActivities()) {
			subActivity.detachFromUserStory(userStory);
		}
	}

} //ActivityImpl
