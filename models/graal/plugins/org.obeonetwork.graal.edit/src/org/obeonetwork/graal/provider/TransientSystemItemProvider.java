package org.obeonetwork.graal.provider;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.obeonetwork.graal.System;

public class TransientSystemItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

	public TransientSystemItemProvider(AdapterFactory adapterFactory, System system) {
		super(adapterFactory);
		system.eAdapters().add(this);
	}

	@Override
	public Object getParent(Object object) {
		return target;
	}

	@Override
	public Collection<?> getChildren(Object object) {
		return super.getChildren(target);
	}

	
}
