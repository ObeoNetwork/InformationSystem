package org.obeonetwork.dsl.soa.design.dialogs;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.obeonetwork.dsl.soa.design.dialogs.messages"; //$NON-NLS-1$
	public static String FlowCreation;
	public static String Type;
	public static String FlowDescription;
	public static String DeleteIcon;
	public static String CancelButtonLabel;
	public static String OKButtonLabel;
	public static String AuthorizationURL;
	public static String TokenURL;
	public static String RefreshURL;
	public static String FlowScopes;
	public static String FlowName;
	public static String FlowDescriptionLabel;
	public static String AddIcon;
	public static String NewFlowScope;
	public static String NewSecurityScheme;
	public static String Flows;
	public static String SecuritySchemeName;
	public static String SecuritySchemeDescription;
	public static String ApiKeyLocation;
	public static String ConnectURL;
	public static String HttpScheme;
	public static String Format;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
