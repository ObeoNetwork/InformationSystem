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
package org.obeonetwork.dsl.environment.binding.dialect.properties;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.obeonetwork.dsl.environment.bindingdialect.description.DBindingEditorCreationDescription;
import org.obeonetwork.dsl.environment.bindingdialect.description.DescriptionPackage;

import org.eclipse.sirius.editor.properties.filters.common.ViewpointPropertyFilter;

/**
 * @author sthibaudeau
 *
 */
public class DBindingEditorCreationDescriptionDescriptionFilter extends ViewpointPropertyFilter {

    /**
     * {@inheritDoc}
     */
    protected EStructuralFeature getFeature() {
        return DescriptionPackage.eINSTANCE.getDBindingEditorCreationDescription_Description();
    }

    /**
     * {@inheritDoc}
     */
    protected boolean isRightInputType(Object arg0) {
        return arg0 instanceof DBindingEditorCreationDescription;
    }

}
