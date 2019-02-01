/*******************************************************************************
 * Copyright (c) 2019 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.properties.internal.services;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;

public class EnvironmentServices {
	
	public MetaDataContainer getMetadataContainer(EObject self) {
		MetaDataContainer metadatas = null;
		if (self instanceof ObeoDSMObject) {
			metadatas = ((ObeoDSMObject) self).getMetadatas();
			if (metadatas == null) {
				metadatas = EnvironmentFactory.eINSTANCE.createMetaDataContainer();
				((ObeoDSMObject) self).setMetadatas(metadatas);
			}
		}
		return metadatas;
	}
}
