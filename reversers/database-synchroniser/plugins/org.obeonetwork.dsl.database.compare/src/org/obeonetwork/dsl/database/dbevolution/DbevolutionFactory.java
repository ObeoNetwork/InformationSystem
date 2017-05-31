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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage
 * @generated
 */
public interface DbevolutionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	DbevolutionFactory eINSTANCE = org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Add Table</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Table</em>'.
	 * @generated
	 */
	AddTable createAddTable();

	/**
	 * Returns a new object of class '<em>Remove Table</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Remove Table</em>'.
	 * @generated
	 */
	RemoveTable createRemoveTable();

	/**
	 * Returns a new object of class '<em>Database Change Set</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Database Change Set</em>'.
	 * @generated
	 */
	DatabaseChangeSet createDatabaseChangeSet();

	/**
	 * Returns a new object of class '<em>Alter Table</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Alter Table</em>'.
	 * @generated
	 */
	AlterTable createAlterTable();

	/**
	 * Returns a new object of class '<em>Rename Table Change</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rename Table Change</em>'.
	 * @generated
	 */
	RenameTableChange createRenameTableChange();

	/**
	 * Returns a new object of class '<em>Add Column Change</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Column Change</em>'.
	 * @generated
	 */
	AddColumnChange createAddColumnChange();

	/**
	 * Returns a new object of class '<em>Remove Column Change</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remove Column Change</em>'.
	 * @generated
	 */
	RemoveColumnChange createRemoveColumnChange();

	/**
	 * Returns a new object of class '<em>Rename Column Change</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rename Column Change</em>'.
	 * @generated
	 */
	RenameColumnChange createRenameColumnChange();

	/**
	 * Returns a new object of class '<em>Update Column Change</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Update Column Change</em>'.
	 * @generated
	 */
	UpdateColumnChange createUpdateColumnChange();

	/**
	 * Returns a new object of class '<em>Update Column Comment Change</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Update Column Comment Change</em>'.
	 * @generated
	 */
	UpdateColumnCommentChange createUpdateColumnCommentChange();

	/**
	 * Returns a new object of class '<em>Update Table Comment Change</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Update Table Comment Change</em>'.
	 * @generated
	 */
	UpdateTableCommentChange createUpdateTableCommentChange();

	/**
	 * Returns a new object of class '<em>Add Primary Key</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Add Primary Key</em>'.
	 * @generated
	 */
	AddPrimaryKey createAddPrimaryKey();

	/**
	 * Returns a new object of class '<em>Remove Primary Key</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Remove Primary Key</em>'.
	 * @generated
	 */
	RemovePrimaryKey createRemovePrimaryKey();

	/**
	 * Returns a new object of class '<em>Update Primary Key</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Update Primary Key</em>'.
	 * @generated
	 */
	UpdatePrimaryKey createUpdatePrimaryKey();

	/**
	 * Returns a new object of class '<em>Add Index</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Index</em>'.
	 * @generated
	 */
	AddIndex createAddIndex();

	/**
	 * Returns a new object of class '<em>Remove Index</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Remove Index</em>'.
	 * @generated
	 */
	RemoveIndex createRemoveIndex();

	/**
	 * Returns a new object of class '<em>Update Index</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Update Index</em>'.
	 * @generated
	 */
	UpdateIndex createUpdateIndex();

	/**
	 * Returns a new object of class '<em>Add Foreign Key</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Add Foreign Key</em>'.
	 * @generated
	 */
	AddForeignKey createAddForeignKey();

	/**
	 * Returns a new object of class '<em>Remove Foreign Key</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Remove Foreign Key</em>'.
	 * @generated
	 */
	RemoveForeignKey createRemoveForeignKey();

	/**
	 * Returns a new object of class '<em>Update Foreign Key</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Update Foreign Key</em>'.
	 * @generated
	 */
	UpdateForeignKey createUpdateForeignKey();

	/**
	 * Returns a new object of class '<em>Add Constraint</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Add Constraint</em>'.
	 * @generated
	 */
	AddConstraint createAddConstraint();

	/**
	 * Returns a new object of class '<em>Remove Constraint</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Remove Constraint</em>'.
	 * @generated
	 */
	RemoveConstraint createRemoveConstraint();

	/**
	 * Returns a new object of class '<em>Update Constraint</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Update Constraint</em>'.
	 * @generated
	 */
	UpdateConstraint createUpdateConstraint();

	/**
	 * Returns a new object of class '<em>Add Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Sequence</em>'.
	 * @generated
	 */
	AddSequence createAddSequence();

	/**
	 * Returns a new object of class '<em>Remove Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remove Sequence</em>'.
	 * @generated
	 */
	RemoveSequence createRemoveSequence();

	/**
	 * Returns a new object of class '<em>Update Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Update Sequence</em>'.
	 * @generated
	 */
	UpdateSequence createUpdateSequence();

	/**
	 * Returns a new object of class '<em>Schema Change</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Schema Change</em>'.
	 * @generated
	 */
	SchemaChange createSchemaChange();

	/**
	 * Returns a new object of class '<em>Add Schema</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Schema</em>'.
	 * @generated
	 */
	AddSchema createAddSchema();

	/**
	 * Returns a new object of class '<em>Remove Schema</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remove Schema</em>'.
	 * @generated
	 */
	RemoveSchema createRemoveSchema();

	/**
	 * Returns a new object of class '<em>Alter Schema</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Alter Schema</em>'.
	 * @generated
	 */
	AlterSchema createAlterSchema();

	/**
	 * Returns a new object of class '<em>Rename Schema Change</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rename Schema Change</em>'.
	 * @generated
	 */
	RenameSchemaChange createRenameSchemaChange();

	/**
	 * Returns a new object of class '<em>Update Schema Comment Change</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Update Schema Comment Change</em>'.
	 * @generated
	 */
	UpdateSchemaCommentChange createUpdateSchemaCommentChange();

	/**
	 * Returns a new object of class '<em>Add View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add View</em>'.
	 * @generated
	 */
	AddView createAddView();

	/**
	 * Returns a new object of class '<em>Remove View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remove View</em>'.
	 * @generated
	 */
	RemoveView createRemoveView();

	/**
	 * Returns a new object of class '<em>Alter View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Alter View</em>'.
	 * @generated
	 */
	AlterView createAlterView();

	/**
	 * Returns a new object of class '<em>Rename View Change</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rename View Change</em>'.
	 * @generated
	 */
	RenameViewChange createRenameViewChange();

	/**
	 * Returns a new object of class '<em>Update View Comment Change</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Update View Comment Change</em>'.
	 * @generated
	 */
	UpdateViewCommentChange createUpdateViewCommentChange();

	/**
	 * Returns a new object of class '<em>Update View Query Change</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Update View Query Change</em>'.
	 * @generated
	 */
	UpdateViewQueryChange createUpdateViewQueryChange();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DbevolutionPackage getDbevolutionPackage();

} // DbevolutionFactory
