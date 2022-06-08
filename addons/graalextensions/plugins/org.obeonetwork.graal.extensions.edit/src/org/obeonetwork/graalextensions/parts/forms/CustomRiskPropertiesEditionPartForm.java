/**
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.graalextensions.parts.forms;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

import org.obeonetwork.graalextensions.adapterfactory.CustomAdapterFactory;
import org.obeonetwork.graalextensions.adapterfactory.CustomAdapterFactory.PropertiesTab;

public class CustomRiskPropertiesEditionPartForm extends RiskPropertiesEditionPartForm {

	public CustomRiskPropertiesEditionPartForm() {
		super();
		adapterFactory = new CustomAdapterFactory(PropertiesTab.RISK);
	}
	
	@Override
	protected EObject resolveSemanticObject(Object object) {
		if (object instanceof DSemanticDecorator) {
			return((DSemanticDecorator) object).getTarget();
		}
		return super.resolveSemanticObject(object);
	}
}
