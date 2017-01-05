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
package org.obeonetwork.dsl.database.dbevolution.util;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.obeonetwork.dsl.database.dbevolution.AddColumnChange;
import org.obeonetwork.dsl.database.dbevolution.AddConstraint;
import org.obeonetwork.dsl.database.dbevolution.AddForeignKey;
import org.obeonetwork.dsl.database.dbevolution.AddIndex;
import org.obeonetwork.dsl.database.dbevolution.AddPrimaryKey;
import org.obeonetwork.dsl.database.dbevolution.AddSchema;
import org.obeonetwork.dsl.database.dbevolution.AddSequence;
import org.obeonetwork.dsl.database.dbevolution.AddTable;
import org.obeonetwork.dsl.database.dbevolution.AddView;
import org.obeonetwork.dsl.database.dbevolution.AlterSchema;
import org.obeonetwork.dsl.database.dbevolution.AlterTable;
import org.obeonetwork.dsl.database.dbevolution.AlterView;
import org.obeonetwork.dsl.database.dbevolution.ColumnChange;
import org.obeonetwork.dsl.database.dbevolution.ConstraintChange;
import org.obeonetwork.dsl.database.dbevolution.DBDiff;
import org.obeonetwork.dsl.database.dbevolution.DatabaseChangeSet;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage;
import org.obeonetwork.dsl.database.dbevolution.ForeignKeyChange;
import org.obeonetwork.dsl.database.dbevolution.IndexChange;
import org.obeonetwork.dsl.database.dbevolution.PrimaryKeyChange;
import org.obeonetwork.dsl.database.dbevolution.RemoveColumnChange;
import org.obeonetwork.dsl.database.dbevolution.RemoveConstraint;
import org.obeonetwork.dsl.database.dbevolution.RemoveForeignKey;
import org.obeonetwork.dsl.database.dbevolution.RemoveIndex;
import org.obeonetwork.dsl.database.dbevolution.RemovePrimaryKey;
import org.obeonetwork.dsl.database.dbevolution.RemoveSchema;
import org.obeonetwork.dsl.database.dbevolution.RemoveSequence;
import org.obeonetwork.dsl.database.dbevolution.RemoveTable;
import org.obeonetwork.dsl.database.dbevolution.RemoveView;
import org.obeonetwork.dsl.database.dbevolution.RenameColumnChange;
import org.obeonetwork.dsl.database.dbevolution.RenameSchemaChange;
import org.obeonetwork.dsl.database.dbevolution.RenameTableChange;
import org.obeonetwork.dsl.database.dbevolution.RenameViewChange;
import org.obeonetwork.dsl.database.dbevolution.SchemaChange;
import org.obeonetwork.dsl.database.dbevolution.SequenceChange;
import org.obeonetwork.dsl.database.dbevolution.TableChange;
import org.obeonetwork.dsl.database.dbevolution.UpdateColumnChange;
import org.obeonetwork.dsl.database.dbevolution.UpdateColumnCommentChange;
import org.obeonetwork.dsl.database.dbevolution.UpdateConstraint;
import org.obeonetwork.dsl.database.dbevolution.UpdateForeignKey;
import org.obeonetwork.dsl.database.dbevolution.UpdateIndex;
import org.obeonetwork.dsl.database.dbevolution.UpdatePrimaryKey;
import org.obeonetwork.dsl.database.dbevolution.UpdateSchemaCommentChange;
import org.obeonetwork.dsl.database.dbevolution.UpdateSequence;
import org.obeonetwork.dsl.database.dbevolution.UpdateTableCommentChange;
import org.obeonetwork.dsl.database.dbevolution.UpdateViewCommentChange;
import org.obeonetwork.dsl.database.dbevolution.UpdateViewQueryChange;
import org.obeonetwork.dsl.database.dbevolution.ViewChange;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage
 * @generated
 */
