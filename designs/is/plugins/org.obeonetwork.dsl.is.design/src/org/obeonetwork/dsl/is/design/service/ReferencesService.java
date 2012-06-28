/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.is.design.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.dsl.environment.Reference;

public class ReferencesService {
	
	public List<Reference> getDtoOppositeReferences(EObject context, List<Reference> references) {
		Map<String, Reference> map = new HashMap<String, Reference>();
		for (Reference ref : references) {
			if (ref.getOppositeOf() != null) {
				String key1 = ref.getOppositeOf().hashCode() + "" + ref.hashCode();
				String key2 = ref.hashCode() + "" + ref.getOppositeOf().hashCode();
				if (map.get(key1) == null && map.get(key2) == null) {
					map.put(key1, ref);
				}
			}
		}
		return new ArrayList<Reference>(map.values());
	}
	
	public List<org.obeonetwork.dsl.entity.Reference> getEntityOppositeReferences(EObject context, List<org.obeonetwork.dsl.entity.Reference> references) {
		Map<String, org.obeonetwork.dsl.entity.Reference> map = new HashMap<String, org.obeonetwork.dsl.entity.Reference>();
		for (org.obeonetwork.dsl.entity.Reference ref : references) {
			if (ref.getOppositeOf() != null) {
				String key1 = ref.getOppositeOf().hashCode() + "" + ref.hashCode();
				String key2 = ref.hashCode() + "" + ref.getOppositeOf().hashCode();
				if (map.get(key1) == null && map.get(key2) == null) {
					map.put(key1, ref);
				}
			}
		}
		return new ArrayList<org.obeonetwork.dsl.entity.Reference>(map.values());
	}
	
	public void deleteEntityReferences(List<org.obeonetwork.dsl.entity.Reference> references) {
		for (org.obeonetwork.dsl.entity.Reference reference : references) {
			EcoreUtil.delete(reference, true);
		}
	}
	

	public void deleteDtoReferences(List<org.obeonetwork.dsl.environment.Reference> references) {
		for (org.obeonetwork.dsl.environment.Reference reference : references) {
			EcoreUtil.delete(reference, true);
		}
	}
}