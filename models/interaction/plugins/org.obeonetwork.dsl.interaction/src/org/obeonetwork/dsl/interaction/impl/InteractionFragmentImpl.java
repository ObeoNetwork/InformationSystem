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
package org.obeonetwork.dsl.interaction.impl;

import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.dsl.interaction.End;
import org.obeonetwork.dsl.interaction.InteractionFragment;
import org.obeonetwork.dsl.interaction.InteractionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fragment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.interaction.impl.InteractionFragmentImpl#getStartingEnd <em>Starting End</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.interaction.impl.InteractionFragmentImpl#getFinishingEnd <em>Finishing End</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class InteractionFragmentImpl extends NamedElementImpl implements InteractionFragment {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InteractionFragmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InteractionPackage.Literals.INTERACTION_FRAGMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public End getStartingEnd() {
		return (End)eDynamicGet(InteractionPackage.INTERACTION_FRAGMENT__STARTING_END, InteractionPackage.Literals.INTERACTION_FRAGMENT__STARTING_END, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public End basicGetStartingEnd() {
		return (End)eDynamicGet(InteractionPackage.INTERACTION_FRAGMENT__STARTING_END, InteractionPackage.Literals.INTERACTION_FRAGMENT__STARTING_END, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartingEnd(End newStartingEnd) {
		eDynamicSet(InteractionPackage.INTERACTION_FRAGMENT__STARTING_END, InteractionPackage.Literals.INTERACTION_FRAGMENT__STARTING_END, newStartingEnd);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public End getFinishingEnd() {
		return (End)eDynamicGet(InteractionPackage.INTERACTION_FRAGMENT__FINISHING_END, InteractionPackage.Literals.INTERACTION_FRAGMENT__FINISHING_END, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public End basicGetFinishingEnd() {
		return (End)eDynamicGet(InteractionPackage.INTERACTION_FRAGMENT__FINISHING_END, InteractionPackage.Literals.INTERACTION_FRAGMENT__FINISHING_END, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinishingEnd(End newFinishingEnd) {
		eDynamicSet(InteractionPackage.INTERACTION_FRAGMENT__FINISHING_END, InteractionPackage.Literals.INTERACTION_FRAGMENT__FINISHING_END, newFinishingEnd);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InteractionPackage.INTERACTION_FRAGMENT__STARTING_END:
				if (resolve) return getStartingEnd();
				return basicGetStartingEnd();
			case InteractionPackage.INTERACTION_FRAGMENT__FINISHING_END:
				if (resolve) return getFinishingEnd();
				return basicGetFinishingEnd();
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
			case InteractionPackage.INTERACTION_FRAGMENT__STARTING_END:
				setStartingEnd((End)newValue);
				return;
			case InteractionPackage.INTERACTION_FRAGMENT__FINISHING_END:
				setFinishingEnd((End)newValue);
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
			case InteractionPackage.INTERACTION_FRAGMENT__STARTING_END:
				setStartingEnd((End)null);
				return;
			case InteractionPackage.INTERACTION_FRAGMENT__FINISHING_END:
				setFinishingEnd((End)null);
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
			case InteractionPackage.INTERACTION_FRAGMENT__STARTING_END:
				return basicGetStartingEnd() != null;
			case InteractionPackage.INTERACTION_FRAGMENT__FINISHING_END:
				return basicGetFinishingEnd() != null;
		}
		return super.eIsSet(featureID);
	}

} //InteractionFragmentImpl
