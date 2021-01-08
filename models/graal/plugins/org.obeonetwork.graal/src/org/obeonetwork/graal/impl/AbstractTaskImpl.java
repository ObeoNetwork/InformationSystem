/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.obeonetwork.graal.AbstractTask;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.System;
import org.obeonetwork.graal.TasksGroup;
import org.obeonetwork.graal.UseCase;
import org.obeonetwork.graal.util.GraalUsageCrossReferencer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.graal.impl.AbstractTaskImpl#getId <em>Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractTaskImpl extends NamedElementImpl implements AbstractTask {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraalPackage.Literals.ABSTRACT_TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return (String)eDynamicGet(GraalPackage.ABSTRACT_TASK__ID, GraalPackage.Literals.ABSTRACT_TASK__ID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		eDynamicSet(GraalPackage.ABSTRACT_TASK__ID, GraalPackage.Literals.ABSTRACT_TASK__ID, newId);
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
				// We have to check for Resource because CDOResource are EObjects
				// if we did not check, we would not retrieve anything contained within a CDO Resource
				// (We use Resource instead of CDOResource to avoid dependency on CDO)
				return (eObject instanceof Resource)
					|| (eObject instanceof System)
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
			case GraalPackage.ABSTRACT_TASK__ID:
				return getId();
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
			case GraalPackage.ABSTRACT_TASK__ID:
				setId((String)newValue);
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
			case GraalPackage.ABSTRACT_TASK__ID:
				setId(ID_EDEFAULT);
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
			case GraalPackage.ABSTRACT_TASK__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
		}
		return super.eIsSet(featureID);
	}

} //AbstractTaskImpl
