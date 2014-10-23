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
import org.obeonetwork.dsl.environment.Namespace;
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
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.SystemImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.SystemImpl#getOwnedComponents <em>Owned Components</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.SystemImpl#getOwnedWires <em>Owned Wires</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.SystemImpl#getNamespaces <em>Namespaces</em>}</li>
 * </ul>
 * </p>
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
	public EList<Namespace> getNamespaces() {
		return (EList<Namespace>)eDynamicGet(SoaPackage.SYSTEM__NAMESPACES, SoaPackage.Literals.SYSTEM__NAMESPACES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SoaPackage.SYSTEM__OWNED_COMPONENTS:
				return ((InternalEList<?>)getOwnedComponents()).basicRemove(otherEnd, msgs);
			case SoaPackage.SYSTEM__OWNED_WIRES:
				return ((InternalEList<?>)getOwnedWires()).basicRemove(otherEnd, msgs);
			case SoaPackage.SYSTEM__NAMESPACES:
				return ((InternalEList<?>)getNamespaces()).basicRemove(otherEnd, msgs);
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
			case SoaPackage.SYSTEM__NAME:
				return getName();
			case SoaPackage.SYSTEM__OWNED_COMPONENTS:
				return getOwnedComponents();
			case SoaPackage.SYSTEM__OWNED_WIRES:
				return getOwnedWires();
			case SoaPackage.SYSTEM__NAMESPACES:
				return getNamespaces();
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
			case SoaPackage.SYSTEM__NAMESPACES:
				getNamespaces().clear();
				getNamespaces().addAll((Collection<? extends Namespace>)newValue);
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
			case SoaPackage.SYSTEM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SoaPackage.SYSTEM__OWNED_COMPONENTS:
				getOwnedComponents().clear();
				return;
			case SoaPackage.SYSTEM__OWNED_WIRES:
				getOwnedWires().clear();
				return;
			case SoaPackage.SYSTEM__NAMESPACES:
				getNamespaces().clear();
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
			case SoaPackage.SYSTEM__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case SoaPackage.SYSTEM__OWNED_COMPONENTS:
				return !getOwnedComponents().isEmpty();
			case SoaPackage.SYSTEM__OWNED_WIRES:
				return !getOwnedWires().isEmpty();
			case SoaPackage.SYSTEM__NAMESPACES:
				return !getNamespaces().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SystemImpl