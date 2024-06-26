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
package org.obeonetwork.dsl.typeslibrary.policies;

import java.util.List;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.providers.impl.PropertiesEditingProviderImpl;

public abstract class CustomPropertiesEditingProvider extends PropertiesEditingProviderImpl {


	public CustomPropertiesEditingProvider() {
		super();
	}
	
	public CustomPropertiesEditingProvider(List<PropertiesEditingProvider> superProviders) {
		super(superProviders);
	}

	@Override
	public PropertiesEditingPolicy getPolicy(PropertiesEditingContext context) {
		if (context instanceof EReferencePropertiesEditionContext) {
			return new CreateEditingPolicy((EReferencePropertiesEditionContext) context);
		}
		if (context instanceof EObjectPropertiesEditionContext) {
			return new CustomEditingPolicy((PropertiesEditingContext) context);
		}
		return null;
	}

}