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

import org.obeonetwork.dsl.database.Table;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rename Table Change</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.dbevolution.RenameTableChange#getNewTable <em>New Table</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getRenameTableChange()
 * @model
 * @generated
 */
public interface RenameTableChange extends TableChange {
	/**
	 * Returns the value of the '<em><b>New Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Table</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Table</em>' reference.
	 * @see #setNewTable(Table)
	 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getRenameTableChange_NewTable()
	 * @model required="true"
	 * @generated
	 */
	Table getNewTable();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.dbevolution.RenameTableChange#getNewTable <em>New Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Table</em>' reference.
	 * @see #getNewTable()
	 * @generated
	 */
	void setNewTable(Table value);

} // RenameTableChange
