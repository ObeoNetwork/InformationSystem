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
package org.obeonetwork.tools.projectlibrary.extension;


import org.eclipse.sirius.business.api.featureextensions.AbstractFeatureExtensionServices;
import org.eclipse.sirius.viewpoint.DFeatureExtension;
import org.eclipse.sirius.viewpoint.description.FeatureExtensionDescription;
import org.obeonetwork.dsl.manifest.MImportExportData;

/**
 * Feature extension services used to set the EClass to be saved within the aird resource
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
public class ManifestFeatureExtensionServices extends AbstractFeatureExtensionServices {

	@Override
	protected Class<? extends DFeatureExtension> getFeatureExtensionClass() {
		return MImportExportData.class;
	}

	@Override
	protected Class<? extends FeatureExtensionDescription> getFeatureExtensionDescriptionClass() {
		return null;
	}
}
