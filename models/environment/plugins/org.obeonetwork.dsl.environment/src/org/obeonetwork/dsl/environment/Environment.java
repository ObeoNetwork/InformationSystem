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
 * A representation of the model object '<em><b>Environment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.Environment#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.Environment#getActions <em>Actions</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.Environment#getLinks <em>Links</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.Environment#getPriorityDefinitions <em>Priority Definitions</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.Environment#getTypesDefinition <em>Types Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getEnvironment()
 * @model
 * @generated
 */
public interface Environment extends ObeoDSMObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getEnvironment_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.Environment#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getEnvironment_Actions()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Action> getActions();

	/**
	 * Returns the value of the '<em><b>Links</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.InterDSMLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' containment reference list.
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getEnvironment_Links()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<InterDSMLink> getLinks();

	/**
	 * Returns the value of the '<em><b>Priority Definitions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority Definitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority Definitions</em>' containment reference.
	 * @see #setPriorityDefinitions(PriorityDefinition)
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getEnvironment_PriorityDefinitions()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	PriorityDefinition getPriorityDefinitions();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.Environment#getPriorityDefinitions <em>Priority Definitions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority Definitions</em>' containment reference.
	 * @see #getPriorityDefinitions()
	 * @generated
	 */
	void setPriorityDefinitions(PriorityDefinition value);

	/**
	 * Returns the value of the '<em><b>Types Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types Definition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types Definition</em>' containment reference.
	 * @see #setTypesDefinition(TypesDefinition)
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getEnvironment_TypesDefinition()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	TypesDefinition getTypesDefinition();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.Environment#getTypesDefinition <em>Types Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Types Definition</em>' containment reference.
	 * @see #getTypesDefinition()
	 * @generated
	 */
	void setTypesDefinition(TypesDefinition value);

} // Environment