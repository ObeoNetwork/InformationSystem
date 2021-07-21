/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.design.ui;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * Static cache of the standard SWT colors as RGB instances. <br>
 * This is a workaround for using system colors with computed colors in Sirius.
 * Calling {@link #org.eclipse.swt.widgets.Display.getSystemColor()} from Sirius
 * services causes concurrent access problems.<br>
 * Drawback : the cache is not updated when the preferences changes.
 *
 */
public class RGBSystemColorUtil {

	private static String SWT_COLOR_FIELD_PREFIX = "COLOR_";
	private static Map<String, RGB> systemRGBColors;
	static {
		systemRGBColors = new HashMap<String, RGB>();
		for(Field swtColorField : getSWTColorFields()) {
			RGB rgb = Display.getCurrent().getSystemColor(getValue(swtColorField)).getRGB();
			String name = swtColorField.getName().substring(SWT_COLOR_FIELD_PREFIX.length());
			systemRGBColors.put(name, rgb);
		}
		
	}
	
	private static int getValue(Field field) {
		int value = 0;
		try {
			value = field.getInt(null);
		} catch (IllegalArgumentException e) {
			// Shouldn't happen
		} catch (IllegalAccessException e) {
			// Shouldn't happen
		}
		return value;
	}

	private static List<Field> getSWTColorFields() { 
		Field[] allFields = SWT.class.getDeclaredFields();
		ArrayList<Field> swtColorFields = new ArrayList<Field>(allFields.length);

		for (Field field : allFields) {
			if (field.getType() == Integer.TYPE && Modifier.isStatic(field.getModifiers())
					&& Modifier.isPublic(field.getModifiers()) && Modifier.isFinal(field.getModifiers())
					&& field.getName().startsWith(SWT_COLOR_FIELD_PREFIX)) { //$NON-NLS-1$

				swtColorFields.add(field);
			}
		}
		return swtColorFields;
	}

	public static RGB getRGBByName(String colorName) {
		RGB rgb = systemRGBColors.get(colorName);
		if(rgb == null) {
			rgb = systemRGBColors.get("BLACK");
		}
		return rgb;
	}
	
	public static Set<String> getAvailableColorNames() {
		return systemRGBColors.keySet();
	}
	
}
