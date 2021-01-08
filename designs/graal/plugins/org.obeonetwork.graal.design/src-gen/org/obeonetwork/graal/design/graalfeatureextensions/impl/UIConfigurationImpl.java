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
package org.obeonetwork.graal.design.graalfeatureextensions.impl;

import org.eclipse.sirius.viewpoint.DAnalysis;

import org.eclipse.sirius.viewpoint.impl.DFeatureExtensionImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.obeonetwork.graal.UserStory;

import org.obeonetwork.graal.design.graalfeatureextensions.GraalfeatureextensionsPackage;
import org.obeonetwork.graal.design.graalfeatureextensions.UIConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UI Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.graal.design.graalfeatureextensions.impl.UIConfigurationImpl#getViewpointAnalysis <em>Viewpoint Analysis</em>}</li>
 *   <li>{@link org.obeonetwork.graal.design.graalfeatureextensions.impl.UIConfigurationImpl#getActiveUserStories <em>Active User Stories</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UIConfigurationImpl extends DFeatureExtensionImpl implements UIConfiguration {
	/**
	 * The cached value of the '{@link #getViewpointAnalysis() <em>Viewpoint Analysis</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewpointAnalysis()
	 * @generated
	 * @ordered
	 */
	protected DAnalysis viewpointAnalysis;

	/**
	 * The cached value of the '{@link #getActiveUserStories() <em>Active User Stories</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActiveUserStories()
	 * @generated
	 * @ordered
	 */
	protected EList<UserStory> activeUserStories;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UIConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraalfeatureextensionsPackage.Literals.UI_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DAnalysis getViewpointAnalysis() {
		if (viewpointAnalysis != null && viewpointAnalysis.eIsProxy()) {
			InternalEObject oldViewpointAnalysis = (InternalEObject)viewpointAnalysis;
			viewpointAnalysis = (DAnalysis)eResolveProxy(oldViewpointAnalysis);
			if (viewpointAnalysis != oldViewpointAnalysis) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraalfeatureextensionsPackage.UI_CONFIGURATION__VIEWPOINT_ANALYSIS, oldViewpointAnalysis, viewpointAnalysis));
			}
		}
		return viewpointAnalysis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DAnalysis basicGetViewpointAnalysis() {
		return viewpointAnalysis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViewpointAnalysis(DAnalysis newViewpointAnalysis) {
		DAnalysis oldViewpointAnalysis = viewpointAnalysis;
		viewpointAnalysis = newViewpointAnalysis;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraalfeatureextensionsPackage.UI_CONFIGURATION__VIEWPOINT_ANALYSIS, oldViewpointAnalysis, viewpointAnalysis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UserStory> getActiveUserStories() {
		if (activeUserStories == null) {
			activeUserStories = new EObjectResolvingEList<UserStory>(UserStory.class, this, GraalfeatureextensionsPackage.UI_CONFIGURATION__ACTIVE_USER_STORIES);
		}
		return activeUserStories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraalfeatureextensionsPackage.UI_CONFIGURATION__VIEWPOINT_ANALYSIS:
				if (resolve) return getViewpointAnalysis();
				return basicGetViewpointAnalysis();
			case GraalfeatureextensionsPackage.UI_CONFIGURATION__ACTIVE_USER_STORIES:
				return getActiveUserStories();
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
			case GraalfeatureextensionsPackage.UI_CONFIGURATION__VIEWPOINT_ANALYSIS:
				setViewpointAnalysis((DAnalysis)newValue);
				return;
			case GraalfeatureextensionsPackage.UI_CONFIGURATION__ACTIVE_USER_STORIES:
				getActiveUserStories().clear();
				getActiveUserStories().addAll((Collection<? extends UserStory>)newValue);
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
			case GraalfeatureextensionsPackage.UI_CONFIGURATION__VIEWPOINT_ANALYSIS:
				setViewpointAnalysis((DAnalysis)null);
				return;
			case GraalfeatureextensionsPackage.UI_CONFIGURATION__ACTIVE_USER_STORIES:
				getActiveUserStories().clear();
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
			case GraalfeatureextensionsPackage.UI_CONFIGURATION__VIEWPOINT_ANALYSIS:
				return viewpointAnalysis != null;
			case GraalfeatureextensionsPackage.UI_CONFIGURATION__ACTIVE_USER_STORIES:
				return activeUserStories != null && !activeUserStories.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //UIConfigurationImpl
