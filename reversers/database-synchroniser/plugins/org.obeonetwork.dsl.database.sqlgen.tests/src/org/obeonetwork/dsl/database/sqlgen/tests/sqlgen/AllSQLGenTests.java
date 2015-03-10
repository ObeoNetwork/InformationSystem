package org.obeonetwork.dsl.database.sqlgen.tests.sqlgen;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TableSQLGenTest.class, PrimaryKeySQLGenTest.class, ForeignKeySQLGenTest.class, IndexSQLGenTest.class, ConstraintSQLGenTest.class, DatabaseSQLGenTest.class })
public class AllSQLGenTests {
}
