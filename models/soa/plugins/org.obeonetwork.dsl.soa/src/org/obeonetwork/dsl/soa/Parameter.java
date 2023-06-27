/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
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
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.Parameter#getType <em>Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Parameter#getMediaType <em>Media Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Parameter#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Parameter#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Parameter#isIsUnique <em>Is Unique</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Parameter#isIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Parameter#getStatusCode <em>Status Code</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Parameter#getStatusMessage <em>Status Message</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Parameter#getRestData <em>Rest Data</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Parameter#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Parameter#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Parameter#getPattern <em>Pattern</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.soa.SoaPackage#getParameter()
 * @model
 * @generated
 */
public interface Parameter extends ObeoDSMObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2023 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of the parameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Type)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getParameter_Type()
	 * @model
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Parameter#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

	/**
	 * Returns the value of the '<em><b>Media Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.MediaType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The mediatypes used by this parameter
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Media Type</em>' containment reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getParameter_MediaType()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<MediaType> getMediaType();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the parameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getParameter_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Parameter#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Multiplicity</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * The literals are from the enumeration {@link org.obeonetwork.dsl.environment.MultiplicityKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiplicity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The multiplicity of the parameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Multiplicity</em>' attribute.
	 * @see org.obeonetwork.dsl.environment.MultiplicityKind
	 * @see #setMultiplicity(MultiplicityKind)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getParameter_Multiplicity()
	 * @model default="1" required="true"
	 * @generated
	 */
	MultiplicityKind getMultiplicity();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Parameter#getMultiplicity <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplicity</em>' attribute.
	 * @see org.obeonetwork.dsl.environment.MultiplicityKind
	 * @see #getMultiplicity()
	 * @generated
	 */
	void setMultiplicity(MultiplicityKind value);

	/**
	 * Returns the value of the '<em><b>Is Unique</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Unique</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tells if the parameter contains duplicates.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Unique</em>' attribute.
	 * @see #setIsUnique(boolean)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getParameter_IsUnique()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsUnique();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Parameter#isIsUnique <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Unique</em>' attribute.
	 * @see #isIsUnique()
	 * @generated
	 */
	void setIsUnique(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Ordered</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Ordered</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tells if the parameter is ordered.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Ordered</em>' attribute.
	 * @see #setIsOrdered(boolean)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getParameter_IsOrdered()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsOrdered();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Parameter#isIsOrdered <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Ordered</em>' attribute.
	 * @see #isIsOrdered()
	 * @generated
	 */
	void setIsOrdered(boolean value);

	/**
	 * Returns the value of the '<em><b>Status Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The status code associated with this parameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Status Code</em>' attribute.
	 * @see #setStatusCode(String)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getParameter_StatusCode()
	 * @model
	 * @generated
	 */
	String getStatusCode();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Parameter#getStatusCode <em>Status Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status Code</em>' attribute.
	 * @see #getStatusCode()
	 * @generated
	 */
	void setStatusCode(String value);

	/**
	 * Returns the value of the '<em><b>Status Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The status message associated with this parameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Status Message</em>' attribute.
	 * @see #setStatusMessage(String)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getParameter_StatusMessage()
	 * @model
	 * @generated
	 */
	String getStatusMessage();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Parameter#getStatusMessage <em>Status Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status Message</em>' attribute.
	 * @see #getStatusMessage()
	 * @generated
	 */
	void setStatusMessage(String value);

	/**
	 * Returns the value of the '<em><b>Rest Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rest Data</em>' containment reference.
	 * @see #setRestData(ParameterRestData)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getParameter_RestData()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ParameterRestData getRestData();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Parameter#getRestData <em>Rest Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rest Data</em>' containment reference.
	 * @see #getRestData()
	 * @generated
	 */
	void setRestData(ParameterRestData value);

	/**
	 * Returns the value of the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum</em>' attribute.
	 * @see #setMinimum(String)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getParameter_Minimum()
	 * @model
	 * @generated
	 */
	String getMinimum();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Parameter#getMinimum <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum</em>' attribute.
	 * @see #getMinimum()
	 * @generated
	 */
	void setMinimum(String value);

	/**
	 * Returns the value of the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum</em>' attribute.
	 * @see #setMaximum(String)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getParameter_Maximum()
	 * @model
	 * @generated
	 */
	String getMaximum();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Parameter#getMaximum <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum</em>' attribute.
	 * @see #getMaximum()
	 * @generated
	 */
	void setMaximum(String value);

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' attribute.
	 * @see #setPattern(String)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getParameter_Pattern()
	 * @model
	 * @generated
	 */
	String getPattern();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Parameter#getPattern <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' attribute.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(String value);

} // Parameter