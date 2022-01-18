/**
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package fr.gouv.mindef.safran.graalextensions.adapterfactory;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import fr.gouv.mindef.safran.graalextensions.filter.GraalExtensionsFilter;
import fr.gouv.mindef.safran.graalextensions.providers.CustomRiskPropertiesEditionProvider;
import fr.gouv.mindef.safran.graalextensions.providers.VersionPropertiesEditionProvider;

public class CustomAdapterFactory extends AdapterFactoryImpl {
	private AdapterFactory composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	private PropertiesTab propertiesTab;
	
	public enum PropertiesTab {
		VERSION, RISK
	}
	
	public CustomAdapterFactory(PropertiesTab propertiesTab) {
		super();
		this.propertiesTab = propertiesTab;
	}

	@Override
	public Object adapt(Object target, Object type) {
		if (GraalExtensionsFilter.isPerimeterUnit(target)) {
			if (type == PropertiesEditingProvider.class) {
				return getProviderForType(type);
			}
		}
		return composedAdapterFactory.adapt(target, type);
	}

	@Override
	public Adapter adapt(Notifier target, Object type) {
		if (GraalExtensionsFilter.isPerimeterUnit(target)) {
			if (type == PropertiesEditingProvider.class) {
				return getProviderForType(type);
			}
		}
		return composedAdapterFactory.adapt(target, type);
	}
	
	private Adapter getProviderForType(Object type) {
		if (type == PropertiesEditingProvider.class) {
			if (propertiesTab == PropertiesTab.VERSION) {					
				return new VersionPropertiesEditionProvider();
			}
			if (propertiesTab == PropertiesTab.RISK) {					
				return new CustomRiskPropertiesEditionProvider();
			}
		}
		return null;
	}

	@Override
	public boolean isFactoryForType(Object type) {
		return composedAdapterFactory.isFactoryForType(type);
	}
	
}
