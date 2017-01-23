/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.environment.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.obeonetwork.dsl.environment.FilterContainer;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;
import org.obeonetwork.dsl.environment.parts.FilterContainerPropertiesEditionPart;

// End of user code

/**
 * 
 * 
 */
public class FilterContainerPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The FilterContainer part
	 * 
	 */
	private FilterContainerPropertiesEditionPart filterContainerPart;

	/**
	 * The FilterContainerFilterContainerPropertiesEditionComponent sub component
	 * 
	 */
	protected FilterContainerFilterContainerPropertiesEditionComponent filterContainerFilterContainerPropertiesEditionComponent;

	/**
	 * The MetadataCptPropertiesEditionComponent sub component
	 * 
	 */
	protected MetadataCptPropertiesEditionComponent metadataCptPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param filterContainer the EObject to edit
	 * 
	 */
	public FilterContainerPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject filterContainer, String editing_mode) {
		super(editingContext, editing_mode);
		if (filterContainer instanceof FilterContainer) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(filterContainer, PropertiesEditingProvider.class);
			filterContainerFilterContainerPropertiesEditionComponent = (FilterContainerFilterContainerPropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, FilterContainerFilterContainerPropertiesEditionComponent.FILTERCONTAINER_PART, FilterContainerFilterContainerPropertiesEditionComponent.class);
			addSubComponent(filterContainerFilterContainerPropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(filterContainer, PropertiesEditingProvider.class);
			metadataCptPropertiesEditionComponent = (MetadataCptPropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, MetadataCptPropertiesEditionComponent.METADATAS_PART, MetadataCptPropertiesEditionComponent.class);
			addSubComponent(metadataCptPropertiesEditionComponent);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      getPropertiesEditionPart(int, java.lang.String)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (FilterContainerFilterContainerPropertiesEditionComponent.FILTERCONTAINER_PART.equals(key)) {
			filterContainerPart = (FilterContainerPropertiesEditionPart)filterContainerFilterContainerPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)filterContainerPart;
		}
		return super.getPropertiesEditionPart(kind, key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      setPropertiesEditionPart(java.lang.Object, int,
	 *      org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 * 
	 */
	public void setPropertiesEditionPart(java.lang.Object key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (EnvironmentViewsRepository.FilterContainer.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			filterContainerPart = (FilterContainerPropertiesEditionPart)propertiesEditionPart;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(java.lang.Object key, int kind, EObject element, ResourceSet allResource) {
		if (key == EnvironmentViewsRepository.FilterContainer.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EnvironmentViewsRepository.Metadatas.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
