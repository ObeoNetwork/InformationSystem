package org.obeonetwork.graal.design.extension;

import java.util.Collections;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.sirius.ui.tools.api.views.ViewHelper;
import org.eclipse.sirius.ui.tools.internal.views.ViewHelperImpl;
import org.eclipse.sirius.ui.tools.internal.views.modelexplorer.extension.IContextMenuActionProvider;
import org.eclipse.sirius.ui.tools.internal.views.modelexplorer.extension.ISessionViewExtension;

public class GraalSessionExtension {

	public static void addExtension() {
		
		final ISessionViewExtension extension = new ISessionViewExtension() {
			public ITreeContentProvider getContentProvider() {
				return new GraalAnalysisTreeProvider();
			}

			public IContextMenuActionProvider getContextMenuActionProvider() {
//				return new GraalAnalysisContextMenuActionProvider();
				return new IContextMenuActionProvider() {
					
					@Override
					public Iterable<IContributionItem> getContextualMenuContributionItems(ISelection selection) {
						return Collections.emptyList();
					}
					
					@Override
					public Iterable<IAction> getContextMenuActions(ISelection selection) {
						return Collections.emptyList();
					}
				};
			}
		};
		((ViewHelperImpl)ViewHelper.INSTANCE).addExtension(extension);
	}

}
