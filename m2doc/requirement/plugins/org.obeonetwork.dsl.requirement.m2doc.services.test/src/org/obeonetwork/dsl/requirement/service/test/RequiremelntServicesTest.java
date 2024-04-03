/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.requirement.service.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.junit.Test;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Repository;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.dsl.requirement.RequirementPackage;
import org.obeonetwork.requirement.m2doc.services.RequirementServices;

/**
 * Test of the requirement reverse service.
 * 
 * @author Obeo
 *
 */
public class RequiremelntServicesTest {

	private final RequirementServices rs = new RequirementServices();
	
	@Test
	public void relatedRequirements() {
		Repository repo = (Repository) EcoreUtil.create(RequirementPackage.Literals.REPOSITORY);
		Category cat = (Category) EcoreUtil.create(RequirementPackage.Literals.CATEGORY);
		repo.getMainCategories().add(cat);
		Requirement req1 = (Requirement) EcoreUtil.create(RequirementPackage.Literals.REQUIREMENT);
		Requirement req2 = (Requirement) EcoreUtil.create(RequirementPackage.Literals.REQUIREMENT);
		Requirement req3 = (Requirement) EcoreUtil.create(RequirementPackage.Literals.REQUIREMENT);
		cat.getRequirements().add(req1);
		cat.getRequirements().add(req2);
		cat.getRequirements().add(req3);
		Repository repo2 = (Repository) EcoreUtil.create(RequirementPackage.Literals.REPOSITORY);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = new XMLResourceImpl();
		resourceSet.getResources().add(resource);
		resource.getContents().add(repo);
		resource.getContents().add(repo2);
		req1.getReferencedObject().add(repo2);
		req2.getReferencedObject().add(repo2);
		req3.getReferencedObject().add(repo2);
		
		List<Requirement> reqs = rs.relatedRequirements(repo2);
		
		assertTrue(reqs.contains(req1));
		assertTrue(reqs.contains(req2));
		assertTrue(reqs.contains(req3));
	}
	
	@Test
	public void hasRelatedRequirements() {
		Repository repo = (Repository) EcoreUtil.create(RequirementPackage.Literals.REPOSITORY);
		Category cat = (Category) EcoreUtil.create(RequirementPackage.Literals.CATEGORY);
		repo.getMainCategories().add(cat);
		Requirement req1 = (Requirement) EcoreUtil.create(RequirementPackage.Literals.REQUIREMENT);
		Requirement req2 = (Requirement) EcoreUtil.create(RequirementPackage.Literals.REQUIREMENT);
		Requirement req3 = (Requirement) EcoreUtil.create(RequirementPackage.Literals.REQUIREMENT);
		cat.getRequirements().add(req1);
		cat.getRequirements().add(req2);
		cat.getRequirements().add(req3);
		Repository repo2 = (Repository) EcoreUtil.create(RequirementPackage.Literals.REPOSITORY);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = new XMLResourceImpl();
		resourceSet.getResources().add(resource);
		resource.getContents().add(repo);
		resource.getContents().add(repo2);
		req1.getReferencedObject().add(repo2);
		req2.getReferencedObject().add(repo2);
		req3.getReferencedObject().add(repo2);

		assertTrue(rs.hasRelatedRequirements(repo2));
	}

}
