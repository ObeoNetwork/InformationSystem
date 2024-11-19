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
package org.obeonetwork.dsl.environment.binding.dialect.ui.dialect;

import org.eclipse.sirius.ui.business.api.dialect.DialectUI;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIServices;

/**
 * Extension to provide Binding dialect UI
 * @author Obeo
 *
 */
public class BindingDialectUI implements DialectUI{

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.ui.business.api.dialect.DialectUI#getName()
	 */
	public String getName() {
		return "Binding Editor Dialect";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.ui.business.api.dialect.DialectUI#getServices()
	 */
	public DialectUIServices getServices() {
		return new BindingDialectUIServices();
	}

}
