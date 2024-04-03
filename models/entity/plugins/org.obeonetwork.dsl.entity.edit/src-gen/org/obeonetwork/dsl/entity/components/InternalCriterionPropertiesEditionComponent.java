/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
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
import org.obeonetwork.dsl.entity.InternalCriterion;
import org.obeonetwork.dsl.entity.parts.EntityViewsRepository;
import org.obeonetwork.dsl.entity.parts.InternalCriterionPropertiesEditionPart;
import org.obeonetwork.dsl.environment.components.MetadataCptPropertiesEditionComponent;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;

// End of user code

/**
 * @author Obeo
 * 
 */
public class InternalCriterionPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The InternalCriterion part
	 * 
	 */
	private InternalCriterionPropertiesEditionPart internalCriterionPart;

	/**
	 * The InternalCriterionInternalCriterionPropertiesEditionComponent sub component
	 * 
	 */
	protected InternalCriterionInternalCriterionPropertiesEditionComponent internalCriterionInternalCriterionPropertiesEditionComponent;

	/**
	 * The MetadataCptPropertiesEditionComponent sub component
	 * 
	 */
	protected MetadataCptPropertiesEditionComponent metadataCptPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param internalCriterion the EObject to edit
	 * 
	 */
	public InternalCriterionPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject internalCriterion, String editing_mode) {
		super(editingContext, editing_mode);
		if (internalCriterion instanceof InternalCriterion) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(internalCriterion, PropertiesEditingProvider.class);
			internalCriterionInternalCriterionPropertiesEditionComponent = (InternalCriterionInternalCriterionPropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, InternalCriterionInternalCriterionPropertiesEditionComponent.INTERNALCRITERION_PART, InternalCriterionInternalCriterionPropertiesEditionComponent.class);
			addSubComponent(internalCriterionInternalCriterionPropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(internalCriterion, PropertiesEditingProvider.class);
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
		if (InternalCriterionInternalCriterionPropertiesEditionComponent.INTERNALCRITERION_PART.equals(key)) {
			internalCriterionPart = (InternalCriterionPropertiesEditionPart)internalCriterionInternalCriterionPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)internalCriterionPart;
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
		if (EntityViewsRepository.InternalCriterion.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			internalCriterionPart = (InternalCriterionPropertiesEditionPart)propertiesEditionPart;
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
		if (key == EntityViewsRepository.InternalCriterion.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EnvironmentViewsRepository.Metadatas.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
