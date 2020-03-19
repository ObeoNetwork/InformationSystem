/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa;

import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.TypesDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.Component#getOwnedServices <em>Owned Services</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Component#getRequiredServices <em>Required Services</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Component#getProvidedServices <em>Provided Services</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Component#getImplementations <em>Implementations</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Component#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Component#getOwnedBinding <em>Owned Binding</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Component#getBlock <em>Block</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.soa.SoaPackage#getComponent()
 * @model
 * @generated
 */
public interface Component extends ObeoDSMObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2017 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Owned Services</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.Service}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Services</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of owned services.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Services</em>' containment reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getComponent_OwnedServices()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Service> getOwnedServices();

	/**
	 * Returns the value of the '<em><b>Required Services</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.Service}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Services</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of required services.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Required Services</em>' reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getComponent_RequiredServices()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Service> getRequiredServices();

	/**
	 * Returns the value of the '<em><b>Provided Services</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.Service}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Services</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of provided services.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Provided Services</em>' reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getComponent_ProvidedServices()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Service> getProvidedServices();

	/**
	 * Returns the value of the '<em><b>Implementations</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.ImplementationComponent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of implementations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Implementations</em>' containment reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getComponent_Implementations()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ImplementationComponent> getImplementations();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the component.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getComponent_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Component#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Owned Binding</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.Binding}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Binding</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of owned bindings.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Binding</em>' containment reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getComponent_OwnedBinding()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Binding> getOwnedBinding();

	/**
	 * Returns the value of the '<em><b>Block</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.TypesDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of block type definitions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Block</em>' reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getComponent_Block()
	 * @model
	 * @generated
	 */
	EList<TypesDefinition> getBlock();

} // Component