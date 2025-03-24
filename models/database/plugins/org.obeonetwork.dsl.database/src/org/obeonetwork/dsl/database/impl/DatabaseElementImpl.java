/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.impl;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.obeonetwork.dsl.database.DatabaseElement;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.impl.DatabaseElementImpl#getID <em>ID</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.DatabaseElementImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.database.impl.DatabaseElementImpl#getTechID <em>Tech ID</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DatabaseElementImpl extends ObeoDSMObjectImpl implements DatabaseElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2025 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v2.0\r\nwhich accompanies this distribution, and is available at\r\nhttps://www.eclipse.org/legal/epl-2.0/\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getComments() <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComments()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENTS_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getTechID() <em>Tech ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTechID()
	 * @generated
	 * @ordered
	 */
	protected static final String TECH_ID_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DatabaseElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatabasePackage.Literals.DATABASE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getID() {
		((BasicEObjectImpl) eContainer()).eURIFragmentSegment(eContainingFeature(), this);
		String id = null;
		String ownId = "";
		if (eContainer() != null) {
			if (eContainer() instanceof DatabaseElement) {
				id = ((DatabaseElement)eContainer()).getID();				
			}
			ownId = ((BasicEObjectImpl) eContainer()).eURIFragmentSegment(eContainingFeature(), this);
		}
		if (id != null) {
			id += "::" + ownId;
		} else {
			id = ownId;
		}
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComments() {
		return (String)eDynamicGet(DatabasePackage.DATABASE_ELEMENT__COMMENTS, DatabasePackage.Literals.DATABASE_ELEMENT__COMMENTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComments(String newComments) {
		eDynamicSet(DatabasePackage.DATABASE_ELEMENT__COMMENTS, DatabasePackage.Literals.DATABASE_ELEMENT__COMMENTS, newComments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @deprecated
	 */
	@Deprecated
	public String getTechID() {
		return getTechnicalid();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @deprecated
	 */
	@Deprecated
	public void setTechID(String newTechID) {
		setTechnicalid(newTechID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DatabasePackage.DATABASE_ELEMENT__ID:
				return getID();
			case DatabasePackage.DATABASE_ELEMENT__COMMENTS:
				return getComments();
			case DatabasePackage.DATABASE_ELEMENT__TECH_ID:
				return getTechID();
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
			case DatabasePackage.DATABASE_ELEMENT__COMMENTS:
				setComments((String)newValue);
				return;
			case DatabasePackage.DATABASE_ELEMENT__TECH_ID:
				setTechID((String)newValue);
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
			case DatabasePackage.DATABASE_ELEMENT__COMMENTS:
				setComments(COMMENTS_EDEFAULT);
				return;
			case DatabasePackage.DATABASE_ELEMENT__TECH_ID:
				setTechID(TECH_ID_EDEFAULT);
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
			case DatabasePackage.DATABASE_ELEMENT__ID:
				return ID_EDEFAULT == null ? getID() != null : !ID_EDEFAULT.equals(getID());
			case DatabasePackage.DATABASE_ELEMENT__COMMENTS:
				return COMMENTS_EDEFAULT == null ? getComments() != null : !COMMENTS_EDEFAULT.equals(getComments());
			case DatabasePackage.DATABASE_ELEMENT__TECH_ID:
				return TECH_ID_EDEFAULT == null ? getTechID() != null : !TECH_ID_EDEFAULT.equals(getTechID());
		}
		return super.eIsSet(featureID);
	}

} //DatabaseElementImpl
