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
import org.obeonetwork.dsl.database.PrimaryKey;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage;
import org.obeonetwork.dsl.database.dbevolution.UpdatePrimaryKey;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Update Primary Key</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.dbevolution.impl.UpdatePrimaryKeyImpl#getNewPrimaryKey <em>New Primary Key</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UpdatePrimaryKeyImpl extends PrimaryKeyChangeImpl implements UpdatePrimaryKey {
	/**
	 * The cached value of the '{@link #getNewPrimaryKey() <em>New Primary Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewPrimaryKey()
	 * @generated
	 * @ordered
	 */
	protected PrimaryKey newPrimaryKey;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected UpdatePrimaryKeyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DbevolutionPackage.Literals.UPDATE_PRIMARY_KEY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryKey getNewPrimaryKey() {
		if (newPrimaryKey != null && ((EObject)newPrimaryKey).eIsProxy()) {
			InternalEObject oldNewPrimaryKey = (InternalEObject)newPrimaryKey;
			newPrimaryKey = (PrimaryKey)eResolveProxy(oldNewPrimaryKey);
			if (newPrimaryKey != oldNewPrimaryKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DbevolutionPackage.UPDATE_PRIMARY_KEY__NEW_PRIMARY_KEY, oldNewPrimaryKey, newPrimaryKey));
			}
		}
		return newPrimaryKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryKey basicGetNewPrimaryKey() {
		return newPrimaryKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewPrimaryKey(PrimaryKey newNewPrimaryKey) {
		PrimaryKey oldNewPrimaryKey = newPrimaryKey;
		newPrimaryKey = newNewPrimaryKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbevolutionPackage.UPDATE_PRIMARY_KEY__NEW_PRIMARY_KEY, oldNewPrimaryKey, newPrimaryKey));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DbevolutionPackage.UPDATE_PRIMARY_KEY__NEW_PRIMARY_KEY:
				if (resolve) return getNewPrimaryKey();
				return basicGetNewPrimaryKey();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DbevolutionPackage.UPDATE_PRIMARY_KEY__NEW_PRIMARY_KEY:
				setNewPrimaryKey((PrimaryKey)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DbevolutionPackage.UPDATE_PRIMARY_KEY__NEW_PRIMARY_KEY:
				setNewPrimaryKey((PrimaryKey)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DbevolutionPackage.UPDATE_PRIMARY_KEY__NEW_PRIMARY_KEY:
				return newPrimaryKey != null;
		}
		return super.eIsSet(featureID);
	}

} // UpdatePrimaryKeyImpl
