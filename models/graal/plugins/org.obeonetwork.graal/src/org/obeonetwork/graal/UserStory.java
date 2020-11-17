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
package org.obeonetwork.graal;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Story</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.graal.UserStory#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.graal.GraalPackage#getUserStory()
 * @model
 * @generated
 */
public interface UserStory extends NamedElement {

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.graal.UserStoryElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of user stories elements.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Elements</em>' reference list.
	 * @see org.obeonetwork.graal.GraalPackage#getUserStory_Elements()
	 * @model
	 * @generated
	 */
	EList<UserStoryElement> getElements();
} // UserStory
