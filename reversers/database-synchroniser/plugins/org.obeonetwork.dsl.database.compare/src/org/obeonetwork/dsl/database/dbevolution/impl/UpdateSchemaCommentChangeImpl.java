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
import org.obeonetwork.dsl.database.Schema;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage;
import org.obeonetwork.dsl.database.dbevolution.UpdateSchemaCommentChange;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Update Schema Comment Change</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.dbevolution.impl.UpdateSchemaCommentChangeImpl#getNewSchema <em>New Schema</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UpdateSchemaCommentChangeImpl extends SchemaChangeImpl implements UpdateSchemaCommentChange {
	/**
	 * The cached value of the '{@link #getNewSchema() <em>New Schema</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewSchema()
	 * @generated
	 * @ordered
	 */
	protected Schema newSchema;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UpdateSchemaCommentChangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DbevolutionPackage.Literals.UPDATE_SCHEMA_COMMENT_CHANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Schema getNewSchema() {
		if (newSchema != null && ((EObject)newSchema).eIsProxy()) {
			InternalEObject oldNewSchema = (InternalEObject)newSchema;
			newSchema = (Schema)eResolveProxy(oldNewSchema);
			if (newSchema != oldNewSchema) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DbevolutionPackage.UPDATE_SCHEMA_COMMENT_CHANGE__NEW_SCHEMA, oldNewSchema, newSchema));
			}
		}
		return newSchema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Schema basicGetNewSchema() {
		return newSchema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewSchema(Schema newNewSchema) {
		Schema oldNewSchema = newSchema;
		newSchema = newNewSchema;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbevolutionPackage.UPDATE_SCHEMA_COMMENT_CHANGE__NEW_SCHEMA, oldNewSchema, newSchema));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DbevolutionPackage.UPDATE_SCHEMA_COMMENT_CHANGE__NEW_SCHEMA:
				if (resolve) return getNewSchema();
				return basicGetNewSchema();
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
			case DbevolutionPackage.UPDATE_SCHEMA_COMMENT_CHANGE__NEW_SCHEMA:
				setNewSchema((Schema)newValue);
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
			case DbevolutionPackage.UPDATE_SCHEMA_COMMENT_CHANGE__NEW_SCHEMA:
				setNewSchema((Schema)null);
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
			case DbevolutionPackage.UPDATE_SCHEMA_COMMENT_CHANGE__NEW_SCHEMA:
				return newSchema != null;
		}
		return super.eIsSet(featureID);
	}

} //UpdateSchemaCommentChangeImpl
