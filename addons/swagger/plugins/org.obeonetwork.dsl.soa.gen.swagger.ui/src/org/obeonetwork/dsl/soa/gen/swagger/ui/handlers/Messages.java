package org.obeonetwork.dsl.soa.gen.swagger.ui.handlers;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.obeonetwork.dsl.soa.gen.swagger.ui.handlers.messages"; //$NON-NLS-1$
	public static String ImportSwaggerHandler_ResultDialog_Failure_message;
	public static String ImportSwaggerHandler_ResultDialog_Success_message;
	public static String ImportSwaggerHandler_ResultDialog_Title;
	public static String ImportSwaggerHandler_ResultDialog_Warning_message;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
