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
package org.obeonetwork.dsl.database.sqlgen.tests.sqlgen;

import java.io.File;

import org.eclipse.emf.compare.Comparison;
import org.junit.Test;
import org.obeonetwork.dsl.database.sqlgen.DatabaseGen;
import org.obeonetwork.dsl.database.sqlgen.SQLGenerator;

public class IndexSQLGenTestDisabled extends AbtractGeneratorTest {

	@Override
	protected SQLGenerator createGenerator(Comparison databaseChangeSet, File folder) throws Exception {
		DatabaseGen indexGen = new DatabaseGen(databaseChangeSet, folder, getArguments());
		return indexGen;
	}

	@Test
	public void createIndex() throws Exception {
		assertGen("index/create-index", "create-index.sql");
	}
	
	@Test
	public void createUniqueIndex() throws Exception {
		assertGen("index/create-index/unique", "create-index.sql");
	}

	@Test
	public void dropIndex() throws Exception {
		assertGen("index/drop-index", "drop-index.sql");
	}

	@Test
	public void alterIndex() throws Exception {
		assertGen("index/update-index", "alter-index.sql");
	}

}
