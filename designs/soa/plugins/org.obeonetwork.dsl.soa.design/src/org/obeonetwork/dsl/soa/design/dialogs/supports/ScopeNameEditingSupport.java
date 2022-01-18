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
package org.obeonetwork.dsl.soa.design.dialogs.supports;

import org.eclipse.jface.viewers.TableViewer;
import org.obeonetwork.dsl.soa.Scope;

/**
 * {@link EditingSupport} specialization for editing the names of {@link Scope}s
 * 	@author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers
 *  	la Fosse</a> 	 
 */
public class ScopeNameEditingSupport extends AbstractScopeEditingSupport {
	
	public ScopeNameEditingSupport(TableViewer scopeTableViewer) {
		super(scopeTableViewer);
	}

	@Override
	protected Object getValue(Object element) {
		return ((Scope) element).getName();
	}

	@Override
	protected void setValue(Object element, Object value) {
		((Scope) element).setName((String) value);
		getViewer().refresh();
	}
}