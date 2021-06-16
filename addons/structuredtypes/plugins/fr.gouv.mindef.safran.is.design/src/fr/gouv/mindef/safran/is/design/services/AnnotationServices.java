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
package fr.gouv.mindef.safran.is.design.services;

import java.util.Arrays;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.net4j.util.StringUtil;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListDialog;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.MetaData;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.Reference;

/**
 * Utilities services concerning Annotations
 * @author Stephane Thibaudeau <a href="mailto:stephane.thibaudeau@obeo.fr">stephane.thibaudeau@obeo.fr</a>
 *
 */
public class AnnotationServices {
	
	private static final String PHYSICAL_NAME = "PHYSICAL_NAME";
	private static final String PHYSICAL_SIZE = "PHYSICAL_SIZE";
	private static final String PHYSICAL_CHECK = "PHYSICAL_CHECK";
	private static final String PHYSICAL_UNIQUE = "PHYSICAL_UNIQUE";
	private static final String PHYSICAL_DEFAULT = "PHYSICAL_DEFAULT";
	private static final String PHYSICAL_TARGET = "PHYSICAL_TARGET";

	/**
	 * Returns true if an attribute is in a context allowing the user to edit label
	 */
	public boolean canEditObject(Object attribute, String requiredEClass) {
		if (attribute instanceof Attribute) {
			EObject eContainer = ((Attribute)attribute).eContainer();
			if (eContainer != null) {
				return requiredEClass.equals(eContainer.eClass().getName());
			}
		}
		return true;
	}
	
	/**
	 * Returns the physical name of an object
	 * This physical name is persisted as an annotation
	 * @param context Object for which we look for the physical name
	 * @return the physical name or null if there is none specified for the context object
	 */
	public String getPhysicalName(ObeoDSMObject context) {
		return getAnnotation(context, PHYSICAL_NAME);
	}
	
	/**
	 * Returns the physical size of an object
	 * This physical size is persisted as an annotation
	 * @param context Object for which we look for the physical size
	 * @return the physical size or null if there is none specified for the context object
	 */
	public String getPhysicalSize(ObeoDSMObject context) {
		return getAnnotation(context, PHYSICAL_SIZE);
	}
	
	/**
	 * Returns the physical check (domain of values) of an object
	 * This physical check is persisted as an annotation
	 * @param context Object for which we look for the physical check
	 * @return the physical check or null if there is none specified for the context object
	 */
	public String getPhysicalCheck(ObeoDSMObject context) {
		return getAnnotation(context, PHYSICAL_CHECK);
	}
	
	/**
	 * Returns the physical unique constraint of an object
	 * This physical unique constraint is persisted as an annotation
	 * @param context Object for which we look for the physical unique
	 * @return the physical unique or null if there is none specified for the context object
	 */
	public String getPhysicalUnique(ObeoDSMObject context) {
		return getAnnotation(context, PHYSICAL_UNIQUE);
	}
	
	/**
	 * Returns the physical default value of an object
	 * This physical default is persisted as an annotation
	 * @param context Object for which we look for the physical default value
	 * @return the physical default or null if there is none specified for the context object
	 */
	public String getPhysicalDefault(ObeoDSMObject context) {
		return getAnnotation(context, PHYSICAL_DEFAULT);
	}

	/**
	 * Returns the physical target value of an object
	 * This physical target is persisted as an annotation
	 * @param context Object for which we look for the physical target value
	 * @return the physical target or null if there is none specified for the context object
	 */
	public String getPhysicalTarget(ObeoDSMObject context) {	
		return getAnnotation(context, PHYSICAL_TARGET);
	}
	
