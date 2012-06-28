/**
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.database;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.Table#getPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.Table#getForeignKeys <em>Foreign Keys</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.Table#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.Table#getIndexes <em>Indexes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.database.DatabasePackage#getTable()
 * @model
 * @generated
 */
public interface Table extends AbstractTable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2011 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Primary Key</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.database.PrimaryKey#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Key</em>' containment reference.
	 * @see #setPrimaryKey(PrimaryKey)
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getTable_PrimaryKey()
	 * @see org.obeonetwork.dsl.database.PrimaryKey#getOwner
	 * @model opposite="owner" containment="true" ordered="false"
	 * @generated
	 */
	PrimaryKey getPrimaryKey();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.Table#getPrimaryKey <em>Primary Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Key</em>' containment reference.
	 * @see #getPrimaryKey()
	 * @generated
	 */
	void setPrimaryKey(PrimaryKey value);

	/**
	 * Returns the value of the '<em><b>Foreign Keys</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.database.ForeignKey}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.database.ForeignKey#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreign Keys</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foreign Keys</em>' containment reference list.
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getTable_ForeignKeys()
	 * @see org.obeonetwork.dsl.database.ForeignKey#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<ForeignKey> getForeignKeys();

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.database.Constraint}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.database.Constraint#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getTable_Constraints()
	 * @see org.obeonetwork.dsl.database.Constraint#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Constraint> getConstraints();

	/**
	 * Returns the value of the '<em><b>Indexes</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.database.Index}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.database.Index#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Indexes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indexes</em>' containment reference list.
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getTable_Indexes()
	 * @see org.obeonetwork.dsl.database.Index#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Index> getIndexes();

} // Table
