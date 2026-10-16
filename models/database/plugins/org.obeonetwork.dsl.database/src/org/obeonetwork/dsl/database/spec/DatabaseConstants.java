/*******************************************************************************
 * Copyright (c) 2008, 2026 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.spec;

public interface DatabaseConstants {
	static final String DB_ORACLE = "oracle";
	static final String DB_MYSQL = "mysql";
	static final String DB_MARIADB = "mariadb";
	static final String DB_H2 = "h2";
	static final String DB_POSTGRES = "postgresql";
	static final String DB_SQLSERVER = "sqlserver";
	
	static final String DB_LOGICAL_TYPES = "logical";

	/**
	 * Returns the display label for a database vendor.
	 *
	 * @param vendor the database vendor identifier, or {@code null}
	 * @return the vendor label, the identifier if unknown, or an empty string if null
	 */
	static String getVendorLabel(String vendor) {
		if (vendor == null) {
			return "";
		}
		return switch (vendor) {
		case DB_H2 -> "H2";
		case DB_MYSQL -> "MySQL";
		case DB_MARIADB -> "MariaDB";
		case DB_POSTGRES -> "PostgreSQL";
		case DB_SQLSERVER -> "SQL Server";
		case DB_ORACLE -> "Oracle";
		case DB_LOGICAL_TYPES -> "Logical Types";
		default -> vendor;
		};
	}
}
