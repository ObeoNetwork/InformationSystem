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
package org.obeonetwork.dsl.environment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.Attribute#getType <em>Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.Attribute#getContainingType <em>Containing Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.Attribute#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.Attribute#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.Attribute#getPattern <em>Pattern</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends Property {
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
	 * The type of the attribute.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(DataType)
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getAttribute_Type()
	 * @model required="true"
	 * @generated
	 */
	DataType getType();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.Attribute#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(DataType value);

	/**
	 * Returns the value of the '<em><b>Containing Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.environment.StructuredType#getOwnedAttributes <em>Owned Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The containing structured type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Containing Type</em>' container reference.
	 * @see #setContainingType(StructuredType)
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getAttribute_ContainingType()
	 * @see org.obeonetwork.dsl.environment.StructuredType#getOwnedAttributes
	 * @model opposite="ownedAttributes" required="true" transient="false"
	 * @generated
	 */
	StructuredType getContainingType();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.Attribute#getContainingType <em>Containing Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containing Type</em>' container reference.
	 * @see #getContainingType()
	 * @generated
	 */
	void setContainingType(StructuredType value);

	/**
	 * Returns the value of the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum</em>' attribute.
	 * @see #setMinimum(String)
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getAttribute_Minimum()
	 * @model
	 * @generated
	 */
	String getMinimum();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.Attribute#getMinimum <em>Minimum</em>}' attribute.
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
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getAttribute_Maximum()
	 * @model
	 * @generated
	 */
	String getMaximum();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.Attribute#getMaximum <em>Maximum</em>}' attribute.
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
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getAttribute_Pattern()
	 * @model
	 * @generated
	 */
	String getPattern();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.Attribute#getPattern <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' attribute.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(String value);

} // Attribute
