/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.commands;

import java.util.List;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.obeonetwork.dsl.environment.BindingInfo;
import org.obeonetwork.dsl.environment.bindingdialect.DBoundElement;

public class CreateMappingsCommand extends CompoundCommand {

//	final private BindingInfo bindingInfo;
//	final private List<DBoundElement> leftBoundElements;
//	final private List<DBoundElement> rightBoundElements;
	
	public CreateMappingsCommand(TransactionalEditingDomain domain,
			BindingInfo bindingInfo,
			List<DBoundElement> leftBoundElements,
			List<DBoundElement> rightBoundElements) {
		
//		this.bindingInfo = bindingInfo;
//		this.leftBoundElements = leftBoundElements;
//		this.rightBoundElements = rightBoundElements;
		
		for (int i =0; i < leftBoundElements.size(); i++) {
			DBoundElement leftBoundElement = leftBoundElements.get(i);
			DBoundElement rightBoundElement = rightBoundElements.get(i);
			append(new CreateMappingCommand(domain, bindingInfo, leftBoundElement, rightBoundElement));
		}
	}
	
}
