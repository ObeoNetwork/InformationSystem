/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.is.ui.wizards;

import org.eclipse.sirius.business.api.modelingproject.ModelingProject;

public class NewModelWizardData {

	private ModelingProject targetModelingProject;
	private Object targetContainer;
	private String targetResourceName;
	
	public ModelingProject getTargetModelingProject() {
		return targetModelingProject;
	}

	public void setTargetModelingProject(ModelingProject targetModelingProject) {
		this.targetModelingProject = targetModelingProject;
	}

	public Object getTargetContainer() {
		return targetContainer;
	}

	public void setTargetContainer(Object targetContainer) {
		this.targetContainer = targetContainer;
	}

	public String getTargetResourceName() {
		return targetResourceName;
	}

	public void setTargetResourceName(String targetResourceName) {
		this.targetResourceName = targetResourceName;
	}
	
}
