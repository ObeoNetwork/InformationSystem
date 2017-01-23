package org.obeonetwork.dsl.graal.m2doc.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.graal.DomainClass;
import org.obeonetwork.graal.UseCase;

public class UseCaseServices {

	public List<DomainClass> allDomainClasses(UseCase uc){
		List<DomainClass> result = new ArrayList<DomainClass>();
		result.addAll(uc.getDomainClasses());
		for(Namespace ns : uc.getNamespaces()){
			collectClasses(ns,result);
		}
		Collections.sort(result, new Comparator<DomainClass>() {

			@Override
			public int compare(DomainClass arg0, DomainClass arg1) {
				return fullQualifiedName(arg0).compareTo(fullQualifiedName(arg1));
			}
		});
		return result;
	}

	/**
	 * Recursively collects the domain classes in the namespaces 
	 * @param ns the root namespace
	 * @param result the list of collected domain classes 
	 */
	private void collectClasses(Namespace ns,List<DomainClass> result){
		for(Type type : ns.getTypes()){
			if(type instanceof DomainClass){
				result.add((DomainClass)type);
			}
		}
		for(Namespace ons : ns.getOwnedNamespaces()){
			collectClasses(ons, result);
		}
	}
	
	public String fullQualifiedName(DomainClass dc){
		StringBuilder result = new StringBuilder();
		if(dc.eContainer() instanceof Namespace){
			fullQualifiedNamespace((Namespace) dc.eContainer(), result);
		}
		result.append('.').append(dc.getName());
		return result.toString();
	}
	private void fullQualifiedNamespace(Namespace ns,StringBuilder builder){
		if(ns.getOwner()!=null && ns.getOwner() instanceof Namespace){
			fullQualifiedNamespace((Namespace) ns.getOwner(),builder);
		}
		builder.append('.').append(ns.getName());
	}
}