public class DbevolutionSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static DbevolutionPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public DbevolutionSwitch() {
		if (modelPackage == null) {
			modelPackage = DbevolutionPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DbevolutionPackage.DATABASE_CHANGE_SET: {
				DatabaseChangeSet databaseChangeSet = (DatabaseChangeSet)theEObject;
				T result = caseDatabaseChangeSet(databaseChangeSet);
				if (result == null) result = caseComparison(databaseChangeSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.TABLE_CHANGE: {
				TableChange tableChange = (TableChange)theEObject;
				T result = caseTableChange(tableChange);
				if (result == null) result = caseDBDiff(tableChange);
				if (result == null) result = caseDiff(tableChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.ADD_TABLE: {
				AddTable addTable = (AddTable)theEObject;
				T result = caseAddTable(addTable);
				if (result == null) result = caseTableChange(addTable);
				if (result == null) result = caseDBDiff(addTable);
				if (result == null) result = caseDiff(addTable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.REMOVE_TABLE: {
				RemoveTable removeTable = (RemoveTable)theEObject;
				T result = caseRemoveTable(removeTable);
				if (result == null) result = caseTableChange(removeTable);
				if (result == null) result = caseDBDiff(removeTable);
				if (result == null) result = caseDiff(removeTable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.ALTER_TABLE: {
				AlterTable alterTable = (AlterTable)theEObject;
				T result = caseAlterTable(alterTable);
				if (result == null) result = caseTableChange(alterTable);
				if (result == null) result = caseDBDiff(alterTable);
				if (result == null) result = caseDiff(alterTable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.RENAME_TABLE_CHANGE: {
				RenameTableChange renameTableChange = (RenameTableChange)theEObject;
				T result = caseRenameTableChange(renameTableChange);
				if (result == null) result = caseTableChange(renameTableChange);
				if (result == null) result = caseDBDiff(renameTableChange);
				if (result == null) result = caseDiff(renameTableChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.UPDATE_TABLE_COMMENT_CHANGE: {
				UpdateTableCommentChange updateTableCommentChange = (UpdateTableCommentChange)theEObject;
				T result = caseUpdateTableCommentChange(updateTableCommentChange);
				if (result == null) result = caseTableChange(updateTableCommentChange);
				if (result == null) result = caseDBDiff(updateTableCommentChange);
				if (result == null) result = caseDiff(updateTableCommentChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.COLUMN_CHANGE: {
				ColumnChange columnChange = (ColumnChange)theEObject;
				T result = caseColumnChange(columnChange);
				if (result == null) result = caseDBDiff(columnChange);
				if (result == null) result = caseDiff(columnChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.ADD_COLUMN_CHANGE: {
				AddColumnChange addColumnChange = (AddColumnChange)theEObject;
				T result = caseAddColumnChange(addColumnChange);
				if (result == null) result = caseColumnChange(addColumnChange);
				if (result == null) result = caseDBDiff(addColumnChange);
				if (result == null) result = caseDiff(addColumnChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.REMOVE_COLUMN_CHANGE: {
				RemoveColumnChange removeColumnChange = (RemoveColumnChange)theEObject;
				T result = caseRemoveColumnChange(removeColumnChange);
				if (result == null) result = caseColumnChange(removeColumnChange);
				if (result == null) result = caseDBDiff(removeColumnChange);
				if (result == null) result = caseDiff(removeColumnChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.RENAME_COLUMN_CHANGE: {
				RenameColumnChange renameColumnChange = (RenameColumnChange)theEObject;
				T result = caseRenameColumnChange(renameColumnChange);
				if (result == null) result = caseColumnChange(renameColumnChange);
				if (result == null) result = caseDBDiff(renameColumnChange);
				if (result == null) result = caseDiff(renameColumnChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.UPDATE_COLUMN_CHANGE: {
				UpdateColumnChange updateColumnChange = (UpdateColumnChange)theEObject;
				T result = caseUpdateColumnChange(updateColumnChange);
				if (result == null) result = caseColumnChange(updateColumnChange);
				if (result == null) result = caseDBDiff(updateColumnChange);
				if (result == null) result = caseDiff(updateColumnChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.UPDATE_COLUMN_COMMENT_CHANGE: {
				UpdateColumnCommentChange updateColumnCommentChange = (UpdateColumnCommentChange)theEObject;
				T result = caseUpdateColumnCommentChange(updateColumnCommentChange);
				if (result == null) result = caseColumnChange(updateColumnCommentChange);
				if (result == null) result = caseDBDiff(updateColumnCommentChange);
				if (result == null) result = caseDiff(updateColumnCommentChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.PRIMARY_KEY_CHANGE: {
				PrimaryKeyChange primaryKeyChange = (PrimaryKeyChange)theEObject;
				T result = casePrimaryKeyChange(primaryKeyChange);
				if (result == null) result = caseDBDiff(primaryKeyChange);
				if (result == null) result = caseDiff(primaryKeyChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.ADD_PRIMARY_KEY: {
				AddPrimaryKey addPrimaryKey = (AddPrimaryKey)theEObject;
				T result = caseAddPrimaryKey(addPrimaryKey);
				if (result == null) result = casePrimaryKeyChange(addPrimaryKey);
				if (result == null) result = caseDBDiff(addPrimaryKey);
				if (result == null) result = caseDiff(addPrimaryKey);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.REMOVE_PRIMARY_KEY: {
				RemovePrimaryKey removePrimaryKey = (RemovePrimaryKey)theEObject;
				T result = caseRemovePrimaryKey(removePrimaryKey);
				if (result == null) result = casePrimaryKeyChange(removePrimaryKey);
				if (result == null) result = caseDBDiff(removePrimaryKey);
				if (result == null) result = caseDiff(removePrimaryKey);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.UPDATE_PRIMARY_KEY: {
				UpdatePrimaryKey updatePrimaryKey = (UpdatePrimaryKey)theEObject;
				T result = caseUpdatePrimaryKey(updatePrimaryKey);
				if (result == null) result = casePrimaryKeyChange(updatePrimaryKey);
				if (result == null) result = caseDBDiff(updatePrimaryKey);
				if (result == null) result = caseDiff(updatePrimaryKey);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.INDEX_CHANGE: {
				IndexChange indexChange = (IndexChange)theEObject;
				T result = caseIndexChange(indexChange);
				if (result == null) result = caseDBDiff(indexChange);
				if (result == null) result = caseDiff(indexChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.ADD_INDEX: {
				AddIndex addIndex = (AddIndex)theEObject;
				T result = caseAddIndex(addIndex);
				if (result == null) result = caseIndexChange(addIndex);
				if (result == null) result = caseDBDiff(addIndex);
				if (result == null) result = caseDiff(addIndex);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.REMOVE_INDEX: {
				RemoveIndex removeIndex = (RemoveIndex)theEObject;
				T result = caseRemoveIndex(removeIndex);
				if (result == null) result = caseIndexChange(removeIndex);
				if (result == null) result = caseDBDiff(removeIndex);
				if (result == null) result = caseDiff(removeIndex);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.UPDATE_INDEX: {
				UpdateIndex updateIndex = (UpdateIndex)theEObject;
				T result = caseUpdateIndex(updateIndex);
				if (result == null) result = caseIndexChange(updateIndex);
				if (result == null) result = caseDBDiff(updateIndex);
				if (result == null) result = caseDiff(updateIndex);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.FOREIGN_KEY_CHANGE: {
				ForeignKeyChange foreignKeyChange = (ForeignKeyChange)theEObject;
				T result = caseForeignKeyChange(foreignKeyChange);
				if (result == null) result = caseDBDiff(foreignKeyChange);
				if (result == null) result = caseDiff(foreignKeyChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.ADD_FOREIGN_KEY: {
				AddForeignKey addForeignKey = (AddForeignKey)theEObject;
				T result = caseAddForeignKey(addForeignKey);
				if (result == null) result = caseForeignKeyChange(addForeignKey);
				if (result == null) result = caseDBDiff(addForeignKey);
				if (result == null) result = caseDiff(addForeignKey);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.REMOVE_FOREIGN_KEY: {
				RemoveForeignKey removeForeignKey = (RemoveForeignKey)theEObject;
				T result = caseRemoveForeignKey(removeForeignKey);
				if (result == null) result = caseForeignKeyChange(removeForeignKey);
				if (result == null) result = caseDBDiff(removeForeignKey);
				if (result == null) result = caseDiff(removeForeignKey);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.UPDATE_FOREIGN_KEY: {
				UpdateForeignKey updateForeignKey = (UpdateForeignKey)theEObject;
				T result = caseUpdateForeignKey(updateForeignKey);
				if (result == null) result = caseForeignKeyChange(updateForeignKey);
				if (result == null) result = caseDBDiff(updateForeignKey);
				if (result == null) result = caseDiff(updateForeignKey);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.CONSTRAINT_CHANGE: {
				ConstraintChange constraintChange = (ConstraintChange)theEObject;
				T result = caseConstraintChange(constraintChange);
				if (result == null) result = caseDBDiff(constraintChange);
				if (result == null) result = caseDiff(constraintChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.ADD_CONSTRAINT: {
				AddConstraint addConstraint = (AddConstraint)theEObject;
				T result = caseAddConstraint(addConstraint);
				if (result == null) result = caseConstraintChange(addConstraint);
				if (result == null) result = caseDBDiff(addConstraint);
				if (result == null) result = caseDiff(addConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.REMOVE_CONSTRAINT: {
				RemoveConstraint removeConstraint = (RemoveConstraint)theEObject;
				T result = caseRemoveConstraint(removeConstraint);
				if (result == null) result = caseConstraintChange(removeConstraint);
				if (result == null) result = caseDBDiff(removeConstraint);
				if (result == null) result = caseDiff(removeConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.UPDATE_CONSTRAINT: {
				UpdateConstraint updateConstraint = (UpdateConstraint)theEObject;
				T result = caseUpdateConstraint(updateConstraint);
				if (result == null) result = caseConstraintChange(updateConstraint);
				if (result == null) result = caseDBDiff(updateConstraint);
				if (result == null) result = caseDiff(updateConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.SEQUENCE_CHANGE: {
				SequenceChange sequenceChange = (SequenceChange)theEObject;
				T result = caseSequenceChange(sequenceChange);
				if (result == null) result = caseDBDiff(sequenceChange);
				if (result == null) result = caseDiff(sequenceChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.ADD_SEQUENCE: {
				AddSequence addSequence = (AddSequence)theEObject;
				T result = caseAddSequence(addSequence);
				if (result == null) result = caseSequenceChange(addSequence);
				if (result == null) result = caseDBDiff(addSequence);
				if (result == null) result = caseDiff(addSequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.REMOVE_SEQUENCE: {
				RemoveSequence removeSequence = (RemoveSequence)theEObject;
				T result = caseRemoveSequence(removeSequence);
				if (result == null) result = caseSequenceChange(removeSequence);
				if (result == null) result = caseDBDiff(removeSequence);
				if (result == null) result = caseDiff(removeSequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.UPDATE_SEQUENCE: {
				UpdateSequence updateSequence = (UpdateSequence)theEObject;
				T result = caseUpdateSequence(updateSequence);
				if (result == null) result = caseSequenceChange(updateSequence);
				if (result == null) result = caseDBDiff(updateSequence);
				if (result == null) result = caseDiff(updateSequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.SCHEMA_CHANGE: {
				SchemaChange schemaChange = (SchemaChange)theEObject;
				T result = caseSchemaChange(schemaChange);
				if (result == null) result = caseDBDiff(schemaChange);
				if (result == null) result = caseDiff(schemaChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.ADD_SCHEMA: {
				AddSchema addSchema = (AddSchema)theEObject;
				T result = caseAddSchema(addSchema);
				if (result == null) result = caseSchemaChange(addSchema);
				if (result == null) result = caseDBDiff(addSchema);
				if (result == null) result = caseDiff(addSchema);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.REMOVE_SCHEMA: {
				RemoveSchema removeSchema = (RemoveSchema)theEObject;
				T result = caseRemoveSchema(removeSchema);
				if (result == null) result = caseSchemaChange(removeSchema);
				if (result == null) result = caseDBDiff(removeSchema);
				if (result == null) result = caseDiff(removeSchema);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.ALTER_SCHEMA: {
				AlterSchema alterSchema = (AlterSchema)theEObject;
				T result = caseAlterSchema(alterSchema);
				if (result == null) result = caseSchemaChange(alterSchema);
				if (result == null) result = caseDBDiff(alterSchema);
				if (result == null) result = caseDiff(alterSchema);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.RENAME_SCHEMA_CHANGE: {
				RenameSchemaChange renameSchemaChange = (RenameSchemaChange)theEObject;
				T result = caseRenameSchemaChange(renameSchemaChange);
				if (result == null) result = caseSchemaChange(renameSchemaChange);
				if (result == null) result = caseDBDiff(renameSchemaChange);
				if (result == null) result = caseDiff(renameSchemaChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.UPDATE_SCHEMA_COMMENT_CHANGE: {
				UpdateSchemaCommentChange updateSchemaCommentChange = (UpdateSchemaCommentChange)theEObject;
				T result = caseUpdateSchemaCommentChange(updateSchemaCommentChange);
				if (result == null) result = caseSchemaChange(updateSchemaCommentChange);
				if (result == null) result = caseDBDiff(updateSchemaCommentChange);
				if (result == null) result = caseDiff(updateSchemaCommentChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.DB_DIFF: {
				DBDiff dbDiff = (DBDiff)theEObject;
				T result = caseDBDiff(dbDiff);
				if (result == null) result = caseDiff(dbDiff);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.VIEW_CHANGE: {
				ViewChange viewChange = (ViewChange)theEObject;
				T result = caseViewChange(viewChange);
				if (result == null) result = caseDBDiff(viewChange);
				if (result == null) result = caseDiff(viewChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.ADD_VIEW: {
				AddView addView = (AddView)theEObject;
				T result = caseAddView(addView);
				if (result == null) result = caseViewChange(addView);
				if (result == null) result = caseDBDiff(addView);
				if (result == null) result = caseDiff(addView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.REMOVE_VIEW: {
				RemoveView removeView = (RemoveView)theEObject;
				T result = caseRemoveView(removeView);
				if (result == null) result = caseViewChange(removeView);
				if (result == null) result = caseDBDiff(removeView);
				if (result == null) result = caseDiff(removeView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.ALTER_VIEW: {
				AlterView alterView = (AlterView)theEObject;
				T result = caseAlterView(alterView);
				if (result == null) result = caseViewChange(alterView);
				if (result == null) result = caseDBDiff(alterView);
				if (result == null) result = caseDiff(alterView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.RENAME_VIEW_CHANGE: {
				RenameViewChange renameViewChange = (RenameViewChange)theEObject;
				T result = caseRenameViewChange(renameViewChange);
				if (result == null) result = caseViewChange(renameViewChange);
				if (result == null) result = caseDBDiff(renameViewChange);
				if (result == null) result = caseDiff(renameViewChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.UPDATE_VIEW_COMMENT_CHANGE: {
				UpdateViewCommentChange updateViewCommentChange = (UpdateViewCommentChange)theEObject;
				T result = caseUpdateViewCommentChange(updateViewCommentChange);
				if (result == null) result = caseViewChange(updateViewCommentChange);
				if (result == null) result = caseDBDiff(updateViewCommentChange);
				if (result == null) result = caseDiff(updateViewCommentChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DbevolutionPackage.UPDATE_VIEW_QUERY_CHANGE: {
				UpdateViewQueryChange updateViewQueryChange = (UpdateViewQueryChange)theEObject;
				T result = caseUpdateViewQueryChange(updateViewQueryChange);
				if (result == null) result = caseViewChange(updateViewQueryChange);
				if (result == null) result = caseDBDiff(updateViewQueryChange);
				if (result == null) result = caseDiff(updateViewQueryChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Table</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Table</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddTable(AddTable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remove Table</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove Table</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemoveTable(RemoveTable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Database Change Set</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate
	 * the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Database Change Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDatabaseChangeSet(DatabaseChangeSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Table Change</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Table Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTableChange(TableChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Alter Table</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Alter Table</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlterTable(AlterTable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rename Table Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rename Table Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRenameTableChange(RenameTableChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Column Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Column Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseColumnChange(ColumnChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Column Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Column Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddColumnChange(AddColumnChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remove Column Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove Column Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemoveColumnChange(RemoveColumnChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rename Column Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rename Column Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRenameColumnChange(RenameColumnChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update Column Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update Column Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdateColumnChange(UpdateColumnChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update Column Comment Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update Column Comment Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdateColumnCommentChange(UpdateColumnCommentChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update Table Comment Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update Table Comment Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdateTableCommentChange(UpdateTableCommentChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primary Key Change</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primary Key Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimaryKeyChange(PrimaryKeyChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Primary Key</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Primary Key</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddPrimaryKey(AddPrimaryKey object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remove Primary Key</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove Primary Key</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemovePrimaryKey(RemovePrimaryKey object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update Primary Key</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update Primary Key</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdatePrimaryKey(UpdatePrimaryKey object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Index Change</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Index Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIndexChange(IndexChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Index</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Index</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddIndex(AddIndex object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remove Index</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove Index</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemoveIndex(RemoveIndex object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update Index</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update Index</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdateIndex(UpdateIndex object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Foreign Key Change</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Foreign Key Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForeignKeyChange(ForeignKeyChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Foreign Key</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Foreign Key</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddForeignKey(AddForeignKey object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remove Foreign Key</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove Foreign Key</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemoveForeignKey(RemoveForeignKey object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update Foreign Key</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update Foreign Key</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdateForeignKey(UpdateForeignKey object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint Change</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraintChange(ConstraintChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddConstraint(AddConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remove Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemoveConstraint(RemoveConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdateConstraint(UpdateConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceChange(SequenceChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddSequence(AddSequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remove Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemoveSequence(RemoveSequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdateSequence(UpdateSequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Schema Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Schema Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSchemaChange(SchemaChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Schema</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Schema</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddSchema(AddSchema object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remove Schema</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove Schema</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemoveSchema(RemoveSchema object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Alter Schema</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Alter Schema</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlterSchema(AlterSchema object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rename Schema Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rename Schema Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRenameSchemaChange(RenameSchemaChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update Schema Comment Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update Schema Comment Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdateSchemaCommentChange(UpdateSchemaCommentChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB Diff</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB Diff</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDBDiff(DBDiff object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>View Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>View Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseViewChange(ViewChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddView(AddView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remove View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemoveView(RemoveView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Alter View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Alter View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlterView(AlterView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rename View Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rename View Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRenameViewChange(RenameViewChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update View Comment Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update View Comment Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdateViewCommentChange(UpdateViewCommentChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update View Query Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update View Query Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdateViewQueryChange(UpdateViewQueryChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Comparison</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Comparison</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComparison(Comparison object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Diff</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Diff</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiff(Diff object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch, but this is
	 * the last case anyway. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} // DbevolutionSwitch
