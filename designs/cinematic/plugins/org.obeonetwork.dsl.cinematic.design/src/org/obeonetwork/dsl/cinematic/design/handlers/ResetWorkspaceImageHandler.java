package org.obeonetwork.dsl.cinematic.design.handlers;

import static org.obeonetwork.utils.common.StringUtils.isNullOrWhite;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.description.NodeMapping;
import org.eclipse.sirius.diagram.description.style.WorkspaceImageDescription;
import org.eclipse.sirius.diagram.ui.business.api.image.ImageSelectorService;
import org.eclipse.sirius.diagram.ui.edit.api.part.IDiagramElementEditPart;
import org.eclipse.sirius.viewpoint.BasicLabelStyle;
import org.obeonetwork.utils.common.handlers.EventHelper;

public class ResetWorkspaceImageHandler  extends AbstractHandler {
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IDiagramElementEditPart selectedDiagramElementEditPart = EventHelper.uwrapSingleSelection(event, IDiagramElementEditPart.class);
		DDiagramElement diagramElement = selectedDiagramElementEditPart.resolveDiagramElement();
		
		String workspacePath = null;
		if(diagramElement.getMapping() instanceof NodeMapping) {
			NodeMapping mapping = (NodeMapping) diagramElement.getMapping();
			if(mapping.getStyle() instanceof WorkspaceImageDescription) {
				WorkspaceImageDescription workspaceImageDescription = (WorkspaceImageDescription) mapping.getStyle();
				workspacePath = workspaceImageDescription.getWorkspacePath();
			}
		};
		
		if(!isNullOrWhite(workspacePath)) {
			ImageSelectorService.INSTANCE.updateStyle((BasicLabelStyle) diagramElement.getStyle(), workspacePath);
		}
		
		return null;
	}

}
