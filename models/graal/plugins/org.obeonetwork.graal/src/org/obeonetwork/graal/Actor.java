/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.graal.Actor#getSubActors <em>Sub Actors</em>}</li>
 *   <li>{@link org.obeonetwork.graal.Actor#getSuperActor <em>Super Actor</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.graal.GraalPackage#getActor()
 * @model
 * @generated
 */
public interface Actor extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Sub Actors</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.graal.Actor}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.graal.Actor#getSuperActor <em>Super Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Actors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of sub actors.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub Actors</em>' reference list.
	 * @see org.obeonetwork.graal.GraalPackage#getActor_SubActors()
	 * @see org.obeonetwork.graal.Actor#getSuperActor
	 * @model opposite="superActor"
	 * @generated
	 */
	EList<Actor> getSubActors();

	/**
	 * Returns the value of the '<em><b>Super Actor</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.graal.Actor#getSubActors <em>Sub Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Actor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The super actor.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Super Actor</em>' reference.
	 * @see #setSuperActor(Actor)
	 * @see org.obeonetwork.graal.GraalPackage#getActor_SuperActor()
	 * @see org.obeonetwork.graal.Actor#getSubActors
	 * @model opposite="subActors"
	 * @generated
	 */
	Actor getSuperActor();

	/**
	 * Sets the value of the '{@link org.obeonetwork.graal.Actor#getSuperActor <em>Super Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Actor</em>' reference.
	 * @see #getSuperActor()
	 * @generated
	 */
	void setSuperActor(Actor value);

} // Actor
