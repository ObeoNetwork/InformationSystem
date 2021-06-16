package org.obeonetwork.dsl.cinematic.design.services.flows;

import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DEdgeBeginNameEditPart;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DEdgeNameEditPart;
import org.eclipse.sirius.diagram.ui.part.SiriusVisualIDRegistry;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.obeonetwork.dsl.cinematic.design.services.label.TransitionGuardEditLabel;
import org.obeonetwork.dsl.cinematic.flow.Transition;

/**
 * Extension for the Eclipse extension point: org.eclipse.gmf.runtime.diagram.ui.editpartProviders
 * Specifies {@link DirectEditPolicy} for {@link Transition} labels.
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a> 
 *
 */
@SuppressWarnings("restriction")
public class TransitionEditPartProvider extends AbstractEditPartProvider {	
	@Override
	public IGraphicalEditPart createGraphicEditPart(View view) {
		switch (SiriusVisualIDRegistry.getVisualID(view)) {

		case DEdgeBeginNameEditPart.VISUAL_ID:

			// We want to enable the begin label direct edit for the Transition.
			DEdgeBeginNameEditPart dEdgePart = new DEdgeBeginNameEditPart(view) {

				@Override
				protected boolean isDirectEditEnabled() {
					return true;
				}

			};

			// When a direct edit is performed on the begin label, we perform this edit policy:
			dEdgePart.installEditPolicy(org.eclipse.gef.RequestConstants.REQ_DIRECT_EDIT,
					new TransitionGuardEditLabel());

			return dEdgePart;

		case DEdgeNameEditPart.VISUAL_ID:
			
			// We do not want to enable direct edit on the center label (event list) of a Transition.
			DEdgeNameEditPart dEdgeCentralPart = new DEdgeNameEditPart(view) {

				@Override
				protected boolean isDirectEditEnabled() {
					return false;
				}
			};

			return dEdgeCentralPart;
		}

		return null;
	}

	@Override
	public boolean provides(IOperation operation) {
		if (operation instanceof CreateGraphicEditPartOperation) {
			View view = ((IEditPartOperation) operation).getView();
			
			if (view.getElement() instanceof DSemanticDecorator) {
				
				if (((DSemanticDecorator) view.getElement()).getTarget() instanceof Transition) {
					switch (SiriusVisualIDRegistry.getVisualID(view)) {

					case DEdgeBeginNameEditPart.VISUAL_ID:
						return true;
						
					case DEdgeNameEditPart.VISUAL_ID:
						return true;
					}
				}
			}
		}
		return false;
	}
}
