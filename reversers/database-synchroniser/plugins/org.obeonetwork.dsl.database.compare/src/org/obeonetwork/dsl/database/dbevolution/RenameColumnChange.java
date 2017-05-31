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

import org.obeonetwork.dsl.database.Column;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rename Column Change</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.dbevolution.RenameColumnChange#getNewColumn <em>New Column</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getRenameColumnChange()
 * @model
 * @generated
 */
public interface RenameColumnChange extends ColumnChange {

	/**
	 * Returns the value of the '<em><b>New Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Column</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Column</em>' reference.
	 * @see #setNewColumn(Column)
	 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getRenameColumnChange_NewColumn()
	 * @model required="true"
	 * @generated
	 */
	Column getNewColumn();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.dbevolution.RenameColumnChange#getNewColumn <em>New Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Column</em>' reference.
	 * @see #getNewColumn()
	 * @generated
	 */
	void setNewColumn(Column value);
} // RenameColumnChange
