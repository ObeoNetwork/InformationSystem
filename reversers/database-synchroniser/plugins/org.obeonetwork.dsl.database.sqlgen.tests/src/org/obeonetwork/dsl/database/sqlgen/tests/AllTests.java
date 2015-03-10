package org.obeonetwork.dsl.database.sqlgen.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.obeonetwork.dsl.database.sqlgen.tests.compare.AllChangeTests;
import org.obeonetwork.dsl.database.sqlgen.tests.sqlgen.AllSQLGenTests;

@RunWith(Suite.class)
@SuiteClasses({ AllChangeTests.class, AllSQLGenTests.class })
public class AllTests {
}
