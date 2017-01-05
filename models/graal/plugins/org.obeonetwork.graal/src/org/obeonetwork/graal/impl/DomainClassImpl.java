/*******************************************************************************
 * Copyright (c) 2010, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.impl;

import org.eclipse.emf.ecore.EClass;

import org.obeonetwork.dsl.environment.impl.StructuredTypeImpl;

import org.obeonetwork.graal.DomainClass;
import org.obeonetwork.graal.GraalPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.graal.impl.DomainClassImpl#getEstimatedVolumetry <em>Estimated Volumetry</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.DomainClassImpl#isHistorized <em>Historized</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DomainClassImpl extends StructuredTypeImpl implements DomainClass {
	/**
	 * The default value of the '{@link #getEstimatedVolumetry() <em>Estimated Volumetry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEstimatedVolumetry()
	 * @generated
	 * @ordered
	 */
	protected static final int ESTIMATED_VOLUMETRY_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #isHistorized() <em>Historized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHistorized()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HISTORIZED_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraalPackage.Literals.DOMAIN_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEstimatedVolumetry() {
		return (Integer)eDynamicGet(GraalPackage.DOMAIN_CLASS__ESTIMATED_VOLUMETRY, GraalPackage.Literals.DOMAIN_CLASS__ESTIMATED_VOLUMETRY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEstimatedVolumetry(int newEstimatedVolumetry) {
		eDynamicSet(GraalPackage.DOMAIN_CLASS__ESTIMATED_VOLUMETRY, GraalPackage.Literals.DOMAIN_CLASS__ESTIMATED_VOLUMETRY, newEstimatedVolumetry);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHistorized() {
		return (Boolean)eDynamicGet(GraalPackage.DOMAIN_CLASS__HISTORIZED, GraalPackage.Literals.DOMAIN_CLASS__HISTORIZED, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHistorized(boolean newHistorized) {
		eDynamicSet(GraalPackage.DOMAIN_CLASS__HISTORIZED, GraalPackage.Literals.DOMAIN_CLASS__HISTORIZED, newHistorized);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraalPackage.DOMAIN_CLASS__ESTIMATED_VOLUMETRY:
				return getEstimatedVolumetry();
			case GraalPackage.DOMAIN_CLASS__HISTORIZED:
				return isHistorized();
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
			case GraalPackage.DOMAIN_CLASS__ESTIMATED_VOLUMETRY:
				setEstimatedVolumetry((Integer)newValue);
				return;
			case GraalPackage.DOMAIN_CLASS__HISTORIZED:
				setHistorized((Boolean)newValue);
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
			case GraalPackage.DOMAIN_CLASS__ESTIMATED_VOLUMETRY:
				setEstimatedVolumetry(ESTIMATED_VOLUMETRY_EDEFAULT);
				return;
			case GraalPackage.DOMAIN_CLASS__HISTORIZED:
				setHistorized(HISTORIZED_EDEFAULT);
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
			case GraalPackage.DOMAIN_CLASS__ESTIMATED_VOLUMETRY:
				return getEstimatedVolumetry() != ESTIMATED_VOLUMETRY_EDEFAULT;
			case GraalPackage.DOMAIN_CLASS__HISTORIZED:
				return isHistorized() != HISTORIZED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //DomainClassImpl
