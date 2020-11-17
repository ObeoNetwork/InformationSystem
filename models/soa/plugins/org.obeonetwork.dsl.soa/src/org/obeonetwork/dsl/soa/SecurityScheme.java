/**
 * Copyright (c) 2008, 2020 Obeo.
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
 *   <li>{@link org.obeonetwork.dsl.soa.SecurityScheme#getDescription <em>Description</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.SecurityScheme#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.SecurityScheme#getApiKeyLocation <em>Api Key Location</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.soa.SoaPackage#getSecurityScheme()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface SecurityScheme extends CDOObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2020 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

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
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A short description for security scheme.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getSecurityScheme_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.SecurityScheme#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

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

} // SecurityScheme
