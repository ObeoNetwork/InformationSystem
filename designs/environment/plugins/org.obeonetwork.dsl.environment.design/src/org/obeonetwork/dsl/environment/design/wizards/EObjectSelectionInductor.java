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
package org.obeonetwork.dsl.environment.design.wizards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

public abstract class EObjectSelectionInductor implements ISObjectSelectionWizardPage.ISelectionInductor {

	private Map<EObject, List<EObjectTreeItemWrapper>> treeItemWrapersMap = new HashMap<>();
	
	public EObjectSelectionInductor(EObjectTreeItemWrapper treeRoot) {
		initTreeItemWrapersMap(treeRoot);
	}

	private void initTreeItemWrapersMap(EObjectTreeItemWrapper treeItemWraper) {
		List<EObjectTreeItemWrapper> treeItemWrapers = treeItemWrapersMap.get(treeItemWraper.getWrappedEObject());
		if(treeItemWrapers == null) {
			treeItemWrapers = new ArrayList<>();
			treeItemWrapersMap.put(treeItemWraper.getWrappedEObject(), treeItemWrapers);
		}
		
		if(!treeItemWrapers.contains(treeItemWraper)) {
			treeItemWrapers.add(treeItemWraper);
		}
		
		for(EObjectTreeItemWrapper childTreeItemWrapper : treeItemWraper.getChildren()) {
			initTreeItemWrapersMap(childTreeItemWrapper);
		}
	}

	@Override
	public List<EObjectTreeItemWrapper> select(EObjectTreeItemWrapper selected) {
		List<EObject> inducedSelectedEObjects = selectEObject(selected.getWrappedEObject());
		List<EObjectTreeItemWrapper> inducedSelectedEObjectTreeItemWrappers = new ArrayList<>();
		for(EObject inducedSelectedEObject : inducedSelectedEObjects) {
			List<EObjectTreeItemWrapper> treeItemWrappers = treeItemWrapersMap.get(inducedSelectedEObject);
			if(treeItemWrappers != null) {
				inducedSelectedEObjectTreeItemWrappers.addAll(treeItemWrappers);
			}
		}
		return inducedSelectedEObjectTreeItemWrappers;
	}
	
	public abstract List<EObject> selectEObject(EObject selected);

}
