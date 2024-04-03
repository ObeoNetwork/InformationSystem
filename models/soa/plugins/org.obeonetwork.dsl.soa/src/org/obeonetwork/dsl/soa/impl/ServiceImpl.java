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
package org.obeonetwork.dsl.soa.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl;
import org.obeonetwork.dsl.soa.Binding;
import org.obeonetwork.dsl.soa.Interface;
import org.obeonetwork.dsl.soa.InterfaceKind;
import org.obeonetwork.dsl.soa.Securable;
import org.obeonetwork.dsl.soa.SecurityApplication;
import org.obeonetwork.dsl.soa.SecurityScheme;
import org.obeonetwork.dsl.soa.Service;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.dsl.soa.SynchronizationKind;
import org.obeonetwork.dsl.soa.Verb;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ServiceImpl#getSecurityApplications <em>Security Applications</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ServiceImpl#getSecuritySchemes <em>Security Schemes</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ServiceImpl#getOwnedInterface <em>Owned Interface</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ServiceImpl#getSynchronization <em>Synchronization</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ServiceImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ServiceImpl#getReferencedInterface <em>Referenced Interface</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ServiceImpl#getBindings <em>Bindings</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ServiceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ServiceImpl#getUsedTypes <em>Used Types</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ServiceImpl#getURI <em>URI</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ServiceImpl extends ObeoDSMObjectImpl implements Service {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2024 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getSynchronization() <em>Synchronization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSynchronization()
	 * @generated
	 * @ordered
	 */
	protected static final SynchronizationKind SYNCHRONIZATION_EDEFAULT = SynchronizationKind.SYNCHRONOUS_LITERAL;
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
	 * The default value of the '{@link #getURI() <em>URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getURI()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

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
	@SuppressWarnings("unchecked")
	@Override
	public EList<SecurityApplication> getSecurityApplications() {
		return (EList<SecurityApplication>)eDynamicGet(SoaPackage.SERVICE__SECURITY_APPLICATIONS, SoaPackage.Literals.SECURABLE__SECURITY_APPLICATIONS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SecurityScheme> getSecuritySchemes() {
		// TODO: implement this method to return the 'Security Schemes' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public void setOwnedInterface(Interface newOwnedInterface) {
		eDynamicSet(SoaPackage.SERVICE__OWNED_INTERFACE, SoaPackage.Literals.SERVICE__OWNED_INTERFACE, newOwnedInterface);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SynchronizationKind getSynchronization() {
		return (SynchronizationKind)eDynamicGet(SoaPackage.SERVICE__SYNCHRONIZATION, SoaPackage.Literals.SERVICE__SYNCHRONIZATION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSynchronization(SynchronizationKind newSynchronization) {
		eDynamicSet(SoaPackage.SERVICE__SYNCHRONIZATION, SoaPackage.Literals.SERVICE__SYNCHRONIZATION, newSynchronization);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InterfaceKind getKind() {
		return (InterfaceKind)eDynamicGet(SoaPackage.SERVICE__KIND, SoaPackage.Literals.SERVICE__KIND, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKind(InterfaceKind newKind) {
		eDynamicSet(SoaPackage.SERVICE__KIND, SoaPackage.Literals.SERVICE__KIND, newKind);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public void setReferencedInterface(Interface newReferencedInterface) {
		eDynamicSet(SoaPackage.SERVICE__REFERENCED_INTERFACE, SoaPackage.Literals.SERVICE__REFERENCED_INTERFACE, newReferencedInterface);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public void setBindings(Binding newBindings) {
		eDynamicSet(SoaPackage.SERVICE__BINDINGS, SoaPackage.Literals.SERVICE__BINDINGS, newBindings);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String)eDynamicGet(SoaPackage.SERVICE__NAME, SoaPackage.Literals.SERVICE__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eDynamicSet(SoaPackage.SERVICE__NAME, SoaPackage.Literals.SERVICE__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Type> getUsedTypes() {
		return (EList<Type>)eDynamicGet(SoaPackage.SERVICE__USED_TYPES, SoaPackage.Literals.SERVICE__USED_TYPES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getURI() {
		return (String)eDynamicGet(SoaPackage.SERVICE__URI, SoaPackage.Literals.SERVICE__URI, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setURI(String newURI) {
		eDynamicSet(SoaPackage.SERVICE__URI, SoaPackage.Literals.SERVICE__URI, newURI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SoaPackage.SERVICE__SECURITY_APPLICATIONS:
				return ((InternalEList<?>)getSecurityApplications()).basicRemove(otherEnd, msgs);
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
			case SoaPackage.SERVICE__SECURITY_APPLICATIONS:
				return getSecurityApplications();
			case SoaPackage.SERVICE__SECURITY_SCHEMES:
				return getSecuritySchemes();
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
			case SoaPackage.SERVICE__URI:
				return getURI();
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
			case SoaPackage.SERVICE__SECURITY_APPLICATIONS:
				getSecurityApplications().clear();
				getSecurityApplications().addAll((Collection<? extends SecurityApplication>)newValue);
				return;
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
			case SoaPackage.SERVICE__URI:
				setURI((String)newValue);
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
			case SoaPackage.SERVICE__SECURITY_APPLICATIONS:
				getSecurityApplications().clear();
				return;
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
			case SoaPackage.SERVICE__URI:
				setURI(URI_EDEFAULT);
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
			case SoaPackage.SERVICE__SECURITY_APPLICATIONS:
				return !getSecurityApplications().isEmpty();
			case SoaPackage.SERVICE__SECURITY_SCHEMES:
				return !getSecuritySchemes().isEmpty();
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
			case SoaPackage.SERVICE__URI:
				return URI_EDEFAULT == null ? getURI() != null : !URI_EDEFAULT.equals(getURI());
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
		if (baseClass == Securable.class) {
			switch (derivedFeatureID) {
				case SoaPackage.SERVICE__SECURITY_APPLICATIONS: return SoaPackage.SECURABLE__SECURITY_APPLICATIONS;
				case SoaPackage.SERVICE__SECURITY_SCHEMES: return SoaPackage.SECURABLE__SECURITY_SCHEMES;
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
		if (baseClass == Securable.class) {
			switch (baseFeatureID) {
				case SoaPackage.SECURABLE__SECURITY_APPLICATIONS: return SoaPackage.SERVICE__SECURITY_APPLICATIONS;
				case SoaPackage.SECURABLE__SECURITY_SCHEMES: return SoaPackage.SERVICE__SECURITY_SCHEMES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //ServiceImpl