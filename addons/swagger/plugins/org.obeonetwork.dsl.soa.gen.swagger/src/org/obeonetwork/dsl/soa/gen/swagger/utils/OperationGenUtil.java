/*******************************************************************************
 * Copyright (c) 2016-2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
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
