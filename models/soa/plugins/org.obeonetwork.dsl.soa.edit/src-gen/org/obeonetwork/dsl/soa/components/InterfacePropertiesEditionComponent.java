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
import org.obeonetwork.dsl.soa.Interface;
import org.obeonetwork.dsl.soa.parts.Interface_PropertiesEditionPart;
import org.obeonetwork.dsl.soa.parts.SoaViewsRepository;

// End of user code

/**
 * @author Obeo
 * 
 */
public class InterfacePropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The Interface part
	 * 
	 */
	private Interface_PropertiesEditionPart interface_Part;

	/**
	 * The InterfaceInterface_PropertiesEditionComponent sub component
	 * 
	 */
	protected InterfaceInterface_PropertiesEditionComponent interfaceInterface_PropertiesEditionComponent;

	/**
	 * The MetadataCptPropertiesEditionComponent sub component
	 * 
	 */
	protected MetadataCptPropertiesEditionComponent metadataCptPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param interface_ the EObject to edit
	 * 
	 */
	public InterfacePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject interface_, String editing_mode) {
		super(editingContext, editing_mode);
		if (interface_ instanceof Interface) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(interface_, PropertiesEditingProvider.class);
			interfaceInterface_PropertiesEditionComponent = (InterfaceInterface_PropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, InterfaceInterface_PropertiesEditionComponent.INTERFACE__PART, InterfaceInterface_PropertiesEditionComponent.class);
			addSubComponent(interfaceInterface_PropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(interface_, PropertiesEditingProvider.class);
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
		if (InterfaceInterface_PropertiesEditionComponent.INTERFACE__PART.equals(key)) {
			interface_Part = (Interface_PropertiesEditionPart)interfaceInterface_PropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)interface_Part;
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
		if (SoaViewsRepository.Interface_.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			interface_Part = (Interface_PropertiesEditionPart)propertiesEditionPart;
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
		if (key == SoaViewsRepository.Interface_.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EnvironmentViewsRepository.Metadatas.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