	/**
	 * Returns the annotation with the specified name on the context object 
	 * @param context Object for which we look for an annotation
	 * @param annotationName Name of the looked up annotation
	 * @return Body of the found annotation, null if there is no annotation with the specified name
	 */
	public String getAnnotation(ObeoDSMObject context, String annotationName) {
		// if no annotation name has been specified we can return at once
		if (annotationName != null) {
			// Get the metadata container
			MetaDataContainer metadataContainer = context.getMetadatas();
			if (metadataContainer != null) {
				// Look for an annotation with the right name amongst metadatas
				for (MetaData metadata : metadataContainer.getMetadatas()) {
					if (metadata instanceof Annotation) {
						Annotation annotation = (Annotation)metadata;
						if (annotationName.equals(annotation.getTitle())) {
							return annotation.getBody();
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Sets the physical name of an object as an annotation
	 * @param context Object for which we want to set the physical name
	 * @param physicalName New value for the physical name
	 */
	public void setPhysicalName(ObeoDSMObject context, String physicalName) {
		setAnnotation(context, PHYSICAL_NAME, physicalName);
	}
	
	/**
	 * Sets the physical size of an object as an annotation
	 * @param context Object for which we want to set the physical size
	 * @param physicalSize New value for the physical size
	 */
	public void setPhysicalSize(ObeoDSMObject context, String physicalSize) {
		setAnnotation(context, PHYSICAL_SIZE, physicalSize);
	}
	
	/**
	 * Sets the physical check (domain of values) of an object as an annotation
	 * @param context Object for which we want to set the physical check
	 * @param physicalCheck New value for the physical check
	 */
	public void setPhysicalCheck(ObeoDSMObject context, String physicalCheck) {
		setAnnotation(context, PHYSICAL_CHECK, physicalCheck);
	}
	
	/**
	 * Sets the physical unique constraint of an object as an annotation
	 * @param context Object for which we want to set the physical unique constraint
	 * @param physicalUnique New value for the physical unique constraint
	 */
	public void setPhysicalUnique(ObeoDSMObject context, String physicalUnique) {
		setAnnotation(context, PHYSICAL_UNIQUE, physicalUnique);
	}
	
	/**
	 * Sets the physical default value of an object as an annotation
	 * @param context Object for which we want to set the physical default
	 * @param physicalDefault New value for the physical default
	 */
	public void setPhysicalDefault(ObeoDSMObject context, String physicalDefault) {
		setAnnotation(context, PHYSICAL_DEFAULT, physicalDefault);
	}
	
	/**
	 * Sets the physical target of an object as an annotation
	 * @param context Object for which we want to set the physical target
	 * @param physicalTarget New value for the physical target
	 */
	public void setPhysicalTarget(ObeoDSMObject context, String physicalTarget) {
		
		if (context instanceof Reference) {
			
			// put a X in the cell
			if (physicalTarget != null && !physicalTarget.isEmpty()) {
				if (physicalTarget.toLowerCase().trim().contains("x")) {
					physicalTarget = "X";
					
					Reference reference = (Reference) context;
					
					MetaDataContainer oppositeMetaDataContainer = reference.getOppositeOf().getMetadatas();
					
					if (oppositeMetaDataContainer != null) {
						// Is the opposed reference defined as the physical target ? 
						Optional<Annotation> physicalTargetAnnotation = oppositeMetaDataContainer // metadatacontainer
							.getMetadatas() // list<metadata>
							.stream()
							.filter(Annotation.class::isInstance)
							.map(Annotation.class::cast)
							.filter(annotation -> PHYSICAL_TARGET.equals(annotation.getTitle()))
							.findAny();
						
						if (physicalTargetAnnotation.isPresent())
							physicalTargetAnnotation.get().setBody(null);
					}
					
				} else {
					physicalTarget = null;
					switchReferenceTarget((Reference) context);
				}							
			} else {
				// removed the cell's content: we check the opposite Reference instead				
				switchReferenceTarget((Reference) context);				
			}
		}		
		setAnnotation(context, PHYSICAL_TARGET, physicalTarget);
	}	
	
	private void switchReferenceTarget(Reference reference) {
		Optional<Annotation> physicalTargetAnnotation = reference.getOppositeOf()
			.getMetadatas() // metadatacontainer
			.getMetadatas() // list<metadata>
			.stream()
			.filter(Annotation.class::isInstance)
			.map(Annotation.class::cast)
			.filter(annotation -> PHYSICAL_TARGET.equals(annotation.getTitle()))
			.findAny();
		
		if (physicalTargetAnnotation.isPresent())
			physicalTargetAnnotation.get().setBody("X");
		else {
			Reference opposite = reference.getOppositeOf();
			Annotation annotation = EnvironmentFactory.eINSTANCE.createAnnotation();
			annotation.setTitle(PHYSICAL_TARGET);
			annotation.setBody("X");
			opposite.getMetadatas().getMetadatas().add(annotation);
		}					
	}
	
	public boolean isValidReference(Reference reference) {
		String physicalTarget = getPhysicalTarget(reference);
		String physicalTargetOpposite = getPhysicalTarget(reference.getOppositeOf());
		
		if (physicalTarget != null) {
			if (! physicalTarget.isEmpty()) {
				if (physicalTargetOpposite != null && ! physicalTargetOpposite.isEmpty()) {
					return false;
				}
				
				if (! "x".equalsIgnoreCase(physicalTarget)) {
					return false;
				}
			}
			
		}
		
		return true;
	}
	
	/**
	 * Creates or sets an annotation with the specified name and value
	 * @param context Object carrying the annotation
	 * @param annotationName Name of the annotation
	 * @param annotationValue Value of the annotation
	 */
	public void setAnnotation(ObeoDSMObject context, String annotationName, String annotationValue) {
		if (annotationName == null) {
			return;
		}
		Annotation annotation = null;
		// Get the existing MetaDataContainer or create a new one
		MetaDataContainer container = context.getMetadatas();
		if (container == null) {
			// Create a new container
			container = EnvironmentFactory.eINSTANCE.createMetaDataContainer();
			context.setMetadatas(container);
			
			// Create a new annotation
			annotation = EnvironmentFactory.eINSTANCE.createAnnotation();
			annotation.setTitle(annotationName);
			annotation.setBody(annotationValue);
			container.getMetadatas().add(annotation);
			return;
		}
		
		// Look for an existing annotation
		for (MetaData metadata : container.getMetadatas()) {
			if (metadata instanceof Annotation) {
				Annotation existingAnnotation = (Annotation)metadata;
				if (annotationName.equals(existingAnnotation.getTitle())) {
					existingAnnotation.setBody(annotationValue);
					return;
				}
			}
		}
		
		// If we get there it means there is no existing annotation with the specified name
		annotation = EnvironmentFactory.eINSTANCE.createAnnotation();
		annotation.setTitle(annotationName);
		annotation.setBody(annotationValue);
		container.getMetadatas().add(annotation);
	}
}
