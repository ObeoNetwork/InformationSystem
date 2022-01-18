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
package org.obeonetwork.tools.contextual.explorer.ui.queries;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.amalgam.explorer.contextual.core.query.IQuery;
import org.obeonetwork.dsl.requirement.CategoriesContainer;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.tools.contextual.explorer.ui.internal.utils.ContextualExplorerUtils;

/**
 * This query is used to compute all references of a
 * {@link CategoriesContainer}.
 * 
 * <p>
 * This query is contributed to the
 * <i>org.eclipse.amalgam.explorer.contextual.core.contentProviderCategory</i>
 * extension and apply this query only if {@link CategoriesContainer}.
 * </p>
 */
public class CategoriesContainerReferencesQuery implements IQuery {

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> compute(Object object_p) {
		List<Object> result = new ArrayList<>();
		if (object_p instanceof CategoriesContainer) {
			for (Object refValue : ContextualExplorerUtils.getAllReferencesValues(object_p)) {
				if (refValue instanceof List) {
					for (Object object : (List<? extends Object>) refValue) {
						if (ContextualExplorerUtils.isValidElement(object) || object instanceof Requirement || object instanceof CategoriesContainer) {
							result.add(object);
						}
					}
				} else if (ContextualExplorerUtils.isValidElement(refValue) || refValue instanceof Requirement || refValue instanceof CategoriesContainer) {
					result.add(refValue);
				}
			}
		}
		return result;
	}

}
