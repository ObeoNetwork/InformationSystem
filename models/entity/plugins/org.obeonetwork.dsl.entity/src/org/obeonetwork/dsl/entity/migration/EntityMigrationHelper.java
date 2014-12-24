package org.obeonetwork.dsl.entity.migration;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.obeonetwork.dsl.entity.EntityFactory;
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.tools.migration.BasicMigrationHelper;
import org.obeonetwork.tools.migration.MigrationXMLHelper;

public class EntityMigrationHelper extends BasicMigrationHelper{

	public static final String ENTITY_URI_OLD = "http://www.obeonetwork.org/dsl/entity/2.0.0";
	public static final String ENTITY_URI_NEW = "http://www.obeonetwork.org/dsl/entity/3.0.0";
	
	public static final String ENVIRONMENT_URI_OLD = "http://www.obeonetwork.org/dsl/environment/2.0.0";
	public static final String ENVIRONMENT_URI_NEW = "http://www.obeonetwork.org/dsl/environment/3.0.0";
	
	@Override
	public Map<String, EPackage> getOldURIToPackageMap() {
		Map<String, EPackage> newPackagesMap = new HashMap<String, EPackage>();
		newPackagesMap.put(ENTITY_URI_OLD, EntityPackage.eINSTANCE);
		newPackagesMap.put(ENVIRONMENT_URI_OLD, EnvironmentPackage.eINSTANCE);
		return newPackagesMap;
	}
	
	@Override
	public EClassifier getType(EPackage ePackage, String name) {
		// Block => Namespace
		if ("Block".equals(name)) {
			return EnvironmentPackage.eINSTANCE.getNamespace();
		}
		return null;
	}
	
	@Override
	public EStructuralFeature findEStructuralFeature(EClass eClass, String name, EStructuralFeature found) {
		if (eClass == EntityPackage.eINSTANCE.getRoot()) {
			// Root.blocks => Root.namespaces
			if ("blocks".equals(name)) {
				found = EnvironmentPackage.eINSTANCE.getNamespacesContainer_OwnedNamespaces();
			}
		} else if (eClass == EnvironmentPackage.eINSTANCE.getNamespace()) {
			// Block.subblocks => Namespace.ownedNamespaces
			if ("subblocks".equals(name)) {
				found = EnvironmentPackage.eINSTANCE.getNamespacesContainer_OwnedNamespaces();
			}
			// Block.entities => TypesDefinitions.types
			if ("entities".equals(name)) {
				found = EnvironmentPackage.eINSTANCE.getTypesDefinition_Types();
			}
		} else if (eClass == EnvironmentPackage.eINSTANCE.getAttribute()) {
			if ("isPrimaryKey".equals(name)) {
				found = EnvironmentPackage.eINSTANCE.getProperty_IsIdentifier();
			}
			if ("type".equals(name)) {
				found = EnvironmentPackage.eINSTANCE.getAttribute_Type();
			}
		} else if (eClass == EnvironmentPackage.eINSTANCE.getReference()) {
			if ("isPrimaryKey".equals(name)) {
				found = EnvironmentPackage.eINSTANCE.getProperty_IsIdentifier();
			}
			if ("type".equals(name)) {
				found = EnvironmentPackage.eINSTANCE.getReference_ReferencedType();
			}
		}
		
		return found;
	}
	
	@Override
	public EObject createObject(EFactory eFactory, EClassifier type, MigrationXMLHelper parentHelper) {
		if (type == EnvironmentPackage.eINSTANCE.getType()) {
			return parentHelper.originalCreateObject(EntityFactory.eINSTANCE, EntityPackage.Literals.ENTITY);
		}
		if (type == EnvironmentPackage.eINSTANCE.getStructuredType()) {
			return parentHelper.originalCreateObject(EntityFactory.eINSTANCE, EntityPackage.Literals.ENTITY);
		}
		if (type == EnvironmentPackage.eINSTANCE.getDataType()) {
			return parentHelper.originalCreateObject(EnvironmentFactory.eINSTANCE, EnvironmentPackage.Literals.PRIMITIVE_TYPE);
		}
		return null;
	}
}
