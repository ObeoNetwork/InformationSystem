package org.obeonetwork.dsl.soa.spec;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.obeonetwork.dsl.soa.Service;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.dsl.soa.impl.InterfaceImpl;

public class InterfaceSpec extends InterfaceImpl {

	
	@Override
	public void setName(String newName) {
		String oldName = getName();
		super.setName(newName);
		if(eContainer()!=null){
			Service service = (Service)eContainer();
			String serviceName = service.getName();
			if(serviceName!=null && !serviceName.equals(newName)){
				service.setName(newName);
			}
		}
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SoaPackage.INTERFACE__NAME, oldName, newName));
	}
}
