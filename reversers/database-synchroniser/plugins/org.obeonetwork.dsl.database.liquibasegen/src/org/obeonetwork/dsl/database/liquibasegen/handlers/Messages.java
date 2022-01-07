package org.obeonetwork.dsl.database.liquibasegen.handlers;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.obeonetwork.dsl.database.liquibasegen.handlers.messages"; //$NON-NLS-1$
	public static String ChangelogHandler_dialog_title;
	public static String ChangelogHandler_Error_message_properties_file_not_found;
	public static String ChangelogHandler_success_message;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
