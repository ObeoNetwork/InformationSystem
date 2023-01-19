/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
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
 * {@link ScopeDescriptionEditingSupport} specialization for editing the description of {@link Scope}s
 * 	@author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers
 *  	la Fosse</a> 	 
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