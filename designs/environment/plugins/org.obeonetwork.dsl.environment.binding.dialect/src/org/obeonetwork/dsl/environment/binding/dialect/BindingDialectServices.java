/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.binding.dialect;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.obeonetwork.dsl.environment.bindingdialect.BindingdialectFactory;
import org.obeonetwork.dsl.environment.bindingdialect.DBindingEditor;
import org.obeonetwork.dsl.environment.bindingdialect.description.DBindingEditorDescription;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.business.api.dialect.AbstractRepresentationDialectServices;
import org.eclipse.sirius.business.api.dialect.description.IInterpretedExpressionQuery;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.RepresentationExtensionDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;

/**
 * Class to provide Binding dialect services
 * @author Stephane Thibaudeau <stephane.thibaudeau@obeo.fr>
 *
 */
public class BindingDialectServices extends AbstractRepresentationDialectServices {


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.viewpoint.business.api.dialect.AbstractRepresentationDialectServices#isSupported(org.eclipse.sirius.viewpoint.DRepresentation)
	 */
	@Override
	protected boolean isSupported(DRepresentation representation) {
		return representation instanceof DBindingEditor;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.viewpoint.business.api.dialect.AbstractRepresentationDialectServices#isSupported(org.eclipse.sirius.viewpoint.description.RepresentationDescription)
	 */
	@Override
	protected boolean isSupported(RepresentationDescription representationDesc) {
		return representationDesc instanceof DBindingEditorDescription;
	}
	
	protected boolean isSupported(RepresentationExtensionDescription representationDesc){
		return representationDesc instanceof DBindingEditorDescription;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.viewpoint.business.api.dialect.DialectServices#getDescription(org.eclipse.sirius.viewpoint.DRepresentation)
	 */
	public RepresentationDescription getDescription(DRepresentation representation) {
        if (isSupported(representation)) {
            return ((DBindingEditor) representation).getDescription();
        } else {
            return null;
        }
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.viewpoint.business.api.dialect.DialectServices#canCreate(org.eclipse.emf.ecore.EObject, org.eclipse.sirius.viewpoint.description.RepresentationDescription)
	 */
	public boolean canCreate(EObject semantic, RepresentationDescription representationDesc) {
		boolean result = false;
		if (semantic != null && isSupported(representationDesc)) {
			// TODO Check the domain class when it will be possible to specify it as a parameter in odesign
			// TODO Check preconditions too and so on
			result = "BindingInfo".equals(semantic.eClass().getName());
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.viewpoint.business.api.dialect.DialectServices#createRepresentation(java.lang.String, org.eclipse.emf.ecore.EObject, org.eclipse.sirius.viewpoint.description.RepresentationDescription, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public DRepresentation createRepresentation(String name, EObject semantic, RepresentationDescription description, IProgressMonitor monitor) {
//		ensureDescriptionResourceInMainResourceSet(description);
		
		DBindingEditor editor = BindingdialectFactory.eINSTANCE.createDBindingEditor();
		editor.setName(name);
		editor.setDescription((DBindingEditorDescription)description);
		editor.setTarget(semantic);
		
		refresh(editor, monitor);
		
		return editor;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.viewpoint.business.api.dialect.DialectServices#refresh(org.eclipse.sirius.viewpoint.DRepresentation, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void refresh(DRepresentation representation, IProgressMonitor monitor) {
		if (canRefresh(representation)) {
			refreshEditor((DBindingEditor)representation, monitor);
		}
	}
	
	/**
	 * Refreshes an editor
	 * @param editor Editor to refresh
	 * @param monitor Progress monitor
	 */
	private void refreshEditor(DBindingEditor editor, IProgressMonitor monitor) {
		// TODO implement refresh
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.viewpoint.business.api.dialect.DialectServices#initRepresentations(org.eclipse.sirius.viewpoint.description.Viewpoint, org.eclipse.emf.ecore.EObject)
	 */
	public void initRepresentations(Viewpoint viewpoint, EObject semantic) {
	}

	
	
	protected <T extends RepresentationDescription> void initRepresentationForElement(T representationDescription, EObject semanticElement) {
		
	}
	
	protected <T extends RepresentationDescription> void initRepresentationForElement(T representationDescription, EObject semanticElement, IProgressMonitor monitor) {
		
	}

	public IInterpretedExpressionQuery createInterpretedExpressionQuery(EObject arg0, EStructuralFeature arg1) {
		return null;
	}

	public boolean handles(RepresentationDescription description) {
		return isSupported(description);
	}

	public void initRepresentations(Viewpoint vp, EObject semantic,	IProgressMonitor monitor) {
		
	}

	
	public void refresh(DRepresentation representation, boolean fullRefresh,
			IProgressMonitor monitor) {
		if (canRefresh(representation)) {
			refreshEditor((DBindingEditor)representation, monitor);
		}
		
	}

	
	public boolean handles(
			RepresentationExtensionDescription representationExtensionDescription) {
		return isSupported(representationExtensionDescription);	
	}
	
}
