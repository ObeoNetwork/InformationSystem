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

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.environment.DTO;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.soa.Category;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.InterfaceKind;
import org.obeonetwork.dsl.soa.Service;
import org.obeonetwork.dsl.soa.ServiceDTO;
import org.obeonetwork.dsl.soa.Wire;

import org.eclipse.sirius.diagram.AbstractDNode;
import org.eclipse.sirius.diagram.DNodeContainer;
import org.eclipse.sirius.diagram.DSemanticDiagram;

public class SOAService {
	
	public List<Component> allNonReferencedExternalComponents (org.obeonetwork.dsl.soa.System context) {
		List<Component> allNonReferencedExternalComponents = allExternalComponents(context);
		// Remove all referenced external components
		allNonReferencedExternalComponents
				.removeAll(allReferencedExternalComponents(context));
		return allNonReferencedExternalComponents;

	}

	public List<Component> allExternalComponents(org.obeonetwork.dsl.soa.System context) {
		List<Component> allExternalComponents = allComponents(context);
		// Remove The component contained in the System.
		allExternalComponents.removeAll(context.getOwnedComponents());
		return allExternalComponents;
	}

	public List<Component> allReferencedExternalComponents(org.obeonetwork.dsl.soa.System context) {
		List<Component> allReferencedExternelComponents = allReferencedComponents(context);
		// Remove The component contained in the System.
		allReferencedExternelComponents.removeAll(context.getOwnedComponents());
		return allReferencedExternelComponents;
	}

	public List<Component> allReferencedComponents(org.obeonetwork.dsl.soa.System  context) {
		List<Component> allReferencedComponents = new ArrayList<Component>();
		List<Wire> ownedWires = context.getOwnedWires();
		// Add Components parent of source and dest of westWire
		for (Wire wire : ownedWires) {
			Component componentSource = (Component) wire.getSource()
					.eContainer();
			allReferencedComponents.add(componentSource);
			Component componentDest = (Component) wire.getDest().eContainer();
			allReferencedComponents.add(componentDest);
		}
		Set<Component> componentsSet = new HashSet<Component>();
		// Remove duplicates
		componentsSet.addAll(allReferencedComponents);
		return new ArrayList<Component>(componentsSet);
	}

	public List<Component> allComponents(org.obeonetwork.dsl.soa.System context) {
		EcoreService ecoreService = new EcoreService();
		// Retrieve allRoots
		Collection<EObject> allRoots = ecoreService.allRoots(context);
		List<Component> components = new ArrayList<Component>();
		// For all roots retrieve all elements of type Component
		for (EObject object : allRoots) {
			List<Component> allContainedEntities = new ArrayList<Component>();
			for (EObject obj : EcoreService.eAllContents(object,
					Component.class)) {
				allContainedEntities.add((Component) obj);
			}
			components.addAll(allContainedEntities);
		}
		return components;
	}

	public List<Component> allSelectableExternalComponents(org.obeonetwork.dsl.soa.System context,
			DSemanticDiagram semanticDiagram) {
		List<Component> allNonReferencedExternalComponents = allNonReferencedExternalComponents(context);
		List<Component> allComponentToRemove = new ArrayList<Component>();
		// For all semanticDiagram retrieve all contents elements of type
		// "DNodeContainer"
		for (EObject obj : EcoreService.eContents(semanticDiagram,
				DNodeContainer.class)) {
			// Retrieve and add the target of DNodeContainer type of Component
			if (((DNodeContainer) obj).getTarget() instanceof Component) {
				allComponentToRemove.add((Component) ((DNodeContainer) obj)
						.getTarget());
			}
		}
		allNonReferencedExternalComponents.removeAll(allComponentToRemove);
		return allNonReferencedExternalComponents;
	}
	
	public List<Type> allSelectableExternalDTOs (Category context, DSemanticDiagram semanticDiagram){		
		List<Type> allNonReferencedExternalDTOs = allNonReferencedExternalDTOs(context);
		List<Type> allTypesToRemove = new ArrayList<Type>();
		// For all semanticDiagram retrieve all contents elements of type
		// "DNodeContainer"
		for (EObject obj : EcoreService.eContents(semanticDiagram,
				AbstractDNode.class)) {
			// Retrieve and add the target of DNodeContainer type of Component
			if (((AbstractDNode) obj).getTarget() instanceof ServiceDTO) {
				allTypesToRemove.add((ServiceDTO) ((AbstractDNode) obj)
						.getTarget());
			}
		}
		allNonReferencedExternalDTOs.removeAll(allTypesToRemove);
		return allNonReferencedExternalDTOs;
	}
	
