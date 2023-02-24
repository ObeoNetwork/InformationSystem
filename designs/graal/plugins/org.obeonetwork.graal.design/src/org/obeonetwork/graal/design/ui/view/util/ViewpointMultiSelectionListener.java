/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
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
package org.obeonetwork.graal.design.ui.view.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public abstract class ViewpointMultiSelectionListener implements ISelectionListener {

	private IWorkbenchPart owningPart;

	/**
	 * @param owningPart
	 */
	public ViewpointMultiSelectionListener(IWorkbenchPart owningPart) {
		this.owningPart = owningPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (part != owningPart) {
			List<EObject> selectedEObjects = new ArrayList<EObject>();
			Session session = null;
			if (!selection.isEmpty() && selection instanceof StructuredSelection) {
				for (Object selectedObject : ((StructuredSelection) selection).toList()) {
					if (selectedObject instanceof GraphicalEditPart) {
						GraphicalEditPart graphicalEditPart = (GraphicalEditPart) selectedObject;
						if (graphicalEditPart.getModel() instanceof View) {
							View node = (View) graphicalEditPart.getModel();
							if (node.getElement() instanceof DSemanticDecorator) {
								DSemanticDecorator semanticDecorator = (DSemanticDecorator) node.getElement();
								if (session == null) {
									session = new EObjectQuery(semanticDecorator.getTarget()).getSession();
								}
								selectedEObjects.add(semanticDecorator.getTarget());
							}
						}
					} else if (selectedObject instanceof EObject) {
						EObject selectedEObject = (EObject) selectedObject;
						session = new EObjectQuery(selectedEObject).getSession();
						if (!ViewpointPackage.eINSTANCE.getDRepresentation().isInstance(selectedObject)) {
							selectedEObjects.add(selectedEObject);
						}
					}
				}
			}

			eObjectSelected(session, selectedEObjects);
		}
	}

	/**
	 * @param session
	 *            the {@link Session} owning the selected semantic element.
	 * @param selectedEObject
	 *            the new selection
	 */
	protected abstract void eObjectSelected(Session session, List<EObject> selectedEObject);

}
