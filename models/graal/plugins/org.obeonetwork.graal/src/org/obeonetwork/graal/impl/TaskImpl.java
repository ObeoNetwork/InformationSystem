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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.obeonetwork.graal.AbstractTask;
import org.obeonetwork.graal.Actor;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.Loop;
import org.obeonetwork.graal.NamedElement;
import org.obeonetwork.graal.System;
import org.obeonetwork.graal.Task;
import org.obeonetwork.graal.TaskReference;
import org.obeonetwork.graal.TasksGroup;
import org.obeonetwork.graal.UseCase;
import org.obeonetwork.graal.UserStory;
import org.obeonetwork.graal.UserStoryElement;
import org.obeonetwork.graal.util.GraalUsageCrossReferencer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.graal.impl.TaskImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.TaskImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.TaskImpl#getUses <em>Uses</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.TaskImpl#getPreconditions <em>Preconditions</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.TaskImpl#getPostconditions <em>Postconditions</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.TaskImpl#getActors <em>Actors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskImpl extends ActivityImpl implements Task {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getPreconditions() <em>Preconditions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreconditions()
	 * @generated
	 * @ordered
	 */
	protected static final String PRECONDITIONS_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getPostconditions() <em>Postconditions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostconditions()
	 * @generated
	 * @ordered
	 */
	protected static final String POSTCONDITIONS_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraalPackage.Literals.TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eDynamicGet(GraalPackage.TASK__NAME, GraalPackage.Literals.NAMED_ELEMENT__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eDynamicSet(GraalPackage.TASK__NAME, GraalPackage.Literals.NAMED_ELEMENT__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return (String)eDynamicGet(GraalPackage.TASK__ID, GraalPackage.Literals.ABSTRACT_TASK__ID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		eDynamicSet(GraalPackage.TASK__ID, GraalPackage.Literals.ABSTRACT_TASK__ID, newId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Task> getUses() {
		return (EList<Task>)eDynamicGet(GraalPackage.TASK__USES, GraalPackage.Literals.TASK__USES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPreconditions() {
		return (String)eDynamicGet(GraalPackage.TASK__PRECONDITIONS, GraalPackage.Literals.TASK__PRECONDITIONS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreconditions(String newPreconditions) {
		eDynamicSet(GraalPackage.TASK__PRECONDITIONS, GraalPackage.Literals.TASK__PRECONDITIONS, newPreconditions);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPostconditions() {
		return (String)eDynamicGet(GraalPackage.TASK__POSTCONDITIONS, GraalPackage.Literals.TASK__POSTCONDITIONS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostconditions(String newPostconditions) {
		eDynamicSet(GraalPackage.TASK__POSTCONDITIONS, GraalPackage.Literals.TASK__POSTCONDITIONS, newPostconditions);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Actor> getActors() {
		return (EList<Actor>)eDynamicGet(GraalPackage.TASK__ACTORS, GraalPackage.Literals.TASK__ACTORS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<TaskReference> getReferencedBy() {
		Collection<Setting> referencingTasksReferences = new GraalUsageCrossReferencer() {
			@Override
			protected boolean crossReference(EObject eObject, EReference eReference, EObject crossReferencedEObject) {
				return eReference == GraalPackage.Literals.TASK_REFERENCE__TASK;
			}
			
			@Override
			protected boolean containment(EObject eObject) {
				return (eObject instanceof System)
					|| (eObject instanceof TasksGroup)
					|| (eObject instanceof Task)
					|| (eObject instanceof Loop)
					|| (eObject instanceof TaskReference);
			}
		}.findUsage(this);
		
		List<TaskReference> foundTasksReferences = new ArrayList<TaskReference>();
		for (Setting setting : referencingTasksReferences) {
			foundTasksReferences.add((TaskReference)setting.getEObject());
		}
		return ECollections.unmodifiableEList(new BasicEList<TaskReference>(foundTasksReferences));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Task> getUsedBy() {
		Collection<Setting> usingTasksSettings = new GraalUsageCrossReferencer() {
			@Override
			protected boolean crossReference(EObject eObject, EReference eReference, EObject crossReferencedEObject) {
				return eReference == GraalPackage.Literals.TASK__USES;
			}
			
			@Override
			protected boolean containment(EObject eObject) {
				// We have to check for Resource because CDOResource are EObjects
				// if we did not check, we would not retrieve anything contained within a CDO Resource
				// (We use Resource instead of CDOResource to avoid dependency on CDO)
				return (eObject instanceof Resource)
					|| (eObject instanceof System)
					|| (eObject instanceof TasksGroup)
					|| (eObject instanceof Task);
			}
		}.findUsage(this);
		
		List<Task> foundTasks = new ArrayList<Task>();
		for (Setting setting : usingTasksSettings) {
			foundTasks.add((Task)setting.getEObject());
		}
		
		return ECollections.unmodifiableEList(new BasicEList<Task>(foundTasks));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public UseCase getUseCase() {
		Collection<Setting> useCaseReferences = new GraalUsageCrossReferencer() {
			@Override
			protected boolean crossReference(EObject eObject, EReference eReference, EObject crossReferencedEObject) {
				return eReference == GraalPackage.Literals.USE_CASE__TASKS;
			}
			
			@Override
			protected boolean containment(EObject eObject) {
				return (eObject instanceof System)
					|| (eObject instanceof UseCase);
			}
		}.findUsage(this);
		
		UseCase useCase = null;
		for (Setting setting : useCaseReferences) {
			useCase = (UseCase)setting.getEObject();
			break;
		}
		
		return useCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public org.obeonetwork.graal.System getContainingSystem() {
		if (eContainer() != null) {
			if (eContainer() instanceof System) {
				return (System)eContainer();
			} else if (eContainer() instanceof TasksGroup) {
				return ((TasksGroup)eContainer()).getContainingSystem();
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraalPackage.TASK__NAME:
				return getName();
			case GraalPackage.TASK__ID:
				return getId();
			case GraalPackage.TASK__USES:
				return getUses();
			case GraalPackage.TASK__PRECONDITIONS:
				return getPreconditions();
			case GraalPackage.TASK__POSTCONDITIONS:
				return getPostconditions();
			case GraalPackage.TASK__ACTORS:
				return getActors();
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
			case GraalPackage.TASK__NAME:
				setName((String)newValue);
				return;
			case GraalPackage.TASK__ID:
				setId((String)newValue);
				return;
			case GraalPackage.TASK__USES:
				getUses().clear();
				getUses().addAll((Collection<? extends Task>)newValue);
				return;
			case GraalPackage.TASK__PRECONDITIONS:
				setPreconditions((String)newValue);
				return;
			case GraalPackage.TASK__POSTCONDITIONS:
				setPostconditions((String)newValue);
				return;
			case GraalPackage.TASK__ACTORS:
				getActors().clear();
				getActors().addAll((Collection<? extends Actor>)newValue);
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
			case GraalPackage.TASK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GraalPackage.TASK__ID:
				setId(ID_EDEFAULT);
				return;
			case GraalPackage.TASK__USES:
				getUses().clear();
				return;
			case GraalPackage.TASK__PRECONDITIONS:
				setPreconditions(PRECONDITIONS_EDEFAULT);
				return;
			case GraalPackage.TASK__POSTCONDITIONS:
				setPostconditions(POSTCONDITIONS_EDEFAULT);
				return;
			case GraalPackage.TASK__ACTORS:
				getActors().clear();
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
			case GraalPackage.TASK__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case GraalPackage.TASK__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case GraalPackage.TASK__USES:
				return !getUses().isEmpty();
			case GraalPackage.TASK__PRECONDITIONS:
				return PRECONDITIONS_EDEFAULT == null ? getPreconditions() != null : !PRECONDITIONS_EDEFAULT.equals(getPreconditions());
			case GraalPackage.TASK__POSTCONDITIONS:
				return POSTCONDITIONS_EDEFAULT == null ? getPostconditions() != null : !POSTCONDITIONS_EDEFAULT.equals(getPostconditions());
			case GraalPackage.TASK__ACTORS:
				return !getActors().isEmpty();
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
		if (baseClass == NamedElement.class) {
			switch (derivedFeatureID) {
				case GraalPackage.TASK__NAME: return GraalPackage.NAMED_ELEMENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == AbstractTask.class) {
			switch (derivedFeatureID) {
				case GraalPackage.TASK__ID: return GraalPackage.ABSTRACT_TASK__ID;
				default: return -1;
			}
		}
		if (baseClass == UserStoryElement.class) {
			switch (derivedFeatureID) {
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
		if (baseClass == NamedElement.class) {
			switch (baseFeatureID) {
				case GraalPackage.NAMED_ELEMENT__NAME: return GraalPackage.TASK__NAME;
				default: return -1;
			}
		}
		if (baseClass == AbstractTask.class) {
			switch (baseFeatureID) {
				case GraalPackage.ABSTRACT_TASK__ID: return GraalPackage.TASK__ID;
				default: return -1;
			}
		}
		if (baseClass == UserStoryElement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		// The task is attached to the user story
		userStory.getElements().add(this);
		
		super.attachToUserStory(userStory);
	}

	@Override
	public void detachFromUserStory(UserStory userStory) {
		// The task is detached form the user story
		userStory.getElements().remove(this);
		
		super.detachFromUserStory(userStory);
	}
	
} //TaskImpl
