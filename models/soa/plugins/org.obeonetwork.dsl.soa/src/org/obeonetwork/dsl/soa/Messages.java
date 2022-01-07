package org.obeonetwork.dsl.soa;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.obeonetwork.dsl.soa.messages"; //$NON-NLS-1$
	public static String License_DefaultName;
	public static String License_DefaultURL;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
