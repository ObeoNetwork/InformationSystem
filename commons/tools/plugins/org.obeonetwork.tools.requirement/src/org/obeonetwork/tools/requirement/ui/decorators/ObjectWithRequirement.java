/*******************************************************************************
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.requirement.ui.decorators;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.tools.requirement.core.util.RequirementService;

/**
 * An example showing how to control when an element is decorated. This example
 * decorates only elements that are instances of IResource and whose attribute
 * is 'Read-only'.
 * 
 * @see ILightweightLabelDecorator
 */
public class ObjectWithRequirement implements ILightweightLabelDecorator {
	public static final String DECORATOR_ID = "org.obeonetwork.tools.requirement.ui.decorators.ObjectWithRequirement";
	
	private int quadrant = IDecoration.BOTTOM_RIGHT;

	/** The icon image location in the project folder */
	private static final String ICON_PATH = "icons/ObjectWithRequirementDecorator.png"; //NON-NLS-1
	
	private static final URL ICON_URL = FileLocator.find(Platform.getBundle("org.obeonetwork.tools.requirement"), new Path(ICON_PATH), null); //NON-NLS-1
	
	private static final ImageDescriptor DESCRIPTOR = ImageDescriptor.createFromURL(ICON_URL);

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ILightweightLabelDecorator#decorate(java.lang.Object, org.eclipse.jface.viewers.IDecoration)
	 */
	public void decorate(Object element, IDecoration decoration) {
		if (element instanceof EObject && shouldDecorate((EObject)element)) {
			if (DESCRIPTOR != null) {
				decoration.addOverlay(DESCRIPTOR, quadrant);
			}
		}
	}
	
	private boolean shouldDecorate(EObject element) {
		Requirement[] linkedRequirements = RequirementService.getLinkedRequirements(element);
		return linkedRequirements.length > 0;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void addListener(ILabelProviderListener listener) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	public void dispose() {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 */
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void removeListener(ILabelProviderListener listener) {
	}
}