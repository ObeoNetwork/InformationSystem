/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.design.tests;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.sirius.tests.support.api.SiriusTestCase;
import org.eclipse.sirius.tools.api.command.ICommandFactory;
import org.junit.Test;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.entity.EntityFactory;
import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.MetaData;
import org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinition;
import org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinitions;
import org.obeonetwork.dsl.environment.metadatadef.util.ProvidedMetaDataDefinitionsModelsService;
import org.obeonetwork.dsl.environment.properties.internal.services.EnvironmentServices;

public class MetadataDefinitionsManagementTest extends SiriusTestCase {

	private static final String MISSING_APPLICABLE_ANNOTATIONS_FOR_ENTITY_ELEMENT = "Missing applicable Annotations for Entity element";
	private static final String MISSING_META_DATA_DEFINITIONS_CONTRIBUTION_FROM_URI = "Missing MetaDataDefinitions contribution from URI: ";
	private static final String MISSING_CONTRIBUTION_OF_EXTENSION_FOR_METADADEF = "Missing single contribution of extension for metadadef";
	private static final String METADATADEF_RESOURCE_URI_STRING = "platform:/plugin/org.obeonetwork.dsl.environment.design.tests/resources/metadatadefResourceContribution/sample.metadatadef";
	private static final String FIRST_METADATA_DEF_TITLE_IN_RESOURCE = "Modeling studio";
	private static final String FIRST_METADATA_DEF_BODY_IN_RESOURCE = "This element comes from an ISD modeling workbench";
	private static final String FIRST_METADATA_DEF_CONDITION_IN_RESOURCE = "aql:true";

	private static final String METADATA_DEF_TITLE_APPLICABLE_TO_ENITY = "Business Need layer";

	EnvironmentServices environmentService = new EnvironmentServices();

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		genericSetUp();
	}

	@Override
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testLoadingMetadatadefResourceContribution() {
		List<IConfigurationElement> contribution = ProvidedMetaDataDefinitionsModelsService
				.getProvidedMetaDataDefinitions();
		assertNotNull(MISSING_CONTRIBUTION_OF_EXTENSION_FOR_METADADEF, contribution);
		assertEquals(1, contribution.size());
		assertEquals(METADATADEF_RESOURCE_URI_STRING, contribution.get(0).getAttribute("uri"));

		Collection<MetaDataDefinitions> metadatadefs = ProvidedMetaDataDefinitionsModelsService
				.getProvidedMetaDataDefinitionsModels();
		assertNotNull(MISSING_META_DATA_DEFINITIONS_CONTRIBUTION_FROM_URI + METADATADEF_RESOURCE_URI_STRING,
				metadatadefs);
		assertEquals(1, metadatadefs.size());

		MetaDataDefinitions defs = (MetaDataDefinitions) metadatadefs.toArray()[0];
		assertEquals(3, defs.getMetaDataDefinitions().size());

		MetaDataDefinition firstMetaDefinition = defs.getMetaDataDefinitions().get(0);
		assertEquals(FIRST_METADATA_DEF_TITLE_IN_RESOURCE, firstMetaDefinition.getTitle());
		assertEquals(FIRST_METADATA_DEF_BODY_IN_RESOURCE, firstMetaDefinition.getBody());
		assertEquals(FIRST_METADATA_DEF_CONDITION_IN_RESOURCE, firstMetaDefinition.getCondition());
	}

	@Test
	public void testGetApplicableMetadataListAndSetMetadata() {
		Entity entity = EntityFactory.eINSTANCE.createEntity();
		writeTransaction(() -> ((Resource) session.getSemanticResources().toArray()[0]).getContents().add(entity));
		List<Annotation> annotations = environmentService.getApplicableMetadataList(entity);
		assertNotNull(MISSING_APPLICABLE_ANNOTATIONS_FOR_ENTITY_ELEMENT, annotations);
		// The aql conditions of 2 (among 3) MetadataDefinitions must return true when
		// evaluated on entity.
		assertEquals(2, annotations.size());

		List<String> metadataTitles = List.of(FIRST_METADATA_DEF_TITLE_IN_RESOURCE,
				METADATA_DEF_TITLE_APPLICABLE_TO_ENITY);
		assertTrue(annotations.stream().allMatch(an -> metadataTitles.contains(an.getTitle())));

		Annotation firstAnnotation = annotations.stream()
				.filter(an -> an.getTitle().equals(FIRST_METADATA_DEF_TITLE_IN_RESOURCE)).findFirst().orElse(null);
		writeTransaction(() -> environmentService.setMetadata(entity, List.of(firstAnnotation)));

		assertNotNull(entity.getMetadatas());
		List<MetaData> metadata = entity.getMetadatas().getMetadatas();
		// Check setMetadata works
		assertEquals(1, metadata.size());
		assertEquals(firstAnnotation, metadata.get(0));

		annotations = environmentService.getApplicableMetadataList(entity);
		assertNotNull(annotations);
		// Only one (among 2) MetadataDefinition can be applied to entity, since the
		// other
		// is already present on entity.
		assertEquals(1, annotations.size());
		assertEquals(METADATA_DEF_TITLE_APPLICABLE_TO_ENITY, annotations.get(0).getTitle());

		List<MetaData> newSelecteElts = List.of(firstAnnotation, annotations.get(0));
		writeTransaction(() -> environmentService.setMetadata(entity, newSelecteElts));
		metadata = entity.getMetadatas().getMetadatas();
		// Check setMetadata works
		assertEquals(2, metadata.size());
		assertTrue(metadata.containsAll(newSelecteElts));

		// What matters is the title, changing the body doesn't make the metadata
		// applicable again.
		Annotation entityAnnotation0 = (Annotation) metadata.get(0);
		writeTransaction(() -> entityAnnotation0.setBody(""));

		annotations = environmentService.getApplicableMetadataList(entity);
		assertNotNull(annotations);
		// No MetadataDefinition can be applied to entity.
		assertEquals(0, annotations.size());

		// Changing the title makes the metadata definition with former title
		// applicable again.
		writeTransaction(() -> entityAnnotation0.setTitle("NewTitle"));
		annotations = environmentService.getApplicableMetadataList(entity);
		assertNotNull(annotations);
		assertEquals(1, annotations.size());
	}

	private void writeTransaction(Runnable runnable) {
		RecordingCommand command = new RecordingCommand(session.getTransactionalEditingDomain()) {
			@Override
			protected void doExecute() {
				runnable.run();
			}
		};
		executeCommand(command);
	}

	@Override
	protected ICommandFactory getCommandFactory() {
		return null;
	}

}
