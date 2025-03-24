/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.requirement.providers;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;

import org.obeonetwork.dsl.requirement.parts.RequirementViewsRepository;

import org.obeonetwork.dsl.requirement.parts.forms.AdvancedPropertiesEditionPartForm;
import org.obeonetwork.dsl.requirement.parts.forms.CategoryPropertiesEditionPartForm;
import org.obeonetwork.dsl.requirement.parts.forms.RepositoryPropertiesEditionPartForm;
import org.obeonetwork.dsl.requirement.parts.forms.RequirementPropertiesEditionPartForm;

import org.obeonetwork.dsl.requirement.parts.impl.AdvancedPropertiesEditionPartImpl;
import org.obeonetwork.dsl.requirement.parts.impl.CategoryPropertiesEditionPartImpl;
import org.obeonetwork.dsl.requirement.parts.impl.RepositoryPropertiesEditionPartImpl;
import org.obeonetwork.dsl.requirement.parts.impl.RequirementPropertiesEditionPartImpl;

/**
 * 
 * 
 */
public class RequirementPropertiesEditionPartProvider implements IPropertiesEditionPartProvider {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Object)
	 * 
	 */
	public boolean provides(Object key) {
		return key == RequirementViewsRepository.class;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Object, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(Object key, int kind, IPropertiesEditionComponent component) {
		if (key == RequirementViewsRepository.Repository.class) {
			if (kind == RequirementViewsRepository.SWT_KIND)
				return new RepositoryPropertiesEditionPartImpl(component);
			if (kind == RequirementViewsRepository.FORM_KIND)
				return new RepositoryPropertiesEditionPartForm(component);
		}
		if (key == RequirementViewsRepository.Category.class) {
			if (kind == RequirementViewsRepository.SWT_KIND)
				return new CategoryPropertiesEditionPartImpl(component);
			if (kind == RequirementViewsRepository.FORM_KIND)
				return new CategoryPropertiesEditionPartForm(component);
		}
		if (key == RequirementViewsRepository.Requirement_.class) {
			if (kind == RequirementViewsRepository.SWT_KIND)
				return new RequirementPropertiesEditionPartImpl(component);
			if (kind == RequirementViewsRepository.FORM_KIND)
				return new RequirementPropertiesEditionPartForm(component);
		}
		if (key == RequirementViewsRepository.Advanced.class) {
			if (kind == RequirementViewsRepository.SWT_KIND)
				return new AdvancedPropertiesEditionPartImpl(component);
			if (kind == RequirementViewsRepository.FORM_KIND)
				return new AdvancedPropertiesEditionPartForm(component);
		}
		return null;
	}

}
