/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
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
package org.obeonetwork.dsl.requirement.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.dsl.requirement.parts.AdvancedPropertiesEditionPart;
import org.obeonetwork.dsl.requirement.parts.RequirementPropertiesEditionPart;
import org.obeonetwork.dsl.requirement.parts.RequirementViewsRepository;

// End of user code

/**
 * 
 * 
 */
public class RequirementPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The Requirement part
	 * 
	 */
	private RequirementPropertiesEditionPart requirementPart;

	/**
	 * The RequirementRequirementPropertiesEditionComponent sub component
	 * 
	 */
	protected RequirementRequirementPropertiesEditionComponent requirementRequirementPropertiesEditionComponent;

	/**
	 * The Advanced part
	 * 
	 */
	private AdvancedPropertiesEditionPart advancedPart;

	/**
	 * The RequirementAdvancedPropertiesEditionComponent sub component
	 * 
	 */
	protected RequirementAdvancedPropertiesEditionComponent requirementAdvancedPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param requirement the EObject to edit
	 * 
	 */
	public RequirementPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject requirement, String editing_mode) {
		super(editingContext, editing_mode);
		if (requirement instanceof Requirement) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(requirement, PropertiesEditingProvider.class);
			requirementRequirementPropertiesEditionComponent = (RequirementRequirementPropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, RequirementRequirementPropertiesEditionComponent.REQUIREMENT_PART, RequirementRequirementPropertiesEditionComponent.class);
			addSubComponent(requirementRequirementPropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(requirement, PropertiesEditingProvider.class);
			requirementAdvancedPropertiesEditionComponent = (RequirementAdvancedPropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, RequirementAdvancedPropertiesEditionComponent.ADVANCED_PART, RequirementAdvancedPropertiesEditionComponent.class);
			addSubComponent(requirementAdvancedPropertiesEditionComponent);
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
		if (RequirementRequirementPropertiesEditionComponent.REQUIREMENT_PART.equals(key)) {
			requirementPart = (RequirementPropertiesEditionPart)requirementRequirementPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)requirementPart;
		}
		if (RequirementAdvancedPropertiesEditionComponent.ADVANCED_PART.equals(key)) {
			advancedPart = (AdvancedPropertiesEditionPart)requirementAdvancedPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)advancedPart;
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
		if (RequirementViewsRepository.Requirement_.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			requirementPart = (RequirementPropertiesEditionPart)propertiesEditionPart;
		}
		if (RequirementViewsRepository.Advanced.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			advancedPart = (AdvancedPropertiesEditionPart)propertiesEditionPart;
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
		if (key == RequirementViewsRepository.Requirement_.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == RequirementViewsRepository.Advanced.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
