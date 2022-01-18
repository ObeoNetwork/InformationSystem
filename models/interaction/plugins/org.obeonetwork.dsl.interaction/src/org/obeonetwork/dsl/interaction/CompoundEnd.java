/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
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
 * A representation of the model object '<em><b>Compound End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.interaction.CompoundEnd#getOtherOwner <em>Other Owner</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getCompoundEnd()
 * @model
 * @generated
 */
public interface CompoundEnd extends End {
	/**
	 * Returns the value of the '<em><b>Other Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Other Owner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Other Owner</em>' reference.
	 * @see #setOtherOwner(Message)
	 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getCompoundEnd_OtherOwner()
	 * @model
	 * @generated
	 */
	Message getOtherOwner();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.interaction.CompoundEnd#getOtherOwner <em>Other Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Other Owner</em>' reference.
	 * @see #getOtherOwner()
	 * @generated
	 */
	void setOtherOwner(Message value);

} // CompoundEnd
