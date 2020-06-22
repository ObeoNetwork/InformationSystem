/*******************************************************************************
 * Copyright (c) 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.contextual.explorer.ui.internal.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.sirius.business.api.session.Session;
import org.obeonetwork.dsl.database.DatabaseElement;
import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.MetaData;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.tools.doc.core.DocumentationLink;

public final class ContextualExplorerUtils {
	
	private ContextualExplorerUtils() {
	}
	
	public static boolean isValidElement(Object o) {
		return o instanceof ObeoDSMObject || o instanceof DatabaseElement;
	}
	
	public static boolean isDocumentationLink(MetaData metaData) {
		if (metaData instanceof Annotation) {
			return ((Annotation) metaData).getTitle().startsWith(DocumentationLink.DOCUMENTATION_ANNOTATION_TITLE);
		}
		return false;
	}
	
	public static Collection<Object> getAllReferencesValues(Object object) {
		Set<Object> result = new HashSet<>();
		if (object instanceof EObject) {
			EList<EReference> eAllReferences = ((EObject) object).eClass().getEAllReferences();
			List<Object> values = eAllReferences.stream()
					.filter(ref -> !ContextualExplorerUtils.isOppositeOfContainmentReference(ref))
					.map(ref -> ((EObject) object).eGet(ref)).collect(Collectors.toList());
			result.addAll(values);
		}
		return result;
	}
	
	private static Optional<ECrossReferenceAdapter> getCrossReferencerAdapter(Object object) {
		Optional<ECrossReferenceAdapter> optional = Optional.empty();
		if (object instanceof EObject) {
			Optional<Session> oSession = Session.of((EObject) object);
			if (oSession.isPresent()) {
				Session session = oSession.get();
				return Optional.ofNullable(session.getSemanticCrossReferencer());
			}
		}
		return optional;
	}
	
	public static Collection<Setting> getAllInverseReferences(Object object) {
		return ContextualExplorerUtils.getCrossReferencerAdapter(object)
				.map(ecra -> ecra.getInverseReferences((EObject) object))
				.orElse(new ArrayList<>());
	}
	
	public static Collection<Setting> getAllReferring(Object object) {
		return ContextualExplorerUtils.getAllInverseReferences(object)
				.stream()
				.filter(s -> !ContextualExplorerUtils.isOppositeOfContainmentReference(s.getEStructuralFeature()))
				.collect(Collectors.toList());
	}
	
	private static boolean isOppositeOfContainmentReference(EStructuralFeature feature) {
		// Filter references which are opposite of containement
		if (feature instanceof EReference) {
			EReference eOpposite = ((EReference) feature).getEOpposite();
			if (eOpposite != null && eOpposite.isContainment()) {
				return true;	
			}
		}
		return false;
	}

}
