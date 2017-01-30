/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.environment.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.obeonetwork.dsl.environment.util.EnvironmentAdapterFactory;

/**
 * 
 * 
 */
public class EnvironmentEEFAdapterFactory extends EnvironmentAdapterFactory {

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.environment.util.EnvironmentAdapterFactory#createObeoDSMObjectAdapter()
	 * 
	 */
	public Adapter createObeoDSMObjectAdapter() {
		return new MetadataCptPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.environment.util.EnvironmentAdapterFactory#createEnvironmentAdapter()
	 * 
	 */
	public Adapter createEnvironmentAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new EnvironmentPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.environment.util.EnvironmentAdapterFactory#createPrimitiveTypeAdapter()
	 * 
	 */
	public Adapter createPrimitiveTypeAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new PrimitiveTypePropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.environment.util.EnvironmentAdapterFactory#createEnumerationAdapter()
	 * 
	 */
	public Adapter createEnumerationAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new EnumerationPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.environment.util.EnvironmentAdapterFactory#createLiteralAdapter()
	 * 
	 */
	public Adapter createLiteralAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new LiteralPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.environment.util.EnvironmentAdapterFactory#createInterDSMLinkAdapter()
	 * 
	 */
	public Adapter createInterDSMLinkAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new InterDSMLinkPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.environment.util.EnvironmentAdapterFactory#createAnnotationAdapter()
	 * 
	 */
	public Adapter createAnnotationAdapter() {
		return new AnnotationPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.environment.util.EnvironmentAdapterFactory#createPriorityDefinitionAdapter()
	 * 
	 */
	public Adapter createPriorityDefinitionAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new PriorityDefinitionPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.environment.util.EnvironmentAdapterFactory#createPriorityAdapter()
	 * 
	 */
	public Adapter createPriorityAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new PriorityPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.environment.util.EnvironmentAdapterFactory#createTypesDefinitionAdapter()
	 * 
	 */
	public Adapter createTypesDefinitionAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new TypesDefinitionPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.environment.util.EnvironmentAdapterFactory#createDTOAdapter()
	 * 
	 */
	public Adapter createDTOAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new DtoPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.environment.util.EnvironmentAdapterFactory#createFilterContainerAdapter()
	 * 
	 */
	public Adapter createFilterContainerAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new FilterContainerPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.environment.util.EnvironmentAdapterFactory#createNamespaceAdapter()
	 * 
	 */
	public Adapter createNamespaceAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new NamespacePropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.environment.util.EnvironmentAdapterFactory#createAttributeAdapter()
	 * 
	 */
	public Adapter createAttributeAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new AttributePropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.environment.util.EnvironmentAdapterFactory#createReferenceAdapter()
	 * 
	 */
	public Adapter createReferenceAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new ReferencePropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.environment.util.EnvironmentAdapterFactory#createBindingInfoAdapter()
	 * 
	 */
	public Adapter createBindingInfoAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new BindingInfoPropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.environment.util.EnvironmentAdapterFactory#createBindingReferenceAdapter()
	 * 
	 */
	public Adapter createBindingReferenceAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new BindingReferencePropertiesEditionProvider(providers);
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.environment.util.EnvironmentAdapterFactory#createBindingElementAdapter()
	 * 
	 */
	public Adapter createBindingElementAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createObeoDSMObjectAdapter());
		return new BindingElementPropertiesEditionProvider(providers);
	}

}
