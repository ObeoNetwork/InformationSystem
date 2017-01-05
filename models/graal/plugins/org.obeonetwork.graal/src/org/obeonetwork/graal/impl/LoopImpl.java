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
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.Loop;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.graal.impl.LoopImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link org.obeonetwork.graal.impl.LoopImpl#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LoopImpl extends ActivityImpl implements Loop {
	/**
	 * The default value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerBound()
	 * @generated
	 * @ordered
	 */
	protected static final int LOWER_BOUND_EDEFAULT = 0;
	/**
	 * The default value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperBound()
	 * @generated
	 * @ordered
	 */
	protected static final int UPPER_BOUND_EDEFAULT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraalPackage.Literals.LOOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLowerBound() {
		return (Integer)eDynamicGet(GraalPackage.LOOP__LOWER_BOUND, GraalPackage.Literals.LOOP__LOWER_BOUND, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerBound(int newLowerBound) {
		eDynamicSet(GraalPackage.LOOP__LOWER_BOUND, GraalPackage.Literals.LOOP__LOWER_BOUND, newLowerBound);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getUpperBound() {
		return (Integer)eDynamicGet(GraalPackage.LOOP__UPPER_BOUND, GraalPackage.Literals.LOOP__UPPER_BOUND, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperBound(int newUpperBound) {
		eDynamicSet(GraalPackage.LOOP__UPPER_BOUND, GraalPackage.Literals.LOOP__UPPER_BOUND, newUpperBound);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraalPackage.LOOP__LOWER_BOUND:
				return getLowerBound();
			case GraalPackage.LOOP__UPPER_BOUND:
				return getUpperBound();
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
			case GraalPackage.LOOP__LOWER_BOUND:
				setLowerBound((Integer)newValue);
				return;
			case GraalPackage.LOOP__UPPER_BOUND:
				setUpperBound((Integer)newValue);
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
			case GraalPackage.LOOP__LOWER_BOUND:
				setLowerBound(LOWER_BOUND_EDEFAULT);
				return;
			case GraalPackage.LOOP__UPPER_BOUND:
				setUpperBound(UPPER_BOUND_EDEFAULT);
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
			case GraalPackage.LOOP__LOWER_BOUND:
				return getLowerBound() != LOWER_BOUND_EDEFAULT;
			case GraalPackage.LOOP__UPPER_BOUND:
				return getUpperBound() != UPPER_BOUND_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //LoopImpl
