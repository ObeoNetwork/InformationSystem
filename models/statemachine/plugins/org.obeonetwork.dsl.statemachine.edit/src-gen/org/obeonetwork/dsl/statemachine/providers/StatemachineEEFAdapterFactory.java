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
/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.statemachine.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.obeonetwork.dsl.environment.providers.MetadataCptPropertiesEditionProvider;

import org.obeonetwork.dsl.statemachine.util.StateMachineAdapterFactory;

/**
 * 
 * 
 */
public class StatemachineEEFAdapterFactory extends StateMachineAdapterFactory {

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.statemachine.util.StateMachineAdapterFactory#createObeoDSMObjectAdapter()
	 * 
	 */
	public Adapter createObeoDSMObjectAdapter() {
		return new MetadataCptPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.statemachine.util.StateMachineAdapterFactory#createStateMachineAdapter()
	 * 
	 */
	public Adapter createStateMachineAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new StateMachinePropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.statemachine.util.StateMachineAdapterFactory#createStateAdapter()
	 * 
	 */
	public Adapter createStateAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new StatePropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.statemachine.util.StateMachineAdapterFactory#createRegionAdapter()
	 * 
	 */
	public Adapter createRegionAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new RegionPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.statemachine.util.StateMachineAdapterFactory#createTransitionAdapter()
	 * 
	 */
	public Adapter createTransitionAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new TransitionPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.statemachine.util.StateMachineAdapterFactory#createInitialStateAdapter()
	 * 
	 */
	public Adapter createInitialStateAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new InitialStatePropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.statemachine.util.StateMachineAdapterFactory#createFinalStateAdapter()
	 * 
	 */
	public Adapter createFinalStateAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new FinalStatePropertiesEditionProvider(providers);
	}

}
