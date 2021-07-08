package org.obeonetwork.dsl.cinematic.design.handlers;

import java.util.Arrays;
import java.util.Comparator;

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
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.ui.business.api.image.ImageSelectorService;
import org.eclipse.sirius.diagram.ui.edit.api.part.IDiagramElementEditPart;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.business.api.dialect.ExportFormat;
import org.eclipse.sirius.ui.tools.api.actions.export.SizeTooLargeException;
import org.eclipse.sirius.viewpoint.BasicLabelStyle;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.obeonetwork.dsl.cinematic.design.Activator;
import org.obeonetwork.dsl.cinematic.design.ICinematicViewpoint;
import org.obeonetwork.dsl.cinematic.flow.ViewState;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.utils.common.handlers.EventHelper;
import org.obeonetwork.utils.sirius.session.SessionUtils;

public class SetMockupAsWorkspaceImageHandler extends AbstractHandler {
	
	private final static String MOCKUPS_FOLDER_NAME = "mockups";

    private static final ExportFormat FORMAT = new ExportFormat(ExportFormat.ExportDocumentFormat.NONE, ImageFileFormat.JPG);
    
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IDiagramElementEditPart selectedDiagramElementEditPart = EventHelper.uwrapSingleSelection(event, IDiagramElementEditPart.class);
		DDiagramElement diagramElement = selectedDiagramElementEditPart.resolveDiagramElement();
		
		ViewState viewState = (ViewState) diagramElement.getTarget();
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
		
//		Arrays.stream(mockupMembers)
//		.filter(r -> r.getName().matches(baseFileName + "-[0-9]+\\.jpg"))
//		.forEach(r -> {
//			try {
//				r.delete(true, null);
//			} catch (CoreException e1) {
//			}
//		});
		
		
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
		
		ImageSelectorService.INSTANCE.updateStyle((BasicLabelStyle) diagramElement.getStyle(), 
				imageFile.getFullPath().toPortableString());
		
		return null;
	}

    private String sanitize(String name) {
        return name.replaceAll("[<>:\"/\\|?*'\0 ]", "_");
    }
    
}
