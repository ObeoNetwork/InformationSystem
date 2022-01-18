/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
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
	
	
	
//	@Override
//	public EStructuralFeature getAttribute(EClass eClass, String name,
//			String loadedVersion) {
//		// TODO Auto-generated method stub
//		System.out.println("attribute : " + eClass.getName() + "." + name);
//		return super.getAttribute(eClass, name, loadedVersion);
//	}
//
//
//
//	@Override
//	public EStructuralFeature getLocalElement(EClass eClass, String name,
//			String loadedVersion) {
//		// TODO Auto-generated method stub
//		System.out.println("localelement : " + eClass.getName() + "." + name);
//		return super.getLocalElement(eClass, name, loadedVersion);
//	}
//
//
//
//	@Override
//	public Object getValue(EObject object, EStructuralFeature feature,
//			Object value, String loadedVersion) {
//		// TODO Auto-generated method stub
//		System.out.println("value : " + feature.getName() + "." + value);
//		return super.getValue(object, feature, value, loadedVersion);
//	}
//
//
//
//	@Override
//	public Option<String> getNewFragment(String uriFragment) {
//		// TODO Auto-generated method stub
//		System.out.println("uriFragment : " + uriFragment);
//		return super.getNewFragment(uriFragment);
//	}



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
		ePackagesMapping.put(BasicMigrationHelper.SOA_URI_OLD, BasicMigrationHelper.SOA_URI_NEW);
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
	
}
