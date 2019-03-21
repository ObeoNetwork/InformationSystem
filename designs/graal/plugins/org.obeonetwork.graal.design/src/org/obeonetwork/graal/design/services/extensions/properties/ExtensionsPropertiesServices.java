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
package org.obeonetwork.graal.design.services.extensions.properties;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.graal.Task;
import org.obeonetwork.graal.UseCase;
import org.obeonetwork.graal.UserStory;

import fr.gouv.mindef.safran.graalextensions.GraalExtensionsFactory;
import fr.gouv.mindef.safran.graalextensions.Risk;

public class ExtensionsPropertiesServices {
	
	public boolean handleRiskAndVersionProperties(EObject context) {
		boolean canHaveRiskProperties = false;
		
		canHaveRiskProperties |= context instanceof Task;
		canHaveRiskProperties |= context instanceof UseCase;
		canHaveRiskProperties |= context instanceof UserStory;
		
		return canHaveRiskProperties;
	}
	
	public Risk getRisk(ObeoDSMObject context) {
		return Optional.ofNullable(context.getMetadatas()).map(MetaDataContainer::getMetadatas)
				.flatMap(l -> l.stream().filter(Risk.class::isInstance).findFirst())
				.map(Risk.class::cast)
				.orElse(GraalExtensionsFactory.eINSTANCE.createRisk());
	}
}
