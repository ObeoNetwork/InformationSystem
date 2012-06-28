///*******************************************************************************
// * Copyright (c) 2009-2010 Obeo.
// * All rights reserved. This program and the accompanying materials
// * are made available under the terms of the Eclipse Public License v1.0
// * which accompanies this distribution, and is available at
// * http://www.eclipse.org/legal/epl-v10.html
// * 
// * Contributors:
// *     Obeo - initial API and implementation
// *******************************************************************************/
//package org.obeonetwork.dsl.is.design.ui.editpolicies;
//
//import org.eclipse.core.runtime.NullProgressMonitor;
//import org.eclipse.emf.ecore.EObject;
//import org.eclipse.emf.edit.domain.EditingDomain;
//import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
//import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
//import org.eclipse.emf.eef.runtime.impl.policies.DomainPropertiesEditionContext;
//import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
//import org.eclipse.emf.transaction.RecordingCommand;
//import org.eclipse.emf.transaction.TransactionalEditingDomain;
//import org.eclipse.gef.Request;
//import org.eclipse.gef.commands.Command;
//import org.eclipse.gef.commands.CompoundCommand;
//import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
//
//import fr.obeo.dsl.viewpoint.DDiagram;
//import fr.obeo.dsl.viewpoint.DDiagramElement;
//import fr.obeo.dsl.viewpoint.business.api.dialect.DialectManager;
//import fr.obeo.dsl.viewpoint.business.api.helper.ViewPointHelper;
//
///**
// * 
// * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
// */
//public class OpenEditPolicy extends
//		org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy {
//
//	@Override
//	protected Command getOpenCommand(Request request) {					
//		if (isDDiagramElement()) {
//			DDiagramElement diagramElement = getDDiagramElement();
//			EObject modelElement = diagramElement.getTarget();
//			if (modelElement != null) {
//				IGraphicalEditPart editPart = (IGraphicalEditPart) super.getHost();
//				TransactionalEditingDomain editingDomain = editPart.getEditingDomain();					
//				return createEditingCommand(editingDomain, modelElement);
//			}			
//		}
//		return null;
//	}
//	
//	private Command createEditingCommand(EditingDomain editingDomain, EObject modelElement){
//		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(modelElement);
//		if (policyProvider != null) {
//			IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(modelElement);
//			if (editionPolicy != null) {
//				org.eclipse.emf.common.command.Command propertiesEditionCommand = editionPolicy.getPropertiesEditionCommand(new DomainPropertiesEditionContext(null,editingDomain, modelElement));
//				if(propertiesEditionCommand!=null){					
//					CompoundCommand compoundCommand = new CompoundCommand();					
//					compoundCommand.add(new EMFtoGEFCommandWrapper(propertiesEditionCommand));
////					if (isDDiagramElement()) {
////						DDiagramElement diagramElement = getDDiagramElement();
////						final DDiagram diagram = ViewPointHelper.getParentDiagram(diagramElement);												
////						compoundCommand.add(new EMFtoGEFCommandWrapper(new RecordingCommand((TransactionalEditingDomain) editingDomain){
////							@Override
////							protected void doExecute() {
////								DialectManager.INSTANCE.refresh(diagram, new NullProgressMonitor());								
////							}
////						}));
////					}										
//					return compoundCommand;
//				}
//			}
//		}
//		return null;
//	}
//	
//	private boolean isDDiagramElement(){
//		if (super.getHost() instanceof IGraphicalEditPart) {
//			IGraphicalEditPart editPart = (IGraphicalEditPart) super.getHost();
//			EObject model = editPart.resolveSemanticElement();
//			if (model instanceof DDiagramElement) {
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	private DDiagramElement getDDiagramElement(){
//		if (isDDiagramElement()) {
//			IGraphicalEditPart editPart = (IGraphicalEditPart) super.getHost();			
//			DDiagramElement diagramElement = (DDiagramElement) editPart.resolveSemanticElement();
//			return diagramElement;
//		}
//		return null;
//	}
//
//	
//}
