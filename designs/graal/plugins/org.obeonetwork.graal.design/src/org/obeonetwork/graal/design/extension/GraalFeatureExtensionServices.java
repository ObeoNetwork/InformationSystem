/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.design.extension;


import org.obeonetwork.graal.design.graalfeatureextensions.UIConfiguration;

import fr.obeo.dsl.viewpoint.DFeatureExtension;
import fr.obeo.dsl.viewpoint.business.api.featureextensions.AbstractFeatureExtensionServices;
import fr.obeo.dsl.viewpoint.description.FeatureExtensionDescription;

/**
 * Feature extension services used to set the EClass to be saved within the aird resource
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
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
