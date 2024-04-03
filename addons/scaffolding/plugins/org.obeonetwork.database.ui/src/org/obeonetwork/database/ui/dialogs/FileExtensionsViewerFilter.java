/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.database.ui.dialogs;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class FileExtensionsViewerFilter extends ViewerFilter {

	private String[] fileExtensions;
	public FileExtensionsViewerFilter(String[] fileExtensions) {
		super();
		this.fileExtensions = fileExtensions;
	}
	
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof IFile) {
			IResource workspaceResource = (IResource)element;
			for (String fileExtension : fileExtensions) {
				if (fileExtension.equals(workspaceResource.getFileExtension())) {
					return true;
				}
			}
			return false;
		}
		return true;
	}
}
