package fr.gouv.mindef.safran.project.lifecycle.ui;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "fr.gouv.mindef.safran.project.lifecycle.ui.messages"; //$NON-NLS-1$
	public static String BusinessProjectImportDialog_Title;
	public static String BusinessProjectImportDialog_grpSourceProject_text;
	public static String BusinessProjectImportDialog_grpTargetProject_text;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
