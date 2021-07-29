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

import org.eclipse.emf.common.util.EList;

import org.obeonetwork.dsl.environment.ObeoDSMObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * REQUIRED FOR OAUTH2. An object containing configuration information for the flow types supported.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.Flow#getFlowType <em>Flow Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Flow#getAuthorizationURL <em>Authorization URL</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Flow#getTokenURL <em>Token URL</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Flow#getRefreshURL <em>Refresh URL</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Flow#getScopes <em>Scopes</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.soa.SoaPackage#getFlow()
 * @model
 * @generated
 */
public interface Flow extends ObeoDSMObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2021 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Flow Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.dsl.soa.FlowType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * REQUIRED. Type of Flow.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Flow Type</em>' attribute.
	 * @see org.obeonetwork.dsl.soa.FlowType
	 * @see #setFlowType(FlowType)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getFlow_FlowType()
	 * @model required="true"
	 * @generated
	 */
	FlowType getFlowType();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Flow#getFlowType <em>Flow Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flow Type</em>' attribute.
	 * @see org.obeonetwork.dsl.soa.FlowType
	 * @see #getFlowType()
	 * @generated
	 */
	void setFlowType(FlowType value);

	/**
	 * Returns the value of the '<em><b>Authorization URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * REQUIRED. The authorization URL to be used for this flow. This MUST be in the form of a URL.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Authorization URL</em>' attribute.
	 * @see #setAuthorizationURL(String)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getFlow_AuthorizationURL()
	 * @model
	 * @generated
	 */
	String getAuthorizationURL();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Flow#getAuthorizationURL <em>Authorization URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Authorization URL</em>' attribute.
	 * @see #getAuthorizationURL()
	 * @generated
	 */
	void setAuthorizationURL(String value);

	/**
	 * Returns the value of the '<em><b>Token URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * REQUIRED. The token URL to be used for this flow. This MUST be in the form of a URL.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Token URL</em>' attribute.
	 * @see #setTokenURL(String)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getFlow_TokenURL()
	 * @model
	 * @generated
	 */
	String getTokenURL();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Flow#getTokenURL <em>Token URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Token URL</em>' attribute.
	 * @see #getTokenURL()
	 * @generated
	 */
	void setTokenURL(String value);

	/**
	 * Returns the value of the '<em><b>Refresh URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The refresh URL to be used for this flow. This MUST be in the form of a URL.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Refresh URL</em>' attribute.
	 * @see #setRefreshURL(String)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getFlow_RefreshURL()
	 * @model
	 * @generated
	 */
	String getRefreshURL();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Flow#getRefreshURL <em>Refresh URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refresh URL</em>' attribute.
	 * @see #getRefreshURL()
	 * @generated
	 */
	void setRefreshURL(String value);

	/**
	 * Returns the value of the '<em><b>Scopes</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.Parameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The available scopes for the OAuth2 security scheme. References to SOA Parameters.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Scopes</em>' reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getFlow_Scopes()
	 * @model
	 * @generated
	 */
	EList<Parameter> getScopes();

} // Flow
