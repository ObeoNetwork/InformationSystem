/**
 * Copyright (c) 2008, 2022 Obeo.
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
import org.obeonetwork.dsl.environment.ObeoDSMObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Information</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Provides metadata about the API.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.Information#getApiVersion <em>Api Version</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Information#getTermsOfService <em>Terms Of Service</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.soa.SoaPackage#getInformation()
 * @model
 * @generated
 */
public interface Information extends ObeoDSMObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2022 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Api Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The version of the API definition (which is distinct from the OpenAPI specification version or the API implementation version).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Api Version</em>' attribute.
	 * @see #setApiVersion(String)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getInformation_ApiVersion()
	 * @model
	 * @generated
	 */
	String getApiVersion();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Information#getApiVersion <em>Api Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Api Version</em>' attribute.
	 * @see #getApiVersion()
	 * @generated
	 */
	void setApiVersion(String value);

	/**
	 * Returns the value of the '<em><b>Terms Of Service</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A URL to the Terms of Service for the API. MUST be in the format of a URL.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Terms Of Service</em>' attribute.
	 * @see #setTermsOfService(String)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getInformation_TermsOfService()
	 * @model
	 * @generated
	 */
	String getTermsOfService();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Information#getTermsOfService <em>Terms Of Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Terms Of Service</em>' attribute.
	 * @see #getTermsOfService()
	 * @generated
	 */
	void setTermsOfService(String value);

} // Information
