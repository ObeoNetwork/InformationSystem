/**
 * Copyright (c) 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *
 * $Id$
 */
package org.obeonetwork.tools.requirement.wizard.util;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class RequirementsRepositoriesContentProvider extends AdapterFactoryContentProvider implements ITreeContentProvider{

	public RequirementsRepositoriesContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	public Object[] getElements(Object object) {
		if(object instanceof Collection<?>){
			@SuppressWarnings("unchecked")
			Collection<Resource> requirementsRepositories = (Collection<Resource>)object;
			return requirementsRepositories.toArray(new Resource[requirementsRepositories.size()]);
		}		
		return super.getElements(object);
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		super.inputChanged(viewer, oldInput, newInput);
	}

	
	
}
