package org.obeonetwork.dsl.environment.migration;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.tools.migration.BasicMigrationHelper;

public class EnvironmentMigrationHelper extends BasicMigrationHelper {

	public static final String ENVIRONMENT_URI_OLD = "http://www.obeonetwork.org/dsl/environment/2.0.0";
	public static final String ENVIRONMENT_URI_NEW = "http://www.obeonetwork.org/dsl/environment/3.0.0";
	
	@Override
	public Map<String, EPackage> getOldURIToPackageMap() {
		Map<String, EPackage> newPackagesMap = new HashMap<String, EPackage>();
		newPackagesMap.put(ENVIRONMENT_URI_OLD, EnvironmentPackage.eINSTANCE);
		return newPackagesMap;
	}
	
	@Override
	public EStructuralFeature findEStructuralFeature(EClass eClass, String name, EStructuralFeature found) {
		if (eClass == EnvironmentPackage.eINSTANCE.getEnumeration()) {
			// Enumeration.fields => Enumeration.literals
			if ("fields".equals(name)) {
				found = EnvironmentPackage.eINSTANCE.getEnumeration_Literals();
			}
		}
		return found;
	}
}
