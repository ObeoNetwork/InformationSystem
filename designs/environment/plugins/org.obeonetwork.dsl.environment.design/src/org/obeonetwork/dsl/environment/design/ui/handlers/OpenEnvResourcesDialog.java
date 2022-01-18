/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.design.ui.handlers;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.tools.api.command.semantic.AddSemanticResourceCommand;
import org.eclipse.sirius.tools.api.command.semantic.RemoveSemanticResourceCommand;
import org.eclipse.sirius.ui.tools.api.views.common.item.ProjectDependenciesItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.obeonetwork.dsl.environment.Environment;
import org.obeonetwork.dsl.environment.design.internal.EnvironmentRow;
import org.obeonetwork.dsl.environment.design.internal.commands.UnsetCrossReferenceCommand;
import org.obeonetwork.dsl.environment.design.ui.dialog.EnvironmentResourcesDialog;
import org.obeonetwork.dsl.environment.design.ui.dialog.EnvironmentUsedElementResourceWarning;
import org.obeonetwork.dsl.environment.util.ProvidedModelsService;

public class OpenEnvResourcesDialog extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell shell = HandlerUtil.getActiveShell(event);
		OpenEnvResourceDialogContext context = new OpenEnvResourceDialogContext();
		context.handleExecutionEvent(event);
		if (!context.isWellInitialized()) {
			return null;
		}
		
		ModelingProject project = context.getModelingProject();
		Session session = context.getSession();
		
		List<EnvironmentRow> environmentRows = getAllEnvironmentResources(session);
		List<EnvironmentRow> selectedEnvironmentRows = environmentRows.stream().filter(env -> env.selected).collect(toList());
		List<EnvironmentRow> nonSelectedEnvironmentRows = environmentRows.stream().filter(env -> !env.selected).collect(toList());
		
		selectedEnvironmentRows.sort((er1, er2) -> er1.name.compareTo(er2.name));
		nonSelectedEnvironmentRows.sort((er1, er2) -> er1.name.compareTo(er2.name));
		
		List<EnvironmentRow> sortedEnvironmentRows = new ArrayList<>();
		sortedEnvironmentRows.addAll(selectedEnvironmentRows);
		sortedEnvironmentRows.addAll(nonSelectedEnvironmentRows);
		
		// Display the dialog allowing to choose environment resource in the project.
		EnvironmentResourcesDialog dialog = new EnvironmentResourcesDialog(shell, sortedEnvironmentRows, project.getProject().getName());
		if (Window.OK == dialog.open()) {
			TransactionalEditingDomain ted = session.getTransactionalEditingDomain();
			if (ted == null) {
				return null;
			}
			List<EnvironmentRow> newEnvironmentRows = dialog.getEnvironmentRows();
			CompoundCommand globalCommand = new CompoundCommand();
			for (EnvironmentRow row : newEnvironmentRows) {
				// For every environment resources we compare the state before and after the dialog
				if (row.selected && nonSelectedEnvironmentRows.contains(row)) {
					// The environment resource has been selected when the dialog was opened
					AddSemanticResourceCommand addSemanticResourceCommand = new AddSemanticResourceCommand(session, URI.createURI(row.uri), new NullProgressMonitor());
					globalCommand.append(addSemanticResourceCommand);
				} else if (!row.selected && selectedEnvironmentRows.contains(row)) {
					//The environment resource has been unchecked in the dialog
					Resource resource = ted.getResourceSet().getResource(URI.createURI(row.uri), false);
					List<Setting> crossReferences = findCrossReferences(session, resource);
					if (!crossReferences.isEmpty()) {
						CompoundCommand handleCommand = handleSemanticResourceUse(crossReferences, shell, session, resource, ted);
						if (!handleCommand.isEmpty()) {
							globalCommand.append(handleCommand);
						}
					} else {
						RemoveSemanticResourceCommand removeSemanticResourceCommand = new RemoveSemanticResourceCommand(session, resource, new NullProgressMonitor(), false);
						globalCommand.append(removeSemanticResourceCommand);
					}
				}
			}
			if (!globalCommand.isEmpty()) {
				ted.getCommandStack().execute(globalCommand);
			}
		}
		return null;
	}

	private CompoundCommand handleSemanticResourceUse(List<Setting> crossReferencesUsingSettings, Shell parentShell, Session session, Resource resource, TransactionalEditingDomain ted) {
		List<EObject> crossReferences = crossReferencesUsingSettings.stream().map(Setting::getEObject).collect(toList());
		List<Resource> roots = computeRoots(crossReferences);
		EnvironmentUsedElementResourceWarning environmentUsedElementResourceWarning = new EnvironmentUsedElementResourceWarning(parentShell, roots, crossReferences, resource.getURI().lastSegment());
		CompoundCommand compoundCommand = new CompoundCommand();
		if (Window.OK == environmentUsedElementResourceWarning.open()) {
			//remove crossReference
			UnsetCrossReferenceCommand unsetCrossReferenceCommand = new UnsetCrossReferenceCommand(ted);
			unsetCrossReferenceCommand.addAllSetting(crossReferencesUsingSettings);
			compoundCommand.append(unsetCrossReferenceCommand);
			RemoveSemanticResourceCommand removeSemanticResourceCommand = new RemoveSemanticResourceCommand(session, resource, new NullProgressMonitor(), false);
			compoundCommand.append(removeSemanticResourceCommand);
		}
		return compoundCommand;
	}

	private List<Resource> computeRoots(List<EObject> crossReferences) {
		List<Resource> rootList = new ArrayList<>();
		for (EObject eObject : crossReferences) {
			Resource eResource = eObject.eResource();
			if (!rootList.contains(eResource)) {
				rootList.add(eResource);
			}
		}
		return rootList;
	}

	/**
	 * Finds the possible use of the resource in other resources.
	 * 
	 * @param session  The session
	 * @param resource The resource we search for use
	 * @return The list of use
	 */
	private List<Setting> findCrossReferences(Session session, Resource resource) {
		List<Setting> crossReferences = new ArrayList<>();
		ECrossReferenceAdapter crossReferencer = session.getSemanticCrossReferencer();
		TreeIterator<EObject> contents = resource.getAllContents();
		while(contents.hasNext()) {
			EObject eObject = contents.next();
			Collection<Setting> references = crossReferencer.getInverseReferences(eObject);
			for (Setting setting : references) {
				if (!setting.getEObject().eResource().equals(resource)) {
					crossReferences.add(setting);
				}
			}
		}
		return crossReferences;
	}

	private List<EnvironmentRow> getAllEnvironmentResources(Session session) {
		List<EnvironmentRow> environmentRows = new ArrayList<>();
		
		List<Resource> sessionEnvironmentResources = session.getSemanticResources().stream()
				.filter(r -> !r.getContents().isEmpty() && r.getContents().get(0) instanceof Environment)
				.collect(toList());
		
		for (IConfigurationElement configElement : ProvidedModelsService.getProvidedEnvironment()) {
			EnvironmentRow environmentRow = new EnvironmentRow();
			environmentRow.name = configElement.getAttribute("name");
			environmentRow.uri = configElement.getAttribute("uri");
			environmentRow.selected = sessionEnvironmentResources.stream()
					.anyMatch(r -> r.getURI().equals(URI.createURI(environmentRow.uri)));
			environmentRow.unselectable = false;
			environmentRows.add(environmentRow);
		}
		
		List<URI> providedEnvironmentURIs = environmentRows.stream().map(er -> URI.createURI(er.uri)).collect(toList());
		
		List<Resource> otherEnvironmentResources = sessionEnvironmentResources.stream().filter(env -> !providedEnvironmentURIs.contains(env.getURI())).collect(toList());
		for(Resource otherEnvironmentResource : otherEnvironmentResources) {
			Environment environment = (Environment)otherEnvironmentResource.getContents().get(0);
			
			EnvironmentRow environmentRow = new EnvironmentRow();
			environmentRow.name = environment.getName();
			environmentRow.uri = otherEnvironmentResource.getURI().toString();
			environmentRow.selected = true;
			environmentRow.unselectable = true;
			environmentRows.add(environmentRow);
		}
		
		return environmentRows;
	}
	
	private class OpenEnvResourceDialogContext {
		
		private ModelingProject modelingProject;
		private Session session;
		
		public ModelingProject getModelingProject() {
			return modelingProject;
		}

		public Session getSession() {
			return session;
		}

		public boolean isWellInitialized() {
			return modelingProject != null && session != null;
		}

		public void handleExecutionEvent(ExecutionEvent event) {
			IStructuredSelection selection = HandlerUtil.getCurrentStructuredSelection(event);
			Object element = selection.getFirstElement();
			if (element instanceof ProjectDependenciesItem) {
				handleProjectDependenciesItem((ProjectDependenciesItem) element);
			} else {
				getModelingProject(element);
				if (this.modelingProject != null) {
					getSession(event, this.modelingProject);
				}
			}
		}
		
		private void handleProjectDependenciesItem(ProjectDependenciesItem projectDependenciesItem) {
			Option<Session> sessionOptional = projectDependenciesItem.getSession();
			if (sessionOptional.some()) {
				this.session = sessionOptional.get();
				getModelingProjectFromSession(this.session);
			}
		}

		private void getModelingProjectFromSession(Session session) {
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			String airdPath = session.getSessionResource().getURI().toPlatformString(true);
			IProject project = root.findMember(airdPath).getProject();
			this.modelingProject = ModelingProject.asModelingProject(project).get();
		}

		private void getModelingProject(Object element) {
			if (element instanceof IFile) {
				element = ((IFile) element).getProject();
			}
			ModelingProject modelingProject = null;
			if (element instanceof IProject && ModelingProject.hasModelingProjectNature((IProject) element)) {
				Option<ModelingProject> modelingProjectOption = ModelingProject.asModelingProject((IProject) element);
				if (modelingProjectOption.some()) {
					modelingProject = modelingProjectOption.get();
				}
			}
			this.modelingProject = modelingProject;
		}
		
		private void getSession(ExecutionEvent event, ModelingProject modelingProject) {
			Session session = modelingProject.getSession();
			if (session == null) {
				boolean confirmed = MessageDialog.openConfirm(HandlerUtil.getActiveShell(event), "Session not available", "The session seems closed, do you want to open it? (it might take some time)");
				if (confirmed && modelingProject != null) {
					Option<URI> representationsFileURI = modelingProject.getMainRepresentationsFileURI(new NullProgressMonitor());
					if (representationsFileURI.some()) {
						session = SessionManager.INSTANCE.getSession(representationsFileURI.get(), new NullProgressMonitor());
						if (!session.isOpen()) {
							session.open(new NullProgressMonitor());
							if (!session.isOpen()) {
								session = null;
							}
						}
					}
				}
			}
			this.session = session;
		}
		
	}
}
