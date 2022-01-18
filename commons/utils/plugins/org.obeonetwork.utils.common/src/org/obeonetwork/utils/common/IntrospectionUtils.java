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
package org.obeonetwork.utils.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class IntrospectionUtils {
	
	public static <T> T getFieldValue(Object object, String fieldName, Class<T> clazz) {
		T fieldValue = null;
		Field field = getField(object.getClass(), fieldName);
		field.setAccessible(true);
		try {
			Object value = field.get(object);
			if (clazz.isAssignableFrom(value.getClass())) {
				fieldValue = clazz.cast(value);
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// Silent catch
		} finally {
			field.setAccessible(false);
		}
		return fieldValue;
	}

	private static Field getField(Class<? extends Object> clazz, String fieldName) {
		Field field = getDeclaredFieldSafe(clazz,fieldName);
		while(field == null && clazz != null) {
			clazz = clazz.getSuperclass();
			field = getDeclaredFieldSafe(clazz, fieldName);
		}
		return field;
	}

	private static Field getDeclaredFieldSafe(Class<? extends Object> clazz, String fieldName) {
		Field field = null;
		try {
			field = clazz.getDeclaredField(fieldName);
		} catch (NoSuchFieldException | SecurityException e) {
			// Silent catch
		}
		return field;
	}

	public static void invokeMethod(Object object, String methodName) {
		Method method = getMethod(object.getClass(), methodName);
		method.setAccessible(true);
		try {
			method.invoke(object);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// Silent catch
		} finally {
			method.setAccessible(false);
		}
	}
	
	private static Method getMethod(Class<? extends Object> clazz, String methodName) {
		Method method = getDeclaredMethodSafe(clazz, methodName);
		while(method == null && clazz != null) {
			clazz = clazz.getSuperclass();
			method = getDeclaredMethodSafe(clazz, methodName);
		}
		return method;
	}
	
	private static Method getDeclaredMethodSafe(Class<? extends Object> clazz, String methodName) {
		Method method = null;
		try {
			method = clazz.getDeclaredMethod(methodName);
		} catch (NoSuchMethodException | SecurityException e) {
			// Silent catch
		}
		return method;
	}

}
