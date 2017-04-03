/**
 * Copyright (c) 2012, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 */
package fr.gouv.mindef.safran.graalextensions.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import fr.gouv.mindef.safran.graalextensions.util.GraalExtensionsAdapterFactory;

/**
 * @author Obeo.fr
 * 
 */
public class GraalextensionsEEFAdapterFactory extends GraalExtensionsAdapterFactory {

	public GraalextensionsEEFAdapterFactory() {
	}
	
	@Override
	public Adapter createRiskAdapter() {
		List<PropertiesEditingProvider> providers = new ArrayList<PropertiesEditingProvider>(1);
		providers.add((PropertiesEditingProvider)createMetaDataAdapter());
		return new RiskPropertiesEditionProvider(providers);
	}


}
