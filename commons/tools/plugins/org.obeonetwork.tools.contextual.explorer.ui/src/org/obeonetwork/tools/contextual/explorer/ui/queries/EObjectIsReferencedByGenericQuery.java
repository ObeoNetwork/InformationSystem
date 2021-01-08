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
package org.obeonetwork.tools.contextual.explorer.ui.queries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.amalgam.explorer.contextual.core.query.IQuery;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.obeonetwork.dsl.database.DatabaseElement;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.tools.contextual.explorer.ui.internal.utils.ContextualExplorerUtils;

/**
 * This query is used to compute elements that have a reference to the given
 * object.
 * 
 * <p>
 * This query is contributed to the
 * <i>org.eclipse.amalgam.explorer.contextual.core.contentProviderCategory</i>
 * extension and apply this query only if {@link ObeoDSMObject} or
 * {@link DatabaseElement} are selected.
 * </p>
 */
public class EObjectIsReferencedByGenericQuery implements IQuery {

	@Override
	public List<Object> compute(Object arg0) {
		List<Object> result = new ArrayList<>();
		Collection<Setting> allInverseReferences = ContextualExplorerUtils.getAllReferring(arg0);
		for (Setting setting : allInverseReferences) {
			EObject eObject = setting.getEObject();
			if (ContextualExplorerUtils.isValidElement(eObject)) {
				result.add(eObject);
			}
		}
		return result;
	}
}
