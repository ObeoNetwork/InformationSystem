/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.graal.m2doc.services;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.acceleo.annotations.api.documentation.Documentation;
import org.eclipse.acceleo.annotations.api.documentation.Example;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.obeonetwork.graal.Node;
import org.obeonetwork.graal.Task;
import org.obeonetwork.graal.provider.GraalItemProviderAdapterFactory;

public class TaskServices {
	
	// @formatter:off
	@Documentation(
			comment = "{m:myTask.allChildrenAndTask()}",
		    value = "Return a list containing a task and all its contained children.",
		    examples = {
		    		@Example(
		    				expression = "{m:myTask.allChildrenAndTask()}", 
		    				result = "a list containing a task and all its contained children.")
		    }
		)
	// @formatter:on	
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
