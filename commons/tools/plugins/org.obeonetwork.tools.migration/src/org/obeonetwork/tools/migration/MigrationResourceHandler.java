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
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.BasicResourceHandler;
import org.eclipse.emf.ecore.xml.type.AnyType;

public class MigrationResourceHandler extends BasicResourceHandler {
	
	IMigrationHelper migrationHelper = null;
	
	public MigrationResourceHandler(IMigrationHelper migrationHelper) {
		this.migrationHelper = migrationHelper;
	}
	
	@Override
	public void preLoad(XMLResource resource, InputStream inputStream, Map<?, ?> options) {
		super.preLoad(resource, inputStream, options);
		if (migrationHelper.isMigrationNeeded()) {
			migrationHelper.preLoad(resource, inputStream, options);
		}
	}
	
	@Override
	public void postLoad(XMLResource resource, InputStream inputStream, Map<?, ?> options) {
		super.postLoad(resource, inputStream, options);
		if (migrationHelper.isMigrationNeeded()) {
			processUnknownData(resource);
			migrationHelper.postLoad(resource, inputStream, options);
		}
		migrationHelper.postLoadAlways(resource, inputStream, options);
	}

	protected void processUnknownData(final XMLResource resource) {
		final Map<EObject, AnyType> extMap = resource.getEObjectToExtensionMap();
		for (final EObject key : extMap.keySet()) {
			final AnyType value = extMap.get(key);
			handleUnknownData(key, value);
		}
	}

	private void handleUnknownData(final EObject eObj, final AnyType unknownData) {
		handleUnknownFeaturesMixedValue(eObj, unknownData.getMixed());
		handleUnknownFeaturesAnyAttribute(eObj, unknownData.getAnyAttribute());
	}
	
	private void handleUnknownFeaturesMixedValue(final EObject owner, final FeatureMap featureMap) {
		migrationHelper.handleUnknownFeaturesMixedValue(owner, featureMap);
		final Iterator<FeatureMap.Entry> iter = featureMap.iterator();
		while (iter.hasNext()) {
			final FeatureMap.Entry entry = iter.next();
			if (isADeletedFeature(owner, entry.getEStructuralFeature())) {
				iter.remove();
			}
		}
	}

	private void handleUnknownFeaturesAnyAttribute(final EObject owner, final FeatureMap featureMap) {
		migrationHelper.handleUnknownFeaturesAnyAttribute(owner, featureMap);
		Iterator<FeatureMap.Entry> iter = featureMap.iterator();
		while (iter.hasNext()) {
			final FeatureMap.Entry entry = iter.next();
			if (isADeletedFeature(owner, entry.getEStructuralFeature())) {
				iter.remove();
			}
		}
	}

	private boolean isADeletedFeature(EObject owner, EStructuralFeature eStructuralFeature) {
		return migrationHelper.isADeletedFeature(owner, eStructuralFeature);
	}
}
