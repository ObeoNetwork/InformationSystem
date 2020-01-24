package org.obeonetwork.dsl.soa.gen.swagger.utils;

import org.obeonetwork.dsl.soa.System;

public class SystemGenUtil {

	public static String getName(System system) {
		return (system.getName() == null || system.getName().isEmpty())? "UnnamedSystem" : system.getName();
	}
	
}
