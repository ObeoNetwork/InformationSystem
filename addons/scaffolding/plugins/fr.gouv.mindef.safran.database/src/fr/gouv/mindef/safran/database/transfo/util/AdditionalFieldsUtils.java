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
package fr.gouv.mindef.safran.database.transfo.util;

import java.text.MessageFormat;

import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.Constraint;
import org.obeonetwork.dsl.database.Table;

public class AdditionalFieldsUtils {
	
	private static final String VALIDITY_COLUMN_NAME = "{0}_XTOPSUP";
	private static final String DATE_COLUMN_NAME = "{0}_XDMAJ";
	private static final String VALIDITY_COLUMN_CONSTRAINT = "{0} in (''0'',''1'',''3'',''9'')";
	
	public static boolean isAdditionalColumn(Column column) {
		if (column.getName().equals(getValidityColumnName((Table)column.getOwner()))) {
			return true;
		}
		if (column.getName().equals(getDateColumnName((Table)column.getOwner()))) {
			return true;
		}
		return false;
	}
	
	public static boolean isAdditionalConstraint(Constraint constraint) {
		if (getValidityColumnConstraint(constraint.getOwner()).equals(constraint.getExpression())) {
			return true;
		}
		return false;
	}
	
	public static String getValidityColumnName(Table table) {
		String schemaName = getSchemaName(table);
		return MessageFormat.format(VALIDITY_COLUMN_NAME, schemaName);
	}

	public static String getDateColumnName(Table table) {
		String schemaName = getSchemaName(table);
		return MessageFormat.format(DATE_COLUMN_NAME, schemaName);
	}
	
	public static String getValidityColumnConstraint(Table table) {
		return MessageFormat.format(VALIDITY_COLUMN_CONSTRAINT, getValidityColumnName(table));
	}
	
	private static String getSchemaName(Table table) {
		return table.getOwner().getName();
	}

}
