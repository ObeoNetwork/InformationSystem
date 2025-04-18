/**
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.graalextensions.adapterfactory;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.obeonetwork.graalextensions.filter.GraalExtensionsFilter;
import org.obeonetwork.graalextensions.providers.CustomRiskPropertiesEditionProvider;
import org.obeonetwork.graalextensions.providers.VersionPropertiesEditionProvider;

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
