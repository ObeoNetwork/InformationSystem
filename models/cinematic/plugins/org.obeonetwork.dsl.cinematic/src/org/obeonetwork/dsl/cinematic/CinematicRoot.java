/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic;

import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.cinematic.toolkits.Toolkit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.cinematic.CinematicRoot#getToolkits <em>Toolkits</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.cinematic.CinematicPackage#getCinematicRoot()
 * @model
 * @generated
 */
public interface CinematicRoot extends AbstractPackage {
	/**
	 * Returns the value of the '<em><b>Toolkits</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.cinematic.toolkits.Toolkit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Toolkits</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of the Toolkits defined on this Cinematic Root.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Toolkits</em>' reference list.
	 * @see org.obeonetwork.dsl.cinematic.CinematicPackage#getCinematicRoot_Toolkits()
	 * @model
	 * @generated
	 */
	EList<Toolkit> getToolkits();

} // CinematicRoot
