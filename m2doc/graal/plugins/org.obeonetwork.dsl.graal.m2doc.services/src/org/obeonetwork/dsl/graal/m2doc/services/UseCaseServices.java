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

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.acceleo.annotations.api.documentation.Documentation;
import org.eclipse.acceleo.annotations.api.documentation.Example;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.graal.DomainClass;
import org.obeonetwork.graal.UseCase;

public class UseCaseServices {

	// @formatter:off
	@Documentation(
			comment = "{m:myUseCase.allDomainClasses()}",
		    value = "Return a list containing all domain classes referenced by a use case.",
		    examples = {
		    		@Example(
		    				expression = "{m:myUseCase.allDomainClasses()}", 
		    				result = "a list containing all domain classes referenced by a use case.")
		    }
		)
	// @formatter:on	
	public List<DomainClass> allDomainClasses(UseCase uc){
		Set<DomainClass> classes = new HashSet<DomainClass>();
		
		// Add domain classes directly references
		classes.addAll(uc.getDomainClasses());
		
		// Search for domain classes in referenced namespaces
		for (Namespace ns : uc.getNamespaces()) {
			collectClasses(ns,classes);
		}
		// This reference exists for compatibility with old metamodel version (before DomainClass)
		for (StructuredType type : uc.getTypes()) {
			if (type instanceof DomainClass) {
				classes.add((DomainClass)type);
			}
		}
		
		// Convert set to list
		List<DomainClass> result = new ArrayList<>(classes);
		// and sort by fully qualified names
		Collections.sort(result, new Comparator<DomainClass>() {

			@Override
			public int compare(DomainClass arg0, DomainClass arg1) {
				// Use a primary collator to ignore accents and case
				Collator collator = Collator.getInstance();
				collator.setStrength(Collator.PRIMARY);
				return collator.compare(fullQualifiedName(arg0), fullQualifiedName(arg1));
			}
		});
		return result;
	}

	/**
	 * Recursively collects the domain classes in the namespaces 
	 * @param ns the root namespace
	 * @param result the set of collected domain classes 
	 */
	private void collectClasses(Namespace ns,Set<DomainClass> result){
		for(Type type : ns.getTypes()){
			if(type instanceof DomainClass){
				result.add((DomainClass)type);
			}
		}
		for(Namespace ons : ns.getOwnedNamespaces()){
			collectClasses(ons, result);
		}
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:myDomainClass.fullQualifiedName()}",
		    value = "Return the full qualified name of the domain class.",
		    examples = {
		    		@Example(
		    				expression = "{m:myDomainClass.fullQualifiedName()}", 
		    				result = "the full qualified name of the domain class.")
		    }
		)
	// @formatter:on	
	public String fullQualifiedName(DomainClass dc){
		StringBuilder result = new StringBuilder();
		if(dc.eContainer() instanceof Namespace){
			fullQualifiedNamespace((Namespace) dc.eContainer(), result);
			result.append('.');
		}
		result.append(dc.getName());
		return result.toString();
	}

	private void fullQualifiedNamespace(Namespace ns,StringBuilder builder){
		if(ns.getOwner() instanceof Namespace){
			fullQualifiedNamespace((Namespace) ns.getOwner(),builder);
			builder.append('.');
		}
		builder.append(ns.getName());
	}
}
