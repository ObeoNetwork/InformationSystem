package org.obeonetwork.dsl.interaction.design.ui.extension;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.obeonetwork.dsl.interaction.design.ui.extension.providers.InteractionAnalysisContextMenuActionProvider;
import org.obeonetwork.dsl.interaction.design.ui.extension.providers.InteractionAnalysisTreeProvider;

import fr.obeo.dsl.viewpoint.ui.tools.api.views.ViewHelper;
import fr.obeo.dsl.viewpoint.ui.tools.internal.views.ViewHelperImpl;
import fr.obeo.dsl.viewpoint.ui.tools.internal.views.sessionview.extension.IContextMenuActionProvider;
import fr.obeo.dsl.viewpoint.ui.tools.internal.views.sessionview.extension.ISessionViewExtension;

public class InteractionSessionExtension {

	/**
	 *Add an extension to the Model Content View
	 */
	public static void addExtension() {
		
		final ISessionViewExtension extension = new ISessionViewExtension() {
			public ITreeContentProvider getContentProvider() {
				return new InteractionAnalysisTreeProvider();
			}

			public IContextMenuActionProvider getContextMenuActionProvider() {
				return new InteractionAnalysisContextMenuActionProvider();
			}
		};
		((ViewHelperImpl)ViewHelper.INSTANCE).addExtension(extension);
	}
}
