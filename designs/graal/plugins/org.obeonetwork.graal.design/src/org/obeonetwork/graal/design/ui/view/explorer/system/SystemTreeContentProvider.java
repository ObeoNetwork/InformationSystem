package org.obeonetwork.graal.design.ui.view.explorer.system;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.obeonetwork.graal.System;
import org.obeonetwork.graal.provider.custom.SystemCustomContentItemProvider;

/**
 * @author Obeo
 *
 */
public class SystemTreeContentProvider implements ITreeContentProvider {
	@Override
	public Object[] getElements(Object inputElement) {
		return new Object[0];
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof SystemCustomContentItemProvider) {
			SystemCustomContentItemProvider systemCustomContentItemProvider = (SystemCustomContentItemProvider) parentElement;
			return systemCustomContentItemProvider.getChildren(systemCustomContentItemProvider.getTarget()).toArray();
		} else if (parentElement instanceof EObject && !(parentElement instanceof System)) {// Below SystemCustomContentItemProvider
			final AdapterFactory composedAdapterFactory = new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			Object itemProvider = composedAdapterFactory.adapt((EObject) parentElement,
					IEditingDomainItemProvider.class);
			return ((IEditingDomainItemProvider) itemProvider).getChildren(parentElement).toArray();
		}
		return new Object[0];
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof SystemCustomContentItemProvider) {
			SystemCustomContentItemProvider systemCustomContentItemProvider = (SystemCustomContentItemProvider) element;
			return systemCustomContentItemProvider.getParent(systemCustomContentItemProvider.getTarget());
		} else if (element instanceof EObject && !(element instanceof System)) {// Below SystemCustomContentItemProvider
			final AdapterFactory composedAdapterFactory = new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			Object itemProvider = composedAdapterFactory.adapt(element, IEditingDomainItemProvider.class);
			if (itemProvider != null) {
				return ((IEditingDomainItemProvider) itemProvider).getParent(element);
			}
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}
}
