/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.dsl.cinematic.CinematicPackage;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.toolkits.Toolkit;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.impl.CinematicRootImpl#getToolkits <em>Toolkits</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CinematicRootImpl extends AbstractPackageImpl implements CinematicRoot {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CinematicRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CinematicPackage.Literals.CINEMATIC_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Toolkit> getToolkits() {
		return (EList<Toolkit>)eDynamicGet(CinematicPackage.CINEMATIC_ROOT__TOOLKITS, CinematicPackage.Literals.CINEMATIC_ROOT__TOOLKITS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CinematicPackage.CINEMATIC_ROOT__TOOLKITS:
				return getToolkits();
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
			case CinematicPackage.CINEMATIC_ROOT__TOOLKITS:
				getToolkits().clear();
				getToolkits().addAll((Collection<? extends Toolkit>)newValue);
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
			case CinematicPackage.CINEMATIC_ROOT__TOOLKITS:
				getToolkits().clear();
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
			case CinematicPackage.CINEMATIC_ROOT__TOOLKITS:
				return !getToolkits().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CinematicRootImpl
