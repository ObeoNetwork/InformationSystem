package org.obeonetwork.dsl.soa.migration;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.soa.SoaPackage;

public class SoaResourceExtendedMetadata extends BasicExtendedMetaData {


	public String oldSoaURI = "http://www.obeonetwork.org/dsl/soa/2.0.0";
	public String newSoaURI = "http://www.obeonetwork.org/dsl/soa/3.0.0";
	
	public String oldEnvironmentURI = "http://www.obeonetwork.org/dsl/environment/2.0.0";
	public String newEnvironmentURI = "http://www.obeonetwork.org/dsl/environment/3.0.0";
	
	
	@Override
	public EPackage getPackage(String namespace) {
		/*
		 * if the system is asking for an old namespace, let's return the
		 * current EPackage instance.
		 */
		if (oldSoaURI.equals(namespace)) {
			return SoaPackage.eINSTANCE;
		}
		if (oldEnvironmentURI.equals(namespace)) {
			return EnvironmentPackage.eINSTANCE;
		}
		return super.getPackage(namespace);
	}
	
	@Override
	public EClassifier getType(EPackage ePackage, String name) {
		EClassifier eClassifier = super.getType(ePackage, name);
		if (eClassifier == null) {

			if ("ServiceDTO".equals(name)) {
				return EnvironmentPackage.Literals.DTO;
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
		
		if (eClass == SoaPackage.Literals.SYSTEM) {
			if ("ownedDtoRegistry".equals(name)) {
				return SoaPackage.Literals.SYSTEM__NAMESPACES;
			}
			if ("ownedNamespaces".equals(name)) {
				return SoaPackage.Literals.SYSTEM__NAMESPACES;
			}
		}
		if (eClass == EnvironmentPackage.Literals.NAMESPACE) {
			if ("ownedCategories".equals(name)) {
				return EnvironmentPackage.Literals.NAMESPACE__OWNED_NAMESPACES;
			}
		}
		if (eClass == EnvironmentPackage.Literals.ENUMERATION) {
			if ("fields".equals(name)) {
				return EnvironmentPackage.Literals.ENUMERATION__LITERALS;
			}
		}
		if (eClass == EnvironmentPackage.Literals.ATTRIBUTE) {
			if ("type".equals(name)) {
				return EnvironmentPackage.Literals.ATTRIBUTE__TYPE;
			}
		}
		if (eClass == EnvironmentPackage.Literals.REFERENCE) {
			if ("type".equals(name)) {
				return EnvironmentPackage.Literals.REFERENCE__REFERENCED_TYPE;
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
		
		return super.getName(eClassifier);
	}
}
