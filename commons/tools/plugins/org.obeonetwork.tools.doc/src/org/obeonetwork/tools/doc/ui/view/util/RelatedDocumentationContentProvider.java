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
/**
 * 
 */
package org.obeonetwork.tools.doc.ui.view.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.Viewer;
import org.obeonetwork.tools.doc.core.impl.DocumentationLinkHelper;
import org.obeonetwork.tools.linker.ui.view.util.EObjectLinkContentProvider;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class RelatedDocumentationContentProvider extends EObjectLinkContentProvider {

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.ui.view.util.EObjectLinkContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if (newInput instanceof EObject && (((EObject) newInput).eResource() != null) && ((EObject)newInput).eResource().getResourceSet() != null) {
			ResourceSet resourceSet = ((EObject)newInput).eResource().getResourceSet();
			if (linker == null || !linker.getResourceSet().equals(resourceSet)) {
				linker = DocumentationLinkHelper.getDocumentationLinker((EObject)newInput);		
			}
		}
	}

}
