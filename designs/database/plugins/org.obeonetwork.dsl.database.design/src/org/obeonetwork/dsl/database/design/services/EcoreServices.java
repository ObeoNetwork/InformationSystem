/*******************************************************************************
 * Copyright (c) 2009-2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.design.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;

public class EcoreServices {

	public Collection<EObject> allRoots(EObject any) {
		Collection<EObject> roots = new ArrayList<EObject>();
		
		Session session = SessionManager.INSTANCE.getSession(any);
		
		if (session != null) {
			for (Resource childRes : session.getSemanticResources()) {
				roots.addAll(childRes.getContents());
			}
		}
		
		return roots;
	}
	
	static public Collection<Resource> getAllSemanticResourcesInSession(EObject any) {
		Session session = SessionManager.INSTANCE.getSession(any);
		if (session != null) {
			return session.getSemanticResources();
		}
		return Collections.emptyList();
	}
	
	static public List<EObject> eAllContents(EObject context, Class<?> typeClass){
		List<EObject> allContainedElements = new ArrayList<EObject>();
		TreeIterator<EObject> allContents = context.eAllContents();
		Iterator<EObject> iter = allContents;
		while (iter.hasNext()){
			EObject iterNext = iter.next();						
			if (typeClass.isAssignableFrom(iterNext.getClass()) && !allContainedElements.contains(iterNext)){				
				allContainedElements.add(iterNext);
			}
		}
		return allContainedElements;
	}
}