/*******************************************************************************
 * Copyright (c) 2020 Obeo.
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
	 * @param constraint a valid constraint
	 * @return a SQL query
	 * @see #validateConstaint(Constraint)
	 */
	public String buildAddConstraintQuery(Constraint constraint) {
		String tableName = constraint.getOwner().getName().trim();
		String constrainteName = constraint.getName().trim();
		String expression = constraint.getExpression();
		return "ALTER TABLE " + tableName + " ADD CONSTRAINT " + constrainteName + " CHECK(" + expression + ");";
	}

}
