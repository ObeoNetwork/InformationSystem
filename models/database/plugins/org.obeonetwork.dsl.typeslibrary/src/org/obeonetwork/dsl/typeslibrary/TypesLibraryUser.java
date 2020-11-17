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
package org.obeonetwork.dsl.typeslibrary;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.typeslibrary.TypesLibraryUser#getUsedLibraries <em>Used Libraries</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage#getTypesLibraryUser()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface TypesLibraryUser extends CDOObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2020 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Used Libraries</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.typeslibrary.TypesLibrary}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used Libraries</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used Libraries</em>' reference list.
	 * @see org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage#getTypesLibraryUser_UsedLibraries()
	 * @model
	 * @generated
	 */
	EList<TypesLibrary> getUsedLibraries();

} // TypesLibraryUser
