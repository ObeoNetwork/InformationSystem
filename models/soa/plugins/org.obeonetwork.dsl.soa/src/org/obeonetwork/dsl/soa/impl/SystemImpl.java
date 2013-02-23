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
	 * The cached value of the '{@link #getOwnedComponents() <em>Owned Components</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<Component> ownedComponents;
	/**
	 * The cached value of the '{@link #getOwnedWires() <em>Owned Wires</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedWires()
	 * @generated
	 * @ordered
	 */
	protected EList<Wire> ownedWires;
	/**
	 * The cached value of the '{@link #getOwnedDtoRegistry() <em>Owned Dto Registry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDtoRegistry()
	 * @generated
	 * @ordered
	 */
	protected DTORegistry ownedDtoRegistry;

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
		if (ownedComponents == null) {
			ownedComponents = new EObjectContainmentEList.Resolving<Component>(Component.class, this, SoaPackage.SYSTEM__OWNED_COMPONENTS);
		}
		return ownedComponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Wire> getOwnedWires() {
		if (ownedWires == null) {
			ownedWires = new EObjectContainmentEList.Resolving<Wire>(Wire.class, this, SoaPackage.SYSTEM__OWNED_WIRES);
		}
		return ownedWires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DTORegistry getOwnedDtoRegistry() {
		if (ownedDtoRegistry != null && ownedDtoRegistry.eIsProxy()) {
			InternalEObject oldOwnedDtoRegistry = (InternalEObject)ownedDtoRegistry;
			ownedDtoRegistry = (DTORegistry)eResolveProxy(oldOwnedDtoRegistry);
			if (ownedDtoRegistry != oldOwnedDtoRegistry) {
				InternalEObject newOwnedDtoRegistry = (InternalEObject)ownedDtoRegistry;
				NotificationChain msgs = oldOwnedDtoRegistry.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SoaPackage.SYSTEM__OWNED_DTO_REGISTRY, null, null);
				if (newOwnedDtoRegistry.eInternalContainer() == null) {
					msgs = newOwnedDtoRegistry.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SoaPackage.SYSTEM__OWNED_DTO_REGISTRY, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SoaPackage.SYSTEM__OWNED_DTO_REGISTRY, oldOwnedDtoRegistry, ownedDtoRegistry));
			}
		}
		return ownedDtoRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DTORegistry basicGetOwnedDtoRegistry() {
		return ownedDtoRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedDtoRegistry(DTORegistry newOwnedDtoRegistry, NotificationChain msgs) {
		DTORegistry oldOwnedDtoRegistry = ownedDtoRegistry;
		ownedDtoRegistry = newOwnedDtoRegistry;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SoaPackage.SYSTEM__OWNED_DTO_REGISTRY, oldOwnedDtoRegistry, newOwnedDtoRegistry);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedDtoRegistry(DTORegistry newOwnedDtoRegistry) {
		if (newOwnedDtoRegistry != ownedDtoRegistry) {
			NotificationChain msgs = null;
			if (ownedDtoRegistry != null)
				msgs = ((InternalEObject)ownedDtoRegistry).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SoaPackage.SYSTEM__OWNED_DTO_REGISTRY, null, msgs);
			if (newOwnedDtoRegistry != null)
				msgs = ((InternalEObject)newOwnedDtoRegistry).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SoaPackage.SYSTEM__OWNED_DTO_REGISTRY, null, msgs);
			msgs = basicSetOwnedDtoRegistry(newOwnedDtoRegistry, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SoaPackage.SYSTEM__OWNED_DTO_REGISTRY, newOwnedDtoRegistry, newOwnedDtoRegistry));
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
				return ownedComponents != null && !ownedComponents.isEmpty();
			case SoaPackage.SYSTEM__OWNED_WIRES:
				return ownedWires != null && !ownedWires.isEmpty();
			case SoaPackage.SYSTEM__OWNED_DTO_REGISTRY:
				return ownedDtoRegistry != null;
		}
		return super.eIsSet(featureID);
	}

} //SystemImpl