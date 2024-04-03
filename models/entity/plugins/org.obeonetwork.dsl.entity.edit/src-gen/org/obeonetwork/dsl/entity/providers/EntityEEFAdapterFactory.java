/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.entity.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.obeonetwork.dsl.entity.util.EntityAdapterFactory;

import org.obeonetwork.dsl.environment.providers.MetadataCptPropertiesEditionProvider;
import org.obeonetwork.dsl.environment.providers.TypesDefinitionPropertiesEditionProvider;

/**
 * @author Obeo
 * 
 */
public class EntityEEFAdapterFactory extends EntityAdapterFactory {

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.entity.util.EntityAdapterFactory#createObeoDSMObjectAdapter()
	 * 
	 */
	public Adapter createObeoDSMObjectAdapter() {
		return new MetadataCptPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.entity.util.EntityAdapterFactory#createTypesDefinitionAdapter()
	 * 
	 */
	public Adapter createTypesDefinitionAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new TypesDefinitionPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.entity.util.EntityAdapterFactory#createRootAdapter()
	 * 
	 */
	public Adapter createRootAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new RootPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.entity.util.EntityAdapterFactory#createEntityAdapter()
	 * 
	 */
	public Adapter createEntityAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new EntityPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.entity.util.EntityAdapterFactory#createFinderAdapter()
	 * 
	 */
	public Adapter createFinderAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new FinderPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.entity.util.EntityAdapterFactory#createInternalCriterionAdapter()
	 * 
	 */
	public Adapter createInternalCriterionAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new InternalCriterionPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.entity.util.EntityAdapterFactory#createExternalCriterionAdapter()
	 * 
	 */
	public Adapter createExternalCriterionAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new ExternalCriterionPropertiesEditionProvider(providers);
	}

}
