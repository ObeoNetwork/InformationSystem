package org.obeonetwork.dsl.soa.gen.swagger.utils;

import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.soa.Operation;
import org.obeonetwork.dsl.soa.Parameter;
import org.obeonetwork.dsl.soa.SoaPackage;

public class ParameterGenUtil {

	public static boolean isRequired(Parameter parameter) {
		return parameter.getMultiplicity() == MultiplicityKind.ONE_LITERAL || parameter.getMultiplicity() == MultiplicityKind.ONE_STAR_LITERAL;
	}

	public static boolean isMany(Parameter parameter) {
		return parameter.getMultiplicity() == MultiplicityKind.ONE_STAR_LITERAL || parameter.getMultiplicity() == MultiplicityKind.ZERO_STAR_LITERAL;
	}

	public static Integer getLowerBound(Parameter parameter) {
		if(parameter.getMultiplicity() == MultiplicityKind.ONE_LITERAL || parameter.getMultiplicity() == MultiplicityKind.ONE_STAR_LITERAL) {
			return 1;
		}
		return 0;
	}

	public static Operation getOperation(Parameter parameter) {
		return (Operation) parameter.eContainer();
	}

	public static boolean isOutput(Parameter soaParameter) {
		return soaParameter.eContainingFeature() == SoaPackage.eINSTANCE.getOperation_Output();
	}

	public static boolean isFault(Parameter soaParameter) {
		return soaParameter.eContainingFeature() == SoaPackage.eINSTANCE.getOperation_Fault();
	}

	
}
