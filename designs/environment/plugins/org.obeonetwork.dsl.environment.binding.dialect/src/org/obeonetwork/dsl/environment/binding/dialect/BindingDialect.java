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
package org.obeonetwork.dsl.environment.binding.dialect;

import org.eclipse.sirius.business.api.dialect.Dialect;
import org.eclipse.sirius.business.api.dialect.DialectServices;

/**
 * Extension to provide Binding dialect
 * @author Stephane Thibaudeau <stephane.thibaudeau@obeo.fr>
 *
 */
public class BindingDialect implements Dialect {
	
	private BindingDialectServices services;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.viewpoint.business.api.dialect.Dialect#getName()
	 */
	public String getName() {
		return "BindingDialect";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.viewpoint.business.api.dialect.Dialect#getServices()
	 */
	public DialectServices getServices() {
		if (services == null) {
			services = new BindingDialectServices();
		}
		return services;
	}

}
