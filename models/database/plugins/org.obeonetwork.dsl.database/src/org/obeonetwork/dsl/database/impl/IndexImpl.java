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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.Index;
import org.obeonetwork.dsl.database.IndexElement;
import org.obeonetwork.dsl.database.Table;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Index</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.impl.IndexImpl#getQualifier <em>Qualifier</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.IndexImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.IndexImpl#isUnique <em>Unique</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.IndexImpl#getCardinality <em>Cardinality</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.IndexImpl#getIndexType <em>Index Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.IndexImpl#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IndexImpl extends NamedElementImpl implements Index {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2011 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getQualifier() <em>Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifier()
	 * @generated
	 * @ordered
	 */
	protected static final String QUALIFIER_EDEFAULT = null;
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
	 * The default value of the '{@link #getCardinality() <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCardinality()
	 * @generated
	 * @ordered
	 */
	protected static final int CARDINALITY_EDEFAULT = 0;
	/**
	 * The default value of the '{@link #getIndexType() <em>Index Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexType()
	 * @generated
	 * @ordered
	 */
	protected static final String INDEX_TYPE_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IndexImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatabasePackage.Literals.INDEX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQualifier() {
		return (String)eDynamicGet(DatabasePackage.INDEX__QUALIFIER, DatabasePackage.Literals.INDEX__QUALIFIER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualifier(String newQualifier) {
		eDynamicSet(DatabasePackage.INDEX__QUALIFIER, DatabasePackage.Literals.INDEX__QUALIFIER, newQualifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IndexElement> getElements() {
		return (EList<IndexElement>)eDynamicGet(DatabasePackage.INDEX__ELEMENTS, DatabasePackage.Literals.INDEX__ELEMENTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUnique() {
		return (Boolean)eDynamicGet(DatabasePackage.INDEX__UNIQUE, DatabasePackage.Literals.INDEX__UNIQUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnique(boolean newUnique) {
		eDynamicSet(DatabasePackage.INDEX__UNIQUE, DatabasePackage.Literals.INDEX__UNIQUE, newUnique);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCardinality() {
		return (Integer)eDynamicGet(DatabasePackage.INDEX__CARDINALITY, DatabasePackage.Literals.INDEX__CARDINALITY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCardinality(int newCardinality) {
		eDynamicSet(DatabasePackage.INDEX__CARDINALITY, DatabasePackage.Literals.INDEX__CARDINALITY, newCardinality);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIndexType() {
		return (String)eDynamicGet(DatabasePackage.INDEX__INDEX_TYPE, DatabasePackage.Literals.INDEX__INDEX_TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndexType(String newIndexType) {
		eDynamicSet(DatabasePackage.INDEX__INDEX_TYPE, DatabasePackage.Literals.INDEX__INDEX_TYPE, newIndexType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table getOwner() {
		return (Table)eDynamicGet(DatabasePackage.INDEX__OWNER, DatabasePackage.Literals.INDEX__OWNER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(Table newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, DatabasePackage.INDEX__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Table newOwner) {
		eDynamicSet(DatabasePackage.INDEX__OWNER, DatabasePackage.Literals.INDEX__OWNER, newOwner);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DatabasePackage.INDEX__OWNER:
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
			case DatabasePackage.INDEX__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
			case DatabasePackage.INDEX__OWNER:
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
			case DatabasePackage.INDEX__OWNER:
				return eInternalContainer().eInverseRemove(this, DatabasePackage.TABLE__INDEXES, Table.class, msgs);
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
			case DatabasePackage.INDEX__QUALIFIER:
				return getQualifier();
			case DatabasePackage.INDEX__ELEMENTS:
				return getElements();
			case DatabasePackage.INDEX__UNIQUE:
				return isUnique();
			case DatabasePackage.INDEX__CARDINALITY:
				return getCardinality();
			case DatabasePackage.INDEX__INDEX_TYPE:
				return getIndexType();
			case DatabasePackage.INDEX__OWNER:
				return getOwner();
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
			case DatabasePackage.INDEX__QUALIFIER:
				setQualifier((String)newValue);
				return;
			case DatabasePackage.INDEX__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends IndexElement>)newValue);
				return;
			case DatabasePackage.INDEX__UNIQUE:
				setUnique((Boolean)newValue);
				return;
			case DatabasePackage.INDEX__CARDINALITY:
				setCardinality((Integer)newValue);
				return;
			case DatabasePackage.INDEX__INDEX_TYPE:
				setIndexType((String)newValue);
				return;
			case DatabasePackage.INDEX__OWNER:
				setOwner((Table)newValue);
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
			case DatabasePackage.INDEX__QUALIFIER:
				setQualifier(QUALIFIER_EDEFAULT);
				return;
			case DatabasePackage.INDEX__ELEMENTS:
				getElements().clear();
				return;
			case DatabasePackage.INDEX__UNIQUE:
				setUnique(UNIQUE_EDEFAULT);
				return;
			case DatabasePackage.INDEX__CARDINALITY:
				setCardinality(CARDINALITY_EDEFAULT);
				return;
			case DatabasePackage.INDEX__INDEX_TYPE:
				setIndexType(INDEX_TYPE_EDEFAULT);
				return;
			case DatabasePackage.INDEX__OWNER:
				setOwner((Table)null);
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
			case DatabasePackage.INDEX__QUALIFIER:
				return QUALIFIER_EDEFAULT == null ? getQualifier() != null : !QUALIFIER_EDEFAULT.equals(getQualifier());
			case DatabasePackage.INDEX__ELEMENTS:
				return !getElements().isEmpty();
			case DatabasePackage.INDEX__UNIQUE:
				return isUnique() != UNIQUE_EDEFAULT;
			case DatabasePackage.INDEX__CARDINALITY:
				return getCardinality() != CARDINALITY_EDEFAULT;
			case DatabasePackage.INDEX__INDEX_TYPE:
				return INDEX_TYPE_EDEFAULT == null ? getIndexType() != null : !INDEX_TYPE_EDEFAULT.equals(getIndexType());
			case DatabasePackage.INDEX__OWNER:
				return getOwner() != null;
		}
		return super.eIsSet(featureID);
	}

} //IndexImpl
