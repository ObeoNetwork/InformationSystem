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
package org.obeonetwork.dsl.cinematic.design.handlers;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.common.tools.api.resource.ImageFileFormat;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.WorkspaceImage;
import org.eclipse.sirius.diagram.business.api.query.DDiagramQuery;
import org.eclipse.sirius.diagram.ui.business.api.image.WorkspaceImageHelper;
import org.eclipse.sirius.diagram.ui.edit.api.part.IDiagramElementEditPart;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.business.api.dialect.ExportFormat;
import org.eclipse.sirius.ui.tools.api.actions.export.SizeTooLargeException;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.DView;
import org.obeonetwork.dsl.cinematic.design.Activator;
import org.obeonetwork.dsl.cinematic.design.ICinematicViewpoint;
import org.obeonetwork.dsl.cinematic.flow.ViewState;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.utils.common.EObjectUtils;
import org.obeonetwork.utils.common.SessionUtils;
import org.obeonetwork.utils.common.StreamUtils;
import org.obeonetwork.utils.common.ui.handlers.EventHelper;

public class ApplyMockupImageHandler extends AbstractHandler {
	
	private final static String MOCKUPS_FOLDER_NAME = "mockups";

    private static final ExportFormat FORMAT = new ExportFormat(ExportFormat.ExportDocumentFormat.NONE, ImageFileFormat.JPG);
    
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		for(IDiagramElementEditPart selectedDiagramElementEditPart : EventHelper.uwrapMultipleSelection(event, IDiagramElementEditPart.class)) {
			applyMockupImage(selectedDiagramElementEditPart);
		}
		
		return null;
	}

	private void applyMockupImage(IDiagramElementEditPart selectedDiagramElementEditPart) {
		DDiagramElement diagramElement = selectedDiagramElementEditPart.resolveDiagramElement();
		
		ViewState viewState = (ViewState) diagramElement.getTarget();
		
		if (viewState.getViewContainers().isEmpty()) 
			return;
		
		ViewContainer viewContainer = viewState.getViewContainers().get(0);
		
		Session session = new EObjectQuery(viewState).getSession();
		
		DRepresentation mockupDiagram = session.getOwnedViews().stream()
				.flatMap(v -> v.getOwnedRepresentationDescriptors().stream())
				.filter(rd -> rd.getTarget() == viewContainer)
				.filter(rd -> rd.getDescription().getName().equals(ICinematicViewpoint.VIEW_CONTAINER_DIAGRAM_ID))
				.map(rd -> rd.getRepresentation())
				.findFirst().orElse(null);
				
		ModelingProject modelingProject = SessionUtils.getModelingProjectFromSession(session);
		IFolder mockupsFolder = modelingProject.getProject().getFolder(MOCKUPS_FOLDER_NAME);
		if(!mockupsFolder.exists()) {
			try {
				mockupsFolder.create(true, true, null);
			} catch (CoreException e) {
				Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, 
						"Can't create mockup folder", e));
			}
		}
		String baseFileName = sanitize(mockupDiagram.getName());
		
		IResource[] mockupFolderMembers = null;
		try {
			mockupFolderMembers = mockupsFolder.members();
		} catch (CoreException e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, 
					"Can't read mockup folder content", e));
		}
		
		int suffix = 0;
		if(mockupFolderMembers != null) {
			suffix = Arrays.stream(mockupFolderMembers)
					.filter(r -> r.getName().matches(baseFileName + "-[0-9]+\\.jpg"))
					.map(r -> r.getName())
					.map(name -> name.substring(baseFileName.length() + 1, name.length() - 4))
					.map(s -> Integer.valueOf(s))
					.max(Comparator.comparing(Integer::valueOf))
					.orElse(-1) + 1;
		}
		
		String fileName = baseFileName + "-" + suffix + ".jpg";
		IFile imageFile = mockupsFolder.getFile(fileName);
		
		try {
	        DialectUIManager.INSTANCE.export(mockupDiagram, session, 
	        		imageFile.getLocation(),
	                FORMAT, new NullProgressMonitor());
		} catch (SizeTooLargeException e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, 
					"Diagram is too large to be exported as image", e));
		}
		
		WorkspaceImage workspaceImageStyle = (WorkspaceImage) diagramElement.getStyle();
		String oldWorkspacePath = workspaceImageStyle.getWorkspacePath();
		String newWorkspacePath = imageFile.getFullPath().toPortableString();
		
		if(oldWorkspacePath.startsWith(mockupsFolder.getFullPath().toPortableString())) {
			DDiagram currentDiagram = EObjectUtils.getContainerOrSelf(workspaceImageStyle, DDiagram.class);
			DRepresentationDescriptor currentRepresentationDescriptor = new DDiagramQuery(currentDiagram).getRepresentationDescriptor();
			DView dView = EObjectUtils.getContainerOrSelf(currentRepresentationDescriptor, DView.class);
			
			List<DRepresentation> flowDiagrams = dView.getOwnedRepresentationDescriptors().stream()
			.filter(rd -> ICinematicViewpoint.FLOW_DIAGRAM_ID.equals(rd.getDescription().getName()))
			.map(rd -> rd.getRepresentation())
			.collect(toList());
			
			for(DRepresentation flowDiagram : flowDiagrams) {
				List<WorkspaceImage> workspaceImageStylesToUpdate = StreamUtils.asStream(flowDiagram.eAllContents())
				.filter(WorkspaceImage.class::isInstance).map(WorkspaceImage.class::cast)
				.filter(wi -> oldWorkspacePath.equals(wi.getWorkspacePath()))
				.collect(toList());
				for(WorkspaceImage workspaceImageStyleToUpdate : workspaceImageStylesToUpdate) {
					WorkspaceImageHelper.INSTANCE.updateStyle(workspaceImageStyleToUpdate, newWorkspacePath);
				}
			}
			IFile oldFile = mockupsFolder.getFile(oldWorkspacePath.substring(mockupsFolder.getFullPath().toPortableString().length()));
			try {
				oldFile.delete(true, null);
			} catch (CoreException e) {
				// Never mind
			}
		} else {
			WorkspaceImageHelper.INSTANCE.updateStyle(workspaceImageStyle, newWorkspacePath);
		}
		
	}

    private String sanitize(String name) {
        return name.replaceAll("[<>:\"/\\|?*'\0 ]", "_");
    }
    
}
