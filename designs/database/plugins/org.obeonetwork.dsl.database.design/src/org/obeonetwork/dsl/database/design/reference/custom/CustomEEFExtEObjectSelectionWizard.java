/*******************************************************************************
 * Copyright (c) 2019 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.design.reference.custom;

import org.eclipse.eef.core.api.EditingContextAdapter;
import org.eclipse.eef.ide.ui.ext.widgets.reference.internal.EEFExtEObjectSelectionWizard;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.wizard.IWizard;

@SuppressWarnings("restriction")
public class CustomEEFExtEObjectSelectionWizard extends EEFExtEObjectSelectionWizard implements IWizard {

	private EObject target;
	private EReference eReference;
	private EditingContextAdapter editingContextAdapter;
	private CustomEEFExtEObjectSelectionPage eObjectSelectionPage;

	public CustomEEFExtEObjectSelectionWizard(EObject target, EReference eReference,
			EditingContextAdapter editingContextAdapter) {
		super(target, eReference, editingContextAdapter);
		this.target = target;
		this.eReference = eReference;
		this.editingContextAdapter = editingContextAdapter;
	}
	
	@Override
	public void addPages() {
		this.eObjectSelectionPage = new CustomEEFExtEObjectSelectionPage(this.target, this.eReference, this.editingContextAdapter);
		this.addPage(this.eObjectSelectionPage);
	}
	
	public EList<?> getResult() {
		BasicEList<Object> result = new BasicEList<Object>();
		
		EObject selectedEObject = this.eObjectSelectionPage.getSelectedEObject();
		if (selectedEObject != null) {
			result.add(selectedEObject);			
		}
		return result;
	}
}
