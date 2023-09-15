package org.obeonetwork.dsl.soa.services;

import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.ConstrainableElement;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.soa.Parameter;

public class ConstrainableElementService {

	public static Type getType(ConstrainableElement element) {
		if(element instanceof Attribute) {
			return ((Attribute) element).getType();
		}
		if(element instanceof Reference) {
			return ((Reference) element).getReferencedType();
		}
		if(element instanceof Parameter) {
			return ((Parameter) element).getType();
		}
		return null;
	}
	
}
