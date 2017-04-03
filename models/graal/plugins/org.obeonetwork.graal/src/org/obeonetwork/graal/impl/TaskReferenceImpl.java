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

import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.Task;
import org.obeonetwork.graal.TaskReference;
import org.obeonetwork.graal.UserStory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.graal.impl.TaskReferenceImpl#getTask <em>Task</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TaskReferenceImpl extends NodeImpl implements TaskReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraalPackage.Literals.TASK_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task getTask() {
		return (Task)eDynamicGet(GraalPackage.TASK_REFERENCE__TASK, GraalPackage.Literals.TASK_REFERENCE__TASK, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task basicGetTask() {
		return (Task)eDynamicGet(GraalPackage.TASK_REFERENCE__TASK, GraalPackage.Literals.TASK_REFERENCE__TASK, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTask(Task newTask) {
		eDynamicSet(GraalPackage.TASK_REFERENCE__TASK, GraalPackage.Literals.TASK_REFERENCE__TASK, newTask);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraalPackage.TASK_REFERENCE__TASK:
				if (resolve) return getTask();
				return basicGetTask();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraalPackage.TASK_REFERENCE__TASK:
				setTask((Task)newValue);
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
			case GraalPackage.TASK_REFERENCE__TASK:
				setTask((Task)null);
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
			case GraalPackage.TASK_REFERENCE__TASK:
				return basicGetTask() != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public boolean isConcernedByUserStory(UserStory userStory) {
		Task referencedTask = getTask();
		if (referencedTask != null) {
			return referencedTask.isConcernedByUserStory(userStory);
		}
		return false;
	}

	@Override
	public void attachToUserStory(UserStory userStory) {
		Task referencedTask = getTask();
		if (referencedTask != null) {
			referencedTask.attachToUserStory(userStory);
		}
	}

	@Override
	public void detachFromUserStory(UserStory userStory) {
		// Should be useless
		userStory.getElements().remove(this);
		
		Task referencedTask = getTask();
		if (referencedTask != null) {
			referencedTask.detachFromUserStory(userStory);
		}
	}

} //TaskReferenceImpl
