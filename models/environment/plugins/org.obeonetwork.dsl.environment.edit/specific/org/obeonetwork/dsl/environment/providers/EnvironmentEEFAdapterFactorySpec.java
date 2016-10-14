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
