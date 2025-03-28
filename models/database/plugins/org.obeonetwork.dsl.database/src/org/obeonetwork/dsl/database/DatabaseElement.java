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
package org.obeonetwork.dsl.database;

import org.eclipse.emf.cdo.CDOObject;
import org.obeonetwork.dsl.environment.ObeoDSMObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.DatabaseElement#getID <em>ID</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.DatabaseElement#getComments <em>Comments</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.DatabaseElement#getTechID <em>Tech ID</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.database.DatabasePackage#getDatabaseElement()
 * @model abstract="true"
 * @generated
 */
public interface DatabaseElement extends ObeoDSMObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2025 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v2.0\r\nwhich accompanies this distribution, and is available at\r\nhttps://www.eclipse.org/legal/epl-2.0/\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The identifier of the element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>ID</em>' attribute.
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getDatabaseElement_ID()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getID();

	/**
	 * Returns the value of the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comments</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The comment.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Comments</em>' attribute.
	 * @see #setComments(String)
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getDatabaseElement_Comments()
	 * @model
	 * @generated
	 */
	String getComments();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.DatabaseElement#getComments <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comments</em>' attribute.
	 * @see #getComments()
	 * @generated
	 */
	void setComments(String value);

	/**
	 * Returns the value of the '<em><b>Tech ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tech ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Deprecated. Use ObeoDSMObject::technicalid instead.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Tech ID</em>' attribute.
	 * @see #setTechID(String)
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getDatabaseElement_TechID()
	 * @model volatile="true" derived="true"
	 * @generated
	 */
	String getTechID();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.DatabaseElement#getTechID <em>Tech ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tech ID</em>' attribute.
	 * @see #getTechID()
	 * @generated
	 */
	void setTechID(String value);

} // DatabaseElement
