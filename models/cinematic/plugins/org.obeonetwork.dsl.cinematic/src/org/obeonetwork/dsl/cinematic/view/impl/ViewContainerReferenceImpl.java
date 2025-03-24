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
package org.obeonetwork.dsl.cinematic.view.impl;

import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewContainerReference;
import org.obeonetwork.dsl.cinematic.view.ViewPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.impl.ViewContainerReferenceImpl#getViewContainer <em>View Container</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ViewContainerReferenceImpl extends AbstractViewElementImpl implements ViewContainerReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewContainerReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ViewPackage.Literals.VIEW_CONTAINER_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewContainer getViewContainer() {
		return (ViewContainer)eDynamicGet(ViewPackage.VIEW_CONTAINER_REFERENCE__VIEW_CONTAINER, ViewPackage.Literals.VIEW_CONTAINER_REFERENCE__VIEW_CONTAINER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewContainer basicGetViewContainer() {
		return (ViewContainer)eDynamicGet(ViewPackage.VIEW_CONTAINER_REFERENCE__VIEW_CONTAINER, ViewPackage.Literals.VIEW_CONTAINER_REFERENCE__VIEW_CONTAINER, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViewContainer(ViewContainer newViewContainer) {
		eDynamicSet(ViewPackage.VIEW_CONTAINER_REFERENCE__VIEW_CONTAINER, ViewPackage.Literals.VIEW_CONTAINER_REFERENCE__VIEW_CONTAINER, newViewContainer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ViewPackage.VIEW_CONTAINER_REFERENCE__VIEW_CONTAINER:
				if (resolve) return getViewContainer();
				return basicGetViewContainer();
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
			case ViewPackage.VIEW_CONTAINER_REFERENCE__VIEW_CONTAINER:
				setViewContainer((ViewContainer)newValue);
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
			case ViewPackage.VIEW_CONTAINER_REFERENCE__VIEW_CONTAINER:
				setViewContainer((ViewContainer)null);
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
			case ViewPackage.VIEW_CONTAINER_REFERENCE__VIEW_CONTAINER:
				return basicGetViewContainer() != null;
		}
		return super.eIsSet(featureID);
	}

} //ViewContainerReferenceImpl
