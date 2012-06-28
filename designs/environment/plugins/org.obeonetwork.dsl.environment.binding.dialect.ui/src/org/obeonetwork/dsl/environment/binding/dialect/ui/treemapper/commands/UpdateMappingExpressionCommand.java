package org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import fr.obeo.dsl.viewpoint.ViewpointPlugin;
import fr.obeo.mda.ecore.extender.business.api.accessor.ModelAccessor;

public class UpdateMappingExpressionCommand extends RecordingCommand {

	private EObject element;
	private String expression;
	private ModelAccessor accessor;
	
	public UpdateMappingExpressionCommand(TransactionalEditingDomain domain, ModelAccessor accessor, EObject element, String expression) {
		super(domain, "Update Mapping expression");
		this.element = element;
		this.accessor = accessor;
		this.expression = expression;
	}

	@Override
	protected void doExecute() {
		if (element == null) {
			return;
		}
		try {
			accessor.eSet(element, "bindingExpression", expression);
		} catch (Exception e) {
			ViewpointPlugin.getDefault().error("Error while modifying model", e);
		}
	}

}
