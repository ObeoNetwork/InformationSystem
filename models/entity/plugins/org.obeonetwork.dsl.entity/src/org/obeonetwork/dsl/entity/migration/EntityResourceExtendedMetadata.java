package org.obeonetwork.dsl.entity.migration;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.environment.EnvironmentPackage;

public class EntityResourceExtendedMetadata extends BasicExtendedMetaData {


	public String oldURI = "http://www.obeonetwork.org/dsl/entity/2.0.0";

	public String newURI = "http://www.obeonetwork.org/dsl/entity/3.0.0";
	
	
	@Override
	public EPackage getPackage(String namespace) {
		/*
		 * if the system is asking for an old namespace, let's return the
		 * current EPackage instance.
		 */
		if (oldURI.equals(namespace)) {
			return EntityPackage.eINSTANCE;
		}
		return super.getPackage(namespace);
	}
	
	@Override
	public EClassifier getType(EPackage ePackage, String name) {
		EClassifier eClassifier = super.getType(ePackage, name);
		if (eClassifier == null) {

			// Block => Namespace
			if ("Block".equals(name)) {
				return EnvironmentPackage.eINSTANCE.getNamespace();
			}
		}
		return eClassifier;
	}
	
	/*
	 * features mapping
	 */

	@Override
	public EStructuralFeature getAttribute(EClass eClass, String namespace, String name) {
		EStructuralFeature found = super.getAttribute(eClass, namespace, name);
		if (found == null) {
			found = findEStructuralFeature(eClass, name, found);
		}
		return found;
	}

	@Override
	protected EStructuralFeature getLocalElement(EClass eClass, String namespace, String name) {
		EStructuralFeature found = super.getLocalElement(eClass, namespace,
				name);
		if (found == null) {
			found = findEStructuralFeature(eClass, name, found);
		}
		return found;
	}

	private EStructuralFeature findEStructuralFeature(EClass eClass, String name, EStructuralFeature found) {
		/*
		 * Test on eClass and name to put the right feature into the "found" variable
		 */
		
		if (eClass == EntityPackage.eINSTANCE.getRoot()) {
			// Root.blocks => Root.namespaces
			if ("blocks".equals(name)) {
				found = EntityPackage.eINSTANCE.getRoot_Namespaces();
			}
		} else if (eClass == EnvironmentPackage.eINSTANCE.getNamespace()) {
			// Block.subblocks => Namespace.ownedNamespaces
			if ("subblocks".equals(name)) {
				found = EnvironmentPackage.eINSTANCE.getNamespace_OwnedNamespaces();
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
	public String getNamespace(EPackage ePackage) {
		/*
		 * Here we could override the namespace we want to be used when saving.
		 */

		return super.getNamespace(ePackage);
	}
	
	@Override
	public String getName(EClassifier eClassifier) {
		/*
		 * Here we could redefine the way a type is transformed in a name during
		 * the save.
		 */
//		if (eClassifier == EnvironmentPackage.eINSTANCE.getType()) {
//			return EntityPackage.eINSTANCE.getEntity().getName();
//		}
		
		return super.getName(eClassifier);
	}
}
