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
package org.obeonetwork.dsl.environment.properties.internal.services;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.eclipse.sirius.tools.api.SiriusPlugin;
import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.MetaData;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinition;
import org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinitions;
import org.obeonetwork.dsl.environment.metadatadef.util.ProvidedMetaDataDefinitionsModelsService;
import org.obeonetwork.dsl.environment.properties.providers.IMetaDataHelpProvider;
import org.obeonetwork.utils.common.SiriusInterpreterUtils;

/**
 * Services for environment models
 * 
 * @author Obeo
 */
public class EnvironmentServices {

	static final List<IMetaDataHelpProvider> METADATA_HELP_PROVIDERS = new ArrayList<>();

	static {
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor("org.obeonetwork.dsl.environment.properties.metadataHelpProvider");
		Arrays.asList(config).forEach(configurationElement -> {
			try {
				final Object object = configurationElement.createExecutableExtension("class");
				if (object instanceof IMetaDataHelpProvider) {
					METADATA_HELP_PROVIDERS.add((IMetaDataHelpProvider) object);
				}
			} catch (CoreException | ClassCastException e) {
				e.printStackTrace();
			}
		});
	}

	public MetaDataContainer getMetadataContainer(EObject self) {
		MetaDataContainer metadatas = null;
		if (self instanceof ObeoDSMObject) {
			metadatas = ((ObeoDSMObject) self).getMetadatas();
			if (metadatas == null) {
				metadatas = EnvironmentFactory.eINSTANCE.createMetaDataContainer();
				((ObeoDSMObject) self).setMetadatas(metadatas);
			}
		}
		return metadatas;
	}

	/**
	 * Return a help label to display in the metadata tooltip, as provided by a
	 * {@link MetaDataExtension}
	 * 
	 * @param self an {@link ObeoDSMObject}
	 * @return a {@link String} to be displayed as a tooltip, in the 'metadatas'
	 *         view property.
	 */
	public String getMetadatasHelpExpression(ObeoDSMObject self) {
		return METADATA_HELP_PROVIDERS.stream().map(provider -> provider.getHelpMessage(self))
				.filter(s -> s != null && !s.isEmpty()).findAny().orElse(null);
	}

	/**
	 * 
	 * @param elt
	 * @return a list of a {@link Annotation} that may be apply to self.
	 */
	public List<Annotation> getApplicableMetadataList(ObeoDSMObject self) {
		return getCandidateMetadataDefinitionList(self).stream()//
				.map(mdd -> convertToMetadata(mdd))//
				.filter(Annotation.class::isInstance).map(Annotation.class::cast)//
				.collect(toList());
	}
	
	/**
	 * Sets the new {@link MetaData} list of self given selectedElements.
	 * @param self
	 * @param selectedElements
	 * @return
	 */
	public ObeoDSMObject setMetadata(ObeoDSMObject self, List<MetaData> selectedElements) {
		MetaDataContainer metadataContainer = getMetadataContainer(self);
		boolean selectedEltsEmptyOrNull = selectedElements == null || selectedElements.isEmpty();
		List<MetaData> currentMetadata = metadataContainer.getMetadatas();
		if (currentMetadata.equals(selectedElements) || (currentMetadata.isEmpty() && selectedEltsEmptyOrNull)) {
			return self;
		}
		if (selectedEltsEmptyOrNull) {
			metadataContainer.getMetadatas().clear();
			return self;
		}
		metadataContainer.getMetadatas().clear();
		metadataContainer.getMetadatas().addAll(selectedElements);
		return self;
	}
	
	/**
	 * 
	 * @param self
	 * @return the list of {@link MetaDataDefinition} that may apply to self.
	 */
	private List<MetaDataDefinition> getCandidateMetadataDefinitionList(ObeoDSMObject self) {
		if (self == null) {
			return Collections.emptyList();
		}
		List<MetaDataDefinition> applicableMetaDataDefs = getApplicableMetadataDefintionList(self);
		return applicableMetaDataDefs.stream().filter(mdd -> !isMetaDataDefinitionApplied(self, mdd))
				.collect(Collectors.toList());
	}

	private MetaData convertToMetadata(EObject elt) {
		if (elt instanceof MetaData) {
			return (MetaData) elt;
		} else if (elt instanceof MetaDataDefinition) {
			MetaDataDefinition metadataDef = (MetaDataDefinition) elt;
			Annotation metadata = EnvironmentFactory.eINSTANCE.createAnnotation();
			metadata.setTitle(metadataDef.getTitle());
			metadata.setBody(metadataDef.getBody());
			return metadata;
		}
		return null;
	}

	private List<MetaDataDefinition> getApplicableMetadataDefintionList(EObject elt) {
		List<MetaDataDefinition> definitions = new ArrayList<>(); 
		definitions.addAll(ProvidedMetaDataDefinitionsModelsService.getProvidedMetaDataDefinitionsModels().stream()//
				.map(MetaDataDefinitions::getMetaDataDefinitions).flatMap(List::stream)//
				.collect(Collectors.toList()));
		definitions.addAll(getProjectMetaDataDefinitions(elt));
		return definitions.stream()//
				.filter(mdd -> isMetaDataDefinitionApplicable(elt, mdd))//
				.collect(Collectors.toList());
	}

	private List<MetaDataDefinition> getProjectMetaDataDefinitions(EObject elt) {
		return elt.eResource().getResourceSet().getResources().stream()//
			.flatMap(r -> r.getContents().stream())//
			.filter(MetaDataDefinitions.class::isInstance).map(MetaDataDefinitions.class::cast)//
			.flatMap(mdds -> mdds.getMetaDataDefinitions().stream())//
			.collect(toList());
	}

	private boolean isMetaDataDefinitionApplicable(EObject eObj, MetaDataDefinition metaDataDefinition) {
		IInterpreter interpreter = SiriusPlugin.getDefault().getInterpreterRegistry().getInterpreter(eObj);
		String aqlExpression = metaDataDefinition.getCondition();
		if (aqlExpression == null || aqlExpression.isBlank()) {
			return true;
		}
		String aqlPrefix = "aql:";
		if (!aqlExpression.startsWith(aqlPrefix)) {
			aqlExpression = aqlPrefix + aqlExpression;
		}
		boolean isApplicable = false;
		isApplicable = SiriusInterpreterUtils.evaluateToBoolean(interpreter, eObj, aqlExpression, false);
		return isApplicable;
	}

	private boolean isMetaDataDefinitionApplied(EObject eObj, MetaDataDefinition metaDataDefinition) {
		if (eObj instanceof ObeoDSMObject) {
			ObeoDSMObject dsmObj = (ObeoDSMObject) eObj;
			if (dsmObj.getMetadatas() != null) {
				return dsmObj.getMetadatas().getMetadatas().stream().filter(Annotation.class::isInstance)
						.map(Annotation.class::cast).anyMatch(an -> areEquivalent(metaDataDefinition, an));
			}
		}
		return false;
	}

	private boolean areEquivalent(MetaDataDefinition metaDataDefinition, Annotation annotation) {
		return metaDataDefinition != null && annotation != null
				&& bothEqualIgnoreCaseOrNull(metaDataDefinition.getTitle(), annotation.getTitle());
	}

	private static boolean bothEqualIgnoreCaseOrNull(String s1, String s2) {
		return s1 == null ? s2 == null : s1.equalsIgnoreCase(s2);
	}
}
