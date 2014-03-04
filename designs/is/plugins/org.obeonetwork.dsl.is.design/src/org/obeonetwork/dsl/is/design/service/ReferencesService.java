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
import org.obeonetwork.dsl.entity.Block;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.environment.Reference;

import fr.obeo.dsl.viewpoint.business.api.session.Session;
import fr.obeo.dsl.viewpoint.business.api.session.SessionManager;
import fr.obeo.mda.ecore.extender.business.api.accessor.ModelAccessor;

public class ReferencesService {
	
	public List<Reference> getDtoOppositeReferences(EObject context, List<Reference> references) {
		Map<String, Reference> map = new HashMap<String, Reference>();
		for (Reference ref : references) {
			if (ref.getOppositeOf() != null) {
				String key1 = ref.getOppositeOf().hashCode() + "" + ref.hashCode();
				String key2 = ref.hashCode() + "" + ref.getOppositeOf().hashCode();
				if (map.get(key1) == null && map.get(key2) == null) {
					// Try to always return the same reference as first element
					if (key1.compareTo(key2) > 0) {
						map.put(key1, ref);
					} else {
						map.put(key2, ref.getOppositeOf());
					}
				}
			}
		}
		return new ArrayList<Reference>(map.values());
	}
	
	public List<org.obeonetwork.dsl.entity.Reference> getEntityReferences(Block block) {
		List<org.obeonetwork.dsl.entity.Reference> references = new ArrayList<org.obeonetwork.dsl.entity.Reference>();
		for (Entity entity : block.getEntities()) {
			references.addAll(entity.getReferences());
		}
		for (Block subBlock : block.getSubblocks()) {
			references.addAll(getEntityReferences(subBlock));
		}
		return references;
	}
	
	public List<org.obeonetwork.dsl.entity.Reference> getEntityOppositeReferences(Block block) {
		List<org.obeonetwork.dsl.entity.Reference> bidiRefs = new ArrayList<org.obeonetwork.dsl.entity.Reference>();
		for (org.obeonetwork.dsl.entity.Reference ref : getEntityReferences(block)) {
			if (ref.getOppositeOf() != null) {
				if (!bidiRefs.contains(ref) && !bidiRefs.contains(ref.getOppositeOf())) {
					bidiRefs.add(ref);
				}
			}
		}
		return bidiRefs;
	}
	
	public void deleteEntityReferences(List<org.obeonetwork.dsl.entity.Reference> references) {
		Session session = null;
		ModelAccessor modelAccessor = null;
		for (org.obeonetwork.dsl.entity.Reference reference : references) {
			if (session == null) {
				session = SessionManager.INSTANCE.getSession(reference);
			}
			if (modelAccessor == null) {
				modelAccessor = session.getModelAccessor();
			}
			DeleteUtils.delete(reference, session, modelAccessor);
		}
	}

	public void deleteDtoReferences(List<Reference> references) {
		Session session = null;
		ModelAccessor modelAccessor = null;
		for (Reference reference : references) {
			if (session == null) {
				session = SessionManager.INSTANCE.getSession(reference);
			}
			if (modelAccessor == null) {
				modelAccessor = session.getModelAccessor();
			}
			DeleteUtils.delete(reference, session, modelAccessor);
		}
	}
}