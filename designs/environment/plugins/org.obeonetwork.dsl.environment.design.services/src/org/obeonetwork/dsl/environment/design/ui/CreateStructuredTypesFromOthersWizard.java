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
package org.obeonetwork.dsl.environment.design.ui;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.wizard.Wizard;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.design.services.TypesServices;

public class CreateStructuredTypesFromOthersWizard extends Wizard {
	
	private TypesServices typesServices = new TypesServices();
	
	private Namespace namespace;
	private String sourceTypeName;
	private String targetTypeName;
	private ChooseTypesAndReferencesPage page;

	private Collection<StructuredType> createdTypes = new ArrayList<StructuredType>();

	public CreateStructuredTypesFromOthersWizard(Namespace namespace, String targetTypeName, String sourceTypeName) {
		String title = "Create " + targetTypeName + " from " + sourceTypeName;
		setWindowTitle(title);
		this.namespace = namespace;
		this.sourceTypeName = sourceTypeName;
		this.targetTypeName = targetTypeName;
	}

	@Override
	public void addPages() {
		page = new ChooseTypesAndReferencesPage(namespace, sourceTypeName);
		addPage(page);
	}

	@Override
	public boolean performFinish() {
		createdTypes = typesServices.createTypesFromOtherTypes(
				namespace,
				page.getCheckedTypes(),
				page.getCheckedReferences(),
				sourceTypeName,
				targetTypeName);
		return !createdTypes.isEmpty();
	}

	public Collection<StructuredType> getCreatedTypes() {
		return createdTypes;
	}

}
