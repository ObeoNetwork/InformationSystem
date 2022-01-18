/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.cinematic.flow.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.obeonetwork.dsl.cinematic.flow.util.FlowAdapterFactory;
import org.obeonetwork.dsl.environment.providers.MetadataCptPropertiesEditionProvider;

/**
 * 
 * 
 */
public class FlowEEFAdapterFactory extends FlowAdapterFactory {

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.cinematic.flow.util.FlowAdapterFactory#createObeoDSMObjectAdapter()
	 * 
	 */
	public Adapter createObeoDSMObjectAdapter() {
		return new MetadataCptPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.cinematic.flow.util.FlowAdapterFactory#createFlowAdapter()
	 * 
	 */
	public Adapter createFlowAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new FlowPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.cinematic.flow.util.FlowAdapterFactory#createTransitionAdapter()
	 * 
	 */
	public Adapter createTransitionAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new TransitionPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.cinematic.flow.util.FlowAdapterFactory#createActionStateAdapter()
	 * 
	 */
	public Adapter createActionStateAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new ActionStatePropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.cinematic.flow.util.FlowAdapterFactory#createViewStateAdapter()
	 * 
	 */
	public Adapter createViewStateAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new ViewStatePropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.cinematic.flow.util.FlowAdapterFactory#createDecisionStateAdapter()
	 * 
	 */
	public Adapter createDecisionStateAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new DecisionStatePropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.cinematic.flow.util.FlowAdapterFactory#createSubflowStateAdapter()
	 * 
	 */
	public Adapter createSubflowStateAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new SubflowStatePropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.cinematic.flow.util.FlowAdapterFactory#createAsyncEventStateAdapter()
	 * 
	 */
	public Adapter createAsyncEventStateAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new AsyncEventStatePropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.cinematic.flow.util.FlowAdapterFactory#createInitialStateAdapter()
	 * 
	 */
	public Adapter createInitialStateAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new InitialStatePropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.cinematic.flow.util.FlowAdapterFactory#createAbortStateAdapter()
	 * 
	 */
	public Adapter createAbortStateAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new AbortStatePropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.cinematic.flow.util.FlowAdapterFactory#createFinalStateAdapter()
	 * 
	 */
	public Adapter createFinalStateAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new FinalStatePropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.cinematic.flow.util.FlowAdapterFactory#createFlowActionAdapter()
	 * 
	 */
	public Adapter createFlowActionAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new FlowActionPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.cinematic.flow.util.FlowAdapterFactory#createFlowEventAdapter()
	 * 
	 */
	public Adapter createFlowEventAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new FlowEventPropertiesEditionProvider(providers);
	}

}
