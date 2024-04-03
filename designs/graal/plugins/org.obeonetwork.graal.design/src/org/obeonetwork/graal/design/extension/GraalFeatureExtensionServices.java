/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.design.extension;


import org.obeonetwork.graal.design.graalfeatureextensions.UIConfiguration;

import org.eclipse.sirius.viewpoint.DFeatureExtension;
import org.eclipse.sirius.business.api.featureextensions.AbstractFeatureExtensionServices;
import org.eclipse.sirius.viewpoint.description.FeatureExtensionDescription;

/**
 * Feature extension services used to set the EClass to be saved within the aird resource
 * @author Obeo
 *
 */
public class GraalFeatureExtensionServices extends AbstractFeatureExtensionServices {

	@Override
	protected Class<? extends DFeatureExtension> getFeatureExtensionClass() {
		return UIConfiguration.class;
	}

	@Override
	protected Class<? extends FeatureExtensionDescription> getFeatureExtensionDescriptionClass() {
		return null;
	}
}
