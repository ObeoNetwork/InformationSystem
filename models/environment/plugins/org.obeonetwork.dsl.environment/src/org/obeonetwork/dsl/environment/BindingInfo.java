/**
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.environment;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binding Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.BindingInfo#getReferences <em>References</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.BindingInfo#getLeft <em>Left</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.BindingInfo#getRight <em>Right</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.BindingInfo#getSubBindingInfos <em>Sub Binding Infos</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.BindingInfo#getTargets <em>Targets</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.BindingInfo#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getBindingInfo()
 * @model
 * @generated
 */
public interface BindingInfo extends ObeoDSMObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>References</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.BindingReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' containment reference list.
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getBindingInfo_References()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<BindingReference> getReferences();

	/**
	 * Returns the value of the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' reference.
	 * @see #setLeft(BoundableElement)
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getBindingInfo_Left()
	 * @model
	 * @generated
	 */
	BoundableElement getLeft();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.BindingInfo#getLeft <em>Left</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(BoundableElement value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' reference.
	 * @see #setRight(BoundableElement)
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getBindingInfo_Right()
	 * @model
	 * @generated
	 */
	BoundableElement getRight();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.environment.BindingInfo#getRight <em>Right</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(BoundableElement value);

	/**
	 * Returns the value of the '<em><b>Sub Binding Infos</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.BindingInfo}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Binding Infos</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Binding Infos</em>' reference list.
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getBindingInfo_SubBindingInfos()
	 * @model
	 * @generated
	 */
	EList<BindingInfo> getSubBindingInfos();

	/**
	 * Returns the value of the '<em><b>Targets</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.BoundableElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Targets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Targets</em>' reference list.
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getBindingInfo_Targets()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<BoundableElement> getTargets();

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.BindingElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getBindingInfo_Elements()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<BindingElement> getElements();

} // BindingInfo
