/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.database.dbevolution.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.compare.impl.ReferenceChangeImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.dbevolution.AddColumnChange;
import org.obeonetwork.dsl.database.dbevolution.ColumnChange;
import org.obeonetwork.dsl.database.dbevolution.DBDiff;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Add Column Change</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AddColumnChangeImpl extends ColumnChangeImpl implements AddColumnChange {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddColumnChangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DbevolutionPackage.Literals.ADD_COLUMN_CHANGE;
	}

} //AddColumnChangeImpl
