/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
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

public class ForeignKeySQLGenTestDisabled extends AbtractGeneratorTest {

	@Override
	protected SQLGenerator createGenerator(Comparison databaseChangeSet, File folder) throws Exception {
		DatabaseGen foreignKeyGen = new DatabaseGen(databaseChangeSet, folder, getArguments());
		return foreignKeyGen;
	}

	@Test
	public void createForeignKey() throws Exception {
		assertGen("fk/create-fk", "create-fk.sql");
	}

	@Test
	public void dropForeignKey() throws Exception {
		assertGen("fk/drop-fk", "drop-fk.sql");
	}

	@Test
	public void alterForeignKey() throws Exception {
		assertGen("fk/update-fk", "alter-fk.sql");
	}

}
