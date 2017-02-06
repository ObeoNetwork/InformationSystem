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
