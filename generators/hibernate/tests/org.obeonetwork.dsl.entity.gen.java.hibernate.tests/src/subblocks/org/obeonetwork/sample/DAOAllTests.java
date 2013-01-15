package org.obeonetwork.sample;

// Start of user code for import 
import junit.framework.Test;
import junit.framework.TestSuite;

import org.obeonetwork.sample.collections.composition.onetomanycomp.test
.OnetomanycompTest;
import org.obeonetwork.sample.collections.composition.onetoonecomp.test
.OnetoonecompTest;
import org.obeonetwork.sample.collections.associations.unidirectional.assounidionetomany.test
.AssounidionetomanyTest;
import org.obeonetwork.sample.collections.associations.unidirectional.assounidionetoone.test
.AssounidionetooneTest;
import org.obeonetwork.sample.collections.associations.unidirectional.assounidimanytoone.test
.AssounidimanytooneTest;
import org.obeonetwork.sample.collections.associations.unidirectional.assounidimanytomany.test
.AssounidimanytomanyTest;
import org.obeonetwork.sample.collections.associations.bidirectional.assobidionetomany.test
.AssobidionetomanyTest;
import org.obeonetwork.sample.collections.associations.bidirectional.assobidimanytomany.test
.AssobidimanytomanyTest;
import org.obeonetwork.sample.collections.associations.bidirectional.assobidionetoone.test
.AssobidionetooneTest;
import org.obeonetwork.sample.collections.associations.bidirectional.assobidimanytoone.test
.AssobidimanytooneTest;
import org.obeonetwork.sample.inheritence.tableperhierarchy.test
.TableperhierarchyTest;
import org.obeonetwork.sample.inheritence.tablepersubclass.test
.TablepersubclassTest;
import org.obeonetwork.sample.attributes.test
.AttributesTest;

// End of user code

/**
 * Test class for All DAO Tests.
 */
public class DAOAllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Tests suite for DAOAllTests");
		
		suite.addTestSuite(OnetomanycompTest.class);
		suite.addTestSuite(OnetoonecompTest.class);
		suite.addTestSuite(AssounidionetomanyTest.class);
		suite.addTestSuite(AssounidionetooneTest.class);
		suite.addTestSuite(AssounidimanytooneTest.class);
		suite.addTestSuite(AssounidimanytomanyTest.class);
		suite.addTestSuite(AssobidionetomanyTest.class);
		suite.addTestSuite(AssobidimanytomanyTest.class);
		suite.addTestSuite(AssobidionetooneTest.class);
		suite.addTestSuite(AssobidimanytooneTest.class);
		suite.addTestSuite(TableperhierarchyTest.class);
		suite.addTestSuite(TablepersubclassTest.class);
		suite.addTestSuite(AttributesTest.class);
		//Start of user code others unit tests
		
		//End of user code
		return suite;
	}

}
