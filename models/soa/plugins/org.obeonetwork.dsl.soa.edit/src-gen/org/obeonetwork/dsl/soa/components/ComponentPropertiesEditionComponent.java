/*******************************************************************************
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.obeonetwork.dsl.environment.components.MetadataCptPropertiesEditionComponent;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.parts.ComponentPropertiesEditionPart;
import org.obeonetwork.dsl.soa.parts.SoaViewsRepository;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr>Jérôme Benois</a>
 * 
 */
public class ComponentPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The Component part
	 * 
	 */
	private ComponentPropertiesEditionPart componentPart;

	/**
	 * The ComponentComponentPropertiesEditionComponent sub component
	 * 
	 */
	protected ComponentComponentPropertiesEditionComponent componentComponentPropertiesEditionComponent;

	/**
	 * The MetadataCptPropertiesEditionComponent sub component
	 * 
	 */
	protected MetadataCptPropertiesEditionComponent metadataCptPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param component the EObject to edit
	 * 
	 */
	public ComponentPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject component, String editing_mode) {
		super(editingContext, editing_mode);
		if (component instanceof Component) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(component, PropertiesEditingProvider.class);
			componentComponentPropertiesEditionComponent = (ComponentComponentPropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, ComponentComponentPropertiesEditionComponent.COMPONENT_PART, ComponentComponentPropertiesEditionComponent.class);
			addSubComponent(componentComponentPropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(component, PropertiesEditingProvider.class);
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
		if (ComponentComponentPropertiesEditionComponent.COMPONENT_PART.equals(key)) {
			componentPart = (ComponentPropertiesEditionPart)componentComponentPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)componentPart;
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
		if (SoaViewsRepository.Component.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			componentPart = (ComponentPropertiesEditionPart)propertiesEditionPart;
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
		if (key == SoaViewsRepository.Component.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EnvironmentViewsRepository.Metadatas.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
