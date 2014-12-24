package org.obeonetwork.dsl.entity.design.services.label.specific;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.obeonetwork.dsl.entity.Root;
import org.obeonetwork.dsl.entity.provider.EntityItemProviderAdapterFactory;
import org.obeonetwork.dsl.entity.util.EntitySwitch;

public class EntityLabelServices extends EntitySwitch<String> {

	@Override
	public String caseRoot(Root object) {
		EntityItemProviderAdapterFactory itemProviderFactory = new EntityItemProviderAdapterFactory();
		Adapter itemProvider = itemProviderFactory.adapt(object, IItemLabelProvider.class);
		return ((IItemLabelProvider)itemProvider).getText(object);
	}
	
}
