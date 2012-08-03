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
import org.obeonetwork.dsl.entity.gen.java.spring.applicationContext
import org.obeonetwork.dsl.entity.gen.java.spring.applicationContext-test
import org.obeonetwork.dsl.entity.gen.java.dao.api.dao-factory-package
import org.obeonetwork.dsl.entity.gen.java.dao.api.dao-factory
%>

<%-- no override needed since hibernatePackage is defined both for Entity and Package--%>
<%script type="EObject" name="hibernateTestPackage" post="trim()"%>
<%for (DAOScope){%>
<%hibernatePackage%>.test
<%}%>

<%-- to override --%>
<%script type="EObject" name="DAOScope"%>
<%self.filter("Block")%>

<%-- to override if DAO per Entity --%>
<%script type="Block" name="scopedEntities"%>
<%entities%>

<%-- to override if DAO per Entity --%>
<%script type="Block" name="externalDAOs"%>
<%entities.references[isMandatory && isNavigable].type.block.minimize() - self()%>

<%-- to override if DAO per Entity --%>
<%script type="Entity" name="DAOName"%>
<%block.DAOName%>

<%script type="Block" name="DAOName"%>
<%name.toStandardNotation().toL1Case()%>Dao

<%-- no override needed since name is defined both for Entity and Package--%>
<%script type="EObject" name="testClassName" post="trim()"%>
<%for (DAOScope){%>
<%name.toStandardNotation.toU1Case()%>Test
<%}%>

<%-- no override needed since daoFactoryPackage and DAOFactoryName are defined both for Entity and Package--%>
<%script type="EObject" name="importDAOFactory"%>
<%for (DAOScope){%>
import <%daoFactoryPackage%>.<%DAOFactoryName%>;
<%}%>

<%script type="Block" name="hibernateDAOJUnitFilePath"%>
<%if (getProperty("generate.tests")=="yes" && entities.nSize()>0){%>
<%pathToTestJava%>/<%hibernateTestPackage.toPath()%>/<%testClassName%>.java
<%}%>

<%script type="EObject" name="baseTestClassQualifiedName"%>
<%baseTestClassPackage%>.<%baseTestClass%>;

<%script type="EObject" name="importBaseTestClass"%>
import <%baseTestClassQualifiedName%>

<%script type="Block" name="hibernateDAO-JUnit" file="<%hibernateDAOJUnitFilePath%>"%>
<%generate%>

<%script type="EObject" name="generate"%>
<%for (DAOScope){%>
package <%hibernateTestPackage%>;

// <%startUserCode%> for import 
<%if (scopedEntities.ownedAttributes[type.name == "Date"]){%>
import java.util.Date;
<%}%>
<%if (scopedEntities.ownedAttributes[isMultiValuated]){%>
import java.util.ArrayList;
import java.util.List;
<%}%>

<%importHibernateTransaction%>
<%importBaseTestClass%>
<%importDaoException%>
<%importHibernateUtil%>
<%importDAOFactory%>
import junit.framework.Assert;

import <%daoInterfaceQualifiedName%>;
<%for (scopedEntities){%>
import <%entityQualifiedName%>;
	<%for (references[isNavigable() && isMandatory]){%>
import <%type.entityQualifiedName%>;
	<%}%>
<%}%>
<%for (externalDAOs){%>
import <%daoInterfaceQualifiedName%>;
<%}%>

// <%endUserCode%> for import

/**
 * Test class for <%name%>.
 */
public class <%testClassName%> extends <%baseTestClass%> {
<%testFeatures%>
<%setUp%>
<%tearDown%>
<%scopedEntities.generateTests%>

<%scopedEntities.generateExamples%>
    
    // <%startUserCode%> of specific tests
    // <%endUserCode%> of specific tests

}
<%}%>

<%-- to override according to framework --%>
<%script type="EObject" name="baseTestClassPackage"%>
junit.framework

<%-- to override according to framework --%>
<%script type="EObject" name="baseTestClass"%>
TestCase

<%-- to override according to framework --%>
<%script type="EObject" name="importHibernateTransaction"%>
import org.hibernate.Transaction;

