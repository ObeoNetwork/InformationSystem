/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
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
import org.obeonetwork.dsl.cinematic.view.ViewElement;
import org.obeonetwork.dsl.cinematic.view.parts.ViewElementPropertiesEditionPart;
import org.obeonetwork.dsl.cinematic.view.parts.ViewViewsRepository;
import org.obeonetwork.dsl.environment.components.MetadataCptPropertiesEditionComponent;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;

// End of user code

/**
 * 
 * 
 */
public class ViewElementPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The ViewElement part
	 * 
	 */
	private ViewElementPropertiesEditionPart viewElementPart;

	/**
	 * The ViewElementViewElementPropertiesEditionComponent sub component
	 * 
	 */
	protected ViewElementViewElementPropertiesEditionComponent viewElementViewElementPropertiesEditionComponent;

	/**
	 * The MetadataCptPropertiesEditionComponent sub component
	 * 
	 */
	protected MetadataCptPropertiesEditionComponent metadataCptPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param viewElement the EObject to edit
	 * 
	 */
	public ViewElementPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject viewElement, String editing_mode) {
		super(editingContext, editing_mode);
		if (viewElement instanceof ViewElement) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(viewElement, PropertiesEditingProvider.class);
			viewElementViewElementPropertiesEditionComponent = (ViewElementViewElementPropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, ViewElementViewElementPropertiesEditionComponent.VIEWELEMENT_PART, ViewElementViewElementPropertiesEditionComponent.class);
			addSubComponent(viewElementViewElementPropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(viewElement, PropertiesEditingProvider.class);
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
		if (ViewElementViewElementPropertiesEditionComponent.VIEWELEMENT_PART.equals(key)) {
			viewElementPart = (ViewElementPropertiesEditionPart)viewElementViewElementPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)viewElementPart;
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
		if (ViewViewsRepository.ViewElement.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			viewElementPart = (ViewElementPropertiesEditionPart)propertiesEditionPart;
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
		if (key == ViewViewsRepository.ViewElement.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EnvironmentViewsRepository.Metadatas.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
