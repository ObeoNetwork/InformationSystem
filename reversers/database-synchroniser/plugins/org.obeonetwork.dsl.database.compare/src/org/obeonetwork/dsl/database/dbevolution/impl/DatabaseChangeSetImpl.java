/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.database.dbevolution.impl;

import org.eclipse.emf.compare.impl.ComparisonImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.impl.MatchImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.obeonetwork.dsl.database.dbevolution.DatabaseChangeSet;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Database Change Set</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DatabaseChangeSetImpl extends ComparisonImpl implements DatabaseChangeSet {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DatabaseChangeSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DbevolutionPackage.Literals.DATABASE_CHANGE_SET;
	}

} // DatabaseChangeSetImpl
