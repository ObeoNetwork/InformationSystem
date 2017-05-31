/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.database.ui.wizards.scaffolding.newmodel;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.entity.Root;
import org.obeonetwork.dsl.entity.presentation.EntityModelWizard;

public class EnhancedEntityModelWizard extends EntityModelWizard implements INewModelWizard {
	private IFile createdFile = null;
	
	@Override
	public boolean performFinish() {
		createdFile = getModelFile();
		return super.performFinish();
	}

	public IFile getCreatedFile() {
		return createdFile;
	}

	@Override
	protected EObject createInitialModel() {
		Root rootObject = entityFactory.createRoot();
		return rootObject;
	}
	
	
}
