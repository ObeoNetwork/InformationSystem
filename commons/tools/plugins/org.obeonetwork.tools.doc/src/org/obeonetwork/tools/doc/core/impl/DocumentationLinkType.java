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
/**
 * 
 */
package org.obeonetwork.tools.doc.core.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.MetaData;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.tools.doc.core.DocumentationLink;
import org.obeonetwork.tools.linker.EObjectLink;
import org.obeonetwork.tools.linker.LinkType;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class DocumentationLinkType implements LinkType {

	public static final String DOCUMENTATION_LINK_TYPE = "org.obeonetwork.tools.doc.linkType"; //$NON-NLS-1$
	
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.LinkType#getId()
	 */
	public String getId() {
		return DOCUMENTATION_LINK_TYPE;
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.LinkType#loadLinks(org.eclipse.emf.ecore.EObject)
	 */
	public List<EObjectLink> loadLinks(EObject source) {
		if (source instanceof ObeoDSMObject) {
			ObeoDSMObject element = (ObeoDSMObject) source;
			MetaDataContainer metadatas = element.getMetadatas();
			if (metadatas != null) {
				List<EObjectLink> result = new ArrayList<EObjectLink>();
				for (MetaData metadata : metadatas.getMetadatas()) {
					if (metadata instanceof Annotation) {
						Annotation annotation = (Annotation) metadata;
						if (annotation.getTitle() != null && annotation.getTitle().startsWith(DocumentationLink.DOCUMENTATION_ANNOTATION_TITLE)) {
							DocumentationLink link = new DocumentationLinkImpl(annotation);
							result.add(link);
						}
					}
				}
				return result;
			}

		}
		return Collections.emptyList();
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.LinkType#createLink(org.eclipse.emf.ecore.EObject)
	 */
	public DocumentationLink createLink(EObject source) {
		if (source instanceof ObeoDSMObject) {
			DocumentationLink result = new DocumentationLinkImpl((ObeoDSMObject) source);
			return result;

		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.LinkType#delete(org.obeonetwork.tools.linker.EObjectLink)
	 */
	public void delete(EObjectLink link) {
		((DocumentationLink)link).delete();
	}

}
