/*******************************************************************************
 * Copyright (c) 2011, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.typeslibrary.providers;

import org.eclipse.emf.common.notify.Adapter;

public class CustomTypeslibraryEEFAdapterFactory extends TypeslibraryEEFAdapterFactory {

	@Override
	public Adapter createTypeInstanceAdapter() {
		return new CustomTypeInstancePropertiesEditionProvider();
	}
}
