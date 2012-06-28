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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.Reference#isIsComposite <em>Is Composite</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.Reference#isNavigable <em>Navigable</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.Reference#getOppositeOf <em>Opposite Of</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.Reference#getType <em>Type</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.Reference#getDto <em>Dto</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getReference()
 * @model
 * @generated
 */
public interface Reference extends Property {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Is Composite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Composite</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Composite</em>' attribute.
	 * @see #setIsComposite(boolean)
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getReference_IsComposite()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsComposite();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.Reference#isIsComposite <em>Is Composite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Composite</em>' attribute.
	 * @see #isIsComposite()
	 * @generated
	 */
	void setIsComposite(boolean value);

	/**
	 * Returns the value of the '<em><b>Navigable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Navigable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Navigable</em>' attribute.
	 * @see #setNavigable(boolean)
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getReference_Navigable()
	 * @model required="true"
	 * @generated
	 */
	boolean isNavigable();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.Reference#isNavigable <em>Navigable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Navigable</em>' attribute.
	 * @see #isNavigable()
	 * @generated
	 */
	void setNavigable(boolean value);

	/**
	 * Returns the value of the '<em><b>Opposite Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opposite Of</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opposite Of</em>' reference.
	 * @see #setOppositeOf(Reference)
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getReference_OppositeOf()
	 * @model
	 * @generated
	 */
	Reference getOppositeOf();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.Reference#getOppositeOf <em>Opposite Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opposite Of</em>' reference.
	 * @see #getOppositeOf()
	 * @generated
	 */
	void setOppositeOf(Reference value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(DTO)
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getReference_Type()
	 * @model required="true"
	 * @generated
	 */
	DTO getType();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.Reference#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(DTO value);

	/**
	 * Returns the value of the '<em><b>Dto</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.obeonetwork.dsl.environment.DTO#getOwnedReferences <em>Owned References</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dto</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dto</em>' container reference.
	 * @see #setDto(DTO)
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getReference_Dto()
	 * @see org.obeonetwork.dsl.environment.DTO#getOwnedReferences
	 * @model opposite="ownedReferences" required="true" transient="false"
	 * @generated
	 */
	DTO getDto();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.Reference#getDto <em>Dto</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dto</em>' container reference.
	 * @see #getDto()
	 * @generated
	 */
	void setDto(DTO value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean canBeOppositeOf(Reference opposite);

} // Reference
