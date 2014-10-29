/**
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.environment.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.obeonetwork.dsl.environment.DTO;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.FilterContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DTO</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.DTOImpl#getOwnedContainer <em>Owned Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DTOImpl extends StructuredTypeImpl implements DTO {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DTOImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EnvironmentPackage.Literals.DTO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterContainer getOwnedContainer() {
		return (FilterContainer) eDynamicGet(
				EnvironmentPackage.DTO__OWNED_CONTAINER,
				EnvironmentPackage.Literals.DTO__OWNED_CONTAINER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterContainer basicGetOwnedContainer() {
		return (FilterContainer) eDynamicGet(
				EnvironmentPackage.DTO__OWNED_CONTAINER,
				EnvironmentPackage.Literals.DTO__OWNED_CONTAINER, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedContainer(
			FilterContainer newOwnedContainer, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject) newOwnedContainer,
				EnvironmentPackage.DTO__OWNED_CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedContainer(FilterContainer newOwnedContainer) {
		eDynamicSet(EnvironmentPackage.DTO__OWNED_CONTAINER,
				EnvironmentPackage.Literals.DTO__OWNED_CONTAINER,
				newOwnedContainer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EnvironmentPackage.DTO__OWNED_CONTAINER:
			return basicSetOwnedContainer(null, msgs);
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
		case EnvironmentPackage.DTO__OWNED_CONTAINER:
			if (resolve)
				return getOwnedContainer();
			return basicGetOwnedContainer();
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
		case EnvironmentPackage.DTO__OWNED_CONTAINER:
			setOwnedContainer((FilterContainer) newValue);
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
		case EnvironmentPackage.DTO__OWNED_CONTAINER:
			setOwnedContainer((FilterContainer) null);
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
		case EnvironmentPackage.DTO__OWNED_CONTAINER:
			return basicGetOwnedContainer() != null;
		}
		return super.eIsSet(featureID);
	}

} //DTOImpl
