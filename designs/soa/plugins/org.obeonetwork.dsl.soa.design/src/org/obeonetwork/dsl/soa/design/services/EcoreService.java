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
package org.obeonetwork.dsl.soa.design.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;

public class EcoreService {

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
	
	static public List<EObject> eContents(EObject context, Class<?> typeClass){
		List<EObject> containedElements = new ArrayList<EObject>();
		List<EObject> contents = context.eContents();		
		for (EObject obj: contents){						
			if (typeClass.isAssignableFrom(obj.getClass()) && !containedElements.contains(obj)){				
				containedElements.add(obj);
			}
		}
		return containedElements;
	}
}