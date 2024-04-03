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
package org.obeonetwork.dsl.database.reverse.source;

public class DataSourceException extends Exception {

	private static final long serialVersionUID = 4980542657923318293L;

	public DataSourceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public DataSourceException(String arg0) {
		super(arg0);
	}
	
}
