package org.obeonetwork.dsl.soa.gen.swagger.utils;

import org.obeonetwork.dsl.environment.ConstrainableElement;
import org.obeonetwork.dsl.environment.PrimitiveType;
import org.obeonetwork.dsl.environment.PrimitiveTypeKind;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.soa.services.ConstrainableElementService;

public class ConstrainableElementGenUtil {

	public static boolean isTextual(ConstrainableElement constrainableElement) {
		Type type = ConstrainableElementService.getType(constrainableElement);
		return type instanceof PrimitiveType && ((PrimitiveType) type).getKind() == PrimitiveTypeKind.TEXT;
	}
	
}
