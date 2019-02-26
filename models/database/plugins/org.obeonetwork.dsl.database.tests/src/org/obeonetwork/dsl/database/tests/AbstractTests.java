package org.obeonetwork.dsl.database.tests;

import org.junit.AfterClass;
import org.junit.Before;
import org.obeonetwork.dsl.database.tests.utils.TestUtils;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;

public abstract class AbstractTests {
	
	public static final String DATABASE_NAME_DEFAULT = "northwind";
	protected static Liquibase liquibase;
	protected static Database database;
	
	@Before
	public void setUpBeforeTest() throws LiquibaseException {
		// Initialize the database with liquibase.
		liquibase = TestUtils.createAndInitializeLiquibase("resources/northwind-liquibase.xml", database);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws DatabaseException {
		// Remove the content of the database.
		if (liquibase != null) {
			liquibase.dropAll();
		}
		
		if (database != null) {
			database.close();
		}
		
	}
}
