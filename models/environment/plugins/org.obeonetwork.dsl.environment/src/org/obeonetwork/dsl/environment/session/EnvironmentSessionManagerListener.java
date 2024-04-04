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
 package org.obeonetwork.dsl.environment.session;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.resource.ResourceDescriptor;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionListener;
import org.eclipse.sirius.business.api.session.SessionManagerListener.Stub;
import org.eclipse.sirius.tools.api.command.semantic.AddSemanticResourceCommand;
import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.eclipse.sirius.viewpoint.description.DAnnotationEntry;
import org.eclipse.sirius.viewpoint.description.DescriptionFactory;
import org.obeonetwork.dsl.environment.util.ProvidedModelsService;
import org.obeonetwork.utils.common.SessionUtils;

public class EnvironmentSessionManagerListener extends Stub {
	
	public static final String FIRST_OPEN_FLAG = "FIRST_SESSION_OPENNING_PERFORMED";
	
	private static final String PROVIDED_ENVIRONMENT_MODEL_EXTENSION_URI_ATTRIBUTE = "uri";

	private static final String PROVIDED_ENVIRONMENT_MODEL_EXTENSION_PROPERTY_ATTRIBUTE = "priority";
	
	private static final String ENVIRONMENT_RESOURCE_EXTENSION = "environment";
	
	private Comparator<IConfigurationElement> configElementComparator = (c1, c2) -> {
		return getPriority(c2) - getPriority(c1);
	};
	
	private int getPriority(IConfigurationElement configElement) {
		int priority = 0;
		String attribute = configElement.getAttribute(PROVIDED_ENVIRONMENT_MODEL_EXTENSION_PROPERTY_ATTRIBUTE);
		if (attribute != null && !attribute.isEmpty()) {
			try {
				priority = Integer.parseInt(attribute);
			} catch (NumberFormatException e) {
				// Do nothing
			}
		}
		return priority;
	}

	public void notify(Session updated, int notification) {
		if (SessionListener.OPENED == notification) {
			SessionUtils sessionUtils = new SessionUtils();
			DAnalysis analysis = sessionUtils.getMainAnalysis(updated);
			if (isFirstOpen(analysis)) {
				if (!isEnvironmentResourceRegistered(analysis)) {
					addDefaultEnvironmentResourceToSemanticResource(updated);
				}
//				Uncomment the lines below if you what to include MetaDataDefinitions in session's resource set.
//				Collection<URI> alreadyPresentMetaDataDefUris = MetaDataDefinitionsResourceUtil
//						.getRegisteredMetaDataDefinitionsResources(analysis);
//				MetaDataDefinitionsResourceUtil.addProvidedMetaDataDefintionsResourceToSemanticResource(updated,
//						alreadyPresentMetaDataDefUris);
				setSessionFirstOpeningFlag(updated, analysis);
			}
		}
	}

	private boolean isEnvironmentResourceRegistered(DAnalysis analysis) {
		return analysis.getSemanticResources().stream()
				.map(ResourceDescriptor::getResourceURI)
				.map(URI::fileExtension)
				.filter(ext -> ENVIRONMENT_RESOURCE_EXTENSION.equals(ext))
				.findFirst()
				.isPresent();
	}

	private void addDefaultEnvironmentResourceToSemanticResource(Session session) {
		// Read Extension "org.obeonetwork.dsl.environment.providedEnvironmentModel"
		List<IConfigurationElement> configElements = ProvidedModelsService.getProvidedEnvironment();
		configElements.sort(configElementComparator);
		
		if (!configElements.isEmpty()) {
			Collections.sort(configElements, this.configElementComparator);
			int bestPriority = getPriority(configElements.get(0));
			TransactionalEditingDomain ted = session.getTransactionalEditingDomain();
			if (ted != null) {
				configElements.stream()
				.filter(c -> getPriority(c) == bestPriority) // Select extensions with highest priority
				.map(c -> c.getAttribute(PROVIDED_ENVIRONMENT_MODEL_EXTENSION_URI_ATTRIBUTE))
				.map(URI::createURI)
				// Add to semantic resources
				.map(uri -> new AddSemanticResourceCommand(session, uri, new NullProgressMonitor()))
				.forEach(command -> ted.getCommandStack().execute(command));
			}
		}
	}
	
	private void setSessionFirstOpeningFlag(Session session, DAnalysis analysis) {
		TransactionalEditingDomain ted = session.getTransactionalEditingDomain();
		if (ted != null) {
			DAnnotationEntry annotationEntry = DescriptionFactory.eINSTANCE.createDAnnotationEntry();
			annotationEntry.setSource(FIRST_OPEN_FLAG);
			ted.getCommandStack().execute(new AddCommand(ted, analysis, ViewpointPackage.Literals.DANALYSIS__EANNOTATIONS, annotationEntry));
		}
	}
	
	private boolean isFirstOpen(DAnalysis analysis) {
		return !analysis.getEAnnotations().stream()
				.map(DAnnotationEntry::getSource)
				.filter(source -> FIRST_OPEN_FLAG.equals(source))
				.findFirst()
				.isPresent();
	}
	
}
