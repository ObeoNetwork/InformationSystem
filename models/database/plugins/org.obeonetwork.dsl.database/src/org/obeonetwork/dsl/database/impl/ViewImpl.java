/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.View;
import org.obeonetwork.dsl.database.ViewElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.impl.ViewImpl#getQuery <em>Query</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.ViewImpl#getColumns <em>Columns</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.ViewImpl#getTables <em>Tables</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ViewImpl extends AbstractTableImpl implements View {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2020 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getQuery() <em>Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuery()
	 * @generated
	 * @ordered
	 */
	protected static final String QUERY_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatabasePackage.Literals.VIEW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQuery() {
		return (String)eDynamicGet(DatabasePackage.VIEW__QUERY, DatabasePackage.Literals.VIEW__QUERY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuery(String newQuery) {
		eDynamicSet(DatabasePackage.VIEW__QUERY, DatabasePackage.Literals.VIEW__QUERY, newQuery);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ViewElement> getColumns() {
		return (EList<ViewElement>)eDynamicGet(DatabasePackage.VIEW__COLUMNS, DatabasePackage.Literals.VIEW__COLUMNS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ViewElement> getTables() {
		return (EList<ViewElement>)eDynamicGet(DatabasePackage.VIEW__TABLES, DatabasePackage.Literals.VIEW__TABLES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DatabasePackage.VIEW__COLUMNS:
				return ((InternalEList<?>)getColumns()).basicRemove(otherEnd, msgs);
			case DatabasePackage.VIEW__TABLES:
				return ((InternalEList<?>)getTables()).basicRemove(otherEnd, msgs);
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
			case DatabasePackage.VIEW__QUERY:
				return getQuery();
			case DatabasePackage.VIEW__COLUMNS:
				return getColumns();
			case DatabasePackage.VIEW__TABLES:
				return getTables();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DatabasePackage.VIEW__QUERY:
				setQuery((String)newValue);
				return;
			case DatabasePackage.VIEW__COLUMNS:
				getColumns().clear();
				getColumns().addAll((Collection<? extends ViewElement>)newValue);
				return;
			case DatabasePackage.VIEW__TABLES:
				getTables().clear();
				getTables().addAll((Collection<? extends ViewElement>)newValue);
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
			case DatabasePackage.VIEW__QUERY:
				setQuery(QUERY_EDEFAULT);
				return;
			case DatabasePackage.VIEW__COLUMNS:
				getColumns().clear();
				return;
			case DatabasePackage.VIEW__TABLES:
				getTables().clear();
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
			case DatabasePackage.VIEW__QUERY:
				return QUERY_EDEFAULT == null ? getQuery() != null : !QUERY_EDEFAULT.equals(getQuery());
			case DatabasePackage.VIEW__COLUMNS:
				return !getColumns().isEmpty();
			case DatabasePackage.VIEW__TABLES:
				return !getTables().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ViewImpl
