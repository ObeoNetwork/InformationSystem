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

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;

public abstract class AbstractScopeEditingSupport extends EditingSupport {
	private CellEditor cellEditor;
	
	public AbstractScopeEditingSupport(TableViewer scopeTableViewer) {
		super(scopeTableViewer);
		cellEditor = new TextCellEditor(scopeTableViewer.getTable(), SWT.SINGLE | SWT.BORDER);
	}
	
	@Override
	protected CellEditor getCellEditor(Object element) {			
		return cellEditor;
	}

	@Override
	protected boolean canEdit(Object element) { 
		return true;
	}

}
