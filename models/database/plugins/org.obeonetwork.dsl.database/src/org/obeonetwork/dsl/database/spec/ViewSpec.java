/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.spec;


import org.obeonetwork.dsl.database.impl.ViewImpl;

public class ViewSpec extends ViewImpl{

	/**
	 *  View content is initialized.
	 * The view have references (tables, columns) which are not saved 
	 * and need to be computed at the opening of a diagram.
	 */
	public boolean initialized = false;
	
	public ViewSpec(){
		super();
	}

}