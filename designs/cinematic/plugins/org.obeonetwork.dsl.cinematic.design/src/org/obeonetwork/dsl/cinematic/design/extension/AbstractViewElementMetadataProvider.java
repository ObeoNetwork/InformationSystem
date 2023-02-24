/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.design.extension;

import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.properties.providers.IMetaDataHelpProvider;

public class AbstractViewElementMetadataProvider implements IMetaDataHelpProvider{
	
	@Override
	public String getHelpMessage(ObeoDSMObject dsmObject) {
		if (dsmObject instanceof AbstractViewElement)
			return ((AbstractViewElement) dsmObject).getWidget().getMetadataHelp();
		else 
			return null;
	}

}
