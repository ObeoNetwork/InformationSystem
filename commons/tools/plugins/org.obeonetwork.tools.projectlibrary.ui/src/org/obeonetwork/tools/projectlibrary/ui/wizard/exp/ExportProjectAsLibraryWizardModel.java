/**
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.tools.projectlibrary.ui.wizard.exp;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.obeonetwork.dsl.manifest.MManifest;
import org.obeonetwork.tools.projectlibrary.extension.ManifestServices;
import org.obeonetwork.tools.projectlibrary.util.ProjectLibraryUtils;

/**
 * Model class holding contents for "Export modeling project as a library" wizard
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
public class ExportProjectAsLibraryWizardModel {

	private List<ModelingProject> modelingProjects;
	private ModelingProject selectedModelingProject;
	private Set<ModelingProject> referencingModelingProjects;
	private String projectId;
	private String version;
	private List<MManifest> previousVersions;
	private String comment;
	private String exportDirectory;
	private String marFileName;
	private boolean isSelectedModelingProjectHasDependencies;
	
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	
	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	public ModelingProject getSelectedModelingProject() {
		return selectedModelingProject;
	}

	public void setSelectedModelingProject(ModelingProject selectedModelingProject) {
		if(!Objects.equals(this.selectedModelingProject, selectedModelingProject)) {
			propertyChangeSupport.firePropertyChange("selectedModelingProject", this.selectedModelingProject, this.selectedModelingProject = selectedModelingProject); //$NON-NLS-1$
			// Initialize values for other fields
			if (selectedModelingProject != null) {
				ProjectLibraryUtils projectLibraryUtils = new ProjectLibraryUtils();
				Set<IProject> referencedProjects = projectLibraryUtils.getReferencedProjects(selectedModelingProject);
				setIsSelectedModelingProjectHasDependencies(!referencedProjects.isEmpty());
				
				Set<ModelingProject> referencingModelingProjects = projectLibraryUtils.getReferencingProjects(selectedModelingProject);
				setReferencingModelingProjects(referencingModelingProjects);

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
	}

	public List<ModelingProject> getModelingProjects() {
		return modelingProjects;
	}
	
	public void setModelingProjects(List<ModelingProject> modelingProjects) {
		if(!Objects.equals(this.modelingProjects, modelingProjects)) 
			propertyChangeSupport.firePropertyChange("modelingProjects", this.modelingProjects, this.modelingProjects = modelingProjects); //$NON-NLS-1$
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		if(!Objects.equals(this.projectId, projectId))
			propertyChangeSupport.firePropertyChange("projectId", this.projectId, this.projectId = projectId); //$NON-NLS-1$
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		if(!Objects.equals(this.version, version))
			propertyChangeSupport.firePropertyChange("version", this.version, this.version = version); //$NON-NLS-1$
	}

	public List<MManifest> getPreviousVersions() {
		return previousVersions;
	}

	public void setPreviousVersions(List<MManifest> previousVersions) {
		if(!Objects.equals(this.previousVersions, previousVersions))
			propertyChangeSupport.firePropertyChange("previousVersions", this.previousVersions, this.previousVersions = previousVersions); //$NON-NLS-1$
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		if(!Objects.equals(this.comment, comment)) 
			propertyChangeSupport.firePropertyChange("comment", this.comment, this.comment = comment); //$NON-NLS-1$
	}

	public String getExportDirectory() {
		return exportDirectory;
	}

	public void setExportDirectory(String exportDirectory) {
		if(!Objects.equals(this.exportDirectory, exportDirectory))
			propertyChangeSupport.firePropertyChange("exportDirectory", this.exportDirectory, this.exportDirectory = exportDirectory); //$NON-NLS-1$
	}
	
	public String getMarFileName() {
		return marFileName;
	}

	public void setMarFileName(String marFileName) {
		if(!Objects.equals(this.marFileName, marFileName)) 
			propertyChangeSupport.firePropertyChange("marFileName", this.marFileName, this.marFileName = marFileName); //$NON-NLS-1$
	}
	
	public void setReferencingModelingProjects(Set<ModelingProject> referencedModelingProjects) {
		if(!Objects.equals(this.referencingModelingProjects, referencedModelingProjects)) 
			propertyChangeSupport.firePropertyChange("referencedModelingProjects", this.referencingModelingProjects, this.referencingModelingProjects = referencedModelingProjects); //$NON-NLS-1$
	}
	
	public Set<ModelingProject> getReferencingModelingProjects() {
		if(referencingModelingProjects == null) {
			this.referencingModelingProjects = new HashSet<>();
		}
		return referencingModelingProjects;
	}
	public void setIsSelectedModelingProjectHasDependencies(boolean newValue) {
		if(this.isSelectedModelingProjectHasDependencies != newValue)
			propertyChangeSupport.firePropertyChange("isSelectedModelingProjectHasDependencies", this.isSelectedModelingProjectHasDependencies, this.isSelectedModelingProjectHasDependencies = newValue); //$NON-NLS-1$
	}
	
	public boolean getIsSelectedModelingProjectHasDependencies() {
		return this.isSelectedModelingProjectHasDependencies;
	}

}
