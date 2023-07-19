/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.is.handlers;

import java.lang.annotation.Annotation;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.ui.handlers.HandlerUtil;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.design.services.ReferencesService;

import org.obeonetwork.is.design.services.AnnotationServices;
import org.obeonetwork.is.propertyTesters.ReferencePropertyTester;

/**
 * Handler for setting the TargetSchema of References based on the namespace it is contained in.
 * 
 * @author Obeo
 */
public class SetTargetSchemaHandler extends AbstractHandler {

	private static final AnnotationServices ANNOTATION_SERVICES = new AnnotationServices();
	
	/**
	 * <pre>Selection is a Bi-directionnal reference with NN multiplicity</pre>
	 * This check shall be performed with {@link ReferencePropertyTester} and {@link DSemanticDecoratorPropertyTester}.
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		DSemanticDecorator decorator = (DSemanticDecorator) ((StructuredSelection) selection).getFirstElement();
		
		if (decorator.getTarget() instanceof Reference) {
			Reference reference = (Reference) decorator.getTarget();		
			String qualifiedName = ReferencesService.getNamespaceQualifiedName(reference); 
			
			if (qualifiedName.equals(ANNOTATION_SERVICES.getPhysicalTarget(reference))) {
				// Physical Target is already defined: we swap with the OpposedReference namespace			
				qualifiedName = ReferencesService.getNamespaceQualifiedName(reference.getOppositeOf());
			}
			
			setPhysicalTarget(reference, qualifiedName);	
		}
		
		return null;
	}

	/**
	 * Sets the physical target {@link Annotation} of the {@link Reference}.
	 * It is based on the {@link Namespace} of the {@link StructuredType} the {@link Reference} belongs to.
	 * @param reference a {@link Reference}
	 * @param physicalTarget a {@link String}
	 */
	private void setPhysicalTarget(Reference reference, String physicalTarget) {
		TransactionalEditingDomain domain = new EObjectQuery(reference).getSession().getTransactionalEditingDomain();

	    domain.getCommandStack().execute(new RecordingCommand(domain) {
	        @Override
	        protected void doExecute() {
	        	ANNOTATION_SERVICES.setPhysicalTarget(reference, physicalTarget);
	    		ANNOTATION_SERVICES.setPhysicalTarget(reference.getOppositeOf(), physicalTarget);
	        }
	    });
	}
}
