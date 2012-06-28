/**
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *
 * $Id$
 */
package org.obeonetwork.dsl.environment;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DTO</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.DTO#getOwnedContainer <em>Owned Container</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.DTO#getAssociatedTypes <em>Associated Types</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.DTO#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.DTO#getReferences <em>References</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.DTO#getOwnedReferences <em>Owned References</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.DTO#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.DTO#getOwnedAttributes <em>Owned Attributes</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.DTO#getSupertype <em>Supertype</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getDTO()
 * @model abstract="true"
 * @generated
 */
public interface DTO extends StructuredType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Owned Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Container</em>' containment reference.
	 * @see #setOwnedContainer(FilterContainer)
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getDTO_OwnedContainer()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	FilterContainer getOwnedContainer();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.DTO#getOwnedContainer <em>Owned Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Container</em>' containment reference.
	 * @see #getOwnedContainer()
	 * @generated
	 */
	void setOwnedContainer(FilterContainer value);

	/**
	 * Returns the value of the '<em><b>Associated Types</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.StructuredType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associated Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associated Types</em>' reference list.
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getDTO_AssociatedTypes()
	 * @model
	 * @generated
	 */
	EList<StructuredType> getAssociatedTypes();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' reference list.
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getDTO_Properties()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Property> getProperties();

	/**
	 * Returns the value of the '<em><b>References</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.Reference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' reference list.
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getDTO_References()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Reference> getReferences();

	/**
	 * Returns the value of the '<em><b>Owned References</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.Reference}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.environment.Reference#getDto <em>Dto</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned References</em>' containment reference list.
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getDTO_OwnedReferences()
	 * @see org.obeonetwork.dsl.environment.Reference#getDto
	 * @model opposite="dto" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Reference> getOwnedReferences();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' reference list.
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getDTO_Attributes()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Owned Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.Attribute}.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.environment.Attribute#getDto <em>Dto</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Attributes</em>' containment reference list.
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getDTO_OwnedAttributes()
	 * @see org.obeonetwork.dsl.environment.Attribute#getDto
	 * @model opposite="dto" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Attribute> getOwnedAttributes();

	/**
	 * Returns the value of the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supertype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supertype</em>' reference.
	 * @see #setSupertype(DTO)
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getDTO_Supertype()
	 * @model
	 * @generated
	 */
	DTO getSupertype();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.DTO#getSupertype <em>Supertype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Supertype</em>' reference.
	 * @see #getSupertype()
	 * @generated
	 */
	void setSupertype(DTO value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean isSubtypeOf(DTO dto);

} // DTO