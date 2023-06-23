/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.ForeignKeyElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Foreign Key Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.impl.ForeignKeyElementImpl#getFkColumn <em>Fk Column</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.ForeignKeyElementImpl#getPkColumn <em>Pk Column</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForeignKeyElementImpl extends DatabaseElementImpl implements ForeignKeyElement {
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2023 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v2.0\r\nwhich accompanies this distribution, and is available at\r\nhttps://www.eclipse.org/legal/epl-2.0/\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForeignKeyElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatabasePackage.Literals.FOREIGN_KEY_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column getFkColumn() {
		return (Column)eDynamicGet(DatabasePackage.FOREIGN_KEY_ELEMENT__FK_COLUMN, DatabasePackage.Literals.FOREIGN_KEY_ELEMENT__FK_COLUMN, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column basicGetFkColumn() {
		return (Column)eDynamicGet(DatabasePackage.FOREIGN_KEY_ELEMENT__FK_COLUMN, DatabasePackage.Literals.FOREIGN_KEY_ELEMENT__FK_COLUMN, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFkColumn(Column newFkColumn, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newFkColumn, DatabasePackage.FOREIGN_KEY_ELEMENT__FK_COLUMN, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFkColumn(Column newFkColumn) {
		eDynamicSet(DatabasePackage.FOREIGN_KEY_ELEMENT__FK_COLUMN, DatabasePackage.Literals.FOREIGN_KEY_ELEMENT__FK_COLUMN, newFkColumn);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column getPkColumn() {
		return (Column)eDynamicGet(DatabasePackage.FOREIGN_KEY_ELEMENT__PK_COLUMN, DatabasePackage.Literals.FOREIGN_KEY_ELEMENT__PK_COLUMN, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column basicGetPkColumn() {
		return (Column)eDynamicGet(DatabasePackage.FOREIGN_KEY_ELEMENT__PK_COLUMN, DatabasePackage.Literals.FOREIGN_KEY_ELEMENT__PK_COLUMN, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPkColumn(Column newPkColumn) {
		eDynamicSet(DatabasePackage.FOREIGN_KEY_ELEMENT__PK_COLUMN, DatabasePackage.Literals.FOREIGN_KEY_ELEMENT__PK_COLUMN, newPkColumn);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DatabasePackage.FOREIGN_KEY_ELEMENT__FK_COLUMN:
				Column fkColumn = basicGetFkColumn();
				if (fkColumn != null)
					msgs = ((InternalEObject)fkColumn).eInverseRemove(this, DatabasePackage.COLUMN__FOREIGN_KEY_ELEMENTS, Column.class, msgs);
				return basicSetFkColumn((Column)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DatabasePackage.FOREIGN_KEY_ELEMENT__FK_COLUMN:
				return basicSetFkColumn(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DatabasePackage.FOREIGN_KEY_ELEMENT__FK_COLUMN:
				if (resolve) return getFkColumn();
				return basicGetFkColumn();
			case DatabasePackage.FOREIGN_KEY_ELEMENT__PK_COLUMN:
				if (resolve) return getPkColumn();
				return basicGetPkColumn();
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
			case DatabasePackage.FOREIGN_KEY_ELEMENT__FK_COLUMN:
				setFkColumn((Column)newValue);
				return;
			case DatabasePackage.FOREIGN_KEY_ELEMENT__PK_COLUMN:
				setPkColumn((Column)newValue);
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
			case DatabasePackage.FOREIGN_KEY_ELEMENT__FK_COLUMN:
				setFkColumn((Column)null);
				return;
			case DatabasePackage.FOREIGN_KEY_ELEMENT__PK_COLUMN:
				setPkColumn((Column)null);
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
			case DatabasePackage.FOREIGN_KEY_ELEMENT__FK_COLUMN:
				return basicGetFkColumn() != null;
			case DatabasePackage.FOREIGN_KEY_ELEMENT__PK_COLUMN:
				return basicGetPkColumn() != null;
		}
		return super.eIsSet(featureID);
	}

} //ForeignKeyElementImpl
