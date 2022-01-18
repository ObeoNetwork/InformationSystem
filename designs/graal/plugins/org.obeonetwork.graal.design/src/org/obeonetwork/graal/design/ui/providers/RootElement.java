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
package org.obeonetwork.graal.design.ui.providers;

/**
 * Class used as root element in the tree viewers to avoid recursion bug on tree viewers
 * @author Stephane Thibaudeau <stephane.thibaudeau@obeo.fr>
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
