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
package org.obeonetwork.dsl.environment.properties.internal.link.resolver;

import java.util.Iterator;

import org.eclipse.eef.EEFPageDescription;
import org.eclipse.eef.EEFViewDescription;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.properties.core.api.IDescriptionLinkResolver;
import org.eclipse.sirius.properties.core.api.TransformationCache;

/**
 * This link resolver is used to put the Metadata properties page in the end of
 * the list of page in order to prevent the metadata page to be selected by
 * default.
 */
public class MetadataEnvironmentPropertiesLinkResolver implements IDescriptionLinkResolver {

	private static final String METADATA_PAGE_IDENTIFIER = "Metadata Page";

	@Override
	public void resolve(EObject eObject, TransformationCache cache) {
		if (eObject instanceof EEFViewDescription) {
			EEFViewDescription viewDescription = (EEFViewDescription) eObject;
			EList<EEFPageDescription> pages = viewDescription.getPages();
			Iterator<EEFPageDescription> iterator = pages.iterator();
			EEFPageDescription foundPageDescription = null;
			while(foundPageDescription == null && iterator.hasNext()) {
				EEFPageDescription pageDescription = iterator.next();
				if (METADATA_PAGE_IDENTIFIER.equals(pageDescription.getIdentifier())) {
					foundPageDescription = pageDescription;
				}
			}
			if (foundPageDescription != null) {
				pages.move(pages.size() - 1, foundPageDescription);
			}
		}
	}

}
