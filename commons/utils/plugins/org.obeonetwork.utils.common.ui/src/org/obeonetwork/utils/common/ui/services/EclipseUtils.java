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
package org.obeonetwork.utils.common.ui.services;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.sirius.diagram.ui.tools.api.editor.DDiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;

public class EclipseUtils {

	public static List<DDiagramEditor> getOpenDDiagramEditors() {
		List<DDiagramEditor> openDDiagramEditors = new ArrayList<>();
		if(PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null && PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage() != null) {
			IEditorReference[] editorReferences = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();
			for (IEditorReference editorReference : editorReferences) {
				IEditorPart editor = editorReference.getEditor(false);
				if(editor instanceof DDiagramEditor) {
					DDiagramEditor dDiagramEditor = (DDiagramEditor) editor;
					openDDiagramEditors.add(dDiagramEditor);
				}
			}
		}
		return openDDiagramEditors;
	}
	
}
