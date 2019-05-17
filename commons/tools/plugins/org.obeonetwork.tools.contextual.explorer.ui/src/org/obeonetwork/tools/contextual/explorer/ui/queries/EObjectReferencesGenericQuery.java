/*******************************************************************************
 * Copyright (c) 2019 Obeo.
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
import org.obeonetwork.dsl.database.DatabaseElement;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.tools.contextual.explorer.ui.internal.utils.ContextualExplorerUtils;

/**
 * This query is used to compute the list of references of the given object.
 * 
 * <p>
 * This query is contributed to the
 * <i>org.eclipse.amalgam.explorer.contextual.core.contentProviderCategory</i>
 * extension and apply this query only if {@link ObeoDSMObject} or
 * {@link DatabaseElement} are selected.
 * </p>
 */
public class EObjectReferencesGenericQuery implements IQuery {

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> compute(Object arg0) {
		List<Object> result = new ArrayList<>();
		if (ContextualExplorerUtils.isValidElement(arg0)) {
			for (Object refValue : ContextualExplorerUtils.getAllReferencesValues(arg0)) {
				if (refValue instanceof List) {
					for (Object object : (List<? extends Object>) refValue) {
						if (ContextualExplorerUtils.isValidElement(object)) {
							result.add(object);
						}
					}
				} else if (ContextualExplorerUtils.isValidElement(refValue)) {
					result.add(refValue);
				}
			}
		}
		return result;
	}
}
