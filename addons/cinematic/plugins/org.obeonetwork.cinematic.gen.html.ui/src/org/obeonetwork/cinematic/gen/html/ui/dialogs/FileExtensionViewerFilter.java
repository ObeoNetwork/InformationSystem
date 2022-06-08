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
package org.obeonetwork.cinematic.gen.html.ui.dialogs;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class FileExtensionViewerFilter extends ViewerFilter {

	private String fileExtension;
	public FileExtensionViewerFilter(String fileExtension) {
		super();
		this.fileExtension = fileExtension;
	}
	
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
        if (element instanceof IFile) {
            IResource workspaceResource = (IResource)element;
            return fileExtension.equals(workspaceResource.getFileExtension());
          }
          return true;
	}
}
