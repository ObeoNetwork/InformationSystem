/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.database.AbstractTable;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DatabaseFactory;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.ForeignKeyElement;
import org.obeonetwork.dsl.database.Index;
import org.obeonetwork.dsl.database.IndexElement;
import org.obeonetwork.dsl.database.PrimaryKey;
import org.obeonetwork.dsl.database.Sequence;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.typeslibrary.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Column</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.impl.ColumnImpl#isNullable <em>Nullable</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.ColumnImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.ColumnImpl#getIndexes <em>Indexes</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.ColumnImpl#getIndexElements <em>Index Elements</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.ColumnImpl#getPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.ColumnImpl#getForeignKeys <em>Foreign Keys</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.ColumnImpl#getForeignKeyElements <em>Foreign Key Elements</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.ColumnImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.ColumnImpl#getSequence <em>Sequence</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.ColumnImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.ColumnImpl#isAutoincrement <em>Autoincrement</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.ColumnImpl#isInPrimaryKey <em>In Primary Key</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.ColumnImpl#isInForeignKey <em>In Foreign Key</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.ColumnImpl#isUnique <em>Unique</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ColumnImpl extends NamedElementImpl implements Column {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2023 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #isNullable() <em>Nullable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNullable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NULLABLE_EDEFAULT = false;
	/**
	 * The default value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_VALUE_EDEFAULT = null;
	/**
	 * The default value of the '{@link #isAutoincrement() <em>Autoincrement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutoincrement()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AUTOINCREMENT_EDEFAULT = false;
	/**
	 * The default value of the '{@link #isInPrimaryKey() <em>In Primary Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInPrimaryKey()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IN_PRIMARY_KEY_EDEFAULT = false;
	/**
	 * The default value of the '{@link #isInForeignKey() <em>In Foreign Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInForeignKey()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IN_FOREIGN_KEY_EDEFAULT = false;
	/**
	 * The default value of the '{@link #isUnique() <em>Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnique()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UNIQUE_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ColumnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatabasePackage.Literals.COLUMN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNullable() {
		return (Boolean)eDynamicGet(DatabasePackage.COLUMN__NULLABLE, DatabasePackage.Literals.COLUMN__NULLABLE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNullable(boolean newNullable) {
		eDynamicSet(DatabasePackage.COLUMN__NULLABLE, DatabasePackage.Literals.COLUMN__NULLABLE, newNullable);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultValue() {
		return (String)eDynamicGet(DatabasePackage.COLUMN__DEFAULT_VALUE, DatabasePackage.Literals.COLUMN__DEFAULT_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultValue(String newDefaultValue) {
		eDynamicSet(DatabasePackage.COLUMN__DEFAULT_VALUE, DatabasePackage.Literals.COLUMN__DEFAULT_VALUE, newDefaultValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Index> getIndexes() {
		// TODO: implement this method to return the 'Indexes' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IndexElement> getIndexElements() {
		return (EList<IndexElement>)eDynamicGet(DatabasePackage.COLUMN__INDEX_ELEMENTS, DatabasePackage.Literals.COLUMN__INDEX_ELEMENTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryKey getPrimaryKey() {
		return (PrimaryKey)eDynamicGet(DatabasePackage.COLUMN__PRIMARY_KEY, DatabasePackage.Literals.COLUMN__PRIMARY_KEY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryKey basicGetPrimaryKey() {
		return (PrimaryKey)eDynamicGet(DatabasePackage.COLUMN__PRIMARY_KEY, DatabasePackage.Literals.COLUMN__PRIMARY_KEY, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrimaryKey(PrimaryKey newPrimaryKey, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newPrimaryKey, DatabasePackage.COLUMN__PRIMARY_KEY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimaryKey(PrimaryKey newPrimaryKey) {
		eDynamicSet(DatabasePackage.COLUMN__PRIMARY_KEY, DatabasePackage.Literals.COLUMN__PRIMARY_KEY, newPrimaryKey);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ForeignKey> getForeignKeys() {
		// TODO: implement this method to return the 'Foreign Keys' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ForeignKeyElement> getForeignKeyElements() {
		return (EList<ForeignKeyElement>)eDynamicGet(DatabasePackage.COLUMN__FOREIGN_KEY_ELEMENTS, DatabasePackage.Literals.COLUMN__FOREIGN_KEY_ELEMENTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		return (Type)eDynamicGet(DatabasePackage.COLUMN__TYPE, DatabasePackage.Literals.COLUMN__TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetType(Type newType, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newType, DatabasePackage.COLUMN__TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Type newType) {
		eDynamicSet(DatabasePackage.COLUMN__TYPE, DatabasePackage.Literals.COLUMN__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sequence getSequence() {
		return (Sequence)eDynamicGet(DatabasePackage.COLUMN__SEQUENCE, DatabasePackage.Literals.COLUMN__SEQUENCE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sequence basicGetSequence() {
		return (Sequence)eDynamicGet(DatabasePackage.COLUMN__SEQUENCE, DatabasePackage.Literals.COLUMN__SEQUENCE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSequence(Sequence newSequence, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newSequence, DatabasePackage.COLUMN__SEQUENCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequence(Sequence newSequence) {
		eDynamicSet(DatabasePackage.COLUMN__SEQUENCE, DatabasePackage.Literals.COLUMN__SEQUENCE, newSequence);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table getOwner() {
		return (Table)eDynamicGet(DatabasePackage.COLUMN__OWNER, DatabasePackage.Literals.COLUMN__OWNER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(Table newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, DatabasePackage.COLUMN__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Table newOwner) {
		eDynamicSet(DatabasePackage.COLUMN__OWNER, DatabasePackage.Literals.COLUMN__OWNER, newOwner);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAutoincrement() {
		return (Boolean)eDynamicGet(DatabasePackage.COLUMN__AUTOINCREMENT, DatabasePackage.Literals.COLUMN__AUTOINCREMENT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutoincrement(boolean newAutoincrement) {
		eDynamicSet(DatabasePackage.COLUMN__AUTOINCREMENT, DatabasePackage.Literals.COLUMN__AUTOINCREMENT, newAutoincrement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInPrimaryKey() {
		// TODO: implement this method to return the 'In Primary Key' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInForeignKey() {
		// TODO: implement this method to return the 'In Foreign Key' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUnique() {
		// TODO: implement this method to return the 'Unique' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addToPrimaryKey() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeFromPrimaryKey() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addToUniqueIndex() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeFromUniqueIndex() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case DatabasePackage.COLUMN__INDEX_ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIndexElements()).basicAdd(otherEnd, msgs);
			case DatabasePackage.COLUMN__PRIMARY_KEY:
				PrimaryKey primaryKey = basicGetPrimaryKey();
				if (primaryKey != null)
					msgs = ((InternalEObject)primaryKey).eInverseRemove(this, DatabasePackage.PRIMARY_KEY__COLUMNS, PrimaryKey.class, msgs);
				return basicSetPrimaryKey((PrimaryKey)otherEnd, msgs);
			case DatabasePackage.COLUMN__FOREIGN_KEY_ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getForeignKeyElements()).basicAdd(otherEnd, msgs);
			case DatabasePackage.COLUMN__SEQUENCE:
				Sequence sequence = basicGetSequence();
				if (sequence != null)
					msgs = ((InternalEObject)sequence).eInverseRemove(this, DatabasePackage.SEQUENCE__COLUMNS, Sequence.class, msgs);
				return basicSetSequence((Sequence)otherEnd, msgs);
			case DatabasePackage.COLUMN__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((Table)otherEnd, msgs);
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
			case DatabasePackage.COLUMN__INDEX_ELEMENTS:
				return ((InternalEList<?>)getIndexElements()).basicRemove(otherEnd, msgs);
			case DatabasePackage.COLUMN__PRIMARY_KEY:
				return basicSetPrimaryKey(null, msgs);
			case DatabasePackage.COLUMN__FOREIGN_KEY_ELEMENTS:
				return ((InternalEList<?>)getForeignKeyElements()).basicRemove(otherEnd, msgs);
			case DatabasePackage.COLUMN__TYPE:
				return basicSetType(null, msgs);
			case DatabasePackage.COLUMN__SEQUENCE:
				return basicSetSequence(null, msgs);
			case DatabasePackage.COLUMN__OWNER:
				return basicSetOwner(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case DatabasePackage.COLUMN__OWNER:
				return eInternalContainer().eInverseRemove(this, DatabasePackage.TABLE__COLUMNS, Table.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DatabasePackage.COLUMN__NULLABLE:
				return isNullable();
			case DatabasePackage.COLUMN__DEFAULT_VALUE:
				return getDefaultValue();
			case DatabasePackage.COLUMN__INDEXES:
				return getIndexes();
			case DatabasePackage.COLUMN__INDEX_ELEMENTS:
				return getIndexElements();
			case DatabasePackage.COLUMN__PRIMARY_KEY:
				if (resolve) return getPrimaryKey();
				return basicGetPrimaryKey();
			case DatabasePackage.COLUMN__FOREIGN_KEYS:
				return getForeignKeys();
			case DatabasePackage.COLUMN__FOREIGN_KEY_ELEMENTS:
				return getForeignKeyElements();
			case DatabasePackage.COLUMN__TYPE:
				return getType();
			case DatabasePackage.COLUMN__SEQUENCE:
				if (resolve) return getSequence();
				return basicGetSequence();
			case DatabasePackage.COLUMN__OWNER:
				return getOwner();
			case DatabasePackage.COLUMN__AUTOINCREMENT:
				return isAutoincrement();
			case DatabasePackage.COLUMN__IN_PRIMARY_KEY:
				return isInPrimaryKey();
			case DatabasePackage.COLUMN__IN_FOREIGN_KEY:
				return isInForeignKey();
			case DatabasePackage.COLUMN__UNIQUE:
				return isUnique();
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
			case DatabasePackage.COLUMN__NULLABLE:
				setNullable((Boolean)newValue);
				return;
			case DatabasePackage.COLUMN__DEFAULT_VALUE:
				setDefaultValue((String)newValue);
				return;
			case DatabasePackage.COLUMN__INDEX_ELEMENTS:
				getIndexElements().clear();
				getIndexElements().addAll((Collection<? extends IndexElement>)newValue);
				return;
			case DatabasePackage.COLUMN__PRIMARY_KEY:
				setPrimaryKey((PrimaryKey)newValue);
				return;
			case DatabasePackage.COLUMN__FOREIGN_KEY_ELEMENTS:
				getForeignKeyElements().clear();
				getForeignKeyElements().addAll((Collection<? extends ForeignKeyElement>)newValue);
				return;
			case DatabasePackage.COLUMN__TYPE:
				setType((Type)newValue);
				return;
			case DatabasePackage.COLUMN__SEQUENCE:
				setSequence((Sequence)newValue);
				return;
			case DatabasePackage.COLUMN__OWNER:
				setOwner((Table)newValue);
				return;
			case DatabasePackage.COLUMN__AUTOINCREMENT:
				setAutoincrement((Boolean)newValue);
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
			case DatabasePackage.COLUMN__NULLABLE:
				setNullable(NULLABLE_EDEFAULT);
				return;
			case DatabasePackage.COLUMN__DEFAULT_VALUE:
				setDefaultValue(DEFAULT_VALUE_EDEFAULT);
				return;
			case DatabasePackage.COLUMN__INDEX_ELEMENTS:
				getIndexElements().clear();
				return;
			case DatabasePackage.COLUMN__PRIMARY_KEY:
				setPrimaryKey((PrimaryKey)null);
				return;
			case DatabasePackage.COLUMN__FOREIGN_KEY_ELEMENTS:
				getForeignKeyElements().clear();
				return;
			case DatabasePackage.COLUMN__TYPE:
				setType((Type)null);
				return;
			case DatabasePackage.COLUMN__SEQUENCE:
				setSequence((Sequence)null);
				return;
			case DatabasePackage.COLUMN__OWNER:
				setOwner((Table)null);
				return;
			case DatabasePackage.COLUMN__AUTOINCREMENT:
				setAutoincrement(AUTOINCREMENT_EDEFAULT);
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
			case DatabasePackage.COLUMN__NULLABLE:
				return isNullable() != NULLABLE_EDEFAULT;
			case DatabasePackage.COLUMN__DEFAULT_VALUE:
				return DEFAULT_VALUE_EDEFAULT == null ? getDefaultValue() != null : !DEFAULT_VALUE_EDEFAULT.equals(getDefaultValue());
			case DatabasePackage.COLUMN__INDEXES:
				return !getIndexes().isEmpty();
			case DatabasePackage.COLUMN__INDEX_ELEMENTS:
				return !getIndexElements().isEmpty();
			case DatabasePackage.COLUMN__PRIMARY_KEY:
				return basicGetPrimaryKey() != null;
			case DatabasePackage.COLUMN__FOREIGN_KEYS:
				return !getForeignKeys().isEmpty();
			case DatabasePackage.COLUMN__FOREIGN_KEY_ELEMENTS:
				return !getForeignKeyElements().isEmpty();
			case DatabasePackage.COLUMN__TYPE:
				return getType() != null;
			case DatabasePackage.COLUMN__SEQUENCE:
				return basicGetSequence() != null;
			case DatabasePackage.COLUMN__OWNER:
				return getOwner() != null;
			case DatabasePackage.COLUMN__AUTOINCREMENT:
				return isAutoincrement() != AUTOINCREMENT_EDEFAULT;
			case DatabasePackage.COLUMN__IN_PRIMARY_KEY:
				return isInPrimaryKey() != IN_PRIMARY_KEY_EDEFAULT;
			case DatabasePackage.COLUMN__IN_FOREIGN_KEY:
				return isInForeignKey() != IN_FOREIGN_KEY_EDEFAULT;
			case DatabasePackage.COLUMN__UNIQUE:
				return isUnique() != UNIQUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //ColumnImpl
