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
package org.obeonetwork.dsl.requirement.providers;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.obeonetwork.dsl.requirement.parts.RequirementViewsRepository;
import org.obeonetwork.dsl.requirement.parts.impl.CustomRequirementPropertiesEditionPartImpl;

/**
 * Specialize the EditionPartProvider to provide our custom class to edit Requirement in a wizard
 * @author sthibaudeau
 *
 */
public class CustomRequirementPropertiesEditionPartProvider extends RequirementPropertiesEditionPartProvider {

	@Override
	public IPropertiesEditionPart getPropertiesEditionPart(Object key, int kind, IPropertiesEditionComponent component) {
		if (key == RequirementViewsRepository.Requirement_.class) {
			if (kind == RequirementViewsRepository.SWT_KIND) {
				return new CustomRequirementPropertiesEditionPartImpl(component);
			}
		}
		return super.getPropertiesEditionPart(key, kind, component);
	}

}
