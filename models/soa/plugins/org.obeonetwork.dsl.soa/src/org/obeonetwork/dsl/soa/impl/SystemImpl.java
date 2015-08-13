/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.soa.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.NamespacesContainer;
import org.obeonetwork.dsl.environment.impl.TypesDefinitionImpl;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.dsl.soa.Wire;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.SystemImpl#getOwnedNamespaces <em>Owned Namespaces</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.SystemImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.SystemImpl#getOwnedComponents <em>Owned Components</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.SystemImpl#getOwnedWires <em>Owned Wires</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SystemImpl extends TypesDefinitionImpl implements org.obeonetwork.dsl.soa.System {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

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
	protected SystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SoaPackage.Literals.SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eDynamicGet(SoaPackage.SYSTEM__NAME, SoaPackage.Literals.SYSTEM__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eDynamicSet(SoaPackage.SYSTEM__NAME, SoaPackage.Literals.SYSTEM__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Component> getOwnedComponents() {
		return (EList<Component>)eDynamicGet(SoaPackage.SYSTEM__OWNED_COMPONENTS, SoaPackage.Literals.SYSTEM__OWNED_COMPONENTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Wire> getOwnedWires() {
		return (EList<Wire>)eDynamicGet(SoaPackage.SYSTEM__OWNED_WIRES, SoaPackage.Literals.SYSTEM__OWNED_WIRES, true, true);
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
			case SoaPackage.SYSTEM__OWNED_NAMESPACES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedNamespaces()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Namespace> getOwnedNamespaces() {
		return (EList<Namespace>)eDynamicGet(SoaPackage.SYSTEM__OWNED_NAMESPACES, EnvironmentPackage.Literals.NAMESPACES_CONTAINER__OWNED_NAMESPACES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SoaPackage.SYSTEM__OWNED_NAMESPACES:
				return ((InternalEList<?>)getOwnedNamespaces()).basicRemove(otherEnd, msgs);
			case SoaPackage.SYSTEM__OWNED_COMPONENTS:
				return ((InternalEList<?>)getOwnedComponents()).basicRemove(otherEnd, msgs);
			case SoaPackage.SYSTEM__OWNED_WIRES:
				return ((InternalEList<?>)getOwnedWires()).basicRemove(otherEnd, msgs);
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
			case SoaPackage.SYSTEM__OWNED_NAMESPACES:
				return getOwnedNamespaces();
			case SoaPackage.SYSTEM__NAME:
				return getName();
			case SoaPackage.SYSTEM__OWNED_COMPONENTS:
				return getOwnedComponents();
			case SoaPackage.SYSTEM__OWNED_WIRES:
				return getOwnedWires();
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
			case SoaPackage.SYSTEM__OWNED_NAMESPACES:
				getOwnedNamespaces().clear();
				getOwnedNamespaces().addAll((Collection<? extends Namespace>)newValue);
				return;
			case SoaPackage.SYSTEM__NAME:
				setName((String)newValue);
				return;
			case SoaPackage.SYSTEM__OWNED_COMPONENTS:
				getOwnedComponents().clear();
				getOwnedComponents().addAll((Collection<? extends Component>)newValue);
				return;
			case SoaPackage.SYSTEM__OWNED_WIRES:
				getOwnedWires().clear();
				getOwnedWires().addAll((Collection<? extends Wire>)newValue);
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
			case SoaPackage.SYSTEM__OWNED_NAMESPACES:
				getOwnedNamespaces().clear();
				return;
			case SoaPackage.SYSTEM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SoaPackage.SYSTEM__OWNED_COMPONENTS:
				getOwnedComponents().clear();
				return;
			case SoaPackage.SYSTEM__OWNED_WIRES:
				getOwnedWires().clear();
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
			case SoaPackage.SYSTEM__OWNED_NAMESPACES:
				return !getOwnedNamespaces().isEmpty();
			case SoaPackage.SYSTEM__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case SoaPackage.SYSTEM__OWNED_COMPONENTS:
				return !getOwnedComponents().isEmpty();
			case SoaPackage.SYSTEM__OWNED_WIRES:
				return !getOwnedWires().isEmpty();
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
				case SoaPackage.SYSTEM__OWNED_NAMESPACES: return EnvironmentPackage.NAMESPACES_CONTAINER__OWNED_NAMESPACES;
				default: return -1;
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
				case EnvironmentPackage.NAMESPACES_CONTAINER__OWNED_NAMESPACES: return SoaPackage.SYSTEM__OWNED_NAMESPACES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //SystemImpl