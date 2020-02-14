package org.obeonetwork.dsl.soa.gen.swagger.utils;

import java.util.ArrayList;
import java.util.List;

import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.Operation;
import org.obeonetwork.dsl.soa.Parameter;
import org.obeonetwork.dsl.soa.Service;

public class OperationGenUtil {
	
	public static Service getService(Operation operation) {
		return (Service) operation.eContainer().eContainer();
	}

	public static Component getComponent(Operation operation) {
		return (Component) getService(operation).eContainer();
	}
	
	public static List<Parameter> getOwnedParameters(Operation operation) {
		List<Parameter> ownedParameters = new ArrayList<>();
		ownedParameters.addAll(operation.getInput());
		ownedParameters.addAll(operation.getOutput());
		ownedParameters.addAll(operation.getFault());
		return ownedParameters;
	}
}
