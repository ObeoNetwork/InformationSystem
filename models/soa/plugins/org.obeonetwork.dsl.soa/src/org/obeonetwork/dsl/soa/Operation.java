/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
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
import org.obeonetwork.dsl.environment.Action;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.soa.Operation#getInput <em>Input</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Operation#getOutput <em>Output</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Operation#getKind <em>Kind</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Operation#isPublic <em>Public</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Operation#getFault <em>Fault</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Operation#getURI <em>URI</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Operation#getVerb <em>Verb</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Operation#getExposition <em>Exposition</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Operation#isPaged <em>Paged</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Operation#getServers <em>Servers</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Operation#getSize <em>Size</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Operation#getPage <em>Page</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.soa.Operation#getPaginationExtension <em>Pagination Extension</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.soa.SoaPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends Action, Securable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2025 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Input</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of input parameters.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Input</em>' containment reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getOperation_Input()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Parameter> getInput();

	/**
	 * Returns the value of the '<em><b>Output</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of output parameters
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Output</em>' containment reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getOperation_Output()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Parameter> getOutput();

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.dsl.soa.OperationKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The kind of operation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.obeonetwork.dsl.soa.OperationKind
	 * @see #setKind(OperationKind)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getOperation_Kind()
	 * @model
	 * @generated
	 */
	OperationKind getKind();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Operation#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.obeonetwork.dsl.soa.OperationKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(OperationKind value);

	/**
	 * Returns the value of the '<em><b>Public</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Public</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tells if the operation is public.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Public</em>' attribute.
	 * @see #setPublic(boolean)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getOperation_Public()
	 * @model required="true"
	 * @generated
	 */
	boolean isPublic();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Operation#isPublic <em>Public</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Public</em>' attribute.
	 * @see #isPublic()
	 * @generated
	 */
	void setPublic(boolean value);

	/**
	 * Returns the value of the '<em><b>Fault</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of fault parameters.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fault</em>' containment reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getOperation_Fault()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Parameter> getFault();

	/**
	 * Returns the value of the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The exposition URI of this operation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>URI</em>' attribute.
	 * @see #setURI(String)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getOperation_URI()
	 * @model
	 * @generated
	 */
	String getURI();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Operation#getURI <em>URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>URI</em>' attribute.
	 * @see #getURI()
	 * @generated
	 */
	void setURI(String value);

	/**
	 * Returns the value of the '<em><b>Verb</b></em>' attribute.
	 * The default value is <code>"GET"</code>.
	 * The literals are from the enumeration {@link org.obeonetwork.dsl.soa.Verb}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Verb</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The HTTP verb of this operation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Verb</em>' attribute.
	 * @see org.obeonetwork.dsl.soa.Verb
	 * @see #setVerb(Verb)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getOperation_Verb()
	 * @model default="GET"
	 * @generated
	 */
	Verb getVerb();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Operation#getVerb <em>Verb</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Verb</em>' attribute.
	 * @see org.obeonetwork.dsl.soa.Verb
	 * @see #getVerb()
	 * @generated
	 */
	void setVerb(Verb value);

	/**
	 * Returns the value of the '<em><b>Exposition</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.dsl.soa.ExpositionKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exposition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The kind of exposition or NONE if not exposed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Exposition</em>' attribute.
	 * @see org.obeonetwork.dsl.soa.ExpositionKind
	 * @see #setExposition(ExpositionKind)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getOperation_Exposition()
	 * @model
	 * @generated
	 */
	ExpositionKind getExposition();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Operation#getExposition <em>Exposition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exposition</em>' attribute.
	 * @see org.obeonetwork.dsl.soa.ExpositionKind
	 * @see #getExposition()
	 * @generated
	 */
	void setExposition(ExpositionKind value);

	/**
	 * Returns the value of the '<em><b>Paged</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tells if this operation is paged.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Paged</em>' attribute.
	 * @see #setPaged(boolean)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getOperation_Paged()
	 * @model default="false"
	 * @generated
	 */
	boolean isPaged();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Operation#isPaged <em>Paged</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Paged</em>' attribute.
	 * @see #isPaged()
	 * @generated
	 */
	void setPaged(boolean value);

	/**
	 * Returns the value of the '<em><b>Servers</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.soa.Server}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of servers.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Servers</em>' containment reference list.
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getOperation_Servers()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Server> getServers();

	/**
	 * Returns the value of the '<em><b>Size</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Size input parameter that indicates the number of instances to return.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Size</em>' reference.
	 * @see #setSize(Parameter)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getOperation_Size()
	 * @model
	 * @generated
	 */
	Parameter getSize();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Operation#getSize <em>Size</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' reference.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(Parameter value);

	/**
	 * Returns the value of the '<em><b>Page</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Page input parameter that indicates the index of the page requested.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Page</em>' reference.
	 * @see #setPage(Parameter)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getOperation_Page()
	 * @model
	 * @generated
	 */
	Parameter getPage();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Operation#getPage <em>Page</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Page</em>' reference.
	 * @see #getPage()
	 * @generated
	 */
	void setPage(Parameter value);

	/**
	 * Returns the value of the '<em><b>Pagination Extension</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference towards the property extension that defines the operation's pagination.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pagination Extension</em>' reference.
	 * @see #setPaginationExtension(PropertiesExtension)
	 * @see org.obeonetwork.dsl.soa.SoaPackage#getOperation_PaginationExtension()
	 * @model
	 * @generated
	 */
	PropertiesExtension getPaginationExtension();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.soa.Operation#getPaginationExtension <em>Pagination Extension</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pagination Extension</em>' reference.
	 * @see #getPaginationExtension()
	 * @generated
	 */
	void setPaginationExtension(PropertiesExtension value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the owned SecurityApplications and the ones inherited from the containing Service.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<SecurityApplication> getAllSecurityApplications();

} // Operation