package org.obeonetwork.dsl.soa.gen.swagger.utils;

import static org.obeonetwork.dsl.soa.gen.swagger.utils.StringUtils.isNullOrWhite;

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
