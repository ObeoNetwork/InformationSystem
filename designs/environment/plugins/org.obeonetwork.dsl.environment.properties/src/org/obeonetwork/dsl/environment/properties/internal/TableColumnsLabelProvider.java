/*******************************************************************************
 * Copyright (c) 2019 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.properties.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;

/**
 * The label provider for column.
 * 
 * @author gcoutable
 */
public class TableColumnsLabelProvider extends CellLabelProvider implements ILabelProvider {
	
	private String columnName;

	public TableColumnsLabelProvider(String columnName) {
		this.columnName = columnName;
	}

	@Override
	public void update(ViewerCell cell) {
		Object element = cell.getElement();
		cell.setText(getText(element));
		Image image = getImage(element);
		cell.setImage(image);
	}

	@Override
	public Image getImage(Object element) {
		return null;
	}

	@Override
	public String getText(Object element) {
		if (element instanceof EObject) {
			EStructuralFeature eStructuralFeature = ((EObject) element).eClass().getEStructuralFeature(columnName);
			Object object = null;
			if (eStructuralFeature != null) {
				object = ((EObject) element).eGet(eStructuralFeature);
			}
			return object == null ? "" : object.toString();
		}
		return element == null ? "" : element.toString();
	}

}
