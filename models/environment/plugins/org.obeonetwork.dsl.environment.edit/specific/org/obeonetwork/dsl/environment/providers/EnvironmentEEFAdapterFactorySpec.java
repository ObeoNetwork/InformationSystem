/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

/**
 * Specific Adapter Factory for eef properties views for environment.
 * 
 * @author ymortier
 */
public class EnvironmentEEFAdapterFactorySpec extends EnvironmentEEFAdapterFactory {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.util.EnvironmentAdapterFactory#createReferenceAdapter()
	 */
	public Adapter createReferenceAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider) createObeoDSMObjectAdapter());
		return new ReferencePropertiesEditionProviderSpec(providers);
	}

}
