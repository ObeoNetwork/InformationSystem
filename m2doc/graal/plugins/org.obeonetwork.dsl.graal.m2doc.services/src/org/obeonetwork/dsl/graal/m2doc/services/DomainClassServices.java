/*******************************************************************************
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.graal.m2doc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.MetaData;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.tools.doc.core.DocumentationLink;

public class DomainClassServices {

	/**
	 * Return first annotation with the specified title
	 */
	public String annotation(ObeoDSMObject object, String title) {
		if (title == null) {
			return "";
		}
		MetaDataContainer metadataContainer = object.getMetadatas();
		if (metadataContainer != null) {
			for (MetaData data : metadataContainer.getMetadatas()) {
				if (data instanceof Annotation) {
					Annotation annotation = (Annotation) data;
					if (title.equals(annotation.getTitle())) {
						String result = annotation.getBody();
						if (result == null) {
							result = "";
						}
						return result;
					}
				}
			}
		}
		return "";
	}

	/**
	 * Retrieve all the {@link Annotation} which are considered as
	 * {@link DocumentationLink}.
	 * 
	 * @param object
	 * @return
	 */
	public List<Annotation> getDocumentationLinks(ObeoDSMObject object) {
		if (object.getMetadatas() != null) { 
			Stream<Annotation> annotations = object.getMetadatas().getMetadatas().stream()
					.filter(metadata -> metadata instanceof Annotation).map(metadata -> (Annotation) metadata);

			return annotations.filter(
					annotation -> annotation.getTitle().startsWith(DocumentationLink.DOCUMENTATION_ANNOTATION_TITLE))
					.collect(Collectors.toList());
		} else {
			return new ArrayList<>();
		}
	}
}
