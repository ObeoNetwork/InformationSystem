/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.design.migration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.business.api.migration.AbstractMigrationParticipant;
import org.eclipse.sirius.business.api.resource.ResourceDescriptor;
import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.DView;
import org.eclipse.sirius.viewpoint.ViewpointFactory;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.obeonetwork.tools.migration.BasicMigrationHelper;
import org.osgi.framework.Version;

/**
 * Class used by Sirius migration process to convert old EClasses to new ones.
 * EProxies are also processed by this class to handle the renaming of the 'is.design' project.
 * 
 * @author Obeo
 */
public class ISMigrationParticipant extends AbstractMigrationParticipant {

	public static final String OLD_IS_DESIGN_PROJECT_NAME = "fr.gouv.mindef.safran.is.design";
	public static final String NEW_IS_DESIGN_PROJECT_NAME = "org.obeonetwork.is.design";
	
	private static Map<String, Map<String, EClassLocation>> eClassesMapping = null;
	private static Map<String, String> ePackagesMapping = null;
	
	@Override
	public Version getMigrationVersion() {
		// /!\ Warning: This version number is serialized on 'save' operation. /!\
		// This version number have to be increased when ISD metamodel change or when Sirius version change.
		// Version number format is 100.0.0 + ISD version (ex: 103.1.0 is related to 3.1.0 version)
		return new Version(105,0,0);
	}

	@Override
	public EPackage getPackage(String namespace, String loadedVersion) {
		String newNsURI = getEPackagesMapping().get(namespace);
		if (newNsURI != null) {
			EPackage newEPackage = getPackageFromRegistry(newNsURI);
			if (newEPackage != null) {
				return newEPackage;
			}
		}
		return super.getPackage(namespace, loadedVersion);
	}
	
	@Override
	public EClassifier getType(EPackage ePackage, String name, String loadedVersion) {
		String ePackageURI = ePackage.getNsURI();
		String newEPackageURI = null;
		String newEClassName = null;
		
		EClassLocation newEClass = getNewEClass(ePackageURI, name);
		if (newEClass != null) {
			newEPackageURI = newEClass.getEPackageNsURI();
			newEClassName = newEClass.getEClassName();
		} else {
			// Try to convert EPackage
			newEPackageURI = ePackageURI;
			newEClassName = name;
		}
		
		// Get Classifier from registry
		if (newEPackageURI != null && newEClassName != null) {
			EPackage newEPackage = getPackageFromRegistry(newEPackageURI);
			if (newEPackage != null) {
				EClassifier eClassifier = newEPackage.getEClassifier(newEClassName);
				if (eClassifier != null) {
					return eClassifier;
				}
			}
		}
		
		return super.getType(ePackage, name, loadedVersion);
	}
	
	private EClassLocation getNewEClass(String ePackageURI, String name) {
		Map<String, EClassLocation> mappingsForEPackage = getEClassesMapping().get(ePackageURI);
		if (mappingsForEPackage != null) {
			return mappingsForEPackage.get(name);
		}
		return null;
	}
	
	private EPackage getPackageFromRegistry(String nsURI) {
		return EPackage.Registry.INSTANCE.getEPackage(nsURI);
	}
	
	/**
	 * 
	 */
	private static void initMappings() {
		ePackagesMapping = new HashMap<String, String>();
		ePackagesMapping.put(BasicMigrationHelper.ENVIRONMENT_URI_OLD, BasicMigrationHelper.ENVIRONMENT_URI_NEW);
		ePackagesMapping.put(BasicMigrationHelper.ENTITY_URI_OLD, BasicMigrationHelper.ENTITY_URI_NEW);
		ePackagesMapping.put(BasicMigrationHelper.SOA_URI_OLD2, BasicMigrationHelper.SOA_URI_NEW);
		ePackagesMapping.put(BasicMigrationHelper.SOA_URI_OLD3, BasicMigrationHelper.SOA_URI_NEW);
		ePackagesMapping.put(BasicMigrationHelper.GRAAL_URI_OLD, BasicMigrationHelper.GRAAL_URI_NEW);
		
		eClassesMapping = new HashMap<String, Map<String,EClassLocation>>();
		
		Map<String, EClassLocation> ePackageMapppings = new HashMap<String, EClassLocation>();
		ePackageMapppings.put("Block", new EClassLocation(BasicMigrationHelper.ENVIRONMENT_URI_NEW, "Namespace"));
		ePackageMapppings.put("Property", new EClassLocation(BasicMigrationHelper.ENVIRONMENT_URI_NEW, "Property"));
		ePackageMapppings.put("Attribute", new EClassLocation(BasicMigrationHelper.ENVIRONMENT_URI_NEW, "Attribute"));
		ePackageMapppings.put("Reference", new EClassLocation(BasicMigrationHelper.ENVIRONMENT_URI_NEW, "Reference"));
		eClassesMapping.put(BasicMigrationHelper.ENTITY_URI_NEW, ePackageMapppings);
		
		ePackageMapppings = new HashMap<String, EClassLocation>();
		ePackageMapppings.put("Category", new EClassLocation(BasicMigrationHelper.ENVIRONMENT_URI_NEW, "Namespace"));
		ePackageMapppings.put("ServiceDTO", new EClassLocation(BasicMigrationHelper.ENVIRONMENT_URI_NEW, "DTO"));
		eClassesMapping.put(BasicMigrationHelper.SOA_URI_NEW, ePackageMapppings);
	}
	
