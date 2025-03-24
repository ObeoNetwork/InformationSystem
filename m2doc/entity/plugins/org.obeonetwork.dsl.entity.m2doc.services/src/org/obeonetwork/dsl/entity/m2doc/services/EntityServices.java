/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.entity.m2doc.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.acceleo.annotations.api.documentation.Documentation;
import org.eclipse.acceleo.annotations.api.documentation.Example;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.Type;

/**
 * AQL Services for Entity's concepts.
 *
 * @author Obeo
 *
 */
public class EntityServices {

	// @formatter:off
	@Documentation(
			comment = "{m:myNamespace.getOwnedEntities()}",
		    value = "Returns the list of Entity directly contained in the given Namespace.",
		    examples = {
		    		@Example(
		    				expression = "{m:myNamespace.getOwnedEntities().name->sep(',')}", 
		    				result = "The list of Entity directly contained in the given Namespace names separated by coma.")
		    }
		)
	// @formatter:on	
	public List<Entity> getOwnedEntities(Namespace namespace) {
		final List<Entity> result = new ArrayList<>();

		for (Type type : namespace.getTypes()) {
			if (type instanceof Entity) {
				result.add((Entity) type);
			}
		}

		Collections.sort(result, new Comparator<Entity>() {

			@Override
			public int compare(Entity o1, Entity o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		return result;
	}

	// @formatter:off
	@Documentation(
			comment = "{m:myNamespace.hasOwnedEntities()}",
		    value = "Returns true if the given Namespace directly contains at least one Entity.",
		    examples = {
		    		@Example(
		    				expression = "{m:myNamespace.hasOwnedEntities()}", 
		    				result = "true or false.")
		    }
		)
	// @formatter:on	
	public boolean hasOwnedEntities(Namespace namespace) {
		return !getOwnedEntities(namespace).isEmpty();
	}

}
