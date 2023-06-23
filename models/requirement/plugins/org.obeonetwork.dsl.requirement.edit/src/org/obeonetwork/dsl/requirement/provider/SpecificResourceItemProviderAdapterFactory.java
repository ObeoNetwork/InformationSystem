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
package org.obeonetwork.dsl.requirement.provider;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

public class SpecificResourceItemProviderAdapterFactory extends ResourceItemProviderAdapterFactory {

	@Override
	public Adapter createResourceSetAdapter() {
		return new SpecificResourceSetItemProvider(this);
	}
}
