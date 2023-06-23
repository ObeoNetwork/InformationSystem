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
package org.obeonetwork.tools.contextual.explorer.ui.queries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.amalgam.explorer.contextual.core.query.IQuery;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.dsl.requirement.RequirementPackage;
import org.obeonetwork.tools.contextual.explorer.ui.internal.utils.ContextualExplorerUtils;

/**
 * This query is used to compute the list of all references of a
 * {@link Requirement} except elements coming from the reference
 * {@link RequirementPackage.Literals#REQUIREMENT__REFERENCED_OBJECT}. Those
 * references are computed by
 * {@link RequirementReferencesReferencedObjectQuery}.
 *
 * <p>
 * This query is contributed to the
 * <i>org.eclipse.amalgam.explorer.contextual.core.contentProviderCategory</i>
 * extension and apply this query only if {@link Requirement} are selected.
 * </p>
 */
public class RequirementReferencesOtherQuery implements IQuery {

	@Override
	public List<Object> compute(Object object_p) {
		if (object_p instanceof Requirement) {
			Collection<Object> referencesValues = ContextualExplorerUtils.getAllReferencesValues(object_p);
			IQuery query = new RequirementReferencesReferencedObjectQuery();
			List<Object> compute = query.compute(object_p);
			// Display all elements except those which are displayed in the referenced object category (result of RequirementReferencesReferencedObjectQuery)
			referencesValues.removeIf(rv -> shouldRemove(rv, compute));
			return new ArrayList<>(referencesValues);
		}
		return Collections.emptyList();
	}
	
	private boolean shouldRemove(Object referenceValue, List<Object> requirementReferencedObjectResult) {
		if (referenceValue instanceof List<?>) {
			List<?> list = (List<?>) referenceValue;
			return list.equals(requirementReferencedObjectResult);
		} else {
			return requirementReferencedObjectResult.contains(referenceValue);
		}
	}
}
