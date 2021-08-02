/**
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.soa;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.environment.ObeoDSMObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Security Scheme</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.SecurityScheme#getKey <em>Key</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.SecurityScheme#getType <em>Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.SecurityScheme#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.SecurityScheme#getApiKeyLocation <em>Api Key Location</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.SecurityScheme#getConnectURL <em>Connect URL</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.SecurityScheme#getFlows <em>Flows</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.SecurityScheme#getHttpScheme <em>Http Scheme</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.soa.SoaPackage#getSecurityScheme()
 * @model
 * @generated
 */
public interface SecurityScheme extends ObeoDSMObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2021 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The unique id of the Security Scheme, used in the OpenAPI serialization format.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(String)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getSecurityScheme_Key()
	 * @model
	 * @generated
	 */
	String getKey();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.SecurityScheme#getKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.dsl.soa.SecuritySchemeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of the security scheme.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.obeonetwork.dsl.soa.SecuritySchemeType
	 * @see #setType(SecuritySchemeType)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getSecurityScheme_Type()
	 * @model
	 * @generated
	 */
	SecuritySchemeType getType();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.SecurityScheme#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.obeonetwork.dsl.soa.SecuritySchemeType
	 * @see #getType()
	 * @generated
	 */
	void setType(SecuritySchemeType value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the header, query or cookie parameter to be used.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getSecurityScheme_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.SecurityScheme#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Api Key Location</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.dsl.soa.ApiKeyLocation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The location of the API key. (Named "in" in the OpenAPI specification).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Api Key Location</em>' attribute.
	 * @see org.obeonetwork.dsl.soa.ApiKeyLocation
	 * @see #setApiKeyLocation(ApiKeyLocation)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getSecurityScheme_ApiKeyLocation()
	 * @model
	 * @generated
	 */
	ApiKeyLocation getApiKeyLocation();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.SecurityScheme#getApiKeyLocation <em>Api Key Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Api Key Location</em>' attribute.
	 * @see org.obeonetwork.dsl.soa.ApiKeyLocation
	 * @see #getApiKeyLocation()
	 * @generated
	 */
	void setApiKeyLocation(ApiKeyLocation value);

	/**
	 * Returns the value of the '<em><b>Connect URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * REQUIRED. OpenId Connect URL to discover OAuth2 configuration values. This MUST be in the form of a URL.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Connect URL</em>' attribute.
	 * @see #setConnectURL(String)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getSecurityScheme_ConnectURL()
	 * @model
	 * @generated
	 */
	String getConnectURL();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.SecurityScheme#getConnectURL <em>Connect URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connect URL</em>' attribute.
	 * @see #getConnectURL()
	 * @generated
	 */
	void setConnectURL(String value);

	/**
	 * Returns the value of the '<em><b>Flows</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.Flow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * REQUIRED for OAuth2 Security Schemes. An object containing configuration information for the flow types supported.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Flows</em>' containment reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getSecurityScheme_Flows()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Flow> getFlows();

	/**
	 * Returns the value of the '<em><b>Http Scheme</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.dsl.soa.HttpScheme}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * REQUIRED. The name of the HTTP Authorization scheme to be used in the Authorization header as defined in RFC7235.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Http Scheme</em>' attribute.
	 * @see org.obeonetwork.dsl.soa.HttpScheme
	 * @see #setHttpScheme(HttpScheme)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getSecurityScheme_HttpScheme()
	 * @model
	 * @generated
	 */
	HttpScheme getHttpScheme();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.SecurityScheme#getHttpScheme <em>Http Scheme</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Http Scheme</em>' attribute.
	 * @see org.obeonetwork.dsl.soa.HttpScheme
	 * @see #getHttpScheme()
	 * @generated
	 */
	void setHttpScheme(HttpScheme value);

} // SecurityScheme
