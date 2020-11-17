/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.migration;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLResource.ResourceHandler;

abstract public class BasicMigrationHelper implements IMigrationHelper {
	
	public static final String ENTITY_URI_OLD = "http://www.obeonetwork.org/dsl/entity/2.0.0";
	public static final String ENTITY_URI_NEW = "http://www.obeonetwork.org/dsl/entity/3.0.0";
	
	public static final String ENVIRONMENT_URI_OLD = "http://www.obeonetwork.org/dsl/environment/2.0.0";
	public static final String ENVIRONMENT_URI_NEW = "http://www.obeonetwork.org/dsl/environment/3.0.0";
	
	public static final String SOA_URI_OLD = "http://www.obeonetwork.org/dsl/soa/2.0.0";
	public static final String SOA_URI_NEW = "http://www.obeonetwork.org/dsl/soa/3.0.0";
	
	public static final String GRAAL_URI_OLD = "http://org.obeonetwork.graal/1.0";
	public static final String GRAAL_URI_NEW = "http://www.obeonetwork.org/dsl/graal/2.0.0";
	
	private static Map<String, String> oldUriToNewUri = null;
	
	private boolean migrationNeeded = false;
	
	public boolean isMigrationNeeded() {
		return migrationNeeded;
	}

	public void setMigrationNeeded(boolean migrationNeeded) {
		this.migrationNeeded = migrationNeeded;
	}

	public Map<String, String> getOldURIToPackageMap() {
		if (oldUriToNewUri == null) {
			oldUriToNewUri = new HashMap<String, String>();
			oldUriToNewUri.put(ENVIRONMENT_URI_OLD, ENVIRONMENT_URI_NEW);
			oldUriToNewUri.put(ENTITY_URI_OLD, ENTITY_URI_NEW);
			oldUriToNewUri.put(SOA_URI_OLD, SOA_URI_NEW);
			oldUriToNewUri.put(GRAAL_URI_OLD, GRAAL_URI_NEW);
		}
		return oldUriToNewUri;
	}
	
	@Override
	public ExtendedMetaData getExtendedMetaData() {
		return new MigrationExtendedMetaData(this);
	}

	@Override
	public ResourceHandler getResourceHandler() {
		return new MigrationResourceHandler(this);
	}
	
	@Override
	public EObject getEObject(String uriFragment) {
		return null;
	}

	@Override
	public XMLHelper createXMLHelper(XMLResource resource) {
		return new MigrationXMLHelper(resource, this);
	}
	
	@Override
	public String getCorrespondingNamespace(String namespace) {
		return getOldURIToPackageMap().get(namespace);
	}
	

	@Override
	public EClassifier getType(EPackage ePackage, String name) {
		return null;
	}

	@Override
	public String getNamespace(EPackage ePackage) {
		return null;
	}

	@Override
	public String getName(EClassifier eClassifier) {
		return null;
	}

	@Override
	public EStructuralFeature findEStructuralFeature(EClass eClass, String name, EStructuralFeature found) {
		return null;
	}

	@Override
	public void preLoad(XMLResource resource, InputStream inputStream, Map<?, ?> options) {
	}

	@Override
	public void postLoad(XMLResource resource, InputStream inputStream,	Map<?, ?> options) {
	}

	@Override
	public void handleUnknownFeaturesMixedValue(EObject owner, FeatureMap featureMap) {
	}

	@Override
	public void handleUnknownFeaturesAnyAttribute(EObject owner, FeatureMap featureMap) {
	}

	@Override
	public boolean isADeletedFeature(EObject owner, EStructuralFeature eStructuralFeature) {
		return false;
	}

	@Override
	public EObject createObject(EFactory eFactory, EClassifier type, MigrationXMLHelper parentHelper) {
		return null;
	}

	@Override
	public boolean setValue(EObject object, EStructuralFeature feature, Object value, int position, MigrationXMLHelper parentHelper) {
		return false;
	}

}
