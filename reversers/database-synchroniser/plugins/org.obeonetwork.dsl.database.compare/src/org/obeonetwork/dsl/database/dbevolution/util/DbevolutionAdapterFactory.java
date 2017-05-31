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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.ecore.EObject;
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
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides
 * an adapter <code>createXXX</code> method for each class of the model. <!--
 * end-user-doc -->
 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage
 * @generated
 */
public class DbevolutionAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static DbevolutionPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public DbevolutionAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DbevolutionPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc --> This implementation returns <code>true</code> if
	 * the object is either the model's package or is an instance object of the
	 * model. <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DbevolutionSwitch<Adapter> modelSwitch = new DbevolutionSwitch<Adapter>() {
			@Override
			public Adapter caseDatabaseChangeSet(DatabaseChangeSet object) {
				return createDatabaseChangeSetAdapter();
			}
			@Override
			public Adapter caseTableChange(TableChange object) {
				return createTableChangeAdapter();
			}
			@Override
			public Adapter caseAddTable(AddTable object) {
				return createAddTableAdapter();
			}
			@Override
			public Adapter caseRemoveTable(RemoveTable object) {
				return createRemoveTableAdapter();
			}
			@Override
			public Adapter caseAlterTable(AlterTable object) {
				return createAlterTableAdapter();
			}
			@Override
			public Adapter caseRenameTableChange(RenameTableChange object) {
				return createRenameTableChangeAdapter();
			}
			@Override
			public Adapter caseUpdateTableCommentChange(UpdateTableCommentChange object) {
				return createUpdateTableCommentChangeAdapter();
			}
			@Override
			public Adapter caseColumnChange(ColumnChange object) {
				return createColumnChangeAdapter();
			}
			@Override
			public Adapter caseAddColumnChange(AddColumnChange object) {
				return createAddColumnChangeAdapter();
			}
			@Override
			public Adapter caseRemoveColumnChange(RemoveColumnChange object) {
				return createRemoveColumnChangeAdapter();
			}
			@Override
			public Adapter caseRenameColumnChange(RenameColumnChange object) {
				return createRenameColumnChangeAdapter();
			}
			@Override
			public Adapter caseUpdateColumnChange(UpdateColumnChange object) {
				return createUpdateColumnChangeAdapter();
			}
			@Override
			public Adapter caseUpdateColumnCommentChange(UpdateColumnCommentChange object) {
				return createUpdateColumnCommentChangeAdapter();
			}
			@Override
			public Adapter casePrimaryKeyChange(PrimaryKeyChange object) {
				return createPrimaryKeyChangeAdapter();
			}
			@Override
			public Adapter caseAddPrimaryKey(AddPrimaryKey object) {
				return createAddPrimaryKeyAdapter();
			}
			@Override
			public Adapter caseRemovePrimaryKey(RemovePrimaryKey object) {
				return createRemovePrimaryKeyAdapter();
			}
			@Override
			public Adapter caseUpdatePrimaryKey(UpdatePrimaryKey object) {
				return createUpdatePrimaryKeyAdapter();
			}
			@Override
			public Adapter caseIndexChange(IndexChange object) {
				return createIndexChangeAdapter();
			}
			@Override
			public Adapter caseAddIndex(AddIndex object) {
				return createAddIndexAdapter();
			}
			@Override
			public Adapter caseRemoveIndex(RemoveIndex object) {
				return createRemoveIndexAdapter();
			}
			@Override
			public Adapter caseUpdateIndex(UpdateIndex object) {
				return createUpdateIndexAdapter();
			}
			@Override
			public Adapter caseForeignKeyChange(ForeignKeyChange object) {
				return createForeignKeyChangeAdapter();
			}
			@Override
			public Adapter caseAddForeignKey(AddForeignKey object) {
				return createAddForeignKeyAdapter();
			}
			@Override
			public Adapter caseRemoveForeignKey(RemoveForeignKey object) {
				return createRemoveForeignKeyAdapter();
			}
			@Override
			public Adapter caseUpdateForeignKey(UpdateForeignKey object) {
				return createUpdateForeignKeyAdapter();
			}
			@Override
			public Adapter caseConstraintChange(ConstraintChange object) {
				return createConstraintChangeAdapter();
			}
			@Override
			public Adapter caseAddConstraint(AddConstraint object) {
				return createAddConstraintAdapter();
			}
			@Override
			public Adapter caseRemoveConstraint(RemoveConstraint object) {
				return createRemoveConstraintAdapter();
			}
			@Override
			public Adapter caseUpdateConstraint(UpdateConstraint object) {
				return createUpdateConstraintAdapter();
			}
			@Override
			public Adapter caseSequenceChange(SequenceChange object) {
				return createSequenceChangeAdapter();
			}
			@Override
			public Adapter caseAddSequence(AddSequence object) {
				return createAddSequenceAdapter();
			}
			@Override
			public Adapter caseRemoveSequence(RemoveSequence object) {
				return createRemoveSequenceAdapter();
			}
			@Override
			public Adapter caseUpdateSequence(UpdateSequence object) {
				return createUpdateSequenceAdapter();
			}
			@Override
			public Adapter caseSchemaChange(SchemaChange object) {
				return createSchemaChangeAdapter();
			}
			@Override
			public Adapter caseAddSchema(AddSchema object) {
				return createAddSchemaAdapter();
			}
			@Override
			public Adapter caseRemoveSchema(RemoveSchema object) {
				return createRemoveSchemaAdapter();
			}
			@Override
			public Adapter caseAlterSchema(AlterSchema object) {
				return createAlterSchemaAdapter();
			}
			@Override
			public Adapter caseRenameSchemaChange(RenameSchemaChange object) {
				return createRenameSchemaChangeAdapter();
			}
			@Override
			public Adapter caseUpdateSchemaCommentChange(UpdateSchemaCommentChange object) {
				return createUpdateSchemaCommentChangeAdapter();
			}
			@Override
			public Adapter caseDBDiff(DBDiff object) {
				return createDBDiffAdapter();
			}
			@Override
			public Adapter caseViewChange(ViewChange object) {
				return createViewChangeAdapter();
			}
			@Override
			public Adapter caseAddView(AddView object) {
				return createAddViewAdapter();
			}
			@Override
			public Adapter caseRemoveView(RemoveView object) {
				return createRemoveViewAdapter();
			}
			@Override
			public Adapter caseAlterView(AlterView object) {
				return createAlterViewAdapter();
			}
			@Override
			public Adapter caseRenameViewChange(RenameViewChange object) {
				return createRenameViewChangeAdapter();
			}
			@Override
			public Adapter caseUpdateViewCommentChange(UpdateViewCommentChange object) {
				return createUpdateViewCommentChangeAdapter();
			}
			@Override
			public Adapter caseUpdateViewQueryChange(UpdateViewQueryChange object) {
				return createUpdateViewQueryChangeAdapter();
			}
			@Override
			public Adapter caseComparison(Comparison object) {
				return createComparisonAdapter();
			}
			@Override
			public Adapter caseDiff(Diff object) {
				return createDiffAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.obeonetwork.dsl.database.dbevolution.AddTable
	 * <em>Add Table</em>}'. <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a
	 * case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.AddTable
	 * @generated
	 */
	public Adapter createAddTableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.RemoveTable <em>Remove Table</em>}'.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.RemoveTable
	 * @generated
	 */
	public Adapter createRemoveTableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.DatabaseChangeSet <em>Database Change Set</em>}'.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.DatabaseChangeSet
	 * @generated
	 */
	public Adapter createDatabaseChangeSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.TableChange <em>Table Change</em>}'.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.TableChange
	 * @generated
	 */
	public Adapter createTableChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.AlterTable <em>Alter Table</em>}'.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.AlterTable
	 * @generated
	 */
	public Adapter createAlterTableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.RenameTableChange <em>Rename Table Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.RenameTableChange
	 * @generated
	 */
	public Adapter createRenameTableChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.ColumnChange <em>Column Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.ColumnChange
	 * @generated
	 */
	public Adapter createColumnChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.AddColumnChange <em>Add Column Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.AddColumnChange
	 * @generated
	 */
	public Adapter createAddColumnChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.RemoveColumnChange <em>Remove Column Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.RemoveColumnChange
	 * @generated
	 */
	public Adapter createRemoveColumnChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.RenameColumnChange <em>Rename Column Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.RenameColumnChange
	 * @generated
	 */
	public Adapter createRenameColumnChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.UpdateColumnChange <em>Update Column Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateColumnChange
	 * @generated
	 */
	public Adapter createUpdateColumnChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.UpdateColumnCommentChange <em>Update Column Comment Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateColumnCommentChange
	 * @generated
	 */
	public Adapter createUpdateColumnCommentChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.UpdateTableCommentChange <em>Update Table Comment Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateTableCommentChange
	 * @generated
	 */
	public Adapter createUpdateTableCommentChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.PrimaryKeyChange <em>Primary Key Change</em>}'.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.PrimaryKeyChange
	 * @generated
	 */
	public Adapter createPrimaryKeyChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.AddPrimaryKey <em>Add Primary Key</em>}'.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.AddPrimaryKey
	 * @generated
	 */
	public Adapter createAddPrimaryKeyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.RemovePrimaryKey <em>Remove Primary Key</em>}'.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.RemovePrimaryKey
	 * @generated
	 */
	public Adapter createRemovePrimaryKeyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.UpdatePrimaryKey <em>Update Primary Key</em>}'.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdatePrimaryKey
	 * @generated
	 */
	public Adapter createUpdatePrimaryKeyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.IndexChange <em>Index Change</em>}'.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.IndexChange
	 * @generated
	 */
	public Adapter createIndexChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.obeonetwork.dsl.database.dbevolution.AddIndex
	 * <em>Add Index</em>}'. <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a
	 * case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.AddIndex
	 * @generated
	 */
	public Adapter createAddIndexAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.RemoveIndex <em>Remove Index</em>}'.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.RemoveIndex
	 * @generated
	 */
	public Adapter createRemoveIndexAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.UpdateIndex <em>Update Index</em>}'.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateIndex
	 * @generated
	 */
	public Adapter createUpdateIndexAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.ForeignKeyChange <em>Foreign Key Change</em>}'.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.ForeignKeyChange
	 * @generated
	 */
	public Adapter createForeignKeyChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.AddForeignKey <em>Add Foreign Key</em>}'.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.AddForeignKey
	 * @generated
	 */
	public Adapter createAddForeignKeyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.RemoveForeignKey <em>Remove Foreign Key</em>}'.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.RemoveForeignKey
	 * @generated
	 */
	public Adapter createRemoveForeignKeyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.UpdateForeignKey <em>Update Foreign Key</em>}'.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateForeignKey
	 * @generated
	 */
	public Adapter createUpdateForeignKeyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.ConstraintChange <em>Constraint Change</em>}'.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.ConstraintChange
	 * @generated
	 */
	public Adapter createConstraintChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.AddConstraint <em>Add Constraint</em>}'.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.AddConstraint
	 * @generated
	 */
	public Adapter createAddConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.RemoveConstraint <em>Remove Constraint</em>}'.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.RemoveConstraint
	 * @generated
	 */
	public Adapter createRemoveConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.UpdateConstraint <em>Update Constraint</em>}'.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateConstraint
	 * @generated
	 */
	public Adapter createUpdateConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.SequenceChange <em>Sequence Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.SequenceChange
	 * @generated
	 */
	public Adapter createSequenceChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.AddSequence <em>Add Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.AddSequence
	 * @generated
	 */
	public Adapter createAddSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.RemoveSequence <em>Remove Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.RemoveSequence
	 * @generated
	 */
	public Adapter createRemoveSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.UpdateSequence <em>Update Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateSequence
	 * @generated
	 */
	public Adapter createUpdateSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.SchemaChange <em>Schema Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.SchemaChange
	 * @generated
	 */
	public Adapter createSchemaChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.AddSchema <em>Add Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.AddSchema
	 * @generated
	 */
	public Adapter createAddSchemaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.RemoveSchema <em>Remove Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.RemoveSchema
	 * @generated
	 */
	public Adapter createRemoveSchemaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.AlterSchema <em>Alter Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.AlterSchema
	 * @generated
	 */
	public Adapter createAlterSchemaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.RenameSchemaChange <em>Rename Schema Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.RenameSchemaChange
	 * @generated
	 */
	public Adapter createRenameSchemaChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.UpdateSchemaCommentChange <em>Update Schema Comment Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateSchemaCommentChange
	 * @generated
	 */
	public Adapter createUpdateSchemaCommentChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.DBDiff <em>DB Diff</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.DBDiff
	 * @generated
	 */
	public Adapter createDBDiffAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.ViewChange <em>View Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.ViewChange
	 * @generated
	 */
	public Adapter createViewChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.AddView <em>Add View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.AddView
	 * @generated
	 */
	public Adapter createAddViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.RemoveView <em>Remove View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.RemoveView
	 * @generated
	 */
	public Adapter createRemoveViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.AlterView <em>Alter View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.AlterView
	 * @generated
	 */
	public Adapter createAlterViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.RenameViewChange <em>Rename View Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.RenameViewChange
	 * @generated
	 */
	public Adapter createRenameViewChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.UpdateViewCommentChange <em>Update View Comment Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateViewCommentChange
	 * @generated
	 */
	public Adapter createUpdateViewCommentChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.obeonetwork.dsl.database.dbevolution.UpdateViewQueryChange <em>Update View Query Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateViewQueryChange
	 * @generated
	 */
	public Adapter createUpdateViewQueryChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.compare.Comparison <em>Comparison</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.compare.Comparison
	 * @generated
	 */
	public Adapter createComparisonAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.compare.Diff <em>Diff</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.compare.Diff
	 * @generated
	 */
	public Adapter createDiffAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc --> This
	 * default implementation returns null. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // DbevolutionAdapterFactory
