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

import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.MetaData;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;

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

}
