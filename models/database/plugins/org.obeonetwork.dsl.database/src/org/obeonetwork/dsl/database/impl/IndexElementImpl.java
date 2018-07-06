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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.IndexElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Index Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.impl.IndexElementImpl#getColumn <em>Column</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.IndexElementImpl#isAsc <em>Asc</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IndexElementImpl extends DatabaseElementImpl implements IndexElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2011, 2017 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #isAsc() <em>Asc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAsc()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ASC_EDEFAULT = false;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IndexElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatabasePackage.Literals.INDEX_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column getColumn() {
		return (Column)eDynamicGet(DatabasePackage.INDEX_ELEMENT__COLUMN, DatabasePackage.Literals.INDEX_ELEMENT__COLUMN, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column basicGetColumn() {
		return (Column)eDynamicGet(DatabasePackage.INDEX_ELEMENT__COLUMN, DatabasePackage.Literals.INDEX_ELEMENT__COLUMN, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetColumn(Column newColumn, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newColumn, DatabasePackage.INDEX_ELEMENT__COLUMN, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColumn(Column newColumn) {
		eDynamicSet(DatabasePackage.INDEX_ELEMENT__COLUMN, DatabasePackage.Literals.INDEX_ELEMENT__COLUMN, newColumn);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAsc() {
		return (Boolean)eDynamicGet(DatabasePackage.INDEX_ELEMENT__ASC, DatabasePackage.Literals.INDEX_ELEMENT__ASC, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAsc(boolean newAsc) {
		eDynamicSet(DatabasePackage.INDEX_ELEMENT__ASC, DatabasePackage.Literals.INDEX_ELEMENT__ASC, newAsc);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DatabasePackage.INDEX_ELEMENT__COLUMN:
				Column column = basicGetColumn();
				if (column != null)
					msgs = ((InternalEObject)column).eInverseRemove(this, DatabasePackage.COLUMN__INDEX_ELEMENTS, Column.class, msgs);
				return basicSetColumn((Column)otherEnd, msgs);
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
			case DatabasePackage.INDEX_ELEMENT__COLUMN:
				return basicSetColumn(null, msgs);
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
			case DatabasePackage.INDEX_ELEMENT__COLUMN:
				if (resolve) return getColumn();
				return basicGetColumn();
			case DatabasePackage.INDEX_ELEMENT__ASC:
				return isAsc();
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
			case DatabasePackage.INDEX_ELEMENT__COLUMN:
				setColumn((Column)newValue);
				return;
			case DatabasePackage.INDEX_ELEMENT__ASC:
				setAsc((Boolean)newValue);
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
			case DatabasePackage.INDEX_ELEMENT__COLUMN:
				setColumn((Column)null);
				return;
			case DatabasePackage.INDEX_ELEMENT__ASC:
				setAsc(ASC_EDEFAULT);
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
			case DatabasePackage.INDEX_ELEMENT__COLUMN:
				return basicGetColumn() != null;
			case DatabasePackage.INDEX_ELEMENT__ASC:
				return isAsc() != ASC_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //IndexElementImpl
