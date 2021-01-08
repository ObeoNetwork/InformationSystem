/**
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 */
package fr.gouv.mindef.safran.graalextensions.providers;

import fr.gouv.mindef.safran.graalextensions.parts.GraalextensionsViewsRepository;

import fr.gouv.mindef.safran.graalextensions.parts.forms.RiskPropertiesEditionPartForm;
import fr.gouv.mindef.safran.graalextensions.parts.forms.VersionPropertiesEditionPartForm;

import fr.gouv.mindef.safran.graalextensions.parts.impl.RiskPropertiesEditionPartImpl;
import fr.gouv.mindef.safran.graalextensions.parts.impl.VersionPropertiesEditionPartImpl;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;

/**
 * @author Obeo.fr
 * 
 */
public class GraalextensionsPropertiesEditionPartProvider implements IPropertiesEditionPartProvider {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Object)
	 * 
	 */
	public boolean provides(Object key) {
		return key == GraalextensionsViewsRepository.class;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Object, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(Object key, int kind, IPropertiesEditionComponent component) {
		if (key == GraalextensionsViewsRepository.Version.class) {
			if (kind == GraalextensionsViewsRepository.SWT_KIND)
				return new VersionPropertiesEditionPartImpl(component);
			if (kind == GraalextensionsViewsRepository.FORM_KIND)
				return new VersionPropertiesEditionPartForm(component);
		}
		if (key == GraalextensionsViewsRepository.Risk.class) {
			if (kind == GraalextensionsViewsRepository.SWT_KIND)
				return new RiskPropertiesEditionPartImpl(component);
			if (kind == GraalextensionsViewsRepository.FORM_KIND)
				return new RiskPropertiesEditionPartForm(component);
		}
		return null;
	}

}
