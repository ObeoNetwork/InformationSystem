/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.design.dialogs;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.obeonetwork.dsl.cinematic.design.dialogs.messages"; //$NON-NLS-1$
	public static String CinematicDialog_clear;
	public static String CinematicDialog_EventSelection;
	public static String CinematicDialog_filterText;
	public static String CinematicDialog_hideNonContextualViewContainers;
	public static String CinemlaticDialog_HideViewContainerBoundToOtherViewStates;
	public static String CinemlaticDialog_ViewContainerSelection;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
