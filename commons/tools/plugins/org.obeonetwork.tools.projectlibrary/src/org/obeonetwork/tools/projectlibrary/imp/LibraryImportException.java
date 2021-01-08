/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.projectlibrary.imp;

public class LibraryImportException extends Exception {

	private static final long serialVersionUID = -4760221193108613757L;

	public LibraryImportException() {
		super();
	}

	public LibraryImportException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public LibraryImportException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public LibraryImportException(String arg0) {
		super(arg0);
	}

	public LibraryImportException(Throwable arg0) {
		super(arg0);
	}
	
}
