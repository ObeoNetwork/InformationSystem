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
 * A representation of the model object '<em><b>Primary Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.PrimaryKey#getColumns <em>Columns</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.PrimaryKey#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.database.DatabasePackage#getPrimaryKey()
 * @model
 * @generated
 */
public interface PrimaryKey extends NamedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2011 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Columns</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.database.Column}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.database.Column#getPrimaryKey <em>Primary Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns</em>' reference list.
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getPrimaryKey_Columns()
	 * @see org.obeonetwork.dsl.database.Column#getPrimaryKey
	 * @model opposite="primaryKey"
	 * @generated
	 */
	EList<Column> getColumns();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.database.Table#getPrimaryKey <em>Primary Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Table)
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getPrimaryKey_Owner()
	 * @see org.obeonetwork.dsl.database.Table#getPrimaryKey
	 * @model opposite="primaryKey" required="true" transient="false"
	 * @generated
	 */
	Table getOwner();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.PrimaryKey#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Table value);

} // PrimaryKey
