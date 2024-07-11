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

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.environment.BindingElement;
import org.obeonetwork.dsl.environment.BindingInfo;
import org.obeonetwork.dsl.environment.BindingReference;
import org.obeonetwork.dsl.environment.BoundableElement;
import org.obeonetwork.dsl.environment.EnvironmentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binding Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.BindingInfoImpl#getReferences <em>References</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.BindingInfoImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.BindingInfoImpl#getRight <em>Right</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.BindingInfoImpl#getSubBindingInfos <em>Sub Binding Infos</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.BindingInfoImpl#getTargets <em>Targets</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.BindingInfoImpl#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BindingInfoImpl extends ObeoDSMObjectImpl implements BindingInfo {
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
	protected BindingInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EnvironmentPackage.Literals.BINDING_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<BindingReference> getReferences() {
		return (EList<BindingReference>) eDynamicGet(EnvironmentPackage.BINDING_INFO__REFERENCES,
				EnvironmentPackage.Literals.BINDING_INFO__REFERENCES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BoundableElement getLeft() {
		return (BoundableElement) eDynamicGet(EnvironmentPackage.BINDING_INFO__LEFT,
				EnvironmentPackage.Literals.BINDING_INFO__LEFT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoundableElement basicGetLeft() {
		return (BoundableElement) eDynamicGet(EnvironmentPackage.BINDING_INFO__LEFT,
				EnvironmentPackage.Literals.BINDING_INFO__LEFT, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLeft(BoundableElement newLeft) {
		eDynamicSet(EnvironmentPackage.BINDING_INFO__LEFT, EnvironmentPackage.Literals.BINDING_INFO__LEFT, newLeft);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BoundableElement getRight() {
		return (BoundableElement) eDynamicGet(EnvironmentPackage.BINDING_INFO__RIGHT,
				EnvironmentPackage.Literals.BINDING_INFO__RIGHT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoundableElement basicGetRight() {
		return (BoundableElement) eDynamicGet(EnvironmentPackage.BINDING_INFO__RIGHT,
				EnvironmentPackage.Literals.BINDING_INFO__RIGHT, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRight(BoundableElement newRight) {
		eDynamicSet(EnvironmentPackage.BINDING_INFO__RIGHT, EnvironmentPackage.Literals.BINDING_INFO__RIGHT, newRight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<BindingInfo> getSubBindingInfos() {
		return (EList<BindingInfo>) eDynamicGet(EnvironmentPackage.BINDING_INFO__SUB_BINDING_INFOS,
				EnvironmentPackage.Literals.BINDING_INFO__SUB_BINDING_INFOS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<BoundableElement> getTargets() {
		EObject[] targets = new EObject[] { getLeft(), getRight() };
		return new EcoreEList.UnmodifiableEList<BoundableElement>(this,
				EnvironmentPackage.Literals.BINDING_INFO__TARGETS, 2, targets);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<BindingElement> getElements() {
		return (EList<BindingElement>) eDynamicGet(EnvironmentPackage.BINDING_INFO__ELEMENTS,
				EnvironmentPackage.Literals.BINDING_INFO__ELEMENTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EnvironmentPackage.BINDING_INFO__REFERENCES:
			return ((InternalEList<?>) getReferences()).basicRemove(otherEnd, msgs);
		case EnvironmentPackage.BINDING_INFO__ELEMENTS:
			return ((InternalEList<?>) getElements()).basicRemove(otherEnd, msgs);
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
		case EnvironmentPackage.BINDING_INFO__REFERENCES:
			return getReferences();
		case EnvironmentPackage.BINDING_INFO__LEFT:
			if (resolve)
				return getLeft();
			return basicGetLeft();
		case EnvironmentPackage.BINDING_INFO__RIGHT:
			if (resolve)
				return getRight();
			return basicGetRight();
		case EnvironmentPackage.BINDING_INFO__SUB_BINDING_INFOS:
			return getSubBindingInfos();
		case EnvironmentPackage.BINDING_INFO__TARGETS:
			return getTargets();
		case EnvironmentPackage.BINDING_INFO__ELEMENTS:
			return getElements();
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
		case EnvironmentPackage.BINDING_INFO__REFERENCES:
			getReferences().clear();
			getReferences().addAll((Collection<? extends BindingReference>) newValue);
			return;
		case EnvironmentPackage.BINDING_INFO__LEFT:
			setLeft((BoundableElement) newValue);
			return;
		case EnvironmentPackage.BINDING_INFO__RIGHT:
			setRight((BoundableElement) newValue);
			return;
		case EnvironmentPackage.BINDING_INFO__SUB_BINDING_INFOS:
			getSubBindingInfos().clear();
			getSubBindingInfos().addAll((Collection<? extends BindingInfo>) newValue);
			return;
		case EnvironmentPackage.BINDING_INFO__ELEMENTS:
			getElements().clear();
			getElements().addAll((Collection<? extends BindingElement>) newValue);
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
		case EnvironmentPackage.BINDING_INFO__REFERENCES:
			getReferences().clear();
			return;
		case EnvironmentPackage.BINDING_INFO__LEFT:
			setLeft((BoundableElement) null);
			return;
		case EnvironmentPackage.BINDING_INFO__RIGHT:
			setRight((BoundableElement) null);
			return;
		case EnvironmentPackage.BINDING_INFO__SUB_BINDING_INFOS:
			getSubBindingInfos().clear();
			return;
		case EnvironmentPackage.BINDING_INFO__ELEMENTS:
			getElements().clear();
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
		case EnvironmentPackage.BINDING_INFO__REFERENCES:
			return !getReferences().isEmpty();
		case EnvironmentPackage.BINDING_INFO__LEFT:
			return basicGetLeft() != null;
		case EnvironmentPackage.BINDING_INFO__RIGHT:
			return basicGetRight() != null;
		case EnvironmentPackage.BINDING_INFO__SUB_BINDING_INFOS:
			return !getSubBindingInfos().isEmpty();
		case EnvironmentPackage.BINDING_INFO__TARGETS:
			return !getTargets().isEmpty();
		case EnvironmentPackage.BINDING_INFO__ELEMENTS:
			return !getElements().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BindingInfoImpl
