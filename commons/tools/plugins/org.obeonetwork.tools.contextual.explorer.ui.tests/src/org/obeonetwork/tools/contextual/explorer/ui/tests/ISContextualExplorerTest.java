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
package org.obeonetwork.tools.contextual.explorer.ui.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.amalgam.explorer.contextual.core.query.IQuery;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.sirius.tests.support.api.SiriusTestCase;
import org.eclipse.sirius.tools.api.command.ICommandFactory;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.Schema;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.environment.MetaData;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Repository;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.graal.Node;
import org.obeonetwork.graal.System;
import org.obeonetwork.graal.Task;
import org.obeonetwork.graal.Transition;
import org.obeonetwork.graal.UserView;
import org.obeonetwork.tools.contextual.explorer.ui.queries.CategoriesContainerReferencesQuery;
import org.obeonetwork.tools.contextual.explorer.ui.queries.DocumentationLinkIsReferencedByQuery;
import org.obeonetwork.tools.contextual.explorer.ui.queries.EObjectIsReferencedByGenericQuery;
import org.obeonetwork.tools.contextual.explorer.ui.queries.EObjectIsReferencedByRequirementQuery;
import org.obeonetwork.tools.contextual.explorer.ui.queries.EObjectReferencesGenericQuery;
import org.obeonetwork.tools.contextual.explorer.ui.queries.EObjectReferencesMetadataQuery;
import org.obeonetwork.tools.contextual.explorer.ui.queries.MetadataIsReferencedByQuery;
import org.obeonetwork.tools.contextual.explorer.ui.queries.RequirementIsReferencedByQuery;
import org.obeonetwork.tools.contextual.explorer.ui.queries.RequirementReferencesOtherQuery;
import org.obeonetwork.tools.contextual.explorer.ui.queries.RequirementReferencesReferencedObjectQuery;

public class ISContextualExplorerTest extends SiriusTestCase {
	
	private static final String GRAAL_SEMANTIC_MODEL = "/" + Activator.PLUGIN_ID + "/" + "resources/contextualExplorer_test_graal.graal";
	
	private static final String REQUIREMENT_SEMANTIC_MODEL = "/" + Activator.PLUGIN_ID + "/" + "resources/contextualExplorer_test_requirement.requirement";
	
	private static final String DATABASE_SEMANTIC_MODEL = "/" + Activator.PLUGIN_ID + "/" + "resources/contextualExplorer_test_database.database";
	
	private static final String REPRESENTATION_FILE = "/" + Activator.PLUGIN_ID + "/" + "resources/representations.aird";
	
	private ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(Registry.INSTANCE);
	
	@Override
	protected void setUp() throws Exception {
		createModelingProject = true;
		super.setUp();
		List<String> semanticResources = new ArrayList<>();
		semanticResources.add(GRAAL_SEMANTIC_MODEL);
		semanticResources.add(REQUIREMENT_SEMANTIC_MODEL);
		semanticResources.add(DATABASE_SEMANTIC_MODEL);
		genericSetUp(semanticResources, Collections.emptyList(), REPRESENTATION_FILE);
	}
	
	private String getName(Object object) {
		IItemLabelProvider labelProvider = (IItemLabelProvider) composedAdapterFactory.adapt(object, IItemLabelProvider.class);
		if (labelProvider != null) {
			return labelProvider.getText(object);
		}
		return object.toString();
	}
	
	private List<String> getNames(List<Object> objects) {
		return objects.stream()
				.map(this::getName)
				.collect(Collectors.toList());
	}
	
	private void testQuery(IQuery query, Object selection, List<Object> expectedResult) {
		List<Object> queryResult = query.compute(selection);
		assertEquals("The query result does not match expected results, size are different.", expectedResult.size(), queryResult.size());
		for (Object object : queryResult) {
			assertTrue(String.format("%1$s is not contained in expected results %2$s.", getName(object), getNames(expectedResult)), expectedResult.contains(object));
		}
	}
	
	private EObject getRootElementOfResource(String uriString) {
		Optional<EObject> eObject = session.getSemanticResources().stream()
				.filter(resource -> uriString.equals(resource.getURI().toPlatformString(false)))
				.map(Resource::getContents)
				.filter(roots -> !roots.isEmpty())
				.map(roots -> roots.get(0))
				.findFirst();
		if (eObject.isPresent()) {
			return eObject.get();
		}
		fail(String.format("Unable to reach the first element of the resource %1$s", uriString));
		return null;
	}
	
	public void testObeoDSMObjectIsReferencedByGenericQuery() {
		IQuery query = new EObjectIsReferencedByGenericQuery();
		List<Object> expectedResult = new ArrayList<>();
		
		// Build expected result and get the context object
		System system = (System) getRootElementOfResource(GRAAL_SEMANTIC_MODEL);
		Task task = system.getOwnedTasks().get(0);
		Transition transition = task.getTransitions().get(0);
		expectedResult.add(transition);
		EList<Node> nodes = task.getNodes();
		UserView userView = (UserView) nodes.get(1);
		
		testQuery(query, userView, expectedResult);
	}
	
