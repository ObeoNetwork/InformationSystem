/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.gen.swagger.utils;

import static java.util.stream.Collectors.toList;

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
		ownedParameters.addAll(getInput(operation));
		ownedParameters.addAll(getOutput(operation));
		ownedParameters.addAll(getFault(operation));
		
		return ownedParameters;
	}
	
	public static List<Parameter> getInput(Operation operation) {
		return operation.getInput().stream().filter(p -> p.getRestData() != null).collect(toList());
	}
	
	public static List<Parameter> getOutput(Operation operation) {
		return operation.getOutput();
	}
	
	public static List<Parameter> getFault(Operation operation) {
		return operation.getFault();
	}
	
}
