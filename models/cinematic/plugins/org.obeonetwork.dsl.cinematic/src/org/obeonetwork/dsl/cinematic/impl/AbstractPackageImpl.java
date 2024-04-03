/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.cinematic.AbstractPackage;
import org.obeonetwork.dsl.cinematic.CinematicPackage;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.impl.AbstractPackageImpl#getFlows <em>Flows</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.impl.AbstractPackageImpl#getViewContainers <em>View Containers</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.impl.AbstractPackageImpl#getSubPackages <em>Sub Packages</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractPackageImpl extends NamedElementImpl implements AbstractPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractPackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CinematicPackage.Literals.ABSTRACT_PACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Flow> getFlows() {
		return (EList<Flow>)eDynamicGet(CinematicPackage.ABSTRACT_PACKAGE__FLOWS, CinematicPackage.Literals.ABSTRACT_PACKAGE__FLOWS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ViewContainer> getViewContainers() {
		return (EList<ViewContainer>)eDynamicGet(CinematicPackage.ABSTRACT_PACKAGE__VIEW_CONTAINERS, CinematicPackage.Literals.ABSTRACT_PACKAGE__VIEW_CONTAINERS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<org.obeonetwork.dsl.cinematic.Package> getSubPackages() {
		return (EList<org.obeonetwork.dsl.cinematic.Package>)eDynamicGet(CinematicPackage.ABSTRACT_PACKAGE__SUB_PACKAGES, CinematicPackage.Literals.ABSTRACT_PACKAGE__SUB_PACKAGES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CinematicPackage.ABSTRACT_PACKAGE__FLOWS:
				return ((InternalEList<?>)getFlows()).basicRemove(otherEnd, msgs);
			case CinematicPackage.ABSTRACT_PACKAGE__VIEW_CONTAINERS:
				return ((InternalEList<?>)getViewContainers()).basicRemove(otherEnd, msgs);
			case CinematicPackage.ABSTRACT_PACKAGE__SUB_PACKAGES:
				return ((InternalEList<?>)getSubPackages()).basicRemove(otherEnd, msgs);
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
			case CinematicPackage.ABSTRACT_PACKAGE__FLOWS:
				return getFlows();
			case CinematicPackage.ABSTRACT_PACKAGE__VIEW_CONTAINERS:
				return getViewContainers();
			case CinematicPackage.ABSTRACT_PACKAGE__SUB_PACKAGES:
				return getSubPackages();
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
			case CinematicPackage.ABSTRACT_PACKAGE__FLOWS:
				getFlows().clear();
				getFlows().addAll((Collection<? extends Flow>)newValue);
				return;
			case CinematicPackage.ABSTRACT_PACKAGE__VIEW_CONTAINERS:
				getViewContainers().clear();
				getViewContainers().addAll((Collection<? extends ViewContainer>)newValue);
				return;
			case CinematicPackage.ABSTRACT_PACKAGE__SUB_PACKAGES:
				getSubPackages().clear();
				getSubPackages().addAll((Collection<? extends org.obeonetwork.dsl.cinematic.Package>)newValue);
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
			case CinematicPackage.ABSTRACT_PACKAGE__FLOWS:
				getFlows().clear();
				return;
			case CinematicPackage.ABSTRACT_PACKAGE__VIEW_CONTAINERS:
				getViewContainers().clear();
				return;
			case CinematicPackage.ABSTRACT_PACKAGE__SUB_PACKAGES:
				getSubPackages().clear();
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
			case CinematicPackage.ABSTRACT_PACKAGE__FLOWS:
				return !getFlows().isEmpty();
			case CinematicPackage.ABSTRACT_PACKAGE__VIEW_CONTAINERS:
				return !getViewContainers().isEmpty();
			case CinematicPackage.ABSTRACT_PACKAGE__SUB_PACKAGES:
				return !getSubPackages().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AbstractPackageImpl
