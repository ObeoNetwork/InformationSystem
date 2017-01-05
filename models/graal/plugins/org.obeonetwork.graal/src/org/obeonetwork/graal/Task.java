/*******************************************************************************
 * Copyright (c) 2010, 2017 Obeo.
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
 * A representation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.graal.Task#getUses <em>Uses</em>}</li>
 *   <li>{@link org.obeonetwork.graal.Task#getPreconditions <em>Preconditions</em>}</li>
 *   <li>{@link org.obeonetwork.graal.Task#getPostconditions <em>Postconditions</em>}</li>
 *   <li>{@link org.obeonetwork.graal.Task#getActors <em>Actors</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.graal.GraalPackage#getTask()
 * @model
 * @generated
 */
public interface Task extends Activity, AbstractTask, UserStoryElement {
	/**
	 * Returns the value of the '<em><b>Uses</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.graal.Task}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uses</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uses</em>' reference list.
	 * @see org.obeonetwork.graal.GraalPackage#getTask_Uses()
	 * @model
	 * @generated
	 */
	EList<Task> getUses();

	/**
	 * Returns the value of the '<em><b>Preconditions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preconditions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preconditions</em>' attribute.
	 * @see #setPreconditions(String)
	 * @see org.obeonetwork.graal.GraalPackage#getTask_Preconditions()
	 * @model
	 * @generated
	 */
	String getPreconditions();

	/**
	 * Sets the value of the '{@link org.obeonetwork.graal.Task#getPreconditions <em>Preconditions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preconditions</em>' attribute.
	 * @see #getPreconditions()
	 * @generated
	 */
	void setPreconditions(String value);

	/**
	 * Returns the value of the '<em><b>Postconditions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postconditions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Postconditions</em>' attribute.
	 * @see #setPostconditions(String)
	 * @see org.obeonetwork.graal.GraalPackage#getTask_Postconditions()
	 * @model
	 * @generated
	 */
	String getPostconditions();

	/**
	 * Sets the value of the '{@link org.obeonetwork.graal.Task#getPostconditions <em>Postconditions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Postconditions</em>' attribute.
	 * @see #getPostconditions()
	 * @generated
	 */
	void setPostconditions(String value);

	/**
	 * Returns the value of the '<em><b>Actors</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.graal.Actor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actors</em>' reference list.
	 * @see org.obeonetwork.graal.GraalPackage#getTask_Actors()
	 * @model
	 * @generated
	 */
	EList<Actor> getActors();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Task> getUsedBy();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Actor> getRelatedActors();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<TaskReference> getReferencedBy();

} // Task
