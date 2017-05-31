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

import org.eclipse.emf.compare.ComparePackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionFactory
 * @model kind="package"
 * @generated
 */
public interface DbevolutionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dbevolution";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.obeonetwork.org/dsl/database/evolution/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dbevolution";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	DbevolutionPackage eINSTANCE = org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.AddTableImpl <em>Add Table</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.AddTableImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getAddTable()
	 * @generated
	 */
	int ADD_TABLE = 2;

	/**
	 * The meta object id for the '
	 * {@link org.obeonetwork.dsl.database.dbevolution.impl.RemoveTableImpl
	 * <em>Remove Table</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.RemoveTableImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getRemoveTable()
	 * @generated
	 */
	int REMOVE_TABLE = 3;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.DatabaseChangeSetImpl <em>Database Change Set</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DatabaseChangeSetImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getDatabaseChangeSet()
	 * @generated
	 */
	int DATABASE_CHANGE_SET = 0;

	/**
	 * The feature id for the '<em><b>Matched Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CHANGE_SET__MATCHED_RESOURCES = ComparePackage.COMPARISON__MATCHED_RESOURCES;

	/**
	 * The feature id for the '<em><b>Matches</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CHANGE_SET__MATCHES = ComparePackage.COMPARISON__MATCHES;

	/**
	 * The feature id for the '<em><b>Conflicts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CHANGE_SET__CONFLICTS = ComparePackage.COMPARISON__CONFLICTS;

	/**
	 * The feature id for the '<em><b>Equivalences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CHANGE_SET__EQUIVALENCES = ComparePackage.COMPARISON__EQUIVALENCES;

	/**
	 * The feature id for the '<em><b>Three Way</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CHANGE_SET__THREE_WAY = ComparePackage.COMPARISON__THREE_WAY;

	/**
	 * The feature id for the '<em><b>Diagnostic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CHANGE_SET__DIAGNOSTIC = ComparePackage.COMPARISON__DIAGNOSTIC;

	/**
	 * The number of structural features of the '<em>Database Change Set</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CHANGE_SET_FEATURE_COUNT = ComparePackage.COMPARISON_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.DBDiffImpl <em>DB Diff</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DBDiffImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getDBDiff()
	 * @generated
	 */
	int DB_DIFF = 39;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_DIFF__MATCH = ComparePackage.DIFF__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_DIFF__REQUIRES = ComparePackage.DIFF__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_DIFF__REQUIRED_BY = ComparePackage.DIFF__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_DIFF__IMPLIES = ComparePackage.DIFF__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_DIFF__IMPLIED_BY = ComparePackage.DIFF__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_DIFF__REFINES = ComparePackage.DIFF__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_DIFF__REFINED_BY = ComparePackage.DIFF__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_DIFF__PRIME_REFINING = ComparePackage.DIFF__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_DIFF__KIND = ComparePackage.DIFF__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_DIFF__SOURCE = ComparePackage.DIFF__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_DIFF__STATE = ComparePackage.DIFF__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_DIFF__EQUIVALENCE = ComparePackage.DIFF__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_DIFF__CONFLICT = ComparePackage.DIFF__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_DIFF__TARGET = ComparePackage.DIFF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>DB Diff</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_DIFF_FEATURE_COUNT = ComparePackage.DIFF_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.obeonetwork.dsl.database.dbevolution.impl.TableChangeImpl
	 * <em>Table Change</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.TableChangeImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getTableChange()
	 * @generated
	 */
	int TABLE_CHANGE = 1;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CHANGE__MATCH = DB_DIFF__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CHANGE__REQUIRES = DB_DIFF__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CHANGE__REQUIRED_BY = DB_DIFF__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CHANGE__IMPLIES = DB_DIFF__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CHANGE__IMPLIED_BY = DB_DIFF__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CHANGE__REFINES = DB_DIFF__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CHANGE__REFINED_BY = DB_DIFF__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CHANGE__PRIME_REFINING = DB_DIFF__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CHANGE__KIND = DB_DIFF__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CHANGE__SOURCE = DB_DIFF__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CHANGE__STATE = DB_DIFF__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CHANGE__EQUIVALENCE = DB_DIFF__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CHANGE__CONFLICT = DB_DIFF__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CHANGE__TARGET = DB_DIFF__TARGET;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TABLE_CHANGE__TABLE = DB_DIFF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Table Change</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_CHANGE_FEATURE_COUNT = DB_DIFF_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TABLE__MATCH = TABLE_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TABLE__REQUIRES = TABLE_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TABLE__REQUIRED_BY = TABLE_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TABLE__IMPLIES = TABLE_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TABLE__IMPLIED_BY = TABLE_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TABLE__REFINES = TABLE_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TABLE__REFINED_BY = TABLE_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TABLE__PRIME_REFINING = TABLE_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADD_TABLE__KIND = TABLE_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TABLE__SOURCE = TABLE_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TABLE__STATE = TABLE_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TABLE__EQUIVALENCE = TABLE_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TABLE__CONFLICT = TABLE_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TABLE__TARGET = TABLE_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADD_TABLE__TABLE = TABLE_CHANGE__TABLE;

	/**
	 * The number of structural features of the '<em>Add Table</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADD_TABLE_FEATURE_COUNT = TABLE_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_TABLE__MATCH = TABLE_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_TABLE__REQUIRES = TABLE_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_TABLE__REQUIRED_BY = TABLE_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_TABLE__IMPLIES = TABLE_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_TABLE__IMPLIED_BY = TABLE_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_TABLE__REFINES = TABLE_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_TABLE__REFINED_BY = TABLE_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_TABLE__PRIME_REFINING = TABLE_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REMOVE_TABLE__KIND = TABLE_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_TABLE__SOURCE = TABLE_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_TABLE__STATE = TABLE_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_TABLE__EQUIVALENCE = TABLE_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_TABLE__CONFLICT = TABLE_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_TABLE__TARGET = TABLE_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REMOVE_TABLE__TABLE = TABLE_CHANGE__TABLE;

	/**
	 * The number of structural features of the '<em>Remove Table</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_TABLE_FEATURE_COUNT = TABLE_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.obeonetwork.dsl.database.dbevolution.impl.AlterTableImpl
	 * <em>Alter Table</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.AlterTableImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getAlterTable()
	 * @generated
	 */
	int ALTER_TABLE = 4;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_TABLE__MATCH = TABLE_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_TABLE__REQUIRES = TABLE_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_TABLE__REQUIRED_BY = TABLE_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_TABLE__IMPLIES = TABLE_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_TABLE__IMPLIED_BY = TABLE_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_TABLE__REFINES = TABLE_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_TABLE__REFINED_BY = TABLE_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_TABLE__PRIME_REFINING = TABLE_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALTER_TABLE__KIND = TABLE_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_TABLE__SOURCE = TABLE_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_TABLE__STATE = TABLE_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_TABLE__EQUIVALENCE = TABLE_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_TABLE__CONFLICT = TABLE_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_TABLE__TARGET = TABLE_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALTER_TABLE__TABLE = TABLE_CHANGE__TABLE;

	/**
	 * The number of structural features of the '<em>Alter Table</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_TABLE_FEATURE_COUNT = TABLE_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.RenameTableChangeImpl <em>Rename Table Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.RenameTableChangeImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getRenameTableChange()
	 * @generated
	 */
	int RENAME_TABLE_CHANGE = 5;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_TABLE_CHANGE__MATCH = TABLE_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_TABLE_CHANGE__REQUIRES = TABLE_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_TABLE_CHANGE__REQUIRED_BY = TABLE_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_TABLE_CHANGE__IMPLIES = TABLE_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_TABLE_CHANGE__IMPLIED_BY = TABLE_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_TABLE_CHANGE__REFINES = TABLE_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_TABLE_CHANGE__REFINED_BY = TABLE_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_TABLE_CHANGE__PRIME_REFINING = TABLE_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_TABLE_CHANGE__KIND = TABLE_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_TABLE_CHANGE__SOURCE = TABLE_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_TABLE_CHANGE__STATE = TABLE_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_TABLE_CHANGE__EQUIVALENCE = TABLE_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_TABLE_CHANGE__CONFLICT = TABLE_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_TABLE_CHANGE__TARGET = TABLE_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_TABLE_CHANGE__TABLE = TABLE_CHANGE__TABLE;

	/**
	 * The feature id for the '<em><b>New Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_TABLE_CHANGE__NEW_TABLE = TABLE_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rename Table Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_TABLE_CHANGE_FEATURE_COUNT = TABLE_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.ColumnChangeImpl <em>Column Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.ColumnChangeImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getColumnChange()
	 * @generated
	 */
	int COLUMN_CHANGE = 7;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.AddColumnChangeImpl <em>Add Column Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.AddColumnChangeImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getAddColumnChange()
	 * @generated
	 */
	int ADD_COLUMN_CHANGE = 8;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.RemoveColumnChangeImpl <em>Remove Column Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.RemoveColumnChangeImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getRemoveColumnChange()
	 * @generated
	 */
	int REMOVE_COLUMN_CHANGE = 9;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.RenameColumnChangeImpl <em>Rename Column Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.RenameColumnChangeImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getRenameColumnChange()
	 * @generated
	 */
	int RENAME_COLUMN_CHANGE = 10;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.UpdateColumnChangeImpl <em>Update Column Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.UpdateColumnChangeImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getUpdateColumnChange()
	 * @generated
	 */
	int UPDATE_COLUMN_CHANGE = 11;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.UpdateColumnCommentChangeImpl <em>Update Column Comment Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.UpdateColumnCommentChangeImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getUpdateColumnCommentChange()
	 * @generated
	 */
	int UPDATE_COLUMN_COMMENT_CHANGE = 12;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.UpdateTableCommentChangeImpl <em>Update Table Comment Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.UpdateTableCommentChangeImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getUpdateTableCommentChange()
	 * @generated
	 */
	int UPDATE_TABLE_COMMENT_CHANGE = 6;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TABLE_COMMENT_CHANGE__MATCH = TABLE_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TABLE_COMMENT_CHANGE__REQUIRES = TABLE_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TABLE_COMMENT_CHANGE__REQUIRED_BY = TABLE_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TABLE_COMMENT_CHANGE__IMPLIES = TABLE_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TABLE_COMMENT_CHANGE__IMPLIED_BY = TABLE_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TABLE_COMMENT_CHANGE__REFINES = TABLE_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TABLE_COMMENT_CHANGE__REFINED_BY = TABLE_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TABLE_COMMENT_CHANGE__PRIME_REFINING = TABLE_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TABLE_COMMENT_CHANGE__KIND = TABLE_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TABLE_COMMENT_CHANGE__SOURCE = TABLE_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TABLE_COMMENT_CHANGE__STATE = TABLE_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TABLE_COMMENT_CHANGE__EQUIVALENCE = TABLE_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TABLE_COMMENT_CHANGE__CONFLICT = TABLE_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TABLE_COMMENT_CHANGE__TARGET = TABLE_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TABLE_COMMENT_CHANGE__TABLE = TABLE_CHANGE__TABLE;

	/**
	 * The feature id for the '<em><b>New Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TABLE_COMMENT_CHANGE__NEW_TABLE = TABLE_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Update Table Comment Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TABLE_COMMENT_CHANGE_FEATURE_COUNT = TABLE_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_CHANGE__MATCH = DB_DIFF__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_CHANGE__REQUIRES = DB_DIFF__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_CHANGE__REQUIRED_BY = DB_DIFF__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_CHANGE__IMPLIES = DB_DIFF__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_CHANGE__IMPLIED_BY = DB_DIFF__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_CHANGE__REFINES = DB_DIFF__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_CHANGE__REFINED_BY = DB_DIFF__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_CHANGE__PRIME_REFINING = DB_DIFF__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_CHANGE__KIND = DB_DIFF__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_CHANGE__SOURCE = DB_DIFF__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_CHANGE__STATE = DB_DIFF__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_CHANGE__EQUIVALENCE = DB_DIFF__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_CHANGE__CONFLICT = DB_DIFF__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_CHANGE__TARGET = DB_DIFF__TARGET;

	/**
	 * The feature id for the '<em><b>Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_CHANGE__COLUMN = DB_DIFF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Column Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_CHANGE_FEATURE_COUNT = DB_DIFF_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_COLUMN_CHANGE__MATCH = COLUMN_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_COLUMN_CHANGE__REQUIRES = COLUMN_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_COLUMN_CHANGE__REQUIRED_BY = COLUMN_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_COLUMN_CHANGE__IMPLIES = COLUMN_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_COLUMN_CHANGE__IMPLIED_BY = COLUMN_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_COLUMN_CHANGE__REFINES = COLUMN_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_COLUMN_CHANGE__REFINED_BY = COLUMN_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_COLUMN_CHANGE__PRIME_REFINING = COLUMN_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_COLUMN_CHANGE__KIND = COLUMN_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_COLUMN_CHANGE__SOURCE = COLUMN_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_COLUMN_CHANGE__STATE = COLUMN_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_COLUMN_CHANGE__EQUIVALENCE = COLUMN_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_COLUMN_CHANGE__CONFLICT = COLUMN_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_COLUMN_CHANGE__TARGET = COLUMN_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_COLUMN_CHANGE__COLUMN = COLUMN_CHANGE__COLUMN;

	/**
	 * The number of structural features of the '<em>Add Column Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_COLUMN_CHANGE_FEATURE_COUNT = COLUMN_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_COLUMN_CHANGE__MATCH = COLUMN_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_COLUMN_CHANGE__REQUIRES = COLUMN_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_COLUMN_CHANGE__REQUIRED_BY = COLUMN_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_COLUMN_CHANGE__IMPLIES = COLUMN_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_COLUMN_CHANGE__IMPLIED_BY = COLUMN_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_COLUMN_CHANGE__REFINES = COLUMN_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_COLUMN_CHANGE__REFINED_BY = COLUMN_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_COLUMN_CHANGE__PRIME_REFINING = COLUMN_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_COLUMN_CHANGE__KIND = COLUMN_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_COLUMN_CHANGE__SOURCE = COLUMN_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_COLUMN_CHANGE__STATE = COLUMN_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_COLUMN_CHANGE__EQUIVALENCE = COLUMN_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_COLUMN_CHANGE__CONFLICT = COLUMN_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_COLUMN_CHANGE__TARGET = COLUMN_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_COLUMN_CHANGE__COLUMN = COLUMN_CHANGE__COLUMN;

	/**
	 * The number of structural features of the '<em>Remove Column Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_COLUMN_CHANGE_FEATURE_COUNT = COLUMN_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_COLUMN_CHANGE__MATCH = COLUMN_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_COLUMN_CHANGE__REQUIRES = COLUMN_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_COLUMN_CHANGE__REQUIRED_BY = COLUMN_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_COLUMN_CHANGE__IMPLIES = COLUMN_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_COLUMN_CHANGE__IMPLIED_BY = COLUMN_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_COLUMN_CHANGE__REFINES = COLUMN_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_COLUMN_CHANGE__REFINED_BY = COLUMN_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_COLUMN_CHANGE__PRIME_REFINING = COLUMN_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_COLUMN_CHANGE__KIND = COLUMN_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_COLUMN_CHANGE__SOURCE = COLUMN_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_COLUMN_CHANGE__STATE = COLUMN_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_COLUMN_CHANGE__EQUIVALENCE = COLUMN_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_COLUMN_CHANGE__CONFLICT = COLUMN_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_COLUMN_CHANGE__TARGET = COLUMN_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_COLUMN_CHANGE__COLUMN = COLUMN_CHANGE__COLUMN;

	/**
	 * The feature id for the '<em><b>New Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_COLUMN_CHANGE__NEW_COLUMN = COLUMN_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rename Column Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_COLUMN_CHANGE_FEATURE_COUNT = COLUMN_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_CHANGE__MATCH = COLUMN_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_CHANGE__REQUIRES = COLUMN_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_CHANGE__REQUIRED_BY = COLUMN_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_CHANGE__IMPLIES = COLUMN_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_CHANGE__IMPLIED_BY = COLUMN_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_CHANGE__REFINES = COLUMN_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_CHANGE__REFINED_BY = COLUMN_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_CHANGE__PRIME_REFINING = COLUMN_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_CHANGE__KIND = COLUMN_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_CHANGE__SOURCE = COLUMN_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_CHANGE__STATE = COLUMN_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_CHANGE__EQUIVALENCE = COLUMN_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_CHANGE__CONFLICT = COLUMN_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_CHANGE__TARGET = COLUMN_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_CHANGE__COLUMN = COLUMN_CHANGE__COLUMN;

	/**
	 * The number of structural features of the '<em>Update Column Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_CHANGE_FEATURE_COUNT = COLUMN_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_COMMENT_CHANGE__MATCH = COLUMN_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_COMMENT_CHANGE__REQUIRES = COLUMN_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_COMMENT_CHANGE__REQUIRED_BY = COLUMN_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_COMMENT_CHANGE__IMPLIES = COLUMN_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_COMMENT_CHANGE__IMPLIED_BY = COLUMN_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_COMMENT_CHANGE__REFINES = COLUMN_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_COMMENT_CHANGE__REFINED_BY = COLUMN_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_COMMENT_CHANGE__PRIME_REFINING = COLUMN_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_COMMENT_CHANGE__KIND = COLUMN_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_COMMENT_CHANGE__SOURCE = COLUMN_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_COMMENT_CHANGE__STATE = COLUMN_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_COMMENT_CHANGE__EQUIVALENCE = COLUMN_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_COMMENT_CHANGE__CONFLICT = COLUMN_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_COMMENT_CHANGE__TARGET = COLUMN_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_COMMENT_CHANGE__COLUMN = COLUMN_CHANGE__COLUMN;

	/**
	 * The number of structural features of the '<em>Update Column Comment Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_COLUMN_COMMENT_CHANGE_FEATURE_COUNT = COLUMN_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.PrimaryKeyChangeImpl <em>Primary Key Change</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.PrimaryKeyChangeImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getPrimaryKeyChange()
	 * @generated
	 */
	int PRIMARY_KEY_CHANGE = 13;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY_CHANGE__MATCH = DB_DIFF__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY_CHANGE__REQUIRES = DB_DIFF__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY_CHANGE__REQUIRED_BY = DB_DIFF__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY_CHANGE__IMPLIES = DB_DIFF__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY_CHANGE__IMPLIED_BY = DB_DIFF__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY_CHANGE__REFINES = DB_DIFF__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY_CHANGE__REFINED_BY = DB_DIFF__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY_CHANGE__PRIME_REFINING = DB_DIFF__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY_CHANGE__KIND = DB_DIFF__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY_CHANGE__SOURCE = DB_DIFF__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY_CHANGE__STATE = DB_DIFF__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY_CHANGE__EQUIVALENCE = DB_DIFF__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY_CHANGE__CONFLICT = DB_DIFF__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY_CHANGE__TARGET = DB_DIFF__TARGET;

	/**
	 * The feature id for the '<em><b>Primary Key</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY_CHANGE__PRIMARY_KEY = DB_DIFF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primary Key Change</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_KEY_CHANGE_FEATURE_COUNT = DB_DIFF_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.AddPrimaryKeyImpl <em>Add Primary Key</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.AddPrimaryKeyImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getAddPrimaryKey()
	 * @generated
	 */
	int ADD_PRIMARY_KEY = 14;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_PRIMARY_KEY__MATCH = PRIMARY_KEY_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_PRIMARY_KEY__REQUIRES = PRIMARY_KEY_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_PRIMARY_KEY__REQUIRED_BY = PRIMARY_KEY_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_PRIMARY_KEY__IMPLIES = PRIMARY_KEY_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_PRIMARY_KEY__IMPLIED_BY = PRIMARY_KEY_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_PRIMARY_KEY__REFINES = PRIMARY_KEY_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_PRIMARY_KEY__REFINED_BY = PRIMARY_KEY_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_PRIMARY_KEY__PRIME_REFINING = PRIMARY_KEY_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADD_PRIMARY_KEY__KIND = PRIMARY_KEY_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_PRIMARY_KEY__SOURCE = PRIMARY_KEY_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_PRIMARY_KEY__STATE = PRIMARY_KEY_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_PRIMARY_KEY__EQUIVALENCE = PRIMARY_KEY_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_PRIMARY_KEY__CONFLICT = PRIMARY_KEY_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_PRIMARY_KEY__TARGET = PRIMARY_KEY_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Primary Key</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADD_PRIMARY_KEY__PRIMARY_KEY = PRIMARY_KEY_CHANGE__PRIMARY_KEY;

	/**
	 * The number of structural features of the '<em>Add Primary Key</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_PRIMARY_KEY_FEATURE_COUNT = PRIMARY_KEY_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.RemovePrimaryKeyImpl <em>Remove Primary Key</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.RemovePrimaryKeyImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getRemovePrimaryKey()
	 * @generated
	 */
	int REMOVE_PRIMARY_KEY = 15;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_PRIMARY_KEY__MATCH = PRIMARY_KEY_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_PRIMARY_KEY__REQUIRES = PRIMARY_KEY_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_PRIMARY_KEY__REQUIRED_BY = PRIMARY_KEY_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_PRIMARY_KEY__IMPLIES = PRIMARY_KEY_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_PRIMARY_KEY__IMPLIED_BY = PRIMARY_KEY_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_PRIMARY_KEY__REFINES = PRIMARY_KEY_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_PRIMARY_KEY__REFINED_BY = PRIMARY_KEY_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_PRIMARY_KEY__PRIME_REFINING = PRIMARY_KEY_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REMOVE_PRIMARY_KEY__KIND = PRIMARY_KEY_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_PRIMARY_KEY__SOURCE = PRIMARY_KEY_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_PRIMARY_KEY__STATE = PRIMARY_KEY_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_PRIMARY_KEY__EQUIVALENCE = PRIMARY_KEY_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_PRIMARY_KEY__CONFLICT = PRIMARY_KEY_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_PRIMARY_KEY__TARGET = PRIMARY_KEY_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Primary Key</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REMOVE_PRIMARY_KEY__PRIMARY_KEY = PRIMARY_KEY_CHANGE__PRIMARY_KEY;

	/**
	 * The number of structural features of the '<em>Remove Primary Key</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_PRIMARY_KEY_FEATURE_COUNT = PRIMARY_KEY_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.UpdatePrimaryKeyImpl <em>Update Primary Key</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.UpdatePrimaryKeyImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getUpdatePrimaryKey()
	 * @generated
	 */
	int UPDATE_PRIMARY_KEY = 16;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_PRIMARY_KEY__MATCH = PRIMARY_KEY_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_PRIMARY_KEY__REQUIRES = PRIMARY_KEY_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_PRIMARY_KEY__REQUIRED_BY = PRIMARY_KEY_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_PRIMARY_KEY__IMPLIES = PRIMARY_KEY_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_PRIMARY_KEY__IMPLIED_BY = PRIMARY_KEY_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_PRIMARY_KEY__REFINES = PRIMARY_KEY_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_PRIMARY_KEY__REFINED_BY = PRIMARY_KEY_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_PRIMARY_KEY__PRIME_REFINING = PRIMARY_KEY_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UPDATE_PRIMARY_KEY__KIND = PRIMARY_KEY_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_PRIMARY_KEY__SOURCE = PRIMARY_KEY_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_PRIMARY_KEY__STATE = PRIMARY_KEY_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_PRIMARY_KEY__EQUIVALENCE = PRIMARY_KEY_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_PRIMARY_KEY__CONFLICT = PRIMARY_KEY_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_PRIMARY_KEY__TARGET = PRIMARY_KEY_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Primary Key</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UPDATE_PRIMARY_KEY__PRIMARY_KEY = PRIMARY_KEY_CHANGE__PRIMARY_KEY;

	/**
	 * The feature id for the '<em><b>New Primary Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_PRIMARY_KEY__NEW_PRIMARY_KEY = PRIMARY_KEY_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Update Primary Key</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_PRIMARY_KEY_FEATURE_COUNT = PRIMARY_KEY_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.obeonetwork.dsl.database.dbevolution.impl.IndexChangeImpl
	 * <em>Index Change</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.IndexChangeImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getIndexChange()
	 * @generated
	 */
	int INDEX_CHANGE = 17;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CHANGE__MATCH = DB_DIFF__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CHANGE__REQUIRES = DB_DIFF__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CHANGE__REQUIRED_BY = DB_DIFF__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CHANGE__IMPLIES = DB_DIFF__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CHANGE__IMPLIED_BY = DB_DIFF__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CHANGE__REFINES = DB_DIFF__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CHANGE__REFINED_BY = DB_DIFF__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CHANGE__PRIME_REFINING = DB_DIFF__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CHANGE__KIND = DB_DIFF__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CHANGE__SOURCE = DB_DIFF__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CHANGE__STATE = DB_DIFF__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CHANGE__EQUIVALENCE = DB_DIFF__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CHANGE__CONFLICT = DB_DIFF__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CHANGE__TARGET = DB_DIFF__TARGET;

	/**
	 * The feature id for the '<em><b>Index</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INDEX_CHANGE__INDEX = DB_DIFF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Index Change</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CHANGE_FEATURE_COUNT = DB_DIFF_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.AddIndexImpl <em>Add Index</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.AddIndexImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getAddIndex()
	 * @generated
	 */
	int ADD_INDEX = 18;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_INDEX__MATCH = INDEX_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_INDEX__REQUIRES = INDEX_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_INDEX__REQUIRED_BY = INDEX_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_INDEX__IMPLIES = INDEX_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_INDEX__IMPLIED_BY = INDEX_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_INDEX__REFINES = INDEX_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_INDEX__REFINED_BY = INDEX_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_INDEX__PRIME_REFINING = INDEX_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADD_INDEX__KIND = INDEX_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_INDEX__SOURCE = INDEX_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_INDEX__STATE = INDEX_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_INDEX__EQUIVALENCE = INDEX_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_INDEX__CONFLICT = INDEX_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_INDEX__TARGET = INDEX_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Index</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADD_INDEX__INDEX = INDEX_CHANGE__INDEX;

	/**
	 * The number of structural features of the '<em>Add Index</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADD_INDEX_FEATURE_COUNT = INDEX_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.obeonetwork.dsl.database.dbevolution.impl.RemoveIndexImpl
	 * <em>Remove Index</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.RemoveIndexImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getRemoveIndex()
	 * @generated
	 */
	int REMOVE_INDEX = 19;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_INDEX__MATCH = INDEX_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_INDEX__REQUIRES = INDEX_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_INDEX__REQUIRED_BY = INDEX_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_INDEX__IMPLIES = INDEX_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_INDEX__IMPLIED_BY = INDEX_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_INDEX__REFINES = INDEX_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_INDEX__REFINED_BY = INDEX_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_INDEX__PRIME_REFINING = INDEX_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REMOVE_INDEX__KIND = INDEX_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_INDEX__SOURCE = INDEX_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_INDEX__STATE = INDEX_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_INDEX__EQUIVALENCE = INDEX_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_INDEX__CONFLICT = INDEX_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_INDEX__TARGET = INDEX_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Index</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REMOVE_INDEX__INDEX = INDEX_CHANGE__INDEX;

	/**
	 * The number of structural features of the '<em>Remove Index</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_INDEX_FEATURE_COUNT = INDEX_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.obeonetwork.dsl.database.dbevolution.impl.UpdateIndexImpl
	 * <em>Update Index</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.UpdateIndexImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getUpdateIndex()
	 * @generated
	 */
	int UPDATE_INDEX = 20;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_INDEX__MATCH = INDEX_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_INDEX__REQUIRES = INDEX_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_INDEX__REQUIRED_BY = INDEX_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_INDEX__IMPLIES = INDEX_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_INDEX__IMPLIED_BY = INDEX_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_INDEX__REFINES = INDEX_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_INDEX__REFINED_BY = INDEX_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_INDEX__PRIME_REFINING = INDEX_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UPDATE_INDEX__KIND = INDEX_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_INDEX__SOURCE = INDEX_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_INDEX__STATE = INDEX_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_INDEX__EQUIVALENCE = INDEX_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_INDEX__CONFLICT = INDEX_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_INDEX__TARGET = INDEX_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Index</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UPDATE_INDEX__INDEX = INDEX_CHANGE__INDEX;

	/**
	 * The feature id for the '<em><b>New Index</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_INDEX__NEW_INDEX = INDEX_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Update Index</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_INDEX_FEATURE_COUNT = INDEX_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.ForeignKeyChangeImpl <em>Foreign Key Change</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.ForeignKeyChangeImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getForeignKeyChange()
	 * @generated
	 */
	int FOREIGN_KEY_CHANGE = 21;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY_CHANGE__MATCH = DB_DIFF__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY_CHANGE__REQUIRES = DB_DIFF__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY_CHANGE__REQUIRED_BY = DB_DIFF__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY_CHANGE__IMPLIES = DB_DIFF__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY_CHANGE__IMPLIED_BY = DB_DIFF__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY_CHANGE__REFINES = DB_DIFF__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY_CHANGE__REFINED_BY = DB_DIFF__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY_CHANGE__PRIME_REFINING = DB_DIFF__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY_CHANGE__KIND = DB_DIFF__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY_CHANGE__SOURCE = DB_DIFF__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY_CHANGE__STATE = DB_DIFF__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY_CHANGE__EQUIVALENCE = DB_DIFF__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY_CHANGE__CONFLICT = DB_DIFF__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY_CHANGE__TARGET = DB_DIFF__TARGET;

	/**
	 * The feature id for the '<em><b>Foreign Key</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY_CHANGE__FOREIGN_KEY = DB_DIFF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Foreign Key Change</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY_CHANGE_FEATURE_COUNT = DB_DIFF_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.AddForeignKeyImpl <em>Add Foreign Key</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.AddForeignKeyImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getAddForeignKey()
	 * @generated
	 */
	int ADD_FOREIGN_KEY = 22;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FOREIGN_KEY__MATCH = FOREIGN_KEY_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FOREIGN_KEY__REQUIRES = FOREIGN_KEY_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FOREIGN_KEY__REQUIRED_BY = FOREIGN_KEY_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FOREIGN_KEY__IMPLIES = FOREIGN_KEY_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FOREIGN_KEY__IMPLIED_BY = FOREIGN_KEY_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FOREIGN_KEY__REFINES = FOREIGN_KEY_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FOREIGN_KEY__REFINED_BY = FOREIGN_KEY_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FOREIGN_KEY__PRIME_REFINING = FOREIGN_KEY_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADD_FOREIGN_KEY__KIND = FOREIGN_KEY_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FOREIGN_KEY__SOURCE = FOREIGN_KEY_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FOREIGN_KEY__STATE = FOREIGN_KEY_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FOREIGN_KEY__EQUIVALENCE = FOREIGN_KEY_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FOREIGN_KEY__CONFLICT = FOREIGN_KEY_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FOREIGN_KEY__TARGET = FOREIGN_KEY_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Foreign Key</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADD_FOREIGN_KEY__FOREIGN_KEY = FOREIGN_KEY_CHANGE__FOREIGN_KEY;

	/**
	 * The number of structural features of the '<em>Add Foreign Key</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FOREIGN_KEY_FEATURE_COUNT = FOREIGN_KEY_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.RemoveForeignKeyImpl <em>Remove Foreign Key</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.RemoveForeignKeyImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getRemoveForeignKey()
	 * @generated
	 */
	int REMOVE_FOREIGN_KEY = 23;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_FOREIGN_KEY__MATCH = FOREIGN_KEY_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_FOREIGN_KEY__REQUIRES = FOREIGN_KEY_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_FOREIGN_KEY__REQUIRED_BY = FOREIGN_KEY_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_FOREIGN_KEY__IMPLIES = FOREIGN_KEY_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_FOREIGN_KEY__IMPLIED_BY = FOREIGN_KEY_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_FOREIGN_KEY__REFINES = FOREIGN_KEY_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_FOREIGN_KEY__REFINED_BY = FOREIGN_KEY_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_FOREIGN_KEY__PRIME_REFINING = FOREIGN_KEY_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REMOVE_FOREIGN_KEY__KIND = FOREIGN_KEY_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_FOREIGN_KEY__SOURCE = FOREIGN_KEY_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_FOREIGN_KEY__STATE = FOREIGN_KEY_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_FOREIGN_KEY__EQUIVALENCE = FOREIGN_KEY_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_FOREIGN_KEY__CONFLICT = FOREIGN_KEY_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_FOREIGN_KEY__TARGET = FOREIGN_KEY_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Foreign Key</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REMOVE_FOREIGN_KEY__FOREIGN_KEY = FOREIGN_KEY_CHANGE__FOREIGN_KEY;

	/**
	 * The number of structural features of the '<em>Remove Foreign Key</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_FOREIGN_KEY_FEATURE_COUNT = FOREIGN_KEY_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.UpdateForeignKeyImpl <em>Update Foreign Key</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.UpdateForeignKeyImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getUpdateForeignKey()
	 * @generated
	 */
	int UPDATE_FOREIGN_KEY = 24;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_FOREIGN_KEY__MATCH = FOREIGN_KEY_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_FOREIGN_KEY__REQUIRES = FOREIGN_KEY_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_FOREIGN_KEY__REQUIRED_BY = FOREIGN_KEY_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_FOREIGN_KEY__IMPLIES = FOREIGN_KEY_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_FOREIGN_KEY__IMPLIED_BY = FOREIGN_KEY_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_FOREIGN_KEY__REFINES = FOREIGN_KEY_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_FOREIGN_KEY__REFINED_BY = FOREIGN_KEY_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_FOREIGN_KEY__PRIME_REFINING = FOREIGN_KEY_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UPDATE_FOREIGN_KEY__KIND = FOREIGN_KEY_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_FOREIGN_KEY__SOURCE = FOREIGN_KEY_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_FOREIGN_KEY__STATE = FOREIGN_KEY_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_FOREIGN_KEY__EQUIVALENCE = FOREIGN_KEY_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_FOREIGN_KEY__CONFLICT = FOREIGN_KEY_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_FOREIGN_KEY__TARGET = FOREIGN_KEY_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Foreign Key</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UPDATE_FOREIGN_KEY__FOREIGN_KEY = FOREIGN_KEY_CHANGE__FOREIGN_KEY;

	/**
	 * The feature id for the '<em><b>New Foreign Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_FOREIGN_KEY__NEW_FOREIGN_KEY = FOREIGN_KEY_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Update Foreign Key</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_FOREIGN_KEY_FEATURE_COUNT = FOREIGN_KEY_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.ConstraintChangeImpl <em>Constraint Change</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.ConstraintChangeImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getConstraintChange()
	 * @generated
	 */
	int CONSTRAINT_CHANGE = 25;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CHANGE__MATCH = DB_DIFF__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CHANGE__REQUIRES = DB_DIFF__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CHANGE__REQUIRED_BY = DB_DIFF__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CHANGE__IMPLIES = DB_DIFF__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CHANGE__IMPLIED_BY = DB_DIFF__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CHANGE__REFINES = DB_DIFF__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CHANGE__REFINED_BY = DB_DIFF__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CHANGE__PRIME_REFINING = DB_DIFF__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CHANGE__KIND = DB_DIFF__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CHANGE__SOURCE = DB_DIFF__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CHANGE__STATE = DB_DIFF__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CHANGE__EQUIVALENCE = DB_DIFF__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CHANGE__CONFLICT = DB_DIFF__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CHANGE__TARGET = DB_DIFF__TARGET;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CHANGE__CONSTRAINT = DB_DIFF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constraint Change</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CHANGE_FEATURE_COUNT = DB_DIFF_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.AddConstraintImpl <em>Add Constraint</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.AddConstraintImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getAddConstraint()
	 * @generated
	 */
	int ADD_CONSTRAINT = 26;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_CONSTRAINT__MATCH = CONSTRAINT_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_CONSTRAINT__REQUIRES = CONSTRAINT_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_CONSTRAINT__REQUIRED_BY = CONSTRAINT_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_CONSTRAINT__IMPLIES = CONSTRAINT_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_CONSTRAINT__IMPLIED_BY = CONSTRAINT_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_CONSTRAINT__REFINES = CONSTRAINT_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_CONSTRAINT__REFINED_BY = CONSTRAINT_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_CONSTRAINT__PRIME_REFINING = CONSTRAINT_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADD_CONSTRAINT__KIND = CONSTRAINT_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_CONSTRAINT__SOURCE = CONSTRAINT_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_CONSTRAINT__STATE = CONSTRAINT_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_CONSTRAINT__EQUIVALENCE = CONSTRAINT_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_CONSTRAINT__CONFLICT = CONSTRAINT_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_CONSTRAINT__TARGET = CONSTRAINT_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADD_CONSTRAINT__CONSTRAINT = CONSTRAINT_CHANGE__CONSTRAINT;

	/**
	 * The number of structural features of the '<em>Add Constraint</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.RemoveConstraintImpl <em>Remove Constraint</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.RemoveConstraintImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getRemoveConstraint()
	 * @generated
	 */
	int REMOVE_CONSTRAINT = 27;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_CONSTRAINT__MATCH = CONSTRAINT_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_CONSTRAINT__REQUIRES = CONSTRAINT_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_CONSTRAINT__REQUIRED_BY = CONSTRAINT_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_CONSTRAINT__IMPLIES = CONSTRAINT_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_CONSTRAINT__IMPLIED_BY = CONSTRAINT_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_CONSTRAINT__REFINES = CONSTRAINT_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_CONSTRAINT__REFINED_BY = CONSTRAINT_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_CONSTRAINT__PRIME_REFINING = CONSTRAINT_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REMOVE_CONSTRAINT__KIND = CONSTRAINT_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_CONSTRAINT__SOURCE = CONSTRAINT_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_CONSTRAINT__STATE = CONSTRAINT_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_CONSTRAINT__EQUIVALENCE = CONSTRAINT_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_CONSTRAINT__CONFLICT = CONSTRAINT_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_CONSTRAINT__TARGET = CONSTRAINT_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REMOVE_CONSTRAINT__CONSTRAINT = CONSTRAINT_CHANGE__CONSTRAINT;

	/**
	 * The number of structural features of the '<em>Remove Constraint</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.UpdateConstraintImpl <em>Update Constraint</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.UpdateConstraintImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getUpdateConstraint()
	 * @generated
	 */
	int UPDATE_CONSTRAINT = 28;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__MATCH = CONSTRAINT_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__REQUIRES = CONSTRAINT_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__REQUIRED_BY = CONSTRAINT_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__IMPLIES = CONSTRAINT_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__IMPLIED_BY = CONSTRAINT_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__REFINES = CONSTRAINT_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__REFINED_BY = CONSTRAINT_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__PRIME_REFINING = CONSTRAINT_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__KIND = CONSTRAINT_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__SOURCE = CONSTRAINT_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__STATE = CONSTRAINT_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__EQUIVALENCE = CONSTRAINT_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__CONFLICT = CONSTRAINT_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__TARGET = CONSTRAINT_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__CONSTRAINT = CONSTRAINT_CHANGE__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>New Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__NEW_CONSTRAINT = CONSTRAINT_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Update Constraint</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.SequenceChangeImpl <em>Sequence Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.SequenceChangeImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getSequenceChange()
	 * @generated
	 */
	int SEQUENCE_CHANGE = 29;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_CHANGE__MATCH = DB_DIFF__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_CHANGE__REQUIRES = DB_DIFF__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_CHANGE__REQUIRED_BY = DB_DIFF__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_CHANGE__IMPLIES = DB_DIFF__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_CHANGE__IMPLIED_BY = DB_DIFF__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_CHANGE__REFINES = DB_DIFF__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_CHANGE__REFINED_BY = DB_DIFF__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_CHANGE__PRIME_REFINING = DB_DIFF__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_CHANGE__KIND = DB_DIFF__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_CHANGE__SOURCE = DB_DIFF__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_CHANGE__STATE = DB_DIFF__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_CHANGE__EQUIVALENCE = DB_DIFF__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_CHANGE__CONFLICT = DB_DIFF__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_CHANGE__TARGET = DB_DIFF__TARGET;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_CHANGE__SEQUENCE = DB_DIFF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sequence Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_CHANGE_FEATURE_COUNT = DB_DIFF_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.AddSequenceImpl <em>Add Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.AddSequenceImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getAddSequence()
	 * @generated
	 */
	int ADD_SEQUENCE = 30;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SEQUENCE__MATCH = SEQUENCE_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SEQUENCE__REQUIRES = SEQUENCE_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SEQUENCE__REQUIRED_BY = SEQUENCE_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SEQUENCE__IMPLIES = SEQUENCE_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SEQUENCE__IMPLIED_BY = SEQUENCE_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SEQUENCE__REFINES = SEQUENCE_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SEQUENCE__REFINED_BY = SEQUENCE_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SEQUENCE__PRIME_REFINING = SEQUENCE_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SEQUENCE__KIND = SEQUENCE_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SEQUENCE__SOURCE = SEQUENCE_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SEQUENCE__STATE = SEQUENCE_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SEQUENCE__EQUIVALENCE = SEQUENCE_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SEQUENCE__CONFLICT = SEQUENCE_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SEQUENCE__TARGET = SEQUENCE_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SEQUENCE__SEQUENCE = SEQUENCE_CHANGE__SEQUENCE;

	/**
	 * The number of structural features of the '<em>Add Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SEQUENCE_FEATURE_COUNT = SEQUENCE_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.RemoveSequenceImpl <em>Remove Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.RemoveSequenceImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getRemoveSequence()
	 * @generated
	 */
	int REMOVE_SEQUENCE = 31;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SEQUENCE__MATCH = SEQUENCE_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SEQUENCE__REQUIRES = SEQUENCE_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SEQUENCE__REQUIRED_BY = SEQUENCE_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SEQUENCE__IMPLIES = SEQUENCE_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SEQUENCE__IMPLIED_BY = SEQUENCE_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SEQUENCE__REFINES = SEQUENCE_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SEQUENCE__REFINED_BY = SEQUENCE_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SEQUENCE__PRIME_REFINING = SEQUENCE_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SEQUENCE__KIND = SEQUENCE_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SEQUENCE__SOURCE = SEQUENCE_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SEQUENCE__STATE = SEQUENCE_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SEQUENCE__EQUIVALENCE = SEQUENCE_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SEQUENCE__CONFLICT = SEQUENCE_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SEQUENCE__TARGET = SEQUENCE_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SEQUENCE__SEQUENCE = SEQUENCE_CHANGE__SEQUENCE;

	/**
	 * The number of structural features of the '<em>Remove Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SEQUENCE_FEATURE_COUNT = SEQUENCE_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.UpdateSequenceImpl <em>Update Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.UpdateSequenceImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getUpdateSequence()
	 * @generated
	 */
	int UPDATE_SEQUENCE = 32;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SEQUENCE__MATCH = SEQUENCE_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SEQUENCE__REQUIRES = SEQUENCE_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SEQUENCE__REQUIRED_BY = SEQUENCE_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SEQUENCE__IMPLIES = SEQUENCE_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SEQUENCE__IMPLIED_BY = SEQUENCE_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SEQUENCE__REFINES = SEQUENCE_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SEQUENCE__REFINED_BY = SEQUENCE_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SEQUENCE__PRIME_REFINING = SEQUENCE_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SEQUENCE__KIND = SEQUENCE_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SEQUENCE__SOURCE = SEQUENCE_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SEQUENCE__STATE = SEQUENCE_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SEQUENCE__EQUIVALENCE = SEQUENCE_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SEQUENCE__CONFLICT = SEQUENCE_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SEQUENCE__TARGET = SEQUENCE_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SEQUENCE__SEQUENCE = SEQUENCE_CHANGE__SEQUENCE;

	/**
	 * The feature id for the '<em><b>New Sequence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SEQUENCE__NEW_SEQUENCE = SEQUENCE_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Update Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SEQUENCE_FEATURE_COUNT = SEQUENCE_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.SchemaChangeImpl <em>Schema Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.SchemaChangeImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getSchemaChange()
	 * @generated
	 */
	int SCHEMA_CHANGE = 33;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_CHANGE__MATCH = DB_DIFF__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_CHANGE__REQUIRES = DB_DIFF__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_CHANGE__REQUIRED_BY = DB_DIFF__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_CHANGE__IMPLIES = DB_DIFF__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_CHANGE__IMPLIED_BY = DB_DIFF__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_CHANGE__REFINES = DB_DIFF__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_CHANGE__REFINED_BY = DB_DIFF__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_CHANGE__PRIME_REFINING = DB_DIFF__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_CHANGE__KIND = DB_DIFF__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_CHANGE__SOURCE = DB_DIFF__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_CHANGE__STATE = DB_DIFF__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_CHANGE__EQUIVALENCE = DB_DIFF__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_CHANGE__CONFLICT = DB_DIFF__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_CHANGE__TARGET = DB_DIFF__TARGET;

	/**
	 * The feature id for the '<em><b>Schema</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_CHANGE__SCHEMA = DB_DIFF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Schema Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_CHANGE_FEATURE_COUNT = DB_DIFF_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.AddSchemaImpl <em>Add Schema</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.AddSchemaImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getAddSchema()
	 * @generated
	 */
	int ADD_SCHEMA = 34;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SCHEMA__MATCH = SCHEMA_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SCHEMA__REQUIRES = SCHEMA_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SCHEMA__REQUIRED_BY = SCHEMA_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SCHEMA__IMPLIES = SCHEMA_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SCHEMA__IMPLIED_BY = SCHEMA_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SCHEMA__REFINES = SCHEMA_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SCHEMA__REFINED_BY = SCHEMA_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SCHEMA__PRIME_REFINING = SCHEMA_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SCHEMA__KIND = SCHEMA_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SCHEMA__SOURCE = SCHEMA_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SCHEMA__STATE = SCHEMA_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SCHEMA__EQUIVALENCE = SCHEMA_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SCHEMA__CONFLICT = SCHEMA_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SCHEMA__TARGET = SCHEMA_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Schema</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SCHEMA__SCHEMA = SCHEMA_CHANGE__SCHEMA;

	/**
	 * The number of structural features of the '<em>Add Schema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_SCHEMA_FEATURE_COUNT = SCHEMA_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.RemoveSchemaImpl <em>Remove Schema</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.RemoveSchemaImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getRemoveSchema()
	 * @generated
	 */
	int REMOVE_SCHEMA = 35;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SCHEMA__MATCH = SCHEMA_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SCHEMA__REQUIRES = SCHEMA_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SCHEMA__REQUIRED_BY = SCHEMA_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SCHEMA__IMPLIES = SCHEMA_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SCHEMA__IMPLIED_BY = SCHEMA_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SCHEMA__REFINES = SCHEMA_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SCHEMA__REFINED_BY = SCHEMA_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SCHEMA__PRIME_REFINING = SCHEMA_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SCHEMA__KIND = SCHEMA_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SCHEMA__SOURCE = SCHEMA_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SCHEMA__STATE = SCHEMA_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SCHEMA__EQUIVALENCE = SCHEMA_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SCHEMA__CONFLICT = SCHEMA_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SCHEMA__TARGET = SCHEMA_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Schema</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SCHEMA__SCHEMA = SCHEMA_CHANGE__SCHEMA;

	/**
	 * The number of structural features of the '<em>Remove Schema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SCHEMA_FEATURE_COUNT = SCHEMA_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.AlterSchemaImpl <em>Alter Schema</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.AlterSchemaImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getAlterSchema()
	 * @generated
	 */
	int ALTER_SCHEMA = 36;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_SCHEMA__MATCH = SCHEMA_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_SCHEMA__REQUIRES = SCHEMA_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_SCHEMA__REQUIRED_BY = SCHEMA_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_SCHEMA__IMPLIES = SCHEMA_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_SCHEMA__IMPLIED_BY = SCHEMA_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_SCHEMA__REFINES = SCHEMA_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_SCHEMA__REFINED_BY = SCHEMA_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_SCHEMA__PRIME_REFINING = SCHEMA_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_SCHEMA__KIND = SCHEMA_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_SCHEMA__SOURCE = SCHEMA_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_SCHEMA__STATE = SCHEMA_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_SCHEMA__EQUIVALENCE = SCHEMA_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_SCHEMA__CONFLICT = SCHEMA_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_SCHEMA__TARGET = SCHEMA_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Schema</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_SCHEMA__SCHEMA = SCHEMA_CHANGE__SCHEMA;

	/**
	 * The number of structural features of the '<em>Alter Schema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_SCHEMA_FEATURE_COUNT = SCHEMA_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.RenameSchemaChangeImpl <em>Rename Schema Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.RenameSchemaChangeImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getRenameSchemaChange()
	 * @generated
	 */
	int RENAME_SCHEMA_CHANGE = 37;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_SCHEMA_CHANGE__MATCH = SCHEMA_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_SCHEMA_CHANGE__REQUIRES = SCHEMA_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_SCHEMA_CHANGE__REQUIRED_BY = SCHEMA_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_SCHEMA_CHANGE__IMPLIES = SCHEMA_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_SCHEMA_CHANGE__IMPLIED_BY = SCHEMA_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_SCHEMA_CHANGE__REFINES = SCHEMA_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_SCHEMA_CHANGE__REFINED_BY = SCHEMA_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_SCHEMA_CHANGE__PRIME_REFINING = SCHEMA_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_SCHEMA_CHANGE__KIND = SCHEMA_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_SCHEMA_CHANGE__SOURCE = SCHEMA_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_SCHEMA_CHANGE__STATE = SCHEMA_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_SCHEMA_CHANGE__EQUIVALENCE = SCHEMA_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_SCHEMA_CHANGE__CONFLICT = SCHEMA_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_SCHEMA_CHANGE__TARGET = SCHEMA_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Schema</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_SCHEMA_CHANGE__SCHEMA = SCHEMA_CHANGE__SCHEMA;

	/**
	 * The feature id for the '<em><b>New Schema</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_SCHEMA_CHANGE__NEW_SCHEMA = SCHEMA_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rename Schema Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_SCHEMA_CHANGE_FEATURE_COUNT = SCHEMA_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.UpdateSchemaCommentChangeImpl <em>Update Schema Comment Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.UpdateSchemaCommentChangeImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getUpdateSchemaCommentChange()
	 * @generated
	 */
	int UPDATE_SCHEMA_COMMENT_CHANGE = 38;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SCHEMA_COMMENT_CHANGE__MATCH = SCHEMA_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SCHEMA_COMMENT_CHANGE__REQUIRES = SCHEMA_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SCHEMA_COMMENT_CHANGE__REQUIRED_BY = SCHEMA_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SCHEMA_COMMENT_CHANGE__IMPLIES = SCHEMA_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SCHEMA_COMMENT_CHANGE__IMPLIED_BY = SCHEMA_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SCHEMA_COMMENT_CHANGE__REFINES = SCHEMA_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SCHEMA_COMMENT_CHANGE__REFINED_BY = SCHEMA_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SCHEMA_COMMENT_CHANGE__PRIME_REFINING = SCHEMA_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SCHEMA_COMMENT_CHANGE__KIND = SCHEMA_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SCHEMA_COMMENT_CHANGE__SOURCE = SCHEMA_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SCHEMA_COMMENT_CHANGE__STATE = SCHEMA_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SCHEMA_COMMENT_CHANGE__EQUIVALENCE = SCHEMA_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SCHEMA_COMMENT_CHANGE__CONFLICT = SCHEMA_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SCHEMA_COMMENT_CHANGE__TARGET = SCHEMA_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>Schema</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SCHEMA_COMMENT_CHANGE__SCHEMA = SCHEMA_CHANGE__SCHEMA;

	/**
	 * The feature id for the '<em><b>New Schema</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SCHEMA_COMMENT_CHANGE__NEW_SCHEMA = SCHEMA_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Update Schema Comment Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SCHEMA_COMMENT_CHANGE_FEATURE_COUNT = SCHEMA_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.ViewChangeImpl <em>View Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.ViewChangeImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getViewChange()
	 * @generated
	 */
	int VIEW_CHANGE = 40;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CHANGE__MATCH = DB_DIFF__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CHANGE__REQUIRES = DB_DIFF__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CHANGE__REQUIRED_BY = DB_DIFF__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CHANGE__IMPLIES = DB_DIFF__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CHANGE__IMPLIED_BY = DB_DIFF__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CHANGE__REFINES = DB_DIFF__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CHANGE__REFINED_BY = DB_DIFF__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CHANGE__PRIME_REFINING = DB_DIFF__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CHANGE__KIND = DB_DIFF__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CHANGE__SOURCE = DB_DIFF__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CHANGE__STATE = DB_DIFF__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CHANGE__EQUIVALENCE = DB_DIFF__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CHANGE__CONFLICT = DB_DIFF__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CHANGE__TARGET = DB_DIFF__TARGET;

	/**
	 * The feature id for the '<em><b>View</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CHANGE__VIEW = DB_DIFF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>View Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_CHANGE_FEATURE_COUNT = DB_DIFF_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.AddViewImpl <em>Add View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.AddViewImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getAddView()
	 * @generated
	 */
	int ADD_VIEW = 41;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_VIEW__MATCH = VIEW_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_VIEW__REQUIRES = VIEW_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_VIEW__REQUIRED_BY = VIEW_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_VIEW__IMPLIES = VIEW_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_VIEW__IMPLIED_BY = VIEW_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_VIEW__REFINES = VIEW_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_VIEW__REFINED_BY = VIEW_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_VIEW__PRIME_REFINING = VIEW_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_VIEW__KIND = VIEW_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_VIEW__SOURCE = VIEW_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_VIEW__STATE = VIEW_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_VIEW__EQUIVALENCE = VIEW_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_VIEW__CONFLICT = VIEW_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_VIEW__TARGET = VIEW_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>View</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_VIEW__VIEW = VIEW_CHANGE__VIEW;

	/**
	 * The number of structural features of the '<em>Add View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_VIEW_FEATURE_COUNT = VIEW_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.RemoveViewImpl <em>Remove View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.RemoveViewImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getRemoveView()
	 * @generated
	 */
	int REMOVE_VIEW = 42;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_VIEW__MATCH = VIEW_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_VIEW__REQUIRES = VIEW_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_VIEW__REQUIRED_BY = VIEW_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_VIEW__IMPLIES = VIEW_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_VIEW__IMPLIED_BY = VIEW_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_VIEW__REFINES = VIEW_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_VIEW__REFINED_BY = VIEW_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_VIEW__PRIME_REFINING = VIEW_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_VIEW__KIND = VIEW_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_VIEW__SOURCE = VIEW_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_VIEW__STATE = VIEW_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_VIEW__EQUIVALENCE = VIEW_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_VIEW__CONFLICT = VIEW_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_VIEW__TARGET = VIEW_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>View</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_VIEW__VIEW = VIEW_CHANGE__VIEW;

	/**
	 * The number of structural features of the '<em>Remove View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_VIEW_FEATURE_COUNT = VIEW_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.AlterViewImpl <em>Alter View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.AlterViewImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getAlterView()
	 * @generated
	 */
	int ALTER_VIEW = 43;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_VIEW__MATCH = VIEW_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_VIEW__REQUIRES = VIEW_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_VIEW__REQUIRED_BY = VIEW_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_VIEW__IMPLIES = VIEW_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_VIEW__IMPLIED_BY = VIEW_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_VIEW__REFINES = VIEW_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_VIEW__REFINED_BY = VIEW_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_VIEW__PRIME_REFINING = VIEW_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_VIEW__KIND = VIEW_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_VIEW__SOURCE = VIEW_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_VIEW__STATE = VIEW_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_VIEW__EQUIVALENCE = VIEW_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_VIEW__CONFLICT = VIEW_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_VIEW__TARGET = VIEW_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>View</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_VIEW__VIEW = VIEW_CHANGE__VIEW;

	/**
	 * The number of structural features of the '<em>Alter View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTER_VIEW_FEATURE_COUNT = VIEW_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.RenameViewChangeImpl <em>Rename View Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.RenameViewChangeImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getRenameViewChange()
	 * @generated
	 */
	int RENAME_VIEW_CHANGE = 44;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_VIEW_CHANGE__MATCH = VIEW_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_VIEW_CHANGE__REQUIRES = VIEW_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_VIEW_CHANGE__REQUIRED_BY = VIEW_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_VIEW_CHANGE__IMPLIES = VIEW_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_VIEW_CHANGE__IMPLIED_BY = VIEW_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_VIEW_CHANGE__REFINES = VIEW_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_VIEW_CHANGE__REFINED_BY = VIEW_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_VIEW_CHANGE__PRIME_REFINING = VIEW_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_VIEW_CHANGE__KIND = VIEW_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_VIEW_CHANGE__SOURCE = VIEW_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_VIEW_CHANGE__STATE = VIEW_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_VIEW_CHANGE__EQUIVALENCE = VIEW_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_VIEW_CHANGE__CONFLICT = VIEW_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_VIEW_CHANGE__TARGET = VIEW_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>View</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_VIEW_CHANGE__VIEW = VIEW_CHANGE__VIEW;

	/**
	 * The feature id for the '<em><b>New View</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_VIEW_CHANGE__NEW_VIEW = VIEW_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rename View Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_VIEW_CHANGE_FEATURE_COUNT = VIEW_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.UpdateViewCommentChangeImpl <em>Update View Comment Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.UpdateViewCommentChangeImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getUpdateViewCommentChange()
	 * @generated
	 */
	int UPDATE_VIEW_COMMENT_CHANGE = 45;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_COMMENT_CHANGE__MATCH = VIEW_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_COMMENT_CHANGE__REQUIRES = VIEW_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_COMMENT_CHANGE__REQUIRED_BY = VIEW_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_COMMENT_CHANGE__IMPLIES = VIEW_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_COMMENT_CHANGE__IMPLIED_BY = VIEW_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_COMMENT_CHANGE__REFINES = VIEW_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_COMMENT_CHANGE__REFINED_BY = VIEW_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_COMMENT_CHANGE__PRIME_REFINING = VIEW_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_COMMENT_CHANGE__KIND = VIEW_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_COMMENT_CHANGE__SOURCE = VIEW_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_COMMENT_CHANGE__STATE = VIEW_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_COMMENT_CHANGE__EQUIVALENCE = VIEW_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_COMMENT_CHANGE__CONFLICT = VIEW_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_COMMENT_CHANGE__TARGET = VIEW_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>View</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_COMMENT_CHANGE__VIEW = VIEW_CHANGE__VIEW;

	/**
	 * The feature id for the '<em><b>New View</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_COMMENT_CHANGE__NEW_VIEW = VIEW_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Update View Comment Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_COMMENT_CHANGE_FEATURE_COUNT = VIEW_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.UpdateViewQueryChangeImpl <em>Update View Query Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.UpdateViewQueryChangeImpl
	 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getUpdateViewQueryChange()
	 * @generated
	 */
	int UPDATE_VIEW_QUERY_CHANGE = 46;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_QUERY_CHANGE__MATCH = VIEW_CHANGE__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_QUERY_CHANGE__REQUIRES = VIEW_CHANGE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_QUERY_CHANGE__REQUIRED_BY = VIEW_CHANGE__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_QUERY_CHANGE__IMPLIES = VIEW_CHANGE__IMPLIES;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_QUERY_CHANGE__IMPLIED_BY = VIEW_CHANGE__IMPLIED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_QUERY_CHANGE__REFINES = VIEW_CHANGE__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_QUERY_CHANGE__REFINED_BY = VIEW_CHANGE__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Prime Refining</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_QUERY_CHANGE__PRIME_REFINING = VIEW_CHANGE__PRIME_REFINING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_QUERY_CHANGE__KIND = VIEW_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_QUERY_CHANGE__SOURCE = VIEW_CHANGE__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_QUERY_CHANGE__STATE = VIEW_CHANGE__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_QUERY_CHANGE__EQUIVALENCE = VIEW_CHANGE__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_QUERY_CHANGE__CONFLICT = VIEW_CHANGE__CONFLICT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_QUERY_CHANGE__TARGET = VIEW_CHANGE__TARGET;

	/**
	 * The feature id for the '<em><b>View</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_QUERY_CHANGE__VIEW = VIEW_CHANGE__VIEW;

	/**
	 * The feature id for the '<em><b>New View</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_QUERY_CHANGE__NEW_VIEW = VIEW_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Update View Query Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_VIEW_QUERY_CHANGE_FEATURE_COUNT = VIEW_CHANGE_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.AddTable <em>Add Table</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Table</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.AddTable
	 * @generated
	 */
	EClass getAddTable();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.RemoveTable <em>Remove Table</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove Table</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.RemoveTable
	 * @generated
	 */
	EClass getRemoveTable();

	/**
	 * Returns the meta object for class '
	 * {@link org.obeonetwork.dsl.database.dbevolution.DatabaseChangeSet
	 * <em>Database Change Set</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Database Change Set</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.DatabaseChangeSet
	 * @generated
	 */
	EClass getDatabaseChangeSet();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.TableChange <em>Table Change</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table Change</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.TableChange
	 * @generated
	 */
	EClass getTableChange();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.database.dbevolution.TableChange#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.TableChange#getTable()
	 * @see #getTableChange()
	 * @generated
	 */
	EReference getTableChange_Table();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.AlterTable <em>Alter Table</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alter Table</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.AlterTable
	 * @generated
	 */
	EClass getAlterTable();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.RenameTableChange <em>Rename Table Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rename Table Change</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.RenameTableChange
	 * @generated
	 */
	EClass getRenameTableChange();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.database.dbevolution.RenameTableChange#getNewTable <em>New Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>New Table</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.RenameTableChange#getNewTable()
	 * @see #getRenameTableChange()
	 * @generated
	 */
	EReference getRenameTableChange_NewTable();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.ColumnChange <em>Column Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Column Change</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.ColumnChange
	 * @generated
	 */
	EClass getColumnChange();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.database.dbevolution.ColumnChange#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Column</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.ColumnChange#getColumn()
	 * @see #getColumnChange()
	 * @generated
	 */
	EReference getColumnChange_Column();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.AddColumnChange <em>Add Column Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Column Change</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.AddColumnChange
	 * @generated
	 */
	EClass getAddColumnChange();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.RemoveColumnChange <em>Remove Column Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove Column Change</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.RemoveColumnChange
	 * @generated
	 */
	EClass getRemoveColumnChange();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.RenameColumnChange <em>Rename Column Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rename Column Change</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.RenameColumnChange
	 * @generated
	 */
	EClass getRenameColumnChange();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.database.dbevolution.RenameColumnChange#getNewColumn <em>New Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>New Column</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.RenameColumnChange#getNewColumn()
	 * @see #getRenameColumnChange()
	 * @generated
	 */
	EReference getRenameColumnChange_NewColumn();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.UpdateColumnChange <em>Update Column Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Update Column Change</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateColumnChange
	 * @generated
	 */
	EClass getUpdateColumnChange();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.UpdateColumnCommentChange <em>Update Column Comment Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Update Column Comment Change</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateColumnCommentChange
	 * @generated
	 */
	EClass getUpdateColumnCommentChange();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.UpdateTableCommentChange <em>Update Table Comment Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Update Table Comment Change</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateTableCommentChange
	 * @generated
	 */
	EClass getUpdateTableCommentChange();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.database.dbevolution.UpdateTableCommentChange#getNewTable <em>New Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>New Table</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateTableCommentChange#getNewTable()
	 * @see #getUpdateTableCommentChange()
	 * @generated
	 */
	EReference getUpdateTableCommentChange_NewTable();

	/**
	 * Returns the meta object for class '
	 * {@link org.obeonetwork.dsl.database.dbevolution.PrimaryKeyChange
	 * <em>Primary Key Change</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Primary Key Change</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.PrimaryKeyChange
	 * @generated
	 */
	EClass getPrimaryKeyChange();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.database.dbevolution.PrimaryKeyChange#getPrimaryKey <em>Primary Key</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Primary Key</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.PrimaryKeyChange#getPrimaryKey()
	 * @see #getPrimaryKeyChange()
	 * @generated
	 */
	EReference getPrimaryKeyChange_PrimaryKey();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.AddPrimaryKey <em>Add Primary Key</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Primary Key</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.AddPrimaryKey
	 * @generated
	 */
	EClass getAddPrimaryKey();

	/**
	 * Returns the meta object for class '
	 * {@link org.obeonetwork.dsl.database.dbevolution.RemovePrimaryKey
	 * <em>Remove Primary Key</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Remove Primary Key</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.RemovePrimaryKey
	 * @generated
	 */
	EClass getRemovePrimaryKey();

	/**
	 * Returns the meta object for class '
	 * {@link org.obeonetwork.dsl.database.dbevolution.UpdatePrimaryKey
	 * <em>Update Primary Key</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Update Primary Key</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdatePrimaryKey
	 * @generated
	 */
	EClass getUpdatePrimaryKey();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.database.dbevolution.UpdatePrimaryKey#getNewPrimaryKey <em>New Primary Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>New Primary Key</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdatePrimaryKey#getNewPrimaryKey()
	 * @see #getUpdatePrimaryKey()
	 * @generated
	 */
	EReference getUpdatePrimaryKey_NewPrimaryKey();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.IndexChange <em>Index Change</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Index Change</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.IndexChange
	 * @generated
	 */
	EClass getIndexChange();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.database.dbevolution.IndexChange#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Index</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.IndexChange#getIndex()
	 * @see #getIndexChange()
	 * @generated
	 */
	EReference getIndexChange_Index();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.AddIndex <em>Add Index</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Index</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.AddIndex
	 * @generated
	 */
	EClass getAddIndex();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.RemoveIndex <em>Remove Index</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove Index</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.RemoveIndex
	 * @generated
	 */
	EClass getRemoveIndex();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.UpdateIndex <em>Update Index</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Update Index</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateIndex
	 * @generated
	 */
	EClass getUpdateIndex();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.database.dbevolution.UpdateIndex#getNewIndex <em>New Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>New Index</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateIndex#getNewIndex()
	 * @see #getUpdateIndex()
	 * @generated
	 */
	EReference getUpdateIndex_NewIndex();

	/**
	 * Returns the meta object for class '
	 * {@link org.obeonetwork.dsl.database.dbevolution.ForeignKeyChange
	 * <em>Foreign Key Change</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Foreign Key Change</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.ForeignKeyChange
	 * @generated
	 */
	EClass getForeignKeyChange();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.database.dbevolution.ForeignKeyChange#getForeignKey <em>Foreign Key</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Foreign Key</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.ForeignKeyChange#getForeignKey()
	 * @see #getForeignKeyChange()
	 * @generated
	 */
	EReference getForeignKeyChange_ForeignKey();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.AddForeignKey <em>Add Foreign Key</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Foreign Key</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.AddForeignKey
	 * @generated
	 */
	EClass getAddForeignKey();

	/**
	 * Returns the meta object for class '
	 * {@link org.obeonetwork.dsl.database.dbevolution.RemoveForeignKey
	 * <em>Remove Foreign Key</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Remove Foreign Key</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.RemoveForeignKey
	 * @generated
	 */
	EClass getRemoveForeignKey();

	/**
	 * Returns the meta object for class '
	 * {@link org.obeonetwork.dsl.database.dbevolution.UpdateForeignKey
	 * <em>Update Foreign Key</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Update Foreign Key</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateForeignKey
	 * @generated
	 */
	EClass getUpdateForeignKey();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.database.dbevolution.UpdateForeignKey#getNewForeignKey <em>New Foreign Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>New Foreign Key</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateForeignKey#getNewForeignKey()
	 * @see #getUpdateForeignKey()
	 * @generated
	 */
	EReference getUpdateForeignKey_NewForeignKey();

	/**
	 * Returns the meta object for class '
	 * {@link org.obeonetwork.dsl.database.dbevolution.ConstraintChange
	 * <em>Constraint Change</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Constraint Change</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.ConstraintChange
	 * @generated
	 */
	EClass getConstraintChange();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.database.dbevolution.ConstraintChange#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Constraint</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.ConstraintChange#getConstraint()
	 * @see #getConstraintChange()
	 * @generated
	 */
	EReference getConstraintChange_Constraint();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.AddConstraint <em>Add Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Constraint</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.AddConstraint
	 * @generated
	 */
	EClass getAddConstraint();

	/**
	 * Returns the meta object for class '
	 * {@link org.obeonetwork.dsl.database.dbevolution.RemoveConstraint
	 * <em>Remove Constraint</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Remove Constraint</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.RemoveConstraint
	 * @generated
	 */
	EClass getRemoveConstraint();

	/**
	 * Returns the meta object for class '
	 * {@link org.obeonetwork.dsl.database.dbevolution.UpdateConstraint
	 * <em>Update Constraint</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Update Constraint</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateConstraint
	 * @generated
	 */
	EClass getUpdateConstraint();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.database.dbevolution.UpdateConstraint#getNewConstraint <em>New Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>New Constraint</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateConstraint#getNewConstraint()
	 * @see #getUpdateConstraint()
	 * @generated
	 */
	EReference getUpdateConstraint_NewConstraint();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.SequenceChange <em>Sequence Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Change</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.SequenceChange
	 * @generated
	 */
	EClass getSequenceChange();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.database.dbevolution.SequenceChange#getSequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sequence</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.SequenceChange#getSequence()
	 * @see #getSequenceChange()
	 * @generated
	 */
	EReference getSequenceChange_Sequence();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.AddSequence <em>Add Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Sequence</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.AddSequence
	 * @generated
	 */
	EClass getAddSequence();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.RemoveSequence <em>Remove Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove Sequence</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.RemoveSequence
	 * @generated
	 */
	EClass getRemoveSequence();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.UpdateSequence <em>Update Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Update Sequence</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateSequence
	 * @generated
	 */
	EClass getUpdateSequence();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.database.dbevolution.UpdateSequence#getNewSequence <em>New Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>New Sequence</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateSequence#getNewSequence()
	 * @see #getUpdateSequence()
	 * @generated
	 */
	EReference getUpdateSequence_NewSequence();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.SchemaChange <em>Schema Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schema Change</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.SchemaChange
	 * @generated
	 */
	EClass getSchemaChange();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.database.dbevolution.SchemaChange#getSchema <em>Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Schema</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.SchemaChange#getSchema()
	 * @see #getSchemaChange()
	 * @generated
	 */
	EReference getSchemaChange_Schema();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.AddSchema <em>Add Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Schema</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.AddSchema
	 * @generated
	 */
	EClass getAddSchema();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.RemoveSchema <em>Remove Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove Schema</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.RemoveSchema
	 * @generated
	 */
	EClass getRemoveSchema();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.AlterSchema <em>Alter Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alter Schema</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.AlterSchema
	 * @generated
	 */
	EClass getAlterSchema();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.RenameSchemaChange <em>Rename Schema Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rename Schema Change</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.RenameSchemaChange
	 * @generated
	 */
	EClass getRenameSchemaChange();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.database.dbevolution.RenameSchemaChange#getNewSchema <em>New Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>New Schema</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.RenameSchemaChange#getNewSchema()
	 * @see #getRenameSchemaChange()
	 * @generated
	 */
	EReference getRenameSchemaChange_NewSchema();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.UpdateSchemaCommentChange <em>Update Schema Comment Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Update Schema Comment Change</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateSchemaCommentChange
	 * @generated
	 */
	EClass getUpdateSchemaCommentChange();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.database.dbevolution.UpdateSchemaCommentChange#getNewSchema <em>New Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>New Schema</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateSchemaCommentChange#getNewSchema()
	 * @see #getUpdateSchemaCommentChange()
	 * @generated
	 */
	EReference getUpdateSchemaCommentChange_NewSchema();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.DBDiff <em>DB Diff</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB Diff</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.DBDiff
	 * @generated
	 */
	EClass getDBDiff();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.database.dbevolution.DBDiff#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.DBDiff#getTarget()
	 * @see #getDBDiff()
	 * @generated
	 */
	EReference getDBDiff_Target();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.ViewChange <em>View Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View Change</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.ViewChange
	 * @generated
	 */
	EClass getViewChange();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.database.dbevolution.ViewChange#getView <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>View</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.ViewChange#getView()
	 * @see #getViewChange()
	 * @generated
	 */
	EReference getViewChange_View();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.AddView <em>Add View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add View</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.AddView
	 * @generated
	 */
	EClass getAddView();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.RemoveView <em>Remove View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove View</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.RemoveView
	 * @generated
	 */
	EClass getRemoveView();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.AlterView <em>Alter View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alter View</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.AlterView
	 * @generated
	 */
	EClass getAlterView();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.RenameViewChange <em>Rename View Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rename View Change</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.RenameViewChange
	 * @generated
	 */
	EClass getRenameViewChange();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.database.dbevolution.RenameViewChange#getNewView <em>New View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>New View</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.RenameViewChange#getNewView()
	 * @see #getRenameViewChange()
	 * @generated
	 */
	EReference getRenameViewChange_NewView();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.UpdateViewCommentChange <em>Update View Comment Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Update View Comment Change</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateViewCommentChange
	 * @generated
	 */
	EClass getUpdateViewCommentChange();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.database.dbevolution.UpdateViewCommentChange#getNewView <em>New View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>New View</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateViewCommentChange#getNewView()
	 * @see #getUpdateViewCommentChange()
	 * @generated
	 */
	EReference getUpdateViewCommentChange_NewView();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.database.dbevolution.UpdateViewQueryChange <em>Update View Query Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Update View Query Change</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateViewQueryChange
	 * @generated
	 */
	EClass getUpdateViewQueryChange();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.database.dbevolution.UpdateViewQueryChange#getNewView <em>New View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>New View</em>'.
	 * @see org.obeonetwork.dsl.database.dbevolution.UpdateViewQueryChange#getNewView()
	 * @see #getUpdateViewQueryChange()
	 * @generated
	 */
	EReference getUpdateViewQueryChange_NewView();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DbevolutionFactory getDbevolutionFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that
	 * represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '
		 * {@link org.obeonetwork.dsl.database.dbevolution.impl.AddTableImpl
		 * <em>Add Table</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.AddTableImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getAddTable()
		 * @generated
		 */
		EClass ADD_TABLE = eINSTANCE.getAddTable();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.RemoveTableImpl <em>Remove Table</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.RemoveTableImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getRemoveTable()
		 * @generated
		 */
		EClass REMOVE_TABLE = eINSTANCE.getRemoveTable();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.DatabaseChangeSetImpl <em>Database Change Set</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DatabaseChangeSetImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getDatabaseChangeSet()
		 * @generated
		 */
		EClass DATABASE_CHANGE_SET = eINSTANCE.getDatabaseChangeSet();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.TableChangeImpl <em>Table Change</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.TableChangeImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getTableChange()
		 * @generated
		 */
		EClass TABLE_CHANGE = eINSTANCE.getTableChange();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_CHANGE__TABLE = eINSTANCE.getTableChange_Table();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.AlterTableImpl <em>Alter Table</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.AlterTableImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getAlterTable()
		 * @generated
		 */
		EClass ALTER_TABLE = eINSTANCE.getAlterTable();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.RenameTableChangeImpl <em>Rename Table Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.RenameTableChangeImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getRenameTableChange()
		 * @generated
		 */
		EClass RENAME_TABLE_CHANGE = eINSTANCE.getRenameTableChange();

		/**
		 * The meta object literal for the '<em><b>New Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RENAME_TABLE_CHANGE__NEW_TABLE = eINSTANCE.getRenameTableChange_NewTable();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.ColumnChangeImpl <em>Column Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.ColumnChangeImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getColumnChange()
		 * @generated
		 */
		EClass COLUMN_CHANGE = eINSTANCE.getColumnChange();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLUMN_CHANGE__COLUMN = eINSTANCE.getColumnChange_Column();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.AddColumnChangeImpl <em>Add Column Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.AddColumnChangeImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getAddColumnChange()
		 * @generated
		 */
		EClass ADD_COLUMN_CHANGE = eINSTANCE.getAddColumnChange();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.RemoveColumnChangeImpl <em>Remove Column Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.RemoveColumnChangeImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getRemoveColumnChange()
		 * @generated
		 */
		EClass REMOVE_COLUMN_CHANGE = eINSTANCE.getRemoveColumnChange();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.RenameColumnChangeImpl <em>Rename Column Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.RenameColumnChangeImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getRenameColumnChange()
		 * @generated
		 */
		EClass RENAME_COLUMN_CHANGE = eINSTANCE.getRenameColumnChange();

		/**
		 * The meta object literal for the '<em><b>New Column</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RENAME_COLUMN_CHANGE__NEW_COLUMN = eINSTANCE.getRenameColumnChange_NewColumn();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.UpdateColumnChangeImpl <em>Update Column Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.UpdateColumnChangeImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getUpdateColumnChange()
		 * @generated
		 */
		EClass UPDATE_COLUMN_CHANGE = eINSTANCE.getUpdateColumnChange();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.UpdateColumnCommentChangeImpl <em>Update Column Comment Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.UpdateColumnCommentChangeImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getUpdateColumnCommentChange()
		 * @generated
		 */
		EClass UPDATE_COLUMN_COMMENT_CHANGE = eINSTANCE.getUpdateColumnCommentChange();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.UpdateTableCommentChangeImpl <em>Update Table Comment Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.UpdateTableCommentChangeImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getUpdateTableCommentChange()
		 * @generated
		 */
		EClass UPDATE_TABLE_COMMENT_CHANGE = eINSTANCE.getUpdateTableCommentChange();

		/**
		 * The meta object literal for the '<em><b>New Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UPDATE_TABLE_COMMENT_CHANGE__NEW_TABLE = eINSTANCE.getUpdateTableCommentChange_NewTable();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.PrimaryKeyChangeImpl <em>Primary Key Change</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.PrimaryKeyChangeImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getPrimaryKeyChange()
		 * @generated
		 */
		EClass PRIMARY_KEY_CHANGE = eINSTANCE.getPrimaryKeyChange();

		/**
		 * The meta object literal for the '<em><b>Primary Key</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMARY_KEY_CHANGE__PRIMARY_KEY = eINSTANCE.getPrimaryKeyChange_PrimaryKey();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.AddPrimaryKeyImpl <em>Add Primary Key</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.AddPrimaryKeyImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getAddPrimaryKey()
		 * @generated
		 */
		EClass ADD_PRIMARY_KEY = eINSTANCE.getAddPrimaryKey();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.RemovePrimaryKeyImpl <em>Remove Primary Key</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.RemovePrimaryKeyImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getRemovePrimaryKey()
		 * @generated
		 */
		EClass REMOVE_PRIMARY_KEY = eINSTANCE.getRemovePrimaryKey();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.UpdatePrimaryKeyImpl <em>Update Primary Key</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.UpdatePrimaryKeyImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getUpdatePrimaryKey()
		 * @generated
		 */
		EClass UPDATE_PRIMARY_KEY = eINSTANCE.getUpdatePrimaryKey();

		/**
		 * The meta object literal for the '<em><b>New Primary Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UPDATE_PRIMARY_KEY__NEW_PRIMARY_KEY = eINSTANCE.getUpdatePrimaryKey_NewPrimaryKey();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.IndexChangeImpl <em>Index Change</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.IndexChangeImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getIndexChange()
		 * @generated
		 */
		EClass INDEX_CHANGE = eINSTANCE.getIndexChange();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDEX_CHANGE__INDEX = eINSTANCE.getIndexChange_Index();

		/**
		 * The meta object literal for the '
		 * {@link org.obeonetwork.dsl.database.dbevolution.impl.AddIndexImpl
		 * <em>Add Index</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.AddIndexImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getAddIndex()
		 * @generated
		 */
		EClass ADD_INDEX = eINSTANCE.getAddIndex();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.RemoveIndexImpl <em>Remove Index</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.RemoveIndexImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getRemoveIndex()
		 * @generated
		 */
		EClass REMOVE_INDEX = eINSTANCE.getRemoveIndex();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.UpdateIndexImpl <em>Update Index</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.UpdateIndexImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getUpdateIndex()
		 * @generated
		 */
		EClass UPDATE_INDEX = eINSTANCE.getUpdateIndex();

		/**
		 * The meta object literal for the '<em><b>New Index</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UPDATE_INDEX__NEW_INDEX = eINSTANCE.getUpdateIndex_NewIndex();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.ForeignKeyChangeImpl <em>Foreign Key Change</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.ForeignKeyChangeImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getForeignKeyChange()
		 * @generated
		 */
		EClass FOREIGN_KEY_CHANGE = eINSTANCE.getForeignKeyChange();

		/**
		 * The meta object literal for the '<em><b>Foreign Key</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOREIGN_KEY_CHANGE__FOREIGN_KEY = eINSTANCE.getForeignKeyChange_ForeignKey();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.AddForeignKeyImpl <em>Add Foreign Key</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.AddForeignKeyImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getAddForeignKey()
		 * @generated
		 */
		EClass ADD_FOREIGN_KEY = eINSTANCE.getAddForeignKey();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.RemoveForeignKeyImpl <em>Remove Foreign Key</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.RemoveForeignKeyImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getRemoveForeignKey()
		 * @generated
		 */
		EClass REMOVE_FOREIGN_KEY = eINSTANCE.getRemoveForeignKey();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.UpdateForeignKeyImpl <em>Update Foreign Key</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.UpdateForeignKeyImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getUpdateForeignKey()
		 * @generated
		 */
		EClass UPDATE_FOREIGN_KEY = eINSTANCE.getUpdateForeignKey();

		/**
		 * The meta object literal for the '<em><b>New Foreign Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UPDATE_FOREIGN_KEY__NEW_FOREIGN_KEY = eINSTANCE.getUpdateForeignKey_NewForeignKey();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.ConstraintChangeImpl <em>Constraint Change</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.ConstraintChangeImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getConstraintChange()
		 * @generated
		 */
		EClass CONSTRAINT_CHANGE = eINSTANCE.getConstraintChange();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_CHANGE__CONSTRAINT = eINSTANCE.getConstraintChange_Constraint();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.AddConstraintImpl <em>Add Constraint</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.AddConstraintImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getAddConstraint()
		 * @generated
		 */
		EClass ADD_CONSTRAINT = eINSTANCE.getAddConstraint();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.RemoveConstraintImpl <em>Remove Constraint</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.RemoveConstraintImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getRemoveConstraint()
		 * @generated
		 */
		EClass REMOVE_CONSTRAINT = eINSTANCE.getRemoveConstraint();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.UpdateConstraintImpl <em>Update Constraint</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.UpdateConstraintImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getUpdateConstraint()
		 * @generated
		 */
		EClass UPDATE_CONSTRAINT = eINSTANCE.getUpdateConstraint();

		/**
		 * The meta object literal for the '<em><b>New Constraint</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UPDATE_CONSTRAINT__NEW_CONSTRAINT = eINSTANCE.getUpdateConstraint_NewConstraint();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.SequenceChangeImpl <em>Sequence Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.SequenceChangeImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getSequenceChange()
		 * @generated
		 */
		EClass SEQUENCE_CHANGE = eINSTANCE.getSequenceChange();

		/**
		 * The meta object literal for the '<em><b>Sequence</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_CHANGE__SEQUENCE = eINSTANCE.getSequenceChange_Sequence();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.AddSequenceImpl <em>Add Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.AddSequenceImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getAddSequence()
		 * @generated
		 */
		EClass ADD_SEQUENCE = eINSTANCE.getAddSequence();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.RemoveSequenceImpl <em>Remove Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.RemoveSequenceImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getRemoveSequence()
		 * @generated
		 */
		EClass REMOVE_SEQUENCE = eINSTANCE.getRemoveSequence();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.UpdateSequenceImpl <em>Update Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.UpdateSequenceImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getUpdateSequence()
		 * @generated
		 */
		EClass UPDATE_SEQUENCE = eINSTANCE.getUpdateSequence();

		/**
		 * The meta object literal for the '<em><b>New Sequence</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UPDATE_SEQUENCE__NEW_SEQUENCE = eINSTANCE.getUpdateSequence_NewSequence();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.SchemaChangeImpl <em>Schema Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.SchemaChangeImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getSchemaChange()
		 * @generated
		 */
		EClass SCHEMA_CHANGE = eINSTANCE.getSchemaChange();

		/**
		 * The meta object literal for the '<em><b>Schema</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEMA_CHANGE__SCHEMA = eINSTANCE.getSchemaChange_Schema();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.AddSchemaImpl <em>Add Schema</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.AddSchemaImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getAddSchema()
		 * @generated
		 */
		EClass ADD_SCHEMA = eINSTANCE.getAddSchema();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.RemoveSchemaImpl <em>Remove Schema</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.RemoveSchemaImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getRemoveSchema()
		 * @generated
		 */
		EClass REMOVE_SCHEMA = eINSTANCE.getRemoveSchema();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.AlterSchemaImpl <em>Alter Schema</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.AlterSchemaImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getAlterSchema()
		 * @generated
		 */
		EClass ALTER_SCHEMA = eINSTANCE.getAlterSchema();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.RenameSchemaChangeImpl <em>Rename Schema Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.RenameSchemaChangeImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getRenameSchemaChange()
		 * @generated
		 */
		EClass RENAME_SCHEMA_CHANGE = eINSTANCE.getRenameSchemaChange();

		/**
		 * The meta object literal for the '<em><b>New Schema</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RENAME_SCHEMA_CHANGE__NEW_SCHEMA = eINSTANCE.getRenameSchemaChange_NewSchema();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.UpdateSchemaCommentChangeImpl <em>Update Schema Comment Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.UpdateSchemaCommentChangeImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getUpdateSchemaCommentChange()
		 * @generated
		 */
		EClass UPDATE_SCHEMA_COMMENT_CHANGE = eINSTANCE.getUpdateSchemaCommentChange();

		/**
		 * The meta object literal for the '<em><b>New Schema</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UPDATE_SCHEMA_COMMENT_CHANGE__NEW_SCHEMA = eINSTANCE.getUpdateSchemaCommentChange_NewSchema();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.DBDiffImpl <em>DB Diff</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DBDiffImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getDBDiff()
		 * @generated
		 */
		EClass DB_DIFF = eINSTANCE.getDBDiff();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB_DIFF__TARGET = eINSTANCE.getDBDiff_Target();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.ViewChangeImpl <em>View Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.ViewChangeImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getViewChange()
		 * @generated
		 */
		EClass VIEW_CHANGE = eINSTANCE.getViewChange();

		/**
		 * The meta object literal for the '<em><b>View</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_CHANGE__VIEW = eINSTANCE.getViewChange_View();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.AddViewImpl <em>Add View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.AddViewImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getAddView()
		 * @generated
		 */
		EClass ADD_VIEW = eINSTANCE.getAddView();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.RemoveViewImpl <em>Remove View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.RemoveViewImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getRemoveView()
		 * @generated
		 */
		EClass REMOVE_VIEW = eINSTANCE.getRemoveView();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.AlterViewImpl <em>Alter View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.AlterViewImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getAlterView()
		 * @generated
		 */
		EClass ALTER_VIEW = eINSTANCE.getAlterView();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.RenameViewChangeImpl <em>Rename View Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.RenameViewChangeImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getRenameViewChange()
		 * @generated
		 */
		EClass RENAME_VIEW_CHANGE = eINSTANCE.getRenameViewChange();

		/**
		 * The meta object literal for the '<em><b>New View</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RENAME_VIEW_CHANGE__NEW_VIEW = eINSTANCE.getRenameViewChange_NewView();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.UpdateViewCommentChangeImpl <em>Update View Comment Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.UpdateViewCommentChangeImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getUpdateViewCommentChange()
		 * @generated
		 */
		EClass UPDATE_VIEW_COMMENT_CHANGE = eINSTANCE.getUpdateViewCommentChange();

		/**
		 * The meta object literal for the '<em><b>New View</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UPDATE_VIEW_COMMENT_CHANGE__NEW_VIEW = eINSTANCE.getUpdateViewCommentChange_NewView();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.database.dbevolution.impl.UpdateViewQueryChangeImpl <em>Update View Query Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.UpdateViewQueryChangeImpl
		 * @see org.obeonetwork.dsl.database.dbevolution.impl.DbevolutionPackageImpl#getUpdateViewQueryChange()
		 * @generated
		 */
		EClass UPDATE_VIEW_QUERY_CHANGE = eINSTANCE.getUpdateViewQueryChange();

		/**
		 * The meta object literal for the '<em><b>New View</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UPDATE_VIEW_QUERY_CHANGE__NEW_VIEW = eINSTANCE.getUpdateViewQueryChange_NewView();

	}

} // DbevolutionPackage
