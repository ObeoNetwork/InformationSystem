package org.obeonetwork.dsl.environment.design.ui.providers;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;

public class ArrayTreeContentProvider extends ArrayContentProvider implements ITreeContentProvider {

	@Override
	public Object[] getChildren(Object parentElement) {
		return new Object[]{};
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return false;
	}

}
