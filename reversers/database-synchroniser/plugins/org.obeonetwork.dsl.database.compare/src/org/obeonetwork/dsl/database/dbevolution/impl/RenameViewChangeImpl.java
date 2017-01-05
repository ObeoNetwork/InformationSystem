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
/**
 */
package org.obeonetwork.dsl.database.dbevolution.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.obeonetwork.dsl.database.View;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage;
import org.obeonetwork.dsl.database.dbevolution.RenameViewChange;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rename View Change</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.dbevolution.impl.RenameViewChangeImpl#getNewView <em>New View</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RenameViewChangeImpl extends ViewChangeImpl implements RenameViewChange {
	/**
	 * The cached value of the '{@link #getNewView() <em>New View</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewView()
	 * @generated
	 * @ordered
	 */
	protected View newView;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RenameViewChangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DbevolutionPackage.Literals.RENAME_VIEW_CHANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public View getNewView() {
		if (newView != null && ((EObject)newView).eIsProxy()) {
			InternalEObject oldNewView = (InternalEObject)newView;
			newView = (View)eResolveProxy(oldNewView);
			if (newView != oldNewView) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DbevolutionPackage.RENAME_VIEW_CHANGE__NEW_VIEW, oldNewView, newView));
			}
		}
		return newView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public View basicGetNewView() {
		return newView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewView(View newNewView) {
		View oldNewView = newView;
		newView = newNewView;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbevolutionPackage.RENAME_VIEW_CHANGE__NEW_VIEW, oldNewView, newView));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DbevolutionPackage.RENAME_VIEW_CHANGE__NEW_VIEW:
				if (resolve) return getNewView();
				return basicGetNewView();
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
			case DbevolutionPackage.RENAME_VIEW_CHANGE__NEW_VIEW:
				setNewView((View)newValue);
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
			case DbevolutionPackage.RENAME_VIEW_CHANGE__NEW_VIEW:
				setNewView((View)null);
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
			case DbevolutionPackage.RENAME_VIEW_CHANGE__NEW_VIEW:
				return newView != null;
		}
		return super.eIsSet(featureID);
	}

} //RenameViewChangeImpl
