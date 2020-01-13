package org.obeonetwork.dsl.soa.gen.swagger.utils;

public class StringUtils {
	
	public static String upperFirst(String s) {
		if(s != null && s.length() > 0) {
			return s.substring(0, 1).toUpperCase() + s.substring(1);
		}
		return s;
	}

}
