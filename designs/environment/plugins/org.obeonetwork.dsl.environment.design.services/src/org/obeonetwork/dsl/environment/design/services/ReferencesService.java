/*******************************************************************************
 * Copyright (c) 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.design.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.Type;

import com.google.common.collect.Sets;

public class ReferencesService {
	
	public List<Reference> getReferences(Namespace namespace) {
		List<Reference> references = new ArrayList<Reference>();
		for (Type type : namespace.getTypes()) {
			if (type instanceof StructuredType) {
				references.addAll(((StructuredType)type).getReferences());
			}
		}
		for (Namespace subNamespace : namespace.getOwnedNamespaces()) {
			references.addAll(getReferences(subNamespace));
		}
		return references;
	}
	
	public List<Reference> getOppositeReferences(Namespace namespace, DSemanticDiagram diagram) {
		Collection<StructuredType> structuredTypes = DesignServices.getDisplayedStructuredTypes(diagram);
		Set<Reference> references = Sets.newLinkedHashSet();
		for (StructuredType structuredType : structuredTypes) {
			references.addAll(structuredType.getOwnedReferences());
		}
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
	
	public List<Reference> getOppositeReferences2(Namespace namespace) {
		List<Reference> bidiRefs = new ArrayList<Reference>();
		for (Reference ref : getReferences(namespace)) {
			if (ref.getOppositeOf() != null) {
				if (!bidiRefs.contains(ref) && !bidiRefs.contains(ref.getOppositeOf())) {
					bidiRefs.add(ref);
				}
			}
		}
		return bidiRefs;
	}
	
	public Reference reconnectBidiReferenceTarget(Reference reference, StructuredType source, StructuredType target) {
		Reference oppositeOf = reference.getOppositeOf();
		
		reference.setReferencedType(target);
		oppositeOf.setContainingType(target);
		
		reference.setOppositeOf(oppositeOf);
		
		return reference;
	}
	
	public Reference reconnectBidiReferenceSource(Reference reference, StructuredType source, StructuredType target) {
		Reference oppositeOf = reference.getOppositeOf();
		
		// Change container of reference
		reference.setContainingType(target);
		// Change referencedType for opposite reference
		oppositeOf.setReferencedType(target);
		
		reference.setOppositeOf(oppositeOf);
		
		return reference;
	}
	
}