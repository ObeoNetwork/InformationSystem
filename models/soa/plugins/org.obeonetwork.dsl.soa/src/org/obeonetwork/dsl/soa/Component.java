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
package org.obeonetwork.dsl.soa;

import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.TypesDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.Component#getOwnedServices <em>Owned Services</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Component#getRequiredServices <em>Required Services</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Component#getProvidedServices <em>Provided Services</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Component#getImplementations <em>Implementations</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Component#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Component#getOwnedBinding <em>Owned Binding</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Component#getBlock <em>Block</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Component#getURI <em>URI</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Component#getApiVersion <em>Api Version</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Component#isDeprecated <em>Deprecated</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Component#getSecuritySchemes <em>Security Schemes</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Component#getLicense <em>License</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Component#getInformation <em>Information</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Component#getContact <em>Contact</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Component#getServers <em>Servers</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.soa.SoaPackage#getComponent()
 * @model
 * @generated
 */
public interface Component extends ObeoDSMObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2024 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Owned Services</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.Service}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Services</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of owned services.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Services</em>' containment reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getComponent_OwnedServices()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Service> getOwnedServices();

	/**
	 * Returns the value of the '<em><b>Required Services</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.Service}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Services</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of required services.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Required Services</em>' reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getComponent_RequiredServices()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Service> getRequiredServices();

	/**
	 * Returns the value of the '<em><b>Provided Services</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.Service}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Services</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of provided services.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Provided Services</em>' reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getComponent_ProvidedServices()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Service> getProvidedServices();

	/**
	 * Returns the value of the '<em><b>Implementations</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.ImplementationComponent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of implementations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Implementations</em>' containment reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getComponent_Implementations()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ImplementationComponent> getImplementations();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the component.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getComponent_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Component#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Owned Binding</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.Binding}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Binding</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of owned bindings.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Binding</em>' containment reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getComponent_OwnedBinding()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Binding> getOwnedBinding();

	/**
	 * Returns the value of the '<em><b>Block</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.TypesDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of block type definitions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Block</em>' reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getComponent_Block()
	 * @model
	 * @generated
	 */
	EList<TypesDefinition> getBlock();

	/**
	 * Returns the value of the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The exposition URI of this component.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>URI</em>' attribute.
	 * @see #setURI(String)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getComponent_URI()
	 * @model
	 * @generated
	 */
	String getURI();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Component#getURI <em>URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>URI</em>' attribute.
	 * @see #getURI()
	 * @generated
	 */
	void setURI(String value);

	/**
	 * Returns the value of the '<em><b>Api Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Api Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Api Version</em>' attribute.
	 * @see #setApiVersion(String)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getComponent_ApiVersion()
	 * @model volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return getInformation().getApiVersion();'"
	 * @generated
	 */
	String getApiVersion();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Component#getApiVersion <em>Api Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Api Version</em>' attribute.
	 * @see #getApiVersion()
	 * @generated
	 */
	void setApiVersion(String value);

	/**
	 * Returns the value of the '<em><b>Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deprecated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tells if this Component is deprecated.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Deprecated</em>' attribute.
	 * @see #setDeprecated(boolean)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getComponent_Deprecated()
	 * @model
	 * @generated
	 */
	boolean isDeprecated();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Component#isDeprecated <em>Deprecated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deprecated</em>' attribute.
	 * @see #isDeprecated()
	 * @generated
	 */
	void setDeprecated(boolean value);

	/**
	 * Returns the value of the '<em><b>Security Schemes</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.SecurityScheme}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Security Schemes</em>' containment reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getComponent_SecuritySchemes()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<SecurityScheme> getSecuritySchemes();

	/**
	 * Returns the value of the '<em><b>License</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>License</em>' containment reference.
	 * @see #setLicense(License)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getComponent_License()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	License getLicense();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Component#getLicense <em>License</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>License</em>' containment reference.
	 * @see #getLicense()
	 * @generated
	 */
	void setLicense(License value);

	/**
	 * Returns the value of the '<em><b>Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Information</em>' containment reference.
	 * @see #setInformation(Information)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getComponent_Information()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	Information getInformation();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Component#getInformation <em>Information</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Information</em>' containment reference.
	 * @see #getInformation()
	 * @generated
	 */
	void setInformation(Information value);

	/**
	 * Returns the value of the '<em><b>Contact</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contact</em>' containment reference.
	 * @see #setContact(Contact)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getComponent_Contact()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	Contact getContact();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Component#getContact <em>Contact</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contact</em>' containment reference.
	 * @see #getContact()
	 * @generated
	 */
	void setContact(Contact value);

	/**
	 * Returns the value of the '<em><b>Servers</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.Server}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of servers.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Servers</em>' containment reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getComponent_Servers()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Server> getServers();

} // Component