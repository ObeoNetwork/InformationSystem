package org.obeonetwork.dsl.soa.services;

import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.ConstrainableElement;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.Type;

public class ConstrainableElementService {

	public static Type getType(ConstrainableElement element) {
		if(element instanceof Attribute) {
			return ((Attribute) element).getType();
		}
		if(element instanceof Reference) {
			return ((Reference) element).getReferencedType();
		}
		return null;
	}
	
}
