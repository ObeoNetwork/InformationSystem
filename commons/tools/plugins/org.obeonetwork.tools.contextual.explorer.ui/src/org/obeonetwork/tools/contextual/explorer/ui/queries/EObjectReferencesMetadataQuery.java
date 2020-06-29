/*******************************************************************************
 * Copyright (c) 2008, 2019 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.contextual.explorer.ui.queries;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.amalgam.explorer.contextual.core.query.IQuery;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;

/**
 * This query is used to compute Metadata of the selection.
 * 
 * <p>
 * This query is contributed to the
 * <i>org.eclipse.amalgam.explorer.contextual.core.contentProviderCategory</i>
 * extension and apply this query only if {@link ObeoDSMObject} are selected.
 * </p>
 */
public class EObjectReferencesMetadataQuery implements IQuery{

	@Override
	public List<Object> compute(Object arg0) {
		List<Object> result = new ArrayList<>();
		if (arg0 instanceof ObeoDSMObject) {
			MetaDataContainer metadatasContainer = ((ObeoDSMObject) arg0).getMetadatas();
			if (metadatasContainer != null) {
				result.addAll(metadatasContainer.getMetadatas());
			}
		}
		return result;
	}
}
