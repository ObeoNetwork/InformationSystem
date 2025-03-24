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
package org.obeonetwork.dsl.application.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.application.ApplicationPackage;
import org.obeonetwork.dsl.application.Configuration;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.ecorebinding.BModel;
import org.obeonetwork.dsl.environment.BindingRegistry;
import org.obeonetwork.dsl.technicalid.impl.IdentifiableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.application.impl.ConfigurationImpl#getBindingRegistries <em>Binding Registries</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.application.impl.ConfigurationImpl#getEcoreModel <em>Ecore Model</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.application.impl.ConfigurationImpl#getCinematicModel <em>Cinematic Model</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.application.impl.ConfigurationImpl#getEcoreBindingModel <em>Ecore Binding Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConfigurationImpl extends IdentifiableImpl implements Configuration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ApplicationPackage.Literals.CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<BindingRegistry> getBindingRegistries() {
		return (EList<BindingRegistry>) eDynamicGet(ApplicationPackage.CONFIGURATION__BINDING_REGISTRIES,
				ApplicationPackage.Literals.CONFIGURATION__BINDING_REGISTRIES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage getEcoreModel() {
		return (EPackage) eDynamicGet(ApplicationPackage.CONFIGURATION__ECORE_MODEL,
				ApplicationPackage.Literals.CONFIGURATION__ECORE_MODEL, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetEcoreModel() {
		return (EPackage) eDynamicGet(ApplicationPackage.CONFIGURATION__ECORE_MODEL,
				ApplicationPackage.Literals.CONFIGURATION__ECORE_MODEL, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEcoreModel(EPackage newEcoreModel) {
		eDynamicSet(ApplicationPackage.CONFIGURATION__ECORE_MODEL,
				ApplicationPackage.Literals.CONFIGURATION__ECORE_MODEL, newEcoreModel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CinematicRoot getCinematicModel() {
		return (CinematicRoot) eDynamicGet(ApplicationPackage.CONFIGURATION__CINEMATIC_MODEL,
				ApplicationPackage.Literals.CONFIGURATION__CINEMATIC_MODEL, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CinematicRoot basicGetCinematicModel() {
		return (CinematicRoot) eDynamicGet(ApplicationPackage.CONFIGURATION__CINEMATIC_MODEL,
				ApplicationPackage.Literals.CONFIGURATION__CINEMATIC_MODEL, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCinematicModel(CinematicRoot newCinematicModel) {
		eDynamicSet(ApplicationPackage.CONFIGURATION__CINEMATIC_MODEL,
				ApplicationPackage.Literals.CONFIGURATION__CINEMATIC_MODEL, newCinematicModel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BModel getEcoreBindingModel() {
		return (BModel) eDynamicGet(ApplicationPackage.CONFIGURATION__ECORE_BINDING_MODEL,
				ApplicationPackage.Literals.CONFIGURATION__ECORE_BINDING_MODEL, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BModel basicGetEcoreBindingModel() {
		return (BModel) eDynamicGet(ApplicationPackage.CONFIGURATION__ECORE_BINDING_MODEL,
				ApplicationPackage.Literals.CONFIGURATION__ECORE_BINDING_MODEL, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEcoreBindingModel(BModel newEcoreBindingModel) {
		eDynamicSet(ApplicationPackage.CONFIGURATION__ECORE_BINDING_MODEL,
				ApplicationPackage.Literals.CONFIGURATION__ECORE_BINDING_MODEL, newEcoreBindingModel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ApplicationPackage.CONFIGURATION__BINDING_REGISTRIES:
			return ((InternalEList<?>) getBindingRegistries()).basicRemove(otherEnd, msgs);
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
		case ApplicationPackage.CONFIGURATION__BINDING_REGISTRIES:
			return getBindingRegistries();
		case ApplicationPackage.CONFIGURATION__ECORE_MODEL:
			if (resolve)
				return getEcoreModel();
			return basicGetEcoreModel();
		case ApplicationPackage.CONFIGURATION__CINEMATIC_MODEL:
			if (resolve)
				return getCinematicModel();
			return basicGetCinematicModel();
		case ApplicationPackage.CONFIGURATION__ECORE_BINDING_MODEL:
			if (resolve)
				return getEcoreBindingModel();
			return basicGetEcoreBindingModel();
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
		case ApplicationPackage.CONFIGURATION__BINDING_REGISTRIES:
			getBindingRegistries().clear();
			getBindingRegistries().addAll((Collection<? extends BindingRegistry>) newValue);
			return;
		case ApplicationPackage.CONFIGURATION__ECORE_MODEL:
			setEcoreModel((EPackage) newValue);
			return;
		case ApplicationPackage.CONFIGURATION__CINEMATIC_MODEL:
			setCinematicModel((CinematicRoot) newValue);
			return;
		case ApplicationPackage.CONFIGURATION__ECORE_BINDING_MODEL:
			setEcoreBindingModel((BModel) newValue);
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
		case ApplicationPackage.CONFIGURATION__BINDING_REGISTRIES:
			getBindingRegistries().clear();
			return;
		case ApplicationPackage.CONFIGURATION__ECORE_MODEL:
			setEcoreModel((EPackage) null);
			return;
		case ApplicationPackage.CONFIGURATION__CINEMATIC_MODEL:
			setCinematicModel((CinematicRoot) null);
			return;
		case ApplicationPackage.CONFIGURATION__ECORE_BINDING_MODEL:
			setEcoreBindingModel((BModel) null);
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
		case ApplicationPackage.CONFIGURATION__BINDING_REGISTRIES:
			return !getBindingRegistries().isEmpty();
		case ApplicationPackage.CONFIGURATION__ECORE_MODEL:
			return basicGetEcoreModel() != null;
		case ApplicationPackage.CONFIGURATION__CINEMATIC_MODEL:
			return basicGetCinematicModel() != null;
		case ApplicationPackage.CONFIGURATION__ECORE_BINDING_MODEL:
			return basicGetEcoreBindingModel() != null;
		}
		return super.eIsSet(featureID);
	}

} //ConfigurationImpl
