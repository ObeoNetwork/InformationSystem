<%
metamodel http://www.obeonetwork.org/dsl/entity/2.0.0

import org.obeonetwork.dsl.environment.gen.java.common.services.StringServices
import org.obeonetwork.dsl.entity.gen.java.dao.api.dao-common

import org.obeonetwork.dsl.entity.gen.java.hibernate.dao-hibernate-common
import org.obeonetwork.dsl.environment.gen.java.common.common
import org.obeonetwork.dsl.entity.gen.java.common.common
%>

<%script type="entity.Root" name="fullFilePath"%>
<%pathToMainResources%>/hibernate.cfg.xml

<%script type="entity.Root" name="generate" file="<%fullFilePath%>"%>
<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-configuration
    PUBLIC "-//Hibernate/Hibernate Configuration DTD//EN"
    "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">

<hibernate-configuration>

    <session-factory>

        <!-- mapping files -->
        
<%for (eAllContents("Entity")){%><%if (!supertype){%>
        <mapping resource="<%entityPackage.toPath()%>/<%name.toStandardNotation().toU1Case()%>.hbm.xml"/>
<%}%><%}%>

		<!-- <%startUserCode%> of listeners -->
		<!-- <%endUserCode%> of listeners -->

    </session-factory>

	<!-- <%startUserCode%> of security parameters -->
	<!-- <%endUserCode%> of security parameters -->

</hibernate-configuration>


