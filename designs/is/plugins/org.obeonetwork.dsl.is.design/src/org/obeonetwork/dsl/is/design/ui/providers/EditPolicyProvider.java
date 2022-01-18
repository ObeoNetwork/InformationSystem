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
package org.obeonetwork.dsl.is.design.ui.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.gmf.runtime.notation.Node;

import org.eclipse.sirius.diagram.DDiagramElement;

/**
 *  
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class EditPolicyProvider implements IEditPolicyProvider{

	public void createEditPolicies(EditPart editPart) {
		//EEF SWT Dialog doesn't fully compliant with OD 4.5.1
		//TODO check EEF SWT Dialog support with the next Obeo Designer release
		//editPart.installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenEditPolicy());
	}

	public boolean provides(IOperation operation) {
		if (operation instanceof CreateEditPoliciesOperation){
			EditPart editPart =((CreateEditPoliciesOperation)operation).getEditPart();
			Object model = editPart.getModel();
			if(model instanceof Node){
				Node node = (Node)model;
				//check DNode, DNodeContainer
				if (node.getElement() instanceof DDiagramElement) {
					DDiagramElement dElement = (DDiagramElement) node.getElement();
					EObject target = dElement.getTarget();
					//System.out.println("DDiagramElement Target : "+target);
					//if(target instanceof NamedElement){
					if(target instanceof EObject){
						return true;
					}
				}
			};
	    }
		return false;
	}
	
	public void removeProviderChangeListener(IProviderChangeListener arg0) {}
	public void addProviderChangeListener(IProviderChangeListener arg0) {}
}
