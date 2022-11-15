/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.design;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;

public interface IDatabaseViewpointConstants {
	
	public static URI VIEWPOINT_URI = URI.createURI("viewpoint:/org.obeonetwork.dsl.database.design/Database");
	
	public static Collection<URI> VIEWPOINT_DEPENDENCIES = Arrays.asList(
			VIEWPOINT_URI
	);

	public static String DATABASE_DIAGRAM_ID = "Database Diagram";
	public static String SCHEMA_DIAGRAM_ID = "Schema Diagram";
	
}