/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
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
package org.obeonetwork.dsl.cinematic.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.parts.CinematicRootPropertiesEditionPart;
import org.obeonetwork.dsl.cinematic.parts.CinematicViewsRepository;
import org.obeonetwork.dsl.cinematic.parts.ToolkitsPropertiesEditionPart;
import org.obeonetwork.dsl.environment.components.MetadataCptPropertiesEditionComponent;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;

// End of user code

/**
 * 
 * 
 */
public class CinematicRootPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The CinematicRoot part
	 * 
	 */
	private CinematicRootPropertiesEditionPart cinematicRootPart;

	/**
	 * The CinematicRootCinematicRootPropertiesEditionComponent sub component
	 * 
	 */
	protected CinematicRootCinematicRootPropertiesEditionComponent cinematicRootCinematicRootPropertiesEditionComponent;

	/**
	 * The Toolkits part
	 * 
	 */
	private ToolkitsPropertiesEditionPart toolkitsPart;

	/**
	 * The CinematicRootToolkitsPropertiesEditionComponent sub component
	 * 
	 */
	protected CinematicRootToolkitsPropertiesEditionComponent cinematicRootToolkitsPropertiesEditionComponent;

	/**
	 * The MetadataCptPropertiesEditionComponent sub component
	 * 
	 */
	protected MetadataCptPropertiesEditionComponent metadataCptPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param cinematicRoot the EObject to edit
	 * 
	 */
	public CinematicRootPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject cinematicRoot, String editing_mode) {
		super(editingContext, editing_mode);
		if (cinematicRoot instanceof CinematicRoot) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(cinematicRoot, PropertiesEditingProvider.class);
			cinematicRootCinematicRootPropertiesEditionComponent = (CinematicRootCinematicRootPropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, CinematicRootCinematicRootPropertiesEditionComponent.CINEMATICROOT_PART, CinematicRootCinematicRootPropertiesEditionComponent.class);
			addSubComponent(cinematicRootCinematicRootPropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(cinematicRoot, PropertiesEditingProvider.class);
			cinematicRootToolkitsPropertiesEditionComponent = (CinematicRootToolkitsPropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, CinematicRootToolkitsPropertiesEditionComponent.TOOLKITS_PART, CinematicRootToolkitsPropertiesEditionComponent.class);
			addSubComponent(cinematicRootToolkitsPropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(cinematicRoot, PropertiesEditingProvider.class);
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
		if (CinematicRootCinematicRootPropertiesEditionComponent.CINEMATICROOT_PART.equals(key)) {
			cinematicRootPart = (CinematicRootPropertiesEditionPart)cinematicRootCinematicRootPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)cinematicRootPart;
		}
		if (CinematicRootToolkitsPropertiesEditionComponent.TOOLKITS_PART.equals(key)) {
			toolkitsPart = (ToolkitsPropertiesEditionPart)cinematicRootToolkitsPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)toolkitsPart;
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
		if (CinematicViewsRepository.CinematicRoot.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			cinematicRootPart = (CinematicRootPropertiesEditionPart)propertiesEditionPart;
		}
		if (CinematicViewsRepository.Toolkits.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			toolkitsPart = (ToolkitsPropertiesEditionPart)propertiesEditionPart;
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
		if (key == CinematicViewsRepository.CinematicRoot.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == CinematicViewsRepository.Toolkits.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EnvironmentViewsRepository.Metadatas.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
