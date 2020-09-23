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
package org.obeonetwork.dsl.database.liquibasegen;

import org.junit.Test;

/**
 * Test the liquibase generator
 *
 */
public class LiquibaseGenTests extends AbstractLiquibaseTest {

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
}
