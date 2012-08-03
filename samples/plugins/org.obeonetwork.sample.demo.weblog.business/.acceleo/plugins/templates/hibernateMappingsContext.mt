<%
metamodel http://www.obeonetwork.org/dsl/entity/2.0.0

import org.obeonetwork.dsl.environment.gen.java.common.common
import org.obeonetwork.dsl.entity.gen.java.common.common
import org.obeonetwork.dsl.environment.gen.java.common.services.StringServices
%>

<%script type="entity.Root" name="hibernateMappingsContextRelativeFilePath"%>
/conf/spring/orm/hibernateMappingsContext.xml

<%script type="entity.Root" name="hibernateMappingsContextFullFilePath"%>
<%if (getProperty("linkage.strategy")=="spring"){%>
<%pathToMainResources%><%hibernateMappingsContextRelativeFilePath%>
<%}%>

<%script type="EObject" name="hibernateMappingResourcesBeanID"%>
hibernateMappingResources

<%script type="entity.Root" name="hibernateMappingsContext" file="<%hibernateMappingsContextFullFilePath%>"%>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd">
<beans>
	<bean id="<%hibernateMappingResourcesBeanID%>" class="org.springframework.beans.factory.config.ListFactoryBean">
	  <property name="sourceList">
	      <list>
	        <%for (eAllContents("Entity")[supertype.nSize()==0]){%>
				<value><%entityPackage.toPath()%>/<%name.toStandardNotation().toU1Case()%>.hbm.xml</value>
			<%}%>
				<!-- <%startUserCode%> for mapping ressources -->
				<!-- <%endUserCode%> for mapping ressources -->
	      </list>
	  </property>
	</bean>
</beans>


