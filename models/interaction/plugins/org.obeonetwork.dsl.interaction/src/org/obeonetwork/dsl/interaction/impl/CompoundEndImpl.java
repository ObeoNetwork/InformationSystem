/**
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.interaction.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.obeonetwork.dsl.interaction.CompoundEnd;
import org.obeonetwork.dsl.interaction.InteractionPackage;
import org.obeonetwork.dsl.interaction.Message;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compound End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.interaction.impl.CompoundEndImpl#getOtherOwner <em>Other Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompoundEndImpl extends EndImpl implements CompoundEnd {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompoundEndImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InteractionPackage.Literals.COMPOUND_END;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns true if one of the end's owners is a message
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isMessageEnd() {
		return super.isMessageEnd() || (getOtherOwner() != null);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * Returns the owner as an execution if one of the end's owners is a message
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Message getMessage() {
		if (super.isMessageEnd()) {
			return super.getMessage();
		} else if(isMessageEnd()) {
			return getOtherOwner();
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message getOtherOwner() {
		return (Message)eDynamicGet(InteractionPackage.COMPOUND_END__OTHER_OWNER, InteractionPackage.Literals.COMPOUND_END__OTHER_OWNER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message basicGetOtherOwner() {
		return (Message)eDynamicGet(InteractionPackage.COMPOUND_END__OTHER_OWNER, InteractionPackage.Literals.COMPOUND_END__OTHER_OWNER, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOtherOwner(Message newOtherOwner) {
		eDynamicSet(InteractionPackage.COMPOUND_END__OTHER_OWNER, InteractionPackage.Literals.COMPOUND_END__OTHER_OWNER, newOtherOwner);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InteractionPackage.COMPOUND_END__OTHER_OWNER:
				if (resolve) return getOtherOwner();
				return basicGetOtherOwner();
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
			case InteractionPackage.COMPOUND_END__OTHER_OWNER:
				setOtherOwner((Message)newValue);
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
			case InteractionPackage.COMPOUND_END__OTHER_OWNER:
				setOtherOwner((Message)null);
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
			case InteractionPackage.COMPOUND_END__OTHER_OWNER:
				return basicGetOtherOwner() != null;
		}
		return super.eIsSet(featureID);
	}

} //CompoundEndImpl
