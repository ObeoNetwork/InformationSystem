package org.obeonetwork.dsl.soa.gen.swagger.utils;

import static org.obeonetwork.dsl.soa.gen.swagger.utils.StringUtils.isNullOrWhite;

import org.obeonetwork.dsl.soa.System;

public class SystemGenUtil {

	public static String getName(System system) {
		return (isNullOrWhite(system.getName()))? "UnnamedSystem" : system.getName();
	}
	
}
