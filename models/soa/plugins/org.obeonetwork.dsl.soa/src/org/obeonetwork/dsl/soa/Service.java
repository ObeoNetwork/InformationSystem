/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
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
import org.obeonetwork.dsl.environment.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.Service#getOwnedInterface <em>Owned Interface</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Service#getSynchronization <em>Synchronization</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Service#getKind <em>Kind</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Service#getReferencedInterface <em>Referenced Interface</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Service#getBindings <em>Bindings</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Service#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Service#getUsedTypes <em>Used Types</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Service#getURI <em>URI</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.soa.SoaPackage#getService()
 * @model
 * @generated
 */
public interface Service extends ObeoDSMObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2020 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Owned Interface</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Interface</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The owned interface.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Interface</em>' containment reference.
	 * @see #setOwnedInterface(Interface)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getService_OwnedInterface()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	Interface getOwnedInterface();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Service#getOwnedInterface <em>Owned Interface</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Interface</em>' containment reference.
	 * @see #getOwnedInterface()
	 * @generated
	 */
	void setOwnedInterface(Interface value);

	/**
	 * Returns the value of the '<em><b>Synchronization</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.dsl.soa.SynchronizationKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Synchronization</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The kind of synchronization.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Synchronization</em>' attribute.
	 * @see org.obeonetwork.dsl.soa.SynchronizationKind
	 * @see #setSynchronization(SynchronizationKind)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getService_Synchronization()
	 * @model required="true"
	 * @generated
	 */
	SynchronizationKind getSynchronization();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Service#getSynchronization <em>Synchronization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Synchronization</em>' attribute.
	 * @see org.obeonetwork.dsl.soa.SynchronizationKind
	 * @see #getSynchronization()
	 * @generated
	 */
	void setSynchronization(SynchronizationKind value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.dsl.soa.InterfaceKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The kind of interface.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.obeonetwork.dsl.soa.InterfaceKind
	 * @see #setKind(InterfaceKind)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getService_Kind()
	 * @model required="true"
	 * @generated
	 */
	InterfaceKind getKind();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Service#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.obeonetwork.dsl.soa.InterfaceKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(InterfaceKind value);

	/**
	 * Returns the value of the '<em><b>Referenced Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Interface</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The referenced interface.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referenced Interface</em>' reference.
	 * @see #setReferencedInterface(Interface)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getService_ReferencedInterface()
	 * @model
	 * @generated
	 */
	Interface getReferencedInterface();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Service#getReferencedInterface <em>Referenced Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Interface</em>' reference.
	 * @see #getReferencedInterface()
	 * @generated
	 */
	void setReferencedInterface(Interface value);

	/**
	 * Returns the value of the '<em><b>Bindings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bindings</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The binding.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bindings</em>' reference.
	 * @see #setBindings(Binding)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getService_Bindings()
	 * @model
	 * @generated
	 */
	Binding getBindings();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Service#getBindings <em>Bindings</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bindings</em>' reference.
	 * @see #getBindings()
	 * @generated
	 */
	void setBindings(Binding value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the service.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getService_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Service#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Used Types</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of used types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Used Types</em>' reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getService_UsedTypes()
	 * @model
	 * @generated
	 */
	EList<Type> getUsedTypes();

	/**
	 * Returns the value of the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The exposition URI of this service.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>URI</em>' attribute.
	 * @see #setURI(String)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getService_URI()
	 * @model
	 * @generated
	 */
	String getURI();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Service#getURI <em>URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>URI</em>' attribute.
	 * @see #getURI()
	 * @generated
	 */
	void setURI(String value);

} // Service