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

import org.eclipse.emf.compare.ComparePackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.obeonetwork.dsl.database.DatabasePackage;
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
import org.obeonetwork.dsl.database.dbevolution.DbevolutionFactory;
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
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class DbevolutionPackageImpl extends EPackageImpl implements DbevolutionPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addTableEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeTableEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass databaseChangeSetEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tableChangeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alterTableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass renameTableChangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass columnChangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addColumnChangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeColumnChangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass renameColumnChangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updateColumnChangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updateColumnCommentChangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updateTableCommentChangeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primaryKeyChangeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addPrimaryKeyEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removePrimaryKeyEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updatePrimaryKeyEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indexChangeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addIndexEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeIndexEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updateIndexEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass foreignKeyChangeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addForeignKeyEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeForeignKeyEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updateForeignKeyEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintChangeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updateConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceChangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updateSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schemaChangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addSchemaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeSchemaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alterSchemaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass renameSchemaChangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updateSchemaCommentChangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dbDiffEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewChangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alterViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass renameViewChangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updateViewCommentChangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updateViewQueryChangeEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory
	 * method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DbevolutionPackageImpl() {
		super(eNS_URI, DbevolutionFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model,
	 * and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link DbevolutionPackage#eINSTANCE}
	 * when that field is accessed. Clients should not invoke it directly.
	 * Instead, they should simply access that field to obtain the package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DbevolutionPackage init() {
		if (isInited) return (DbevolutionPackage)EPackage.Registry.INSTANCE.getEPackage(DbevolutionPackage.eNS_URI);

		// Obtain or create and register package
		DbevolutionPackageImpl theDbevolutionPackage = (DbevolutionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DbevolutionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DbevolutionPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		DatabasePackage.eINSTANCE.eClass();
		ComparePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDbevolutionPackage.createPackageContents();

		// Initialize created meta-data
		theDbevolutionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDbevolutionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DbevolutionPackage.eNS_URI, theDbevolutionPackage);
		return theDbevolutionPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddTable() {
		return addTableEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoveTable() {
		return removeTableEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDatabaseChangeSet() {
		return databaseChangeSetEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTableChange() {
		return tableChangeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTableChange_Table() {
		return (EReference)tableChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlterTable() {
		return alterTableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRenameTableChange() {
		return renameTableChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRenameTableChange_NewTable() {
		return (EReference)renameTableChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getColumnChange() {
		return columnChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getColumnChange_Column() {
		return (EReference)columnChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddColumnChange() {
		return addColumnChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoveColumnChange() {
		return removeColumnChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRenameColumnChange() {
		return renameColumnChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRenameColumnChange_NewColumn() {
		return (EReference)renameColumnChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpdateColumnChange() {
		return updateColumnChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpdateColumnCommentChange() {
		return updateColumnCommentChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpdateTableCommentChange() {
		return updateTableCommentChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUpdateTableCommentChange_NewTable() {
		return (EReference)updateTableCommentChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimaryKeyChange() {
		return primaryKeyChangeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrimaryKeyChange_PrimaryKey() {
		return (EReference)primaryKeyChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddPrimaryKey() {
		return addPrimaryKeyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemovePrimaryKey() {
		return removePrimaryKeyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpdatePrimaryKey() {
		return updatePrimaryKeyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUpdatePrimaryKey_NewPrimaryKey() {
		return (EReference)updatePrimaryKeyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIndexChange() {
		return indexChangeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndexChange_Index() {
		return (EReference)indexChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddIndex() {
		return addIndexEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoveIndex() {
		return removeIndexEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpdateIndex() {
		return updateIndexEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUpdateIndex_NewIndex() {
		return (EReference)updateIndexEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForeignKeyChange() {
		return foreignKeyChangeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForeignKeyChange_ForeignKey() {
		return (EReference)foreignKeyChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddForeignKey() {
		return addForeignKeyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoveForeignKey() {
		return removeForeignKeyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpdateForeignKey() {
		return updateForeignKeyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUpdateForeignKey_NewForeignKey() {
		return (EReference)updateForeignKeyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraintChange() {
		return constraintChangeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraintChange_Constraint() {
		return (EReference)constraintChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddConstraint() {
		return addConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoveConstraint() {
		return removeConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpdateConstraint() {
		return updateConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUpdateConstraint_NewConstraint() {
		return (EReference)updateConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceChange() {
		return sequenceChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceChange_Sequence() {
		return (EReference)sequenceChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddSequence() {
		return addSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoveSequence() {
		return removeSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpdateSequence() {
		return updateSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUpdateSequence_NewSequence() {
		return (EReference)updateSequenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchemaChange() {
		return schemaChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchemaChange_Schema() {
		return (EReference)schemaChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddSchema() {
		return addSchemaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoveSchema() {
		return removeSchemaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlterSchema() {
		return alterSchemaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRenameSchemaChange() {
		return renameSchemaChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRenameSchemaChange_NewSchema() {
		return (EReference)renameSchemaChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpdateSchemaCommentChange() {
		return updateSchemaCommentChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUpdateSchemaCommentChange_NewSchema() {
		return (EReference)updateSchemaCommentChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDBDiff() {
		return dbDiffEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDBDiff_Target() {
		return (EReference)dbDiffEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getViewChange() {
		return viewChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewChange_View() {
		return (EReference)viewChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddView() {
		return addViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoveView() {
		return removeViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlterView() {
		return alterViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRenameViewChange() {
		return renameViewChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRenameViewChange_NewView() {
		return (EReference)renameViewChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpdateViewCommentChange() {
		return updateViewCommentChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUpdateViewCommentChange_NewView() {
		return (EReference)updateViewCommentChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpdateViewQueryChange() {
		return updateViewQueryChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUpdateViewQueryChange_NewView() {
		return (EReference)updateViewQueryChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DbevolutionFactory getDbevolutionFactory() {
		return (DbevolutionFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		databaseChangeSetEClass = createEClass(DATABASE_CHANGE_SET);

		tableChangeEClass = createEClass(TABLE_CHANGE);
		createEReference(tableChangeEClass, TABLE_CHANGE__TABLE);

		addTableEClass = createEClass(ADD_TABLE);

		removeTableEClass = createEClass(REMOVE_TABLE);

		alterTableEClass = createEClass(ALTER_TABLE);

		renameTableChangeEClass = createEClass(RENAME_TABLE_CHANGE);
		createEReference(renameTableChangeEClass, RENAME_TABLE_CHANGE__NEW_TABLE);

		updateTableCommentChangeEClass = createEClass(UPDATE_TABLE_COMMENT_CHANGE);
		createEReference(updateTableCommentChangeEClass, UPDATE_TABLE_COMMENT_CHANGE__NEW_TABLE);

		columnChangeEClass = createEClass(COLUMN_CHANGE);
		createEReference(columnChangeEClass, COLUMN_CHANGE__COLUMN);

		addColumnChangeEClass = createEClass(ADD_COLUMN_CHANGE);

		removeColumnChangeEClass = createEClass(REMOVE_COLUMN_CHANGE);

		renameColumnChangeEClass = createEClass(RENAME_COLUMN_CHANGE);
		createEReference(renameColumnChangeEClass, RENAME_COLUMN_CHANGE__NEW_COLUMN);

		updateColumnChangeEClass = createEClass(UPDATE_COLUMN_CHANGE);

		updateColumnCommentChangeEClass = createEClass(UPDATE_COLUMN_COMMENT_CHANGE);

		primaryKeyChangeEClass = createEClass(PRIMARY_KEY_CHANGE);
		createEReference(primaryKeyChangeEClass, PRIMARY_KEY_CHANGE__PRIMARY_KEY);

		addPrimaryKeyEClass = createEClass(ADD_PRIMARY_KEY);

		removePrimaryKeyEClass = createEClass(REMOVE_PRIMARY_KEY);

		updatePrimaryKeyEClass = createEClass(UPDATE_PRIMARY_KEY);
		createEReference(updatePrimaryKeyEClass, UPDATE_PRIMARY_KEY__NEW_PRIMARY_KEY);

		indexChangeEClass = createEClass(INDEX_CHANGE);
		createEReference(indexChangeEClass, INDEX_CHANGE__INDEX);

		addIndexEClass = createEClass(ADD_INDEX);

		removeIndexEClass = createEClass(REMOVE_INDEX);

		updateIndexEClass = createEClass(UPDATE_INDEX);
		createEReference(updateIndexEClass, UPDATE_INDEX__NEW_INDEX);

		foreignKeyChangeEClass = createEClass(FOREIGN_KEY_CHANGE);
		createEReference(foreignKeyChangeEClass, FOREIGN_KEY_CHANGE__FOREIGN_KEY);

		addForeignKeyEClass = createEClass(ADD_FOREIGN_KEY);

		removeForeignKeyEClass = createEClass(REMOVE_FOREIGN_KEY);

		updateForeignKeyEClass = createEClass(UPDATE_FOREIGN_KEY);
		createEReference(updateForeignKeyEClass, UPDATE_FOREIGN_KEY__NEW_FOREIGN_KEY);

		constraintChangeEClass = createEClass(CONSTRAINT_CHANGE);
		createEReference(constraintChangeEClass, CONSTRAINT_CHANGE__CONSTRAINT);

		addConstraintEClass = createEClass(ADD_CONSTRAINT);

		removeConstraintEClass = createEClass(REMOVE_CONSTRAINT);

		updateConstraintEClass = createEClass(UPDATE_CONSTRAINT);
		createEReference(updateConstraintEClass, UPDATE_CONSTRAINT__NEW_CONSTRAINT);

		sequenceChangeEClass = createEClass(SEQUENCE_CHANGE);
		createEReference(sequenceChangeEClass, SEQUENCE_CHANGE__SEQUENCE);

		addSequenceEClass = createEClass(ADD_SEQUENCE);

		removeSequenceEClass = createEClass(REMOVE_SEQUENCE);

		updateSequenceEClass = createEClass(UPDATE_SEQUENCE);
		createEReference(updateSequenceEClass, UPDATE_SEQUENCE__NEW_SEQUENCE);

		schemaChangeEClass = createEClass(SCHEMA_CHANGE);
		createEReference(schemaChangeEClass, SCHEMA_CHANGE__SCHEMA);

		addSchemaEClass = createEClass(ADD_SCHEMA);

		removeSchemaEClass = createEClass(REMOVE_SCHEMA);

		alterSchemaEClass = createEClass(ALTER_SCHEMA);

		renameSchemaChangeEClass = createEClass(RENAME_SCHEMA_CHANGE);
		createEReference(renameSchemaChangeEClass, RENAME_SCHEMA_CHANGE__NEW_SCHEMA);

		updateSchemaCommentChangeEClass = createEClass(UPDATE_SCHEMA_COMMENT_CHANGE);
		createEReference(updateSchemaCommentChangeEClass, UPDATE_SCHEMA_COMMENT_CHANGE__NEW_SCHEMA);

		dbDiffEClass = createEClass(DB_DIFF);
		createEReference(dbDiffEClass, DB_DIFF__TARGET);

		viewChangeEClass = createEClass(VIEW_CHANGE);
		createEReference(viewChangeEClass, VIEW_CHANGE__VIEW);

		addViewEClass = createEClass(ADD_VIEW);

		removeViewEClass = createEClass(REMOVE_VIEW);

		alterViewEClass = createEClass(ALTER_VIEW);

		renameViewChangeEClass = createEClass(RENAME_VIEW_CHANGE);
		createEReference(renameViewChangeEClass, RENAME_VIEW_CHANGE__NEW_VIEW);

		updateViewCommentChangeEClass = createEClass(UPDATE_VIEW_COMMENT_CHANGE);
		createEReference(updateViewCommentChangeEClass, UPDATE_VIEW_COMMENT_CHANGE__NEW_VIEW);

		updateViewQueryChangeEClass = createEClass(UPDATE_VIEW_QUERY_CHANGE);
		createEReference(updateViewQueryChangeEClass, UPDATE_VIEW_QUERY_CHANGE__NEW_VIEW);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ComparePackage theComparePackage = (ComparePackage)EPackage.Registry.INSTANCE.getEPackage(ComparePackage.eNS_URI);
		DatabasePackage theDatabasePackage = (DatabasePackage)EPackage.Registry.INSTANCE.getEPackage(DatabasePackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		databaseChangeSetEClass.getESuperTypes().add(theComparePackage.getComparison());
		tableChangeEClass.getESuperTypes().add(this.getDBDiff());
		addTableEClass.getESuperTypes().add(this.getTableChange());
		removeTableEClass.getESuperTypes().add(this.getTableChange());
		alterTableEClass.getESuperTypes().add(this.getTableChange());
		renameTableChangeEClass.getESuperTypes().add(this.getTableChange());
		updateTableCommentChangeEClass.getESuperTypes().add(this.getTableChange());
		columnChangeEClass.getESuperTypes().add(this.getDBDiff());
		addColumnChangeEClass.getESuperTypes().add(this.getColumnChange());
		removeColumnChangeEClass.getESuperTypes().add(this.getColumnChange());
		renameColumnChangeEClass.getESuperTypes().add(this.getColumnChange());
		updateColumnChangeEClass.getESuperTypes().add(this.getColumnChange());
		updateColumnCommentChangeEClass.getESuperTypes().add(this.getColumnChange());
		primaryKeyChangeEClass.getESuperTypes().add(this.getDBDiff());
		addPrimaryKeyEClass.getESuperTypes().add(this.getPrimaryKeyChange());
		removePrimaryKeyEClass.getESuperTypes().add(this.getPrimaryKeyChange());
		updatePrimaryKeyEClass.getESuperTypes().add(this.getPrimaryKeyChange());
		indexChangeEClass.getESuperTypes().add(this.getDBDiff());
		addIndexEClass.getESuperTypes().add(this.getIndexChange());
		removeIndexEClass.getESuperTypes().add(this.getIndexChange());
		updateIndexEClass.getESuperTypes().add(this.getIndexChange());
		foreignKeyChangeEClass.getESuperTypes().add(this.getDBDiff());
		addForeignKeyEClass.getESuperTypes().add(this.getForeignKeyChange());
		removeForeignKeyEClass.getESuperTypes().add(this.getForeignKeyChange());
		updateForeignKeyEClass.getESuperTypes().add(this.getForeignKeyChange());
		constraintChangeEClass.getESuperTypes().add(this.getDBDiff());
		addConstraintEClass.getESuperTypes().add(this.getConstraintChange());
		removeConstraintEClass.getESuperTypes().add(this.getConstraintChange());
		updateConstraintEClass.getESuperTypes().add(this.getConstraintChange());
		sequenceChangeEClass.getESuperTypes().add(this.getDBDiff());
		addSequenceEClass.getESuperTypes().add(this.getSequenceChange());
		removeSequenceEClass.getESuperTypes().add(this.getSequenceChange());
		updateSequenceEClass.getESuperTypes().add(this.getSequenceChange());
		schemaChangeEClass.getESuperTypes().add(this.getDBDiff());
		addSchemaEClass.getESuperTypes().add(this.getSchemaChange());
		removeSchemaEClass.getESuperTypes().add(this.getSchemaChange());
		alterSchemaEClass.getESuperTypes().add(this.getSchemaChange());
		renameSchemaChangeEClass.getESuperTypes().add(this.getSchemaChange());
		updateSchemaCommentChangeEClass.getESuperTypes().add(this.getSchemaChange());
		dbDiffEClass.getESuperTypes().add(theComparePackage.getDiff());
		viewChangeEClass.getESuperTypes().add(this.getDBDiff());
		addViewEClass.getESuperTypes().add(this.getViewChange());
		removeViewEClass.getESuperTypes().add(this.getViewChange());
		alterViewEClass.getESuperTypes().add(this.getViewChange());
		renameViewChangeEClass.getESuperTypes().add(this.getViewChange());
		updateViewCommentChangeEClass.getESuperTypes().add(this.getViewChange());
		updateViewQueryChangeEClass.getESuperTypes().add(this.getViewChange());

		// Initialize classes and features; add operations and parameters
		initEClass(databaseChangeSetEClass, DatabaseChangeSet.class, "DatabaseChangeSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tableChangeEClass, TableChange.class, "TableChange", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTableChange_Table(), theDatabasePackage.getTable(), null, "table", null, 1, 1, TableChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addTableEClass, AddTable.class, "AddTable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(removeTableEClass, RemoveTable.class, "RemoveTable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(alterTableEClass, AlterTable.class, "AlterTable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(renameTableChangeEClass, RenameTableChange.class, "RenameTableChange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRenameTableChange_NewTable(), theDatabasePackage.getTable(), null, "newTable", null, 1, 1, RenameTableChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(updateTableCommentChangeEClass, UpdateTableCommentChange.class, "UpdateTableCommentChange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUpdateTableCommentChange_NewTable(), theDatabasePackage.getTable(), null, "newTable", null, 1, 1, UpdateTableCommentChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(columnChangeEClass, ColumnChange.class, "ColumnChange", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getColumnChange_Column(), theDatabasePackage.getColumn(), null, "column", null, 1, 1, ColumnChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addColumnChangeEClass, AddColumnChange.class, "AddColumnChange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(removeColumnChangeEClass, RemoveColumnChange.class, "RemoveColumnChange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(renameColumnChangeEClass, RenameColumnChange.class, "RenameColumnChange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRenameColumnChange_NewColumn(), theDatabasePackage.getColumn(), null, "newColumn", null, 1, 1, RenameColumnChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(updateColumnChangeEClass, UpdateColumnChange.class, "UpdateColumnChange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(updateColumnCommentChangeEClass, UpdateColumnCommentChange.class, "UpdateColumnCommentChange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(primaryKeyChangeEClass, PrimaryKeyChange.class, "PrimaryKeyChange", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrimaryKeyChange_PrimaryKey(), theDatabasePackage.getPrimaryKey(), null, "primaryKey", null, 1, 1, PrimaryKeyChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addPrimaryKeyEClass, AddPrimaryKey.class, "AddPrimaryKey", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(removePrimaryKeyEClass, RemovePrimaryKey.class, "RemovePrimaryKey", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(updatePrimaryKeyEClass, UpdatePrimaryKey.class, "UpdatePrimaryKey", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUpdatePrimaryKey_NewPrimaryKey(), theDatabasePackage.getPrimaryKey(), null, "newPrimaryKey", null, 1, 1, UpdatePrimaryKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(indexChangeEClass, IndexChange.class, "IndexChange", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIndexChange_Index(), theDatabasePackage.getIndex(), null, "index", null, 1, 1, IndexChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addIndexEClass, AddIndex.class, "AddIndex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(removeIndexEClass, RemoveIndex.class, "RemoveIndex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(updateIndexEClass, UpdateIndex.class, "UpdateIndex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUpdateIndex_NewIndex(), theDatabasePackage.getIndex(), null, "newIndex", null, 1, 1, UpdateIndex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(foreignKeyChangeEClass, ForeignKeyChange.class, "ForeignKeyChange", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForeignKeyChange_ForeignKey(), theDatabasePackage.getForeignKey(), null, "foreignKey", null, 1, 1, ForeignKeyChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addForeignKeyEClass, AddForeignKey.class, "AddForeignKey", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(removeForeignKeyEClass, RemoveForeignKey.class, "RemoveForeignKey", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(updateForeignKeyEClass, UpdateForeignKey.class, "UpdateForeignKey", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUpdateForeignKey_NewForeignKey(), theDatabasePackage.getForeignKey(), null, "newForeignKey", null, 1, 1, UpdateForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintChangeEClass, ConstraintChange.class, "ConstraintChange", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstraintChange_Constraint(), theDatabasePackage.getConstraint(), null, "constraint", null, 1, 1, ConstraintChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addConstraintEClass, AddConstraint.class, "AddConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(removeConstraintEClass, RemoveConstraint.class, "RemoveConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(updateConstraintEClass, UpdateConstraint.class, "UpdateConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUpdateConstraint_NewConstraint(), theDatabasePackage.getConstraint(), null, "newConstraint", null, 1, 1, UpdateConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sequenceChangeEClass, SequenceChange.class, "SequenceChange", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSequenceChange_Sequence(), theDatabasePackage.getSequence(), null, "sequence", null, 1, 1, SequenceChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addSequenceEClass, AddSequence.class, "AddSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(removeSequenceEClass, RemoveSequence.class, "RemoveSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(updateSequenceEClass, UpdateSequence.class, "UpdateSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUpdateSequence_NewSequence(), theDatabasePackage.getSequence(), null, "newSequence", null, 1, 1, UpdateSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schemaChangeEClass, SchemaChange.class, "SchemaChange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSchemaChange_Schema(), theDatabasePackage.getSchema(), null, "schema", null, 1, 1, SchemaChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addSchemaEClass, AddSchema.class, "AddSchema", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(removeSchemaEClass, RemoveSchema.class, "RemoveSchema", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(alterSchemaEClass, AlterSchema.class, "AlterSchema", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(renameSchemaChangeEClass, RenameSchemaChange.class, "RenameSchemaChange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRenameSchemaChange_NewSchema(), theDatabasePackage.getSchema(), null, "newSchema", null, 1, 1, RenameSchemaChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(updateSchemaCommentChangeEClass, UpdateSchemaCommentChange.class, "UpdateSchemaCommentChange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUpdateSchemaCommentChange_NewSchema(), theDatabasePackage.getSchema(), null, "newSchema", null, 1, 1, UpdateSchemaCommentChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dbDiffEClass, DBDiff.class, "DBDiff", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDBDiff_Target(), theEcorePackage.getEObject(), null, "target", null, 0, 1, DBDiff.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(viewChangeEClass, ViewChange.class, "ViewChange", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getViewChange_View(), theDatabasePackage.getView(), null, "view", null, 1, 1, ViewChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addViewEClass, AddView.class, "AddView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(removeViewEClass, RemoveView.class, "RemoveView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(alterViewEClass, AlterView.class, "AlterView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(renameViewChangeEClass, RenameViewChange.class, "RenameViewChange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRenameViewChange_NewView(), theDatabasePackage.getView(), null, "newView", null, 1, 1, RenameViewChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(updateViewCommentChangeEClass, UpdateViewCommentChange.class, "UpdateViewCommentChange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUpdateViewCommentChange_NewView(), theDatabasePackage.getView(), null, "newView", null, 1, 1, UpdateViewCommentChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(updateViewQueryChangeEClass, UpdateViewQueryChange.class, "UpdateViewQueryChange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUpdateViewQueryChange_NewView(), theDatabasePackage.getView(), null, "newView", null, 1, 1, UpdateViewQueryChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} // DbevolutionPackageImpl
