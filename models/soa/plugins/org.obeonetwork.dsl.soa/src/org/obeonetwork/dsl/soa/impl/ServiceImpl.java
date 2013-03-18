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
	 * The default value of the '{@link #getSynchronization() <em>Synchronization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSynchronization()
	 * @generated
	 * @ordered
	 */
	protected static final SynchronizationKind SYNCHRONIZATION_EDEFAULT = SynchronizationKind.SYNCHONE_LITERAL;
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
		return (Interface)eDynamicGet(SoaPackage.SERVICE__OWNED_INTERFACE, SoaPackage.Literals.SERVICE__OWNED_INTERFACE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface basicGetOwnedInterface() {
		return (Interface)eDynamicGet(SoaPackage.SERVICE__OWNED_INTERFACE, SoaPackage.Literals.SERVICE__OWNED_INTERFACE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedInterface(Interface newOwnedInterface, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newOwnedInterface, SoaPackage.SERVICE__OWNED_INTERFACE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedInterface(Interface newOwnedInterface) {
		eDynamicSet(SoaPackage.SERVICE__OWNED_INTERFACE, SoaPackage.Literals.SERVICE__OWNED_INTERFACE, newOwnedInterface);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SynchronizationKind getSynchronization() {
		return (SynchronizationKind)eDynamicGet(SoaPackage.SERVICE__SYNCHRONIZATION, SoaPackage.Literals.SERVICE__SYNCHRONIZATION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSynchronization(SynchronizationKind newSynchronization) {
		eDynamicSet(SoaPackage.SERVICE__SYNCHRONIZATION, SoaPackage.Literals.SERVICE__SYNCHRONIZATION, newSynchronization);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceKind getKind() {
		return (InterfaceKind)eDynamicGet(SoaPackage.SERVICE__KIND, SoaPackage.Literals.SERVICE__KIND, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(InterfaceKind newKind) {
		eDynamicSet(SoaPackage.SERVICE__KIND, SoaPackage.Literals.SERVICE__KIND, newKind);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface getReferencedInterface() {
		return (Interface)eDynamicGet(SoaPackage.SERVICE__REFERENCED_INTERFACE, SoaPackage.Literals.SERVICE__REFERENCED_INTERFACE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface basicGetReferencedInterface() {
		return (Interface)eDynamicGet(SoaPackage.SERVICE__REFERENCED_INTERFACE, SoaPackage.Literals.SERVICE__REFERENCED_INTERFACE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedInterface(Interface newReferencedInterface) {
		eDynamicSet(SoaPackage.SERVICE__REFERENCED_INTERFACE, SoaPackage.Literals.SERVICE__REFERENCED_INTERFACE, newReferencedInterface);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Binding getBindings() {
		return (Binding)eDynamicGet(SoaPackage.SERVICE__BINDINGS, SoaPackage.Literals.SERVICE__BINDINGS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Binding basicGetBindings() {
		return (Binding)eDynamicGet(SoaPackage.SERVICE__BINDINGS, SoaPackage.Literals.SERVICE__BINDINGS, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBindings(Binding newBindings) {
		eDynamicSet(SoaPackage.SERVICE__BINDINGS, SoaPackage.Literals.SERVICE__BINDINGS, newBindings);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eDynamicGet(SoaPackage.SERVICE__NAME, SoaPackage.Literals.SERVICE__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eDynamicSet(SoaPackage.SERVICE__NAME, SoaPackage.Literals.SERVICE__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Type> getUsedTypes() {
		return (EList<Type>)eDynamicGet(SoaPackage.SERVICE__USED_TYPES, SoaPackage.Literals.SERVICE__USED_TYPES, true, true);
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
				return basicGetOwnedInterface() != null;
			case SoaPackage.SERVICE__SYNCHRONIZATION:
				return getSynchronization() != SYNCHRONIZATION_EDEFAULT;
			case SoaPackage.SERVICE__KIND:
				return getKind() != KIND_EDEFAULT;
			case SoaPackage.SERVICE__REFERENCED_INTERFACE:
				return basicGetReferencedInterface() != null;
			case SoaPackage.SERVICE__BINDINGS:
				return basicGetBindings() != null;
			case SoaPackage.SERVICE__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case SoaPackage.SERVICE__USED_TYPES:
				return !getUsedTypes().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ServiceImpl