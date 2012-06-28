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



public class EnvironmentService {
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
		}else{
			return property.getMultiplicity();
		}
	}
	
	public String getAttrNameFromString(Attribute attribute, String inputString) {
		int delimiter = inputString.indexOf(":");
		if(delimiter != -1 && delimiter<inputString.length()){
			String token = inputString.substring(0,delimiter);
			return getPropNameFromString(attribute, token);
		}
		return getPropNameFromString(attribute, inputString);
	}
	
	public PrimitiveType getAttrTypeFromString(Attribute attribute, String inputString) {
		int delimiter = inputString.indexOf(":");
		if(delimiter != -1 && delimiter<inputString.length()){
			int startMulti = inputString.indexOf("[");
			String typeName;
			if(startMulti!=-1){
				typeName = inputString.substring(delimiter+1, startMulti);
			}else{
				typeName = inputString.substring(delimiter+1);
			}
			PrimitiveType primitiveType = getPrimType(attribute, typeName);
			if(primitiveType!=null){
				return primitiveType;
			}			
		}		
		return attribute.getType();
	}
	
	private PrimitiveType getPrimType(EObject context, String name){
		String searchedName = name.trim();
		EClass primitiveType = EnvironmentPackage.eINSTANCE.getPrimitiveType();
		Collection<Resource> semanticResources = EcoreService.getAllSemanticResourcesInSession(context);
		for (Resource semanticResource : semanticResources) {
			TreeIterator<?> iterator = semanticResource.getAllContents();
			while(iterator.hasNext()){
				Object o = iterator.next();			
				if (primitiveType.isInstance(o)){				
					PrimitiveType type = (PrimitiveType)o;
					if(searchedName.equalsIgnoreCase(type.getName())){
						return type;
					}
				}
			}
		}
		return null;
	}
}
