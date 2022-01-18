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
package fr.gouv.mindef.safran.database.transfo;

import org.junit.Test;

public class MldToEntityTest extends AbstractTransformationTest {

	@Override
	String getModelsFolder() {
		return "/fr.gouv.mindef.safran.database.tests/models/mld2entity/";
	}

	@Test
	public void simpleDepuisScaffoldModel() {
		testMldToEntityWithScaffoldModel("2-simple-scaffoldmodel");
	}

	@Test
	public void medium() {
		testMldToEntity("3-medium");
	}

	@Test
	public void simpleAvecPkEtFK() {
		testMldToEntity("1-simple-pk-et-fk");
	}

	@Test
	public void complexeAvecScaffold() {
		testMldToEntityWithScaffoldModel("4-complexe-avec-scaffold");
	}

	@Test
	public void simpleAvecFKUnique() {
		testMldToEntity("5-simple-fk-unique-safran-130");
	}

	@Test
	public void multipleConstraintOnAnEntity() {
		testMldToEntity("6-multiple-constraints-on-entity");
	}

	@Test
	public void handlingSchemasWithScaffold() {
		testMldToEntityWithScaffoldModel("7-handling-schemas-with-scaffold");
	}

	@Test
	public void joinTable() {
		testMldToEntity("8-mindef-jointable");
	}

	@Test
	public void joinTableWithScaffold() {
		testMldToEntityWithScaffoldModel("9-mindef-jointable-with-scaffold");
	}

	@Test
	public void safran429SchemaComments() {
		testMldToEntity("10-safran-429-schema-comments");
	}

	@Test
	public void mindefSafran496() {
		testMldToEntity("11.1-safran-496-multiple-indexes-per-entity---create");
		testMldToEntity("11.2-safran-496-multiple-indexes-per-entity---update");
	}

}
