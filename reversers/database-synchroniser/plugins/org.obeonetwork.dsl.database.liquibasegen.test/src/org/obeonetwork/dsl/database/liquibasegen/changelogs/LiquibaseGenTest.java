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
package org.obeonetwork.dsl.database.liquibasegen.changelogs;

import org.junit.Test;

/**
 * Test the liquibase generator
 *
 */
public class LiquibaseGenTest extends AbstractLiquibaseTest {

	/**
	 * Test the generation on change that only contains a single AddIndex change
	 */
	@Test
	public void addIndex() {
		assertGenerationEquals("15-addIndex-mysql");
	}

	@Test
	public void addSequence() {
		assertGenerationEquals("16-addSequence-oracle");
	}

	/**
	 * Test how the generator handle table creation with existing column
	 */
	@Test
	public void addTableWithColumns() {
		assertGenerationEquals("17-addTable-mysql");
	}

	/**
	 * Test how the generator handle table creation with a foreign key
	 */
	@Test
	public void addTableWithForeign() {
		assertGenerationEquals("19-addTableWithForeign-mysql");
	}

	/**
	 * Test how the generator handle add of view
	 */
	@Test
	public void addView() {
		assertGenerationEquals("18-AddView-mysql");
	}

	@Test
	public void dropTable() {
		// In this test an linked sequence is also dropped during the deleting of the
		// table
		// It explain the 2 cahgneSet presents in this changeLog file
		// This behavior should be challenged against real uses
		assertGenerationEquals("20-dropTable-mysql");
	}

	@Test
	public void renameTable() {
		assertGenerationEquals("21-renameTable-mysql");
	}

	@Test
	public void setCommentTable() {
		assertGenerationEquals("22-setCommentOnTable-oracle");
	}

	@Test
	public void addDateColumn() {
		assertGenerationEquals("23-addDateColumn-oracle");
	}

	@Test
	public void addEnumColumn() {
		assertGenerationEquals("24-addEnumColumn-mysql");
	}

	@Test
	public void deleteColumn() {
		assertGenerationEquals("25-deleteColumn-oracle");
	}

	@Test
	public void renameColumn() {
		assertGenerationEquals("26-renameColumn-mysql");
	}

	@Test
	public void changeColumnType() {
		assertGenerationEquals("27-changeColumnDataType-h2");
	}

	@Test
	public void changeColumnPrecisionType() {
		assertGenerationEquals("28-changeColumnTypePrecision-h2");
	}

	@Test
	public void changeColumnPrecisionLength() {
		assertGenerationEquals("29-changeColumnTypeLength-h2");
	}

	@Test
	public void changeColumnAddNullable() {
		assertGenerationEquals("30-changeColumnAddNullable-h2");
	}

	@Test
	public void changeColumnAddNonNull() {
		assertGenerationEquals("31-changeColumnAddNonNull-h2");
	}

	@Test
	public void changeColumnDefaultValue() {
		assertGenerationEquals("33-changeColumnDefaultValue-h2");
	}

	/**
	 * Add a primary in a existing table that reference two existing columns
	 */
	@Test
	public void addPrimaryKeyWith2Columns() {
		assertGenerationEquals("34-addPrimaryKeyMultipleColumn-h2");
	}

	/**
	 * New table with 2 columns and a primary composed of those 2 columns
	 */
	@Test
	public void addTableWithComposedPrimaryKey() {
		assertGenerationEquals("35-addTableWithComposedPrimaryKey");
	}

	/**
	 * New primary key that reference a new column and an existing one
	 */
	@Test
	public void addComposedPrimaryKeyMixed() {
		assertGenerationEquals("36-addPrimaryComposedMixed-mysql");
	}

	/**
	 * Change the comment on a column
	 */
	@Test
	public void changeCommentOnColumn() {
		assertGenerationEquals("37-changeCommnetOnColumns-mysql");
	}

	/**
	 * Drops a primary key on a MySql model
	 */
	@Test
	public void dropPrimaryKey() {
		assertGenerationEquals("39-dropPrimaryKey-mysql");
	}