	public List<Type> allReferencedExternalDTOs (Category context){
		List<Type> allReferencedExternalDTOs = allReferencedDTOs(context);
		// Remove the DTO contained in the context
		allReferencedExternalDTOs.removeAll(allContainedDTOs(context));
		return allReferencedExternalDTOs;
	}
	
	public List<Type> allReferencedDTOs (Category context){
		//<%(allContainedDTOs.referencedDTOs).nMinimize()%>
		List<Type> allContainedDTOs = allContainedDTOs(context);
		List<Type> referencedDTOs = new ArrayList<Type>();
		for (Type type : allContainedDTOs){
			if (type instanceof ServiceDTO){
				referencedDTOs.addAll(referencedDTOs((ServiceDTO)type));
			}
		}
		Set<Type> allReferencedDTOs = new HashSet<Type>();
		// Remove duplicates
		allReferencedDTOs.addAll(referencedDTOs);
		return new ArrayList<Type>(allReferencedDTOs);
	}	
	
	public List<Type> referencedDTOs (ServiceDTO context){ 
		List<Type> types = new ArrayList<Type>();
		List<Reference> references = context.getOwnedReferences();
		for (Reference ref : references){
			// Add the type of Owned references
			types.add(ref.getType());
			for (EObject obj : ref.getType().eCrossReferences()){
				if (obj instanceof Reference){
					// add the EInverse of type.dto
					types.add(((Reference)obj).getDto());
				}
			}
		}
		// Add the supertype
		if (context.getSupertype() != null){
	    types.add(context.getSupertype());
	    for (EObject obj : context.getSupertype().eCrossReferences()){
	    	if (obj instanceof DTO){
	    		// Add the eInverse of supertype
	    		types.add((DTO)obj);
	    	}
	    }
		}
	    Set<Type>referencedDTOs = new HashSet<Type>();
	    // Remove duplicates
	    referencedDTOs.addAll(types);
	    return new ArrayList<Type>(referencedDTOs);
		
		
	}
	
	public List<Type> allContainedDTOs (Category context){
		List<Type> types = context.getTypes();
		for (Category category : context.getOwnedCategories()){
			types.addAll(category.getTypes());
		}
		Set<Type> containedDTOs = new HashSet<Type>();
		// Remove duplicates
		containedDTOs.addAll(types);
		return new ArrayList<Type>(containedDTOs);
	}
	
	public List<Type> allNonReferencedExternalDTOs (Category context){
		List<Type> allExternalDTOs = allExternalDTOs(context);
		allExternalDTOs.removeAll(allReferencedDTOs(context));
		return allExternalDTOs;
	}
	
	public List<Type> allExternalDTOs (Category context){
		List<Type> allDTOs = allDTOs(context);
		allDTOs.removeAll(allContainedDTOs(context));
		return allDTOs;
	}
	
	public List<Type> allDTOs (Category context){
		//<%allRoots.eAllContents().filter("soa.ServiceDTO")%>
		EcoreService ecoreService = new EcoreService();
		// Retrieve allRoots
		Collection<EObject> allRoots = ecoreService.allRoots(context);
		List<Type> types = new ArrayList<Type>();
		// For all roots retrieve all elements of type ServiceDTO
		for (EObject object : allRoots) {
			List<Type> allContainedServiceDTO = new ArrayList<Type>();
			for (EObject obj : EcoreService.eAllContents(object,
					ServiceDTO.class)) {
				allContainedServiceDTO.add((Type) obj);
			}
			types.addAll(allContainedServiceDTO);
		}
		return types;
	}
	
	public boolean isRequiredService (Service context){
		return context.getKind().equals (getRequiredLiteral(context));
	}
	
	public InterfaceKind getProvidedLiteral(EObject object){
		return InterfaceKind.PROVIDED_LITERAL;
	}
	
	public InterfaceKind getRequiredLiteral(EObject object){
		return InterfaceKind.REQUIRED_LITERAL;
	}
}
