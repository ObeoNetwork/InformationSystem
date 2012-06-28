/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.cinematic.view.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.obeonetwork.dsl.cinematic.view.EntityBinding;
import org.obeonetwork.dsl.cinematic.view.parts.EntityBindingPropertiesEditionPart;
import org.obeonetwork.dsl.cinematic.view.parts.ViewViewsRepository;
import org.obeonetwork.dsl.environment.components.MetadataCptPropertiesEditionComponent;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;

// End of user code

/**
 * 
 * 
 */
public class EntityBindingPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The EntityBinding part
	 * 
	 */
	private EntityBindingPropertiesEditionPart entityBindingPart;

	/**
	 * The EntityBindingEntityBindingPropertiesEditionComponent sub component
	 * 
	 */
	protected EntityBindingEntityBindingPropertiesEditionComponent entityBindingEntityBindingPropertiesEditionComponent;

	/**
	 * The MetadataCptPropertiesEditionComponent sub component
	 * 
	 */
	protected MetadataCptPropertiesEditionComponent metadataCptPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param entityBinding the EObject to edit
	 * 
	 */
	public EntityBindingPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject entityBinding, String editing_mode) {
		super(editingContext, editing_mode);
		if (entityBinding instanceof EntityBinding) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(entityBinding, PropertiesEditingProvider.class);
			entityBindingEntityBindingPropertiesEditionComponent = (EntityBindingEntityBindingPropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, EntityBindingEntityBindingPropertiesEditionComponent.ENTITYBINDING_PART, EntityBindingEntityBindingPropertiesEditionComponent.class);
			addSubComponent(entityBindingEntityBindingPropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(entityBinding, PropertiesEditingProvider.class);
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
		if (EntityBindingEntityBindingPropertiesEditionComponent.ENTITYBINDING_PART.equals(key)) {
			entityBindingPart = (EntityBindingPropertiesEditionPart)entityBindingEntityBindingPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)entityBindingPart;
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
		if (ViewViewsRepository.EntityBinding.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			entityBindingPart = (EntityBindingPropertiesEditionPart)propertiesEditionPart;
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
		if (key == ViewViewsRepository.EntityBinding.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EnvironmentViewsRepository.Metadatas.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