<%-- to override according to framework --%>
<%script type="EObject" name="testFeatures" post="indentTab()"%>
<%for (DAOScope){%>
<%for (self + externalDAOs){%>

/**
 * The DAO for class <%name%>.
 */
private <%daoInterfaceName%> <%DAOName%>;
<%}%>

/**
 * The transaction that will be used.
 */
private Transaction tx;

<%}%>

<%-- to override according to framework --%>
<%script type="EObject" name="setUp" post="indentTab()"%>
<%for (DAOScope){%>

/**
 * Sets up the test before its execution, by creating the dao and the
 * transaction.
 * @throws Exception if an unexpected exception occurs.
 */
@Override
protected void setUp() throws Exception {
    super.setUp();
<%for (self + externalDAOs){%>
	<%DAOName%> = <%DAOFactoryName%>.<%DAOGetterName%>();
<%}%>
	tx = HibernateUtil.currentSession().beginTransaction();
}
<%}%>

<%-- to override according to framework --%>
<%script type="EObject" name="tearDown" post="indentTab()"%>
<%for (DAOScope){%>

/**
 * Cleans up the test after its execution, by commiting the transaction in
 * order for the DB changes to become visible, and closing hibernate's
 * session.
 * @throws Exception if an unexpected exception occurs.
 */
@Override
protected void tearDown() throws Exception {
    super.tearDown();
	tx.commit();
    HibernateUtil.closeSession();
}
<%}%>

