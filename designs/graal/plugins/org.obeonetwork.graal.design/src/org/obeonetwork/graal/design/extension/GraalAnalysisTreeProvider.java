package org.obeonetwork.graal.design.extension;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.obeonetwork.graal.provider.TasksItemProvider;

public class GraalAnalysisTreeProvider implements ITreeContentProvider {

	@Override
	public Object[] getElements(Object inputElement) {
		return new Object[0];
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if(parentElement instanceof TasksItemProvider) {
			TasksItemProvider tasksItemProvider = (TasksItemProvider) parentElement;
			return tasksItemProvider.getChildren(tasksItemProvider.getTarget()).toArray();
		}
		return new Object[0];
	}

	@Override
	public Object getParent(Object element) {
		if(element instanceof TasksItemProvider) {
			TasksItemProvider tasksItemProvider = (TasksItemProvider) element;
			return tasksItemProvider.getParent(tasksItemProvider.getTarget());
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

}
