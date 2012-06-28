/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.requirement.providers;

import org.eclipse.emf.common.notify.Adapter;

import org.obeonetwork.dsl.requirement.providers.CategoryPropertiesEditionProvider;
import org.obeonetwork.dsl.requirement.providers.RepositoryPropertiesEditionProvider;
import org.obeonetwork.dsl.requirement.providers.RequirementPropertiesEditionProvider;

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
