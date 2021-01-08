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
package org.obeonetwork.graal;

import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.environment.NamespacesContainer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.graal.System#getSubSystems <em>Sub Systems</em>}</li>
 *   <li>{@link org.obeonetwork.graal.System#getActors <em>Actors</em>}</li>
 *   <li>{@link org.obeonetwork.graal.System#getUseCases <em>Use Cases</em>}</li>
 *   <li>{@link org.obeonetwork.graal.System#getUserStories <em>User Stories</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.graal.GraalPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends NamedElement, DomainModelRegistry, TasksContainer, NamespacesContainer {
	/**
	 * Returns the value of the '<em><b>Actors</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.graal.Actor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of actors.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Actors</em>' containment reference list.
	 * @see org.obeonetwork.graal.GraalPackage#getSystem_Actors()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Actor> getActors();

	/**
	 * Returns the value of the '<em><b>Use Cases</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.graal.UseCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Cases</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of use cases.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Use Cases</em>' containment reference list.
	 * @see org.obeonetwork.graal.GraalPackage#getSystem_UseCases()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<UseCase> getUseCases();

	/**
	 * Returns the value of the '<em><b>User Stories</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.graal.UserStory}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Stories</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of user stories.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>User Stories</em>' containment reference list.
	 * @see org.obeonetwork.graal.GraalPackage#getSystem_UserStories()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<UserStory> getUserStories();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Actor> getRelatedActors();

	/**
	 * Returns the value of the '<em><b>Sub Systems</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.graal.System}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Systems</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of sub systems.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub Systems</em>' containment reference list.
	 * @see org.obeonetwork.graal.GraalPackage#getSystem_SubSystems()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<System> getSubSystems();

} // System
