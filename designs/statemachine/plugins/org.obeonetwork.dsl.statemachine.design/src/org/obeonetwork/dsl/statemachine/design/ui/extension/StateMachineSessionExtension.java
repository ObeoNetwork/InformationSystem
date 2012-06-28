package org.obeonetwork.dsl.statemachine.design.ui.extension;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.obeonetwork.dsl.statemachine.design.ui.extension.providers.StateMachineAnalysisContextMenuActionProvider;
import org.obeonetwork.dsl.statemachine.design.ui.extension.providers.StateMachineAnalysisTreeProvider;

import fr.obeo.dsl.viewpoint.ui.tools.api.views.ViewHelper;
import fr.obeo.dsl.viewpoint.ui.tools.internal.views.ViewHelperImpl;
import fr.obeo.dsl.viewpoint.ui.tools.internal.views.sessionview.extension.IContextMenuActionProvider;
import fr.obeo.dsl.viewpoint.ui.tools.internal.views.sessionview.extension.ISessionViewExtension;

public class StateMachineSessionExtension {

	/**
	 *Add an extension to the Model Content View
	 */
	public static void addExtension() {
		
		final ISessionViewExtension extension = new ISessionViewExtension() {
			public ITreeContentProvider getContentProvider() {
				return new StateMachineAnalysisTreeProvider();
			}

			public IContextMenuActionProvider getContextMenuActionProvider() {
				return new StateMachineAnalysisContextMenuActionProvider();
			}
		};
		((ViewHelperImpl)ViewHelper.INSTANCE).addExtension(extension);
	}
}
