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
package org.obeonetwork.dsl.environment.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.obeonetwork.dsl.environment.BindingElement;
import org.obeonetwork.dsl.environment.BindingReference;
import org.obeonetwork.dsl.environment.EnvironmentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binding Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.BindingReferenceImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.BindingReferenceImpl#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BindingReferenceImpl extends ObeoDSMObjectImpl implements BindingReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2024 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BindingReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EnvironmentPackage.Literals.BINDING_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingElement getLeft() {
		return (BindingElement) eDynamicGet(EnvironmentPackage.BINDING_REFERENCE__LEFT,
				EnvironmentPackage.Literals.BINDING_REFERENCE__LEFT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingElement basicGetLeft() {
		return (BindingElement) eDynamicGet(EnvironmentPackage.BINDING_REFERENCE__LEFT,
				EnvironmentPackage.Literals.BINDING_REFERENCE__LEFT, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeft(BindingElement newLeft, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject) newLeft, EnvironmentPackage.BINDING_REFERENCE__LEFT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeft(BindingElement newLeft) {
		eDynamicSet(EnvironmentPackage.BINDING_REFERENCE__LEFT, EnvironmentPackage.Literals.BINDING_REFERENCE__LEFT,
				newLeft);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingElement getRight() {
		return (BindingElement) eDynamicGet(EnvironmentPackage.BINDING_REFERENCE__RIGHT,
				EnvironmentPackage.Literals.BINDING_REFERENCE__RIGHT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingElement basicGetRight() {
		return (BindingElement) eDynamicGet(EnvironmentPackage.BINDING_REFERENCE__RIGHT,
				EnvironmentPackage.Literals.BINDING_REFERENCE__RIGHT, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRight(BindingElement newRight, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject) newRight, EnvironmentPackage.BINDING_REFERENCE__RIGHT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRight(BindingElement newRight) {
		eDynamicSet(EnvironmentPackage.BINDING_REFERENCE__RIGHT, EnvironmentPackage.Literals.BINDING_REFERENCE__RIGHT,
				newRight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public BindingElement getOppositeBindingElement(BindingElement bindingElement) {
		if (getLeft().equals(bindingElement)) {
			return getRight();
		} else if (getRight().equals(bindingElement)) {
			return getLeft();
		}
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EnvironmentPackage.BINDING_REFERENCE__LEFT:
			BindingElement left = basicGetLeft();
			if (left != null)
				msgs = ((InternalEObject) left).eInverseRemove(this,
						EnvironmentPackage.BINDING_ELEMENT__REFERENCED_BY_AS_LEFT, BindingElement.class, msgs);
			return basicSetLeft((BindingElement) otherEnd, msgs);
		case EnvironmentPackage.BINDING_REFERENCE__RIGHT:
			BindingElement right = basicGetRight();
			if (right != null)
				msgs = ((InternalEObject) right).eInverseRemove(this,
						EnvironmentPackage.BINDING_ELEMENT__REFERENCED_BY_AS_RIGHT, BindingElement.class, msgs);
			return basicSetRight((BindingElement) otherEnd, msgs);
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
		case EnvironmentPackage.BINDING_REFERENCE__LEFT:
			return basicSetLeft(null, msgs);
		case EnvironmentPackage.BINDING_REFERENCE__RIGHT:
			return basicSetRight(null, msgs);
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
		case EnvironmentPackage.BINDING_REFERENCE__LEFT:
			if (resolve)
				return getLeft();
			return basicGetLeft();
		case EnvironmentPackage.BINDING_REFERENCE__RIGHT:
			if (resolve)
				return getRight();
			return basicGetRight();
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
		case EnvironmentPackage.BINDING_REFERENCE__LEFT:
			setLeft((BindingElement) newValue);
			return;
		case EnvironmentPackage.BINDING_REFERENCE__RIGHT:
			setRight((BindingElement) newValue);
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
		case EnvironmentPackage.BINDING_REFERENCE__LEFT:
			setLeft((BindingElement) null);
			return;
		case EnvironmentPackage.BINDING_REFERENCE__RIGHT:
			setRight((BindingElement) null);
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
		case EnvironmentPackage.BINDING_REFERENCE__LEFT:
			return basicGetLeft() != null;
		case EnvironmentPackage.BINDING_REFERENCE__RIGHT:
			return basicGetRight() != null;
		}
		return super.eIsSet(featureID);
	}

} //BindingReferenceImpl
