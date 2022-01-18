/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.spec;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.dsl.soa.impl.ServiceImpl;

public class ServiceSpec extends ServiceImpl {

	
	@Override
	public void setName(String newName) {
		String oldName = getName();
		super.setName(newName);
		if(getOwnedInterface()!=null && getOwnedInterface().getName()!=null){
			String interfaceName = getOwnedInterface().getName();
			if(!interfaceName.equals(newName)){
				getOwnedInterface().setName(newName);
			}
		}		
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SoaPackage.SERVICE__NAME, oldName, newName));
	}
}
