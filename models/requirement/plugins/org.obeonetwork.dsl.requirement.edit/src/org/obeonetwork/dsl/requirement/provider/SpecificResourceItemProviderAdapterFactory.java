/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
