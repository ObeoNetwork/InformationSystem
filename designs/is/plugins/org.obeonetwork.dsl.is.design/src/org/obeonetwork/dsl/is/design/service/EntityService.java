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

import java.util.Collection;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.PrimitiveType;
import org.obeonetwork.dsl.environment.Property;
import org.obeonetwork.dsl.environment.Reference;

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
	
}
