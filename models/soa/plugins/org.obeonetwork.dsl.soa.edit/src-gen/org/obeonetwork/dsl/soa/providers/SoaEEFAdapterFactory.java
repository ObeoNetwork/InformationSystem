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
package org.obeonetwork.dsl.soa.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.obeonetwork.dsl.environment.providers.MetadataCptPropertiesEditionProvider;
import org.obeonetwork.dsl.environment.providers.NamespacePropertiesEditionProvider;
import org.obeonetwork.dsl.environment.providers.TypesDefinitionPropertiesEditionProvider;

import org.obeonetwork.dsl.soa.providers.BindingPropertiesEditionProvider;
import org.obeonetwork.dsl.soa.providers.CategoryPropertiesEditionProvider;
import org.obeonetwork.dsl.soa.providers.ComponentPropertiesEditionProvider;
import org.obeonetwork.dsl.soa.providers.DTORegistryPropertiesEditionProvider;
import org.obeonetwork.dsl.soa.providers.Interface_PropertiesEditionProvider;
import org.obeonetwork.dsl.soa.providers.OperationPropertiesEditionProvider;
import org.obeonetwork.dsl.soa.providers.ParameterPropertiesEditionProvider;
import org.obeonetwork.dsl.soa.providers.ServiceDTOPropertiesEditionProvider;
import org.obeonetwork.dsl.soa.providers.ServicePropertiesEditionProvider;
import org.obeonetwork.dsl.soa.providers.SystemPropertiesEditionProvider;
import org.obeonetwork.dsl.soa.providers.WirePropertiesEditionProvider;

import org.obeonetwork.dsl.soa.util.SoaAdapterFactory;

/**
 * @author <a href="mailto:jerome.benois@obeo.fr>Jérôme Benois</a>
 * 
 */
public class SoaEEFAdapterFactory extends SoaAdapterFactory {

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.soa.util.SoaAdapterFactory#createObeoDSMObjectAdapter()
	 * 
	 */
	public Adapter createObeoDSMObjectAdapter() {
		return new MetadataCptPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.soa.util.SoaAdapterFactory#createNamespaceAdapter()
	 * 
	 */
	public Adapter createNamespaceAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new NamespacePropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.soa.util.SoaAdapterFactory#createSystemAdapter()
	 * 
	 */
	public Adapter createSystemAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new SystemPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.soa.util.SoaAdapterFactory#createComponentAdapter()
	 * 
	 */
	public Adapter createComponentAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new ComponentPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.soa.util.SoaAdapterFactory#createServiceAdapter()
	 * 
	 */
	public Adapter createServiceAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new ServicePropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.soa.util.SoaAdapterFactory#createWireAdapter()
	 * 
	 */
	public Adapter createWireAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new WirePropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.soa.util.SoaAdapterFactory#createBindingAdapter()
	 * 
	 */
	public Adapter createBindingAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new BindingPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.soa.util.SoaAdapterFactory#createInterfaceAdapter()
	 * 
	 */
	public Adapter createInterfaceAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new Interface_PropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.soa.util.SoaAdapterFactory#createOperationAdapter()
	 * 
	 */
	public Adapter createOperationAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new OperationPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.soa.util.SoaAdapterFactory#createParameterAdapter()
	 * 
	 */
	public Adapter createParameterAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new ParameterPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.soa.util.SoaAdapterFactory#createDTORegistryAdapter()
	 * 
	 */
	public Adapter createDTORegistryAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new DTORegistryPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.soa.util.SoaAdapterFactory#createTypesDefinitionAdapter()
	 * 
	 */
	public Adapter createTypesDefinitionAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new TypesDefinitionPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.soa.util.SoaAdapterFactory#createCategoryAdapter()
	 * 
	 */
	public Adapter createCategoryAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new CategoryPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.soa.util.SoaAdapterFactory#createServiceDTOAdapter()
	 * 
	 */
	public Adapter createServiceDTOAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new ServiceDTOPropertiesEditionProvider(providers);
	}

}
