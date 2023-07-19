/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.design.extension;

import org.eclipse.sirius.business.api.featureextensions.FeatureExtension;
import org.eclipse.sirius.business.api.featureextensions.FeatureExtensionServices;

/**
 * Graal feature extension used to store UI preferences in the aird resource
 * @author Obeo
 *
 */
public class GraalFeatureExtension implements FeatureExtension {

	/**
	 * The extension services.
	 */
	private FeatureExtensionServices services;
	public static String FEATURE_EXTENSION_NAME = "GRAAL_UI_FEATURE_EXTENSION";
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.business.api.featureextensions.FeatureExtension#getName()
	 */
	public String getName() {
		return FEATURE_EXTENSION_NAME;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.business.api.featureextensions.FeatureExtension#getServices()
	 */
	public FeatureExtensionServices getServices() {
		if (services == null) {
			services = new GraalFeatureExtensionServices();
		}
		return services;
	}

}
