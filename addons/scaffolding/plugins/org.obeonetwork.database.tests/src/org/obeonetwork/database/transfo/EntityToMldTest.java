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
package org.obeonetwork.database.transfo;


import org.junit.Test;

public class EntityToMldTest extends AbstractTransformationTest {

	@Override
	String getModelsFolder() {
		return "/org.obeonetwork.database.tests/models/entity2mld/";
	}

	@Test
	public void mediumEnDirect() {
		testEntityToMld("2-medium");
	}
	
	@Test
	public void mediumAvecScaffoldModel() {
		testEntityToMldWithScaffoldModel("2-medium");
	}
	
	@Test
	public void simpleAvecPkEtFk() {
		testEntityToMld("1-simple-pk-et-fk");
	}
	
	@Test
	public void sansCreationchampsTechniques() {
		testEntityToMld("23-sans-champs-techniques");
	}
	
	@Test
	public void referenceSupprimee() {
		testEntityToMldWithScaffoldModel("3-reference-supprimee");
	}
	
	@Test
	public void safran130Inverse() {
		testEntityToMld("4-safran-130-inverse");
	}
	
	@Test
	public void safran153ColumnLostInIndex() {
		testEntityToMldWithScaffoldModel("5-column-lost-in-index");
	}
	
	@Test
	public void safran156() {
		testEntityToMld("6-safran-156");
	}
	
	@Test
	public void multipleConstraintOnAnEntity() {
		testEntityToMld("7-multiple-constraints-on-entity");
	}
	
	@Test
	public void indexOnFk() {
		testEntityToMld("8-index-on-fk");
	}
	
	@Test
	public void handlingMultipleSchemas() {
		testEntityToMld("9-handling-schemas");
	}
	
	@Test
	public void handlingMultipleSchemasWithScaffold() {
		testEntityToMldWithScaffoldModel("10-handling-schemas-with-scaffold");
	}
	
	@Test
	public void renameTableWithScaffold() {
		testEntityToMldWithScaffoldModel("11-rename-table");
	}
	
	@Test
	public void multipleFKs() {
		testEntityToMld("12-multiple-fk");
	}
	
	@Test
	public void mindefCas1() {
		testEntityToMld("13-mindef-cas1");
	}
	
	@Test
	public void mindefCas2() {
		testEntityToMld("14-mindef-cas2");
	}
	
	@Test
	public void mindefCas3() {
		testEntityToMld("15-mindef-cas3");
	}
	
	@Test
	public void mindefCas4() {
		testEntityToMld("16-mindef-cas4");
	}
	
	@Test
	public void mindefCas5() {
		testEntityToMld("17-mindef-cas5");
	}
	
	@Test
	public void mindefSafran189() {
		testEntityToMld("18-safran-189");
	}
	
	@Test
	public void mindefSafran336() {
		testEntityToMld("19-safran-336-attribut-sans-type");
	}
	
	@Test
	public void mindefSafran428() {
		testEntityToMld("20-safran-428-associatedTypes");
	}
	
	@Test
	public void mindefSafran429() {
		testEntityToMld("21-safran-429-namespace-description");
	}
	
	@Test
	public void mindefSafran496(){
		testEntityToMld("22.1-safran-496-multiple-indexes-per-entity---initial");
		testEntityToMld("22.2-safran-496-multiple-indexes-per-entity---create");
		testEntityToMld("22.3-safran-496-multiple-indexes-per-entity---update");
	}
	
	@Test
	public void minarmSafran711() {
		testEntityToMld("24.1-safran-711-simple-target");
		testEntityToMld("24.2-safran-711-double-target");
	}
	
	@Test
	public void minarmSafran712() {
		testEntityToMld("25.1-safran-712-two-bidirectionnal-references");
		testEntityToMld("25.2-safran-712-two-bidirectionnal-containments");
		testEntityToMld("25.3-safran-712-two-bidirectionnal-reference-different-namespaces");
	}
	
	@Test
	public void minarmSafran715() {
		testEntityToMld("26.1-safran-715-simple-reflexive");
		testEntityToMld("26.2-safran-715-multiple-reflexive");
		testEntityToMld("26.3-safran-715-reflexive-target-name");
		
	}
}
