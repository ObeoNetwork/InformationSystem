<%
metamodel http://www.obeonetwork.org/dsl/soa/2.0.0

import org.obeonetwork.dsl.soa.gen.common.common
import org.obeonetwork.dsl.soa.gen.common.structure
import org.obeonetwork.dsl.environment.gen.java.common.common
import org.obeonetwork.dsl.environment.gen.java.common.services.StringServices
%>

<%script type="System" name="fullFilePath"%>
<%pathToMainResources%>/conf/spring/layer-services.xml

<%script type="System" name="service" file="<%fullFilePath%>"%>
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns:aop="http://www.springframework.org/schema/aop"
        xmlns:tx="http://www.springframework.org/schema/tx"
        xmlns:jee="http://www.springframework.org/schema/jee"
        xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.0.xsd
           http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-2.0.xsd
           http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-2.0.xsd
           http://www.springframework.org/schema/jee http://www.springframework.org/schema/jee/spring-jee-2.0.xsd">

       <%for (ownedComponents.providedServices) {%>
        <bean id="<%self().serviceName.toL1Case()%>" class="<%self().serviceImplQualifiedName%>">        	
        	<%for (eContainer("Component").requiredServices){%>
			<property name="<%serviceName.toL1Case()%>" ref="<%serviceName.toL1Case()%>"/>
			<%}%>
            <%iocInject%>
			<!-- <%startUserCode%> of custom section-<%self().serviceName%> -->
			 
			<!-- <%endUserCode%> of custom section-<%self().serviceName%> -->
        </bean>
        
        <%}%>
</beans>

<%script type="Service" name="iocInject"%>
 

