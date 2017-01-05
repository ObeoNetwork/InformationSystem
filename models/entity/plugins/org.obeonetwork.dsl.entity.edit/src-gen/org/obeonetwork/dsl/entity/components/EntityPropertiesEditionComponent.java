/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.entity.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.entity.parts.EntityPropertiesEditionPart;
import org.obeonetwork.dsl.entity.parts.EntityViewsRepository;
import org.obeonetwork.dsl.entity.parts.PersistencePropertiesEditionPart;
import org.obeonetwork.dsl.environment.components.MetadataCptPropertiesEditionComponent;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr>Jérôme Benois</a>
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
	 * The Persistence part
	 * 
	 */
	private PersistencePropertiesEditionPart persistencePart;

	/**
	 * The EntityPersistencePropertiesEditionComponent sub component
	 * 
	 */
	protected EntityPersistencePropertiesEditionComponent entityPersistencePropertiesEditionComponent;

	/**
	 * The MetadataCptPropertiesEditionComponent sub component
	 * 
	 */
	protected MetadataCptPropertiesEditionComponent metadataCptPropertiesEditionComponent;

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
			entityPersistencePropertiesEditionComponent = (EntityPersistencePropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, EntityPersistencePropertiesEditionComponent.PERSISTENCE_PART, EntityPersistencePropertiesEditionComponent.class);
			addSubComponent(entityPersistencePropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(entity, PropertiesEditingProvider.class);
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
		if (EntityEntityPropertiesEditionComponent.ENTITY_PART.equals(key)) {
			entityPart = (EntityPropertiesEditionPart)entityEntityPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)entityPart;
		}
		if (EntityPersistencePropertiesEditionComponent.PERSISTENCE_PART.equals(key)) {
			persistencePart = (PersistencePropertiesEditionPart)entityPersistencePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)persistencePart;
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
		if (EntityViewsRepository.Entity_.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			entityPart = (EntityPropertiesEditionPart)propertiesEditionPart;
		}
		if (EntityViewsRepository.Persistence.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			persistencePart = (PersistencePropertiesEditionPart)propertiesEditionPart;
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
		if (key == EntityViewsRepository.Entity_.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EntityViewsRepository.Persistence.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EnvironmentViewsRepository.Metadatas.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
