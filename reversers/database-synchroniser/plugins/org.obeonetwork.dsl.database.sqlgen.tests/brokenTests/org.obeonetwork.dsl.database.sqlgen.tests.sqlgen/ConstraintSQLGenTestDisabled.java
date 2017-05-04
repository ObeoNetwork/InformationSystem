/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.sqlgen.tests.sqlgen;

import java.io.File;

import org.eclipse.emf.compare.Comparison;
import org.junit.Test;
import org.obeonetwork.dsl.database.sqlgen.DatabaseGen;
import org.obeonetwork.dsl.database.sqlgen.SQLGenerator;

public class ConstraintSQLGenTestDisabled extends AbtractGeneratorTest {

	@Override
	protected SQLGenerator createGenerator(Comparison databaseChangeSet, File folder) throws Exception {
		DatabaseGen constraintGen = new DatabaseGen(databaseChangeSet, folder, getArguments());
		return constraintGen;
	}

	@Test
	public void createConstraint() throws Exception {
		assertGen("constraint/create-constraint", "create-constraint.sql");
	}

	@Test
	public void dropConstraint() throws Exception {
		assertGen("constraint/drop-constraint", "drop-constraint.sql");
	}

	@Test
	public void alterConstraint() throws Exception {
		assertGen("constraint/update-constraint/only-expression", "alter-constraint.sql");
	}

}
