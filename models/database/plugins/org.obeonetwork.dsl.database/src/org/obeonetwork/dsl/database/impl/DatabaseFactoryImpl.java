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
package org.obeonetwork.dsl.database.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.dsl.database.*;
import org.obeonetwork.dsl.database.spec.ColumnSpec;
import org.obeonetwork.dsl.database.spec.ViewSpec;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DatabaseFactoryImpl extends EFactoryImpl implements DatabaseFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2011, 2017 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DatabaseFactory init() {
		try {
			DatabaseFactory theDatabaseFactory = (DatabaseFactory)EPackage.Registry.INSTANCE.getEFactory(DatabasePackage.eNS_URI);
			if (theDatabaseFactory != null) {
				return theDatabaseFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DatabaseFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DatabasePackage.DATA_BASE: return (EObject)createDataBase();
			case DatabasePackage.COLUMN: return (EObject)createColumn();
			case DatabasePackage.INDEX: return (EObject)createIndex();
			case DatabasePackage.VIEW: return (EObject)createView();
			case DatabasePackage.TABLE: return (EObject)createTable();
			case DatabasePackage.PRIMARY_KEY: return (EObject)createPrimaryKey();
			case DatabasePackage.FOREIGN_KEY: return (EObject)createForeignKey();
			case DatabasePackage.FOREIGN_KEY_ELEMENT: return (EObject)createForeignKeyElement();
			case DatabasePackage.INDEX_ELEMENT: return (EObject)createIndexElement();
			case DatabasePackage.CONSTRAINT: return (EObject)createConstraint();
			case DatabasePackage.SCHEMA: return (EObject)createSchema();
			case DatabasePackage.SEQUENCE: return (EObject)createSequence();
			case DatabasePackage.VIEW_ELEMENT: return (EObject)createViewElement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DataBase createDataBase() {
		DataBaseImpl dataBase = new DataBaseImpl();
		dataBase.setTechID(EcoreUtil.generateUUID());
		return dataBase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Column createColumn() {
		ColumnImpl column = new ColumnSpec();
		column.setTechID(EcoreUtil.generateUUID());
		TypeInstance type = TypesLibraryFactory.eINSTANCE.createTypeInstance();
		column.setType(type);
		return column;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Index createIndex() {
		IndexImpl index = new IndexImpl();
		index.setTechID(EcoreUtil.generateUUID());
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public View createView() {
		ViewSpec view = new ViewSpec();
		view.setTechID(EcoreUtil.generateUUID());
		return view;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Table createTable() {
		TableImpl table = new TableImpl();
		table.setTechID(EcoreUtil.generateUUID());
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PrimaryKey createPrimaryKey() {
		PrimaryKeyImpl primaryKey = new PrimaryKeyImpl();
		primaryKey.setTechID(EcoreUtil.generateUUID());
		return primaryKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ForeignKey createForeignKey() {
		ForeignKeyImpl foreignKey = new ForeignKeyImpl();
		foreignKey.setTechID(EcoreUtil.generateUUID());
		return foreignKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ForeignKeyElement createForeignKeyElement() {
		ForeignKeyElementImpl foreignKeyElement = new ForeignKeyElementImpl();
		foreignKeyElement.setTechID(EcoreUtil.generateUUID());
		return foreignKeyElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IndexElement createIndexElement() {
		IndexElementImpl indexElement = new IndexElementImpl();
		indexElement.setTechID(EcoreUtil.generateUUID());
		return indexElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Constraint createConstraint() {
		ConstraintImpl constraint = new ConstraintImpl();
		constraint.setTechID(EcoreUtil.generateUUID());
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Schema createSchema() {
		SchemaImpl schema = new SchemaImpl();
		schema.setTechID(EcoreUtil.generateUUID());
		return schema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Sequence createSequence() {
		SequenceImpl sequence = new SequenceImpl();
		sequence.setTechID(EcoreUtil.generateUUID());
		return sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewElement createViewElement() {
		ViewElementImpl viewElement = new ViewElementImpl();
		return viewElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatabasePackage getDatabasePackage() {
		return (DatabasePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DatabasePackage getPackage() {
		return DatabasePackage.eINSTANCE;
	}

} //DatabaseFactoryImpl
