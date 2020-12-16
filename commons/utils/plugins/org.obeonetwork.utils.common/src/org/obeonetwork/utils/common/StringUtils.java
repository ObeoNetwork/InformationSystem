/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.utils.common;

public class StringUtils {
	
	public static final String EMPTY_STRING = "";
	
	public static String upperFirst(String s) {
		if(s != null && s.length() > 0) {
			return s.substring(0, 1).toUpperCase() + s.substring(1);
		}
		return s;
	}

	public static String emptyIfNull(String s) {
		return (s == null)? EMPTY_STRING : s;
	}
	
	public static boolean isNullOrWhite(String s) {
		return s == null || s.trim().isEmpty();
	}

}
