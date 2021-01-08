/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.liquibasegen.service;

import java.text.MessageFormat;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.obeonetwork.dsl.database.Constraint;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.gen.common.services.StatusUtils;

public class SQLService {

	private static final String EMPTY = "";

	public SQLService() {
		super();
	}

	/**
	 * Validates a {@link Constraint} information before building a SQL query with
	 * it
	 * 
	 * @param constraint a non <code>null</code> constraint
	 * @return a {@link IStatus}
	 */
	public IStatus validateConstaint(Constraint constraint) {
		Table table = constraint.getOwner();
		if (table == null || table.getName() == null) {
			return StatusUtils.createErrorStatus(
					MessageFormat.format("Constraint with no table (technical ID {0})", constraint.getTechID()));
		} else if (constraint.getName() == null) {
			return StatusUtils.createErrorStatus(
					MessageFormat.format("Constraint with no name (technical ID {0})", constraint.getTechID()));
		} else if (constraint.getExpression() == null) {
			return StatusUtils.createErrorStatus(
					MessageFormat.format("Constraint with no exrepssion (technical ID {0})", constraint.getTechID()));
		}

		return Status.OK_STATUS;
	}

	/**
	 * Builds the SQL query that add a constraint defined by the given
	 * {@link Constraint}
	 * 
	 * @param tableQname     qualified name of the table
	 * @param constraintName name of the constraint
	 * @param expression     the expression
	 * @return a SQL query
	 * @see #validateConstaint(Constraint)
	 */
	public String buildAddConstraintQuery(String tableQname, String constraintName, String expression) {
		return "ALTER TABLE " + trimEmptyOnNull(tableQname) + " ADD CONSTRAINT " + trimEmptyOnNull(constraintName)
				+ " CHECK(" + trimEmptyOnNull(expression) + ");";
	}

	/**
	 * Drops the given constraint
	 * 
	 * @param tableQName    qualified name of the table
	 * @param contraintName name of the constraint
	 * @return a SQL query
	 */
	public String buildDropConstraintQuery(String tableQName, String contraintName) {
		return "ALTER TABLE " + trimEmptyOnNull(tableQName) + " DROP CONSTRAINT " + trimEmptyOnNull(contraintName)
				+ ";";
	}

	private String trimEmptyOnNull(String s) {
		return s != null ? s.trim() : EMPTY;
	}

}
