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
package org.obeonetwork.dsl.database.sqlgen.tests.sqlgen;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.eclipse.emf.compare.Comparison;
import org.junit.Test;
import org.obeonetwork.dsl.database.sqlgen.DatabaseGen;
import org.obeonetwork.dsl.database.sqlgen.SQLGenerator;

public class DatabaseSQLGenTestDisabled extends AbtractGeneratorTest {

	
	@Override
	protected SQLGenerator createGenerator(Comparison databaseChangeSet, File folder) throws Exception {		
		DatabaseGen databaseGen = new DatabaseGen(databaseChangeSet, folder, getArguments());
		return databaseGen;
	}
	
	@Test
	public void createAllDatabase() throws Exception {
		File folder = new File("testFolder");
		String testCase = "db/db1";
		java.sql.Timestamp timeStampDate = new Timestamp(System.currentTimeMillis()); 
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	String timestamp = formatter.format(timeStampDate);
		String folderPath = folder.getAbsolutePath()+ File.separator + "" + timestamp+ File.separator;
		GeneratedFile createTableScript = new GeneratedFile(folderPath+"create-tables.sql", testCase + File.separator + "create-tables-expected.sql");
		GeneratedFile createPKScript = new GeneratedFile(folderPath+"create-fk.sql", testCase + File.separator + "create-fk-expected.sql");
		GeneratedFile createFKScript = new GeneratedFile(folderPath+"create-pk.sql", testCase + File.separator + "create-pk-expected.sql");
		GeneratedFile createIndexScript = new GeneratedFile(folderPath+"create-index.sql", testCase + File.separator + "create-index-expected.sql");
		GeneratedFile createConstraintScript = new GeneratedFile(folderPath+"create-constraint.sql", testCase + File.separator + "create-constraint-expected.sql");
		assertGen(testCase, createTableScript, createPKScript, createFKScript, createIndexScript, createConstraintScript);
	}
	
}
