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
import org.obeonetwork.dsl.entity.Block;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.soa.Category;
import org.obeonetwork.dsl.soa.ServiceDTO;
import org.obeonetwork.graal.AbstractTask;
import org.obeonetwork.graal.Actor;
import org.obeonetwork.graal.DomainModelRegistry;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.Task;
import org.obeonetwork.graal.TasksContainer;
import org.obeonetwork.graal.TasksGroup;
import org.obeonetwork.graal.UseCase;
import org.obeonetwork.graal.UserStory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.graal.impl.SystemImpl#getDtoCategories <em>Dto Categories</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.SystemImpl#getDtos <em>Dtos</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.SystemImpl#getEntityBlocks <em>Entity Blocks</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.SystemImpl#getEntities <em>Entities</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.SystemImpl#getTasks <em>Tasks</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.SystemImpl#getOwnedTasks <em>Owned Tasks</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.SystemImpl#getOwnedGroups <em>Owned Groups</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.SystemImpl#getSubSystems <em>Sub Systems</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.SystemImpl#getActors <em>Actors</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.SystemImpl#getUseCases <em>Use Cases</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.SystemImpl#getUserStories <em>User Stories</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemImpl extends NamedElementImpl implements org.obeonetwork.graal.System {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraalPackage.Literals.SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Category> getDtoCategories() {
		return (EList<Category>)eDynamicGet(GraalPackage.SYSTEM__DTO_CATEGORIES, GraalPackage.Literals.DOMAIN_MODEL_REGISTRY__DTO_CATEGORIES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ServiceDTO> getDtos() {
		return (EList<ServiceDTO>)eDynamicGet(GraalPackage.SYSTEM__DTOS, GraalPackage.Literals.DOMAIN_MODEL_REGISTRY__DTOS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Block> getEntityBlocks() {
		return (EList<Block>)eDynamicGet(GraalPackage.SYSTEM__ENTITY_BLOCKS, GraalPackage.Literals.DOMAIN_MODEL_REGISTRY__ENTITY_BLOCKS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Entity> getEntities() {
		return (EList<Entity>)eDynamicGet(GraalPackage.SYSTEM__ENTITIES, GraalPackage.Literals.DOMAIN_MODEL_REGISTRY__ENTITIES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AbstractTask> getTasks() {
		return (EList<AbstractTask>)eDynamicGet(GraalPackage.SYSTEM__TASKS, GraalPackage.Literals.TASKS_CONTAINER__TASKS, true, true);
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
	@SuppressWarnings("unchecked")
	public EList<Actor> getActors() {
		return (EList<Actor>)eDynamicGet(GraalPackage.SYSTEM__ACTORS, GraalPackage.Literals.SYSTEM__ACTORS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<UseCase> getUseCases() {
		return (EList<UseCase>)eDynamicGet(GraalPackage.SYSTEM__USE_CASES, GraalPackage.Literals.SYSTEM__USE_CASES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<UserStory> getUserStories() {
		return (EList<UserStory>)eDynamicGet(GraalPackage.SYSTEM__USER_STORIES, GraalPackage.Literals.SYSTEM__USER_STORIES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraalPackage.SYSTEM__TASKS:
				return ((InternalEList<?>)getTasks()).basicRemove(otherEnd, msgs);
			case GraalPackage.SYSTEM__SUB_SYSTEMS:
				return ((InternalEList<?>)getSubSystems()).basicRemove(otherEnd, msgs);
			case GraalPackage.SYSTEM__ACTORS:
				return ((InternalEList<?>)getActors()).basicRemove(otherEnd, msgs);
			case GraalPackage.SYSTEM__USE_CASES:
				return ((InternalEList<?>)getUseCases()).basicRemove(otherEnd, msgs);
			case GraalPackage.SYSTEM__USER_STORIES:
				return ((InternalEList<?>)getUserStories()).basicRemove(otherEnd, msgs);
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
			case GraalPackage.SYSTEM__DTO_CATEGORIES:
				return getDtoCategories();
			case GraalPackage.SYSTEM__DTOS:
				return getDtos();
			case GraalPackage.SYSTEM__ENTITY_BLOCKS:
				return getEntityBlocks();
			case GraalPackage.SYSTEM__ENTITIES:
				return getEntities();
			case GraalPackage.SYSTEM__TASKS:
				return getTasks();
			case GraalPackage.SYSTEM__OWNED_TASKS:
				return getOwnedTasks();
			case GraalPackage.SYSTEM__OWNED_GROUPS:
				return getOwnedGroups();
			case GraalPackage.SYSTEM__SUB_SYSTEMS:
				return getSubSystems();
			case GraalPackage.SYSTEM__ACTORS:
				return getActors();
			case GraalPackage.SYSTEM__USE_CASES:
				return getUseCases();
			case GraalPackage.SYSTEM__USER_STORIES:
				return getUserStories();
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
			case GraalPackage.SYSTEM__DTO_CATEGORIES:
				getDtoCategories().clear();
				getDtoCategories().addAll((Collection<? extends Category>)newValue);
				return;
			case GraalPackage.SYSTEM__DTOS:
				getDtos().clear();
				getDtos().addAll((Collection<? extends ServiceDTO>)newValue);
				return;
			case GraalPackage.SYSTEM__ENTITY_BLOCKS:
				getEntityBlocks().clear();
				getEntityBlocks().addAll((Collection<? extends Block>)newValue);
				return;
			case GraalPackage.SYSTEM__ENTITIES:
				getEntities().clear();
				getEntities().addAll((Collection<? extends Entity>)newValue);
				return;
			case GraalPackage.SYSTEM__TASKS:
				getTasks().clear();
				getTasks().addAll((Collection<? extends AbstractTask>)newValue);
				return;
			case GraalPackage.SYSTEM__SUB_SYSTEMS:
				getSubSystems().clear();
				getSubSystems().addAll((Collection<? extends org.obeonetwork.graal.System>)newValue);
				return;
			case GraalPackage.SYSTEM__ACTORS:
				getActors().clear();
				getActors().addAll((Collection<? extends Actor>)newValue);
				return;
			case GraalPackage.SYSTEM__USE_CASES:
				getUseCases().clear();
				getUseCases().addAll((Collection<? extends UseCase>)newValue);
				return;
			case GraalPackage.SYSTEM__USER_STORIES:
				getUserStories().clear();
				getUserStories().addAll((Collection<? extends UserStory>)newValue);
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
			case GraalPackage.SYSTEM__DTO_CATEGORIES:
				getDtoCategories().clear();
				return;
			case GraalPackage.SYSTEM__DTOS:
				getDtos().clear();
				return;
			case GraalPackage.SYSTEM__ENTITY_BLOCKS:
				getEntityBlocks().clear();
				return;
			case GraalPackage.SYSTEM__ENTITIES:
				getEntities().clear();
				return;
			case GraalPackage.SYSTEM__TASKS:
				getTasks().clear();
				return;
			case GraalPackage.SYSTEM__SUB_SYSTEMS:
				getSubSystems().clear();
				return;
			case GraalPackage.SYSTEM__ACTORS:
				getActors().clear();
				return;
			case GraalPackage.SYSTEM__USE_CASES:
				getUseCases().clear();
				return;
			case GraalPackage.SYSTEM__USER_STORIES:
				getUserStories().clear();
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
			case GraalPackage.SYSTEM__DTO_CATEGORIES:
				return !getDtoCategories().isEmpty();
			case GraalPackage.SYSTEM__DTOS:
				return !getDtos().isEmpty();
			case GraalPackage.SYSTEM__ENTITY_BLOCKS:
				return !getEntityBlocks().isEmpty();
			case GraalPackage.SYSTEM__ENTITIES:
				return !getEntities().isEmpty();
			case GraalPackage.SYSTEM__TASKS:
				return !getTasks().isEmpty();
			case GraalPackage.SYSTEM__OWNED_TASKS:
				return !getOwnedTasks().isEmpty();
			case GraalPackage.SYSTEM__OWNED_GROUPS:
				return !getOwnedGroups().isEmpty();
			case GraalPackage.SYSTEM__SUB_SYSTEMS:
				return !getSubSystems().isEmpty();
			case GraalPackage.SYSTEM__ACTORS:
				return !getActors().isEmpty();
			case GraalPackage.SYSTEM__USE_CASES:
				return !getUseCases().isEmpty();
			case GraalPackage.SYSTEM__USER_STORIES:
				return !getUserStories().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<org.obeonetwork.graal.System> getSubSystems() {
		return (EList<org.obeonetwork.graal.System>)eDynamicGet(GraalPackage.SYSTEM__SUB_SYSTEMS, GraalPackage.Literals.SYSTEM__SUB_SYSTEMS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == DomainModelRegistry.class) {
			switch (derivedFeatureID) {
				case GraalPackage.SYSTEM__DTO_CATEGORIES: return GraalPackage.DOMAIN_MODEL_REGISTRY__DTO_CATEGORIES;
				case GraalPackage.SYSTEM__DTOS: return GraalPackage.DOMAIN_MODEL_REGISTRY__DTOS;
				case GraalPackage.SYSTEM__ENTITY_BLOCKS: return GraalPackage.DOMAIN_MODEL_REGISTRY__ENTITY_BLOCKS;
				case GraalPackage.SYSTEM__ENTITIES: return GraalPackage.DOMAIN_MODEL_REGISTRY__ENTITIES;
				default: return -1;
			}
		}
		if (baseClass == TasksContainer.class) {
			switch (derivedFeatureID) {
				case GraalPackage.SYSTEM__TASKS: return GraalPackage.TASKS_CONTAINER__TASKS;
				case GraalPackage.SYSTEM__OWNED_TASKS: return GraalPackage.TASKS_CONTAINER__OWNED_TASKS;
				case GraalPackage.SYSTEM__OWNED_GROUPS: return GraalPackage.TASKS_CONTAINER__OWNED_GROUPS;
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
		if (baseClass == DomainModelRegistry.class) {
			switch (baseFeatureID) {
				case GraalPackage.DOMAIN_MODEL_REGISTRY__DTO_CATEGORIES: return GraalPackage.SYSTEM__DTO_CATEGORIES;
				case GraalPackage.DOMAIN_MODEL_REGISTRY__DTOS: return GraalPackage.SYSTEM__DTOS;
				case GraalPackage.DOMAIN_MODEL_REGISTRY__ENTITY_BLOCKS: return GraalPackage.SYSTEM__ENTITY_BLOCKS;
				case GraalPackage.DOMAIN_MODEL_REGISTRY__ENTITIES: return GraalPackage.SYSTEM__ENTITIES;
				default: return -1;
			}
		}
		if (baseClass == TasksContainer.class) {
			switch (baseFeatureID) {
				case GraalPackage.TASKS_CONTAINER__TASKS: return GraalPackage.SYSTEM__TASKS;
				case GraalPackage.TASKS_CONTAINER__OWNED_TASKS: return GraalPackage.SYSTEM__OWNED_TASKS;
				case GraalPackage.TASKS_CONTAINER__OWNED_GROUPS: return GraalPackage.SYSTEM__OWNED_GROUPS;
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

} //SystemImpl
