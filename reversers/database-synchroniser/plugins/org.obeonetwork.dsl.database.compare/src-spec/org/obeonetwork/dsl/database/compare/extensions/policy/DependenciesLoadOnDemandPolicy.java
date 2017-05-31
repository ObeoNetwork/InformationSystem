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
package org.obeonetwork.dsl.database.compare.extensions.policy;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.rcp.policy.ILoadOnDemandPolicy;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil;

import com.google.common.collect.Lists;

public class DependenciesLoadOnDemandPolicy implements ILoadOnDemandPolicy {
	
	private static final String[] PATHMAP_TO_CONSIDER = new String[] {
		TypesLibraryUtil.LOGICAL_PATHMAP,
		TypesLibraryUtil.MYSQL_PATHMAP,
		TypesLibraryUtil.ORACLE_PATHMAP,
		TypesLibraryUtil.POSTGRES_PATHMAP,
		TypesLibraryUtil.SQLSERVER_PATHMAP
	};
	
	private List<String> pathmapToConsider = null;
	
	public DependenciesLoadOnDemandPolicy() {
		pathmapToConsider = Lists.newArrayList(PATHMAP_TO_CONSIDER);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.ide.policy.ILoadOnDemandPolicy#isAuthorizing(org.eclipse.emf.compare.ide.policy.URI)
	 */
	public boolean isAuthorizing(URI uri) {
		return pathmapToConsider.contains(uri.toString());
	}

}
