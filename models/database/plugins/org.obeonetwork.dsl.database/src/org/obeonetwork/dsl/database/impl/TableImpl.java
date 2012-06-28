/**
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.database.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.database.Constraint;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.Index;
import org.obeonetwork.dsl.database.PrimaryKey;
import org.obeonetwork.dsl.database.Table;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.impl.TableImpl#getPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.TableImpl#getForeignKeys <em>Foreign Keys</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.TableImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.TableImpl#getIndexes <em>Indexes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TableImpl extends AbstractTableImpl implements Table {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2011 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatabasePackage.Literals.TABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryKey getPrimaryKey() {
		return (PrimaryKey)eDynamicGet(DatabasePackage.TABLE__PRIMARY_KEY, DatabasePackage.Literals.TABLE__PRIMARY_KEY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrimaryKey(PrimaryKey newPrimaryKey, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newPrimaryKey, DatabasePackage.TABLE__PRIMARY_KEY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimaryKey(PrimaryKey newPrimaryKey) {
		eDynamicSet(DatabasePackage.TABLE__PRIMARY_KEY, DatabasePackage.Literals.TABLE__PRIMARY_KEY, newPrimaryKey);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ForeignKey> getForeignKeys() {
		return (EList<ForeignKey>)eDynamicGet(DatabasePackage.TABLE__FOREIGN_KEYS, DatabasePackage.Literals.TABLE__FOREIGN_KEYS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Constraint> getConstraints() {
		return (EList<Constraint>)eDynamicGet(DatabasePackage.TABLE__CONSTRAINTS, DatabasePackage.Literals.TABLE__CONSTRAINTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Index> getIndexes() {
		return (EList<Index>)eDynamicGet(DatabasePackage.TABLE__INDEXES, DatabasePackage.Literals.TABLE__INDEXES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DatabasePackage.TABLE__PRIMARY_KEY:
				PrimaryKey primaryKey = getPrimaryKey();
				if (primaryKey != null)
					msgs = ((InternalEObject)primaryKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DatabasePackage.TABLE__PRIMARY_KEY, null, msgs);
				return basicSetPrimaryKey((PrimaryKey)otherEnd, msgs);
			case DatabasePackage.TABLE__FOREIGN_KEYS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getForeignKeys()).basicAdd(otherEnd, msgs);
			case DatabasePackage.TABLE__CONSTRAINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConstraints()).basicAdd(otherEnd, msgs);
			case DatabasePackage.TABLE__INDEXES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIndexes()).basicAdd(otherEnd, msgs);
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
			case DatabasePackage.TABLE__PRIMARY_KEY:
				return basicSetPrimaryKey(null, msgs);
			case DatabasePackage.TABLE__FOREIGN_KEYS:
				return ((InternalEList<?>)getForeignKeys()).basicRemove(otherEnd, msgs);
			case DatabasePackage.TABLE__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
			case DatabasePackage.TABLE__INDEXES:
				return ((InternalEList<?>)getIndexes()).basicRemove(otherEnd, msgs);
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
			case DatabasePackage.TABLE__PRIMARY_KEY:
				return getPrimaryKey();
			case DatabasePackage.TABLE__FOREIGN_KEYS:
				return getForeignKeys();
			case DatabasePackage.TABLE__CONSTRAINTS:
				return getConstraints();
			case DatabasePackage.TABLE__INDEXES:
				return getIndexes();
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
			case DatabasePackage.TABLE__PRIMARY_KEY:
				setPrimaryKey((PrimaryKey)newValue);
				return;
			case DatabasePackage.TABLE__FOREIGN_KEYS:
				getForeignKeys().clear();
				getForeignKeys().addAll((Collection<? extends ForeignKey>)newValue);
				return;
			case DatabasePackage.TABLE__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends Constraint>)newValue);
				return;
			case DatabasePackage.TABLE__INDEXES:
				getIndexes().clear();
				getIndexes().addAll((Collection<? extends Index>)newValue);
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
			case DatabasePackage.TABLE__PRIMARY_KEY:
				setPrimaryKey((PrimaryKey)null);
				return;
			case DatabasePackage.TABLE__FOREIGN_KEYS:
				getForeignKeys().clear();
				return;
			case DatabasePackage.TABLE__CONSTRAINTS:
				getConstraints().clear();
				return;
			case DatabasePackage.TABLE__INDEXES:
				getIndexes().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DatabasePackage.TABLE__PRIMARY_KEY:
				return getPrimaryKey() != null;
			case DatabasePackage.TABLE__FOREIGN_KEYS:
				return !getForeignKeys().isEmpty();
			case DatabasePackage.TABLE__CONSTRAINTS:
				return !getConstraints().isEmpty();
			case DatabasePackage.TABLE__INDEXES:
				return !getIndexes().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TableImpl
