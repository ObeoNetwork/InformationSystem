/*******************************************************************************
 * Copyright (c) 2011, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.dbevolution;

import org.obeonetwork.dsl.database.PrimaryKey;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Update Primary Key</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.dbevolution.UpdatePrimaryKey#getNewPrimaryKey <em>New Primary Key</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getUpdatePrimaryKey()
 * @model
 * @generated
 */
public interface UpdatePrimaryKey extends PrimaryKeyChange {

	/**
	 * Returns the value of the '<em><b>New Primary Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Primary Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Primary Key</em>' reference.
	 * @see #setNewPrimaryKey(PrimaryKey)
	 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getUpdatePrimaryKey_NewPrimaryKey()
	 * @model required="true"
	 * @generated
	 */
	PrimaryKey getNewPrimaryKey();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.dbevolution.UpdatePrimaryKey#getNewPrimaryKey <em>New Primary Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Primary Key</em>' reference.
	 * @see #getNewPrimaryKey()
	 * @generated
	 */
	void setNewPrimaryKey(PrimaryKey value);

} // UpdatePrimaryKey
