<%--
  Copyright © 2008 Obeo
  All rights reserved.  This program and the accompanying materials
  are made available under the terms of the Eclipse Public License 1.0
  
  You can apply any license to the files generated with this template
  and Acceleo.
  
  Original contributor : Obeo - Jerome Benois
--%>
<%
metamodel http://www.obeonetwork.org/dsl/entity/2.0.0
import org.obeonetwork.dsl.entity.gen.java.common.common
import org.obeonetwork.dsl.entity.gen.java.common.requests
import org.obeonetwork.dsl.entity.gen.java.common.datatype
import org.obeonetwork.dsl.entity.gen.java.common.specifics
import org.obeonetwork.dsl.entity.gen.java.common.structure
import org.obeonetwork.dsl.entity.gen.java.hibernate.dao-hibernate-common
import org.obeonetwork.dsl.environment.gen.java.common.services.StringServices
import org.obeonetwork.dsl.environment.gen.java.common.common
import org.obeonetwork.dsl.entity.gen.java.dao.api.dao-common
%>

<%script type="Root" name="allTestPackage"%>
<%baseImports%><%if (projectName!=null){%>.<%projectName.toStandardNotation().toLowerCase().sep(".")%><%}%>

<%script type="Root" name="fullFilePath"%>
<%if ( getProperty("generate.tests")=="yes" ){%>
<%pathToTestJava%>/<%allTestPackage.toPath()%>/DAOAllTests.java  
<%}%>

<%script type="Root" name="generate" file="<%fullFilePath%>"%>
package <%allTestPackage%>;

// <%startUserCode%> for import 
import junit.framework.Test;
import junit.framework.TestSuite;

<%for (blocks.entities){%>
import <%hibernatePackage%>.test.<%name.toStandardNotation().toU1Case()%>Test;
<%}%>

// <%endUserCode%> for import

/**
 * Test class for All DAO Tests.
 */
public class DAOAllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Tests suite for DAOAllTests");
		
		<%for (blocks.entities){%>
		suite.addTestSuite(<%name.toStandardNotation().toU1Case()%>Test.class);
		<%}%>
		//<%startUserCode%> others unit tests
		
		//<%endUserCode%> others unit tests
		return suite;
	}

}
