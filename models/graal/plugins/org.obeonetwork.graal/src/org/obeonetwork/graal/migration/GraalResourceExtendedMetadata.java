package org.obeonetwork.graal.migration;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.obeonetwork.graal.GraalPackage;

public class GraalResourceExtendedMetadata extends BasicExtendedMetaData {


	public String oldURI = "http://org.obeonetwork.graal/1.0";

	public String newURI = "http://www.obeonetwork.org/dsl/graal/2.0.0";
	
	
	@Override
	public EPackage getPackage(String namespace) {
		/*
		 * if the system is asking for an old namespace, let's return the
		 * current EPackage instance.
		 */
		if (oldURI.equals(namespace)) {
			return GraalPackage.eINSTANCE;
		}
		return super.getPackage(namespace);
	}
	
	@Override
	public EClassifier getType(EPackage ePackage, String name) {
		EClassifier eClassifier = super.getType(ePackage, name);
//		if (eClassifier == null) {
//			// TODO Migration code here
//			throw new RuntimeException("We should write some migration code here");
//		}
		return eClassifier;
	}
}
