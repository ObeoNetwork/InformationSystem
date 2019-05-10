/*******************************************************************************
 * Copyright (c) 2019 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.design.tests;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.sirius.tests.support.api.SiriusTestCase;
import org.eclipse.sirius.tools.api.command.ICommandFactory;
import org.eclipse.sirius.tools.api.command.semantic.RemoveSemanticResourceCommand;
import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.description.DAnnotationEntry;
import org.junit.Test;
import org.obeonetwork.dsl.environment.session.EnvironmentSessionManagerListener;
import org.obeonetwork.utils.sirius.session.SessionUtils;

public class EnvironmentResourceManagementTest extends SiriusTestCase {
	
	private static final String SESSION_DEPENDENCIES_CONTAINS_NULL_VALUE_ERROR_MESSAGE = "The list of session dependencies must not contains null";
	private static final String EMPTY_EXPECTED_SESSION_DEPENDENCIES_ERROR_MESSAGE = "As the session is closed, session dependencies should be empty.";
	private static final String SESSION_FLAG_STATUS_NOT_EXPECTED_ERROR_MESSAGE = "It seems the presence of the FIRST_SESSION_OPENNING_PERFORMED flag is not the expected one";
	private static final String RESOURCE_NOT_IN_SEMANTIC_RESOURCE_ERROR_MESSAGE = "The resource %1$s is not present in semantic resource but should be.";
	private static final String HIGHEST_PRIORITY_ENVIRONMENT_RESOURCE_NOT_IN_RESOURCESET_ERROR_MESSAGE = "The highest priority environment resource (%1$s) should be in the resourceSet";
	private static final String HIGHEST_PRIORITY_ENVIRONMENT_RESOURCE_PRESENT_IN_THE_RESOURCE_SET_ERROR_MESSAGE = "The highest priority environment resource (%1$s) should not be in the resourceSet";
	
	private static final String HIGHEST_PRIORITY_ENVIRONMENT_RESOURCE_NAME = "TestEnvironment.environment";
	private static final String HIGHEST_PRIORITY_ENVIRONMENT_RESOURCE_URI_STRING = "platform:plugin/org.obeonetwork.dsl.environment.design.tests/resources/environmentResourceContribution/" + HIGHEST_PRIORITY_ENVIRONMENT_RESOURCE_NAME;
	private static final URI HIGHEST_PRIORITY_ENVIRONMENT_RESOURCE_URI = URI.createURI(HIGHEST_PRIORITY_ENVIRONMENT_RESOURCE_URI_STRING);
	private SessionUtils sessionUtils = new SessionUtils();
	private DAnalysis mainAnalysis;
	private static final List<Resource> NO_DEPENDENCIES = Collections.emptyList();
	
	@Override
	protected void setUp() throws Exception {
		createModelingProject = true;
		super.setUp();
		genericSetUp();
		
		mainAnalysis = sessionUtils.getMainAnalysis(session);
		checkFlag(true);
	}
	
	@Override
	public void tearDown() throws Exception {
		mainAnalysis = null;
		super.tearDown();
	}
	
	private void checkFlag(boolean flagShouldBePresent) {
		boolean isFlagPresent = mainAnalysis.getEAnnotations().stream()
				.map(DAnnotationEntry::getSource)
				.filter(source -> EnvironmentSessionManagerListener.FIRST_OPEN_FLAG.equals(source))
				.findFirst()
				.isPresent();
		assertEquals(SESSION_FLAG_STATUS_NOT_EXPECTED_ERROR_MESSAGE, flagShouldBePresent, isFlagPresent);
	}
	
	private void checkDependencies(List<Resource> dependencies) {
		for (Resource resource : dependencies) {
			if (resource == null) {
				fail(SESSION_DEPENDENCIES_CONTAINS_NULL_VALUE_ERROR_MESSAGE);
			}
		}
		
		if (NO_DEPENDENCIES.equals(dependencies)) {
			assertEquals(EMPTY_EXPECTED_SESSION_DEPENDENCIES_ERROR_MESSAGE, session.getSemanticResources().size(), 0);
		} else {
			for (Resource resource : dependencies) {
				assertTrue(String.format(RESOURCE_NOT_IN_SEMANTIC_RESOURCE_ERROR_MESSAGE
						, resource.getURI().lastSegment()) , session.getSemanticResources().contains(resource));
			}
		}
	}
	
	private Resource getHighestPriorityEnvironmentResource() {
		ResourceSet resourceSet = session.getSessionResource().getResourceSet();
		Resource highestPriorityEnvironmentResource = resourceSet.getResource(HIGHEST_PRIORITY_ENVIRONMENT_RESOURCE_URI, false);
		return highestPriorityEnvironmentResource;
	}
	
	@Test
	public void testProvidedEnvironmentInProjectDependencies() {
		// Check env with highest priority is present in project dependencies
		Resource highestPriorityEnvironmentResource = getHighestPriorityEnvironmentResource();
		assertNotNull(String.format(HIGHEST_PRIORITY_ENVIRONMENT_RESOURCE_NOT_IN_RESOURCESET_ERROR_MESSAGE, HIGHEST_PRIORITY_ENVIRONMENT_RESOURCE_NAME), highestPriorityEnvironmentResource);
		checkDependencies(Collections.singletonList(highestPriorityEnvironmentResource));
	}
	
	@Test
	public void testReopenProjectDoesNotAddEnvResourceAgain() throws Exception {
		// Check env with highest priority is present in project dependencies
		Resource highestPriorityEnvironmentResource = getHighestPriorityEnvironmentResource();
		assertNotNull(String.format(HIGHEST_PRIORITY_ENVIRONMENT_RESOURCE_NOT_IN_RESOURCESET_ERROR_MESSAGE, HIGHEST_PRIORITY_ENVIRONMENT_RESOURCE_NAME), highestPriorityEnvironmentResource);
		checkDependencies(Collections.singletonList(highestPriorityEnvironmentResource));
		
		// Remove environment resource from project dependencies
		executeCommand(new RemoveSemanticResourceCommand(session, highestPriorityEnvironmentResource, defaultProgress, false));
		session.save(defaultProgress); //Mandatory otherwise the save job may be executed after the session has been closed => leading to NPE.
		
		Resource highestPriorityEnvironmentResourceAfterRemove = getHighestPriorityEnvironmentResource();
		assertNull(String.format(HIGHEST_PRIORITY_ENVIRONMENT_RESOURCE_PRESENT_IN_THE_RESOURCE_SET_ERROR_MESSAGE, HIGHEST_PRIORITY_ENVIRONMENT_RESOURCE_NAME), highestPriorityEnvironmentResourceAfterRemove);
		checkDependencies(NO_DEPENDENCIES);
		
		// Restart session
		closeAndReloadSession();
		assertTrue("The session should be opened", session.isOpen());
		checkFlag(true);
		
		// Check no environment resource has been added after the session opened
		Resource highestPriorityEnvironmentResourceAfterReopening = getHighestPriorityEnvironmentResource();
		assertNull(String.format(HIGHEST_PRIORITY_ENVIRONMENT_RESOURCE_PRESENT_IN_THE_RESOURCE_SET_ERROR_MESSAGE, HIGHEST_PRIORITY_ENVIRONMENT_RESOURCE_NAME), highestPriorityEnvironmentResourceAfterReopening);
		checkDependencies(NO_DEPENDENCIES);
	}

	@Override
	protected ICommandFactory getCommandFactory() {
		return null;
	}
	
}
