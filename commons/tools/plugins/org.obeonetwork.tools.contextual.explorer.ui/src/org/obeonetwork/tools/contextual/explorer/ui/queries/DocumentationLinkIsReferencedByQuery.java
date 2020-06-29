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
import java.util.Collection;
import java.util.List;

import org.eclipse.amalgam.explorer.contextual.core.query.IQuery;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.MetaData;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.tools.contextual.explorer.ui.internal.utils.ContextualExplorerUtils;

/**
 * This query is used to compute all element that have a reference to the given
 * documentation {@link Annotation}.
 * 
 * <p>
 * This query is contributed to the
 * <i>org.eclipse.amalgam.explorer.contextual.core.contentProviderCategory</i>
 * extension and apply this query only if {@link Annotation}.
 * </p>
 */
public class DocumentationLinkIsReferencedByQuery implements IQuery {

	@Override
	public List<Object> compute(Object object_p) {
		List<Object> result = new ArrayList<>();
		if (object_p instanceof MetaData && ContextualExplorerUtils.isDocumentationLink((MetaData) object_p)) {
			EObject annotationContainer = ((Annotation) object_p).eContainer();
			if (annotationContainer instanceof MetaDataContainer) {
				MetaDataContainer metadataContainer = (MetaDataContainer) annotationContainer;
				Collection<Setting> allInverseReferences = ContextualExplorerUtils.getAllInverseReferences(metadataContainer);
				for (Setting setting : allInverseReferences) {
					EObject eObject = setting.getEObject();
					if (ContextualExplorerUtils.isValidElement(eObject)) {
						result.add(eObject);
					}
				}
			}
		}
		return result;
	}

}
