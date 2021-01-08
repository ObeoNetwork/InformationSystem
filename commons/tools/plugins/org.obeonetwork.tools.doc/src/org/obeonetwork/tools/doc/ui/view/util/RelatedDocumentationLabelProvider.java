/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package org.obeonetwork.tools.doc.ui.view.util;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.obeonetwork.tools.doc.core.DocumentationLink;
import org.obeonetwork.tools.linker.ui.view.util.EObjectLinkLabelProvider;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class RelatedDocumentationLabelProvider extends EObjectLinkLabelProvider {

	/**
	 * @param adapterFactory to use
	 * @param emphasicFont to use to show the children documentation
	 */
	public RelatedDocumentationLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 */
	public String getColumnText(Object element, int columnIndex) {
		if (element instanceof DocumentationLink) {
			if (columnIndex == 0) {
				return ((DocumentationLink)element).getName()== null?"":((DocumentationLink)element).getName(); //$NON-NLS-1$
			} else if (columnIndex == 1) { 
				return ((DocumentationLink)element).getValue() == null?"":((DocumentationLink)element).getValue(); //$NON-NLS-1$
			}
		}
		return ""; //$NON-NLS-1$
	}
	
}
