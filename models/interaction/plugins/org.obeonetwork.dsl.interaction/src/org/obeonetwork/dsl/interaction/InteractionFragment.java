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
package org.obeonetwork.dsl.interaction;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fragment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.interaction.InteractionFragment#getStartingEnd <em>Starting End</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.interaction.InteractionFragment#getFinishingEnd <em>Finishing End</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getInteractionFragment()
 * @model abstract="true"
 * @generated
 */
public interface InteractionFragment extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Starting End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Starting End</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Starting End</em>' reference.
	 * @see #setStartingEnd(End)
	 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getInteractionFragment_StartingEnd()
	 * @model required="true"
	 * @generated
	 */
	End getStartingEnd();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.interaction.InteractionFragment#getStartingEnd <em>Starting End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Starting End</em>' reference.
	 * @see #getStartingEnd()
	 * @generated
	 */
	void setStartingEnd(End value);

	/**
	 * Returns the value of the '<em><b>Finishing End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Finishing End</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Finishing End</em>' reference.
	 * @see #setFinishingEnd(End)
	 * @see org.obeonetwork.dsl.interaction.InteractionPackage#getInteractionFragment_FinishingEnd()
	 * @model required="true"
	 * @generated
	 */
	End getFinishingEnd();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.interaction.InteractionFragment#getFinishingEnd <em>Finishing End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Finishing End</em>' reference.
	 * @see #getFinishingEnd()
	 * @generated
	 */
	void setFinishingEnd(End value);

} // InteractionFragment
