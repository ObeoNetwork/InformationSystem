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

import static org.obeonetwork.utils.common.StringUtils.isNullOrWhite;

import java.util.Objects;

import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.System;

public class SystemGenUtil {

	public static String getName(System system) {
		return (isNullOrWhite(system.getName()))? "UnnamedSystem" : system.getName();
	}

	public static Component getComponentByName(System system, String componentName) {
		return system.getOwnedComponents().stream()
				.filter(component -> Objects.equals(component.getName(), componentName))
				.findFirst().orElse(null);
	}
	
}
