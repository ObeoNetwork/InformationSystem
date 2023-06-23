/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Filter Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.FilterContainer#getOwnedFilters <em>Owned Filters</em>}</li>
 * </ul>
 *
 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getFilterContainer()
 * @model
 * @generated
 */
public interface FilterContainer extends ObeoDSMObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008, 2023 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Owned Filters</b></em>' containment reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.environment.Filter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Filters</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of owned filters.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Filters</em>' containment reference list.
	 * @see org.obeonetwork.dsl.environment.EnvironmentPackage#getFilterContainer_OwnedFilters()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Filter> getOwnedFilters();

} // FilterContainer