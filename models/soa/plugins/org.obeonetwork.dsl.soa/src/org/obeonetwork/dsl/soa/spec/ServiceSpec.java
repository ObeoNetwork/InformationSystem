/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.spec;

import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.obeonetwork.dsl.soa.SecurityScheme;
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
	
	@Override
	public EList<SecurityScheme> getSecuritySchemes() {
		
		return ECollections.unmodifiableEList(getSecurityApplications().stream().map(sa -> sa.getSecurityScheme()).collect(Collectors.toList()));
	}
	
}
