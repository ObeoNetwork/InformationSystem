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
/**
 * 
 */
package org.obeonetwork.tools.linker.ui.view.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @author Obeo
 *
 */
public abstract class ViewpointSelectionListener implements ISelectionListener {

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		EObject selectedEObject = null;
		if (!selection.isEmpty() && selection instanceof StructuredSelection) {
			StructuredSelection sSelection = (StructuredSelection) selection;
			if (sSelection.size() == 1) {
				Object selectedObject = sSelection.getFirstElement();
				if (selectedObject instanceof GraphicalEditPart) {
					// Sirius diagrams
					GraphicalEditPart graphicalEditPart = (GraphicalEditPart) selectedObject;
					if (graphicalEditPart.getModel() instanceof View) {
						View node = (View) graphicalEditPart.getModel();
						if (node.getElement() instanceof DSemanticDecorator) {
							DSemanticDecorator semanticDecorator = (DSemanticDecorator) node.getElement();
							selectedEObject = semanticDecorator.getTarget();
						}
					}
				} else if (selectedObject instanceof DSemanticDecorator) {
					// Sirius trees and tables
					selectedEObject = ((DSemanticDecorator) selectedObject).getTarget();					
				} else if (selectedObject instanceof EObject) {
					if (!ViewpointPackage.eINSTANCE.getDRepresentation().isInstance(selectedObject)) {
						selectedEObject = (EObject) selectedObject;
					}
				}
			}
		} else {
			selectedEObject = null;
		}
		
		// Add this test to prevent a NullPointerException when selecting CDO resource
		if (!(selectedEObject instanceof Resource)) {
			eObjectSelected(selectedEObject);
		}

	}

	/**
	 * @param selectedEObject the new selection
	 */
	protected abstract void eObjectSelected(EObject selectedEObject);

}
