/*******************************************************************************
 * Copyright (c) 2010, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.obeonetwork.dsl.environment.components.MetadataCptPropertiesEditionComponent;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;
import org.obeonetwork.graal.DomainClass;
import org.obeonetwork.graal.parts.DomainClassPropertiesEditionPart;
import org.obeonetwork.graal.parts.GraalViewsRepository;
import org.obeonetwork.graal.parts.PersistencePropertiesEditionPart;

// End of user code

/**
 * 
 * 
 */
public class DomainClassPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The DomainClass part
	 * 
	 */
	private DomainClassPropertiesEditionPart domainClassPart;

	/**
	 * The DomainClassDomainClassPropertiesEditionComponent sub component
	 * 
	 */
	protected DomainClassDomainClassPropertiesEditionComponent domainClassDomainClassPropertiesEditionComponent;

	/**
	 * The Persistence part
	 * 
	 */
	private PersistencePropertiesEditionPart persistencePart;

	/**
	 * The DomainClassPersistencePropertiesEditionComponent sub component
	 * 
	 */
	protected DomainClassPersistencePropertiesEditionComponent domainClassPersistencePropertiesEditionComponent;

	/**
	 * The MetadataCptPropertiesEditionComponent sub component
	 * 
	 */
	protected MetadataCptPropertiesEditionComponent metadataCptPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param domainClass the EObject to edit
	 * 
	 */
	public DomainClassPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject domainClass, String editing_mode) {
		super(editingContext, editing_mode);
		if (domainClass instanceof DomainClass) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(domainClass, PropertiesEditingProvider.class);
			domainClassDomainClassPropertiesEditionComponent = (DomainClassDomainClassPropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, DomainClassDomainClassPropertiesEditionComponent.DOMAINCLASS_PART, DomainClassDomainClassPropertiesEditionComponent.class);
			addSubComponent(domainClassDomainClassPropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(domainClass, PropertiesEditingProvider.class);
			domainClassPersistencePropertiesEditionComponent = (DomainClassPersistencePropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, DomainClassPersistencePropertiesEditionComponent.PERSISTENCE_PART, DomainClassPersistencePropertiesEditionComponent.class);
			addSubComponent(domainClassPersistencePropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(domainClass, PropertiesEditingProvider.class);
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
		if (DomainClassDomainClassPropertiesEditionComponent.DOMAINCLASS_PART.equals(key)) {
			domainClassPart = (DomainClassPropertiesEditionPart)domainClassDomainClassPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)domainClassPart;
		}
		if (DomainClassPersistencePropertiesEditionComponent.PERSISTENCE_PART.equals(key)) {
			persistencePart = (PersistencePropertiesEditionPart)domainClassPersistencePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
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
		if (GraalViewsRepository.DomainClass.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			domainClassPart = (DomainClassPropertiesEditionPart)propertiesEditionPart;
		}
		if (GraalViewsRepository.Persistence.class == key) {
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
		if (key == GraalViewsRepository.DomainClass.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == GraalViewsRepository.Persistence.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EnvironmentViewsRepository.Metadatas.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
