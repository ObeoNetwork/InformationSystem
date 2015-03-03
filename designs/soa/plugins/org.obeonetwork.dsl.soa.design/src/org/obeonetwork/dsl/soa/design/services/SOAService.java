package org.obeonetwork.dsl.soa.design.services;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.soa.InterfaceKind;


public class SOAService {
	
	public InterfaceKind getProvidedLiteral(EObject object){
		return InterfaceKind.PROVIDED_LITERAL;
	}
	
	public InterfaceKind getRequiredLiteral(EObject object){
		return InterfaceKind.REQUIRED_LITERAL;
	}
}
