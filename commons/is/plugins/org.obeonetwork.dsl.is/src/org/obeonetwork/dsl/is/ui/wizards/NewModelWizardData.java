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
