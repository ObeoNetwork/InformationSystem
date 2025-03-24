/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.design.services.extensions.properties;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.graal.Task;
import org.obeonetwork.graal.UseCase;
import org.obeonetwork.graal.UserStory;

import org.obeonetwork.graalextensions.GraalExtensionsFactory;
import org.obeonetwork.graalextensions.Risk;

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
	
	public String formatVersionDateValue(Date date) {
		if (date != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return simpleDateFormat.format(date);
		}
		return "";
	}
}
