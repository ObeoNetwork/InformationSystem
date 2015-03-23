/**
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *
 * $Id$
 */
package org.obeonetwork.dsl.environment.design.migration;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.sirius.business.api.migration.AbstractMigrationParticipant;
import org.obeonetwork.tools.migration.BasicMigrationHelper;
import org.osgi.framework.Version;

/**
 * Class used by Sirius migration process to convert old EClasses to new ones
 * 
 * @author Stéphane Thibaudeau - Obeo
 */
public class ISMigrationParticipant extends AbstractMigrationParticipant {

	private static Map<String, Map<String, EClassLocation>> eClassesMapping = null;
	private static Map<String, String> ePackagesMapping = null;
	
	@Override
	public Version getMigrationVersion() {
		return new Version(8,1,1);
	}
	
	@Override
	public EClassifier getType(EPackage ePackage, String name, String loadedVersion) {
		String oldEPackageURI = ePackage.getNsURI();
		String newEPackageURI = null;
		String newEClassName = null;
		
		EClassLocation newEClass = getNewEClass(oldEPackageURI, name);
		if (newEClass != null) {
			newEPackageURI = newEClass.getEPackageNsURI();
			newEClassName = newEClass.getEClassName();
		} else {
			// Try to convert EPackage
			newEPackageURI = getEPackagesMapping().get(oldEPackageURI);
			newEClassName = name;
		}
		
		// Get Classifier from registry
		if (newEPackageURI != null && newEClassName != null) {
			EPackage newEPackage = EPackage.Registry.INSTANCE.getEPackage(newEPackageURI);
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
	
	/**
	 * 
	 */
	private static void initMappings() {
		ePackagesMapping = new HashMap<String, String>();
		ePackagesMapping.put(BasicMigrationHelper.ENVIRONMENT_URI_OLD, BasicMigrationHelper.ENVIRONMENT_URI_NEW);
		ePackagesMapping.put(BasicMigrationHelper.ENTITY_URI_OLD, BasicMigrationHelper.ENTITY_URI_NEW);
		ePackagesMapping.put(BasicMigrationHelper.SOA_URI_OLD, BasicMigrationHelper.SOA_URI_NEW);
		ePackagesMapping.put(BasicMigrationHelper.GRAAL_URI_OLD, BasicMigrationHelper.GRAAL_URI_NEW);
		
		eClassesMapping = new HashMap<String, Map<String,EClassLocation>>();
		
		Map<String, EClassLocation> ePackageMapppings = new HashMap<String, EClassLocation>();
		ePackageMapppings.put("Block", new EClassLocation(BasicMigrationHelper.ENVIRONMENT_URI_NEW, "Namespace"));
		eClassesMapping.put(BasicMigrationHelper.ENTITY_URI_OLD, ePackageMapppings);
		
		ePackageMapppings = new HashMap<String, EClassLocation>();
		ePackageMapppings.put("Category", new EClassLocation(BasicMigrationHelper.ENVIRONMENT_URI_NEW, "Namespace"));
		ePackageMapppings.put("ServiceDTO", new EClassLocation(BasicMigrationHelper.ENVIRONMENT_URI_NEW, "DTO"));
		eClassesMapping.put(BasicMigrationHelper.SOA_URI_OLD, ePackageMapppings);
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
	
}
