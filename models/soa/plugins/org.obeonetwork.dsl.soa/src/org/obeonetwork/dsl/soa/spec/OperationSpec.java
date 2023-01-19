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
package org.obeonetwork.dsl.soa.spec;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.soa.SecurityApplication;
import org.obeonetwork.dsl.soa.SecurityScheme;
import org.obeonetwork.dsl.soa.Service;
import org.obeonetwork.dsl.soa.impl.OperationImpl;

public class OperationSpec extends OperationImpl {

	@Override
	public EList<SecurityScheme> getSecuritySchemes() {
		
		return ECollections.unmodifiableEList(getSecurityApplications().stream().map(sa -> sa.getSecurityScheme()).collect(Collectors.toList()));
	}

	@Override
	public EList<SecurityApplication> getAllSecurityApplications() {
		List<SecurityApplication> allSecurityApplications = new ArrayList<>();
		if(eContainer() != null && eContainer().eContainer() instanceof Service) {
			allSecurityApplications.addAll(((Service)eContainer().eContainer()).getSecurityApplications());
		}
		allSecurityApplications.addAll(getSecurityApplications());
		
		return ECollections.unmodifiableEList(allSecurityApplications);
	}

}
