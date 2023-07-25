package org.obeonetwork.dsl.environment.design.ui.menu;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.common.tools.api.interpreter.EvaluationException;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.tools.api.DiagramPlugin;
import org.eclipse.sirius.diagram.tools.internal.preferences.SiriusDiagramInternalPreferencesKeys;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.obeonetwork.dsl.environment.design.Activator;
import org.obeonetwork.utils.common.ui.services.SiriusUIUtils;

@SuppressWarnings("restriction")
public class PartialViewCreationAction extends Action {

	private EObject context;
	private RepresentationDescription representationDescription;

	public PartialViewCreationAction(EObject context, RepresentationDescription representationDescription) {
		super();

		this.context = context;
		this.representationDescription = representationDescription;
		
		setText(computePartialViewName(context, representationDescription));
		setImageDescriptor(Activator.getImageDescriptor("icons/full/obj16/EnvironmentModelFile.gif"));
	}

	private String computePartialViewName(EObject context, RepresentationDescription representationDescription) {
		
		String name = "";
		
		Session session = SessionManager.INSTANCE.getSession(context);
		IInterpreter interpreter = session.getInterpreter();
		try {
			String titleExpression = representationDescription.getTitleExpression();
			
			interpreter.evaluateString(context, titleExpression);
			
			name = titleExpression;
		} catch (EvaluationException e) {
			e.printStackTrace();
		}
		
		
		return name;
	}

	@Override
	public void run() {
		this.getText();
		boolean syncOnCreation = Platform.getPreferencesService().getBoolean(DiagramPlugin.ID, SiriusDiagramInternalPreferencesKeys.PREF_SYNCHRONIZE_DIAGRAM_ON_CREATION.name(), false, null);
		final IEclipsePreferences diagramCorePreferences = InstanceScope.INSTANCE.getNode(DiagramPlugin.ID);
		diagramCorePreferences.putBoolean(SiriusDiagramInternalPreferencesKeys.PREF_SYNCHRONIZE_DIAGRAM_ON_CREATION.name(), false);

		Session session = SessionManager.INSTANCE.getSession(context);
		
		DDiagram diagram = (DDiagram) SiriusUIUtils.createRepresentation(session, context, representationDescription.getName(), new NullProgressMonitor());
		
		diagramCorePreferences.putBoolean(SiriusDiagramInternalPreferencesKeys.PREF_SYNCHRONIZE_DIAGRAM_ON_CREATION.name(), syncOnCreation);

	}
	
}
