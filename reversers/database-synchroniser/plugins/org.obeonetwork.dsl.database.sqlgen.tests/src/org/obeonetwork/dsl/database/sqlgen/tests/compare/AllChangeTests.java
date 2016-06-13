package org.obeonetwork.dsl.database.sqlgen.tests.compare;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TableChangeTest.class, PrimaryKeyChangeTest.class, ForeignKeyChangeTest.class, IndexChangeTest.class, ConstraintChangeTest.class, ColumnChangeTest.class })
public class AllChangeTests {
}
