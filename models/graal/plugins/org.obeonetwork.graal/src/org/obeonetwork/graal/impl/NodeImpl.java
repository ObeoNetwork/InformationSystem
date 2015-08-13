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

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.Node;
import org.obeonetwork.graal.Task;
import org.obeonetwork.graal.Transition;
import org.obeonetwork.graal.UserStory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.graal.impl.NodeImpl#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.NodeImpl#getIncomingTransitions <em>Incoming Transitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class NodeImpl extends GraalObjectImpl implements Node {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraalPackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Transition> getOutgoingTransitions() {
		return (EList<Transition>)eDynamicGet(GraalPackage.NODE__OUTGOING_TRANSITIONS, GraalPackage.Literals.NODE__OUTGOING_TRANSITIONS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Transition> getIncomingTransitions() {
		return (EList<Transition>)eDynamicGet(GraalPackage.NODE__INCOMING_TRANSITIONS, GraalPackage.Literals.NODE__INCOMING_TRANSITIONS, true, true);
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraalPackage.NODE__OUTGOING_TRANSITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingTransitions()).basicAdd(otherEnd, msgs);
			case GraalPackage.NODE__INCOMING_TRANSITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingTransitions()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraalPackage.NODE__OUTGOING_TRANSITIONS:
				return ((InternalEList<?>)getOutgoingTransitions()).basicRemove(otherEnd, msgs);
			case GraalPackage.NODE__INCOMING_TRANSITIONS:
				return ((InternalEList<?>)getIncomingTransitions()).basicRemove(otherEnd, msgs);
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
			case GraalPackage.NODE__OUTGOING_TRANSITIONS:
				return getOutgoingTransitions();
			case GraalPackage.NODE__INCOMING_TRANSITIONS:
				return getIncomingTransitions();
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
			case GraalPackage.NODE__OUTGOING_TRANSITIONS:
				getOutgoingTransitions().clear();
				getOutgoingTransitions().addAll((Collection<? extends Transition>)newValue);
				return;
			case GraalPackage.NODE__INCOMING_TRANSITIONS:
				getIncomingTransitions().clear();
				getIncomingTransitions().addAll((Collection<? extends Transition>)newValue);
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
			case GraalPackage.NODE__OUTGOING_TRANSITIONS:
				getOutgoingTransitions().clear();
				return;
			case GraalPackage.NODE__INCOMING_TRANSITIONS:
				getIncomingTransitions().clear();
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
			case GraalPackage.NODE__OUTGOING_TRANSITIONS:
				return !getOutgoingTransitions().isEmpty();
			case GraalPackage.NODE__INCOMING_TRANSITIONS:
				return !getIncomingTransitions().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public boolean canBeAttachedToUserStory(UserStory userStory) {
		return true;
	}

	@Override
	public boolean isConcernedByUserStory(UserStory userStory) {
		return userStory.getElements().contains(this);
	}

	@Override
	public void attachToUserStory(UserStory userStory) {
		userStory.getElements().add(this);
		
		// If the containing task is not associated with the user story we do it
		Task task = getContainingTask();
		if (task != null) {
			if (!task.isConcernedByUserStory(userStory)) {
				userStory.getElements().add(task);
			}
		}
	}
	
	@Override
	public void detachFromUserStory(UserStory userStory) {
		userStory.getElements().remove(this);
		
		// if no element in the task is attached with the user story
		// we detach the task from the user story
		Task task = getContainingTask();
		if (task != null) {
			if (userStory.getElements().contains(task)
					&& !task.hasChildAttachedToUserStory(userStory)) {
				userStory.getElements().remove(task);
			}
		}
	}

} //NodeImpl
