/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.impl;

import java.math.BigInteger;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.database.Column;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.Sequence;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.impl.SequenceImpl#getStart <em>Start</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.SequenceImpl#getIncrement <em>Increment</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.SequenceImpl#getMinValue <em>Min Value</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.SequenceImpl#getMaxValue <em>Max Value</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.SequenceImpl#getCacheSize <em>Cache Size</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.SequenceImpl#isCycle <em>Cycle</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.SequenceImpl#getColumns <em>Columns</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SequenceImpl extends NamedElementImpl implements Sequence {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2024 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v2.0\r\nwhich accompanies this distribution, and is available at\r\nhttps://www.eclipse.org/legal/epl-2.0/\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger START_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getIncrement() <em>Increment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncrement()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger INCREMENT_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getMinValue() <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinValue()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger MIN_VALUE_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getMaxValue() <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxValue()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger MAX_VALUE_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getCacheSize() <em>Cache Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCacheSize()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger CACHE_SIZE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #isCycle() <em>Cycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCycle()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CYCLE_EDEFAULT = false;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SequenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatabasePackage.Literals.SEQUENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getStart() {
		return (BigInteger)eDynamicGet(DatabasePackage.SEQUENCE__START, DatabasePackage.Literals.SEQUENCE__START, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStart(BigInteger newStart) {
		eDynamicSet(DatabasePackage.SEQUENCE__START, DatabasePackage.Literals.SEQUENCE__START, newStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getIncrement() {
		return (BigInteger)eDynamicGet(DatabasePackage.SEQUENCE__INCREMENT, DatabasePackage.Literals.SEQUENCE__INCREMENT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncrement(BigInteger newIncrement) {
		eDynamicSet(DatabasePackage.SEQUENCE__INCREMENT, DatabasePackage.Literals.SEQUENCE__INCREMENT, newIncrement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getMinValue() {
		return (BigInteger)eDynamicGet(DatabasePackage.SEQUENCE__MIN_VALUE, DatabasePackage.Literals.SEQUENCE__MIN_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinValue(BigInteger newMinValue) {
		eDynamicSet(DatabasePackage.SEQUENCE__MIN_VALUE, DatabasePackage.Literals.SEQUENCE__MIN_VALUE, newMinValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getMaxValue() {
		return (BigInteger)eDynamicGet(DatabasePackage.SEQUENCE__MAX_VALUE, DatabasePackage.Literals.SEQUENCE__MAX_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxValue(BigInteger newMaxValue) {
		eDynamicSet(DatabasePackage.SEQUENCE__MAX_VALUE, DatabasePackage.Literals.SEQUENCE__MAX_VALUE, newMaxValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getCacheSize() {
		return (BigInteger)eDynamicGet(DatabasePackage.SEQUENCE__CACHE_SIZE, DatabasePackage.Literals.SEQUENCE__CACHE_SIZE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCacheSize(BigInteger newCacheSize) {
		eDynamicSet(DatabasePackage.SEQUENCE__CACHE_SIZE, DatabasePackage.Literals.SEQUENCE__CACHE_SIZE, newCacheSize);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCycle() {
		return (Boolean)eDynamicGet(DatabasePackage.SEQUENCE__CYCLE, DatabasePackage.Literals.SEQUENCE__CYCLE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCycle(boolean newCycle) {
		eDynamicSet(DatabasePackage.SEQUENCE__CYCLE, DatabasePackage.Literals.SEQUENCE__CYCLE, newCycle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Column> getColumns() {
		return (EList<Column>)eDynamicGet(DatabasePackage.SEQUENCE__COLUMNS, DatabasePackage.Literals.SEQUENCE__COLUMNS, true, true);
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
			case DatabasePackage.SEQUENCE__COLUMNS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getColumns()).basicAdd(otherEnd, msgs);
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
			case DatabasePackage.SEQUENCE__COLUMNS:
				return ((InternalEList<?>)getColumns()).basicRemove(otherEnd, msgs);
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
			case DatabasePackage.SEQUENCE__START:
				return getStart();
			case DatabasePackage.SEQUENCE__INCREMENT:
				return getIncrement();
			case DatabasePackage.SEQUENCE__MIN_VALUE:
				return getMinValue();
			case DatabasePackage.SEQUENCE__MAX_VALUE:
				return getMaxValue();
			case DatabasePackage.SEQUENCE__CACHE_SIZE:
				return getCacheSize();
			case DatabasePackage.SEQUENCE__CYCLE:
				return isCycle();
			case DatabasePackage.SEQUENCE__COLUMNS:
				return getColumns();
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
			case DatabasePackage.SEQUENCE__START:
				setStart((BigInteger)newValue);
				return;
			case DatabasePackage.SEQUENCE__INCREMENT:
				setIncrement((BigInteger)newValue);
				return;
			case DatabasePackage.SEQUENCE__MIN_VALUE:
				setMinValue((BigInteger)newValue);
				return;
			case DatabasePackage.SEQUENCE__MAX_VALUE:
				setMaxValue((BigInteger)newValue);
				return;
			case DatabasePackage.SEQUENCE__CACHE_SIZE:
				setCacheSize((BigInteger)newValue);
				return;
			case DatabasePackage.SEQUENCE__CYCLE:
				setCycle((Boolean)newValue);
				return;
			case DatabasePackage.SEQUENCE__COLUMNS:
				getColumns().clear();
				getColumns().addAll((Collection<? extends Column>)newValue);
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
			case DatabasePackage.SEQUENCE__START:
				setStart(START_EDEFAULT);
				return;
			case DatabasePackage.SEQUENCE__INCREMENT:
				setIncrement(INCREMENT_EDEFAULT);
				return;
			case DatabasePackage.SEQUENCE__MIN_VALUE:
				setMinValue(MIN_VALUE_EDEFAULT);
				return;
			case DatabasePackage.SEQUENCE__MAX_VALUE:
				setMaxValue(MAX_VALUE_EDEFAULT);
				return;
			case DatabasePackage.SEQUENCE__CACHE_SIZE:
				setCacheSize(CACHE_SIZE_EDEFAULT);
				return;
			case DatabasePackage.SEQUENCE__CYCLE:
				setCycle(CYCLE_EDEFAULT);
				return;
			case DatabasePackage.SEQUENCE__COLUMNS:
				getColumns().clear();
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
			case DatabasePackage.SEQUENCE__START:
				return START_EDEFAULT == null ? getStart() != null : !START_EDEFAULT.equals(getStart());
			case DatabasePackage.SEQUENCE__INCREMENT:
				return INCREMENT_EDEFAULT == null ? getIncrement() != null : !INCREMENT_EDEFAULT.equals(getIncrement());
			case DatabasePackage.SEQUENCE__MIN_VALUE:
				return MIN_VALUE_EDEFAULT == null ? getMinValue() != null : !MIN_VALUE_EDEFAULT.equals(getMinValue());
			case DatabasePackage.SEQUENCE__MAX_VALUE:
				return MAX_VALUE_EDEFAULT == null ? getMaxValue() != null : !MAX_VALUE_EDEFAULT.equals(getMaxValue());
			case DatabasePackage.SEQUENCE__CACHE_SIZE:
				return CACHE_SIZE_EDEFAULT == null ? getCacheSize() != null : !CACHE_SIZE_EDEFAULT.equals(getCacheSize());
			case DatabasePackage.SEQUENCE__CYCLE:
				return isCycle() != CYCLE_EDEFAULT;
			case DatabasePackage.SEQUENCE__COLUMNS:
				return !getColumns().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SequenceImpl
