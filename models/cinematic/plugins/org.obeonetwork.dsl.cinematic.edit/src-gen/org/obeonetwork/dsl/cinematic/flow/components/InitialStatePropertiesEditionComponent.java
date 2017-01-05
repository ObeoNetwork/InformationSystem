/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo.
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
package org.obeonetwork.dsl.cinematic.flow.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.obeonetwork.dsl.cinematic.flow.InitialState;
import org.obeonetwork.dsl.cinematic.flow.parts.FlowViewsRepository;
import org.obeonetwork.dsl.cinematic.flow.parts.InitialStatePropertiesEditionPart;
import org.obeonetwork.dsl.environment.components.MetadataCptPropertiesEditionComponent;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;

// End of user code

/**
 * 
 * 
 */
public class InitialStatePropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The InitialState part
	 * 
	 */
	private InitialStatePropertiesEditionPart initialStatePart;

	/**
	 * The InitialStateInitialStatePropertiesEditionComponent sub component
	 * 
	 */
	protected InitialStateInitialStatePropertiesEditionComponent initialStateInitialStatePropertiesEditionComponent;

	/**
	 * The MetadataCptPropertiesEditionComponent sub component
	 * 
	 */
	protected MetadataCptPropertiesEditionComponent metadataCptPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param initialState the EObject to edit
	 * 
	 */
	public InitialStatePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject initialState, String editing_mode) {
		super(editingContext, editing_mode);
		if (initialState instanceof InitialState) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(initialState, PropertiesEditingProvider.class);
			initialStateInitialStatePropertiesEditionComponent = (InitialStateInitialStatePropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, InitialStateInitialStatePropertiesEditionComponent.INITIALSTATE_PART, InitialStateInitialStatePropertiesEditionComponent.class);
			addSubComponent(initialStateInitialStatePropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(initialState, PropertiesEditingProvider.class);
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
		if (InitialStateInitialStatePropertiesEditionComponent.INITIALSTATE_PART.equals(key)) {
			initialStatePart = (InitialStatePropertiesEditionPart)initialStateInitialStatePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)initialStatePart;
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
		if (FlowViewsRepository.InitialState.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			initialStatePart = (InitialStatePropertiesEditionPart)propertiesEditionPart;
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
		if (key == FlowViewsRepository.InitialState.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EnvironmentViewsRepository.Metadatas.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
