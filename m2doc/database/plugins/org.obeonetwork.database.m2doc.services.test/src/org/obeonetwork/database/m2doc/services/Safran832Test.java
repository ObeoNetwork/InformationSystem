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
package org.obeonetwork.database.m2doc.services;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.obeonetwork.database.m2doc.services.common.AbstractTest;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.Sequence;
import org.obeonetwork.dsl.database.Table;

public class Safran832Test extends AbstractTest {
	/**
	 * the test database model.
	 */
	private DataBase dataBase;

	@Before
	public void setUp() {
		dataBase = loadModel("model/safran832.database");
	}

	@Test
	public void testAllTables() {
		Set<Table> tables = new DataBaseServices().allTables(dataBase);
		assertEquals(6, tables.size());
	}
	
	@Test
	public void testAllSequences() {
		Set<Sequence> sequences = new DataBaseServices().allSequences(dataBase);
		assertEquals(4, sequences.size());
	}

}
