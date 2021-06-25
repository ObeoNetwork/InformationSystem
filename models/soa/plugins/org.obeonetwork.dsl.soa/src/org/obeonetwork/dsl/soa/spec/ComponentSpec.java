package org.obeonetwork.dsl.soa.spec;

import org.obeonetwork.dsl.soa.SoaFactory;
import org.obeonetwork.dsl.soa.impl.ComponentImpl;

public class ComponentSpec extends ComponentImpl {

	public ComponentSpec() {
		super();
		setInformation(SoaFactory.eINSTANCE.createInformation());
		setLicense(SoaFactory.eINSTANCE.createLicense());
		setContact(SoaFactory.eINSTANCE.createContact());
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setApiVersion(String newApiVersion) {
		getInformation().setVersion(newApiVersion);
	}

}
