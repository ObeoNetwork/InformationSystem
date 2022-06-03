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
