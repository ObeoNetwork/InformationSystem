/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.projectlibrary.extension;

import org.eclipse.sirius.business.api.featureextensions.FeatureExtension;
import org.eclipse.sirius.business.api.featureextensions.FeatureExtensionServices;

/**
 * Feature extension used to store manifest information in the aird resource
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
public class ManifestFeatureExtension implements FeatureExtension {

	/**
	 * The extension services.
	 */
	private FeatureExtensionServices services;
	public static String FEATURE_EXTENSION_NAME = "IS_MANIFEST_FEATURE_EXTENSION";
	
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
			services = new ManifestFeatureExtensionServices();
		}
		return services;
	}

}
