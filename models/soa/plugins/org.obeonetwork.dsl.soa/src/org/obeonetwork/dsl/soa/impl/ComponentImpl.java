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
package org.obeonetwork.dsl.soa.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.environment.TypesDefinition;
import org.obeonetwork.dsl.environment.impl.ObeoDSMObjectImpl;
import org.obeonetwork.dsl.soa.Binding;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.Contact;
import org.obeonetwork.dsl.soa.ImplementationComponent;
import org.obeonetwork.dsl.soa.Information;
import org.obeonetwork.dsl.soa.InterfaceKind;
import org.obeonetwork.dsl.soa.License;
import org.obeonetwork.dsl.soa.SecurityScheme;
import org.obeonetwork.dsl.soa.Server;
import org.obeonetwork.dsl.soa.Service;
import org.obeonetwork.dsl.soa.SoaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ComponentImpl#getOwnedServices <em>Owned Services</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ComponentImpl#getRequiredServices <em>Required Services</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ComponentImpl#getProvidedServices <em>Provided Services</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ComponentImpl#getImplementations <em>Implementations</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ComponentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ComponentImpl#getOwnedBinding <em>Owned Binding</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ComponentImpl#getBlock <em>Block</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ComponentImpl#getURI <em>URI</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ComponentImpl#getApiVersion <em>Api Version</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ComponentImpl#isDeprecated <em>Deprecated</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ComponentImpl#getSecuritySchemes <em>Security Schemes</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ComponentImpl#getLicense <em>License</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ComponentImpl#getInformation <em>Information</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ComponentImpl#getContact <em>Contact</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.impl.ComponentImpl#getServers <em>Servers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComponentImpl extends ObeoDSMObjectImpl implements Component {
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
	 * The default value of the '{@link #getURI() <em>URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getURI()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getApiVersion() <em>Api Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApiVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String API_VERSION_EDEFAULT = null;

	/**
	 * The default value of the '{@link #isDeprecated() <em>Deprecated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeprecated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEPRECATED_EDEFAULT = false;

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
	public String getURI() {
		return (String)eDynamicGet(SoaPackage.COMPONENT__URI, SoaPackage.Literals.COMPONENT__URI, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setURI(String newURI) {
		eDynamicSet(SoaPackage.COMPONENT__URI, SoaPackage.Literals.COMPONENT__URI, newURI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getApiVersion() {
		return getInformation().getApiVersion();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApiVersion(String newApiVersion) {
		// TODO: implement this method to set the 'Api Version' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDeprecated() {
		return (Boolean)eDynamicGet(SoaPackage.COMPONENT__DEPRECATED, SoaPackage.Literals.COMPONENT__DEPRECATED, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeprecated(boolean newDeprecated) {
		eDynamicSet(SoaPackage.COMPONENT__DEPRECATED, SoaPackage.Literals.COMPONENT__DEPRECATED, newDeprecated);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<SecurityScheme> getSecuritySchemes() {
		return (EList<SecurityScheme>)eDynamicGet(SoaPackage.COMPONENT__SECURITY_SCHEMES, SoaPackage.Literals.COMPONENT__SECURITY_SCHEMES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public License getLicense() {
		return (License)eDynamicGet(SoaPackage.COMPONENT__LICENSE, SoaPackage.Literals.COMPONENT__LICENSE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public License basicGetLicense() {
		return (License)eDynamicGet(SoaPackage.COMPONENT__LICENSE, SoaPackage.Literals.COMPONENT__LICENSE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLicense(License newLicense, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newLicense, SoaPackage.COMPONENT__LICENSE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLicense(License newLicense) {
		eDynamicSet(SoaPackage.COMPONENT__LICENSE, SoaPackage.Literals.COMPONENT__LICENSE, newLicense);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Information getInformation() {
		return (Information)eDynamicGet(SoaPackage.COMPONENT__INFORMATION, SoaPackage.Literals.COMPONENT__INFORMATION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Information basicGetInformation() {
		return (Information)eDynamicGet(SoaPackage.COMPONENT__INFORMATION, SoaPackage.Literals.COMPONENT__INFORMATION, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInformation(Information newInformation, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newInformation, SoaPackage.COMPONENT__INFORMATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInformation(Information newInformation) {
		eDynamicSet(SoaPackage.COMPONENT__INFORMATION, SoaPackage.Literals.COMPONENT__INFORMATION, newInformation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Contact getContact() {
		return (Contact)eDynamicGet(SoaPackage.COMPONENT__CONTACT, SoaPackage.Literals.COMPONENT__CONTACT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Contact basicGetContact() {
		return (Contact)eDynamicGet(SoaPackage.COMPONENT__CONTACT, SoaPackage.Literals.COMPONENT__CONTACT, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContact(Contact newContact, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newContact, SoaPackage.COMPONENT__CONTACT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContact(Contact newContact) {
		eDynamicSet(SoaPackage.COMPONENT__CONTACT, SoaPackage.Literals.COMPONENT__CONTACT, newContact);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Server> getServers() {
		return (EList<Server>)eDynamicGet(SoaPackage.COMPONENT__SERVERS, SoaPackage.Literals.COMPONENT__SERVERS, true, true);
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
			case SoaPackage.COMPONENT__SECURITY_SCHEMES:
				return ((InternalEList<?>)getSecuritySchemes()).basicRemove(otherEnd, msgs);
			case SoaPackage.COMPONENT__LICENSE:
				return basicSetLicense(null, msgs);
			case SoaPackage.COMPONENT__INFORMATION:
				return basicSetInformation(null, msgs);
			case SoaPackage.COMPONENT__CONTACT:
				return basicSetContact(null, msgs);
			case SoaPackage.COMPONENT__SERVERS:
				return ((InternalEList<?>)getServers()).basicRemove(otherEnd, msgs);
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
			case SoaPackage.COMPONENT__URI:
				return getURI();
			case SoaPackage.COMPONENT__API_VERSION:
				return getApiVersion();
			case SoaPackage.COMPONENT__DEPRECATED:
				return isDeprecated();
			case SoaPackage.COMPONENT__SECURITY_SCHEMES:
				return getSecuritySchemes();
			case SoaPackage.COMPONENT__LICENSE:
				if (resolve) return getLicense();
				return basicGetLicense();
			case SoaPackage.COMPONENT__INFORMATION:
				if (resolve) return getInformation();
				return basicGetInformation();
			case SoaPackage.COMPONENT__CONTACT:
				if (resolve) return getContact();
				return basicGetContact();
			case SoaPackage.COMPONENT__SERVERS:
				return getServers();
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
			case SoaPackage.COMPONENT__URI:
				setURI((String)newValue);
				return;
			case SoaPackage.COMPONENT__API_VERSION:
				setApiVersion((String)newValue);
				return;
			case SoaPackage.COMPONENT__DEPRECATED:
				setDeprecated((Boolean)newValue);
				return;
			case SoaPackage.COMPONENT__SECURITY_SCHEMES:
				getSecuritySchemes().clear();
				getSecuritySchemes().addAll((Collection<? extends SecurityScheme>)newValue);
				return;
			case SoaPackage.COMPONENT__LICENSE:
				setLicense((License)newValue);
				return;
			case SoaPackage.COMPONENT__INFORMATION:
				setInformation((Information)newValue);
				return;
			case SoaPackage.COMPONENT__CONTACT:
				setContact((Contact)newValue);
				return;
			case SoaPackage.COMPONENT__SERVERS:
				getServers().clear();
				getServers().addAll((Collection<? extends Server>)newValue);
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
			case SoaPackage.COMPONENT__URI:
				setURI(URI_EDEFAULT);
				return;
			case SoaPackage.COMPONENT__API_VERSION:
				setApiVersion(API_VERSION_EDEFAULT);
				return;
			case SoaPackage.COMPONENT__DEPRECATED:
				setDeprecated(DEPRECATED_EDEFAULT);
				return;
			case SoaPackage.COMPONENT__SECURITY_SCHEMES:
				getSecuritySchemes().clear();
				return;
			case SoaPackage.COMPONENT__LICENSE:
				setLicense((License)null);
				return;
			case SoaPackage.COMPONENT__INFORMATION:
				setInformation((Information)null);
				return;
			case SoaPackage.COMPONENT__CONTACT:
				setContact((Contact)null);
				return;
			case SoaPackage.COMPONENT__SERVERS:
				getServers().clear();
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
			case SoaPackage.COMPONENT__URI:
				return URI_EDEFAULT == null ? getURI() != null : !URI_EDEFAULT.equals(getURI());
			case SoaPackage.COMPONENT__API_VERSION:
				return API_VERSION_EDEFAULT == null ? getApiVersion() != null : !API_VERSION_EDEFAULT.equals(getApiVersion());
			case SoaPackage.COMPONENT__DEPRECATED:
				return isDeprecated() != DEPRECATED_EDEFAULT;
			case SoaPackage.COMPONENT__SECURITY_SCHEMES:
				return !getSecuritySchemes().isEmpty();
			case SoaPackage.COMPONENT__LICENSE:
				return basicGetLicense() != null;
			case SoaPackage.COMPONENT__INFORMATION:
				return basicGetInformation() != null;
			case SoaPackage.COMPONENT__CONTACT:
				return basicGetContact() != null;
			case SoaPackage.COMPONENT__SERVERS:
				return !getServers().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComponentImpl