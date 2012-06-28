/**
 * 
 */
package org.obeonetwork.graal.design.ui.view.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;

import fr.obeo.dsl.viewpoint.DAnalysis;
import fr.obeo.dsl.viewpoint.DSemanticDecorator;
import fr.obeo.dsl.viewpoint.ViewpointPackage;

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
	 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (part != owningPart) {
			List<EObject> selectedEObjects = new ArrayList<EObject>();
			DAnalysis analysis = null;
			if (!selection.isEmpty() && selection instanceof StructuredSelection) {
				for (Object selectedObject : ((StructuredSelection) selection).toList()) {
					if (selectedObject instanceof GraphicalEditPart) {
						GraphicalEditPart graphicalEditPart = (GraphicalEditPart) selectedObject;
						if (graphicalEditPart.getModel() instanceof View) {
							View node = (View) graphicalEditPart.getModel();
							if (node.getElement() instanceof DSemanticDecorator) {
								DSemanticDecorator semanticDecorator = (DSemanticDecorator) node.getElement();
								if (analysis == null) {
									EObject rootContainer = EcoreUtil.getRootContainer(semanticDecorator);
									if (rootContainer instanceof DAnalysis) {
										analysis = (DAnalysis) rootContainer;
									}
								}
								selectedEObjects.add(semanticDecorator.getTarget());
							}
						} 
					} else if (selectedObject instanceof EObject) {
						if (!ViewpointPackage.eINSTANCE.getDRepresentation().isInstance(selectedObject)) {
							selectedEObjects.add((EObject)selectedObject);
						}
					} 
				}			
			} 

			eObjectSelected(analysis, selectedEObjects);
		}
	}

	/**
	 * @param analysis the active diagram.
	 * @param selectedEObject the new selection
	 */
	protected abstract void eObjectSelected(DAnalysis analysis, List<EObject> selectedEObject);

}
