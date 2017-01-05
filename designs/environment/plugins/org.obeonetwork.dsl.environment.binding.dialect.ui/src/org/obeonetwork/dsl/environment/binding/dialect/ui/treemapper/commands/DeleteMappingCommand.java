/*******************************************************************************
 * Copyright (c) 2011, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.commands;

import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.obeonetwork.dsl.environment.BindingElement;
import org.obeonetwork.dsl.environment.BindingReference;
import org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge;

import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.ecore.extender.business.api.accessor.ModelAccessor;

public class DeleteMappingCommand extends RecordingCommand {

	private DBindingEdge bindingEdge = null;
	private ModelAccessor accessor;
	
	public DeleteMappingCommand(TransactionalEditingDomain domain, ModelAccessor accessor, DBindingEdge bindingEdge) {
		super(domain, "Delete mapping");
		this.bindingEdge = bindingEdge;
		this.accessor = accessor;
	}

	@Override
	protected void doExecute() {
		if (bindingEdge.getTarget() != null && bindingEdge.getTarget() instanceof BindingReference) {
			
			BindingReference bindingReference = (BindingReference)bindingEdge.getTarget();
			Session session = SessionManager.INSTANCE.getSession(bindingReference);
			ECrossReferenceAdapter crossReferencer = session.getSemanticCrossReferencer();
			
			BindingElement left = bindingReference.getLeft();
			BindingElement right = bindingReference.getRight();
			if (hasNoOtherReference(left)) {
				// Delete the useless element
				accessor.eDelete(left, crossReferencer);
			}
			if (hasNoOtherReference(right)) {
				// Delete the useless element
				accessor.eDelete(right, crossReferencer);
			} else {
				
			}
			accessor.eDelete(bindingReference, crossReferencer);
			accessor.eDelete(bindingEdge, crossReferencer);
			bindingEdge.setLeft(null);
			bindingEdge.setRight(null);
		} else {
			EcoreUtil.delete(bindingEdge);
			bindingEdge.setLeft(null);
			bindingEdge.setRight(null);
		}
	}
	
	
	private boolean hasNoOtherReference(BindingElement bindingElement) {
		return bindingElement.getReferencedBy().size() <= 1;
	}
}
