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
package org.obeonetwork.dsl.requirement.design.provider;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.dsl.requirement.provider.RequirementItemProviderAdapterFactory;

public class RequirementLabelProvider extends LabelProvider {

	private static AdapterFactoryLabelProvider delegatedLabelProvider = null;
	
	@Override
	public Image getImage(Object element) {
		return getLabelProvider().getImage(element);
	}
	
	@Override
	public String getText(Object element) {
		if (element instanceof Category) {
			Category cat = (Category)element;
			return cat.getId() + " - " + cat.getName();
		} else if (element instanceof Requirement) {
			Requirement req = (Requirement)element;
			return req.getId() + " - "	 + req.getName();
		}
		return getLabelProvider().getText(element);
	}
	
	private ILabelProvider getLabelProvider() {
		if (delegatedLabelProvider == null) {
			delegatedLabelProvider = new AdapterFactoryLabelProvider(new RequirementItemProviderAdapterFactory());
		}
		return delegatedLabelProvider;
	}
}
