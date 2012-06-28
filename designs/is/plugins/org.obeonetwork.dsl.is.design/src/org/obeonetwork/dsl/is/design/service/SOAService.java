/*******************************************************************************
 * Copyright (c) 2009-2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.is.design.service;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.soa.InterfaceKind;

public class SOAService {
	
	public InterfaceKind getProvidedLiteral(EObject object){
		return InterfaceKind.PROVIDED_LITERAL;
	}
	
	public InterfaceKind getRequiredLiteral(EObject object){
		return InterfaceKind.REQUIRED_LITERAL;
	}
}
