<%
metamodel http://www.obeonetwork.org/dsl/entity/2.0.0

import org.obeonetwork.dsl.entity.gen.java.hibernate.hibernateEntityDAO-JUnit
import org.obeonetwork.dsl.entity.gen.java.hibernate.dao-hibernate-common
import org.obeonetwork.dsl.entity.gen.java.dao.api.dao-common
import org.obeonetwork.dsl.entity.gen.java.spring.spring-common
%>

<%--TODO put in common with spring-hibernateDAO-JUnit--%>
<%script type="Entity" name="baseTestClassPackage"%>
org.springframework.test

<%--TODO put in common with spring-hibernateDAO-JUnit--%>
<%script type="Entity" name="baseTestClass"%>
AbstractTransactionalSpringContextTests

<%--TODO put in common with spring-hibernateDAO-JUnit--%>
<%script type="Entity" name="importHibernateTransaction"%>
<%""%>

<%--TODO put in common with spring-hibernateDAO-JUnit--%>
<%script type="Entity" name="testFeatures" post="indentTab()"%>
protected final String[] getConfigLocations(){
    return new String[]{"<%testApplicationContextRelativePath%>"};
}
<%for (self + externalDAOs){%>

private <%daoInterfaceName%> <%DAOName%> = (<%daoInterfaceName%>)getApplicationContext().getBean("<%DAOBeanID%>");
<%}%>

<%--TODO put in common with spring-hibernateDAO-JUnit--%>
<%script type="Entity" name="setUp"%>
<%""%>

<%--TODO put in common with spring-hibernateDAO-JUnit--%>
<%script type="Entity" name="tearDown"%>
<%""%>

<%--TODO put in common with spring-hibernateDAO-JUnit--%>
<%script type="Entity" name="importHibernateUtil"%>
<%""%>

<%script type="Entity" name="importDAOFactory"%>
<%""%>

