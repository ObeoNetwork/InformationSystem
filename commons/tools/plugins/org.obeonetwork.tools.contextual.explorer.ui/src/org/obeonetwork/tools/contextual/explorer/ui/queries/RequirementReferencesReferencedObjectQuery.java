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
package org.obeonetwork.tools.contextual.explorer.ui.queries;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.amalgam.explorer.contextual.core.query.IQuery;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.dsl.requirement.RequirementPackage;

/**
 * This query is used to compute element referenced by the given
 * {@link Requirement} by the reference
 * {@link RequirementPackage.Literals#REQUIREMENT__REFERENCED_OBJECT}.
 * 
 * <p>
 * This query is contributed to the
 * <i>org.eclipse.amalgam.explorer.contextual.core.contentProviderCategory</i>
 * extension and apply this query only if {@link Requirement} are selected.
 * </p>
 */
public class RequirementReferencesReferencedObjectQuery implements IQuery {

	@Override
	public List<Object> compute(Object arg0) {
		List<Object> result = new ArrayList<>();
		if (arg0 instanceof Requirement) {
			result.addAll(((Requirement) arg0).getReferencedObject());
		}
		return result;
	}
}
