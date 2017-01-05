/*******************************************************************************
 * Copyright (c) 2011, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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