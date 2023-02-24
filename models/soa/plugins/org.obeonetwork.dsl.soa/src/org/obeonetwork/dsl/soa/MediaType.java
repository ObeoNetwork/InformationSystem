/**
 * Copyright (c) 2008, 2023 Obeo.
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
 * A representation of the model object '<em><b>Media Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Media type is a format of a request or response body data. Web service operations can accept and return data in different formats, the most common being JSON, XML and images. You specify the media type in request and response definitions.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.MediaType#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.MediaType#getExamples <em>Examples</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.soa.SoaPackage#getMediaType()
 * @model
 * @generated
 */
public interface MediaType extends ObeoDSMObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2023 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Two-part identifier for file formats and format contents transmitted on the Internet. It consists of a type and a subtype and should be compliant with RFC 6838.
	 * As of November 1996, the registered types were: application, audio, image, message, multipart, text and video. By December 2020, the registered types included the foregoing, plus font, example, and model.
	 * A subtype typically consists of a media format, but it may or must also contain other content, such as a tree prefix, producer, product or suffix, according to the different rules in registration trees.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #setIdentifier(String)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getMediaType_Identifier()
	 * @model
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.MediaType#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Examples</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.Example}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Example of the media type. 
	 * The example object SHOULD be an instance of the DTO specified by the media type. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Examples</em>' containment reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getMediaType_Examples()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Example> getExamples();

} // MediaType
