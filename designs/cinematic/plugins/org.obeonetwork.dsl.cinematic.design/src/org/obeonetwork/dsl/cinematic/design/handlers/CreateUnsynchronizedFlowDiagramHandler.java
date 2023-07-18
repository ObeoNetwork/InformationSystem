package org.obeonetwork.dsl.cinematic.design.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.tools.api.DiagramPlugin;
import org.eclipse.sirius.diagram.tools.internal.preferences.SiriusDiagramInternalPreferencesKeys;
import org.obeonetwork.dsl.cinematic.design.ICinematicViewpoint;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.utils.common.ui.handlers.EventHelper;
import org.obeonetwork.utils.common.ui.services.SiriusUIUtils;

@SuppressWarnings("restriction")
public class CreateUnsynchronizedFlowDiagramHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		boolean syncOnCreation = Platform.getPreferencesService().getBoolean(DiagramPlugin.ID, SiriusDiagramInternalPreferencesKeys.PREF_SYNCHRONIZE_DIAGRAM_ON_CREATION.name(), false, null);
		final IEclipsePreferences diagramCorePreferences = InstanceScope.INSTANCE.getNode(DiagramPlugin.ID);
		diagramCorePreferences.putBoolean(SiriusDiagramInternalPreferencesKeys.PREF_SYNCHRONIZE_DIAGRAM_ON_CREATION.name(), false);
		
		Flow flow = EventHelper.uwrapSingleSelection(event, Flow.class);
		Session session = new EObjectQuery(flow).getSession();
		DDiagram diagram = (DDiagram) SiriusUIUtils.createRepresentation(session, flow, ICinematicViewpoint.FLOW_DIAGRAM_ID, new NullProgressMonitor());
		
		diagramCorePreferences.putBoolean(SiriusDiagramInternalPreferencesKeys.PREF_SYNCHRONIZE_DIAGRAM_ON_CREATION.name(), syncOnCreation);
		
		// TODO Name the created diagram with "Partial View" in it
		// TODO Implement a condition for the command
		// TODO Open the diagram
		// TODO Implement dnd
		// TODO See https://eclipse.dev/sirius/doc/developer/trigger-refresh-graphical-changes.html to auto refresh the Palette
		
		return null;
	}
	
}