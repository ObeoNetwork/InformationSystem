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
	static final String DB_ORACLE_21C = "Oracle-21c";
	static final String DB_MYSQL_9 = "MySQL-9.6";
	static final String DB_MARIADB_121 = "MariaDB-12.1";
	static final String DB_H2_24 = "H2-2.4";
	static final String DB_POSTGRES_18 = "PostgreSQL18.1";
	static final String DB_SQLSERVER_2025 = "SQLServer-2025";
	
	static final String DB_LOGICAL_TYPES = "Logical Types";

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
		case DB_H2_24 -> "H2";
		case DB_MYSQL_9 -> "MySQL";
		case DB_MARIADB_121 -> "MariaDB";
		case DB_POSTGRES_18 -> "PostgreSQL";
		case DB_SQLSERVER_2025 -> "SQL Server";
		case DB_ORACLE_21C -> "Oracle";
		default -> vendor;
		};
	}
}
