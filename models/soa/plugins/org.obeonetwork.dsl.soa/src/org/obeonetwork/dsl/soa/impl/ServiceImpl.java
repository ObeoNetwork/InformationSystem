/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.soa.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl;
import org.obeonetwork.dsl.soa.Binding;
import org.obeonetwork.dsl.soa.Interface;
import org.obeonetwork.dsl.soa.InterfaceKind;
import org.obeonetwork.dsl.soa.Service;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.dsl.soa.SynchronizationKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ServiceImpl#getOwnedInterface <em>Owned Interface</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ServiceImpl#getSynchronization <em>Synchronization</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ServiceImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ServiceImpl#getReferencedInterface <em>Referenced Interface</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ServiceImpl#getBindings <em>Bindings</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ServiceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ServiceImpl#getUsedTypes <em>Used Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceImpl extends ObeoDSMObjectImpl implements Service {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * The cached value of the '{@link #getOwnedInterface() <em>Owned Interface</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedInterface()
	 * @generated
	 * @ordered
	 */
	protected Interface ownedInterface;

	/**
	 * The default value of the '{@link #getSynchronization() <em>Synchronization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSynchronization()
	 * @generated
	 * @ordered
	 */
	protected static final SynchronizationKind SYNCHRONIZATION_EDEFAULT = SynchronizationKind.SYNCHONE_LITERAL;
	/**
	 * The cached value of the '{@link #getSynchronization() <em>Synchronization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSynchronization()
	 * @generated
	 * @ordered
	 */
	protected SynchronizationKind synchronization = SYNCHRONIZATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final InterfaceKind KIND_EDEFAULT = InterfaceKind.PROVIDED_LITERAL;
	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected InterfaceKind kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferencedInterface() <em>Referenced Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedInterface()
	 * @generated
	 * @ordered
	 */
	protected Interface referencedInterface;

	/**
	 * The cached value of the '{@link #getBindings() <em>Bindings</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindings()
	 * @generated
	 * @ordered
	 */
	protected Binding bindings;

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
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUsedTypes() <em>Used Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> usedTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SoaPackage.Literals.SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface getOwnedInterface() {
		if (ownedInterface != null && ownedInterface.eIsProxy()) {
			InternalEObject oldOwnedInterface = (InternalEObject)ownedInterface;
			ownedInterface = (Interface)eResolveProxy(oldOwnedInterface);
			if (ownedInterface != oldOwnedInterface) {
				InternalEObject newOwnedInterface = (InternalEObject)ownedInterface;
				NotificationChain msgs = oldOwnedInterface.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SoaPackage.SERVICE__OWNED_INTERFACE, null, null);
				if (newOwnedInterface.eInternalContainer() == null) {
					msgs = newOwnedInterface.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SoaPackage.SERVICE__OWNED_INTERFACE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SoaPackage.SERVICE__OWNED_INTERFACE, oldOwnedInterface, ownedInterface));
			}
		}
		return ownedInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface basicGetOwnedInterface() {
		return ownedInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedInterface(Interface newOwnedInterface, NotificationChain msgs) {
		Interface oldOwnedInterface = ownedInterface;
		ownedInterface = newOwnedInterface;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SoaPackage.SERVICE__OWNED_INTERFACE, oldOwnedInterface, newOwnedInterface);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedInterface(Interface newOwnedInterface) {
		if (newOwnedInterface != ownedInterface) {
			NotificationChain msgs = null;
			if (ownedInterface != null)
				msgs = ((InternalEObject)ownedInterface).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SoaPackage.SERVICE__OWNED_INTERFACE, null, msgs);
			if (newOwnedInterface != null)
				msgs = ((InternalEObject)newOwnedInterface).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SoaPackage.SERVICE__OWNED_INTERFACE, null, msgs);
			msgs = basicSetOwnedInterface(newOwnedInterface, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SoaPackage.SERVICE__OWNED_INTERFACE, newOwnedInterface, newOwnedInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SynchronizationKind getSynchronization() {
		return synchronization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSynchronization(SynchronizationKind newSynchronization) {
		SynchronizationKind oldSynchronization = synchronization;
		synchronization = newSynchronization == null ? SYNCHRONIZATION_EDEFAULT : newSynchronization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SoaPackage.SERVICE__SYNCHRONIZATION, oldSynchronization, synchronization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(InterfaceKind newKind) {
		InterfaceKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SoaPackage.SERVICE__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface getReferencedInterface() {
		if (referencedInterface != null && referencedInterface.eIsProxy()) {
			InternalEObject oldReferencedInterface = (InternalEObject)referencedInterface;
			referencedInterface = (Interface)eResolveProxy(oldReferencedInterface);
			if (referencedInterface != oldReferencedInterface) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SoaPackage.SERVICE__REFERENCED_INTERFACE, oldReferencedInterface, referencedInterface));
			}
		}
		return referencedInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface basicGetReferencedInterface() {
		return referencedInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedInterface(Interface newReferencedInterface) {
		Interface oldReferencedInterface = referencedInterface;
		referencedInterface = newReferencedInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SoaPackage.SERVICE__REFERENCED_INTERFACE, oldReferencedInterface, referencedInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Binding getBindings() {
		if (bindings != null && bindings.eIsProxy()) {
			InternalEObject oldBindings = (InternalEObject)bindings;
			bindings = (Binding)eResolveProxy(oldBindings);
			if (bindings != oldBindings) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SoaPackage.SERVICE__BINDINGS, oldBindings, bindings));
			}
		}
		return bindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Binding basicGetBindings() {
		return bindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBindings(Binding newBindings) {
		Binding oldBindings = bindings;
		bindings = newBindings;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SoaPackage.SERVICE__BINDINGS, oldBindings, bindings));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SoaPackage.SERVICE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Type> getUsedTypes() {
		if (usedTypes == null) {
			usedTypes = new EObjectResolvingEList<Type>(Type.class, this, SoaPackage.SERVICE__USED_TYPES);
		}
		return usedTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SoaPackage.SERVICE__OWNED_INTERFACE:
				return basicSetOwnedInterface(null, msgs);
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
			case SoaPackage.SERVICE__OWNED_INTERFACE:
				if (resolve) return getOwnedInterface();
				return basicGetOwnedInterface();
			case SoaPackage.SERVICE__SYNCHRONIZATION:
				return getSynchronization();
			case SoaPackage.SERVICE__KIND:
				return getKind();
			case SoaPackage.SERVICE__REFERENCED_INTERFACE:
				if (resolve) return getReferencedInterface();
				return basicGetReferencedInterface();
			case SoaPackage.SERVICE__BINDINGS:
				if (resolve) return getBindings();
				return basicGetBindings();
			case SoaPackage.SERVICE__NAME:
				return getName();
			case SoaPackage.SERVICE__USED_TYPES:
				return getUsedTypes();
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
			case SoaPackage.SERVICE__OWNED_INTERFACE:
				setOwnedInterface((Interface)newValue);
				return;
			case SoaPackage.SERVICE__SYNCHRONIZATION:
				setSynchronization((SynchronizationKind)newValue);
				return;
			case SoaPackage.SERVICE__KIND:
				setKind((InterfaceKind)newValue);
				return;
			case SoaPackage.SERVICE__REFERENCED_INTERFACE:
				setReferencedInterface((Interface)newValue);
				return;
			case SoaPackage.SERVICE__BINDINGS:
				setBindings((Binding)newValue);
				return;
			case SoaPackage.SERVICE__NAME:
				setName((String)newValue);
				return;
			case SoaPackage.SERVICE__USED_TYPES:
				getUsedTypes().clear();
				getUsedTypes().addAll((Collection<? extends Type>)newValue);
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
			case SoaPackage.SERVICE__OWNED_INTERFACE:
				setOwnedInterface((Interface)null);
				return;
			case SoaPackage.SERVICE__SYNCHRONIZATION:
				setSynchronization(SYNCHRONIZATION_EDEFAULT);
				return;
			case SoaPackage.SERVICE__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case SoaPackage.SERVICE__REFERENCED_INTERFACE:
				setReferencedInterface((Interface)null);
				return;
			case SoaPackage.SERVICE__BINDINGS:
				setBindings((Binding)null);
				return;
			case SoaPackage.SERVICE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SoaPackage.SERVICE__USED_TYPES:
				getUsedTypes().clear();
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
			case SoaPackage.SERVICE__OWNED_INTERFACE:
				return ownedInterface != null;
			case SoaPackage.SERVICE__SYNCHRONIZATION:
				return synchronization != SYNCHRONIZATION_EDEFAULT;
			case SoaPackage.SERVICE__KIND:
				return kind != KIND_EDEFAULT;
			case SoaPackage.SERVICE__REFERENCED_INTERFACE:
				return referencedInterface != null;
			case SoaPackage.SERVICE__BINDINGS:
				return bindings != null;
			case SoaPackage.SERVICE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SoaPackage.SERVICE__USED_TYPES:
				return usedTypes != null && !usedTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (synchronization: ");
		result.append(synchronization);
		result.append(", kind: ");
		result.append(kind);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ServiceImpl