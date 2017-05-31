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
package org.obeonetwork.dsl.database.dbevolution.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
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
import org.obeonetwork.dsl.database.dbevolution.DatabaseChangeSet;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionFactory;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage;
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

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class DbevolutionFactoryImpl extends EFactoryImpl implements DbevolutionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static DbevolutionFactory init() {
		try {
			DbevolutionFactory theDbevolutionFactory = (DbevolutionFactory)EPackage.Registry.INSTANCE.getEFactory(DbevolutionPackage.eNS_URI);
			if (theDbevolutionFactory != null) {
				return theDbevolutionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DbevolutionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public DbevolutionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DbevolutionPackage.DATABASE_CHANGE_SET: return createDatabaseChangeSet();
			case DbevolutionPackage.ADD_TABLE: return createAddTable();
			case DbevolutionPackage.REMOVE_TABLE: return createRemoveTable();
			case DbevolutionPackage.ALTER_TABLE: return createAlterTable();
			case DbevolutionPackage.RENAME_TABLE_CHANGE: return createRenameTableChange();
			case DbevolutionPackage.UPDATE_TABLE_COMMENT_CHANGE: return createUpdateTableCommentChange();
			case DbevolutionPackage.ADD_COLUMN_CHANGE: return createAddColumnChange();
			case DbevolutionPackage.REMOVE_COLUMN_CHANGE: return createRemoveColumnChange();
			case DbevolutionPackage.RENAME_COLUMN_CHANGE: return createRenameColumnChange();
			case DbevolutionPackage.UPDATE_COLUMN_CHANGE: return createUpdateColumnChange();
			case DbevolutionPackage.UPDATE_COLUMN_COMMENT_CHANGE: return createUpdateColumnCommentChange();
			case DbevolutionPackage.ADD_PRIMARY_KEY: return createAddPrimaryKey();
			case DbevolutionPackage.REMOVE_PRIMARY_KEY: return createRemovePrimaryKey();
			case DbevolutionPackage.UPDATE_PRIMARY_KEY: return createUpdatePrimaryKey();
			case DbevolutionPackage.ADD_INDEX: return createAddIndex();
			case DbevolutionPackage.REMOVE_INDEX: return createRemoveIndex();
			case DbevolutionPackage.UPDATE_INDEX: return createUpdateIndex();
			case DbevolutionPackage.ADD_FOREIGN_KEY: return createAddForeignKey();
			case DbevolutionPackage.REMOVE_FOREIGN_KEY: return createRemoveForeignKey();
			case DbevolutionPackage.UPDATE_FOREIGN_KEY: return createUpdateForeignKey();
			case DbevolutionPackage.ADD_CONSTRAINT: return createAddConstraint();
			case DbevolutionPackage.REMOVE_CONSTRAINT: return createRemoveConstraint();
			case DbevolutionPackage.UPDATE_CONSTRAINT: return createUpdateConstraint();
			case DbevolutionPackage.ADD_SEQUENCE: return createAddSequence();
			case DbevolutionPackage.REMOVE_SEQUENCE: return createRemoveSequence();
			case DbevolutionPackage.UPDATE_SEQUENCE: return createUpdateSequence();
			case DbevolutionPackage.SCHEMA_CHANGE: return createSchemaChange();
			case DbevolutionPackage.ADD_SCHEMA: return createAddSchema();
			case DbevolutionPackage.REMOVE_SCHEMA: return createRemoveSchema();
			case DbevolutionPackage.ALTER_SCHEMA: return createAlterSchema();
			case DbevolutionPackage.RENAME_SCHEMA_CHANGE: return createRenameSchemaChange();
			case DbevolutionPackage.UPDATE_SCHEMA_COMMENT_CHANGE: return createUpdateSchemaCommentChange();
			case DbevolutionPackage.ADD_VIEW: return createAddView();
			case DbevolutionPackage.REMOVE_VIEW: return createRemoveView();
			case DbevolutionPackage.ALTER_VIEW: return createAlterView();
			case DbevolutionPackage.RENAME_VIEW_CHANGE: return createRenameViewChange();
			case DbevolutionPackage.UPDATE_VIEW_COMMENT_CHANGE: return createUpdateViewCommentChange();
			case DbevolutionPackage.UPDATE_VIEW_QUERY_CHANGE: return createUpdateViewQueryChange();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AddTable createAddTable() {
		AddTableImpl addTable = new AddTableImpl();
		return addTable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveTable createRemoveTable() {
		RemoveTableImpl removeTable = new RemoveTableImpl();
		return removeTable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseChangeSet createDatabaseChangeSet() {
		DatabaseChangeSetImpl databaseChangeSet = new DatabaseChangeSetImpl();
		return databaseChangeSet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AlterTable createAlterTable() {
		AlterTableImpl alterTable = new AlterTableImpl();
		return alterTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RenameTableChange createRenameTableChange() {
		RenameTableChangeImpl renameTableChange = new RenameTableChangeImpl();
		return renameTableChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddColumnChange createAddColumnChange() {
		AddColumnChangeImpl addColumnChange = new AddColumnChangeImpl();
		return addColumnChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveColumnChange createRemoveColumnChange() {
		RemoveColumnChangeImpl removeColumnChange = new RemoveColumnChangeImpl();
		return removeColumnChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RenameColumnChange createRenameColumnChange() {
		RenameColumnChangeImpl renameColumnChange = new RenameColumnChangeImpl();
		return renameColumnChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UpdateColumnChange createUpdateColumnChange() {
		UpdateColumnChangeImpl updateColumnChange = new UpdateColumnChangeImpl();
		return updateColumnChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UpdateColumnCommentChange createUpdateColumnCommentChange() {
		UpdateColumnCommentChangeImpl updateColumnCommentChange = new UpdateColumnCommentChangeImpl();
		return updateColumnCommentChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UpdateTableCommentChange createUpdateTableCommentChange() {
		UpdateTableCommentChangeImpl updateTableCommentChange = new UpdateTableCommentChangeImpl();
		return updateTableCommentChange;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AddPrimaryKey createAddPrimaryKey() {
		AddPrimaryKeyImpl addPrimaryKey = new AddPrimaryKeyImpl();
		return addPrimaryKey;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RemovePrimaryKey createRemovePrimaryKey() {
		RemovePrimaryKeyImpl removePrimaryKey = new RemovePrimaryKeyImpl();
		return removePrimaryKey;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UpdatePrimaryKey createUpdatePrimaryKey() {
		UpdatePrimaryKeyImpl updatePrimaryKey = new UpdatePrimaryKeyImpl();
		return updatePrimaryKey;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AddIndex createAddIndex() {
		AddIndexImpl addIndex = new AddIndexImpl();
		return addIndex;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveIndex createRemoveIndex() {
		RemoveIndexImpl removeIndex = new RemoveIndexImpl();
		return removeIndex;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UpdateIndex createUpdateIndex() {
		UpdateIndexImpl updateIndex = new UpdateIndexImpl();
		return updateIndex;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AddForeignKey createAddForeignKey() {
		AddForeignKeyImpl addForeignKey = new AddForeignKeyImpl();
		return addForeignKey;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveForeignKey createRemoveForeignKey() {
		RemoveForeignKeyImpl removeForeignKey = new RemoveForeignKeyImpl();
		return removeForeignKey;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UpdateForeignKey createUpdateForeignKey() {
		UpdateForeignKeyImpl updateForeignKey = new UpdateForeignKeyImpl();
		return updateForeignKey;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AddConstraint createAddConstraint() {
		AddConstraintImpl addConstraint = new AddConstraintImpl();
		return addConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveConstraint createRemoveConstraint() {
		RemoveConstraintImpl removeConstraint = new RemoveConstraintImpl();
		return removeConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UpdateConstraint createUpdateConstraint() {
		UpdateConstraintImpl updateConstraint = new UpdateConstraintImpl();
		return updateConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddSequence createAddSequence() {
		AddSequenceImpl addSequence = new AddSequenceImpl();
		return addSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveSequence createRemoveSequence() {
		RemoveSequenceImpl removeSequence = new RemoveSequenceImpl();
		return removeSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UpdateSequence createUpdateSequence() {
		UpdateSequenceImpl updateSequence = new UpdateSequenceImpl();
		return updateSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchemaChange createSchemaChange() {
		SchemaChangeImpl schemaChange = new SchemaChangeImpl();
		return schemaChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddSchema createAddSchema() {
		AddSchemaImpl addSchema = new AddSchemaImpl();
		return addSchema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveSchema createRemoveSchema() {
		RemoveSchemaImpl removeSchema = new RemoveSchemaImpl();
		return removeSchema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlterSchema createAlterSchema() {
		AlterSchemaImpl alterSchema = new AlterSchemaImpl();
		return alterSchema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RenameSchemaChange createRenameSchemaChange() {
		RenameSchemaChangeImpl renameSchemaChange = new RenameSchemaChangeImpl();
		return renameSchemaChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UpdateSchemaCommentChange createUpdateSchemaCommentChange() {
		UpdateSchemaCommentChangeImpl updateSchemaCommentChange = new UpdateSchemaCommentChangeImpl();
		return updateSchemaCommentChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddView createAddView() {
		AddViewImpl addView = new AddViewImpl();
		return addView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveView createRemoveView() {
		RemoveViewImpl removeView = new RemoveViewImpl();
		return removeView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlterView createAlterView() {
		AlterViewImpl alterView = new AlterViewImpl();
		return alterView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RenameViewChange createRenameViewChange() {
		RenameViewChangeImpl renameViewChange = new RenameViewChangeImpl();
		return renameViewChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UpdateViewCommentChange createUpdateViewCommentChange() {
		UpdateViewCommentChangeImpl updateViewCommentChange = new UpdateViewCommentChangeImpl();
		return updateViewCommentChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UpdateViewQueryChange createUpdateViewQueryChange() {
		UpdateViewQueryChangeImpl updateViewQueryChange = new UpdateViewQueryChangeImpl();
		return updateViewQueryChange;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DbevolutionPackage getDbevolutionPackage() {
		return (DbevolutionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DbevolutionPackage getPackage() {
		return DbevolutionPackage.eINSTANCE;
	}

} // DbevolutionFactoryImpl
