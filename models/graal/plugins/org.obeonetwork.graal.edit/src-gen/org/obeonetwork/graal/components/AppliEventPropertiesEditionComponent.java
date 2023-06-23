/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
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
import org.obeonetwork.graal.AppliEvent;
import org.obeonetwork.graal.parts.AppliEventPropertiesEditionPart;
import org.obeonetwork.graal.parts.GraalViewsRepository;

// End of user code

/**
 * 
 * 
 */
public class AppliEventPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The AppliEvent part
	 * 
	 */
	private AppliEventPropertiesEditionPart appliEventPart;

	/**
	 * The AppliEventAppliEventPropertiesEditionComponent sub component
	 * 
	 */
	protected AppliEventAppliEventPropertiesEditionComponent appliEventAppliEventPropertiesEditionComponent;

	/**
	 * The MetadataCptPropertiesEditionComponent sub component
	 * 
	 */
	protected MetadataCptPropertiesEditionComponent metadataCptPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param appliEvent the EObject to edit
	 * 
	 */
	public AppliEventPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject appliEvent, String editing_mode) {
		super(editingContext, editing_mode);
		if (appliEvent instanceof AppliEvent) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(appliEvent, PropertiesEditingProvider.class);
			appliEventAppliEventPropertiesEditionComponent = (AppliEventAppliEventPropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, AppliEventAppliEventPropertiesEditionComponent.APPLIEVENT_PART, AppliEventAppliEventPropertiesEditionComponent.class);
			addSubComponent(appliEventAppliEventPropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(appliEvent, PropertiesEditingProvider.class);
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
		if (AppliEventAppliEventPropertiesEditionComponent.APPLIEVENT_PART.equals(key)) {
			appliEventPart = (AppliEventPropertiesEditionPart)appliEventAppliEventPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)appliEventPart;
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
		if (GraalViewsRepository.AppliEvent.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			appliEventPart = (AppliEventPropertiesEditionPart)propertiesEditionPart;
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
		if (key == GraalViewsRepository.AppliEvent.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EnvironmentViewsRepository.Metadatas.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
