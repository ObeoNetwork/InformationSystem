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
package org.obeonetwork.dsl.interaction;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Return Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.interaction.ReturnMessage#getInvocationMessage <em>Invocation Message</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getReturnMessage()
 * @model
 * @generated
 */
public interface ReturnMessage extends Message {
	/**
	 * Returns the value of the '<em><b>Invocation Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invocation Message</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invocation Message</em>' reference.
	 * @see #setInvocationMessage(Message)
	 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getReturnMessage_InvocationMessage()
	 * @model required="true"
	 * @generated
	 */
	Message getInvocationMessage();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.interaction.ReturnMessage#getInvocationMessage <em>Invocation Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invocation Message</em>' reference.
	 * @see #getInvocationMessage()
	 * @generated
	 */
	void setInvocationMessage(Message value);

} // ReturnMessage
