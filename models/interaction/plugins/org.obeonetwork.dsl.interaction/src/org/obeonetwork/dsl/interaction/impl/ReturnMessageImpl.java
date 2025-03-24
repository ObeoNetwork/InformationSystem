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
package org.obeonetwork.dsl.interaction.impl;

import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.dsl.interaction.InteractionPackage;
import org.obeonetwork.dsl.interaction.Message;
import org.obeonetwork.dsl.interaction.ReturnMessage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Return Message</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.interaction.impl.ReturnMessageImpl#getInvocationMessage <em>Invocation Message</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReturnMessageImpl extends MessageImpl implements ReturnMessage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReturnMessageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InteractionPackage.Literals.RETURN_MESSAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message getInvocationMessage() {
		return (Message)eDynamicGet(InteractionPackage.RETURN_MESSAGE__INVOCATION_MESSAGE, InteractionPackage.Literals.RETURN_MESSAGE__INVOCATION_MESSAGE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message basicGetInvocationMessage() {
		return (Message)eDynamicGet(InteractionPackage.RETURN_MESSAGE__INVOCATION_MESSAGE, InteractionPackage.Literals.RETURN_MESSAGE__INVOCATION_MESSAGE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvocationMessage(Message newInvocationMessage) {
		eDynamicSet(InteractionPackage.RETURN_MESSAGE__INVOCATION_MESSAGE, InteractionPackage.Literals.RETURN_MESSAGE__INVOCATION_MESSAGE, newInvocationMessage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InteractionPackage.RETURN_MESSAGE__INVOCATION_MESSAGE:
				if (resolve) return getInvocationMessage();
				return basicGetInvocationMessage();
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
			case InteractionPackage.RETURN_MESSAGE__INVOCATION_MESSAGE:
				setInvocationMessage((Message)newValue);
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
			case InteractionPackage.RETURN_MESSAGE__INVOCATION_MESSAGE:
				setInvocationMessage((Message)null);
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
			case InteractionPackage.RETURN_MESSAGE__INVOCATION_MESSAGE:
				return basicGetInvocationMessage() != null;
		}
		return super.eIsSet(featureID);
	}

} //ReturnMessageImpl
