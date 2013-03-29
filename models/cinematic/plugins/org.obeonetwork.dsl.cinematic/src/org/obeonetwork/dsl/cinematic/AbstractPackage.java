/**
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.cinematic;

import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.AbstractPackage#getFlows <em>Flows</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.AbstractPackage#getViewContainers <em>View Containers</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.cinematic.AbstractPackage#getSubPackages <em>Sub Packages</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.cinematic.CinematicPackage#getAbstractPackage()
 * @model abstract="true"
 * @generated
 */
public interface AbstractPackage extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Flows</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.cinematic.flow.Flow}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flows</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flows</em>' containment reference list.
	 * @see org.obeonetwork.dsl.cinematic.CinematicPackage#getAbstractPackage_Flows()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Flow> getFlows();

	/**
	 * Returns the value of the '<em><b>View Containers</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.cinematic.view.ViewContainer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View Containers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View Containers</em>' containment reference list.
	 * @see org.obeonetwork.dsl.cinematic.CinematicPackage#getAbstractPackage_ViewContainers()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ViewContainer> getViewContainers();

	/**
	 * Returns the value of the '<em><b>Sub Packages</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.cinematic.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Packages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Packages</em>' containment reference list.
	 * @see org.obeonetwork.dsl.cinematic.CinematicPackage#getAbstractPackage_SubPackages()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<org.obeonetwork.dsl.cinematic.Package> getSubPackages();

} // AbstractPackage
