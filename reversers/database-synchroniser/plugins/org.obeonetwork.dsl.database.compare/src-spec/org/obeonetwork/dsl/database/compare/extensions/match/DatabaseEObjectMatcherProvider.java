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
package org.obeonetwork.dsl.database.compare.extensions.match;

import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.obeonetwork.dsl.is.compare.IEObjectMatcherProvider;

public class DatabaseEObjectMatcherProvider implements IEObjectMatcherProvider {

	@Override
	public IEObjectMatcher getMatcher() {
		return DatabaseMatchEngineFactory.getDatabaseEObjectMatcher();
	}

}
