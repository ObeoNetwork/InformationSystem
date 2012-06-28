/*******************************************************************************
 * Copyright (c) 2009-2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.viewpoint.eef.adapters;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.api.adapters.SemanticAdapter;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Edge;
import org.obeonetwork.dsl.viewpoint.eef.util.VPDecoratorHelper;

import fr.obeo.dsl.viewpoint.DSemanticDecorator;

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class ObeoDesignerSemanticAdapter implements IAdapterFactory {

	/** The types list */
	private static final Class<?>[] types = { SemanticAdapter.class, };

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object,
	 *      java.lang.Class)
	 */
	public Object getAdapter(final Object adaptableObject,
			@SuppressWarnings("rawtypes") final Class adapterType) {
		Object adapter = null;
		// if Object comes from GMF
		if ((adaptableObject != null) && (adapterType == SemanticAdapter.class)) {
			EObject semanticElement = null;
			if (adaptableObject instanceof GraphicalEditPart) {
				semanticElement = ((GraphicalEditPart) adaptableObject)
						.resolveSemanticElement();
			} else if (adaptableObject instanceof ConnectionEditPart) {
				semanticElement = ((Edge) ((ConnectionEditPart) adaptableObject)
						.getModel()).getElement();
			} else if (adaptableObject instanceof DSemanticDecorator) {
				semanticElement = ((DSemanticDecorator) adaptableObject)
						.getTarget();
			}
			if (semanticElement != null) {
				VPDecoratorHelper helper = new VPDecoratorHelper(
						semanticElement);
				if (helper.canAdapt()) {
					return helper.createSemanticAdapterFromDSemanticDecorator();
				}
			}
		}
		return adapter;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapterList()
	 */
	public Class<?>[] getAdapterList() {
		return types;
	}

}
