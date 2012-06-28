package org.obeonetwork.dsl.database.section;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.properties.sections.PropertiesEditionSection;

abstract public class AbstractDatabasePropertiesEditionSection extends PropertiesEditionSection {

	private AdapterFactory adapterFactory;
		
	protected PropertiesEditingProvider getProvider(EObject eObject) {
		if (adapterFactory == null) {
			adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		}
		return (PropertiesEditingProvider)adapterFactory.adapt(eObject, PropertiesEditingProvider.class);
	}
}