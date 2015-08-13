/**
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.cinematic.view.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewContainerReference;
import org.obeonetwork.dsl.cinematic.view.ViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.impl.ViewContainerImpl#getOwnedElements <em>Owned Elements</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.impl.ViewContainerImpl#getViewContainers <em>View Containers</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.impl.ViewContainerImpl#getViewElements <em>View Elements</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.impl.ViewContainerImpl#getViewContainerReferences <em>View Container References</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ViewContainerImpl extends AbstractViewElementImpl implements ViewContainer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ViewPackage.Literals.VIEW_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AbstractViewElement> getOwnedElements() {
		return (EList<AbstractViewElement>)eDynamicGet(ViewPackage.VIEW_CONTAINER__OWNED_ELEMENTS, ViewPackage.Literals.VIEW_CONTAINER__OWNED_ELEMENTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ViewContainer> getViewContainers() {
		return (EList<ViewContainer>)eDynamicGet(ViewPackage.VIEW_CONTAINER__VIEW_CONTAINERS, ViewPackage.Literals.VIEW_CONTAINER__VIEW_CONTAINERS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ViewElement> getViewElements() {
		return (EList<ViewElement>)eDynamicGet(ViewPackage.VIEW_CONTAINER__VIEW_ELEMENTS, ViewPackage.Literals.VIEW_CONTAINER__VIEW_ELEMENTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ViewContainerReference> getViewContainerReferences() {
		return (EList<ViewContainerReference>)eDynamicGet(ViewPackage.VIEW_CONTAINER__VIEW_CONTAINER_REFERENCES, ViewPackage.Literals.VIEW_CONTAINER__VIEW_CONTAINER_REFERENCES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ViewPackage.VIEW_CONTAINER__OWNED_ELEMENTS:
				return ((InternalEList<?>)getOwnedElements()).basicRemove(otherEnd, msgs);
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
			case ViewPackage.VIEW_CONTAINER__OWNED_ELEMENTS:
				return getOwnedElements();
			case ViewPackage.VIEW_CONTAINER__VIEW_CONTAINERS:
				return getViewContainers();
			case ViewPackage.VIEW_CONTAINER__VIEW_ELEMENTS:
				return getViewElements();
			case ViewPackage.VIEW_CONTAINER__VIEW_CONTAINER_REFERENCES:
				return getViewContainerReferences();
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
			case ViewPackage.VIEW_CONTAINER__OWNED_ELEMENTS:
				getOwnedElements().clear();
				getOwnedElements().addAll((Collection<? extends AbstractViewElement>)newValue);
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
			case ViewPackage.VIEW_CONTAINER__OWNED_ELEMENTS:
				getOwnedElements().clear();
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
			case ViewPackage.VIEW_CONTAINER__OWNED_ELEMENTS:
				return !getOwnedElements().isEmpty();
			case ViewPackage.VIEW_CONTAINER__VIEW_CONTAINERS:
				return !getViewContainers().isEmpty();
			case ViewPackage.VIEW_CONTAINER__VIEW_ELEMENTS:
				return !getViewElements().isEmpty();
			case ViewPackage.VIEW_CONTAINER__VIEW_CONTAINER_REFERENCES:
				return !getViewContainerReferences().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ViewContainerImpl
