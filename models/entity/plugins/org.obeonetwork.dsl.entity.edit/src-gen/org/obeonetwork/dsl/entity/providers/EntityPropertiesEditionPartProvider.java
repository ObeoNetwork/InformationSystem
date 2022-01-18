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
package org.obeonetwork.dsl.entity.providers;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;

import org.obeonetwork.dsl.entity.parts.EntityViewsRepository;

import org.obeonetwork.dsl.entity.parts.forms.EntityPropertiesEditionPartForm;
import org.obeonetwork.dsl.entity.parts.forms.ExternalCriterionPropertiesEditionPartForm;
import org.obeonetwork.dsl.entity.parts.forms.FinderPropertiesEditionPartForm;
import org.obeonetwork.dsl.entity.parts.forms.InternalCriterionPropertiesEditionPartForm;
import org.obeonetwork.dsl.entity.parts.forms.PersistencePropertiesEditionPartForm;
import org.obeonetwork.dsl.entity.parts.forms.RootPropertiesEditionPartForm;

import org.obeonetwork.dsl.entity.parts.impl.EntityPropertiesEditionPartImpl;
import org.obeonetwork.dsl.entity.parts.impl.ExternalCriterionPropertiesEditionPartImpl;
import org.obeonetwork.dsl.entity.parts.impl.FinderPropertiesEditionPartImpl;
import org.obeonetwork.dsl.entity.parts.impl.InternalCriterionPropertiesEditionPartImpl;
import org.obeonetwork.dsl.entity.parts.impl.PersistencePropertiesEditionPartImpl;
import org.obeonetwork.dsl.entity.parts.impl.RootPropertiesEditionPartImpl;

/**
 * @author <a href="mailto:jerome.benois@obeo.fr>Jérôme Benois</a>
 * 
 */
public class EntityPropertiesEditionPartProvider implements IPropertiesEditionPartProvider {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Object)
	 * 
	 */
	public boolean provides(Object key) {
		return key == EntityViewsRepository.class;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Object, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(Object key, int kind, IPropertiesEditionComponent component) {
		if (key == EntityViewsRepository.Root.class) {
			if (kind == EntityViewsRepository.SWT_KIND)
				return new RootPropertiesEditionPartImpl(component);
			if (kind == EntityViewsRepository.FORM_KIND)
				return new RootPropertiesEditionPartForm(component);
		}
		if (key == EntityViewsRepository.Entity_.class) {
			if (kind == EntityViewsRepository.SWT_KIND)
				return new EntityPropertiesEditionPartImpl(component);
			if (kind == EntityViewsRepository.FORM_KIND)
				return new EntityPropertiesEditionPartForm(component);
		}
		if (key == EntityViewsRepository.Persistence.class) {
			if (kind == EntityViewsRepository.SWT_KIND)
				return new PersistencePropertiesEditionPartImpl(component);
			if (kind == EntityViewsRepository.FORM_KIND)
				return new PersistencePropertiesEditionPartForm(component);
		}
		if (key == EntityViewsRepository.Finder.class) {
			if (kind == EntityViewsRepository.SWT_KIND)
				return new FinderPropertiesEditionPartImpl(component);
			if (kind == EntityViewsRepository.FORM_KIND)
				return new FinderPropertiesEditionPartForm(component);
		}
		if (key == EntityViewsRepository.InternalCriterion.class) {
			if (kind == EntityViewsRepository.SWT_KIND)
				return new InternalCriterionPropertiesEditionPartImpl(component);
			if (kind == EntityViewsRepository.FORM_KIND)
				return new InternalCriterionPropertiesEditionPartForm(component);
		}
		if (key == EntityViewsRepository.ExternalCriterion.class) {
			if (kind == EntityViewsRepository.SWT_KIND)
				return new ExternalCriterionPropertiesEditionPartImpl(component);
			if (kind == EntityViewsRepository.FORM_KIND)
				return new ExternalCriterionPropertiesEditionPartForm(component);
		}
		return null;
	}

}
