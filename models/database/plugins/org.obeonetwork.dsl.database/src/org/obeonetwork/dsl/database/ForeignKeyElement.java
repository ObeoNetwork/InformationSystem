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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Foreign Key Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.ForeignKeyElement#getFkColumn <em>Fk Column</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.ForeignKeyElement#getPkColumn <em>Pk Column</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.database.DatabasePackage#getForeignKeyElement()
 * @model
 * @generated
 */
public interface ForeignKeyElement extends DatabaseElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2025 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v2.0\r\nwhich accompanies this distribution, and is available at\r\nhttps://www.eclipse.org/legal/epl-2.0/\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Fk Column</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.database.Column#getForeignKeyElements <em>Foreign Key Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fk Column</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The foreign key column.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fk Column</em>' reference.
	 * @see #setFkColumn(Column)
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getForeignKeyElement_FkColumn()
	 * @see org.obeonetwork.dsl.database.Column#getForeignKeyElements
	 * @model opposite="foreignKeyElements"
	 * @generated
	 */
	Column getFkColumn();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.ForeignKeyElement#getFkColumn <em>Fk Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fk Column</em>' reference.
	 * @see #getFkColumn()
	 * @generated
	 */
	void setFkColumn(Column value);

	/**
	 * Returns the value of the '<em><b>Pk Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pk Column</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The primary key column.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pk Column</em>' reference.
	 * @see #setPkColumn(Column)
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getForeignKeyElement_PkColumn()
	 * @model
	 * @generated
	 */
	Column getPkColumn();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.ForeignKeyElement#getPkColumn <em>Pk Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pk Column</em>' reference.
	 * @see #getPkColumn()
	 * @generated
	 */
	void setPkColumn(Column value);

} // ForeignKeyElement