	public void testObeoDSMObjectReferencesGenericQuery() {
		IQuery query = new EObjectReferencesGenericQuery();
		List<Object> expectedResult = new ArrayList<>();
		
		// Build expected result and get the context object
		System system = (System) getRootElementOfResource(GRAAL_SEMANTIC_MODEL);
		Task task = system.getOwnedTasks().get(0);
		Transition transition = task.getTransitions().get(0);
		expectedResult.add(transition);
		EList<Node> nodes = task.getNodes();
		UserView userView = (UserView) nodes.get(1);
		
		testQuery(query, userView, expectedResult);
	}
	
	public void testObeoDSMObjectReferencesMetadataQuery() {
		IQuery query = new EObjectReferencesMetadataQuery();
		List<Object> expectedResult = new ArrayList<>();
		
		// Build expected result and get the context object
		System system = (System) getRootElementOfResource(GRAAL_SEMANTIC_MODEL);
		Task task = system.getOwnedTasks().get(0);
		expectedResult.addAll(task.getMetadatas().getMetadatas());
		
		testQuery(query, task, expectedResult);
	}
	
	public void testObeoDSMObjectIsReferencedByRequirementQuery() {
		IQuery query = new EObjectIsReferencedByRequirementQuery();
		List<Object> expectedResult = new ArrayList<>();
		
		// Build expected result and get the context object
		System system = (System) getRootElementOfResource(GRAAL_SEMANTIC_MODEL);
		Task task = system.getOwnedTasks().get(0);
		EList<Node> nodes = task.getNodes();
		UserView userView = (UserView) nodes.get(1);
		
		Repository repository = (Repository) getRootElementOfResource(REQUIREMENT_SEMANTIC_MODEL);
		Category mainCategory = repository.getMainCategories().get(0);
		expectedResult.add(mainCategory.getRequirements().get(0));
		expectedResult.add(mainCategory.getRequirements().get(2));
		
		testQuery(query, userView, expectedResult);
	}
	
	public void testDatabaseElementIsReferencedByGenericQuery() {
		IQuery query = new EObjectIsReferencedByGenericQuery();
		List<Object> expectedResult = new ArrayList<>();
		
		// Build expected result and get the context object
		DataBase database = (DataBase) getRootElementOfResource(DATABASE_SEMANTIC_MODEL);
		Schema schema = database.getSchemas().get(0);
		Table table = (Table) schema.getTables().get(0);
		expectedResult.add(table.getPrimaryKey());
		expectedResult.addAll(table.getColumns());
		
		testQuery(query, table, expectedResult);
	}
	
	public void testDatabaseElementReferencesGenericQuery() {
		IQuery query = new EObjectReferencesGenericQuery();
		List<Object> expectedResult = new ArrayList<>();
		
		// Build expected result and get the context object
		DataBase database = (DataBase) getRootElementOfResource(DATABASE_SEMANTIC_MODEL);
		Schema schema = database.getSchemas().get(0);
		expectedResult.add(schema);
		Table table = (Table) schema.getTables().get(0);
		expectedResult.add(table.getPrimaryKey());
		expectedResult.addAll(table.getColumns());
		
		testQuery(query, table, expectedResult);
	}
	
	public void testDatabaseElementIsReferencedByRequirement() {
		IQuery query = new EObjectIsReferencedByRequirementQuery();
		List<Object> expectedResult = new ArrayList<>();
		
		// Build expected result and get the context object
		DataBase database = (DataBase) getRootElementOfResource(DATABASE_SEMANTIC_MODEL);
		Schema schema = database.getSchemas().get(0);
		Table table = (Table) schema.getTables().get(0);
		
		Repository repository = (Repository) getRootElementOfResource(REQUIREMENT_SEMANTIC_MODEL);
		Category mainCategory = repository.getMainCategories().get(0);
		expectedResult.add(mainCategory.getRequirements().get(1));
		expectedResult.add(mainCategory.getRequirements().get(2));
		
		testQuery(query, table, expectedResult);
	}
	
