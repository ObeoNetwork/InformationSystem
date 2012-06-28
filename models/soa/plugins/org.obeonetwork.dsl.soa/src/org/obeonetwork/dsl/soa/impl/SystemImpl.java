/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.soa.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.environment.impl.NamespaceImpl;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.DTORegistry;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.dsl.soa.Wire;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.SystemImpl#getOwnedComponents <em>Owned Components</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.SystemImpl#getOwnedWires <em>Owned Wires</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.SystemImpl#getOwnedDtoRegistry <em>Owned Dto Registry</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemImpl extends NamespaceImpl implements org.obeonetwork.dsl.soa.System {
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
	public DTORegistry getOwnedDtoRegistry() {
		return (DTORegistry)eDynamicGet(SoaPackage.SYSTEM__OWNED_DTO_REGISTRY, SoaPackage.Literals.SYSTEM__OWNED_DTO_REGISTRY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DTORegistry basicGetOwnedDtoRegistry() {
		return (DTORegistry)eDynamicGet(SoaPackage.SYSTEM__OWNED_DTO_REGISTRY, SoaPackage.Literals.SYSTEM__OWNED_DTO_REGISTRY, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedDtoRegistry(DTORegistry newOwnedDtoRegistry, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newOwnedDtoRegistry, SoaPackage.SYSTEM__OWNED_DTO_REGISTRY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedDtoRegistry(DTORegistry newOwnedDtoRegistry) {
		eDynamicSet(SoaPackage.SYSTEM__OWNED_DTO_REGISTRY, SoaPackage.Literals.SYSTEM__OWNED_DTO_REGISTRY, newOwnedDtoRegistry);
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
			case SoaPackage.SYSTEM__OWNED_DTO_REGISTRY:
				return basicSetOwnedDtoRegistry(null, msgs);
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
			case SoaPackage.SYSTEM__OWNED_COMPONENTS:
				return getOwnedComponents();
			case SoaPackage.SYSTEM__OWNED_WIRES:
				return getOwnedWires();
			case SoaPackage.SYSTEM__OWNED_DTO_REGISTRY:
				if (resolve) return getOwnedDtoRegistry();
				return basicGetOwnedDtoRegistry();
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
			case SoaPackage.SYSTEM__OWNED_COMPONENTS:
				getOwnedComponents().clear();
				getOwnedComponents().addAll((Collection<? extends Component>)newValue);
				return;
			case SoaPackage.SYSTEM__OWNED_WIRES:
				getOwnedWires().clear();
				getOwnedWires().addAll((Collection<? extends Wire>)newValue);
				return;
			case SoaPackage.SYSTEM__OWNED_DTO_REGISTRY:
				setOwnedDtoRegistry((DTORegistry)newValue);
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
			case SoaPackage.SYSTEM__OWNED_COMPONENTS:
				getOwnedComponents().clear();
				return;
			case SoaPackage.SYSTEM__OWNED_WIRES:
				getOwnedWires().clear();
				return;
			case SoaPackage.SYSTEM__OWNED_DTO_REGISTRY:
				setOwnedDtoRegistry((DTORegistry)null);
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
			case SoaPackage.SYSTEM__OWNED_COMPONENTS:
				return !getOwnedComponents().isEmpty();
			case SoaPackage.SYSTEM__OWNED_WIRES:
				return !getOwnedWires().isEmpty();
			case SoaPackage.SYSTEM__OWNED_DTO_REGISTRY:
				return basicGetOwnedDtoRegistry() != null;
		}
		return super.eIsSet(featureID);
	}

} //SystemImpl