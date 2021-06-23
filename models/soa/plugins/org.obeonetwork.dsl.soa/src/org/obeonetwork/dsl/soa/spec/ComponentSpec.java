package org.obeonetwork.dsl.soa.spec;

import org.obeonetwork.dsl.soa.SoaFactory;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.dsl.soa.impl.ComponentImpl;

public class ComponentSpec extends ComponentImpl {

	public ComponentSpec() {
		super();
		eDynamicSet(SoaPackage.COMPONENT__INFORMATION, SoaFactory.eINSTANCE.createInformation());
		eDynamicSet(SoaPackage.COMPONENT__LICENSE, SoaFactory.eINSTANCE.createLicense());
		eDynamicSet(SoaPackage.COMPONENT__CONTACT, SoaFactory.eINSTANCE.createContact());
	}

}
