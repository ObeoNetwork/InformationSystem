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
/**
 * 
 */
package org.obeonetwork.tools.requirement.ui.view.util;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.tools.linker.ui.view.util.EObjectLinkLabelProvider;
import org.obeonetwork.tools.requirement.core.RequirementLink;

/**
 * @author Obeo
 * 
 */
public class LinkedRequirementsLabelProvider extends EObjectLinkLabelProvider {

	private final static int ID = 0;
	private final static int NAME = 1;
	private final static int CATEGORY = 2;

	/**
	 * @param adapterFactory
	 */
	public LinkedRequirementsLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.tools.linker.ui.view.util.EObjectLinkLabelProvider#getColumnText(java.lang.Object,
	 *      int)
	 */
	@Override
	public String getColumnText(Object element, int columnIndex) {
		String text = ""; //$NON-NLS-1$
		if (element instanceof RequirementLink) {
			Requirement requirement = (Requirement) ((RequirementLink) element).getRequirement();

			if (columnIndex == ID) {
				text = requirement.getId();
			} else if (columnIndex == NAME) {
				text = requirement.getName();
			} else if (columnIndex == CATEGORY) {
				text = requirement.getCategory() != null ? requirement.getCategory().getName() : ""; //$NON-NLS-1$
			}
		}
		return text == null ? "" : text; //$NON-NLS-1$
	}

}