	/**
	 * Updates 3 primary keys
	 * 
	 * <p>
	 * <ul>
	 * <li>Add one column</li>
	 * <li>Remove one column</li<<li>Rename</li>
	 * </ul>
	 * </p>
	 */
	@Test
	public void updatePrimareyKeys() {
		assertGenerationEquals("40-updatePrimKeys-mysql");
	}

	@Test
	public void dropCheckConstraint() {
		assertGenerationEquals("41-dropContraint-mysql");
	}

	/**
	 * Rename an existing constraint
	 */
	@Test
	public void updateConstraint() {
		assertGenerationEquals("42-constraintUpdate-h2");
	}

	@Test
	public void dropForeignKey() {
		assertGenerationEquals("43-dropForeingKey_postgres");
	}

	@Test
	public void updateForeignKey() {
		assertGenerationEquals("44-updateForeignKey-postgres");
	}

	@Test
	public void dropIndex() {
		assertGenerationEquals("45-dropIndex-oracle");
	}

	@Test
	public void updateIndex() {
		assertGenerationEquals("46-updateIndex-mysql");
	}

	@Test
	public void dropSequence() {
		assertGenerationEquals("47-dropSequence-oracle");
	}

	@Test
	public void updateSequenceName() {
		assertGenerationEquals("48-updateSequenceName-oracle");
	}

	/**
	 * Modify all sequence properties (except its name)
	 */
	@Test
	public void updateSequenceProps() {
		assertGenerationEquals("49-updateSequenceProps-oracle");
	}

	@Test
	public void dropView() {
		assertGenerationEquals("50-dropView-mysql");
	}

	@Test
	public void updateView() {
		assertGenerationEquals("51-updateView-mysql");
	}


	@Test
	public void representativeModelFromScratch_MySQL() throws Exception {
		assertGenerationFromScratchEquals("38-representativeModel", "video-mysql.database", "mysql-expected");
	}
	
	@Test
	public void representativeModelFromScratch_MySQL_WithCreateSchemaIfNotExistsFalse() throws Exception {
		//Passing false for parameter createSchemaSchemaIfNotExists must have no effect.
		// * i.e., the same result as without that parameter.
		assertGenerationFromScratchEquals("38-representativeModel", "video-mysql.database", "mysql-expected", false);
	}

	@Test
	public void representativeModelFromScratch_Oracle() throws Exception {
		assertGenerationFromScratchEquals("38-representativeModel", "video-oracle.database", "oracle-expected");
	}
	
	@Test
	public void representativeModelFromScratch_Oracle_WithCreateSchemaIfNotExistsFalse() throws Exception {
		//Passing false for parameter createSchemaSchemaIfNotExists must have no effect.
		// * i.e., the same result as without that parameter.
		assertGenerationFromScratchEquals("38-representativeModel", "video-oracle.database", "oracle-expected", false);
	}

	@Test
	public void representativeModelFromScratch_H2() throws Exception {
		assertGenerationFromScratchEquals("38-representativeModel", "video-h2.database", "h2-expected");
	}
	
	@Test
	public void representativeModelFromScratch_H2_WithCreateSchemaIfNotExistsFalse() throws Exception {
		//Passing false for parameter createSchemaSchemaIfNotExists must have no effect.
		// * i.e., the same result as without that parameter.
		assertGenerationFromScratchEquals("38-representativeModel", "video-h2.database", "h2-expected", false);
	}
	

	@Test
	public void representativeModelFromScratch_Postgres() throws Exception {
		assertGenerationFromScratchEquals("38-representativeModel", "video-postgres.database", "postgres-expected");
	}
	
	@Test
	public void representativeModelFromScratch_WithCreateSchemaIfNotExistsFalse() throws Exception {
		//Passing false for parameter createSchemaSchemaIfNotExists must have no effect.
		// * i.e., the same result as without that parameter.
		assertGenerationFromScratchEquals("38-representativeModel", "video-postgres.database", "postgres-expected", false);
	}
	
	@Test
	public void addSchemaWithCreateSchemaIfNotExists() {
		assertGenerationEquals("03-add-schema", true);
	}
	
}
