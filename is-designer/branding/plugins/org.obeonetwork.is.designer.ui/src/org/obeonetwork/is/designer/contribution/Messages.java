package org.obeonetwork.is.designer.contribution;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.obeonetwork.is.designer.contribution.messages"; //$NON-NLS-1$
	public static String StatusBarBranding_Text;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}