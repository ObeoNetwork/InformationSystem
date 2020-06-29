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
package org.obeonetwork.dsl.is.ui.wizards;

import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.obeonetwork.dsl.is.Activator;

public class ProjectsAndFoldersLabelProvider extends LabelProvider {
	private ILabelProvider workbenchLabelProvider = WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider();

	@Override
	public String getText(Object element) {
		String label = workbenchLabelProvider.getText(element);
		if (label == null || label.isEmpty()) {
			if (element instanceof CDOResourceFolder) {
				return ((CDOResourceFolder) element).getName();
			}
			return super.getText(element);
		}
		return label;
	}
	
	@Override
	public Image getImage(Object element) {
		Image image = workbenchLabelProvider.getImage(element);
		if (image == null) {
			if (element instanceof CDOResourceFolder) {
				ImageDescriptor imageDescriptor = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/shared_folder.png");
				return imageDescriptor.createImage();
			}
			return super.getImage(element);
		}
		return image;
	}
}
