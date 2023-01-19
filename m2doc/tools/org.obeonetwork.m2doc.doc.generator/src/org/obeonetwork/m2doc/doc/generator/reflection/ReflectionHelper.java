/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.m2doc.doc.generator.reflection;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ReflectionHelper {

    public static List<Class<?>> getClasses(String packageName) {
    	try {
    		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    		String path = packageName.replace('.', '/');
    		Enumeration<URL> resources = classLoader.getResources(path);
    		List<File> dirs = new ArrayList<File>();
    		while (resources.hasMoreElements()) {
    			URL resource = resources.nextElement();
    			dirs.add(new File(resource.getFile()));
    		}
    		ArrayList<Class<?>> classes = new ArrayList<Class<?>>();
    		for (File directory : dirs) {
    			classes.addAll(findClasses(directory, packageName));
    		}
    		return classes;
    	} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	return null;
    }
	
    private static List<Class<?>> findClasses(File directory, String packageName) throws ClassNotFoundException {
    	List<Class<?>> classes = new ArrayList<Class<?>>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
            	classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }    
}
