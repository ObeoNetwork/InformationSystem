/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.database.transfo.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.dsl.database.Constraint;
import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.MetaData;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.typeslibrary.NativeTypeKind;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;

public class AnnotationHelper {

	private static final String PHYSICAL_SIZE_KEY = "PHYSICAL_SIZE";
	private static final String PHYSICAL_CHECK_KEY = "PHYSICAL_CHECK";
	private static final String PHYSICAL_DEFAULT_KEY = "PHYSICAL_DEFAULT";
	private static final String PHYSICAL_NAME_KEY = "PHYSICAL_NAME";
	private static final String PHYSICAL_UNIQUE_KEY = "PHYSICAL_UNIQUE";
	private static final String PHYSICAL_TARGET_KEY = "PHYSICAL_TARGET";
	
	private static final String CONSTRAINT_DELIMITER = "|";
	private static final String CONSTRAINT_DELIMITER_REGEX = "\\|"; // REGEX used to delimit constraints within a single PHYSICAL_CHECK annotation
	
	public static void setPhysicalSize(ObeoDSMObject dsmObject, TypeInstance typeInstance) {
		if (typeInstance != null && typeInstance.getNativeType() != null) {
			String size = "";
			if (typeInstance.getNativeType().getSpec().equals(NativeTypeKind.LENGTH)) {
				if (typeInstance.getLength() != null) {
					size = String.valueOf(typeInstance.getLength());
				}
			} else if (typeInstance.getNativeType().getSpec().equals(NativeTypeKind.LENGTH_AND_PRECISION)) {
				String length = "";
				String precision = "";
				if (typeInstance.getLength() != null) {
					length = String.valueOf(typeInstance.getLength());
				}
				if (typeInstance.getPrecision() != null) {
					precision = String.valueOf(typeInstance.getPrecision());
				}
				size = length + "," + precision;
			}
			if (size.length() > 0 && size != ",") {
				setAnnotation(dsmObject, PHYSICAL_SIZE_KEY, size);
			} else {
				setAnnotation(dsmObject, PHYSICAL_SIZE_KEY, null);
			}
		} else {
			setAnnotation(dsmObject, PHYSICAL_SIZE_KEY, null);
		}
	}
	
	public static void setPhysicalUniqueAnnotation(ObeoDSMObject dsmObject, String value) {
		setAnnotation(dsmObject, PHYSICAL_UNIQUE_KEY, value);
	}

	public static void setPhysicalNameAnnotation(ObeoDSMObject dsmObject, String value) {
		setAnnotation(dsmObject, PHYSICAL_NAME_KEY, value);
	}
	
	public static void setPhysicalDefaultAnnotation(ObeoDSMObject dsmObject, String value) {
		String newValue = (value == null || value.trim().length() == 0) ? null : value;
		setAnnotation(dsmObject, PHYSICAL_DEFAULT_KEY, newValue);
	}
	
	public static void setAnnotation(ObeoDSMObject dsmObject, String key, String value) {
		Annotation annotation = getAnnotation(dsmObject, key);
		if (value == null) {
			if (annotation != null) {
				// then we have to remove the annotation
				EcoreUtil.delete(annotation);
			}
			return;
		}
		if (annotation == null) {
			MetaDataContainer metaDataContainer = getOrCreateMetaDataContainer(dsmObject);
			annotation = EnvironmentFactory.eINSTANCE.createAnnotation();
			metaDataContainer.getMetadatas().add(annotation);
			annotation.setTitle(key);
		}
		annotation.setBody(value);
	}
	
	public static void removePhysicalCheckAnnotations(ObeoDSMObject dsmObject) {
		removeAnnotations(dsmObject, PHYSICAL_CHECK_KEY);
	}
	
	public static void removePhysicalUniqueAnnotations(ObeoDSMObject dsmObject) {
		removeAnnotations(dsmObject, PHYSICAL_UNIQUE_KEY);
	}
	
	public static void removeAnnotations(ObeoDSMObject dsmObject, String key) {
		MetaDataContainer metaDataContainer = dsmObject.getMetadatas();
		if (metaDataContainer != null) {
			Collection<Annotation> annotationsToBeDeleted = new ArrayList<Annotation>();
			for (MetaData metadata : metaDataContainer.getMetadatas()) {
				if (metadata instanceof Annotation) {
					Annotation annotation = (Annotation) metadata;
					if (key.equals(annotation.getTitle())) {
						annotationsToBeDeleted.add(annotation);
					}
				}
			}
			
			// Do the removals
			for (Annotation annotation : annotationsToBeDeleted) {
				EcoreUtil.delete(annotation);
			}
		}
	}
	
	private static void addPhysicalCheckAnnotation(ObeoDSMObject dsmObject, String value) {
		addAnnotation(dsmObject, PHYSICAL_CHECK_KEY, value);
	}
	
