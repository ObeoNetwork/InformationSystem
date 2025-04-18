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
package org.obeonetwork.dsl.cinematic.providers;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.obeonetwork.dsl.cinematic.parts.CinematicViewsRepository;
import org.obeonetwork.dsl.cinematic.parts.forms.CinematicRootPropertiesEditionPartForm;
import org.obeonetwork.dsl.cinematic.parts.forms.Package_PropertiesEditionPartForm;
import org.obeonetwork.dsl.cinematic.parts.forms.ToolkitsPropertiesEditionPartForm;

import org.obeonetwork.dsl.cinematic.parts.impl.CinematicRootPropertiesEditionPartImpl;
import org.obeonetwork.dsl.cinematic.parts.impl.Package_PropertiesEditionPartImpl;
import org.obeonetwork.dsl.cinematic.parts.impl.ToolkitsPropertiesEditionPartImpl;

/**
 * 
 * 
 */
public class CinematicPropertiesEditionPartProvider implements IPropertiesEditionPartProvider {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Object)
	 * 
	 */
	public boolean provides(Object key) {
		return key == CinematicViewsRepository.class;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Object, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(Object key, int kind, IPropertiesEditionComponent component) {
		if (key == CinematicViewsRepository.Package_.class) {
			if (kind == CinematicViewsRepository.SWT_KIND)
				return new Package_PropertiesEditionPartImpl(component);
			if (kind == CinematicViewsRepository.FORM_KIND)
				return new Package_PropertiesEditionPartForm(component);
		}
		if (key == CinematicViewsRepository.CinematicRoot.class) {
			if (kind == CinematicViewsRepository.SWT_KIND)
				return new CinematicRootPropertiesEditionPartImpl(component);
			if (kind == CinematicViewsRepository.FORM_KIND)
				return new CinematicRootPropertiesEditionPartForm(component);
		}
		if (key == CinematicViewsRepository.Toolkits.class) {
			if (kind == CinematicViewsRepository.SWT_KIND)
				return new ToolkitsPropertiesEditionPartImpl(component);
			if (kind == CinematicViewsRepository.FORM_KIND)
				return new ToolkitsPropertiesEditionPartForm(component);
		}
		return null;
	}

}
