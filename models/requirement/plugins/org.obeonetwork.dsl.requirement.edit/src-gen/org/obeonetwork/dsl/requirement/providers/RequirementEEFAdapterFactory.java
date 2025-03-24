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
/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.requirement.providers;

import org.eclipse.emf.common.notify.Adapter;

import org.obeonetwork.dsl.requirement.util.RequirementAdapterFactory;

/**
 * 
 * 
 */
public class RequirementEEFAdapterFactory extends RequirementAdapterFactory {

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.requirement.util.RequirementAdapterFactory#createRepositoryAdapter()
	 * 
	 */
	public Adapter createRepositoryAdapter() {
		return new RepositoryPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.requirement.util.RequirementAdapterFactory#createCategoryAdapter()
	 * 
	 */
	public Adapter createCategoryAdapter() {
		return new CategoryPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.requirement.util.RequirementAdapterFactory#createRequirementAdapter()
	 * 
	 */
	public Adapter createRequirementAdapter() {
		return new RequirementPropertiesEditionProvider();
	}

}
