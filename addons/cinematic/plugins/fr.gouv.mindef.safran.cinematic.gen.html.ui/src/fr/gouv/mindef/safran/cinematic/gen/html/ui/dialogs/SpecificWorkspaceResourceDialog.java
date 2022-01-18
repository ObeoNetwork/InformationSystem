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
package fr.gouv.mindef.safran.cinematic.gen.html.ui.dialogs;

import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class SpecificWorkspaceResourceDialog extends WorkspaceResourceDialog {

	public SpecificWorkspaceResourceDialog(Shell parent, ILabelProvider labelProvider, ITreeContentProvider contentProvider) {
		super(parent, labelProvider, contentProvider);
	}

	public static IResource openFolderOrFileSelection(
		    Shell parent,
		    String title,
		    String message,
		    IPath suggestedPath,
		    List<ViewerFilter> viewerFilters)
	{
		final SpecificWorkspaceResourceDialog dialog = new SpecificWorkspaceResourceDialog(parent, new WorkbenchLabelProvider(), new WorkbenchContentProvider());
		dialog.setAllowMultiple(false);
		dialog.setTitle(title);
		dialog.setMessage(message);
		dialog.setShowNewFolderControl(true);
		dialog.setShowFileControl(false);

		dialog.addFilter(dialog.createDefaultViewerFilter(false));
		if (viewerFilters != null) {
			for (ViewerFilter viewerFilter : viewerFilters) {
				dialog.addFilter(viewerFilter);
			}
		}

		if (suggestedPath != null) {
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IResource resource = root.findMember(suggestedPath);
			if (resource != null && resource.isAccessible()) {
				if (resource instanceof IContainer) {
					dialog.setInitialSelection(resource);
				} else {
					dialog.setInitialSelection(resource.getParent());
					dialog.setFileText(resource.getName());
				}
			} else {
				if (suggestedPath.segmentCount() > 1) {
					if (resource == null) {
						resource = root.getFile(suggestedPath);
					}

					if (resource.getProject().isAccessible()){
						IContainer container = resource.getParent();
						for (; !container.isAccessible() && container != resource.getProject(); container = container.getParent()) {
							// Do nothing
						}
						dialog.setInitialSelection(container);
						suggestedPath = suggestedPath.removeFirstSegments(container.getFullPath().segmentCount());
						dialog.setFileText(suggestedPath.toString());
						suggestedPath = null;
					}
				}

				if (suggestedPath != null) {
					String fileText = suggestedPath.isAbsolute() ?
							suggestedPath.removeFirstSegments(1).toString() :
								suggestedPath.toString();
							dialog.setFileText(fileText);
				}
			}
		}

		dialog.loadContents();

		
		return dialog.open() == Window.OK ? dialog.getSelectedContainers()[0] : null;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite)super.createDialogArea(parent);
		if (isShowFileControl()) {
			fileText.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent event) {
					updateOKStatus();
				}
			});
		}
		
		return composite;
	}

	public IStatus validate(Object[] selectedElements) {
		if (isShowNewFolderControl()) {
			updateNewFolderButtonState();
		}
		
		boolean enableOK = false;
		for (int i = 0; i < selectedElements.length; i++) {
			if (selectedElements[i] instanceof IContainer) {
				enableOK = !showFiles || (isShowFileControl() && fileText.getText().trim().length() > 0);
			} else if (selectedElements[i] instanceof IFile) {
				if (isShowFileControl()) {
					if (!fileText.getText().equals(((IFile)selectedElements[i]).getName())) {
						fileText.setText(((IFile)selectedElements[i]).getName());
					}
				}
				enableOK = true;
			}
			if (enableOK) break;
		}
		
		return enableOK ?
				new Status(IStatus.OK, "org.eclipse.emf.common.ui", 0, "", null) :
				new Status(IStatus.ERROR, "org.eclipse.emf.common.ui", 0, "", null);
	}
}
