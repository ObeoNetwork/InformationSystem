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
import org.obeonetwork.dsl.cinematic.view.EntityPropertyBinding;
import org.obeonetwork.dsl.cinematic.view.parts.EntityPropertyBindingPropertiesEditionPart;
import org.obeonetwork.dsl.cinematic.view.parts.ViewViewsRepository;
import org.obeonetwork.dsl.environment.components.MetadataCptPropertiesEditionComponent;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;

// End of user code

/**
 * 
 * 
 */
public class EntityPropertyBindingPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The EntityPropertyBinding part
	 * 
	 */
	private EntityPropertyBindingPropertiesEditionPart entityPropertyBindingPart;

	/**
	 * The EntityPropertyBindingEntityPropertyBindingPropertiesEditionComponent sub component
	 * 
	 */
	protected EntityPropertyBindingEntityPropertyBindingPropertiesEditionComponent entityPropertyBindingEntityPropertyBindingPropertiesEditionComponent;

	/**
	 * The MetadataCptPropertiesEditionComponent sub component
	 * 
	 */
	protected MetadataCptPropertiesEditionComponent metadataCptPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param entityPropertyBinding the EObject to edit
	 * 
	 */
	public EntityPropertyBindingPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject entityPropertyBinding, String editing_mode) {
		super(editingContext, editing_mode);
		if (entityPropertyBinding instanceof EntityPropertyBinding) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(entityPropertyBinding, PropertiesEditingProvider.class);
			entityPropertyBindingEntityPropertyBindingPropertiesEditionComponent = (EntityPropertyBindingEntityPropertyBindingPropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, EntityPropertyBindingEntityPropertyBindingPropertiesEditionComponent.ENTITYPROPERTYBINDING_PART, EntityPropertyBindingEntityPropertyBindingPropertiesEditionComponent.class);
			addSubComponent(entityPropertyBindingEntityPropertyBindingPropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(entityPropertyBinding, PropertiesEditingProvider.class);
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
		if (EntityPropertyBindingEntityPropertyBindingPropertiesEditionComponent.ENTITYPROPERTYBINDING_PART.equals(key)) {
			entityPropertyBindingPart = (EntityPropertyBindingPropertiesEditionPart)entityPropertyBindingEntityPropertyBindingPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)entityPropertyBindingPart;
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
		if (ViewViewsRepository.EntityPropertyBinding.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			entityPropertyBindingPart = (EntityPropertyBindingPropertiesEditionPart)propertiesEditionPart;
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
		if (key == ViewViewsRepository.EntityPropertyBinding.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EnvironmentViewsRepository.Metadatas.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
