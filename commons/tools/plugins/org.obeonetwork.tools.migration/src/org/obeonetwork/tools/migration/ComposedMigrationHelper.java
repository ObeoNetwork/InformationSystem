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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xmi.XMLResource;

public class ComposedMigrationHelper extends BasicMigrationHelper {
	
	private boolean migrationNeeded = false;
	
	private Collection<IMigrationHelper> migrationHelpers = new ArrayList<IMigrationHelper>();

	public ComposedMigrationHelper(IMigrationHelper... migrationHelpers) {
		this.migrationHelpers.addAll(Arrays.asList(migrationHelpers));
	}

	
	@Override
	public boolean isMigrationNeeded() {
		if (migrationNeeded == true) {
			return true;
		} else {
			for (IMigrationHelper migrationHelper : migrationHelpers) {
				boolean needed = migrationHelper.isMigrationNeeded();
				if (needed == true) {
					migrationNeeded = true;
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void setMigrationNeeded(boolean migrationNeeded) {
		for (IMigrationHelper migrationHelper : migrationHelpers) {
			migrationHelper.setMigrationNeeded(migrationNeeded);
		}
	}

	@Override
	public EObject getEObject(String uriFragment) {
		for (IMigrationHelper migrationHelper : migrationHelpers) {
			EObject object = migrationHelper.getEObject(uriFragment);
			if (object != null) {
				return object;
			}
		}
		return null;
	}

	@Override
	public EClassifier getType(EPackage ePackage, String name) {
		for (IMigrationHelper migrationHelper : migrationHelpers) {
			EClassifier type = migrationHelper.getType(ePackage, name);
			if (type != null) {
				return type;
			}
		}
		return null;
	}

	@Override
	public String getNamespace(EPackage ePackage) {
		for (IMigrationHelper migrationHelper : migrationHelpers) {
			String namespace = migrationHelper.getNamespace(ePackage);
			if (namespace != null) {
				return namespace;
			}
		}
		return null;
	}

	@Override
	public String getName(EClassifier eClassifier) {
		for (IMigrationHelper migrationHelper : migrationHelpers) {
			String name = migrationHelper.getName(eClassifier);
			if (name != null) {
				return name;
			}
		}
		return null;
	}

	@Override
	public EStructuralFeature findEStructuralFeature(EClass eClass, String name, EStructuralFeature found) {
		for (IMigrationHelper migrationHelper : migrationHelpers) {
			EStructuralFeature feature = migrationHelper.findEStructuralFeature(eClass, name, found);
			if (feature != null) {
				return feature;
			}
		}
		return null;
	}

	@Override
	public void preLoad(XMLResource resource, InputStream inputStream, Map<?, ?> options) {
		for (IMigrationHelper migrationHelper : migrationHelpers) {
			migrationHelper.preLoad(resource, inputStream, options);
		}
	}

	@Override
	public void postLoad(XMLResource resource, InputStream inputStream, Map<?, ?> options) {
		for (IMigrationHelper migrationHelper : migrationHelpers) {
			migrationHelper.postLoad(resource, inputStream, options);
		}
	}

	@Override
	public void handleUnknownFeaturesMixedValue(EObject owner, FeatureMap featureMap) {
		for (IMigrationHelper migrationHelper : migrationHelpers) {
			migrationHelper.handleUnknownFeaturesMixedValue(owner, featureMap);
		}
	}

	@Override
	public void handleUnknownFeaturesAnyAttribute(EObject owner, FeatureMap featureMap) {
		for (IMigrationHelper migrationHelper : migrationHelpers) {
			migrationHelper.handleUnknownFeaturesAnyAttribute(owner, featureMap);
		}
	}

	@Override
	public boolean isADeletedFeature(EObject owner, EStructuralFeature eStructuralFeature) {
		for (IMigrationHelper migrationHelper : migrationHelpers) {
			boolean deleted = migrationHelper.isADeletedFeature(owner, eStructuralFeature);
			if (deleted == true) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public EObject createObject(EFactory eFactory, EClassifier type, MigrationXMLHelper parentHelper) {
		for (IMigrationHelper migrationHelper : migrationHelpers) {
			EObject object = migrationHelper.createObject(eFactory, type, parentHelper);
			if (object != null) {
				return object;
			}
		}
		return null;
	}

	@Override
	public boolean setValue(EObject object, EStructuralFeature feature, Object value, int position, MigrationXMLHelper parentHelper) {
		for (IMigrationHelper migrationHelper : migrationHelpers) {
			boolean valueSet = migrationHelper.setValue(object, feature, value, position, parentHelper);
			if (valueSet == true) {
				return true;
			}
		}
		return false;
	}

}
