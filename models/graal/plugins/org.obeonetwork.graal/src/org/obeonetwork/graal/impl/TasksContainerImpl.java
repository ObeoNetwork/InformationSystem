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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.obeonetwork.graal.AbstractTask;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.Task;
import org.obeonetwork.graal.TasksContainer;
import org.obeonetwork.graal.TasksGroup;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tasks Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.graal.impl.TasksContainerImpl#getTasks <em>Tasks</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.TasksContainerImpl#getOwnedTasks <em>Owned Tasks</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.TasksContainerImpl#getOwnedGroups <em>Owned Groups</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TasksContainerImpl extends CDOObjectImpl implements TasksContainer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TasksContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraalPackage.Literals.TASKS_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AbstractTask> getTasks() {
		return (EList<AbstractTask>)eDynamicGet(GraalPackage.TASKS_CONTAINER__TASKS, GraalPackage.Literals.TASKS_CONTAINER__TASKS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Task> getOwnedTasks() {
		Collection<Task> tasks = EcoreUtil.getObjectsByType(getTasks(), GraalPackage.Literals.TASK);
		return new EcoreEList.UnmodifiableEList<Task>(this,
					GraalPackage.Literals.TASKS_CONTAINER__OWNED_TASKS,
					tasks.size(),
					tasks.toArray());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<TasksGroup> getOwnedGroups() {
		Collection<TasksGroup> groups = EcoreUtil.getObjectsByType(getTasks(), GraalPackage.Literals.TASKS_GROUP);
		return new EcoreEList.UnmodifiableEList<TasksGroup>(this,
				GraalPackage.Literals.TASKS_CONTAINER__OWNED_GROUPS,
				groups.size(),
				groups.toArray());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraalPackage.TASKS_CONTAINER__TASKS:
				return ((InternalEList<?>)getTasks()).basicRemove(otherEnd, msgs);
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
			case GraalPackage.TASKS_CONTAINER__TASKS:
				return getTasks();
			case GraalPackage.TASKS_CONTAINER__OWNED_TASKS:
				return getOwnedTasks();
			case GraalPackage.TASKS_CONTAINER__OWNED_GROUPS:
				return getOwnedGroups();
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
			case GraalPackage.TASKS_CONTAINER__TASKS:
				getTasks().clear();
				getTasks().addAll((Collection<? extends AbstractTask>)newValue);
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
			case GraalPackage.TASKS_CONTAINER__TASKS:
				getTasks().clear();
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
			case GraalPackage.TASKS_CONTAINER__TASKS:
				return !getTasks().isEmpty();
			case GraalPackage.TASKS_CONTAINER__OWNED_TASKS:
				return !getOwnedTasks().isEmpty();
			case GraalPackage.TASKS_CONTAINER__OWNED_GROUPS:
				return !getOwnedGroups().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TasksContainerImpl
