/**
 * Copyright (c) 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *
 * $Id$
 */
package org.obeonetwork.is.ui.wizards.newproject;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.obeonetwork.is.ui.wizards.newproject.messages"; //$NON-NLS-1$
	public static String wizard_wizard_title;
	public static String wizard_error_message;
	public static String wizard_error_prefix_is_required;
	public static String wizard_title;
	public static String wizard_description;
	public static String wizard_project_name_label;
	public static String wizard_project_prefix_label;
	public static String wizard_error_name_is_required;
	public static String wizard_error_project_already_exists;
	public static String wizard_project_name_example_label;
	public static String wizard_project_prefix_example_label;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
