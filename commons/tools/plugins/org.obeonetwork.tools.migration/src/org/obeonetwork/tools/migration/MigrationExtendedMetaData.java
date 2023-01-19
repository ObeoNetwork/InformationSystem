/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.migration;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;

public class MigrationExtendedMetaData extends BasicExtendedMetaData {

	private IMigrationHelper migrationHelper;
	
	public MigrationExtendedMetaData(IMigrationHelper migrationHelper) {
		this.migrationHelper = migrationHelper;
	}
	
	@Override
	public EPackage getPackage(String namespace) {
		String newNamespace = migrationHelper.getCorrespondingNamespace(namespace);
		if (newNamespace != null) {
			migrationHelper.addOldNamespace(namespace);
			return super.getPackage(newNamespace);
		}
		return super.getPackage(namespace);
	}
	
	@Override
	public EClassifier getType(EPackage ePackage, String name) {
		EClassifier eClassifier = super.getType(ePackage, name);
		if (migrationHelper.isMigrationNeeded()) {
			if (eClassifier == null) {
				eClassifier = migrationHelper.getType(ePackage, name);
			}
		}
		return eClassifier;
	}
	
	@Override
	public String getNamespace(EPackage ePackage) {
		if (migrationHelper.isMigrationNeeded()) {
			String namespace = migrationHelper.getNamespace(ePackage);
			if (namespace != null) {
				return namespace;
			}
		}
		return super.getNamespace(ePackage);
	}
	
	@Override
	public String getName(EClassifier eClassifier) {
		if (migrationHelper.isMigrationNeeded()) {
			String name = migrationHelper.getName(eClassifier);
			if (name != null) {
				return name;
			}
		}
		return super.getName(eClassifier);
	}
	
	@Override
	public EStructuralFeature getAttribute(EClass eClass, String namespace, String name) {
		EStructuralFeature found = super.getAttribute(eClass, namespace, name);
		if (migrationHelper.isMigrationNeeded()) {
			if (found == null) {
				found = migrationHelper.findEStructuralFeature(eClass, name, found);
			}
		}
		return found;
	}

	@Override
	protected EStructuralFeature getLocalElement(EClass eClass, String namespace, String name) {
		EStructuralFeature found = super.getLocalElement(eClass, namespace, name);
		if (migrationHelper.isMigrationNeeded()) {
			if (found == null) {
				found = migrationHelper.findEStructuralFeature(eClass, name, found);
			}
		}
		return found;
	}
}
