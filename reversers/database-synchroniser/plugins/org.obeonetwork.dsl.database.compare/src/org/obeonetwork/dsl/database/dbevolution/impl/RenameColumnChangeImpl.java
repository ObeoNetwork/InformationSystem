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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage;
import org.obeonetwork.dsl.database.dbevolution.RenameColumnChange;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rename Column Change</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.dbevolution.impl.RenameColumnChangeImpl#getNewColumn <em>New Column</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RenameColumnChangeImpl extends ColumnChangeImpl implements RenameColumnChange {
	/**
	 * The cached value of the '{@link #getNewColumn() <em>New Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewColumn()
	 * @generated
	 * @ordered
	 */
	protected Column newColumn;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RenameColumnChangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DbevolutionPackage.Literals.RENAME_COLUMN_CHANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column getNewColumn() {
		if (newColumn != null && ((EObject)newColumn).eIsProxy()) {
			InternalEObject oldNewColumn = (InternalEObject)newColumn;
			newColumn = (Column)eResolveProxy(oldNewColumn);
			if (newColumn != oldNewColumn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DbevolutionPackage.RENAME_COLUMN_CHANGE__NEW_COLUMN, oldNewColumn, newColumn));
			}
		}
		return newColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column basicGetNewColumn() {
		return newColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewColumn(Column newNewColumn) {
		Column oldNewColumn = newColumn;
		newColumn = newNewColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbevolutionPackage.RENAME_COLUMN_CHANGE__NEW_COLUMN, oldNewColumn, newColumn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DbevolutionPackage.RENAME_COLUMN_CHANGE__NEW_COLUMN:
				if (resolve) return getNewColumn();
				return basicGetNewColumn();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DbevolutionPackage.RENAME_COLUMN_CHANGE__NEW_COLUMN:
				setNewColumn((Column)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DbevolutionPackage.RENAME_COLUMN_CHANGE__NEW_COLUMN:
				setNewColumn((Column)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DbevolutionPackage.RENAME_COLUMN_CHANGE__NEW_COLUMN:
				return newColumn != null;
		}
		return super.eIsSet(featureID);
	}

} //RenameColumnChangeImpl
