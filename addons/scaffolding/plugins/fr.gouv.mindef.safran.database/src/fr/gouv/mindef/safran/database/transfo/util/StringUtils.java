/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.database.transfo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	public static String toSqlNotation(String s) {
		if (s == null) {
			return null;
		}
		String sqlName = s.replaceAll("\\p{Punct}^_", "");// Punctuation: One of
															// !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~
															// Except '_'
		sqlName = sqlName.replaceAll("\\.", "");
		Pattern p = Pattern.compile("(\\p{Lower})(\\p{Upper})");
		Matcher m = p.matcher(sqlName);
		sqlName = m.replaceAll("$1_$2");
		sqlName = sqlName.replaceAll(" ", "");
		StringBuffer dest = new StringBuffer(sqlName.length());
	
		for (int i = 0; i < sqlName.length(); i++) {
			char c = sqlName.charAt(i);
			switch (c) {
			case '\u00e0':
	        case '\u00e2':
	        case '\u00e4':
	        	dest.append('a');
	            break;
	        case '\u00e7':
	        	dest.append('c');
	            break;
	        case '\u00e8':
	        case '\u00e9':
	        case '\u00ea':
	        case '\u00eb':
	        	dest.append('e');
	            break;
	        case '\u00ee':
	        case '\u00ef':
	        	dest.append('i');
	            break;
	        case '\u00f4':
	        case '\u00f6':
	        	dest.append('o');
	            break;
	        case '\u00f9':
	        case '\u00fb':
	        case '\u00fc':
	        	dest.append('u');
	            break;
			default:
				dest.append(c);
				break;
			}
		}
		sqlName = dest.toString();
		sqlName = sqlName.toUpperCase();
		return sqlName;
	}

	public static String toCamelCase(String s) {
		String[] parts = s.split("_");
		String camelCaseString = "";
		for (String part : parts) {
			camelCaseString = camelCaseString + toProperCase(part);
		}
		return camelCaseString;
	}

	public static String toProperCase(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}

	public static String toU1Lower(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		return s.substring(0, 1).toLowerCase() + s.substring(1);
	}
	
}
