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
package org.obeonetwork.dsl.typeslibrary.util;

import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.NativeTypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryKind;

public class TypesLibraryUtil {
	
	public static final String LOGICAL_PATHMAP = "pathmap://LogicalDBTypes";
	public static final String LOGICAL_FILENAME = "LogicalModel.typeslibrary";
	
	public static final String MYSQL_PATHMAP = "pathmap://NativeDBTypes/MySQL-5";
	public static final String MYSQL_FILENAME = "MySQL.typeslibrary";
	
	public static final String ORACLE_PATHMAP = "pathmap://NativeDBTypes/Oracle-11g";
	public static final String ORACLE_FILENAME = "Oracle.typeslibrary";
	
	public static final String H2_PATHMAP = "pathmap://NativeDBTypes/H2-1.3";
	public static final String H2_FILENAME = "H2.typeslibrary";
	
	public static final String SQLSERVER_PATHMAP = "pathmap://NativeDBTypes/SQLServer-2008";
	public static final String SQLSERVER_FILENAME = "SQLServer.typeslibrary";
	
	public static final String MARIADB_PATHMAP = "pathmap://NativeDBTypes/MariaDB-10.2";
	public static final String MARIADB_FILENAME = "MariaDB.typeslibrary";
	
	public static final String POSTGRES9_PATHMAP = "pathmap://NativeDBTypes/Postgres-9";
	public static final String POSTGRES9_FILENAME = "Postgres-9.typeslibrary";
	
	public static final String POSTGRES_PATHMAP = "pathmap://NativeDBTypes/Postgres-9.5-13";
	public static final String POSTGRES_FILENAME = "Postgres.typeslibrary";
	
	public static NativeType findLogicalType(TypeInstance physicalTypeInstance) {
		NativeType physicalNativeType = physicalTypeInstance.getNativeType();
		NativeType logicalNativeType = physicalNativeType.getMapsTo();
		if(logicalNativeType==null){
			System.err.println("Cannot map physical type: "+physicalNativeType.getName()+" to logical type");	
		}		
		return logicalNativeType;		
	}
	
	public static NativeTypesLibrary getLogicalTypesLibrary(ResourceSet resourceSet) {		
		URI typeslibraryURI = URI.createURI(LOGICAL_PATHMAP);
		Resource resource = resourceSet.getResource(typeslibraryURI, true);
		NativeTypesLibrary nativeTypesLibrary = (NativeTypesLibrary) resource.getContents().get(0);
	    return nativeTypesLibrary;
	}
	
	public static void registerPathmaps() {
		final URL mySqlUrl = TypesLibraryUtil.class.getClassLoader().getResource(MYSQL_FILENAME);
		URIConverter.URI_MAP.put(URI.createURI(MYSQL_PATHMAP), URI.createURI(mySqlUrl.toString()));
		
		final URL oracleUrl = TypesLibraryUtil.class.getClassLoader().getResource(ORACLE_FILENAME);
		URIConverter.URI_MAP.put(URI.createURI(ORACLE_PATHMAP), URI.createURI(oracleUrl.toString()));	
		
		final URL h2Url = TypesLibraryUtil.class.getClassLoader().getResource(H2_FILENAME);
		URIConverter.URI_MAP.put(URI.createURI(H2_PATHMAP), URI.createURI(h2Url.toString()));
		
		final URL sqlserverUrl = TypesLibraryUtil.class.getClassLoader().getResource(SQLSERVER_FILENAME);
		URIConverter.URI_MAP.put(URI.createURI(SQLSERVER_PATHMAP), URI.createURI(sqlserverUrl.toString()));
		
		final URL mariaDBUrl = TypesLibraryUtil.class.getClassLoader().getResource(MARIADB_FILENAME);
		URIConverter.URI_MAP.put(URI.createURI(MARIADB_PATHMAP), URI.createURI(mariaDBUrl.toString()));
		
		final URL postgres9Url = TypesLibraryUtil.class.getClassLoader().getResource(POSTGRES9_FILENAME);
		URIConverter.URI_MAP.put(URI.createURI(POSTGRES9_PATHMAP), URI.createURI(postgres9Url.toString()));
		
		final URL postgresUrl = TypesLibraryUtil.class.getClassLoader().getResource(POSTGRES_FILENAME);
		URIConverter.URI_MAP.put(URI.createURI(POSTGRES_PATHMAP), URI.createURI(postgresUrl.toString()));
	}

	public static boolean isMPD(TypesLibrary typesLibrary) {
		return typesLibrary != null && typesLibrary.getKind() == TypesLibraryKind.PHYSICAL_TYPES;
	}
	
	public static boolean isOracleMPD(TypesLibrary typesLibrary) {
		return isMPD(typesLibrary) && TypesLibraryUtil.ORACLE_PATHMAP.equals(typesLibrary.eResource().getURI().toString());
	}
	
	public static boolean isMysqlMPD(TypesLibrary typesLibrary) {
		return isMPD(typesLibrary) && TypesLibraryUtil.MYSQL_PATHMAP.equals(typesLibrary.eResource().getURI().toString());
	}
	
	public static boolean isMariaDBMPD(TypesLibrary typesLibrary) {
		return isMPD(typesLibrary) && TypesLibraryUtil.MARIADB_PATHMAP.equals(typesLibrary.eResource().getURI().toString());
	}
	
	public static boolean isPostgresMPD(TypesLibrary typesLibrary) {
		return isMPD(typesLibrary) && (TypesLibraryUtil.POSTGRES9_PATHMAP.equals(typesLibrary.eResource().getURI().toString())
				|| TypesLibraryUtil.POSTGRES_PATHMAP.equals(typesLibrary.eResource().getURI().toString()));
	}
	
	public static boolean isSQLServerMPD(TypesLibrary typesLibrary) {
		return isMPD(typesLibrary) && TypesLibraryUtil.SQLSERVER_PATHMAP.equals(typesLibrary.eResource().getURI().toString());
	}
	
	public static boolean isH2MPD(TypesLibrary typesLibrary) {
		return isMPD(typesLibrary) && TypesLibraryUtil.H2_PATHMAP.equals(typesLibrary.eResource().getURI().toString());
	}
	
}
