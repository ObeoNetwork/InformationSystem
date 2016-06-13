package org.obeonetwork.dsl.environment.migration;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.tools.migration.BasicMigrationHelper;

public class EnvironmentMigrationHelper extends BasicMigrationHelper {
	
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
