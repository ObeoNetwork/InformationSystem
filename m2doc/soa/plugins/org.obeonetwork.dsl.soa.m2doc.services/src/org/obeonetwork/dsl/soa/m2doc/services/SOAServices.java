/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.m2doc.services;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.acceleo.annotations.api.documentation.Documentation;
import org.eclipse.acceleo.annotations.api.documentation.Example;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.m2doc.services.EnvironmentServices;
import org.obeonetwork.dsl.soa.Operation;
import org.obeonetwork.dsl.soa.Parameter;
import org.obeonetwork.dsl.soa.Service;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.dsl.soa.System;

/**
 * AQL Services for SOA's concepts.
 *
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 *
 */
public class SOAServices {

	private final EnvironmentServices es = new EnvironmentServices();

	// @formatter:off
	@Documentation(
			comment = "{m:mySystem.hasOwnedComponents()}",
		    value = "Returns if the given System direclty contains at least one Component.",
		    examples = {
		    		@Example(
		    				expression = "{m:mySystem.hasOwnedComponents()}", 
		    				result = "true or false.")
		    }
		)
	// @formatter:on	
	public boolean hasOwnedComponent(System system) {
		return !system.getOwnedComponents().isEmpty();
	}

	// @formatter:off
	@Documentation(
			comment = "{m:mySystem.hasOwnedWires()}",
		    value = "Returns if the given System direclty contains at least one Wire.",
		    examples = {
		    		@Example(
		    				expression = "{m:mySystem.hasOwnedWires()}", 
		    				result = "true or false.")
		    }
		)
	// @formatter:on	
	public boolean hasOwnedWire(System system) {
		return !system.getOwnedWires().isEmpty();
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myService.getOwnedOperations()}",
		    value = "Returns the list of Operation directly contained in the given Service.",
		    examples = {
		    		@Example(
		    				expression = "{m:myService.getOwnedOperations().name->sep(',')}", 
		    				result = "The list of Operation directly contained in the given Service names separated by coma.")
		    }
		)
	// @formatter:on	
	public List<Operation> getOwnedOperations(Service service) {
		final List<Operation> result = new ArrayList<Operation>();

		if (service.getOwnedInterface() != null) {
			result.addAll(service.getOwnedInterface().getOwnedOperations());
		}

		return result;
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myService.hasOwnedOperations()}",
		    value = "Returns if the given Service direclty contains at least one Operation.",
		    examples = {
		    		@Example(
		    				expression = "{m:myService.hasOwnedOperations()}", 
		    				result = "true or false.")
		    }
		)
	// @formatter:on	
	public boolean hasOwnedOperations(Service service) {
		return !getOwnedOperations(service).isEmpty();
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myOperation.getOwnedParameters()}",
		    value = "Returns the list of Parameter directly contained in the given Operation.",
		    examples = {
		    		@Example(
		    				expression = "{m:myOperation.getOwnedParameters().name->sep(',')}", 
		    				result = "The list of Parameter directly contained in the given Operation names separated by coma.")
		    }
		)
	// @formatter:on	
	public List<Parameter> getOwnedParameters(Operation operation) {
		final List<Parameter> result = new ArrayList<>();

		result.addAll(operation.getInput());
		result.addAll(operation.getOutput());
		result.addAll(operation.getFault());

		return result;
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myOperation.hasOwnedParameters()}",
		    value = "Returns if the given Operation direclty contains at least one Parameter.",
		    examples = {
		    		@Example(
		    				expression = "{m:myOperation.hasOwnedParameters()}", 
		    				result = "true or false.")
		    }
		)
	// @formatter:on	
	public boolean hasOwnedParameters(Operation operation) {
		return !getOwnedParameters(operation).isEmpty();
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myParameter.kind()}",
		    value = "Returns the kind of parameter: 'input' or 'output' or 'fault'.",
		    examples = {
		    		@Example(
		    				expression = "{m:myParameter.kind()}", 
		    				result = "'input' or 'output' or 'fault'.")
		    }
		)
	// @formatter:on	
	public String kind(Parameter parameter) {
		final String result;

		switch (parameter.eContainingFeature().getFeatureID()) {
		case SoaPackage.OPERATION__INPUT:
			result = "input";
			break;

		case SoaPackage.OPERATION__OUTPUT:
			result = "output";
			break;

		case SoaPackage.OPERATION__FAULT:
			result = "fault";
			break;

		default:
			result = "unknown";
			break;
		}

		return result;
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myParameter.unique()}",
		    value = "Returns true if the given parameter is unique, false otherwise.",
		    examples = {
		    		@Example(
		    				expression = "{m:myParameter.unique()}", 
		    				result = "true or false.")
		    }
		)
	// @formatter:on	
	public boolean unique(Parameter parameter) {
		return parameter.isIsUnique();
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myParameter.typeName()}",
		    value = "Returns the String representation of the type of the given Parameter.",
		    examples = {
		    		@Example(
		    				expression = "{m:myParameter.typeName()}", 
		    				result = "MyEntity[0..1]")
		    }
		)
	// @formatter:on	
	public String typeName(Parameter parameter) {
		return parameter.getType().getName() + "[" + parameter.getMultiplicity() + "]";
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myParameter.qualifiedTypeName()}",
		    value = "Returns the String representation of the type of the given Parameter.",
		    examples = {
		    		@Example(
		    				expression = "{m:myParameter.qualifiedTypeName()}", 
		    				result = "namespace1.namespace2.MyEntity[0..1]")
		    }
		)
	// @formatter:on	
	public String qualifiedTypeName(Parameter parameter) {
		final String result;

		if (parameter.getType() instanceof StructuredType) {
			result = es.qualifiedName((StructuredType) parameter.getType());
		} else {
			result = parameter.getType().getName();
		}

		return result + "[" + parameter.getMultiplicity() + "]";
	}

}
