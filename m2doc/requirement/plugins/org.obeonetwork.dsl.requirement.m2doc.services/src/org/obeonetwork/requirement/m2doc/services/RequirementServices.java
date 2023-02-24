/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.requirement.m2doc.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.acceleo.annotations.api.documentation.Documentation;
import org.eclipse.acceleo.annotations.api.documentation.Example;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.dsl.requirement.RequirementPackage;

/**
 * AQL Services for Requirement's concepts.
 * 
 * @author Romain Guider
 *
 */
public class RequirementServices {
	/**
	 * Returns the list of {@link Requirement} that reference the specified
	 * eObject. For the service to work, eObject must be present in a
	 * 
	 * @param eObject
	 * @return the list of {@link Requirement} instances that reference the
	 *         specified eObject.
	 */
	// @formatter:off
	@Documentation(
			comment = "{m:obj.relatedRequirements()}",
		    value = "Returns the set of Requirement that are related to the target object.",
		    examples = {
		    		@Example(expression = "{m:obj.relatedRequirements()->sep(',')}", result = "A comma separated list of related requirements.")
		    }

		)
	// @formatter:on	
	public List<Requirement> relatedRequirements(EObject eObject) {
		List<Requirement> result = new ArrayList<Requirement>();
		
		Collection<Setting> settings = getInverseReferences(eObject);
		for (Setting setting : settings) {
			if (RequirementPackage.Literals.REQUIREMENT__REFERENCED_OBJECT.equals(setting.getEStructuralFeature())) {							
				result.add(((Requirement) setting.getEObject()));
			}
		}
		
		return result;
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:obj.hasRelatedRequirements()}",
		    value = "Returns true if the given Object as at least one related Requirement.",
		    examples = {
		    		@Example(expression = "{m:obj.hasRelatedRequirements()}", result = "true or false.")
		    }

		)
	// @formatter:on	
	public boolean hasRelatedRequirements(EObject eObject) {
		return !relatedRequirements(eObject).isEmpty();
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:obj.allRelatedRequirements()}",
		    value = "Returns a list of all the Requirements related to "
		    		+ "the target object or one of its sub objects. The result "
		    		+ "is a list with no duplicates sorted against the requirements ids.",
		    examples = {
		    		@Example(expression = "{m:obj.allRelatedRequirements()->sep(',')}", result = "A comma separated list of related requirements.")
		    }

		)
	// @formatter:on	
	public List<Requirement> allRelatedRequirements(EObject eObject) {
		Set<Requirement> allRelatedRequirements = new HashSet<Requirement>();
		
		allRelatedRequirements.addAll(relatedRequirements(eObject));
		Iterator<EObject> i = eObject.eAllContents();
		while(i.hasNext()) {
			EObject o = i.next();
			allRelatedRequirements.addAll(relatedRequirements(o));
		}
		
		List<Requirement> sortedResult = new ArrayList<Requirement>();
		sortedResult.addAll(allRelatedRequirements);
		sortedResult.sort(new Comparator<Requirement>() {
			@Override
			public int compare(Requirement a, Requirement b) {
				return a.getId().compareTo(b.getId());
			}
		});
		
		return sortedResult;
	}
	
	/**
	 * Returns inverse reference for an eObject using Sirius cross referencer if available
	 * @param eObject
	 * @return Collection of settings for inverse references
	 */
	private Collection<Setting> getInverseReferences(EObject eObject) {
		Session session = new EObjectQuery(eObject).getSession();
		if (session != null) {
			ECrossReferenceAdapter xReferencer = session.getSemanticCrossReferencer();
			if (xReferencer != null) {
				return xReferencer.getInverseReferences(eObject);
			}
		}
		Resource resource = eObject.eResource();
		if (resource != null) {
			ResourceSet resourceSet = resource.getResourceSet();
			if (resourceSet != null) {
				return EcoreUtil.UsageCrossReferencer.find(eObject, resourceSet);
			}
		}
		return Collections.emptyList();
	}
	
	/**
	 * Returns the list of {@link Requirement} that reference the specified
	 * eObject and which have the specified subtype.
	 * 
	 * @param eObject
	 * @param subtype Subtype that requirements should have. Could be null.
	 * @return the list of {@link Requirement} instances that reference the
	 *         specified eObject.
	 */
	// @formatter:off
	@Documentation(
			comment = "{m:obj.relatedRequirementsWithSubtype('SUBTYPE')}",
		    value = "Returns the list of Requirements that reference the target object and that have the specified subtype.",
		    examples = {
		    		@Example(expression = "{m:obj.relatedRequirementsWithSubtype('performance')->sep(',')}", result = "A comma separated list of related requirements of performance subtype.")
		    }

		)
		// @formatter:on	
	public List<Requirement> relatedRequirementsWithSubtype(EObject eObject, String subtype) {
		List<Requirement> result = new ArrayList<>();
		
		List<Requirement> requirements = relatedRequirements(eObject);
		for (Requirement requirement : requirements) {
			if (isNullOrEmpty(subtype)) {
				if (isNullOrEmpty(requirement.getSubtype())) {
					result.add(requirement);
				}
			} else if (subtype.equals(requirement.getSubtype())) {
				result.add(requirement);
			}
		}
		
		return result;
	}
	
	private boolean isNullOrEmpty(String text) {
		return text == null || text.trim().isEmpty();
	}

}