	private static Map<String, String> getEPackagesMapping() {
		if (ePackagesMapping == null) {
			initMappings();
		}
		return ePackagesMapping;
	}

	private static Map<String, Map<String, EClassLocation>> getEClassesMapping() {
		if (eClassesMapping == null) {
			initMappings();
		}
		return eClassesMapping;
	}
	
	/**
	 * For each eProxy pointing to 'fr.gouv.mindef.safran.is.design' plugin (which was renamed), create a new eProxy pointing to 'org.obeonetwork.is.design' plugin.
	 */
	@Override
	public Object getValue(EObject object, EStructuralFeature feature,
			Object value, String loadedVersion) {
		
		if(value instanceof InternalEObject) {
			InternalEObject eObject = (InternalEObject) value;
			if(eObject.eIsProxy()) {
				URI proxyURI = eObject.eProxyURI();
				if(proxyURI.isPlatformPlugin() && proxyURI.segment(1).equals(OLD_IS_DESIGN_PROJECT_NAME)) {
					String newUriString = proxyURI.toString().replaceFirst(OLD_IS_DESIGN_PROJECT_NAME, NEW_IS_DESIGN_PROJECT_NAME);
					URI newUri = URI.createURI(newUriString);
					InternalEObject newValue = EcoreUtil.copy(eObject);
					newValue.eSetProxyURI(newUri);
					return newValue;
				}
			}
		}
		
		return super.getValue(object, feature, value, loadedVersion);
	}

	private static List<URI> DEFAULT_VIEWPOINT_URIS = Arrays.asList(URI.createURI("viewpoint:/org.obeonetwork.dsl.environment.properties/Environment Views"));
	
	@Override
	public void postLoad(XMLResource resource, String loadedVersion) {
		
		for(EObject root : resource.getContents()) {
			if(root instanceof DAnalysis) {
				DAnalysis analysis = (DAnalysis) root;
				// Ensure the default viewpoints are selected
				for(URI viewpointURI : DEFAULT_VIEWPOINT_URIS) {
					Viewpoint viewpoint = ViewpointRegistry.getInstance().getViewpoint(viewpointURI);
					DView view = analysis.getOwnedViews().stream().filter(v -> v.getViewpoint() == viewpoint).findFirst().orElse(null);
					if(view == null) {
						view = ViewpointFactory.eINSTANCE.createDView();
						view.setViewpoint(viewpoint);
						analysis.getOwnedViews().add(view);
					}
					if(!analysis.getSelectedViews().contains(view)) {
						analysis.getSelectedViews().add(view);
					}
				}
				
				// Remove any semantic resource whose URI starts with "http://www.obeonetwork"
				// These resources are supposed to be the metamodels and shouldn't be part of the references selected semantic resources. 
				List<ResourceDescriptor> resourceDescriptorsToRemove = new ArrayList<>();
				for(ResourceDescriptor resourceDescriptor : analysis.getSemanticResources()) {
					if(resourceDescriptor.getResourceURI().toString().startsWith("http://www.obeonetwork")) {
						resourceDescriptorsToRemove.add(resourceDescriptor);
					}
				}
				analysis.getSemanticResources().removeAll(resourceDescriptorsToRemove);
			}
		}
		
		super.postLoad(resource, loadedVersion);
	}
	
}
