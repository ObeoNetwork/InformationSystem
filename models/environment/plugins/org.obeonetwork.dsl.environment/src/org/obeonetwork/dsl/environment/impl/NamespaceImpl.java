/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.NamespacesContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Namespace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.NamespaceImpl#getOwnedNamespaces <em>Owned Namespaces</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.NamespaceImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.impl.NamespaceImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NamespaceImpl extends TypesDefinitionImpl implements Namespace {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2022 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamespaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EnvironmentPackage.Literals.NAMESPACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Namespace> getOwnedNamespaces() {
		return (EList<Namespace>) eDynamicGet(EnvironmentPackage.NAMESPACE__OWNED_NAMESPACES,
				EnvironmentPackage.Literals.NAMESPACES_CONTAINER__OWNED_NAMESPACES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacesContainer getOwner() {
		return (NamespacesContainer) eDynamicGet(EnvironmentPackage.NAMESPACE__OWNER,
				EnvironmentPackage.Literals.NAMESPACE__OWNER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacesContainer basicGetOwner() {
		return (NamespacesContainer) eDynamicGet(EnvironmentPackage.NAMESPACE__OWNER,
				EnvironmentPackage.Literals.NAMESPACE__OWNER, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(NamespacesContainer newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newOwner, EnvironmentPackage.NAMESPACE__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(NamespacesContainer newOwner) {
		eDynamicSet(EnvironmentPackage.NAMESPACE__OWNER, EnvironmentPackage.Literals.NAMESPACE__OWNER, newOwner);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String) eDynamicGet(EnvironmentPackage.NAMESPACE__NAME, EnvironmentPackage.Literals.NAMESPACE__NAME,
				true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eDynamicSet(EnvironmentPackage.NAMESPACE__NAME, EnvironmentPackage.Literals.NAMESPACE__NAME, newName);
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
		case EnvironmentPackage.NAMESPACE__OWNED_NAMESPACES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOwnedNamespaces()).basicAdd(otherEnd, msgs);
		case EnvironmentPackage.NAMESPACE__OWNER:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetOwner((NamespacesContainer) otherEnd, msgs);
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
		case EnvironmentPackage.NAMESPACE__OWNED_NAMESPACES:
			return ((InternalEList<?>) getOwnedNamespaces()).basicRemove(otherEnd, msgs);
		case EnvironmentPackage.NAMESPACE__OWNER:
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
		case EnvironmentPackage.NAMESPACE__OWNER:
			return eInternalContainer().eInverseRemove(this, EnvironmentPackage.NAMESPACES_CONTAINER__OWNED_NAMESPACES,
					NamespacesContainer.class, msgs);
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
		case EnvironmentPackage.NAMESPACE__OWNED_NAMESPACES:
			return getOwnedNamespaces();
		case EnvironmentPackage.NAMESPACE__OWNER:
			if (resolve)
				return getOwner();
			return basicGetOwner();
		case EnvironmentPackage.NAMESPACE__NAME:
			return getName();
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
		case EnvironmentPackage.NAMESPACE__OWNED_NAMESPACES:
			getOwnedNamespaces().clear();
			getOwnedNamespaces().addAll((Collection<? extends Namespace>) newValue);
			return;
		case EnvironmentPackage.NAMESPACE__OWNER:
			setOwner((NamespacesContainer) newValue);
			return;
		case EnvironmentPackage.NAMESPACE__NAME:
			setName((String) newValue);
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
		case EnvironmentPackage.NAMESPACE__OWNED_NAMESPACES:
			getOwnedNamespaces().clear();
			return;
		case EnvironmentPackage.NAMESPACE__OWNER:
			setOwner((NamespacesContainer) null);
			return;
		case EnvironmentPackage.NAMESPACE__NAME:
			setName(NAME_EDEFAULT);
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
		case EnvironmentPackage.NAMESPACE__OWNED_NAMESPACES:
			return !getOwnedNamespaces().isEmpty();
		case EnvironmentPackage.NAMESPACE__OWNER:
			return basicGetOwner() != null;
		case EnvironmentPackage.NAMESPACE__NAME:
			return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == NamespacesContainer.class) {
			switch (derivedFeatureID) {
			case EnvironmentPackage.NAMESPACE__OWNED_NAMESPACES:
				return EnvironmentPackage.NAMESPACES_CONTAINER__OWNED_NAMESPACES;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == NamespacesContainer.class) {
			switch (baseFeatureID) {
			case EnvironmentPackage.NAMESPACES_CONTAINER__OWNED_NAMESPACES:
				return EnvironmentPackage.NAMESPACE__OWNED_NAMESPACES;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //NamespaceImpl
