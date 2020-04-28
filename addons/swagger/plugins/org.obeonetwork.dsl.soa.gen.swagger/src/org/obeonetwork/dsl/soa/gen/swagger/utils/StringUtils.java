package org.obeonetwork.dsl.soa.gen.swagger.utils;

public class StringUtils {
	
	public static String upperFirst(String s) {
		if(s != null && s.length() > 0) {
			return s.substring(0, 1).toUpperCase() + s.substring(1);
		}
		return s;
	}

	public static String emptyIfNull(String s) {
		return (s == null)? "" : s;
	}
	
	public static boolean isNullOrWhite(String s) {
		return s == null || s.trim().isEmpty();
	}

}
