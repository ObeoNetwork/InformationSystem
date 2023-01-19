/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.obeonetwork.dsl.database.AbstractTable;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.Constraint;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.DatabaseElement;
import org.obeonetwork.dsl.database.DatabaseFactory;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.ForeignKeyElement;
import org.obeonetwork.dsl.database.Index;
import org.obeonetwork.dsl.database.IndexElement;
import org.obeonetwork.dsl.database.NamedElement;
import org.obeonetwork.dsl.database.PrimaryKey;
import org.obeonetwork.dsl.database.Schema;
import org.obeonetwork.dsl.database.Sequence;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.database.View;
import org.obeonetwork.dsl.database.ViewColumn;
import org.obeonetwork.dsl.database.ViewElement;
import org.obeonetwork.dsl.database.ViewTable;
import org.obeonetwork.dsl.technicalid.TechnicalIDPackage;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DatabasePackageImpl extends EPackageImpl implements DatabasePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2023 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataBaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractTableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass columnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indexEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primaryKeyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass foreignKeyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass foreignKeyElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indexElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass databaseElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schemaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tableContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewColumnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewTableEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.obeonetwork.dsl.database.DatabasePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DatabasePackageImpl() {
		super(eNS_URI, DatabaseFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link DatabasePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DatabasePackage init() {
		if (isInited) return (DatabasePackage)EPackage.Registry.INSTANCE.getEPackage(DatabasePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDatabasePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DatabasePackageImpl theDatabasePackage = registeredDatabasePackage instanceof DatabasePackageImpl ? (DatabasePackageImpl)registeredDatabasePackage : new DatabasePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		TypesLibraryPackage.eINSTANCE.eClass();
		TechnicalIDPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDatabasePackage.createPackageContents();

		// Initialize created meta-data
		theDatabasePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDatabasePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DatabasePackage.eNS_URI, theDatabasePackage);
		return theDatabasePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataBase() {
		return dataBaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataBase_Url() {
		return (EAttribute)dataBaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataBase_Schemas() {
		return (EReference)dataBaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataBase_Defines() {
		return (EReference)dataBaseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractTable() {
		return abstractTableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractTable_Owner() {
		return (EReference)abstractTableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getColumn() {
		return columnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColumn_Nullable() {
		return (EAttribute)columnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColumn_DefaultValue() {
		return (EAttribute)columnEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getColumn_Indexes() {
		return (EReference)columnEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getColumn_IndexElements() {
		return (EReference)columnEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getColumn_PrimaryKey() {
		return (EReference)columnEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getColumn_ForeignKeys() {
		return (EReference)columnEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getColumn_ForeignKeyElements() {
		return (EReference)columnEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getColumn_Type() {
		return (EReference)columnEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getColumn_Sequence() {
		return (EReference)columnEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getColumn_Owner() {
		return (EReference)columnEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColumn_Autoincrement() {
		return (EAttribute)columnEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColumn_InPrimaryKey() {
		return (EAttribute)columnEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColumn_InForeignKey() {
		return (EAttribute)columnEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColumn_Unique() {
		return (EAttribute)columnEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIndex() {
		return indexEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndex_Qualifier() {
		return (EAttribute)indexEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndex_Elements() {
		return (EReference)indexEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndex_Unique() {
		return (EAttribute)indexEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndex_Cardinality() {
		return (EAttribute)indexEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndex_IndexType() {
		return (EAttribute)indexEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndex_Owner() {
		return (EReference)indexEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getView() {
		return viewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getView_Query() {
		return (EAttribute)viewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getView_Columns() {
		return (EReference)viewEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getView_Tables() {
		return (EReference)viewEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTable() {
		return tableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTable_PrimaryKey() {
		return (EReference)tableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTable_ForeignKeys() {
		return (EReference)tableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTable_Constraints() {
		return (EReference)tableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTable_Indexes() {
		return (EReference)tableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTable_Columns() {
		return (EReference)tableEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimaryKey() {
		return primaryKeyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrimaryKey_Columns() {
		return (EReference)primaryKeyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrimaryKey_Owner() {
		return (EReference)primaryKeyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForeignKey() {
		return foreignKeyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForeignKey_Elements() {
		return (EReference)foreignKeyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForeignKey_Owner() {
		return (EReference)foreignKeyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForeignKey_Target() {
		return (EReference)foreignKeyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForeignKeyElement() {
		return foreignKeyElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForeignKeyElement_FkColumn() {
		return (EReference)foreignKeyElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForeignKeyElement_PkColumn() {
		return (EReference)foreignKeyElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIndexElement() {
		return indexElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndexElement_Column() {
		return (EReference)indexElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndexElement_Asc() {
		return (EAttribute)indexElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraint() {
		return constraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraint_Expression() {
		return (EAttribute)constraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraint_Owner() {
		return (EReference)constraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDatabaseElement() {
		return databaseElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseElement_ID() {
		return (EAttribute)databaseElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseElement_Comments() {
		return (EAttribute)databaseElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseElement_TechID() {
		return (EAttribute)databaseElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchema() {
		return schemaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequence() {
		return sequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequence_Start() {
		return (EAttribute)sequenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequence_Increment() {
		return (EAttribute)sequenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequence_MinValue() {
		return (EAttribute)sequenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequence_MaxValue() {
		return (EAttribute)sequenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequence_CacheSize() {
		return (EAttribute)sequenceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequence_Cycle() {
		return (EAttribute)sequenceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequence_Columns() {
		return (EReference)sequenceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTableContainer() {
		return tableContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTableContainer_Tables() {
		return (EReference)tableContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTableContainer_Sequences() {
		return (EReference)tableContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getViewElement() {
		return viewElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getViewElement_Name() {
		return (EAttribute)viewElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getViewElement_Alias() {
		return (EAttribute)viewElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getViewColumn() {
		return viewColumnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewColumn_From() {
		return (EReference)viewColumnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getViewTable() {
		return viewTableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseFactory getDatabaseFactory() {
		return (DatabaseFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		dataBaseEClass = createEClass(DATA_BASE);
		createEAttribute(dataBaseEClass, DATA_BASE__URL);
		createEReference(dataBaseEClass, DATA_BASE__SCHEMAS);
		createEReference(dataBaseEClass, DATA_BASE__DEFINES);

		abstractTableEClass = createEClass(ABSTRACT_TABLE);
		createEReference(abstractTableEClass, ABSTRACT_TABLE__OWNER);

		columnEClass = createEClass(COLUMN);
		createEAttribute(columnEClass, COLUMN__NULLABLE);
		createEAttribute(columnEClass, COLUMN__DEFAULT_VALUE);
		createEReference(columnEClass, COLUMN__INDEXES);
		createEReference(columnEClass, COLUMN__INDEX_ELEMENTS);
		createEReference(columnEClass, COLUMN__PRIMARY_KEY);
		createEReference(columnEClass, COLUMN__FOREIGN_KEYS);
		createEReference(columnEClass, COLUMN__FOREIGN_KEY_ELEMENTS);
		createEReference(columnEClass, COLUMN__TYPE);
		createEReference(columnEClass, COLUMN__SEQUENCE);
		createEReference(columnEClass, COLUMN__OWNER);
		createEAttribute(columnEClass, COLUMN__AUTOINCREMENT);
		createEAttribute(columnEClass, COLUMN__IN_PRIMARY_KEY);
		createEAttribute(columnEClass, COLUMN__IN_FOREIGN_KEY);
		createEAttribute(columnEClass, COLUMN__UNIQUE);

		indexEClass = createEClass(INDEX);
		createEAttribute(indexEClass, INDEX__QUALIFIER);
		createEReference(indexEClass, INDEX__ELEMENTS);
		createEAttribute(indexEClass, INDEX__UNIQUE);
		createEAttribute(indexEClass, INDEX__CARDINALITY);
		createEAttribute(indexEClass, INDEX__INDEX_TYPE);
		createEReference(indexEClass, INDEX__OWNER);

		viewEClass = createEClass(VIEW);
		createEAttribute(viewEClass, VIEW__QUERY);
		createEReference(viewEClass, VIEW__COLUMNS);
		createEReference(viewEClass, VIEW__TABLES);

		tableEClass = createEClass(TABLE);
		createEReference(tableEClass, TABLE__PRIMARY_KEY);
		createEReference(tableEClass, TABLE__FOREIGN_KEYS);
		createEReference(tableEClass, TABLE__CONSTRAINTS);
		createEReference(tableEClass, TABLE__INDEXES);
		createEReference(tableEClass, TABLE__COLUMNS);

		primaryKeyEClass = createEClass(PRIMARY_KEY);
		createEReference(primaryKeyEClass, PRIMARY_KEY__COLUMNS);
		createEReference(primaryKeyEClass, PRIMARY_KEY__OWNER);

		foreignKeyEClass = createEClass(FOREIGN_KEY);
		createEReference(foreignKeyEClass, FOREIGN_KEY__ELEMENTS);
		createEReference(foreignKeyEClass, FOREIGN_KEY__OWNER);
		createEReference(foreignKeyEClass, FOREIGN_KEY__TARGET);

		foreignKeyElementEClass = createEClass(FOREIGN_KEY_ELEMENT);
		createEReference(foreignKeyElementEClass, FOREIGN_KEY_ELEMENT__FK_COLUMN);
		createEReference(foreignKeyElementEClass, FOREIGN_KEY_ELEMENT__PK_COLUMN);

		indexElementEClass = createEClass(INDEX_ELEMENT);
		createEReference(indexElementEClass, INDEX_ELEMENT__COLUMN);
		createEAttribute(indexElementEClass, INDEX_ELEMENT__ASC);

		constraintEClass = createEClass(CONSTRAINT);
		createEAttribute(constraintEClass, CONSTRAINT__EXPRESSION);
		createEReference(constraintEClass, CONSTRAINT__OWNER);

		databaseElementEClass = createEClass(DATABASE_ELEMENT);
		createEAttribute(databaseElementEClass, DATABASE_ELEMENT__ID);
		createEAttribute(databaseElementEClass, DATABASE_ELEMENT__COMMENTS);
		createEAttribute(databaseElementEClass, DATABASE_ELEMENT__TECH_ID);

		schemaEClass = createEClass(SCHEMA);

		sequenceEClass = createEClass(SEQUENCE);
		createEAttribute(sequenceEClass, SEQUENCE__START);
		createEAttribute(sequenceEClass, SEQUENCE__INCREMENT);
		createEAttribute(sequenceEClass, SEQUENCE__MIN_VALUE);
		createEAttribute(sequenceEClass, SEQUENCE__MAX_VALUE);
		createEAttribute(sequenceEClass, SEQUENCE__CACHE_SIZE);
		createEAttribute(sequenceEClass, SEQUENCE__CYCLE);
		createEReference(sequenceEClass, SEQUENCE__COLUMNS);

		tableContainerEClass = createEClass(TABLE_CONTAINER);
		createEReference(tableContainerEClass, TABLE_CONTAINER__TABLES);
		createEReference(tableContainerEClass, TABLE_CONTAINER__SEQUENCES);

		viewElementEClass = createEClass(VIEW_ELEMENT);
		createEAttribute(viewElementEClass, VIEW_ELEMENT__NAME);
		createEAttribute(viewElementEClass, VIEW_ELEMENT__ALIAS);

		viewColumnEClass = createEClass(VIEW_COLUMN);
		createEReference(viewColumnEClass, VIEW_COLUMN__FROM);

		viewTableEClass = createEClass(VIEW_TABLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
		TypesLibraryPackage theTypesLibraryPackage = (TypesLibraryPackage)EPackage.Registry.INSTANCE.getEPackage(TypesLibraryPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		namedElementEClass.getESuperTypes().add(this.getDatabaseElement());
		dataBaseEClass.getESuperTypes().add(this.getTableContainer());
		dataBaseEClass.getESuperTypes().add(theTypesLibraryPackage.getTypesLibraryUser());
		abstractTableEClass.getESuperTypes().add(this.getNamedElement());
		columnEClass.getESuperTypes().add(this.getNamedElement());
		indexEClass.getESuperTypes().add(this.getNamedElement());
		viewEClass.getESuperTypes().add(this.getAbstractTable());
		tableEClass.getESuperTypes().add(this.getAbstractTable());
		primaryKeyEClass.getESuperTypes().add(this.getNamedElement());
		foreignKeyEClass.getESuperTypes().add(this.getNamedElement());
		foreignKeyElementEClass.getESuperTypes().add(this.getDatabaseElement());
		indexElementEClass.getESuperTypes().add(this.getDatabaseElement());
		constraintEClass.getESuperTypes().add(this.getNamedElement());
		schemaEClass.getESuperTypes().add(this.getTableContainer());
		sequenceEClass.getESuperTypes().add(this.getNamedElement());
		tableContainerEClass.getESuperTypes().add(this.getNamedElement());
		viewColumnEClass.getESuperTypes().add(this.getViewElement());
		viewTableEClass.getESuperTypes().add(this.getViewElement());

		// Initialize classes and features; add operations and parameters
		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataBaseEClass, DataBase.class, "DataBase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataBase_Url(), ecorePackage.getEString(), "url", null, 0, 1, DataBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataBase_Schemas(), this.getSchema(), null, "schemas", null, 0, -1, DataBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataBase_Defines(), theTypesLibraryPackage.getUserDefinedTypesLibrary(), null, "defines", null, 0, -1, DataBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractTableEClass, AbstractTable.class, "AbstractTable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractTable_Owner(), this.getTableContainer(), this.getTableContainer_Tables(), "owner", null, 1, 1, AbstractTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(columnEClass, Column.class, "Column", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getColumn_Nullable(), ecorePackage.getEBoolean(), "nullable", null, 1, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getColumn_DefaultValue(), ecorePackage.getEString(), "defaultValue", null, 0, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getColumn_Indexes(), this.getIndex(), null, "indexes", null, 0, -1, Column.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getColumn_IndexElements(), this.getIndexElement(), this.getIndexElement_Column(), "indexElements", null, 0, -1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getColumn_PrimaryKey(), this.getPrimaryKey(), this.getPrimaryKey_Columns(), "primaryKey", null, 0, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getColumn_ForeignKeys(), this.getForeignKey(), null, "foreignKeys", null, 0, -1, Column.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getColumn_ForeignKeyElements(), this.getForeignKeyElement(), this.getForeignKeyElement_FkColumn(), "foreignKeyElements", null, 0, -1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getColumn_Type(), theTypesLibraryPackage.getType(), null, "type", null, 1, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getColumn_Sequence(), this.getSequence(), this.getSequence_Columns(), "sequence", null, 0, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getColumn_Owner(), this.getTable(), this.getTable_Columns(), "owner", null, 1, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColumn_Autoincrement(), ecorePackage.getEBoolean(), "autoincrement", null, 0, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColumn_InPrimaryKey(), ecorePackage.getEBoolean(), "inPrimaryKey", null, 0, 1, Column.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getColumn_InForeignKey(), ecorePackage.getEBoolean(), "inForeignKey", null, 0, 1, Column.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getColumn_Unique(), ecorePackage.getEBoolean(), "unique", null, 0, 1, Column.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		addEOperation(columnEClass, null, "addToPrimaryKey", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(columnEClass, null, "addToUniqueIndex", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(columnEClass, null, "removeFromPrimaryKey", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(columnEClass, null, "removeFromUniqueIndex", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(indexEClass, Index.class, "Index", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIndex_Qualifier(), ecorePackage.getEString(), "qualifier", null, 0, 1, Index.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIndex_Elements(), this.getIndexElement(), null, "elements", null, 0, -1, Index.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIndex_Unique(), ecorePackage.getEBoolean(), "unique", null, 0, 1, Index.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIndex_Cardinality(), ecorePackage.getEInt(), "cardinality", null, 0, 1, Index.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIndex_IndexType(), ecorePackage.getEString(), "indexType", null, 0, 1, Index.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIndex_Owner(), this.getTable(), this.getTable_Indexes(), "owner", null, 1, 1, Index.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(viewEClass, View.class, "View", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getView_Query(), ecorePackage.getEString(), "query", null, 0, 1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getView_Columns(), this.getViewColumn(), null, "columns", null, 0, -1, View.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getView_Tables(), this.getViewTable(), null, "tables", null, 0, -1, View.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tableEClass, Table.class, "Table", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTable_PrimaryKey(), this.getPrimaryKey(), this.getPrimaryKey_Owner(), "primaryKey", null, 0, 1, Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTable_ForeignKeys(), this.getForeignKey(), this.getForeignKey_Owner(), "foreignKeys", null, 0, -1, Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTable_Constraints(), this.getConstraint(), this.getConstraint_Owner(), "constraints", null, 0, -1, Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTable_Indexes(), this.getIndex(), this.getIndex_Owner(), "indexes", null, 0, -1, Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTable_Columns(), this.getColumn(), this.getColumn_Owner(), "columns", null, 0, -1, Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primaryKeyEClass, PrimaryKey.class, "PrimaryKey", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrimaryKey_Columns(), this.getColumn(), this.getColumn_PrimaryKey(), "columns", null, 0, -1, PrimaryKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimaryKey_Owner(), this.getTable(), this.getTable_PrimaryKey(), "owner", null, 1, 1, PrimaryKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(foreignKeyEClass, ForeignKey.class, "ForeignKey", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForeignKey_Elements(), this.getForeignKeyElement(), null, "elements", null, 0, -1, ForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForeignKey_Owner(), this.getTable(), this.getTable_ForeignKeys(), "owner", null, 1, 1, ForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForeignKey_Target(), this.getTable(), null, "target", null, 0, 1, ForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(foreignKeyEClass, this.getTable(), "getSourceTable", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(foreignKeyEClass, this.getTable(), "getTargetTable", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(foreignKeyElementEClass, ForeignKeyElement.class, "ForeignKeyElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForeignKeyElement_FkColumn(), this.getColumn(), this.getColumn_ForeignKeyElements(), "fkColumn", null, 0, 1, ForeignKeyElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForeignKeyElement_PkColumn(), this.getColumn(), null, "pkColumn", null, 0, 1, ForeignKeyElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(indexElementEClass, IndexElement.class, "IndexElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIndexElement_Column(), this.getColumn(), this.getColumn_IndexElements(), "column", null, 0, 1, IndexElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIndexElement_Asc(), ecorePackage.getEBoolean(), "asc", null, 0, 1, IndexElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintEClass, Constraint.class, "Constraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstraint_Expression(), ecorePackage.getEString(), "expression", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraint_Owner(), this.getTable(), this.getTable_Constraints(), "owner", null, 1, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(databaseElementEClass, DatabaseElement.class, "DatabaseElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDatabaseElement_ID(), ecorePackage.getEString(), "ID", null, 0, 1, DatabaseElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDatabaseElement_Comments(), ecorePackage.getEString(), "comments", null, 0, 1, DatabaseElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDatabaseElement_TechID(), ecorePackage.getEString(), "techID", null, 0, 1, DatabaseElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schemaEClass, Schema.class, "Schema", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sequenceEClass, Sequence.class, "Sequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSequence_Start(), ecorePackage.getEBigInteger(), "start", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSequence_Increment(), ecorePackage.getEBigInteger(), "increment", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSequence_MinValue(), ecorePackage.getEBigInteger(), "minValue", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSequence_MaxValue(), ecorePackage.getEBigInteger(), "maxValue", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSequence_CacheSize(), ecorePackage.getEBigInteger(), "cacheSize", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSequence_Cycle(), ecorePackage.getEBoolean(), "cycle", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSequence_Columns(), this.getColumn(), this.getColumn_Sequence(), "columns", null, 0, -1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tableContainerEClass, TableContainer.class, "TableContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTableContainer_Tables(), this.getAbstractTable(), this.getAbstractTable_Owner(), "tables", null, 0, -1, TableContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTableContainer_Sequences(), this.getSequence(), null, "sequences", null, 0, -1, TableContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(viewElementEClass, ViewElement.class, "ViewElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getViewElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, ViewElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getViewElement_Alias(), ecorePackage.getEString(), "alias", null, 0, 1, ViewElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(viewColumnEClass, ViewColumn.class, "ViewColumn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getViewColumn_From(), this.getViewTable(), null, "from", null, 0, 1, ViewColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(viewTableEClass, ViewTable.class, "ViewTable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/GenModel</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGenModelAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/GenModel";
		addAnnotation
		  (getNamedElement_Name(),
		   source,
		   new String[] {
			   "documentation", "The name of this model element."
		   });
		addAnnotation
		  (getDataBase_Url(),
		   source,
		   new String[] {
			   "documentation", "The URL of the database."
		   });
		addAnnotation
		  (getDataBase_Schemas(),
		   source,
		   new String[] {
			   "documentation", "The list of schemas contained in this database."
		   });
		addAnnotation
		  (getDataBase_Defines(),
		   source,
		   new String[] {
			   "documentation", "The list of user defined type libraries in this database."
		   });
		addAnnotation
		  (getAbstractTable_Owner(),
		   source,
		   new String[] {
			   "documentation", "The container of this table."
		   });
		addAnnotation
		  (getColumn_Nullable(),
		   source,
		   new String[] {
			   "documentation", "Tells if this column value can be null."
		   });
		addAnnotation
		  (getColumn_DefaultValue(),
		   source,
		   new String[] {
			   "documentation", "The column default value."
		   });
		addAnnotation
		  (getColumn_Indexes(),
		   source,
		   new String[] {
			   "documentation", "The list of indexes for this column."
		   });
		addAnnotation
		  (getColumn_IndexElements(),
		   source,
		   new String[] {
			   "documentation", "The list of index elements for this column."
		   });
		addAnnotation
		  (getColumn_PrimaryKey(),
		   source,
		   new String[] {
			   "documentation", "The list of primary keys for this column."
		   });
		addAnnotation
		  (getColumn_ForeignKeys(),
		   source,
		   new String[] {
			   "documentation", "The list of foreign keys for this column."
		   });
		addAnnotation
		  (getColumn_ForeignKeyElements(),
		   source,
		   new String[] {
			   "documentation", "The list of foreign key elements for this column."
		   });
		addAnnotation
		  (getColumn_Type(),
		   source,
		   new String[] {
			   "documentation", "The type of this column."
		   });
		addAnnotation
		  (getColumn_Sequence(),
		   source,
		   new String[] {
			   "documentation", "The sequence for this column."
		   });
		addAnnotation
		  (getColumn_Owner(),
		   source,
		   new String[] {
			   "documentation", "The containing table."
		   });
		addAnnotation
		  (getColumn_Autoincrement(),
		   source,
		   new String[] {
			   "documentation", "Tells if the column auto increments."
		   });
		addAnnotation
		  (getColumn_InPrimaryKey(),
		   source,
		   new String[] {
			   "documentation", "Tells if the column is in primary keys."
		   });
		addAnnotation
		  (getColumn_InForeignKey(),
		   source,
		   new String[] {
			   "documentation", "Tells if the column is in foreign keys."
		   });
		addAnnotation
		  (getColumn_Unique(),
		   source,
		   new String[] {
			   "documentation", "Tells if the column values are unique."
		   });
		addAnnotation
		  (getIndex_Qualifier(),
		   source,
		   new String[] {
			   "documentation", "The index qualifier."
		   });
		addAnnotation
		  (getIndex_Elements(),
		   source,
		   new String[] {
			   "documentation", "The list of index elements."
		   });
		addAnnotation
		  (getIndex_Unique(),
		   source,
		   new String[] {
			   "documentation", "Tells if the index is unique."
		   });
		addAnnotation
		  (getIndex_Cardinality(),
		   source,
		   new String[] {
			   "documentation", "The index cardinality."
		   });
		addAnnotation
		  (getIndex_IndexType(),
		   source,
		   new String[] {
			   "documentation", "The index type."
		   });
		addAnnotation
		  (getIndex_Owner(),
		   source,
		   new String[] {
			   "documentation", "The containing table."
		   });
		addAnnotation
		  (getView_Query(),
		   source,
		   new String[] {
			   "documentation", "The query populating the view."
		   });
		addAnnotation
		  (getView_Columns(),
		   source,
		   new String[] {
			   "documentation", "The list of columns in this view."
		   });
		addAnnotation
		  (getView_Tables(),
		   source,
		   new String[] {
			   "documentation", "The list of tables in this view."
		   });
		addAnnotation
		  (getTable_PrimaryKey(),
		   source,
		   new String[] {
			   "documentation", "The primary key."
		   });
		addAnnotation
		  (getTable_ForeignKeys(),
		   source,
		   new String[] {
			   "documentation", "The list of foreign keys."
		   });
		addAnnotation
		  (getTable_Constraints(),
		   source,
		   new String[] {
			   "documentation", "The list of constraints."
		   });
		addAnnotation
		  (getTable_Indexes(),
		   source,
		   new String[] {
			   "documentation", "The list of indexes."
		   });
		addAnnotation
		  (getTable_Columns(),
		   source,
		   new String[] {
			   "documentation", "The list of columns."
		   });
		addAnnotation
		  (getPrimaryKey_Columns(),
		   source,
		   new String[] {
			   "documentation", "The list of columns."
		   });
		addAnnotation
		  (getPrimaryKey_Owner(),
		   source,
		   new String[] {
			   "documentation", "The containing table."
		   });
		addAnnotation
		  (getForeignKey_Elements(),
		   source,
		   new String[] {
			   "documentation", "The list of foreign key elements."
		   });
		addAnnotation
		  (getForeignKey_Owner(),
		   source,
		   new String[] {
			   "documentation", "The containing table."
		   });
		addAnnotation
		  (getForeignKey_Target(),
		   source,
		   new String[] {
			   "documentation", "The targeted table."
		   });
		addAnnotation
		  (getForeignKeyElement_FkColumn(),
		   source,
		   new String[] {
			   "documentation", "The foreign key column."
		   });
		addAnnotation
		  (getForeignKeyElement_PkColumn(),
		   source,
		   new String[] {
			   "documentation", "The primary key column."
		   });
		addAnnotation
		  (getIndexElement_Column(),
		   source,
		   new String[] {
			   "documentation", "The column to index."
		   });
		addAnnotation
		  (getIndexElement_Asc(),
		   source,
		   new String[] {
			   "documentation", "The order."
		   });
		addAnnotation
		  (getConstraint_Expression(),
		   source,
		   new String[] {
			   "documentation", "The constaint expression."
		   });
		addAnnotation
		  (getConstraint_Owner(),
		   source,
		   new String[] {
			   "documentation", "The containing table."
		   });
		addAnnotation
		  (getDatabaseElement_ID(),
		   source,
		   new String[] {
			   "documentation", "The identifier of the element."
		   });
		addAnnotation
		  (getDatabaseElement_Comments(),
		   source,
		   new String[] {
			   "documentation", "The comment."
		   });
		addAnnotation
		  (getDatabaseElement_TechID(),
		   source,
		   new String[] {
			   "documentation", "The technical identifier."
		   });
		addAnnotation
		  (getSequence_Start(),
		   source,
		   new String[] {
			   "documentation", "The starting value."
		   });
		addAnnotation
		  (getSequence_Increment(),
		   source,
		   new String[] {
			   "documentation", "The increment size."
		   });
		addAnnotation
		  (getSequence_MinValue(),
		   source,
		   new String[] {
			   "documentation", "The minimum value."
		   });
		addAnnotation
		  (getSequence_MaxValue(),
		   source,
		   new String[] {
			   "documentation", "The maximum value."
		   });
		addAnnotation
		  (getSequence_CacheSize(),
		   source,
		   new String[] {
			   "documentation", "The cache size."
		   });
		addAnnotation
		  (getSequence_Cycle(),
		   source,
		   new String[] {
			   "documentation", "Tells if the sequence is cyclic."
		   });
		addAnnotation
		  (getSequence_Columns(),
		   source,
		   new String[] {
			   "documentation", "The list of colums this sequence is applied."
		   });
		addAnnotation
		  (getTableContainer_Tables(),
		   source,
		   new String[] {
			   "documentation", "The list of contained tables."
		   });
		addAnnotation
		  (getTableContainer_Sequences(),
		   source,
		   new String[] {
			   "documentation", "The list of contained sequences."
		   });
		addAnnotation
		  (getViewElement_Name(),
		   source,
		   new String[] {
			   "documentation", "The name."
		   });
		addAnnotation
		  (getViewElement_Alias(),
		   source,
		   new String[] {
			   "documentation", "The alias."
		   });
	}

} //DatabasePackageImpl
