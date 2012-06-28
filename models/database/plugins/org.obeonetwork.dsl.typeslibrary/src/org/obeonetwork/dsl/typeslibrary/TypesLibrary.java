/**
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.typeslibrary;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Types Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.typeslibrary.TypesLibrary#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage#getTypesLibrary()
 * @model interface="true" abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface TypesLibrary extends CDOObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2011 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.dsl.typeslibrary.TypesLibraryKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.obeonetwork.dsl.typeslibrary.TypesLibraryKind
	 * @see #setKind(TypesLibraryKind)
	 * @see org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage#getTypesLibrary_Kind()
	 * @model
	 * @generated
	 */
	TypesLibraryKind getKind();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.typeslibrary.TypesLibrary#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.obeonetwork.dsl.typeslibrary.TypesLibraryKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(TypesLibraryKind value);

} // TypesLibrary
