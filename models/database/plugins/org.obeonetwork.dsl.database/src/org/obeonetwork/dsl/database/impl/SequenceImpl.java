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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.Sequence;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.impl.SequenceImpl#getStart <em>Start</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.SequenceImpl#getIncrement <em>Increment</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.SequenceImpl#getMinValue <em>Min Value</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.SequenceImpl#getMaxValue <em>Max Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequenceImpl extends NamedElementImpl implements Sequence {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2011 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected static final int START_EDEFAULT = 0;
	/**
	 * The default value of the '{@link #getIncrement() <em>Increment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncrement()
	 * @generated
	 * @ordered
	 */
	protected static final int INCREMENT_EDEFAULT = 0;
	/**
	 * The default value of the '{@link #getMinValue() <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinValue()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_VALUE_EDEFAULT = 0;
	/**
	 * The default value of the '{@link #getMaxValue() <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxValue()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_VALUE_EDEFAULT = 0;
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
	public int getStart() {
		return (Integer)eDynamicGet(DatabasePackage.SEQUENCE__START, DatabasePackage.Literals.SEQUENCE__START, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStart(int newStart) {
		eDynamicSet(DatabasePackage.SEQUENCE__START, DatabasePackage.Literals.SEQUENCE__START, newStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIncrement() {
		return (Integer)eDynamicGet(DatabasePackage.SEQUENCE__INCREMENT, DatabasePackage.Literals.SEQUENCE__INCREMENT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncrement(int newIncrement) {
		eDynamicSet(DatabasePackage.SEQUENCE__INCREMENT, DatabasePackage.Literals.SEQUENCE__INCREMENT, newIncrement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMinValue() {
		return (Integer)eDynamicGet(DatabasePackage.SEQUENCE__MIN_VALUE, DatabasePackage.Literals.SEQUENCE__MIN_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinValue(int newMinValue) {
		eDynamicSet(DatabasePackage.SEQUENCE__MIN_VALUE, DatabasePackage.Literals.SEQUENCE__MIN_VALUE, newMinValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxValue() {
		return (Integer)eDynamicGet(DatabasePackage.SEQUENCE__MAX_VALUE, DatabasePackage.Literals.SEQUENCE__MAX_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxValue(int newMaxValue) {
		eDynamicSet(DatabasePackage.SEQUENCE__MAX_VALUE, DatabasePackage.Literals.SEQUENCE__MAX_VALUE, newMaxValue);
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
			case DatabasePackage.SEQUENCE__START:
				setStart((Integer)newValue);
				return;
			case DatabasePackage.SEQUENCE__INCREMENT:
				setIncrement((Integer)newValue);
				return;
			case DatabasePackage.SEQUENCE__MIN_VALUE:
				setMinValue((Integer)newValue);
				return;
			case DatabasePackage.SEQUENCE__MAX_VALUE:
				setMaxValue((Integer)newValue);
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
				return getStart() != START_EDEFAULT;
			case DatabasePackage.SEQUENCE__INCREMENT:
				return getIncrement() != INCREMENT_EDEFAULT;
			case DatabasePackage.SEQUENCE__MIN_VALUE:
				return getMinValue() != MIN_VALUE_EDEFAULT;
			case DatabasePackage.SEQUENCE__MAX_VALUE:
				return getMaxValue() != MAX_VALUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //SequenceImpl
