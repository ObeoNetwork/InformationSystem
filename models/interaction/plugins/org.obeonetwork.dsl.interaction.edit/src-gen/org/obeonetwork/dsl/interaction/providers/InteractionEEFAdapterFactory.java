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
package org.obeonetwork.dsl.interaction.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.obeonetwork.dsl.environment.providers.MetadataCptPropertiesEditionProvider;

import org.obeonetwork.dsl.interaction.util.InteractionAdapterFactory;

/**
 * 
 * 
 */
public class InteractionEEFAdapterFactory extends InteractionAdapterFactory {

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.interaction.util.InteractionAdapterFactory#createObeoDSMObjectAdapter()
	 * 
	 */
	public Adapter createObeoDSMObjectAdapter() {
		return new MetadataCptPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.interaction.util.InteractionAdapterFactory#createInteractionAdapter()
	 * 
	 */
	public Adapter createInteractionAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new InteractionPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.interaction.util.InteractionAdapterFactory#createParticipantAdapter()
	 * 
	 */
	public Adapter createParticipantAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new ParticipantPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.interaction.util.InteractionAdapterFactory#createExecutionAdapter()
	 * 
	 */
	public Adapter createExecutionAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new ExecutionPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.interaction.util.InteractionAdapterFactory#createCreateParticipantMessageAdapter()
	 * 
	 */
	public Adapter createCreateParticipantMessageAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new CreateParticipantMessagePropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.interaction.util.InteractionAdapterFactory#createDestroyParticipantMessageAdapter()
	 * 
	 */
	public Adapter createDestroyParticipantMessageAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new DestroyParticipantMessagePropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.interaction.util.InteractionAdapterFactory#createReturnMessageAdapter()
	 * 
	 */
	public Adapter createReturnMessageAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new ReturnMessagePropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.interaction.util.InteractionAdapterFactory#createStateInvariantAdapter()
	 * 
	 */
	public Adapter createStateInvariantAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new StateInvariantPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.interaction.util.InteractionAdapterFactory#createInteractionUseAdapter()
	 * 
	 */
	public Adapter createInteractionUseAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new InteractionUsePropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.interaction.util.InteractionAdapterFactory#createCombinedFragmentAdapter()
	 * 
	 */
	public Adapter createCombinedFragmentAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new CombinedFragmentPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.interaction.util.InteractionAdapterFactory#createOperandAdapter()
	 * 
	 */
	public Adapter createOperandAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new OperandPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.interaction.util.InteractionAdapterFactory#createCallMessageAdapter()
	 * 
	 */
	public Adapter createCallMessageAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new CallMessagePropertiesEditionProvider(providers);
	}

}
