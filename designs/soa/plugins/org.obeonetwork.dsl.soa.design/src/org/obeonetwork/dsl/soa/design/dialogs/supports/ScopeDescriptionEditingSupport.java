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
 * {@link ScopeDescriptionEditingSupport} specialization for editing the description of {@link Scope}s
 * @author Obeo
 */
public class ScopeDescriptionEditingSupport extends AbstractScopeEditingSupport {
	
	public ScopeDescriptionEditingSupport(TableViewer scopeTableViewer) {
		super(scopeTableViewer);
	}

	@Override
	protected Object getValue(Object element) {
		return ((Scope) element).getSummary();
	}

	@Override
	protected void setValue(Object element, Object value) {
		((Scope) element).setSummary((String) value);
		getViewer().refresh();
	}
}