	public static void addAnnotation(ObeoDSMObject dsmObject, String key, String value) {
		MetaDataContainer metaDataContainer = getOrCreateMetaDataContainer(dsmObject);
		Annotation annotation = EnvironmentFactory.eINSTANCE.createAnnotation();
		metaDataContainer.getMetadatas().add(annotation);
		annotation.setTitle(key);
		annotation.setBody(value);
	}

	private static MetaDataContainer getOrCreateMetaDataContainer(ObeoDSMObject dsmObject) {
		MetaDataContainer metaDataContainer = dsmObject.getMetadatas();
		if (metaDataContainer == null) {
			metaDataContainer = EnvironmentFactory.eINSTANCE.createMetaDataContainer();
			dsmObject.setMetadatas(metaDataContainer);
		}
		return metaDataContainer;
	}
	
	public static String getPhysicalUnique(ObeoDSMObject dsmObject) {
		return getNonEmptyAnnotationBody(dsmObject, PHYSICAL_UNIQUE_KEY);
	}
	
	public static String getPhysicalName(ObeoDSMObject dsmObject) {
		return getNonEmptyAnnotationBody(dsmObject, PHYSICAL_NAME_KEY);
	}
	
	public static String getPhysicalDefault(ObeoDSMObject dsmObject) {
		return getNonEmptyAnnotationBody(dsmObject, PHYSICAL_DEFAULT_KEY);
	}
	
	public static String getPhysicalSize(ObeoDSMObject dsmObject) {
		return getNonEmptyAnnotationBody(dsmObject, PHYSICAL_SIZE_KEY);
	}
	
	public static Annotation getPhysicalNameAnnotation(ObeoDSMObject dsmObject) {
		return getAnnotation(dsmObject, PHYSICAL_NAME_KEY);
	}
	
	public static Annotation getPhysicalTarget(ObeoDSMObject dsmObject) {
		return getAnnotation(dsmObject, PHYSICAL_TARGET_KEY);
	}
	
	public static String getNonEmptyAnnotationBody(ObeoDSMObject dsmObject, String name) {
		String body = getAnnotationBody(dsmObject, name);
		if (body != null && body.trim().length() > 0) {
			return body.trim();
		}
		return null;
	}
	
	private static String getAnnotationBody(ObeoDSMObject dsmObject, String name) {
		Annotation annotation = getAnnotation(dsmObject, name);
		return annotation == null ? null : annotation.getBody();
	}
	
	public static Annotation getAnnotation(ObeoDSMObject dsmObject, String name) {
		MetaDataContainer metaDataContainer = dsmObject.getMetadatas();
		if (metaDataContainer != null) {
			for (MetaData metaData : metaDataContainer.getMetadatas()) {
				if (metaData instanceof Annotation) {
					Annotation annotation = (Annotation) metaData;
					if (name.equals(annotation.getTitle())) {
						return annotation;
					}
				}
			}
		}
		return null;
	}
	
	public static void setAllConstraints(ObeoDSMObject dsmObject, List<Constraint> constraints) {
		String constraintExpression = "";
		for (int i = 0; i < constraints.size(); i++) {
			if (i > 0) {
				constraintExpression += CONSTRAINT_DELIMITER;
			}
			constraintExpression += constraints.get(i).getExpression();			
		}
		if (constraintExpression.trim().length() > 0) {
			addPhysicalCheckAnnotation(dsmObject, constraintExpression);
		}
	}
	
	public static Collection<String> getAllConstraints(ObeoDSMObject dsmObject) {
		Collection<String> constraints = new ArrayList<String>();
		Collection<Annotation> constraintsAnnotations = getAllPhysicalCheckAnnotations(dsmObject);
		for (Annotation constraintAnnotation : constraintsAnnotations) {
			if (constraintAnnotation.getBody() != null && constraintAnnotation.getBody().trim().length() > 0) {
				// Use the separator to check if several constraints were defined in this annotation
				String[] definedConstraints = constraintAnnotation.getBody().split(CONSTRAINT_DELIMITER_REGEX);
				for (String definedConstraint : definedConstraints) {
					if (definedConstraint != null && definedConstraint.trim().length() > 0) {
						constraints.add(definedConstraint);
					}
				}
			}
		}
		return constraints;
	}
	
	private static Collection<Annotation> getAllPhysicalCheckAnnotations(ObeoDSMObject dsmObject) {
		return getAnnotations(dsmObject, PHYSICAL_CHECK_KEY);
	}
	
	public static Collection<Annotation> getAnnotations(ObeoDSMObject dsmObject, String name) {
		Collection<Annotation> annotations = new ArrayList<Annotation>();
		MetaDataContainer metaDataContainer = dsmObject.getMetadatas();
		if (metaDataContainer != null) {
			for (MetaData metaData : metaDataContainer.getMetadatas()) {
				if (metaData instanceof Annotation) {
					Annotation annotation = (Annotation) metaData;
					if (name.equals(annotation.getTitle())) {
						annotations.add(annotation);
					}
				}
			}
		}
		return annotations;
	}
}
