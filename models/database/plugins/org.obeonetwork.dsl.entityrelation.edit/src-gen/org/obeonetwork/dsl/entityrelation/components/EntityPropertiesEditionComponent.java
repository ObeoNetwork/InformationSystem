/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.entityrelation.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.obeonetwork.dsl.entityrelation.Entity;
import org.obeonetwork.dsl.entityrelation.parts.EntityPropertiesEditionPart;
import org.obeonetwork.dsl.entityrelation.parts.EntityrelationViewsRepository;
import org.obeonetwork.dsl.entityrelation.parts.IdentifiersPropertiesEditionPart;

// End of user code

/**
 * 
 * 
 */
public class EntityPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The Entity part
	 * 
	 */
	private EntityPropertiesEditionPart entityPart;

	/**
	 * The EntityEntityPropertiesEditionComponent sub component
	 * 
	 */
	protected EntityEntityPropertiesEditionComponent entityEntityPropertiesEditionComponent;

	/**
	 * The Identifiers part
	 * 
	 */
	private IdentifiersPropertiesEditionPart identifiersPart;

	/**
	 * The EntityIdentifiersPropertiesEditionComponent sub component
	 * 
	 */
	protected EntityIdentifiersPropertiesEditionComponent entityIdentifiersPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param entity the EObject to edit
	 * 
	 */
	public EntityPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject entity, String editing_mode) {
		super(editingContext, editing_mode);
		if (entity instanceof Entity) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(entity, PropertiesEditingProvider.class);
			entityEntityPropertiesEditionComponent = (EntityEntityPropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, EntityEntityPropertiesEditionComponent.ENTITY_PART, EntityEntityPropertiesEditionComponent.class);
			addSubComponent(entityEntityPropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(entity, PropertiesEditingProvider.class);
			entityIdentifiersPropertiesEditionComponent = (EntityIdentifiersPropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, EntityIdentifiersPropertiesEditionComponent.IDENTIFIERS_PART, EntityIdentifiersPropertiesEditionComponent.class);
			addSubComponent(entityIdentifiersPropertiesEditionComponent);
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
		if (EntityEntityPropertiesEditionComponent.ENTITY_PART.equals(key)) {
			entityPart = (EntityPropertiesEditionPart)entityEntityPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)entityPart;
		}
		if (EntityIdentifiersPropertiesEditionComponent.IDENTIFIERS_PART.equals(key)) {
			identifiersPart = (IdentifiersPropertiesEditionPart)entityIdentifiersPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)identifiersPart;
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
		if (EntityrelationViewsRepository.Entity.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			entityPart = (EntityPropertiesEditionPart)propertiesEditionPart;
		}
		if (EntityrelationViewsRepository.Identifiers.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			identifiersPart = (IdentifiersPropertiesEditionPart)propertiesEditionPart;
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
		if (key == EntityrelationViewsRepository.Entity.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EntityrelationViewsRepository.Identifiers.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