<%script type="Entity" name="generateTests"%>
    /**
     * Tests the creation of the entity <%name%>.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreate<%name.toStandardNotation()%>() throws DaoException {
        // fill attributes with example values
        <%name.toStandardNotation().toU1Case()%> <%name.toStandardNotation().toL1Case()%> = get<%name.toStandardNotation()..toU1Case()%>Example();
        
        // Execute the tested code
        <%DAOName%>.create<%name.toStandardNotation()%>(<%name.toStandardNotation().toL1Case()%>);

        // Verify result
        boolean found = false;
        for (<%name.toStandardNotation.toU1Case()%> current<%name.toStandardNotation()%> : <%DAOName%>.findAll<%name.toStandardNotation()%>s()) {
            if (current<%name.toStandardNotation()%>.equals(<%name.toStandardNotation().toL1Case()%>)) {
                found = true;
            }
        }
        Assert.assertTrue("<%name%> not created", found);
    }

    /**
     * Test the modification of an entity <%name%>.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdate<%name.toStandardNotation()%>() throws DaoException {
        // Initialized the test
        <%name.toStandardNotation().toU1Case()%> <%name.toStandardNotation().toL1Case()%> = get<%name.toStandardNotation().toU1Case()%>Example();
        <%DAOName%>.create<%name.toStandardNotation()%>(<%name.toStandardNotation().toL1Case()%>);

        // Execute the tested code
        <%for (ownedAttributes){%>
            <%if (isMonoValuated){%>
        <%entity.name.toStandardNotation().toL1Case()%>.set<%name.toStandardNotation().toU1Case()%>(<%exampleValues2%>);
            <%}%>
        <%}%>
        <%DAOName%>.update<%name.toStandardNotation()%>(<%name.toStandardNotation().toL1Case()%>);

        // Verify result
        boolean found = false;
        for (<%name.toStandardNotation().toU1Case()%> current<%name.toStandardNotation()%> : <%DAOName%>.findAll<%name.toStandardNotation()%>s()) {
            if (current<%name.toStandardNotation()%>.equals(<%name.toStandardNotation().toL1Case()%>)) {
                found = true;
                <%for (ownedAttributes){%>
                    <%if (isMonoValuated){%>
                Assert.assertEquals("Value <%name.toStandardNotation().toL1Case()%> not modified",
                        <%exampleValues2%>,
                        <%entity.name.toStandardNotation().toL1Case()%>.get<%name.toStandardNotation().toU1Case()%>());
                    <%}%>
                <%}%>
            }
        }
        Assert.assertTrue("<%name.toStandardNotation()%> not found", found);
    }

    /**
     * Test the suppression of an entity <%name%>.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDelete<%name.toStandardNotation()%>() throws DaoException {
        // Initialized the test
        <%name.toStandardNotation().toU1Case()%> <%name.toStandardNotation().toL1Case()%> = get<%name.toStandardNotation().toU1Case()%>Example();
        <%DAOName%>.create<%name.toStandardNotation()%>(<%name.toStandardNotation().toL1Case()%>);
        
        // Execute the tested code
        <%DAOName%>.delete<%name.toStandardNotation()%>(<%name.toStandardNotation().toL1Case()%>);
        
        // Verify result
        boolean found = false;
        for (<%name.toStandardNotation().toU1Case()%> current<%name.toStandardNotation()%> : <%DAOName%>.findAll<%name.toStandardNotation()%>s()) {
            if (current<%name.toStandardNotation()%>.getId().equals(<%name.toStandardNotation().toL1Case()%>.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("<%name.toStandardNotation()%> not deleted", found);
    }

    /**
     * Test the search of all entities <%name%>.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAll<%name.toStandardNotation()%>s() throws DaoException {
        // Verify number of element before testing
        int before = <%DAOName%>.findAll<%name.toStandardNotation()%>s().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        <%name.toStandardNotation().toU1Case()%> <%name.toStandardNotation().toL1Case()%>1 = get<%name.toStandardNotation().toU1Case()%>Example();
        <%DAOName%>.create<%name.toStandardNotation()%>(<%name.toStandardNotation().toL1Case()%>1);
                
        <%name.toStandardNotation.toU1Case()%> <%name.toStandardNotation().toL1Case()%>2 = get<%name.toStandardNotation().toU1Case()%>Example();
        <%DAOName%>.create<%name.toStandardNotation()%>(<%name.toStandardNotation().toL1Case()%>2);

        // Verify result
        int after = <%DAOName%>.findAll<%name.toStandardNotation().toStandardNotation()%>s().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }

<%script type="Attribute" name="exampleValues" post="trim"%>
<%if (type.name == "Integer" || toJavaType == "Integer"){%>
    new Integer(<%name.uniqueCode()%> + 1)
<%}else if (type.name == "Long" || toJavaType == "Long"){%>
    new Long(<%name.uniqueCode()%> + 1)
<%}else if (type.name == "String" || type.name == "Email" || toJavaType == "String"){%>
    "my<%name.toU1Case()%>"
<%}else if (type.name == "Boolean" || toJavaType == "Boolean"){%>
    new Boolean(false)
<%}else if (type.name == "Date" || toJavaType == "Date"){%>
    new Date(0)
<%}else if (type.name.equalsIgnoreCase("Double") || toJavaType == "Double"){%>
    new Double(<%name.uniqueCode()%>.1)
<%}else if (type.name.equalsIgnoreCase("Float") || toJavaType == "Float"){%>
    new Float(<%name.uniqueCode()%>.1)
<%}else if( toJavaType.length() > 0){%>
	new <%toJavaType%>()
<%}else{%>
    new <%type.name%>()
<%}%>

<%script type="Attribute" name="exampleValues2" post="trim"%>
<%if (type.name == "Integer" || toJavaType == "Integer"){%>
    new Integer(<%name.uniqueCode()%>)
<%}else if (type.name == "Long" || toJavaType == "Long"){%>
    new Long(<%name.uniqueCode()%>)
<%}else if (type.name == "String" || type.name == "Email" || toJavaType == "String"){%>
    "second<%name.toU1Case()%>"
<%}else if (type.name == "Boolean" || toJavaType == "Boolean"){%>
    new Boolean(false)
<%}else if (type.name == "Date" || toJavaType == "Date"){%>
    new Date(1)
<%}else if (type.name.equalsIgnoreCase("Double") || toJavaType == "Double"){%>
    new Double(<%name.uniqueCode()%>.0)
<%}else if (type.name.equalsIgnoreCase("Float") || toJavaType == "Float"){%>
    new Float(<%name.uniqueCode()%>.0)
<%}else if( toJavaType.length() > 0){%>
	new <%toJavaType%>()
<%}else{%>
    new <%type.name%>()
<%}%>

<%script type="Entity" name="exampleVariableName"%>
<%name.toStandardNotation().toL1Case()%>

<%script type="Reference" name="exampleVariableName"%>
<%name.toStandardNotation().toL1Case()%>Example

<%script type="Entity" name="generateExamples"%>

   /**
     * Creates an example of <%name%>.
     * @return Returns a new instance of class <%name%>, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected <%name.toStandardNotation().toU1Case()%> get<%name.toStandardNotation().toU1Case()%>Example() throws DaoException {
        // fill attributes with example values
        <%name.toStandardNotation().toU1Case()%> <%exampleVariableName%> = new <%name.toStandardNotation().toU1Case()%>();
        <%-- Member attributes --%>
<%generatePopulateAttribute(exampleVariableName)%>
<%generatePopulateReference(exampleVariableName)%>
        return <%name.toStandardNotation().toL1Case()%>;
    }
    
    /**
     * Creates a second example of <%name%> with other values.
     * @return Returns a new instance of class <%name%> with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected <%name.toStandardNotation().toU1Case()%> get<%name.toStandardNotation().toU1Case()%>Example2() throws DaoException {
        // fill attributes with example values
        <%name.toStandardNotation().toU1Case()%> <%exampleVariableName%> = new <%name.toStandardNotation().toU1Case()%>();
        <%-- Member attributes --%>
<%generatePopulateAttribute2(exampleVariableName)%>
<%generatePopulateReference(exampleVariableName)%>
        return <%name.toStandardNotation().toL1Case()%>;
    }

<%script type="Entity" name="generatePopulateAttribute"%>
<%for (attributes){%>
	<%if (isMonoValuated){%>
        <%args(0)%>.set<%name.toStandardNotation().toU1Case()%>(<%exampleValues%>);
	<%}else{%>
        List<<%type.name.toStandardNotation()%>> list<%name.toU1Case()%> = new ArrayList<<%type.name.toStandardNotation()%>>();
        list<%name.toStandardNotation().toU1Case()%>.add(<%exampleValues%>);
        <%args(0)%>.set<%name.toU1Case()%>(list<%name.toStandardNotation().toU1Case()%>);
	<%}%>
<%}%>

<%script type="Entity" name="generatePopulateAttribute2"%>
<%for (attributes){%>
	<%if (isMonoValuated){%>
        <%args(0)%>.set<%name.toStandardNotation().toU1Case()%>(<%exampleValues2%>);
	<%}else{%>
        List<<%type.name.toStandardNotation()%>> list<%name.toStandardNotation().toU1Case()%> = new ArrayList<<%type.name.toStandardNotation()%>>();
        list<%name.toStandardNotation().toU1Case()%>.add(<%exampleValues2%>);
        <%args(0)%>.set<%name.toStandardNotation().toU1Case()%>(list<%name.toStandardNotation().toU1Case()%>);
	<%}%>
<%}%>

<%script type="Entity" name="generatePopulateReference"%>
<%for (references[isNavigable && isMandatory]){%>
<%generatePrincipalPopulateReference(args(0))%>
<%}%>

<%script type="Reference" name="generatePrincipalPopulateReference"%> 
        <%type.name.toStandardNotation()%> <%exampleVariableName%> = new <%type.name.toStandardNotation()%>();
<%if (isMonoValuated){%>
        <%args(0)%>.set<%name.toStandardNotation().toU1Case()%>(<%exampleVariableName%>);   
<%}else{%>
        <%args(0)%>.get<%name.toStandardNotation().toU1Case()%>().add(<%exampleVariableName%>);
<%}%>
<%if (isBidirectional){%> 
	<%if (isUnique){%>
        <%exampleVariableName%>.set<%oppositeOf.name.toStandardNotation().toU1Case()%>(<%args(0)%>); 
	<%}else{%>
        <%exampleVariableName%>.get<%oppositeOf.name.toStandardNotation().toU1Case()%>().add(<%args(0)%>);        
	<%}%>
<%}%>
        <%type.DAOName%>.create<%type.name.toStandardNotation()%>(<%exampleVariableName%>);
