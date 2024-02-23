/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.design.ui.menu;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.common.tools.api.interpreter.EvaluationException;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.tools.api.DiagramPlugin;
import org.eclipse.sirius.diagram.tools.internal.preferences.SiriusDiagramInternalPreferencesKeys;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.obeonetwork.dsl.environment.design.Activator;
import org.obeonetwork.utils.common.StringUtils;
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
		setImageDescriptor(Activator.getImageDescriptor("icons/full/tool/PartialView.gif"));
	}

	private String computePartialViewName(EObject context, RepresentationDescription representationDescription) {
		
		String name = null;
		if(StringUtils.isNullOrWhite(representationDescription.getTitleExpression())) {
			name = "new " + representationDescription.getName();
		} else {
			Session session = SessionManager.INSTANCE.getSession(context);
			IInterpreter interpreter = session.getInterpreter();
			try {
				name = interpreter.evaluateString(context, representationDescription.getTitleExpression());
			} catch (EvaluationException e) {
				e.printStackTrace();
				name = "Evaluation error";
			}
		}

		name = tweakPartialViewName(name);
		
		return name;
	}

	private String tweakPartialViewName(String diagramName) {
		String partialViewName;
		int index = diagramName.toLowerCase().lastIndexOf("diagram");
		if(index != -1) {
			partialViewName = diagramName.substring(0, index) + "Partial View" + diagramName.substring(index + 7);
		} else {
			partialViewName = diagramName + " Partial View";
		}
		return partialViewName;
	}

	@Override
	public void run() {
		
		// Save the current state of the "Synchronize diagram on creation" preference
		boolean syncOnCreation = Platform.getPreferencesService().getBoolean(DiagramPlugin.ID, SiriusDiagramInternalPreferencesKeys.PREF_SYNCHRONIZE_DIAGRAM_ON_CREATION.name(), false, null);
		
		// Set the "Synchronize diagram on creation" preference to false
		final IEclipsePreferences diagramCorePreferences = InstanceScope.INSTANCE.getNode(DiagramPlugin.ID);
		diagramCorePreferences.putBoolean(SiriusDiagramInternalPreferencesKeys.PREF_SYNCHRONIZE_DIAGRAM_ON_CREATION.name(), false);

		Session session = SessionManager.INSTANCE.getSession(context);
		
		// Pop a dialog to edit the proposed name
		final InputDialog promptName = new InputDialog(Display.getDefault().getActiveShell(),
				"New " + tweakPartialViewName(representationDescription.getName()),
				"Name:",
				getText(),
				null);
		if(promptName.open() != Window.OK) {
			return;
		}
		String representationName = promptName.getValue();
		
		DDiagram diagram = (DDiagram) SiriusUIUtils.createRepresentation(session, context, representationDescription, representationName, new NullProgressMonitor());
		
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().run(false, false, motitor -> 
			DialectUIManager.INSTANCE.openEditor(session, diagram, new NullProgressMonitor()));
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Restore the "Synchronize diagram on creation" preference
		diagramCorePreferences.putBoolean(SiriusDiagramInternalPreferencesKeys.PREF_SYNCHRONIZE_DIAGRAM_ON_CREATION.name(), syncOnCreation);

	}
	
}
