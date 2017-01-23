package org.obeonetwork.dsl.graal.m2doc.services;

import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.MetaData;
import org.obeonetwork.dsl.environment.ObeoDSMObject;

public class DomainClassServices {

	/**
	 * m:attr.metadatas.metadatas->filter(environment::Annotation)->select(a|a.
	 * title='PHYSICAL_SIZE')->asSequence().body->sep(' ')
	 */
	String annotation(ObeoDSMObject object, String title) {
		if (title == null) {
			return "";
		}
		for (MetaData data : object.getMetadatas().getMetadatas()) {
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
		return "";
	}

}
