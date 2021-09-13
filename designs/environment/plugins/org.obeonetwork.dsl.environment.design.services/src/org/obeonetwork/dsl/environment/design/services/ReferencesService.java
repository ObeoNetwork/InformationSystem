/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
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

import com.google.common.collect.Sets;

public class ReferencesService {
	
	public List<Reference> getReferencesBetweenTypes(Collection<StructuredType> structuredTypes) {
		List<Reference> references = new ArrayList<Reference>();
		
		for (StructuredType structuredType : structuredTypes) {
			for (Reference reference : structuredType.getOwnedReferences()) {
				if (structuredTypes.contains(reference.getReferencedType())) {
					references.add(reference);
				}
			}
		}
		return references;
	}
	
	public List<Reference> getReferences(DSemanticDiagram diagram) {
		Set<StructuredType> types = DesignServices.getDisplayedStructuredTypes(diagram);
		List<Reference> references = new ArrayList<Reference>();
		for (StructuredType type : types) {
			references.addAll(type.getOwnedReferences());
		}
		return references;
	}
	
	public List<Reference> getOppositeReferences(DSemanticDiagram diagram) {
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
	
	/**
	 * Returns the {@link Namespace} qualified name of a {@link Reference}  
	 * @param reference a {@link Reference}
	 * @return The qualified name as a {@link String} 
	 */
	public static String getNamespaceQualifiedName(Reference reference) {
		String namespaceQualifiedName = null;
		if (reference.eContainer() != null && reference.eContainer() instanceof StructuredType) {
			StructuredType structuredType = (StructuredType) reference.eContainer();
			namespaceQualifiedName = TypesServices.getNamespaceQualifiedName(structuredType);	
		}
		return namespaceQualifiedName;
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