/**
 * 
 */
package org.obeonetwork.tools.linker.ui.view.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;

import fr.obeo.dsl.viewpoint.DSemanticDecorator;
import fr.obeo.dsl.viewpoint.ViewpointPackage;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
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
					GraphicalEditPart graphicalEditPart = (GraphicalEditPart) selectedObject;
					if (graphicalEditPart.getModel() instanceof View) {
						View node = (View) graphicalEditPart.getModel();
						if (node.getElement() instanceof DSemanticDecorator) {
							DSemanticDecorator semanticDecorator = (DSemanticDecorator) node.getElement();
							selectedEObject = semanticDecorator.getTarget();
						}
					} 
				} else if (selectedObject instanceof EObject) {
					if (!ViewpointPackage.eINSTANCE.getDRepresentation().isInstance(selectedObject)) {
						selectedEObject = (EObject) selectedObject;
					} else {
						selectedEObject = null;
					}
				}
			}
		} else {
			selectedEObject = null;
		}
		eObjectSelected(selectedEObject);

	}

	/**
	 * @param selectedEObject the new selection
	 */
	protected abstract void eObjectSelected(EObject selectedEObject);

}
