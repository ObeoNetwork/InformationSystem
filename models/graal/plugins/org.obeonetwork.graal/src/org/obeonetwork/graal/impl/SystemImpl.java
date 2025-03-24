/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.impl;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.NamespacesContainer;
import org.obeonetwork.dsl.environment.StructuredType;
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
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.graal.impl.SystemImpl#getNamespaces <em>Namespaces</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.SystemImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.SystemImpl#getTasks <em>Tasks</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.SystemImpl#getOwnedTasks <em>Owned Tasks</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.SystemImpl#getOwnedGroups <em>Owned Groups</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.SystemImpl#getOwnedNamespaces <em>Owned Namespaces</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.SystemImpl#getSubSystems <em>Sub Systems</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.SystemImpl#getActors <em>Actors</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.SystemImpl#getUseCases <em>Use Cases</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.SystemImpl#getUserStories <em>User Stories</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SystemImpl extends NamedElementImpl implements org.obeonetwork.graal.System {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected SystemImpl() {
		super();
		eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.getEventType() == Notification.ADD || msg.getEventType() == Notification.ADD_MANY
					|| msg.getEventType() == Notification.REMOVE || msg.getEventType() == Notification.REMOVE_MANY) {
					if (msg.getFeature() == GraalPackage.Literals.TASKS_CONTAINER__TASKS) {
						invalidateCacheRelatedActors();
					} else if (msg.getFeature() == GraalPackage.Literals.SYSTEM__SUB_SYSTEMS) {
						invalidateCacheRelatedActors();
					}
				}
			}
		});
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
	public EList<Namespace> getNamespaces() {
		return (EList<Namespace>)eDynamicGet(GraalPackage.SYSTEM__NAMESPACES, GraalPackage.Literals.DOMAIN_MODEL_REGISTRY__NAMESPACES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<StructuredType> getTypes() {
		return (EList<StructuredType>)eDynamicGet(GraalPackage.SYSTEM__TYPES, GraalPackage.Literals.DOMAIN_MODEL_REGISTRY__TYPES, true, true);
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
	public EList<Namespace> getOwnedNamespaces() {
		return (EList<Namespace>)eDynamicGet(GraalPackage.SYSTEM__OWNED_NAMESPACES, EnvironmentPackage.Literals.NAMESPACES_CONTAINER__OWNED_NAMESPACES, true, true);
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
	 * Set used to cache the related actors
	 * @generated NOT
	 */
	private Set<Actor> cacheRelatedActors = null;

	/**
	 * Invalidate cache on this instance
	 * @generated NOT
	 */
	protected void invalidateCacheRelatedActors() {
		cacheRelatedActors = null;
		// Invalidate parent cache
		EObject parent = eContainer();
		if (parent instanceof SystemImpl) {
			((SystemImpl)parent).invalidateCacheRelatedActors();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Actor> getRelatedActors() {
		// Calculate the list if it is not in cache
		if (cacheRelatedActors == null) {
			cacheRelatedActors = new LinkedHashSet<Actor>();
			for (AbstractTask abstractTask : getTasks()) {
				if (abstractTask instanceof Task) {
					cacheRelatedActors.addAll(((Task)abstractTask).getActors());
				} else if (abstractTask instanceof TasksGroup) {
					cacheRelatedActors.addAll(((TasksGroup)abstractTask).getRelatedActors());
				}
			}
		}
		return ECollections.unmodifiableEList(new BasicEList<Actor>(cacheRelatedActors));
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
			case GraalPackage.SYSTEM__OWNED_NAMESPACES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedNamespaces()).basicAdd(otherEnd, msgs);
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
			case GraalPackage.SYSTEM__TASKS:
				return ((InternalEList<?>)getTasks()).basicRemove(otherEnd, msgs);
			case GraalPackage.SYSTEM__OWNED_NAMESPACES:
				return ((InternalEList<?>)getOwnedNamespaces()).basicRemove(otherEnd, msgs);
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
			case GraalPackage.SYSTEM__NAMESPACES:
				return getNamespaces();
			case GraalPackage.SYSTEM__TYPES:
				return getTypes();
			case GraalPackage.SYSTEM__TASKS:
				return getTasks();
			case GraalPackage.SYSTEM__OWNED_TASKS:
				return getOwnedTasks();
			case GraalPackage.SYSTEM__OWNED_GROUPS:
				return getOwnedGroups();
			case GraalPackage.SYSTEM__OWNED_NAMESPACES:
				return getOwnedNamespaces();
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
			case GraalPackage.SYSTEM__NAMESPACES:
				getNamespaces().clear();
				getNamespaces().addAll((Collection<? extends Namespace>)newValue);
				return;
			case GraalPackage.SYSTEM__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection<? extends StructuredType>)newValue);
				return;
			case GraalPackage.SYSTEM__TASKS:
				getTasks().clear();
				getTasks().addAll((Collection<? extends AbstractTask>)newValue);
				return;
			case GraalPackage.SYSTEM__OWNED_NAMESPACES:
				getOwnedNamespaces().clear();
				getOwnedNamespaces().addAll((Collection<? extends Namespace>)newValue);
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
			case GraalPackage.SYSTEM__NAMESPACES:
				getNamespaces().clear();
				return;
			case GraalPackage.SYSTEM__TYPES:
				getTypes().clear();
				return;
			case GraalPackage.SYSTEM__TASKS:
				getTasks().clear();
				return;
			case GraalPackage.SYSTEM__OWNED_NAMESPACES:
				getOwnedNamespaces().clear();
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
			case GraalPackage.SYSTEM__NAMESPACES:
				return !getNamespaces().isEmpty();
			case GraalPackage.SYSTEM__TYPES:
				return !getTypes().isEmpty();
			case GraalPackage.SYSTEM__TASKS:
				return !getTasks().isEmpty();
			case GraalPackage.SYSTEM__OWNED_TASKS:
				return !getOwnedTasks().isEmpty();
			case GraalPackage.SYSTEM__OWNED_GROUPS:
				return !getOwnedGroups().isEmpty();
			case GraalPackage.SYSTEM__OWNED_NAMESPACES:
				return !getOwnedNamespaces().isEmpty();
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
				case GraalPackage.SYSTEM__NAMESPACES: return GraalPackage.DOMAIN_MODEL_REGISTRY__NAMESPACES;
				case GraalPackage.SYSTEM__TYPES: return GraalPackage.DOMAIN_MODEL_REGISTRY__TYPES;
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
		if (baseClass == NamespacesContainer.class) {
			switch (derivedFeatureID) {
				case GraalPackage.SYSTEM__OWNED_NAMESPACES: return EnvironmentPackage.NAMESPACES_CONTAINER__OWNED_NAMESPACES;
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
				case GraalPackage.DOMAIN_MODEL_REGISTRY__NAMESPACES: return GraalPackage.SYSTEM__NAMESPACES;
				case GraalPackage.DOMAIN_MODEL_REGISTRY__TYPES: return GraalPackage.SYSTEM__TYPES;
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
		if (baseClass == NamespacesContainer.class) {
			switch (baseFeatureID) {
				case EnvironmentPackage.NAMESPACES_CONTAINER__OWNED_NAMESPACES: return GraalPackage.SYSTEM__OWNED_NAMESPACES;
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
