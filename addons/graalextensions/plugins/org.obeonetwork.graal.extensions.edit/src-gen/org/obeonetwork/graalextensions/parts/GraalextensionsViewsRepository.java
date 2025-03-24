/**
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.graalextensions.parts;

/**
 * @author Obeo
 * 
 */
public class GraalextensionsViewsRepository {

	public static final int SWT_KIND = 0;

	public static final int FORM_KIND = 1;


	/**
	 * Version view descriptor
	 * 
	 */
	public static class Version {
		public static class Properties {
	
			// Start of user code for version ElementEditor key
			public static String version_ = "graalextensions::Version::properties::version_";
			// End of user code
			
			
			public static String modifiedOn = "graalextensions::Version::properties::modifiedOn";
			
			
			public static String createdOn = "graalextensions::Version::properties::createdOn";
			
	
		}
	
	}

	/**
	 * Risk view descriptor
	 * 
	 */
	public static class Risk {
		public static class Properties {
	
			
			public static String benefits = "graalextensions::Risk::properties::benefits";
			
			
			public static String drawbacks = "graalextensions::Risk::properties::drawbacks";
			
			
			public static String risk_ = "graalextensions::Risk::properties::risk_";
			
	
		}
	
	}

}
