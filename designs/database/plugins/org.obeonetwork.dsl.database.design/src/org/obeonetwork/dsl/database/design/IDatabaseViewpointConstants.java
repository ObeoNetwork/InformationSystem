/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.design;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;

public interface IDatabaseViewpointConstants {
	
	public static URI DATABASE_VIEWPOINT_URI = URI.createURI("viewpoint:/org.obeonetwork.dsl.database.design/Database");
	public static URI ENVIRONMENT_VIEWPOINT_URI = URI.createURI("viewpoint:/org.obeonetwork.dsl.environment.properties/Environment Views");
	
	
	public static Collection<URI> VIEWPOINT_DEPENDENCIES = Arrays.asList(
			DATABASE_VIEWPOINT_URI,
			ENVIRONMENT_VIEWPOINT_URI
	);

	public static String DATABASE_DIAGRAM_ID = "Database Diagram";
	public static String SCHEMA_DIAGRAM_ID = "Schema Diagram";
	
}
