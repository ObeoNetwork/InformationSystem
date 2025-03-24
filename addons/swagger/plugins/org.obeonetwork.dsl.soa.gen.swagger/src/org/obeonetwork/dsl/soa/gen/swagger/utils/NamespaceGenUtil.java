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
package org.obeonetwork.dsl.soa.gen.swagger.utils;

import java.util.Objects;

import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.Type;

public class NamespaceGenUtil {
	
	public static Namespace getNamespaceByName(Namespace namespace, String name) {
		return namespace.getOwnedNamespaces().stream()
				.filter(ns -> Objects.equals(name, ns.getName()))
				.findFirst().orElse(null);
	}

	public static Type getTypeByName(Namespace namespace, String typeName) {
		return namespace.getTypes().stream()
				.filter(type -> Objects.equals(typeName, type.getName()))
				.findFirst().orElse(null);
	}

}
