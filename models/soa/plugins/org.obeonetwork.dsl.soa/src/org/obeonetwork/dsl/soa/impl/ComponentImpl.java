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
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.environment.TypesDefinition;
import org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl;
import org.obeonetwork.dsl.soa.Binding;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.ImplementationComponent;
import org.obeonetwork.dsl.soa.InterfaceKind;
import org.obeonetwork.dsl.soa.Service;
import org.obeonetwork.dsl.soa.SoaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ComponentImpl#getOwnedServices <em>Owned Services</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ComponentImpl#getRequiredServices <em>Required Services</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ComponentImpl#getProvidedServices <em>Provided Services</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ComponentImpl#getImplementations <em>Implementations</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ComponentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ComponentImpl#getOwnedBinding <em>Owned Binding</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ComponentImpl#getBlock <em>Block</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentImpl extends ObeoDSMObjectImpl implements Component {
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
	protected ComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SoaPackage.Literals.COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Service> getOwnedServices() {
		return (EList<Service>)eDynamicGet(SoaPackage.COMPONENT__OWNED_SERVICES, SoaPackage.Literals.COMPONENT__OWNED_SERVICES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Service> getRequiredServices() {
		EList<Service> requiredServices = new BasicEList<Service>();
		for(Service service : getOwnedServices()){
			if(service.getKind()==InterfaceKind.REQUIRED_LITERAL){
				requiredServices.add(service);
			}
		}
		return requiredServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Service> getProvidedServices() {
		EList<Service> providedServices = new BasicEList<Service>();
		for(Service service : getOwnedServices()){
			if(service.getKind()==InterfaceKind.PROVIDED_LITERAL){
				providedServices.add(service);
			}
		}
		return providedServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ImplementationComponent> getImplementations() {
		return (EList<ImplementationComponent>)eDynamicGet(SoaPackage.COMPONENT__IMPLEMENTATIONS, SoaPackage.Literals.COMPONENT__IMPLEMENTATIONS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eDynamicGet(SoaPackage.COMPONENT__NAME, SoaPackage.Literals.COMPONENT__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eDynamicSet(SoaPackage.COMPONENT__NAME, SoaPackage.Literals.COMPONENT__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Binding> getOwnedBinding() {
		return (EList<Binding>)eDynamicGet(SoaPackage.COMPONENT__OWNED_BINDING, SoaPackage.Literals.COMPONENT__OWNED_BINDING, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<TypesDefinition> getBlock() {
		return (EList<TypesDefinition>)eDynamicGet(SoaPackage.COMPONENT__BLOCK, SoaPackage.Literals.COMPONENT__BLOCK, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SoaPackage.COMPONENT__OWNED_SERVICES:
				return ((InternalEList<?>)getOwnedServices()).basicRemove(otherEnd, msgs);
			case SoaPackage.COMPONENT__IMPLEMENTATIONS:
				return ((InternalEList<?>)getImplementations()).basicRemove(otherEnd, msgs);
			case SoaPackage.COMPONENT__OWNED_BINDING:
				return ((InternalEList<?>)getOwnedBinding()).basicRemove(otherEnd, msgs);
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
			case SoaPackage.COMPONENT__OWNED_SERVICES:
				return getOwnedServices();
			case SoaPackage.COMPONENT__REQUIRED_SERVICES:
				return getRequiredServices();
			case SoaPackage.COMPONENT__PROVIDED_SERVICES:
				return getProvidedServices();
			case SoaPackage.COMPONENT__IMPLEMENTATIONS:
				return getImplementations();
			case SoaPackage.COMPONENT__NAME:
				return getName();
			case SoaPackage.COMPONENT__OWNED_BINDING:
				return getOwnedBinding();
			case SoaPackage.COMPONENT__BLOCK:
				return getBlock();
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
			case SoaPackage.COMPONENT__OWNED_SERVICES:
				getOwnedServices().clear();
				getOwnedServices().addAll((Collection<? extends Service>)newValue);
				return;
			case SoaPackage.COMPONENT__IMPLEMENTATIONS:
				getImplementations().clear();
				getImplementations().addAll((Collection<? extends ImplementationComponent>)newValue);
				return;
			case SoaPackage.COMPONENT__NAME:
				setName((String)newValue);
				return;
			case SoaPackage.COMPONENT__OWNED_BINDING:
				getOwnedBinding().clear();
				getOwnedBinding().addAll((Collection<? extends Binding>)newValue);
				return;
			case SoaPackage.COMPONENT__BLOCK:
				getBlock().clear();
				getBlock().addAll((Collection<? extends TypesDefinition>)newValue);
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
			case SoaPackage.COMPONENT__OWNED_SERVICES:
				getOwnedServices().clear();
				return;
			case SoaPackage.COMPONENT__IMPLEMENTATIONS:
				getImplementations().clear();
				return;
			case SoaPackage.COMPONENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SoaPackage.COMPONENT__OWNED_BINDING:
				getOwnedBinding().clear();
				return;
			case SoaPackage.COMPONENT__BLOCK:
				getBlock().clear();
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
			case SoaPackage.COMPONENT__OWNED_SERVICES:
				return !getOwnedServices().isEmpty();
			case SoaPackage.COMPONENT__REQUIRED_SERVICES:
				return !getRequiredServices().isEmpty();
			case SoaPackage.COMPONENT__PROVIDED_SERVICES:
				return !getProvidedServices().isEmpty();
			case SoaPackage.COMPONENT__IMPLEMENTATIONS:
				return !getImplementations().isEmpty();
			case SoaPackage.COMPONENT__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case SoaPackage.COMPONENT__OWNED_BINDING:
				return !getOwnedBinding().isEmpty();
			case SoaPackage.COMPONENT__BLOCK:
				return !getBlock().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComponentImpl