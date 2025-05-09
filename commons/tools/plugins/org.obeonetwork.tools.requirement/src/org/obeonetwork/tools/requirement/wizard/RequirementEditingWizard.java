/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package org.obeonetwork.tools.requirement.wizard;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.ui.wizards.PropertiesEditionWizard;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.tools.requirement.wizard.page.CategorySelectionPage;

/**
 * @author Obeo
 *
 */
public class RequirementEditingWizard extends PropertiesEditionWizard {

	private CategorySelectionPage page;

	public RequirementEditingWizard(PropertiesEditingContext editionContext, AdapterFactory adapterFactory,
			EObject eObject) {
		super(editionContext, adapterFactory, eObject);
	}

	public RequirementEditingWizard(PropertiesEditingContext editingContext, AdapterFactory adapterFactory,
			EReference eReference) {
		super(editingContext, adapterFactory, eReference);
	}

	@Override
	public void addPages() {
		page = new CategorySelectionPage();
		page.init(eObject.eContainer());
		super.addPages();
		addPage(page);
	}

	public Category getOwningCategory() {
		return (Category) page.getSelection();
	}
}
