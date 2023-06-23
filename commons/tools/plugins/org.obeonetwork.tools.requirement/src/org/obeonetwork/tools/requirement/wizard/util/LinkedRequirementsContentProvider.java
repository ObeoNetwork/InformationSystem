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
package org.obeonetwork.tools.requirement.wizard.util;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.obeonetwork.tools.requirement.core.util.RequirementService;

public class LinkedRequirementsContentProvider extends AdapterFactoryContentProvider {

	public LinkedRequirementsContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public boolean hasChildren(Object object) {
		return false;
	}

	public Object[] getElements(Object object) {
		if (object instanceof EObject) {
			EObject eObject = (EObject) object;
			return RequirementService.getLinkedRequirements(eObject);
		}
		return new Object[0];
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if (newInput instanceof EObject) {
			super.inputChanged(viewer, oldInput, newInput);
		}
	}

}
