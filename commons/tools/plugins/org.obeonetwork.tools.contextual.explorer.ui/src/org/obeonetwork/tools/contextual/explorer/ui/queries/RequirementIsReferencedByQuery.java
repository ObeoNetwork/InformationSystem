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
import java.util.Collection;
import java.util.List;

import org.eclipse.amalgam.explorer.contextual.core.query.IQuery;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.obeonetwork.dsl.requirement.CategoriesContainer;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.tools.contextual.explorer.ui.internal.utils.ContextualExplorerUtils;

/**
 * This query is used to compute the element that have a reference to the
 * {@link Requirement} or {@link CategoriesContainer}.
 * 
 * <p>
 * This query is contributed to the
 * <i>org.eclipse.amalgam.explorer.contextual.core.contentProviderCategory</i>
 * extension and apply this query only if {@link Requirement} or
 * {@link CategoriesContainer} are selected.
 * </p>
 */
public class RequirementIsReferencedByQuery implements IQuery {

	@Override
	public List<Object> compute(Object object_p) {
		List<Object> result = new ArrayList<>();
		if (object_p instanceof Requirement || object_p instanceof CategoriesContainer) {
			Collection<Setting> allInverseReferences = ContextualExplorerUtils.getAllReferring(object_p);
			for (Setting setting : allInverseReferences) {
				EObject eObject = setting.getEObject();
				if (ContextualExplorerUtils.isValidElement(eObject) || eObject instanceof Requirement || eObject instanceof CategoriesContainer) {
					result.add(eObject);
				}
			}
		}
		return result;
	}

}
