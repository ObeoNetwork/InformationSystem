/**
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.tools.projectlibrary.ui.wizard.exp;

import java.util.List;

import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.obeonetwork.dsl.manifest.MManifest;
import org.obeonetwork.tools.projectlibrary.extension.ManifestServices;

/**
 * Model class holding contents for "Export modeling project as a library" wizard
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
public class ExportProjectAsLibraryWizardModel {

	private List<ModelingProject> modelingProjects;
	private ModelingProject selectedModelingProject;
	private String projectId;
	private String version;
	private List<MManifest> previousVersions;
	private String comment;
	private String filePath;
	
	public ModelingProject getSelectedModelingProject() {
		return selectedModelingProject;
	}

	public void setSelectedModelingProject(ModelingProject selectedModelingProject) {
		this.selectedModelingProject = selectedModelingProject;
		// Initialize values for other fields
		if (selectedModelingProject != null) {
			Session session = selectedModelingProject.getSession();
			List<MManifest> previousManifests = new ManifestServices().getExportedManifests(session);
			String projectId = selectedModelingProject.getProject().getName();
			if (!previousManifests.isEmpty()) {
				projectId = previousManifests.get(previousManifests.size() - 1).getProjectId();
			}
			setProjectId(projectId);
			setPreviousVersions(previousManifests);
		}
	}

	public List<ModelingProject> getModelingProjects() {
		return modelingProjects;
	}
	
	public void setModelingProjects(List<ModelingProject> modelingProjects) {
		this.modelingProjects = modelingProjects;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<MManifest> getPreviousVersions() {
		return previousVersions;
	}

	public void setPreviousVersions(List<MManifest> previousVersions) {
		this.previousVersions = previousVersions;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
