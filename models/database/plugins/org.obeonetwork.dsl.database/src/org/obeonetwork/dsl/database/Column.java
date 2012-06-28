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

import org.obeonetwork.dsl.typeslibrary.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Column</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.Column#isNullable <em>Nullable</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.Column#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.Column#getIndexes <em>Indexes</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.Column#getIndexElements <em>Index Elements</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.Column#getPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.Column#getForeignKeys <em>Foreign Keys</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.Column#getForeignKeyElements <em>Foreign Key Elements</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.Column#getType <em>Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.Column#getSequence <em>Sequence</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.Column#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.Column#isAutoincrement <em>Autoincrement</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.Column#isInPrimaryKey <em>In Primary Key</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.Column#isInForeignKey <em>In Foreign Key</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.Column#isUnique <em>Unique</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.database.DatabasePackage#getColumn()
 * @model
 * @generated
 */
public interface Column extends NamedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2011 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nullable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nullable</em>' attribute.
	 * @see #setNullable(boolean)
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getColumn_Nullable()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isNullable();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.Column#isNullable <em>Nullable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nullable</em>' attribute.
	 * @see #isNullable()
	 * @generated
	 */
	void setNullable(boolean value);

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' attribute.
	 * @see #setDefaultValue(String)
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getColumn_DefaultValue()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	String getDefaultValue();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.Column#getDefaultValue <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' attribute.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(String value);

	/**
	 * Returns the value of the '<em><b>Indexes</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.database.Index}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Indexes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indexes</em>' reference list.
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getColumn_Indexes()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Index> getIndexes();

	/**
	 * Returns the value of the '<em><b>Index Elements</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.database.IndexElement}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.database.IndexElement#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Elements</em>' reference list.
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getColumn_IndexElements()
	 * @see org.obeonetwork.dsl.database.IndexElement#getColumn
	 * @model opposite="column"
	 * @generated
	 */
	EList<IndexElement> getIndexElements();

	/**
	 * Returns the value of the '<em><b>Primary Key</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.database.PrimaryKey#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Key</em>' reference.
	 * @see #setPrimaryKey(PrimaryKey)
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getColumn_PrimaryKey()
	 * @see org.obeonetwork.dsl.database.PrimaryKey#getColumns
	 * @model opposite="columns"
	 * @generated
	 */
	PrimaryKey getPrimaryKey();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.Column#getPrimaryKey <em>Primary Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Key</em>' reference.
	 * @see #getPrimaryKey()
	 * @generated
	 */
	void setPrimaryKey(PrimaryKey value);

	/**
	 * Returns the value of the '<em><b>Foreign Keys</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.database.ForeignKey}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreign Keys</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foreign Keys</em>' reference list.
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getColumn_ForeignKeys()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<ForeignKey> getForeignKeys();

	/**
	 * Returns the value of the '<em><b>Foreign Key Elements</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.database.ForeignKeyElement}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.database.ForeignKeyElement#getFkColumn <em>Fk Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreign Key Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foreign Key Elements</em>' reference list.
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getColumn_ForeignKeyElements()
	 * @see org.obeonetwork.dsl.database.ForeignKeyElement#getFkColumn
	 * @model opposite="fkColumn"
	 * @generated
	 */
	EList<ForeignKeyElement> getForeignKeyElements();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(Type)
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getColumn_Type()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.Column#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

	/**
	 * Returns the value of the '<em><b>Sequence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence</em>' reference.
	 * @see #setSequence(Sequence)
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getColumn_Sequence()
	 * @model
	 * @generated
	 */
	Sequence getSequence();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.Column#getSequence <em>Sequence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence</em>' reference.
	 * @see #getSequence()
	 * @generated
	 */
	void setSequence(Sequence value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.database.AbstractTable#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(AbstractTable)
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getColumn_Owner()
	 * @see org.obeonetwork.dsl.database.AbstractTable#getColumns
	 * @model opposite="columns" required="true" transient="false"
	 * @generated
	 */
	AbstractTable getOwner();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.Column#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(AbstractTable value);

	/**
	 * Returns the value of the '<em><b>Autoincrement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Autoincrement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Autoincrement</em>' attribute.
	 * @see #setAutoincrement(boolean)
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getColumn_Autoincrement()
	 * @model
	 * @generated
	 */
	boolean isAutoincrement();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.Column#isAutoincrement <em>Autoincrement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Autoincrement</em>' attribute.
	 * @see #isAutoincrement()
	 * @generated
	 */
	void setAutoincrement(boolean value);

	/**
	 * Returns the value of the '<em><b>In Primary Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Primary Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Primary Key</em>' attribute.
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getColumn_InPrimaryKey()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isInPrimaryKey();

	/**
	 * Returns the value of the '<em><b>In Foreign Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Foreign Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Foreign Key</em>' attribute.
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getColumn_InForeignKey()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isInForeignKey();

	/**
	 * Returns the value of the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unique</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unique</em>' attribute.
	 * @see org.obeonetwork.dsl.database.DatabasePackage#getColumn_Unique()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isUnique();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addToPrimaryKey();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addToUniqueIndex();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void removeFromPrimaryKey();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void removeFromUniqueIndex();

} // Column
