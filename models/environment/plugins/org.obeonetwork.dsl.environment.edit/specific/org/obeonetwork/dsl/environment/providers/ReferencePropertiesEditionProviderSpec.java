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
package org.obeonetwork.dsl.environment.providers;

import java.util.List;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.components.ReferenceOppositePropertiesEditionComponent;
import org.obeonetwork.dsl.environment.components.ReferenceOppositePropertiesEditionComponentSpec;

/**
 * Specific provider for reference.
 * 
 * @author ymortier
 */
public class ReferencePropertiesEditionProviderSpec extends ReferencePropertiesEditionProvider {

	/**
	 * Constructor without provider for super types.
	 */
	public ReferencePropertiesEditionProviderSpec() {
		super();
	}

	/**
	 * Constructor with providers for super types.
	 * 
	 * @param superProviders
	 *            providers to use for super types.
	 */
	public ReferencePropertiesEditionProviderSpec(List<PropertiesEditingProvider> superProviders) {
		super(superProviders);
	}

	@Override
	public IPropertiesEditionComponent getPropertiesEditingComponent(PropertiesEditingContext editingContext,
			String mode, String part) {
		if (editingContext.getEObject() instanceof Reference) {
			if (ReferenceOppositePropertiesEditionComponent.OPPOSITE_PART.equals(part)) {
				return new ReferenceOppositePropertiesEditionComponentSpec(editingContext, editingContext.getEObject(),
						mode);
			}
		}
		return super.getPropertiesEditingComponent(editingContext, mode, part);
	}

	@Override
	public IPropertiesEditionComponent getPropertiesEditingComponent(PropertiesEditingContext editingContext,
			String mode, String part, @SuppressWarnings("rawtypes") Class refinement) {
		if (editingContext.getEObject() instanceof Reference) {
			if (ReferenceOppositePropertiesEditionComponent.OPPOSITE_PART.equals(part)
					&& refinement == ReferenceOppositePropertiesEditionComponent.class) {
				return new ReferenceOppositePropertiesEditionComponentSpec(editingContext, editingContext.getEObject(),
						mode);
			}
		}
		return super.getPropertiesEditingComponent(editingContext, mode, part, refinement);
	}

}
