/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.database.m2doc.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Before;
import org.junit.Test;
import org.obeonetwork.database.m2doc.services.common.AbstractTest;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.Table;

public class TableServicesTest extends AbstractTest {
	/**
	 * the test database model.
	 */
	private DataBase dataBase;

	@Before
	public void setUp() {
		dataBase = loadModel("model/serie-oracle.database");
	}

	private Table getGSSerieTable() {
		List<Table> tables = new ArrayList<Table>(new DataBaseServices().allTables(dataBase));
		for (Table table : tables) {
			if ("GS_SERIE".equals(table.getName())) {
				return table;
			}
		}
		return null;
	}

	@Test
	public void columnTest() {
		Table table = getGSSerieTable();
		assertEquals(7, new TableServices().pureColumns(table).size());
	}

	@Test
	public void columnNamesTest() {
		Table table = getGSSerieTable();
		System.out.println(table.getName());
		assertEquals(7, new TableServices().pureColumnNames(table).size());
	}

	@Test
	public void allColumnTest() {
		Table table = getGSSerieTable();
		System.out.println(table.getName());
		assertEquals(10, new TableServices().allColumns(table).size());
	}

	@Test
	public void allColumnNameTest() {
		Table table = getGSSerieTable();
		System.out.println(table.getName());
		assertEquals(10, new TableServices().allColumnNames(table).size());
	}

	@Test
	public void noPrimaryKeyNameTest() {
		Table table = (Table) EcoreUtil.create(DatabasePackage.eINSTANCE.getTable());
		assertEquals("", new TableServices().primaryKeyName(table));
	}

	@Test
	public void primaryKeyNameTest() {
		Table table = getGSSerieTable();
		assertEquals("GS_SERIE_PK", new TableServices().primaryKeyName(table));
	}
}
