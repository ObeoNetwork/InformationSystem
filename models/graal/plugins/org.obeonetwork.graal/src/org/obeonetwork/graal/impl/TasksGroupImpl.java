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
import org.obeonetwork.graal.AbstractTask;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.Task;
import org.obeonetwork.graal.TasksContainer;
import org.obeonetwork.graal.TasksGroup;
import org.obeonetwork.graal.UserStory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tasks Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.graal.impl.TasksGroupImpl#getTasks <em>Tasks</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.TasksGroupImpl#getOwnedTasks <em>Owned Tasks</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.TasksGroupImpl#getOwnedGroups <em>Owned Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TasksGroupImpl extends AbstractTaskImpl implements TasksGroup {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TasksGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraalPackage.Literals.TASKS_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AbstractTask> getTasks() {
		return (EList<AbstractTask>)eDynamicGet(GraalPackage.TASKS_GROUP__TASKS, GraalPackage.Literals.TASKS_CONTAINER__TASKS, true, true);
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
			case GraalPackage.TASKS_GROUP__TASKS:
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
			case GraalPackage.TASKS_GROUP__TASKS:
				return getTasks();
			case GraalPackage.TASKS_GROUP__OWNED_TASKS:
				return getOwnedTasks();
			case GraalPackage.TASKS_GROUP__OWNED_GROUPS:
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
			case GraalPackage.TASKS_GROUP__TASKS:
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
			case GraalPackage.TASKS_GROUP__TASKS:
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
			case GraalPackage.TASKS_GROUP__TASKS:
				return !getTasks().isEmpty();
			case GraalPackage.TASKS_GROUP__OWNED_TASKS:
				return !getOwnedTasks().isEmpty();
			case GraalPackage.TASKS_GROUP__OWNED_GROUPS:
				return !getOwnedGroups().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == TasksContainer.class) {
			switch (derivedFeatureID) {
				case GraalPackage.TASKS_GROUP__TASKS: return GraalPackage.TASKS_CONTAINER__TASKS;
				case GraalPackage.TASKS_GROUP__OWNED_TASKS: return GraalPackage.TASKS_CONTAINER__OWNED_TASKS;
				case GraalPackage.TASKS_GROUP__OWNED_GROUPS: return GraalPackage.TASKS_CONTAINER__OWNED_GROUPS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == TasksContainer.class) {
			switch (baseFeatureID) {
				case GraalPackage.TASKS_CONTAINER__TASKS: return GraalPackage.TASKS_GROUP__TASKS;
				case GraalPackage.TASKS_CONTAINER__OWNED_TASKS: return GraalPackage.TASKS_GROUP__OWNED_TASKS;
				case GraalPackage.TASKS_CONTAINER__OWNED_GROUPS: return GraalPackage.TASKS_GROUP__OWNED_GROUPS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}
	
	@Override
	public boolean isConcernedByUserStory(UserStory userStory) {
		for (AbstractTask abstractTask : getTasks()) {
			if (abstractTask.isConcernedByUserStory(userStory)) {
				return true;
			}
		}
		return false;
	}

} //TasksGroupImpl
