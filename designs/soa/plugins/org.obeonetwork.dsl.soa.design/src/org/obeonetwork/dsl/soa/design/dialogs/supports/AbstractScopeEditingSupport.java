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
