/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.design.services;

import java.util.Collection;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.DataType;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.Property;
import org.obeonetwork.dsl.environment.Reference;

public class PropertiesServices {

	public String getAttrNameFromString(Attribute attribute, String inputString) {
		int delimiter = inputString.indexOf(":");
		if(delimiter != -1 && delimiter<inputString.length()){
			String token = inputString.substring(0,delimiter);
			return getPropNameFromString(attribute, token);
		}
		return getPropNameFromString(attribute, inputString);
	}

	public static String getRefNameFromString(Reference ref, String inputString) {
		return getPropNameFromString(ref, inputString);
	}
	
	private static String getPropNameFromString(Property property, String inputString) {		
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
	
	public static MultiplicityKind getMultKindFromString(Property property, String inputString) {
		int start = inputString.indexOf("[");
		int end = inputString.indexOf("]");		
		if (end != -1 && start != -1 && start < end) {
			String multiplicity = inputString.substring(start + 1, end);			
			MultiplicityKind multiplicityKind = MultiplicityKind.get(multiplicity);
			//FIXME temporary hack
			property.setMultiplicity(multiplicityKind);
			return multiplicityKind;
		} else {
			return property.getMultiplicity();
		}
	}
	
	public DataType getAttrTypeFromString(Attribute attribute, String inputString) {
		int delimiter = inputString.indexOf(":");
		if(delimiter != -1 && delimiter<inputString.length()){
			int startMulti = inputString.indexOf("[");
			String typeName;
			if(startMulti!=-1){
				typeName = inputString.substring(delimiter+1, startMulti);
			}else{
				typeName = inputString.substring(delimiter+1);
			}
			DataType dataType = getDataType(attribute, typeName);
			if(dataType!=null){
				return dataType;
			}			
		}		
		return attribute.getType();
	}
	
	private DataType getDataType(EObject context, String name){
		String searchedName = name.trim();
		Collection<Resource> semanticResources = ModelServices.getAllResources(context);
		for (Resource semanticResource : semanticResources) {
			TreeIterator<?> iterator = semanticResource.getAllContents();
			while(iterator.hasNext()){
				Object o = iterator.next();	
				if (o instanceof DataType) {
					DataType type = (DataType)o;
					if (searchedName.equalsIgnoreCase(type.getName())) {
						return type;
					}
				}
			}
		}
		return null;
	}
}
