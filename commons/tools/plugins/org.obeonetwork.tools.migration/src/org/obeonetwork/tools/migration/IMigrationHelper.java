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
package org.obeonetwork.tools.migration;

import java.io.InputStream;
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

public interface IMigrationHelper {
	
	public boolean isMigrationNeeded();
	public void addOldNamespace(String oldNamespace);
	public boolean isOldNamespace(String namespace);
	
	/* Called from Resource */
	public ExtendedMetaData getExtendedMetaData();
	public XMLResource.ResourceHandler getResourceHandler();
	public EObject getEObject(String uriFragment);
	public XMLHelper createXMLHelper(XMLResource resource);

	/* From ExtendedMetaData */
	public Map<String, String> getOldURIToPackageMap();
	public String getCorrespondingNamespace(String namespace);
	public EClassifier getType(EPackage ePackage, String name);
	public String getNamespace(EPackage ePackage);
	public String getName(EClassifier eClassifier);
	public EStructuralFeature findEStructuralFeature(EClass eClass, String name, EStructuralFeature found);
	
	/* From ResourceHandler */
	public void preLoad(XMLResource resource, InputStream inputStream, Map<?, ?> options);
	public void postLoad(XMLResource resource, InputStream inputStream, Map<?, ?> options);
	public void handleUnknownFeaturesMixedValue(final EObject owner, final FeatureMap featureMap);
	public void handleUnknownFeaturesAnyAttribute(final EObject owner, final FeatureMap featureMap);
	public boolean isADeletedFeature(EObject owner, EStructuralFeature eStructuralFeature);
	
	/* From XMLHelper */
	public EObject createObject(EFactory eFactory, EClassifier type, MigrationXMLHelper parentHelper);
	public boolean setValue(EObject object, EStructuralFeature feature, Object value, int position, MigrationXMLHelper parentHelper);
}
