/*******************************************************************************
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.graal.m2doc.services;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.graal.Task;

public class TaskServices {
	
	/**
	 * Return a list containing a task and all its contained children
	 */
	public List<EObject> allChildrenAndTask(Task task) {
		List<EObject> result = new ArrayList<>();
		result.add(task);
		
		TreeIterator<Object> iterator = EcoreUtil.getAllContents(task, true);
		while (iterator.hasNext()) {
			Object element = iterator.next();
			if (element instanceof EObject) {
				result.add((EObject)element);
			}
		}
		return result;
	}

}