	public void testRequirementReferencesGenericQuery() {
		IQuery query = new RequirementReferencesReferencedObjectQuery();
		
		Repository repository = (Repository) getRootElementOfResource(REQUIREMENT_SEMANTIC_MODEL);
		Category mainCategory = repository.getMainCategories().get(0);
		
		DataBase database = (DataBase) getRootElementOfResource(DATABASE_SEMANTIC_MODEL);
		Schema schema = database.getSchemas().get(0);
		Table table = (Table) schema.getTables().get(0);
		
		System system = (System) getRootElementOfResource(GRAAL_SEMANTIC_MODEL);
		Task task = system.getOwnedTasks().get(0);
		EList<Node> nodes = task.getNodes();
		UserView userView = (UserView) nodes.get(1);
		
		// Build expected result and get the context object R1
		List<Object> expectedResultR1 = new ArrayList<>();
		Requirement r1 = mainCategory.getRequirements().get(1);
		expectedResultR1.add(table);
		
		testQuery(query, r1, expectedResultR1);
		
		// Build expected result and get the context object R2
		List<Object> expectedResultR2 = new ArrayList<>();
		Requirement r2 = mainCategory.getRequirements().get(2);
		
		expectedResultR2.add(table);
		expectedResultR2.add(userView);
		
		testQuery(query, r2, expectedResultR2);
		
		// Build expected result and get the context object R3
		List<Object> expectedResultR3 = new ArrayList<>();
		Requirement r3 = mainCategory.getRequirements().get(0);
		
		expectedResultR3.add(userView);
		
		testQuery(query, r3, expectedResultR3);
	}
	
	public void testRequirementReferencesGenericQueryWorksOnlyWithRequirement() {
		IQuery query = new RequirementReferencesReferencedObjectQuery();
		
		Repository repository = (Repository) getRootElementOfResource(REQUIREMENT_SEMANTIC_MODEL);
		Category mainCategory = repository.getMainCategories().get(0);
		testQuery(query, mainCategory, Collections.emptyList());
		
		DataBase database = (DataBase) getRootElementOfResource(DATABASE_SEMANTIC_MODEL);
		Schema schema = database.getSchemas().get(0);
		testQuery(query, schema, Collections.emptyList());
		
		System system = (System) getRootElementOfResource(GRAAL_SEMANTIC_MODEL);
		Task task = system.getOwnedTasks().get(0);
		testQuery(query, task, Collections.emptyList());
	}
	
	public void testRequirementIsReferencedByQuery() {
		IQuery query = new RequirementIsReferencedByQuery();
		
		Repository repository = (Repository) getRootElementOfResource(REQUIREMENT_SEMANTIC_MODEL);
		Category mainCategory = repository.getMainCategories().get(0);
		Requirement requirement = mainCategory.getRequirements().get(0);
		testQuery(query, requirement, Collections.emptyList());
		
		List<Object> expectedResult = new ArrayList<>();
		expectedResult.addAll(mainCategory.getRequirements());
		testQuery(query, mainCategory, expectedResult);
	}
	
	public void testRequirementReferencesOtherQuery() {
		IQuery query = new RequirementReferencesOtherQuery();
		
		Repository repository = (Repository) getRootElementOfResource(REQUIREMENT_SEMANTIC_MODEL);
		Category mainCategory = repository.getMainCategories().get(0);
		Requirement r1 = mainCategory.getRequirements().get(1);
		
		testQuery(query, r1, Collections.singletonList(mainCategory));
	}
	
	public void testCategoriesContainerReferencesQuery() {
		IQuery query = new CategoriesContainerReferencesQuery();
		List<Object> expectedResult = new ArrayList<>();
		
		Repository repository = (Repository) getRootElementOfResource(REQUIREMENT_SEMANTIC_MODEL);
		Category mainCategory = repository.getMainCategories().get(0);
		
		expectedResult.add(repository);
		expectedResult.addAll(mainCategory.getRequirements());
		
		testQuery(query, mainCategory, expectedResult);
	}
	
	public void testDocumentationLinkIsReferencedByQuery() {
		IQuery query = new DocumentationLinkIsReferencedByQuery();
		List<Object> expectedResult = new ArrayList<>();
		
		System system = (System) getRootElementOfResource(GRAAL_SEMANTIC_MODEL);
		Task task = system.getOwnedTasks().get(0);
		expectedResult.add(task);
		MetaData metaDataDocumentation = task.getMetadatas().getMetadatas().get(0);
		testQuery(query, metaDataDocumentation, expectedResult);
		
		// If the metadata is a documentation, the metadataIsReferencedByQuery should return an empty list
		IQuery query2 = new MetadataIsReferencedByQuery();
		testQuery(query2, metaDataDocumentation, Collections.emptyList());
	}
	
	public void testMetadataIsReferencedByQuery() {
		IQuery query = new MetadataIsReferencedByQuery();
		List<Object> expectedResult = new ArrayList<>();
		
		System system = (System) getRootElementOfResource(GRAAL_SEMANTIC_MODEL);
		Task task = system.getOwnedTasks().get(0);
		expectedResult.add(task);
		MetaData metaData = task.getMetadatas().getMetadatas().get(1);
		testQuery(query, metaData, expectedResult);
		
		// If the metadata is not a documentation, the DocumentationLinkIsReferencedByQuery should return an empty list
		IQuery query2 = new DocumentationLinkIsReferencedByQuery();
		testQuery(query2, metaData, Collections.emptyList());
	}
	
	@Override
	protected ICommandFactory getCommandFactory() {
		return null;
	}

}
