/*******************************************************************************
 * Copyright (c) 2009-2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.is.design.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.obeonetwork.dsl.entity.Attribute;
import org.obeonetwork.dsl.entity.Block;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.entity.Property;
import org.obeonetwork.dsl.entity.Reference;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.PrimitiveType;

import fr.obeo.dsl.viewpoint.AbstractDNode;
import fr.obeo.dsl.viewpoint.DDiagram;

public class EntityService {
	
	public static String getReferenceNameFromString(Reference ref, String inputString) {
		return getPropertyNameFromString(ref, inputString);
	}
	
	public String getAttributeNameFromString(Attribute attribute, String inputString) {
		int delimiter = inputString.indexOf(":");
		if(delimiter != -1 && delimiter<inputString.length()){
			String token = inputString.substring(0,delimiter);
			return getPropertyNameFromString(attribute, token);
		}
		return getPropertyNameFromString(attribute, inputString);
	}
	
	public PrimitiveType getAttributeTypeFromString(Attribute attribute, String inputString) {
		int delimiter = inputString.indexOf(":");
		if(delimiter != -1 && delimiter<inputString.length()){
			int startMulti = inputString.indexOf("[");
			String typeName;
			if(startMulti!=-1){
				typeName = inputString.substring(delimiter+1, startMulti);
			}else{
				typeName = inputString.substring(delimiter+1);
			}
			typeName = typeName.trim();
			PrimitiveType primitiveType = getPrimitiveType(attribute, typeName);
			if(primitiveType!=null){
				return primitiveType;
			}			
		}		
		return attribute.getType();
	}
	
	public PrimitiveType getStringPrimitiveType(EObject object){
		return getPrimitiveType(object, "String");
	}
	
	private PrimitiveType getPrimitiveType(EObject context, String name){		
		EClass primitiveType = EnvironmentPackage.eINSTANCE.getPrimitiveType();
		Collection<Resource> semanticResources = EcoreService.getAllSemanticResourcesInSession(context);
		for (Resource semanticResource : semanticResources) {
			TreeIterator<?> iterator = semanticResource.getAllContents();
			while(iterator.hasNext()){
				Object o = iterator.next();			
				if (primitiveType.isInstance(o)){				
					PrimitiveType type = (PrimitiveType)o;
					if(name.equalsIgnoreCase(type.getName())){
						return type;
					}
				}
			}
		}
		return null;
	}
	
	private static String getPropertyNameFromString(Property property, String inputString) {		
		int start = inputString.indexOf("[");
		int end = inputString.indexOf("]");
		String name="";
		if (end != -1 && start != -1 && start < end) {			
			name = inputString.substring(0, start).trim()+inputString.substring(end+1,inputString.length()).trim();
		}else{
			name=inputString.trim();
		}
		if(name.length()>0){
			return name;		
		}else{
			return property.getName();
		}		
	}
	
	public static MultiplicityKind getMultiplicityKindFromString(Property property, String inputString) {
		int start = inputString.indexOf("[");
		int end = inputString.indexOf("]");		
		if (end != -1 && start != -1 && start < end) {
			String multiplicity = inputString.substring(start + 1, end);			
			MultiplicityKind multiplicityKind = MultiplicityKind.get(multiplicity);
			//FIXME temporary hack
			property.setMultiplicity(multiplicityKind);
			return multiplicityKind;
		}else{
			return property.getMultiplicity();
		}
	}
	
	public List<Entity> allReferencedExternalEntities(Block context){
		List<Entity> allReferencedEntities = allReferencedEntities(context);
		// Remove contained Entities
		allReferencedEntities.removeAll(allContainedEntities(context));
		Set<Entity> allReferencedExternalEntites = new HashSet<Entity>();
		// Remove duplicates
		allReferencedExternalEntites.addAll(allReferencedEntities);
		return new ArrayList<Entity>(allReferencedExternalEntites);
	}	
	
	public List<Entity> allReferencedEntities(Block context){
		List<Entity> allReferencedEntities = new ArrayList<Entity>();
		for (Entity entity : allContainedEntities(context)){
			allReferencedEntities.addAll(referencedEntities(entity));
		}
		Set<Entity>allReferencedEntitiesOrdered = new HashSet<Entity>();
		// Remove duplicates
		allReferencedEntitiesOrdered.addAll(allReferencedEntities);
		return new ArrayList<Entity>(allReferencedEntitiesOrdered);
	}
	
	public List<Entity> referencedEntities(Entity context){		
		List <Reference> references = context.getOwnedReferences();
		List <Entity> types = new ArrayList<Entity>();
		for (Reference reference : references){		
			// Add reference's type
			types.add(reference.getType());			
			if (!types.contains(reference.getEntity())){
				// Add reference's entity
				types.add(reference.getEntity());
			}
			if (reference.getType().getSupertype() != null && !types.contains(reference.getType().getSupertype())){
				// Add reference's supertype's type
				types.add(reference.getType().getSupertype());
			}
			if (reference.getEntity().getSupertype() != null && !types.contains(reference.getEntity().getSupertype())){
				// Add reference's supertype's entity
				types.add(reference.getEntity().getSupertype());
			}
		}
		Set<Entity> referencedEntities = new HashSet<Entity>();
		// Remove duplicates 
		referencedEntities.addAll(types);
		return new ArrayList<Entity>(referencedEntities);
	}
	
	public List<Entity> allContainedEntities(Block context){
		List<Entity> allContainedEntities = new ArrayList<Entity>();
		for (EObject obj : EcoreService.eAllContents(context, Entity.class)){
			allContainedEntities.add((Entity)obj);
		}		
		return allContainedEntities;
	}
	
	public List<Entity> allNonReferencedExternalEntities(Block context){		
		List<Entity> allExternalEntities = allExternalEntities(context);
		allExternalEntities.removeAll(allReferencedEntities(context));
		return allExternalEntities;
	}
	
	public List<Entity> allExternalEntities(Block context){
		List<Entity> allEntities = allEntities(context);
		allEntities.removeAll(allContainedEntities(context));
		return allEntities;
	}
	
	public List<Entity> allEntities(Block context){
		EcoreService ecoreService = new EcoreService();
		// Retrieve allRoots
		Collection <EObject> allRoots = ecoreService.allRoots(context);
		List<Entity> entities = new ArrayList<Entity>();
		// For all roots retrieve all elements of type Entity
		for (EObject object : allRoots){
			List<Entity> allContainedEntities = new ArrayList<Entity>();
			for (EObject obj : EcoreService.eAllContents(object, Entity.class)){
				allContainedEntities.add((Entity)obj);
			}		
			entities.addAll(allContainedEntities);
		}
		return entities;
	}
	
	public List<Entity> allSelectableExternalEntities(EObject context, DDiagram dDiagram){		
		List<Entity> allNonReferencedExternalEntities = new ArrayList<Entity>();
		List<Entity> targetEntities = new ArrayList<Entity>();
		if (context instanceof Block){
			allNonReferencedExternalEntities = allNonReferencedExternalEntities((Block)context);
			List<AbstractDNode> allContainedNodes = new ArrayList<AbstractDNode>();
			// Retrieve all Elements of type AbstractDNode
			for (EObject obj : EcoreService.eAllContents(dDiagram, AbstractDNode.class)){
				allContainedNodes.add((AbstractDNode)obj);
			}					
			// For all nodes, check if node.target is instanceof Entity
			for (AbstractDNode node : allContainedNodes){
				if (node.getTarget() instanceof Entity){
					targetEntities.add((Entity)node.getTarget());
				}
			}
			allNonReferencedExternalEntities.remove(targetEntities);
						
		}
		return allNonReferencedExternalEntities;
	}	
	
}
