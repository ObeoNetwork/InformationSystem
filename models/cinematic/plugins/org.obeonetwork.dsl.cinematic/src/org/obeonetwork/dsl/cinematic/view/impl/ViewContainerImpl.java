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
package org.obeonetwork.dsl.cinematic.view.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.Layout;
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
 *   <li>{@link org.obeonetwork.dsl.cinematic.view.impl.ViewContainerImpl#getLayout <em>Layout</em>}</li>
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
		// TODO: implement this method to return the 'View Containers' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ViewElement> getViewElements() {
		// TODO: implement this method to return the 'View Elements' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ViewContainerReference> getViewContainerReferences() {
		// TODO: implement this method to return the 'View Container References' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Layout getLayout() {
		return (Layout)eDynamicGet(ViewPackage.VIEW_CONTAINER__LAYOUT, ViewPackage.Literals.VIEW_CONTAINER__LAYOUT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Layout basicGetLayout() {
		return (Layout)eDynamicGet(ViewPackage.VIEW_CONTAINER__LAYOUT, ViewPackage.Literals.VIEW_CONTAINER__LAYOUT, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLayout(Layout newLayout, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newLayout, ViewPackage.VIEW_CONTAINER__LAYOUT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayout(Layout newLayout) {
		eDynamicSet(ViewPackage.VIEW_CONTAINER__LAYOUT, ViewPackage.Literals.VIEW_CONTAINER__LAYOUT, newLayout);
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
			case ViewPackage.VIEW_CONTAINER__LAYOUT:
				return basicSetLayout(null, msgs);
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
			case ViewPackage.VIEW_CONTAINER__LAYOUT:
				if (resolve) return getLayout();
				return basicGetLayout();
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
			case ViewPackage.VIEW_CONTAINER__LAYOUT:
				setLayout((Layout)newValue);
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
			case ViewPackage.VIEW_CONTAINER__LAYOUT:
				setLayout((Layout)null);
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
			case ViewPackage.VIEW_CONTAINER__LAYOUT:
				return basicGetLayout() != null;
		}
		return super.eIsSet(featureID);
	}

} //ViewContainerImpl
