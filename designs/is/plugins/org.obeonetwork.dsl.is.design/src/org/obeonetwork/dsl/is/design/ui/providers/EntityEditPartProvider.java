package org.obeonetwork.dsl.is.design.ui.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.is.design.service.EntityService;

import fr.obeo.dsl.viewpoint.DSemanticDecorator;
import fr.obeo.dsl.viewpoint.diagram.internal.edit.parts.DEdgeBeginNameEditPart;
import fr.obeo.dsl.viewpoint.diagram.internal.edit.parts.DEdgeEndNameEditPart;
import fr.obeo.dsl.viewpoint.diagram.part.ViewpointVisualIDRegistry;
import fr.obeo.dsl.viewpoint.diagram.tools.api.command.GMFCommandWrapper;

public class EntityEditPartProvider extends AbstractEditPartProvider {
	
	@Override
	public IGraphicalEditPart createGraphicEditPart(View view) {
		switch (ViewpointVisualIDRegistry.getVisualID(view)) {

		case DEdgeBeginNameEditPart.VISUAL_ID:
			DEdgeBeginNameEditPart dEdgePart = new DEdgeBeginNameEditPart(view) {

				@Override
				protected boolean isDirectEditEnabled() {
					return true;
				}

			};
			dEdgePart.installEditPolicy(org.eclipse.gef.RequestConstants.REQ_DIRECT_EDIT, new EntityDirectEditForBeginRole());
			return dEdgePart;

		case DEdgeEndNameEditPart.VISUAL_ID:
			DEdgeEndNameEditPart dEdgeEndPart = new DEdgeEndNameEditPart(view) {
				@Override
				protected boolean isDirectEditEnabled() {
					return true;
				}

			};
			dEdgeEndPart.installEditPolicy(org.eclipse.gef.RequestConstants.REQ_DIRECT_EDIT, new EntityDirectEditForEndRole());
			return dEdgeEndPart;
		}
		return null;
	}

	@Override
	public boolean provides(IOperation operation) {
		if (operation instanceof CreateGraphicEditPartOperation) {
			View view = ((IEditPartOperation)operation).getView();
			if (view.getElement() instanceof DSemanticDecorator) {
				if (((DSemanticDecorator)view.getElement()).getTarget() instanceof Reference) {
					switch (ViewpointVisualIDRegistry.getVisualID(view)) {

						case DEdgeBeginNameEditPart.VISUAL_ID:
							return true;

						case DEdgeEndNameEditPart.VISUAL_ID:
							return true;
					}
				}
			}

		}
		return false;
	}
	
	class EntityDirectEditForBeginRole extends LabelDirectEditPolicy {

		protected org.eclipse.gef.commands.Command getDirectEditCommand(org.eclipse.gef.requests.DirectEditRequest edit) {
			final EObject element = ((org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart)getHost()).resolveSemanticElement();
			final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(element);
			final String labelText = (String)edit.getCellEditor().getValue();
			RecordingCommand cmd = new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					if (element instanceof DSemanticDecorator) {
						EObject target = ((DSemanticDecorator)element).getTarget();
						if (target instanceof Reference) {
							Reference reference = (Reference)target;
							Reference oppositeReference =reference.getOppositeOf();
							if (oppositeReference != null) {
								String name = EntityService.getReferenceNameFromString(oppositeReference, labelText);
								MultiplicityKind multiplicity = EntityService.getMultiplicityKindFromString(oppositeReference, labelText);
								oppositeReference.setName(name);
								oppositeReference.setMultiplicity(multiplicity);
							}
						}
					}
				}
			};
			return new ICommandProxy(new GMFCommandWrapper(domain, cmd));

		};

	}
	
	class EntityDirectEditForEndRole extends LabelDirectEditPolicy {

		protected org.eclipse.gef.commands.Command getDirectEditCommand(org.eclipse.gef.requests.DirectEditRequest edit) {
			final EObject element = ((org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart)getHost()).resolveSemanticElement();
			final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(element);
			final String labelText = (String)edit.getCellEditor().getValue();
			RecordingCommand cmd = new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					if (element instanceof DSemanticDecorator) {
						EObject target = ((DSemanticDecorator)element).getTarget();
						if (target instanceof Reference) {
							Reference reference = (Reference)target;
							String name = EntityService.getReferenceNameFromString(reference, labelText);
							MultiplicityKind multiplicity = EntityService.getMultiplicityKindFromString(reference, labelText);
							reference.setName(name);
							reference.setMultiplicity(multiplicity);
						}
					}
				}
			};
			return new ICommandProxy(new GMFCommandWrapper(domain, cmd));

		};

	}
}
