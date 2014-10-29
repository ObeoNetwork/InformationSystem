package org.obeonetwork.dsl.environment.migration;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.obeonetwork.dsl.environment.EnvironmentPackage;

public class EnvironmentResourceExtendedMetadata extends BasicExtendedMetaData {


	public String oldURI = "http://www.obeonetwork.org/dsl/environment/2.0.0";

	public String newURI = "http://www.obeonetwork.org/dsl/environment/3.0.0";
	
	
	@Override
	public EPackage getPackage(String namespace) {
		/*
		 * if the system is asking for an old namespace, let's return the
		 * current EPackage instance.
		 */
		if (oldURI.equals(namespace)) {
			return EnvironmentPackage.eINSTANCE;
		}
		return super.getPackage(namespace);
	}
	
	@Override
	public EClassifier getType(EPackage ePackage, String name) {
		EClassifier eClassifier = super.getType(ePackage, name);
		if (eClassifier == null) {
			
			// TODO Provide the right type for an unknown type
			
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
		
		if (eClass == EnvironmentPackage.eINSTANCE.getEnumeration()) {
			// Enumeration.fields => Enumeration.literals
			if ("fields".equals(name)) {
				found = EnvironmentPackage.eINSTANCE.getEnumeration_Literals();
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
