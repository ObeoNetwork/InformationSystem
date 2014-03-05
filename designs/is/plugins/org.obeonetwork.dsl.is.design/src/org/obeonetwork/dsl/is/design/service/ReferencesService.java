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
import java.util.List;

import org.obeonetwork.dsl.entity.Block;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.environment.DTO;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.soa.Category;
import org.obeonetwork.dsl.soa.DTORegistry;

import fr.obeo.dsl.viewpoint.business.api.session.Session;
import fr.obeo.dsl.viewpoint.business.api.session.SessionManager;
import fr.obeo.mda.ecore.extender.business.api.accessor.ModelAccessor;

public class ReferencesService {
	
	public List<Reference> getDtoReferences(DTORegistry registry) {
		List<Reference> references = new ArrayList<Reference>();
		for (Category category : registry.getOwnedCategories()) {
			references.addAll(getDtoReferences(category));
		}
		return references;
	}
	
	public List<Reference> getDtoReferences(Category category) {
		List<Reference> references = new ArrayList<Reference>();
		for (Type type : category.getTypes()) {
			if (type instanceof DTO) {				
			references.addAll(((DTO)type).getReferences());
			}
		}
		for (Category subCategory : category.getOwnedCategories()) {
			references.addAll(getDtoReferences(subCategory));
		}
		return references;
	}
	
	public List<Reference> getDtoOppositeReferences(DTORegistry registry) {
		List<Reference> bidiRefs = new ArrayList<Reference>();
		for (Reference ref : getDtoReferences(registry)) {
			if (ref.getOppositeOf() != null) {
				if (!bidiRefs.contains(ref) && !bidiRefs.contains(ref.getOppositeOf())) {
					bidiRefs.add(ref);
				}
			}
		}
		return bidiRefs;
	}
	
	public List<Reference> getDtoOppositeReferences(Category category) {
		List<Reference> bidiRefs = new ArrayList<Reference>();
		for (Reference ref : getDtoReferences(category)) {
			if (ref.getOppositeOf() != null) {
				if (!bidiRefs.contains(ref) && !bidiRefs.contains(ref.getOppositeOf())) {
					bidiRefs.add(ref);
				}
			}
		}
		return bidiRefs;
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