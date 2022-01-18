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
package org.obeonetwork.m2doc.doc.generator.reflection;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

public class OEcoreUtil {

	private static Map<Class<?>, EClass> classToEClassMap = null;
	
	public static <T> EClass getEClass(Class<T> type) {

		if(classToEClassMap == null) {
			init();
		}
		
		return classToEClassMap.get(type);
	}

	private static void init() {
		classToEClassMap = new HashMap<>();
		for(Object v : EPackage.Registry.INSTANCE.values()) {
			if(v instanceof EPackage) {
				EPackage ePackage = (EPackage) v;
				for(EClassifier classifier : ePackage.getEClassifiers()) {
					if(classifier instanceof EClass) {
						classToEClassMap.put(classifier.getInstanceClass(), (EClass) classifier);
					}
				}
			}
		}
	}
	
}
