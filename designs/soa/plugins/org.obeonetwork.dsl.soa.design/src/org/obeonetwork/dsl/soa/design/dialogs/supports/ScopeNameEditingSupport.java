/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.design.dialogs.supports;

import org.eclipse.jface.viewers.TableViewer;
import org.obeonetwork.dsl.soa.Scope;

/**
 * {@link EditingSupport} specialization for editing the names of {@link Scope}s
 * @author Obeo
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