/*******************************************************************************
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.entity.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.obeonetwork.dsl.entity.providers.AttributePropertiesEditionProvider;
import org.obeonetwork.dsl.entity.providers.BlockPropertiesEditionProvider;
import org.obeonetwork.dsl.entity.providers.EntityPropertiesEditionProvider;
import org.obeonetwork.dsl.entity.providers.ExternalCriterionPropertiesEditionProvider;
import org.obeonetwork.dsl.entity.providers.FinderPropertiesEditionProvider;
import org.obeonetwork.dsl.entity.providers.InternalCriterionPropertiesEditionProvider;
import org.obeonetwork.dsl.entity.providers.ReferencePropertiesEditionProvider;
import org.obeonetwork.dsl.entity.providers.RootPropertiesEditionProvider;

import org.obeonetwork.dsl.entity.util.EntityAdapterFactory;

import org.obeonetwork.dsl.environment.providers.MetadataCptPropertiesEditionProvider;
import org.obeonetwork.dsl.environment.providers.NamespacePropertiesEditionProvider;

/**
 * @author <a href="mailto:jerome.benois@obeo.fr>Jérôme Benois</a>
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
	 * @see org.obeonetwork.dsl.entity.util.EntityAdapterFactory#createNamespaceAdapter()
	 * 
	 */
	public Adapter createNamespaceAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new NamespacePropertiesEditionProvider(providers);
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
	 * @see org.obeonetwork.dsl.entity.util.EntityAdapterFactory#createBlockAdapter()
	 * 
	 */
	public Adapter createBlockAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new BlockPropertiesEditionProvider(providers);
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
	 * @see org.obeonetwork.dsl.entity.util.EntityAdapterFactory#createAttributeAdapter()
	 * 
	 */
	public Adapter createAttributeAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new AttributePropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.entity.util.EntityAdapterFactory#createReferenceAdapter()
	 * 
	 */
	public Adapter createReferenceAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new ReferencePropertiesEditionProvider(providers);
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
