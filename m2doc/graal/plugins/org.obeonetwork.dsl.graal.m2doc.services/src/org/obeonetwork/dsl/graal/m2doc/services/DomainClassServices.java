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
