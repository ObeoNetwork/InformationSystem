/*******************************************************************************
 * Copyright (c) 2011, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

public class TypesLibraryUtil {
	
	public static final String ORACLE_PATHMAP = "pathmap://NativeDBTypes/Oracle-11g";
	public static final String MYSQL_PATHMAP = "pathmap://NativeDBTypes/MySQL-5";
	public static final String MARIADB_PATHMAP = "pathmap://NativeDBTypes/MariaDB-10.2";
	public static final String POSTGRES_PATHMAP = "pathmap://NativeDBTypes/Postgres-9";
	public static final String SQLSERVER_PATHMAP = "pathmap://NativeDBTypes/SQLServer-2008";
	public static final String H2_PATHMAP = "pathmap://NativeDBTypes/H2-1.3";
	
	public static final String LOGICAL_PATHMAP = "pathmap://LogicalDBTypes";
	
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
		final URL mySqlUrl = TypesLibraryUtil.class.getClassLoader().getResource("MySQL-5.typeslibrary");
		URIConverter.URI_MAP.put(URI.createURI(MYSQL_PATHMAP), URI.createURI(mySqlUrl.toString()));
		final URL mariaDBUrl = TypesLibraryUtil.class.getClassLoader().getResource("MariaDB-10.2.typeslibrary");
		URIConverter.URI_MAP.put(URI.createURI(MARIADB_PATHMAP), URI.createURI(mariaDBUrl.toString()));
		final URL oracleUrl = TypesLibraryUtil.class.getClassLoader().getResource("Oracle-11g.typeslibrary");
		URIConverter.URI_MAP.put(URI.createURI(ORACLE_PATHMAP), URI.createURI(oracleUrl.toString()));	
		final URL postgresUrl = TypesLibraryUtil.class.getClassLoader().getResource("Postgres-9.typeslibrary");
		URIConverter.URI_MAP.put(URI.createURI(POSTGRES_PATHMAP), URI.createURI(postgresUrl.toString()));
		final URL sqlserverUrl = TypesLibraryUtil.class.getClassLoader().getResource("SQLServer-2008.typeslibrary");
		URIConverter.URI_MAP.put(URI.createURI(SQLSERVER_PATHMAP), URI.createURI(sqlserverUrl.toString()));
		final URL h2Url = TypesLibraryUtil.class.getClassLoader().getResource("H2-1.3.typeslibrary");
		URIConverter.URI_MAP.put(URI.createURI(H2_PATHMAP), URI.createURI(h2Url.toString()));
	}

}
