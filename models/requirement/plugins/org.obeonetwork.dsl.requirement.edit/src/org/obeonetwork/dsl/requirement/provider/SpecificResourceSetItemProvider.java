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
package org.obeonetwork.dsl.requirement.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.resource.ResourceItemProvider;

public class SpecificResourceSetItemProvider extends ResourceItemProvider {

	public SpecificResourceSetItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Collection<?> getChildren(Object object) {
		Collection<Object> result = new ArrayList<Object>();
		
		// Including all resources in ResourceSet
		for (Resource resource : ((ResourceSet)object).getResources()) {
			// For each Resource, collect the root elements
			List<EObject> contents = resource.getContents();
		    for (Object o : contents) {
		    	// If the object is controlled, it will show in the tree under its own resource
		    	if (!AdapterFactoryEditingDomain.isControlled(o)) {
		    		result.add(o);
		    	}
		    }
		}
		return result;
	}
}
