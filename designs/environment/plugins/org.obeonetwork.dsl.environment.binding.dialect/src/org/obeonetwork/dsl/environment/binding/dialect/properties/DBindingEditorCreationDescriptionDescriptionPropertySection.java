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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.obeonetwork.dsl.environment.bindingdialect.description.DescriptionPackage;

import org.eclipse.sirius.editor.editorPlugin.SiriusEditor;
import org.eclipse.sirius.editor.properties.sections.common.AbstractComboPropertySection;

/**
 * @author sthibaudeau
 *
 */
public class DBindingEditorCreationDescriptionDescriptionPropertySection extends AbstractComboPropertySection {
	    /**
	     * @see org.eclipse.sirius.viewpoint.tree.editor.properties.sections.AbstractComboPropertySection#getDefaultLabelText()
	     */
	    protected String getDefaultLabelText() {
	        return "DBindingEditorDescription"; //$NON-NLS-1$
	    }

	    /**
	     * @see org.eclipse.sirius.viewpoint.tree.editor.properties.sections.AbstractComboPropertySection#getLabelText()
	     */
	    protected String getLabelText() {
	        String labelText;
	        labelText = super.getLabelText() + "*:"; //$NON-NLS-1$
	        return labelText;
	    }

	    /**
	     * @see org.eclipse.sirius.viewpoint.tree.editor.properties.sections.AbstractComboPropertySection#getFeature()
	     */
	    protected EReference getFeature() {
	        return DescriptionPackage.eINSTANCE.getDBindingEditorCreationDescription_Description();
	    }

	    /**
	     * @see org.eclipse.sirius.viewpoint.tree.editor.properties.sections.AbstractComboPropertySection#getFeatureValue(int)
	     */
	    protected Object getFeatureValue(int index) {
	        return getFeatureValueAt(index);
	    }

	    /**
	     * @see org.eclipse.sirius.viewpoint.tree.editor.properties.sections.AbstractComboPropertySection#isEqual(int)
	     */
	    protected boolean isEqual(int index) {
	        boolean isEqual = false;
	        if (getFeatureValueAt(index) == null)
	            isEqual = eObject.eGet(getFeature()) == null;
	        else
	            isEqual = getFeatureValueAt(index).equals(eObject.eGet(getFeature()));
	        return isEqual;
	    }

	    /**
	     * Returns the value at the specified index in the choice of values for the
	     * feature.
	     * 
	     * @param index
	     *            Index of the value.
	     * @return the value at the specified index in the choice of values.
	     */
	    protected Object getFeatureValueAt(int index) {
	        List values = getChoiceOfValues();
	        if (values.size() < index || values.size() == 0 || index == -1) {
	            return null;
	        }
	        return values.get(index);
	    }

	    /**
	     * Fetches the list of available values for the feature.
	     * 
	     * @return The list of available values for the feature.
	     */
	    protected List getChoiceOfValues() {
	        List values = Collections.emptyList();
	        List<IItemPropertyDescriptor> propertyDescriptors = getDescriptors();
	        for (Iterator iterator = propertyDescriptors.iterator(); iterator.hasNext();) {
	            IItemPropertyDescriptor propertyDescriptor = (IItemPropertyDescriptor) iterator.next();
	            if (((EStructuralFeature) propertyDescriptor.getFeature(eObject)) == getFeature())
	                values = new ArrayList(propertyDescriptor.getChoiceOfValues(eObject));
	        }
	        return values;
	    }

	    /**
	     * {@inheritDoc}
	     */
	    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
	        super.createControls(parent, tabbedPropertySheetPage);
	        nameLabel.setFont(SiriusEditor.getFontRegistry().get("required"));
	    }
}
