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
