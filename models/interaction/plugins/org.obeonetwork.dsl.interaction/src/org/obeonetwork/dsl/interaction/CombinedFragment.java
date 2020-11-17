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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Combined Fragment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.interaction.CombinedFragment#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.interaction.CombinedFragment#getCoveredParticipants <em>Covered Participants</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.interaction.CombinedFragment#getOwnedOperands <em>Owned Operands</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getCombinedFragment()
 * @model
 * @generated
 */
public interface CombinedFragment extends InteractionFragment {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see #setOperator(String)
	 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getCombinedFragment_Operator()
	 * @model
	 * @generated
	 */
	String getOperator();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.interaction.CombinedFragment#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(String value);

	/**
	 * Returns the value of the '<em><b>Covered Participants</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.interaction.Participant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Covered Participants</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Covered Participants</em>' reference list.
	 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getCombinedFragment_CoveredParticipants()
	 * @model
	 * @generated
	 */
	EList<Participant> getCoveredParticipants();

	/**
	 * Returns the value of the '<em><b>Owned Operands</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.interaction.Operand}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Operands</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Operands</em>' containment reference list.
	 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getCombinedFragment_OwnedOperands()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Operand> getOwnedOperands();

} // CombinedFragment
