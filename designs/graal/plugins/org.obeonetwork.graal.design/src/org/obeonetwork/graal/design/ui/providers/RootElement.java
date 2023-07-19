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
package org.obeonetwork.graal.design.ui.providers;

/**
 * Class used as root element in the tree viewers to avoid recursion bug on tree viewers
 * @author Obeo
 *
 */
public class RootElement {

	private Object root;

	public RootElement(Object root) {
		this.root = root;
	}

	public Object getRoot() {
		return root;
	}
	
}
