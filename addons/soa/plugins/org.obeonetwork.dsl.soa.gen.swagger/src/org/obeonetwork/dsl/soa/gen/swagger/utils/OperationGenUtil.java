package org.obeonetwork.dsl.soa.gen.swagger.utils;

import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.Operation;
import org.obeonetwork.dsl.soa.Service;

public class OperationGenUtil {
	
	public static Service getService(Operation operation) {
		return (Service) operation.eContainer().eContainer();
	}

	public static Component getComponent(Operation operation) {
		return (Component) getService(operation).eContainer();
	}
	
}
