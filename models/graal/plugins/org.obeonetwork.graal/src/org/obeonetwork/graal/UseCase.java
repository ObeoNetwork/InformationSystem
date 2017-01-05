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
 * A representation of the model object '<em><b>Use Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.graal.UseCase#getActors <em>Actors</em>}</li>
 *   <li>{@link org.obeonetwork.graal.UseCase#getTasks <em>Tasks</em>}</li>
 *   <li>{@link org.obeonetwork.graal.UseCase#getIncludes <em>Includes</em>}</li>
 *   <li>{@link org.obeonetwork.graal.UseCase#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.obeonetwork.graal.UseCase#getDomainClasses <em>Domain Classes</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.graal.GraalPackage#getUseCase()
 * @model
 * @generated
 */
public interface UseCase extends NamedElement, DomainModelRegistry {
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
	 * @see org.obeonetwork.graal.GraalPackage#getUseCase_Actors()
	 * @model
	 * @generated
	 */
	EList<Actor> getActors();

	/**
	 * Returns the value of the '<em><b>Tasks</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.graal.AbstractTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tasks</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tasks</em>' reference list.
	 * @see org.obeonetwork.graal.GraalPackage#getUseCase_Tasks()
	 * @model
	 * @generated
	 */
	EList<AbstractTask> getTasks();

	/**
	 * Returns the value of the '<em><b>Includes</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.graal.UseCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Includes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Includes</em>' reference list.
	 * @see org.obeonetwork.graal.GraalPackage#getUseCase_Includes()
	 * @model
	 * @generated
	 */
	EList<UseCase> getIncludes();

	/**
	 * Returns the value of the '<em><b>Extends</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.graal.UseCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' reference list.
	 * @see org.obeonetwork.graal.GraalPackage#getUseCase_Extends()
	 * @model
	 * @generated
	 */
	EList<UseCase> getExtends();

	/**
	 * Returns the value of the '<em><b>Domain Classes</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.graal.DomainClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Classes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Classes</em>' reference list.
	 * @see org.obeonetwork.graal.GraalPackage#getUseCase_DomainClasses()
	 * @model
	 * @generated
	 */
	EList<DomainClass> getDomainClasses();

} // UseCase
