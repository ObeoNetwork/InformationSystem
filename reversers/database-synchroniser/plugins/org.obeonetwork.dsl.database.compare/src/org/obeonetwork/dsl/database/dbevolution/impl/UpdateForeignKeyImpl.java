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
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage;
import org.obeonetwork.dsl.database.dbevolution.UpdateForeignKey;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Update Foreign Key</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.dbevolution.impl.UpdateForeignKeyImpl#getNewForeignKey <em>New Foreign Key</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UpdateForeignKeyImpl extends ForeignKeyChangeImpl implements UpdateForeignKey {
	/**
	 * The cached value of the '{@link #getNewForeignKey() <em>New Foreign Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewForeignKey()
	 * @generated
	 * @ordered
	 */
	protected ForeignKey newForeignKey;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected UpdateForeignKeyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DbevolutionPackage.Literals.UPDATE_FOREIGN_KEY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForeignKey getNewForeignKey() {
		if (newForeignKey != null && ((EObject)newForeignKey).eIsProxy()) {
			InternalEObject oldNewForeignKey = (InternalEObject)newForeignKey;
			newForeignKey = (ForeignKey)eResolveProxy(oldNewForeignKey);
			if (newForeignKey != oldNewForeignKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DbevolutionPackage.UPDATE_FOREIGN_KEY__NEW_FOREIGN_KEY, oldNewForeignKey, newForeignKey));
			}
		}
		return newForeignKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForeignKey basicGetNewForeignKey() {
		return newForeignKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewForeignKey(ForeignKey newNewForeignKey) {
		ForeignKey oldNewForeignKey = newForeignKey;
		newForeignKey = newNewForeignKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbevolutionPackage.UPDATE_FOREIGN_KEY__NEW_FOREIGN_KEY, oldNewForeignKey, newForeignKey));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DbevolutionPackage.UPDATE_FOREIGN_KEY__NEW_FOREIGN_KEY:
				if (resolve) return getNewForeignKey();
				return basicGetNewForeignKey();
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
			case DbevolutionPackage.UPDATE_FOREIGN_KEY__NEW_FOREIGN_KEY:
				setNewForeignKey((ForeignKey)newValue);
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
			case DbevolutionPackage.UPDATE_FOREIGN_KEY__NEW_FOREIGN_KEY:
				setNewForeignKey((ForeignKey)null);
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
			case DbevolutionPackage.UPDATE_FOREIGN_KEY__NEW_FOREIGN_KEY:
				return newForeignKey != null;
		}
		return super.eIsSet(featureID);
	}

} // UpdateForeignKeyImpl
