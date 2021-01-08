/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.interaction.design.ui.extension;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.obeonetwork.dsl.interaction.design.ui.extension.providers.InteractionAnalysisContextMenuActionProvider;
import org.obeonetwork.dsl.interaction.design.ui.extension.providers.InteractionAnalysisTreeProvider;

import org.eclipse.sirius.ui.tools.api.views.ViewHelper;
import org.eclipse.sirius.ui.tools.internal.views.ViewHelperImpl;
import org.eclipse.sirius.ui.tools.internal.views.modelexplorer.extension.IContextMenuActionProvider;
import org.eclipse.sirius.ui.tools.internal.views.modelexplorer.extension.ISessionViewExtension;

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
